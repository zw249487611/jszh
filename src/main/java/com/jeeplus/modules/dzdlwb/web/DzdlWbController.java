/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlwb.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.dzdlwb.entity.DzdlWb;
import com.jeeplus.modules.dzdlwb.service.DzdlWbService;

/**
 * 物标管理Controller
 * @author 刘泽敏
 * @version 2016-10-26
 */
@Controller
@RequestMapping(value = "${adminPath}/dzdlwb/dzdlWb")
public class DzdlWbController extends BaseController {

	@Autowired
	private DzdlWbService dzdlWbService;
	
	@ModelAttribute
	public DzdlWb get(@RequestParam(required=false) String id) {
		DzdlWb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dzdlWbService.get(id);
		}
		if (entity == null){
			entity = new DzdlWb();
		}
		return entity;
	}
	
	/**
	 * 物标管理列表页面
	 */
	@RequiresPermissions("dzdlwb:dzdlWb:list")
	@RequestMapping(value = {"list", ""})
	public String list(DzdlWb dzdlWb, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DzdlWb> page = dzdlWbService.findPage(new Page<DzdlWb>(request, response), dzdlWb); 
		model.addAttribute("page", page);
		return "modules/dzdlwb/dzdlWbList";
	}

	/**
	 * 查看，增加，编辑物标管理表单页面
	 */
	@RequiresPermissions(value={"dzdlwb:dzdlWb:view","dzdlwb:dzdlWb:add","dzdlwb:dzdlWb:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(DzdlWb dzdlWb, Model model) {
		model.addAttribute("dzdlWb", dzdlWb);
		return "modules/dzdlwb/dzdlWbForm";
	}

	/**
	 * 保存物标管理
	 */
	@RequiresPermissions(value={"dzdlwb:dzdlWb:add","dzdlwb:dzdlWb:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(DzdlWb dzdlWb, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, dzdlWb)){
			return form(dzdlWb, model);
		}
		if(!dzdlWb.getIsNewRecord()){//编辑表单保存
			DzdlWb t = dzdlWbService.get(dzdlWb.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(dzdlWb, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			dzdlWbService.save(t);//保存
		}else{//新增表单保存
			dzdlWbService.save(dzdlWb);//保存
		}
		addMessage(redirectAttributes, "保存物标管理成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlwb/dzdlWb/?repage";
	}
	
	/**
	 * 删除物标管理
	 */
	@RequiresPermissions("dzdlwb:dzdlWb:del")
	@RequestMapping(value = "delete")
	public String delete(DzdlWb dzdlWb, RedirectAttributes redirectAttributes) {
		dzdlWbService.delete(dzdlWb);
		addMessage(redirectAttributes, "删除物标管理成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlwb/dzdlWb/?repage";
	}
	
	/**
	 * 批量删除物标管理
	 */
	@RequiresPermissions("dzdlwb:dzdlWb:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			dzdlWbService.delete(dzdlWbService.get(id));
		}
		addMessage(redirectAttributes, "删除物标管理成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlwb/dzdlWb/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("dzdlwb:dzdlWb:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(DzdlWb dzdlWb, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "物标管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<DzdlWb> page = dzdlWbService.findPage(new Page<DzdlWb>(request, response, -1), dzdlWb);
    		new ExportExcel("物标管理", DzdlWb.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出物标管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlwb/dzdlWb/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("dzdlwb:dzdlWb:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<DzdlWb> list = ei.getDataList(DzdlWb.class);
			for (DzdlWb dzdlWb : list){
				try{
					dzdlWbService.save(dzdlWb);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条物标管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条物标管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入物标管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlwb/dzdlWb/?repage";
    }
	
	/**
	 * 下载导入物标管理数据模板
	 */
	@RequiresPermissions("dzdlwb:dzdlWb:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "物标管理数据导入模板.xlsx";
    		List<DzdlWb> list = Lists.newArrayList(); 
    		new ExportExcel("物标管理数据", DzdlWb.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlwb/dzdlWb/?repage";
    }
	
	
	

}