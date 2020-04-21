/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlviewspot.web;

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
import com.jeeplus.modules.dzdlviewspot.entity.DzdlViewSpot;
import com.jeeplus.modules.dzdlviewspot.service.DzdlViewSpotService;

/**
 * 电子导览景点Controller
 * @author 刘泽敏
 * @version 2016-10-27
 */
@Controller
@RequestMapping(value = "${adminPath}/dzdlviewspot/dzdlViewSpot")
public class DzdlViewSpotController extends BaseController {

	@Autowired
	private DzdlViewSpotService dzdlViewSpotService;
	
	@ModelAttribute
	public DzdlViewSpot get(@RequestParam(required=false) String id) {
		DzdlViewSpot entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dzdlViewSpotService.get(id);
		}
		if (entity == null){
			entity = new DzdlViewSpot();
		}
		return entity;
	}
	
	/**
	 * 电子导览景点列表页面
	 */
	@RequiresPermissions("dzdlviewspot:dzdlViewSpot:list")
	@RequestMapping(value = {"list", ""})
	public String list(DzdlViewSpot dzdlViewSpot, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DzdlViewSpot> page = dzdlViewSpotService.findPage(new Page<DzdlViewSpot>(request, response), dzdlViewSpot); 
		model.addAttribute("page", page);
		return "modules/dzdlviewspot/dzdlViewSpotList";
	}

	/**
	 * 查看，增加，编辑电子导览景点表单页面
	 */
	@RequiresPermissions(value={"dzdlviewspot:dzdlViewSpot:view","dzdlviewspot:dzdlViewSpot:add","dzdlviewspot:dzdlViewSpot:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(DzdlViewSpot dzdlViewSpot, Model model) {
		model.addAttribute("dzdlViewSpot", dzdlViewSpot);
		return "modules/dzdlviewspot/dzdlViewSpotForm";
	}

	/**
	 * 保存电子导览景点
	 */
	@RequiresPermissions(value={"dzdlviewspot:dzdlViewSpot:add","dzdlviewspot:dzdlViewSpot:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(DzdlViewSpot dzdlViewSpot, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, dzdlViewSpot)){
			return form(dzdlViewSpot, model);
		}
		if(!dzdlViewSpot.getIsNewRecord()){//编辑表单保存
			DzdlViewSpot t = dzdlViewSpotService.get(dzdlViewSpot.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(dzdlViewSpot, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			dzdlViewSpotService.save(t);//保存
		}else{//新增表单保存
			dzdlViewSpotService.save(dzdlViewSpot);//保存
		}
		addMessage(redirectAttributes, "保存电子导览景点成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlviewspot/dzdlViewSpot/?repage";
	}
	
	/**
	 * 删除电子导览景点
	 */
	@RequiresPermissions("dzdlviewspot:dzdlViewSpot:del")
	@RequestMapping(value = "delete")
	public String delete(DzdlViewSpot dzdlViewSpot, RedirectAttributes redirectAttributes) {
		dzdlViewSpotService.delete(dzdlViewSpot);
		addMessage(redirectAttributes, "删除电子导览景点成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlviewspot/dzdlViewSpot/?repage";
	}
	
	/**
	 * 批量删除电子导览景点
	 */
	@RequiresPermissions("dzdlviewspot:dzdlViewSpot:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			dzdlViewSpotService.delete(dzdlViewSpotService.get(id));
		}
		addMessage(redirectAttributes, "删除电子导览景点成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlviewspot/dzdlViewSpot/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("dzdlviewspot:dzdlViewSpot:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(DzdlViewSpot dzdlViewSpot, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电子导览景点"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<DzdlViewSpot> page = dzdlViewSpotService.findPage(new Page<DzdlViewSpot>(request, response, -1), dzdlViewSpot);
    		new ExportExcel("电子导览景点", DzdlViewSpot.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出电子导览景点记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlviewspot/dzdlViewSpot/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("dzdlviewspot:dzdlViewSpot:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<DzdlViewSpot> list = ei.getDataList(DzdlViewSpot.class);
			for (DzdlViewSpot dzdlViewSpot : list){
				try{
					dzdlViewSpotService.save(dzdlViewSpot);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条电子导览景点记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条电子导览景点记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入电子导览景点失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlviewspot/dzdlViewSpot/?repage";
    }
	
	/**
	 * 下载导入电子导览景点数据模板
	 */
	@RequiresPermissions("dzdlviewspot:dzdlViewSpot:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电子导览景点数据导入模板.xlsx";
    		List<DzdlViewSpot> list = Lists.newArrayList(); 
    		new ExportExcel("电子导览景点数据", DzdlViewSpot.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlviewspot/dzdlViewSpot/?repage";
    }
	
	
	

}