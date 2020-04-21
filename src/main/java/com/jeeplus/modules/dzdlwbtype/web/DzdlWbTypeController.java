/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlwbtype.web;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.dzdlwbtype.entity.DzdlWbType;
import com.jeeplus.modules.dzdlwbtype.service.DzdlWbTypeService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 电子导览物标类型管理Controller
 * @author 刘泽敏
 * @version 2016-10-25
 */
@Controller
@RequestMapping(value = "${adminPath}/dzdlwbtype/dzdlWbType")
public class DzdlWbTypeController extends BaseController {

	@Autowired
	private DzdlWbTypeService dzdlWbTypeService;
	
	@ModelAttribute
	public DzdlWbType get(@RequestParam(required=false) String id) {
		DzdlWbType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dzdlWbTypeService.get(id);
		}
		if (entity == null){
			entity = new DzdlWbType();
		}
		return entity;
	}
	
	/**
	 * 电子导览物标类型管理列表页面
	 */
	@RequiresPermissions("dzdlwbtype:dzdlWbType:list")
	@RequestMapping(value = {"list", ""})
	public String list(DzdlWbType dzdlWbType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DzdlWbType> page = dzdlWbTypeService.findPage(new Page<DzdlWbType>(request, response), dzdlWbType); 
		model.addAttribute("page", page);
		return "modules/dzdlwbtype/dzdlWbTypeList";
	}

	/**
	 * 查看，增加，编辑电子导览物标类型管理表单页面
	 */
	@RequiresPermissions(value={"dzdlwbtype:dzdlWbType:view","dzdlwbtype:dzdlWbType:add","dzdlwbtype:dzdlWbType:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(DzdlWbType dzdlWbType, Model model) {
		model.addAttribute("dzdlWbType", dzdlWbType);
		return "modules/dzdlwbtype/dzdlWbTypeForm";
	}

	/**
	 * 保存电子导览物标类型管理
	 */
	@RequiresPermissions(value={"dzdlwbtype:dzdlWbType:add","dzdlwbtype:dzdlWbType:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(DzdlWbType dzdlWbType, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, dzdlWbType)){
			return form(dzdlWbType, model);
		}
		if(!dzdlWbType.getIsNewRecord()){//编辑表单保存
			DzdlWbType t = dzdlWbTypeService.get(dzdlWbType.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(dzdlWbType, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			dzdlWbTypeService.save(t);//保存
		}else{//新增表单保存
			dzdlWbTypeService.save(dzdlWbType);//保存
		}
		addMessage(redirectAttributes, "保存电子导览物标类型管理成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlwbtype/dzdlWbType/?repage";
	}
	
	/**
	 * 删除电子导览物标类型管理
	 */
	@RequiresPermissions("dzdlwbtype:dzdlWbType:del")
	@RequestMapping(value = "delete")
	public String delete(DzdlWbType dzdlWbType, RedirectAttributes redirectAttributes) {
		dzdlWbTypeService.delete(dzdlWbType);
		addMessage(redirectAttributes, "删除电子导览物标类型管理成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlwbtype/dzdlWbType/?repage";
	}
	
	/**
	 * 批量删除电子导览物标类型管理
	 */
	@RequiresPermissions("dzdlwbtype:dzdlWbType:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			dzdlWbTypeService.delete(dzdlWbTypeService.get(id));
		}
		addMessage(redirectAttributes, "删除电子导览物标类型管理成功");
		return "redirect:"+Global.getAdminPath()+"/dzdlwbtype/dzdlWbType/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("dzdlwbtype:dzdlWbType:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(DzdlWbType dzdlWbType, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电子导览物标类型管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<DzdlWbType> page = dzdlWbTypeService.findPage(new Page<DzdlWbType>(request, response, -1), dzdlWbType);
    		new ExportExcel("电子导览物标类型管理", DzdlWbType.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出电子导览物标类型管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlwbtype/dzdlWbType/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("dzdlwbtype:dzdlWbType:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<DzdlWbType> list = ei.getDataList(DzdlWbType.class);
			for (DzdlWbType dzdlWbType : list){
				try{
					dzdlWbTypeService.save(dzdlWbType);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条电子导览物标类型管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条电子导览物标类型管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入电子导览物标类型管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlwbtype/dzdlWbType/?repage";
    }
	
	/**
	 * 下载导入电子导览物标类型管理数据模板
	 */
	@RequiresPermissions("dzdlwbtype:dzdlWbType:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电子导览物标类型管理数据导入模板.xlsx";
    		List<DzdlWbType> list = Lists.newArrayList(); 
    		new ExportExcel("电子导览物标类型管理数据", DzdlWbType.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/dzdlwbtype/dzdlWbType/?repage";
    }
	
}