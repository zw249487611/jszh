/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.web;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import com.jeeplus.common.config.Global;
import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.Encodes;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.bfll.entity.JiangsuAb01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01E;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01;
import com.jeeplus.modules.bfll.service.NewJiangsuAb01Service;
import com.jeeplus.modules.bfll.service.NewJiangsuAc01Service;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 贫困人口基本信息Controller
 * @author hwm
 * @version 2017-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/bfll/newJiangsuAb01")
public class NewJiangsuAb01Controller extends BaseController {

	@Autowired
	private NewJiangsuAb01Service jiangsuAb01Service;
	
	@Autowired
	private NewJiangsuAc01Service jiangsuAc01Service;
	
	@Autowired
	private AreaService areaService;
	
	@ModelAttribute
	public NewJiangsuAb01 get(@RequestParam(required=false) String id) {
		NewJiangsuAb01 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jiangsuAb01Service.get(id);
		}
		if (entity == null){
			entity = new NewJiangsuAb01();
		}
		return entity;
	}
	
	/**
	 * 贫困人口基本信息列表页面
	 */
	@RequiresPermissions("bfll:newJiangsuAb01:list")
	@RequestMapping(value = {"list", ""})
	public String list(NewJiangsuAb01 jiangsuAb01, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NewJiangsuAb01> page = jiangsuAb01Service.findPage(new Page<NewJiangsuAb01>(request, response), jiangsuAb01); 
		model.addAttribute("page", page);
		return "modules/bfll/jiangsuAb01List";
	}

	/**
	 * 查看，增加，编辑贫困人口基本信息表单页面
	 */
	@RequiresPermissions(value={"bfll:newJiangsuAb01:view","bfll:newJiangsuAb01:add","bfll:newJiangsuAb01:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(NewJiangsuAb01 jiangsuAb01, Model model) {
		model.addAttribute("jiangsuAb01", jiangsuAb01);
		return "modules/bfll/jiangsuAb01Form";
	}

	/**
	 * 验证人口的证件号号是否重复
	 */
	@RequestMapping(value="checkNumber")
	@ResponseBody
	public AjaxJson checkNumber(String numbers, String[] oldNumbers,String nd){
		
		String[] nArray = numbers.split(",");
		if((!"".equals(numbers))&&(oldNumbers!=null)){
			for(int i=0;i<nArray.length;i++){
				if((!"".equals(oldNumbers[i])) && (oldNumbers[i].equals(nArray[i]))){ //没改
					
				}else if("".equals(oldNumbers[i])){ //新增
					NewJiangsuAb01 ab01=new NewJiangsuAb01();
					ab01.setAab004(nArray[i]);
					ab01.setAar040(Long.valueOf(nd));
					List<NewJiangsuAb01> jiangsuAb01s=jiangsuAb01Service.findList(ab01);
					if(jiangsuAb01s.size()>0){
						AjaxJson ajax=new AjaxJson();
						ajax.setSuccess(true);
						ajax.setErrorCode("1");
						ajax.setMsg("成功");
						LinkedHashMap map=new LinkedHashMap();
						map.put("number", nArray[i]);
						ajax.setBody(map);
						return ajax;
					}
				}else if((!"".equals(oldNumbers[i])) && (!oldNumbers[i].equals(nArray[i]))){ //修改了
					//判断是否存在
					NewJiangsuAb01 ab01=new NewJiangsuAb01();
					ab01.setAab004(nArray[i]);
					ab01.setAar040(Long.valueOf(nd));
					List<NewJiangsuAb01> jiangsuAb01s=jiangsuAb01Service.findList(ab01);
					if(jiangsuAb01s.size()>0){
						AjaxJson ajax=new AjaxJson();
						ajax.setSuccess(true);
						ajax.setErrorCode("1");
						ajax.setMsg("成功");
						LinkedHashMap map=new LinkedHashMap();
						map.put("number", nArray[i]);
						ajax.setBody(map);
						return ajax;
					}
				}
			}
		}else if((!"".equals(numbers))&&(oldNumbers==null)){
			for(int i=0;i<nArray.length;i++){
				NewJiangsuAb01 ab01=new NewJiangsuAb01();
				ab01.setAab004(nArray[i]);
				ab01.setAar040(Long.valueOf(nd));
				List<NewJiangsuAb01> jiangsuAb01s=jiangsuAb01Service.findList(ab01);
				if(jiangsuAb01s.size()>0){
					AjaxJson ajax=new AjaxJson();
					ajax.setSuccess(true);
					ajax.setErrorCode("1");
					ajax.setMsg("成功");
					LinkedHashMap map=new LinkedHashMap();
					map.put("number", nArray[i]);
					ajax.setBody(map);
					return ajax;
				}
			}
		}
		
		AjaxJson ajax=new AjaxJson();
		ajax.setSuccess(true);
		ajax.setErrorCode("1");
		ajax.setMsg("成功");
		LinkedHashMap map=new LinkedHashMap();
		map.put("number", "");
		ajax.setBody(map);
		return ajax;
	}
	
	
	/**
	 * 保存贫困人口基本信息
	 */
	@RequiresPermissions(value={"bfll:newJiangsuAb01:add","bfll:newJiangsuAb01:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(NewJiangsuAb01 jiangsuAb01, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, jiangsuAb01)){
			return form(jiangsuAb01, model);
		}
		if(!jiangsuAb01.getIsNewRecord()){//编辑表单保存
			NewJiangsuAb01 t = jiangsuAb01Service.get(jiangsuAb01.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(jiangsuAb01, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			jiangsuAb01Service.save(t);//保存
		}else{//新增表单保存
			jiangsuAb01Service.save(jiangsuAb01);//保存
		}
		addMessage(redirectAttributes, "保存贫困人口基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAb01/?repage";
	}
	
	/**
	 * 删除贫困人口基本信息
	 */
	@RequiresPermissions("bfll:newJiangsuAb01:del")
	@RequestMapping(value = "delete")
	public String delete(NewJiangsuAb01 jiangsuAb01, RedirectAttributes redirectAttributes) {
		jiangsuAb01Service.delete(jiangsuAb01);
		addMessage(redirectAttributes, "删除贫困人口基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAb01/?repage";
	}
	
	/**
	 * 批量删除贫困人口基本信息
	 */
	@RequiresPermissions("bfll:newJiangsuAb01:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			jiangsuAb01Service.delete(jiangsuAb01Service.get(id));
		}
		addMessage(redirectAttributes, "删除贫困人口基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAb01/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("bfll:newJiangsuAb01:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(NewJiangsuAb01 jiangsuAb01, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "贫困人口基本信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<NewJiangsuAb01> page = jiangsuAb01Service.findPage(new Page<NewJiangsuAb01>(request, response, -1), jiangsuAb01);
    		new ExportExcel("贫困人口基本信息", JiangsuAb01.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出贫困人口基本信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAb01/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("bfll:newJiangsuAb01:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			int count = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<NewJiangsuAb01> list = ei.getDataList(NewJiangsuAb01.class);
			for (NewJiangsuAb01 jiangsuAb01 : list){
				count++;
				try{
					if (StringUtils.isNotBlank(jiangsuAb01.getHzsfzh()) && StringUtils.isNotBlank(jiangsuAb01.getAab004()) && jiangsuAb01.getAar040() != null) {
						List<Area> xqAreaList = areaService.findListByProperty("name", jiangsuAb01.getAab032());
						if (CollectionUtils.isNotEmpty(xqAreaList)) {
							jiangsuAb01.setAab032(xqAreaList.get(0).getCode());
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录的【县区】与行政区划表不一致<br/>", count));
							continue;
						}
						List<Area> xzAreaList = areaService.findListByProperty("name", jiangsuAb01.getAab033());
						if (CollectionUtils.isNotEmpty(xzAreaList)) {
							jiangsuAb01.setAab033(xzAreaList.get(0).getCode());
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录的【乡镇】与行政区划表不一致<br/>", count));
							continue;
						}
						List<Area> cjAreaList = areaService.findListByProperty("name", jiangsuAb01.getAab034());
						if (CollectionUtils.isNotEmpty(cjAreaList)) {
							jiangsuAb01.setAab034(cjAreaList.get(0).getCode());
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录的【村居】与行政区划表不一致<br/>", count));
							continue;
						}
						
						// 根据户主身份证号查询对应的户信息
						NewJiangsuAc01 conditionAc01 = new NewJiangsuAc01();
						conditionAc01.setAar040(jiangsuAb01.getAar040());
						conditionAc01.setHzsfzh(jiangsuAb01.getHzsfzh());
						conditionAc01.setDelFlag("0");
						List<NewJiangsuAc01> ac01List = jiangsuAc01Service.findList(conditionAc01);
						if (CollectionUtils.isNotEmpty(ac01List)) {// 户主对应的贫困户存在
							NewJiangsuAb01 conditionAb01 = new NewJiangsuAb01();
							conditionAb01.setAab004(jiangsuAb01.getAab004());
							conditionAb01.setAar040(jiangsuAb01.getAar040());
							conditionAb01.setDelFlag("0");
							List<NewJiangsuAb01> ab01List = jiangsuAb01Service.findList(conditionAb01);
							if (CollectionUtils.isNotEmpty(ab01List)) {
								jiangsuAb01.setId(ab01List.get(0).getId());
							}
							jiangsuAb01.setAcid(ac01List.get(0).getId());
							jiangsuAb01Service.save(jiangsuAb01);
							successNum++;
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录户主对应的贫困户记录不存在<br/>", count));
						}
					} else {
						failureNum++;
						failureMsg.append(String.format("第%d条记录的【证件号码】或者【分区年度】或者【户主身份证号】为空<br/>", count));
					}
				}catch(ConstraintViolationException ex){
					failureNum++;
					failureMsg.append(String.format("第%d条记录导入报错，错误信息：%s<br/>", count, ex.getMessage()));
				}catch (Exception ex) {
					failureNum++;
					failureMsg.append(String.format("第%d条记录导入报错，错误信息：%s<br/>", count, ex.getMessage()));
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条贫困人口基本信息记录。<br/>请确保：<br/>1. 贫困人口对应的贫困户信息已经导入系统；<br/>2. 县区、乡镇、村居的名称与行政区划表中的一致；<br/>3. 户主身份证号不为空；<br/>4. 家庭成员证件号码不为空；<br/>5. 分区年度不为空；<br/>6. 相关列的编码值与模板中列举的一致。<br/>");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条贫困人口基本信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入贫困人口基本信息失败！失败信息："+e.getMessage() + "。<br/>请严格按照模板格式填写，不要改动模板格式。");
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
    }
	
	/**
	 * 下载导入贫困人口基本信息数据模板
	 */
	@RequiresPermissions("bfll:newJiangsuAb01:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			URL url = getClass().getClassLoader().getResource("templates/贫困人口基本信息数据导入模板.xlsx");
			File file = new File(url.getFile());
			Workbook wb = WorkbookFactory.create(file);
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+ Encodes.urlEncode(file.getName()));
			wb.write(response.getOutputStream());
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAb01/?repage";
    }
	
	
	/**
	 * 导出excel文件贫困户信息
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:export")
	@RequestMapping(value = "export1",method={RequestMethod.POST,RequestMethod.GET})
    public String export1(NewJiangsuAb01E newjiangsuAb01, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			if(StringUtils.isNotEmpty(newjiangsuAb01.getCurrentAreaId()) && !newjiangsuAb01.getCurrentAreaId().equals("0")){
				Area area = areaService.get(newjiangsuAb01.getCurrentAreaId());
				switch(area.getType()){
				case "4":
					newjiangsuAb01.setXq(area.getId());
					break;
				case "5":
					newjiangsuAb01.setXz(area.getId());
					break;
				case "6":
					newjiangsuAb01.setCj(area.getId());
					break;
				}
			}else if(StringUtils.isEmpty(newjiangsuAb01.getCurrentAreaId())){
				String type = UserUtils.getUser().getOffice().getArea().getType();
				String areaCode = UserUtils.getUser().getOffice().getArea().getId();
				switch(type){
				case "4":
					newjiangsuAb01.setXq(areaCode);
					break;
				case "5":
					newjiangsuAb01.setXz(areaCode);
					break;
				case "6":
					newjiangsuAb01.setCj(areaCode);
					break;
				}
			}
            String fileName = "贫困人口基本信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<NewJiangsuAb01E> page = jiangsuAb01Service.findPage1(new Page<NewJiangsuAb01E>(request, response, -1), newjiangsuAb01);
    		new ExportExcel("贫困人口基本信息", NewJiangsuAb01E.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出贫困人口基本信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
    }

}