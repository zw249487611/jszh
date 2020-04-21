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
import com.jeeplus.modules.bfll.entity.JiangsuAc01;
import com.jeeplus.modules.bfll.service.JiangsuAc01Service;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 贫困户基本信息Controller
 * @author hwm
 * @version 2017-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/bfll/jiangsuAc01")
public class JiangsuAc01Controller extends BaseController {

	@Autowired
	private JiangsuAc01Service jiangsuAc01Service;
	
	@Autowired
	private AreaService areaService;
	
	@ModelAttribute
	public JiangsuAc01 get(@RequestParam(required=false) String id) {
		JiangsuAc01 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jiangsuAc01Service.get(id);
		}
		if (entity == null){
			entity = new JiangsuAc01();
		}
		return entity;
	}
	
	/**
	 * 贫困户基本信息列表页面
	 */
	@RequiresPermissions("bfll:jiangsuAc01:list")
	@RequestMapping(value = {"list", ""})
	public String list(JiangsuAc01 jiangsuAc01, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JiangsuAc01> page = jiangsuAc01Service.findPage(new Page<JiangsuAc01>(request, response), jiangsuAc01); 
		model.addAttribute("page", page);
		return "modules/bfll/jiangsuAc01List";
	}
	
	@RequestMapping(value = "listWf")
	public String listWf(JiangsuAc01 jiangsuAc01, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotEmpty(jiangsuAc01.getCurrentAreaId()) && !jiangsuAc01.getCurrentAreaId().equals("0")){
			Area area = areaService.get(jiangsuAc01.getCurrentAreaId());
			switch(area.getType()){
			case "4":
				jiangsuAc01.setXq(area.getId());
				break;
			case "5":
				jiangsuAc01.setXz(area.getId());
				break;
			case "6":
				jiangsuAc01.setCj(area.getId());
				break;
			}
		} else if (StringUtils.isEmpty(jiangsuAc01.getCurrentAreaId())){
			String type = UserUtils.getUser().getOffice().getArea().getType();
			String areaCode = UserUtils.getUser().getOffice().getArea().getId();
			switch(type){
			case "4":
				jiangsuAc01.setXq(areaCode);
				break;
			case "5":
				jiangsuAc01.setXz(areaCode);
				break;
			case "6":
				jiangsuAc01.setCj(areaCode);
				break;
			}
		}
		Page<JiangsuAc01> page = jiangsuAc01Service.findListBywfh(new Page<JiangsuAc01>(request, response), jiangsuAc01); 
		model.addAttribute("page", page);
		model.addAttribute("jiangsuAc01", jiangsuAc01);
		return "modules/bfll/wfgzList";
	}
	
	/**
	 * 查看，增加，编辑危房改造页面
	 */
	@RequestMapping(value = "formWf")
	public String formWf(JiangsuAc01 jiangsuAc01, Model model) {
		String id= jiangsuAc01.getId();
		jiangsuAc01 = jiangsuAc01Service.getWf(id);
		String currentAreaId = jiangsuAc01.getCurrentAreaId();
		if(StringUtils.isEmpty(currentAreaId)){
			if(!StringUtils.isEmpty(jiangsuAc01.getCj())){
				jiangsuAc01.setCurrentAreaId(jiangsuAc01.getCj());
			}else if(StringUtils.isEmpty(jiangsuAc01.getXz())){
				jiangsuAc01.setCurrentAreaId(jiangsuAc01.getXz());
			}else if(StringUtils.isEmpty(jiangsuAc01.getXq())){
				jiangsuAc01.setCurrentAreaId(jiangsuAc01.getXq());
			}
		}
		model.addAttribute("jiangsuAc01", jiangsuAc01);
		return "modules/bfll/wfgzForm";
	}
	
	
	/**
	 * 保存危房改造备注信息
	 */
	@RequestMapping(value = "saveWf")
	public String saveWf(JiangsuAc01 jiangsuAc01, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, jiangsuAc01)){
			return form(jiangsuAc01, model);
		}
			JiangsuAc01 t = jiangsuAc01Service.getWf(jiangsuAc01.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(jiangsuAc01, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			jiangsuAc01Service.updateWf(t);//保存
		
		addMessage(redirectAttributes, "保存危房全改造信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/listWf?repage";
	}
	
	
	@RequestMapping(value = "listYs")
	public String listYs(JiangsuAc01 jiangsuAc01, HttpServletRequest request, HttpServletResponse response, Model model) {
		/*if(StringUtils.isNotEmpty(jiangsuAc01.getCurrentAreaId()) && !jiangsuAc01.getCurrentAreaId().equals("0")){
			Area area = areaService.get(jiangsuAc01.getCurrentAreaId());
			switch(area.getType()){
			case "4":
				jiangsuAc01.setXq(area.getId());
				break;
			case "5":
				jiangsuAc01.setXz(area.getId());
				break;
			case "6":
				jiangsuAc01.setCj(area.getId());
				break;
			}
		} else if (StringUtils.isEmpty(jiangsuAc01.getCurrentAreaId())){
			String type = UserUtils.getUser().getOffice().getArea().getType();
			String areaCode = UserUtils.getUser().getOffice().getArea().getId();
			switch(type){
			case "4":
				jiangsuAc01.setXq(areaCode);
				break;
			case "5":
				jiangsuAc01.setXz(areaCode);
				break;
			case "6":
				jiangsuAc01.setCj(areaCode);
				break;
			}
		}
		Page<JiangsuAc01> page = jiangsuAc01Service.findListByyswfh(new Page<JiangsuAc01>(request, response), jiangsuAc01); 
		model.addAttribute("page", page);
		model.addAttribute("jiangsuAc01", jiangsuAc01);*/
		return "modules/bfll/appYsList";
	}

	@RequestMapping(value = "listYsWf")
	public String listYsWf(JiangsuAc01 jiangsuAc01, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotEmpty(jiangsuAc01.getCurrentAreaId()) && !jiangsuAc01.getCurrentAreaId().equals("0")){
			Area area = areaService.get(jiangsuAc01.getCurrentAreaId());
			switch(area.getType()){
			case "4":
				jiangsuAc01.setXq(area.getId());
				break;
			case "5":
				jiangsuAc01.setXz(area.getId());
				break;
			case "6":
				jiangsuAc01.setCj(area.getId());
				break;
			}
		} else if (StringUtils.isEmpty(jiangsuAc01.getCurrentAreaId())){
			String type = UserUtils.getUser().getOffice().getArea().getType();
			String areaCode = UserUtils.getUser().getOffice().getArea().getId();
			switch(type){
			case "4":
				jiangsuAc01.setXq(areaCode);
				break;
			case "5":
				jiangsuAc01.setXz(areaCode);
				break;
			case "6":
				jiangsuAc01.setCj(areaCode);
				break;
			}
		}
		Page<JiangsuAc01> page = jiangsuAc01Service.findListByyswfh(new Page<JiangsuAc01>(request, response), jiangsuAc01); 
		model.addAttribute("page", page);
		model.addAttribute("jiangsuAc01", jiangsuAc01);
		return "modules/bfll/appYswfList";
	}
	
	/**
	 * 查看，增加，编辑贫困户基本信息表单页面
	 */
	@RequiresPermissions(value={"bfll:jiangsuAc01:view","bfll:jiangsuAc01:add","bfll:jiangsuAc01:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(JiangsuAc01 jiangsuAc01, Model model) {
		model.addAttribute("jiangsuAc01", jiangsuAc01);
		return "modules/bfll/jiangsuAc01Form";
	}

	/**
	 * 保存贫困户基本信息
	 */
	@RequiresPermissions(value={"bfll:jiangsuAc01:add","bfll:jiangsuAc01:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(JiangsuAc01 jiangsuAc01, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, jiangsuAc01)){
			return form(jiangsuAc01, model);
		}
		if(!jiangsuAc01.getIsNewRecord()){//编辑表单保存
			JiangsuAc01 t = jiangsuAc01Service.get(jiangsuAc01.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(jiangsuAc01, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			jiangsuAc01Service.save(t);//保存
		}else{//新增表单保存
			jiangsuAc01Service.save(jiangsuAc01);//保存
		}
		addMessage(redirectAttributes, "保存贫困户基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/?repage";
	}
	
	/**
	 * 删除贫困户基本信息
	 */
	@RequiresPermissions("bfll:jiangsuAc01:del")
	@RequestMapping(value = "delete")
	public String delete(JiangsuAc01 jiangsuAc01, RedirectAttributes redirectAttributes) {
		jiangsuAc01Service.delete(jiangsuAc01);
		addMessage(redirectAttributes, "删除贫困户基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/?repage";
	}
	
	/**
	 * 批量删除贫困户基本信息
	 */
	@RequiresPermissions("bfll:jiangsuAc01:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			jiangsuAc01Service.delete(jiangsuAc01Service.get(id));
		}
		addMessage(redirectAttributes, "删除贫困户基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("bfll:jiangsuAc01:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(JiangsuAc01 jiangsuAc01, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "贫困户基本信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<JiangsuAc01> page = jiangsuAc01Service.findPage(new Page<JiangsuAc01>(request, response, -1), jiangsuAc01);
    		new ExportExcel("贫困户基本信息", JiangsuAc01.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出贫困户基本信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("bfll:jiangsuAc01:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<JiangsuAc01> list = ei.getDataList(JiangsuAc01.class);
			for (JiangsuAc01 jiangsuAc01 : list){
				try{
					jiangsuAc01Service.save(jiangsuAc01);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条贫困户基本信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条贫困户基本信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入贫困户基本信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/?repage";
    }
	
	/**
	 * 下载导入贫困户基本信息数据模板
	 */
	@RequiresPermissions("bfll:jiangsuAc01:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "贫困户基本信息数据导入模板.xlsx";
    		List<JiangsuAc01> list = Lists.newArrayList(); 
    		new ExportExcel("贫困户基本信息数据", JiangsuAc01.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/jiangsuAc01/?repage";
    }
	
}