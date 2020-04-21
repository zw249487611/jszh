/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.jszh.web;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.jeeplus.modules.jszh.entity.Jszhinfo;
import com.jeeplus.modules.jszh.service.JszhinfoService;

/**
 * 江苏智淮员工身体状况Controller
 * @author zhangw
 * @version 2020-02-02
 */
@Controller
@RequestMapping(value = "${adminPath}/jszh/jszhinfo")
public class JszhinfoController extends BaseController {

	@Autowired
	private JszhinfoService jszhinfoService;
	
	@ModelAttribute
	public Jszhinfo get(@RequestParam(required=false) String id) {
		Jszhinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jszhinfoService.get(id);
		}
		if (entity == null){
			entity = new Jszhinfo();
		}
		return entity;
	}
	
	/**
	 * 问题线索移送列表页面
	 */
	@RequiresPermissions("jszh:jszhinfo:list")
	@RequestMapping(value = {"list", ""})
	public String list(Jszhinfo jszhinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Jszhinfo> page = jszhinfoService.findPage(new Page<Jszhinfo>(request, response), jszhinfo);
//		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
//		String dt = simpleDateFormat.format(jszhinfo.getDate());
		
		model.addAttribute("page", page);
		model.addAttribute("jszhinfo", jszhinfo);
		return "modules/jszh/jszhinfoList";
	}

	/**
	 * 查看，增加，编辑问题线索移送表单页面
	 */
	@RequiresPermissions(value={"jszh:jszhinfo:view","jszh:jszhinfo:add","jszh:jszhinfo:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Jszhinfo jszhinfo, Model model) {
		model.addAttribute("jszhinfo", jszhinfo);
		return "modules/jszh/jszhinfoForm";
	}

	/**
	 * 保存问题线索移送
	 */
	@RequiresPermissions(value={"jszh:jszhinfo:add","jszh:jszhinfo:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Jszhinfo jszhinfo, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, jszhinfo)){
			return form(jszhinfo, model);
		}
		SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!jszhinfo.getIsNewRecord()){//编辑表单保存
			Jszhinfo t = jszhinfoService.get(jszhinfo.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(jszhinfo, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			t.setDate(temp.format(new Date()));
//			System.out.println(new Date());
			jszhinfoService.save(t);//保存
		}else{//新增表单保存
			jszhinfo.setDate(temp.format(new Date()));
			jszhinfoService.save(jszhinfo);//保存
		}
		addMessage(redirectAttributes, "保存身体状况成功");
		return "redirect:"+Global.getAdminPath()+"/jszh/jszhinfo/?repage";
	}
	
	/**
	 * 删除问题线索移送
	 */
	@RequiresPermissions("jszh:jszhinfo:del")
	@RequestMapping(value = "delete")
	public String delete(Jszhinfo jszhinfo, RedirectAttributes redirectAttributes) {
		jszhinfoService.delete(jszhinfo);
		addMessage(redirectAttributes, "删除身体状况成功");
		return "redirect:"+Global.getAdminPath()+"/jszh/jszhinfo/?repage";
	}
	
	/**
	 * 批量删除问题线索移送
	 */
	@RequiresPermissions("jszh:jszhinfo:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			jszhinfoService.delete(jszhinfoService.get(id));
		}
		addMessage(redirectAttributes, "删除身体状况成功");
		return "redirect:"+Global.getAdminPath()+"/jszh/jszhinfo/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("jszh:jszhinfo:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Jszhinfo jszhinfo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "身体状况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Jszhinfo> page = jszhinfoService.findPage(new Page<Jszhinfo>(request, response, -1), jszhinfo);
    		new ExportExcel("身体状况", Jszhinfo.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出身体状况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/jszh/jszhinfo/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("jszh:jszhinfo:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Jszhinfo> list = ei.getDataList(Jszhinfo.class);
			for (Jszhinfo jszhinfo : list){
				try{
					jszhinfoService.save(jszhinfo);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条身体状况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条身体状况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入身体状况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/jszh/jszhinfo/?repage";
    }
	
	/**
	 * 下载导入问题线索移送数据模板
	 */
	@RequiresPermissions("jszh:jszhinfo:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "身体状况数据导入模板.xlsx";
    		List<Jszhinfo> list = Lists.newArrayList(); 
    		new ExportExcel("身体状况数据", Jszhinfo.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/jszh/jszhinfo/?repage";
    }
	
	
	

}