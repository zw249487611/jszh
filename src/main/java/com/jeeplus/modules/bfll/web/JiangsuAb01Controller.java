/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.web;

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
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.bfll.entity.JiangsuAb01;
import com.jeeplus.modules.bfll.service.JiangsuAb01Service;
import com.jeeplus.modules.sys.service.AreaService;

/**
 * 贫困人口基本信息Controller
 * @author tangtq
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/bfll/jiangsuAb01")
public class JiangsuAb01Controller extends BaseController {

	@Autowired
	private JiangsuAb01Service jiangsuAb01Service;
	
	@Autowired
	private AreaService areaService;
	
	@ModelAttribute
	public JiangsuAb01 get(@RequestParam(required=false) String id) {
		JiangsuAb01 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jiangsuAb01Service.get(id);
		}
		if (entity == null){
			entity = new JiangsuAb01();
		}
		return entity;
	}
	
	/**
	 * 贫困人口基本信息列表页面
	 */
	@RequiresPermissions("bfll:jiangsuAb01:list")
	@RequestMapping(value = {"list", ""})
	public String list(JiangsuAb01 jiangsuAb01, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JiangsuAb01> page = jiangsuAb01Service.findPage(new Page<JiangsuAb01>(request, response), jiangsuAb01); 
		model.addAttribute("page", page);
		return "modules/bfll/jiangsuAb01List";
	}

	/**
	 * 查看，增加，编辑贫困人口基本信息表单页面
	 */
	@RequiresPermissions(value={"bfll:jiangsuAb01:view","bfll:jiangsuAb01:add","bfll:jiangsuAb01:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(JiangsuAb01 jiangsuAb01, Model model) {
		model.addAttribute("jiangsuAb01", jiangsuAb01);
		return "modules/bfll/jiangsuAb01Form";
	}

	/**
	 * 保存贫困人口基本信息
	 */
	@RequiresPermissions(value={"bfll:jiangsuAb01:add","bfll:jiangsuAb01:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(JiangsuAb01 jiangsuAb01, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, jiangsuAb01)){
			return form(jiangsuAb01, model);
		}
		if(!jiangsuAb01.getIsNewRecord()){//编辑表单保存
			JiangsuAb01 t = jiangsuAb01Service.get(jiangsuAb01.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(jiangsuAb01, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			jiangsuAb01Service.save(t);//保存
		}else{//新增表单保存
			jiangsuAb01Service.save(jiangsuAb01);//保存
		}
		addMessage(redirectAttributes, "保存贫困人口基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAb01/?repage";
	}
	
	/**
	 * 删除贫困人口基本信息
	 */
	@RequiresPermissions("bfll:jiangsuAb01:del")
	@RequestMapping(value = "delete")
	public String delete(JiangsuAb01 jiangsuAb01, RedirectAttributes redirectAttributes) {
		jiangsuAb01Service.delete(jiangsuAb01);
		addMessage(redirectAttributes, "删除贫困人口基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAb01/?repage";
	}
	
	/**
	 * 批量删除贫困人口基本信息
	 */
	@RequiresPermissions("bfll:jiangsuAb01:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			jiangsuAb01Service.delete(jiangsuAb01Service.get(id));
		}
		addMessage(redirectAttributes, "删除贫困人口基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAb01/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("bfll:jiangsuAb01:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(JiangsuAb01 jiangsuAb01, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "贫困人口基本信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<JiangsuAb01> page = jiangsuAb01Service.findPage(new Page<JiangsuAb01>(request, response, -1), jiangsuAb01);
    		new ExportExcel("贫困人口基本信息", JiangsuAb01.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出贫困人口基本信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAb01/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("bfll:jiangsuAb01:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<JiangsuAb01> list = ei.getDataList(JiangsuAb01.class);
			for (JiangsuAb01 jiangsuAb01 : list){
				try{
					jiangsuAb01Service.save(jiangsuAb01);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条贫困人口基本信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条贫困人口基本信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入贫困人口基本信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAb01/?repage";
    }
	
	/**
	 * 下载导入贫困人口基本信息数据模板
	 */
	@RequiresPermissions("bfll:jiangsuAb01:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "贫困人口基本信息数据导入模板.xlsx";
    		List<JiangsuAb01> list = Lists.newArrayList(); 
    		new ExportExcel("贫困人口基本信息数据", JiangsuAb01.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAb01/?repage";
    }
	
}