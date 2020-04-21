/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.web;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.Encodes;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01E;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc07;
import com.jeeplus.modules.bfll.service.NewJiangsuAb01Service;
import com.jeeplus.modules.bfll.service.NewJiangsuAc01Service;
import com.jeeplus.modules.bfll.service.NewJiangsuAc07Service;
import com.jeeplus.modules.bfll.service.TJdlkhXxbgService;
import com.jeeplus.modules.project.entity.Const;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 贫困户基本信息Controller
 * @author hwm
 * @version 2017-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/bfll/newJiangsuAc01")
public class NewJiangsuAc01Controller extends BaseController {

	@Autowired
	private NewJiangsuAc01Service jiangsuAc01Service;
	@Autowired
	private NewJiangsuAb01Service jiangsuAb01Service;
	@Autowired
	private AreaService areaService;
	@Autowired
	private NewJiangsuAc07Service jiangsuAc07Service;
	@Autowired
	private TJdlkhXxbgService tJdlkhXxbgService;
	@ModelAttribute
	public NewJiangsuAc01 get(@RequestParam(required=false) String id) {
		NewJiangsuAc01 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jiangsuAc01Service.get(id);
		}
		if (entity == null){
			entity = new NewJiangsuAc01();
		}
		return entity;
	}
	
	/**
	 * 贫困户基本信息列表页面
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:list")
	@RequestMapping(value = {"list", ""})
	public String list(NewJiangsuAc01 jiangsuAc01, HttpServletRequest request, HttpServletResponse response, Model model) {
		if (jiangsuAc01.getAar040()==null || "".equals(jiangsuAc01.getAar040())) {
			long i= Long.parseLong(DateUtils.getYear());
			jiangsuAc01.setAar040(i-1);
		}
		if(jiangsuAc01.getDelFlag() == null || "".equals(jiangsuAc01.getDelFlag())){
			jiangsuAc01.setDelFlag("0");
		}
		
		String currentAreaId = jiangsuAc01.getCurrentAreaId();
		if(StringUtils.isEmpty(currentAreaId)){
			User user = UserUtils.getUser();
			String areaId = user.getOffice().getArea().getId();
			Area area = areaService.get(areaId);
			if("4".equals(area.getType())){
				jiangsuAc01.setAar004(area.getId());
			}else if("5".equals(area.getType())){
				jiangsuAc01.setAar005(area.getId());
			}else if("6".equals(area.getType())){
				jiangsuAc01.setAar006(area.getId());
			}
		}else{
			Area area = areaService.get(currentAreaId);
			if("4".equals(area.getType())){
				jiangsuAc01.setAar004(area.getId());
			}else if("5".equals(area.getType())){
				jiangsuAc01.setAar005(area.getId());
			}else if("6".equals(area.getType())){
				jiangsuAc01.setAar006(area.getId());
			}
		}
		
		model.addAttribute("peoplecount", jiangsuAc01Service.gettotalCount(jiangsuAc01));
		Page<NewJiangsuAc01> page = jiangsuAc01Service.findPage1(new Page<NewJiangsuAc01>(request, response), jiangsuAc01);
		model.addAttribute("page", page);
		model.addAttribute("yearMap", getYears().descendingMap());
		model.addAttribute("jiangsuAc01", jiangsuAc01);
		return "modules/bfll/jiangsuAc01List";
	}
	/**
	 * 得到2016年到去年年度
	 */
	public  TreeMap<Integer,String> getYears(){
		TreeMap<Integer,String> yearMap = new TreeMap<Integer,String>();
		int year = Integer.parseInt(DateUtils.getYear());
		--year;
		for(int i = year; i > 2015 ; i--){
			yearMap.put(i, i+"年");
		}
		return yearMap;
	}
/*
	/**
	 * 查看，增加，编辑贫困户基本信息表单页面
	 */
	@RequiresPermissions(value={"bfll:newJiangsuAc01:view","bfll:newJiangsuAc01:add","bfll:newJiangsuAc01:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(NewJiangsuAc01 jiangsuAc01,String isHiden, Model model) {
		if (jiangsuAc01.getIsNewRecord()==false){
			if((!"".equals(jiangsuAc01.getId()))){
				model.addAttribute("isHiden", isHiden);
				List<NewJiangsuAb01> newJiangsuAb01s=jiangsuAb01Service.findByAcid(jiangsuAc01.getId());
				if(newJiangsuAb01s!=null){
					model.addAttribute("newJiangsuAb01s", newJiangsuAb01s);
				}
				NewJiangsuAc07 newJiangsuAc07=jiangsuAc07Service.findByAcidAndNd(jiangsuAc01.getId(),String.valueOf(jiangsuAc01.getAar040()+1));
				if(newJiangsuAc07!=null){
					model.addAttribute("newJiangsuAc07", newJiangsuAc07);
				}
			}
			String currentAreaId = jiangsuAc01.getCurrentAreaId();
			if(StringUtils.isEmpty(currentAreaId)){
				if(!StringUtils.isEmpty(jiangsuAc01.getAar006())){
					jiangsuAc01.setCurrentAreaId(jiangsuAc01.getAar006());
				}else if(!StringUtils.isEmpty(jiangsuAc01.getAar005())){
					jiangsuAc01.setCurrentAreaId(jiangsuAc01.getAar005());
				}else if(!StringUtils.isEmpty(jiangsuAc01.getAar004())){
					jiangsuAc01.setCurrentAreaId(jiangsuAc01.getAar004());
				}
			}
			if(!StringUtils.isEmpty(jiangsuAc01.getAac008())){
				String[] qtzpyy= jiangsuAc01.getAac008().split(",");
				jiangsuAc01.setQtzpyy(qtzpyy);
			}
		}
		model.addAttribute("yearMap", getYears().descendingMap());
		model.addAttribute("jiangsuAc01", jiangsuAc01);
		return "modules/bfll/jiangsuAc01Form";
	}

	
	/**
	 * 保存贫困户基本信息
	 */
	@RequiresPermissions(value={"bfll:newJiangsuAc01:add","bfll:newJiangsuAc01:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(NewJiangsuAc01 jiangsuAc01, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, jiangsuAc01)){
			return form(jiangsuAc01,null, model);
		}
		if(!jiangsuAc01.getIsNewRecord()){//编辑表单保存
			NewJiangsuAc01 t = jiangsuAc01Service.get(jiangsuAc01.getId());//从数据库取出记录的值
			String[] qtzpyy = jiangsuAc01.getQtzpyy();
			String aac008 = "";
			if(qtzpyy != null){
				if(qtzpyy.length >= 1){
					aac008 = qtzpyy[0];
					for(int i=1;i<qtzpyy.length;i++){
						aac008 = aac008+","+qtzpyy[i];
					}
				}
			}
			jiangsuAc01.setAac008(aac008);
			MyBeanUtils.copyBeanNotNull2Bean(jiangsuAc01, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			jiangsuAc01Service.save(t);//保存
		}else{//新增表单保存
			jiangsuAc01Service.save(jiangsuAc01);//保存
		}
		addMessage(redirectAttributes, "保存贫困户基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
	}
	
	
	/**
	 * 删除贫困户基本信息
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:del")
	@RequestMapping(value = "delete")
	public String delete(NewJiangsuAc01 jiangsuAc01, RedirectAttributes redirectAttributes) {
			jiangsuAc01Service.delete(jiangsuAc01);
			List<NewJiangsuAb01> jiangsuAb01s = jiangsuAb01Service.findByAcid(jiangsuAc01.getId());
			for(NewJiangsuAb01 jab01:jiangsuAb01s){
				jiangsuAb01Service.delete(jab01);
			}
			jiangsuAc01.setBgyy("删除贫困户基本信息");
			tJdlkhXxbgService.saveTJdlkhXxbg(jiangsuAc01, jiangsuAc01.getId(), Const.JdLKHBGLX_6);
			addMessage(redirectAttributes, "删除贫困户基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
	}
	
	/**
	 * 批量删除贫困户基本信息
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		String messages= "";
		for(String id : idArray){
			NewJiangsuAc01  jiangsuAc01 = jiangsuAc01Service.get(id);
				jiangsuAc01Service.delete(jiangsuAc01);
				List<NewJiangsuAb01> jiangsuAb01s = jiangsuAb01Service.findByAcid(id);
				for(NewJiangsuAb01 jab01:jiangsuAb01s){
					jiangsuAb01Service.delete(jab01);
				}
				jiangsuAc01.setBgyy("删除贫困户基本信息");
				tJdlkhXxbgService.saveTJdlkhXxbg(jiangsuAc01, jiangsuAc01.getId(), Const.JdLKHBGLX_6);
			}
		if(messages.equals("")){
			addMessage(redirectAttributes, "删除贫困户基本信息成功");
		}else{
			addMessage(redirectAttributes, "以下贫困户不能删除，请先解除帮扶关系："+messages);
		}
		
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
	}
	
	/**
	 * 导出excel文件贫困户信息
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:export")
	@RequestMapping(value = "export",method={RequestMethod.POST,RequestMethod.GET})
    public String exportFile(NewJiangsuAc01E newjiangsuAc01, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			if(StringUtils.isNotEmpty(newjiangsuAc01.getCurrentAreaId()) && !newjiangsuAc01.getCurrentAreaId().equals("0")){
				Area area = areaService.get(newjiangsuAc01.getCurrentAreaId());
				switch(area.getType()){
				case "4":
					newjiangsuAc01.setAar004(area.getId());
					break;
				case "5":
					newjiangsuAc01.setAar005(area.getId());
					break;
				case "6":
					newjiangsuAc01.setAar006(area.getId());
					break;
				}
			}else if(StringUtils.isEmpty(newjiangsuAc01.getCurrentAreaId())){
				String type = UserUtils.getUser().getOffice().getArea().getType();
				String areaCode = UserUtils.getUser().getOffice().getArea().getId();
				switch(type){
				case "4":
					newjiangsuAc01.setAar004(areaCode);
					break;
				case "5":
					newjiangsuAc01.setAar005(areaCode);
					break;
				case "6":
					newjiangsuAc01.setAar006(areaCode);
					break;
				}
			}
            String fileName = "贫困户基本信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<NewJiangsuAc01E> page = jiangsuAc01Service.findPage2(new Page<NewJiangsuAc01E>(request, response, -1), newjiangsuAc01);
    		new ExportExcel("贫困户基本信息", NewJiangsuAc01E.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出贫困户基本信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
    }

	
	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("bfll:newJiangsuAc01:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			int count = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<NewJiangsuAc01> list = ei.getDataList(NewJiangsuAc01.class);
			for (NewJiangsuAc01 jiangsuAc01 : list){
				count++;
				try{
					if (StringUtils.isNotBlank(jiangsuAc01.getHzsfzh()) && jiangsuAc01.getAar040() != null) {
						List<Area> xqAreaList = areaService.findListByProperty("name", jiangsuAc01.getAar004());
						if (CollectionUtils.isNotEmpty(xqAreaList)) {
							jiangsuAc01.setAar004(xqAreaList.get(0).getCode());
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录的【县区】与行政区划表不一致<br/>", count));
							continue;
						}
						
						Area areaCondition = new Area();
						areaCondition.setParent(new Area(jiangsuAc01.getAar004()));
						areaCondition.setName(jiangsuAc01.getAar005());
						List<Area> xzAreaList = areaService.findList2(areaCondition);
						if (CollectionUtils.isNotEmpty(xzAreaList)) {
							jiangsuAc01.setAar005(xzAreaList.get(0).getCode());
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录的【乡镇】与行政区划表不一致<br/>", count));
							continue;
						}
						
						areaCondition = new Area();
						areaCondition.setParent(new Area(jiangsuAc01.getAar005()));
						areaCondition.setName(jiangsuAc01.getAar006());
						List<Area> cjAreaList = areaService.findList2(areaCondition);
						if (CollectionUtils.isNotEmpty(cjAreaList)) {
							jiangsuAc01.setAar006(cjAreaList.get(0).getCode());
						} else {
							failureNum++;
							failureMsg.append(String.format("第%d条记录的【村居】与行政区划表不一致<br/>", count));
							continue;
						}
						// 判断户主对应的户是否已存在
						NewJiangsuAc01 conditionAc01 = new NewJiangsuAc01();
						conditionAc01.setAar040(jiangsuAc01.getAar040());
						conditionAc01.setHzsfzh(jiangsuAc01.getHzsfzh());
						conditionAc01.setDelFlag("0");
						List<NewJiangsuAc01> ac01List = jiangsuAc01Service.findList(conditionAc01);
						if (CollectionUtils.isNotEmpty(ac01List)) {// 户主对应的贫困户已经存在，则更新成最新的记录
							jiangsuAc01.setId(ac01List.get(0).getId());
						}
						jiangsuAc01Service.save(jiangsuAc01);
						successNum++;
					} else {
						failureNum++;
						failureMsg.append(String.format("第%d条记录的【户主身份证号】或者【分区年度】为空<br/>", count));
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
				failureMsg.insert(0, "，失败 "+failureNum+" 条贫困户基本信息记录。<br/>请确保：<br/>1. 县区、乡镇、村居的名称与行政区划表中的一致；<br/>2. 户主身份证号不为空；<br/>3. 分区年度不为空；<br/>4. 相关列的编码值与模板中列举的一致。<br/>");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条贫困户基本信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入贫困户基本信息失败！失败信息："+e.getMessage() + "。<br/>请严格按照模板格式填写，不要改动模板格式。");
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
    }
	
	/**
	 * 下载导入贫困户基本信息数据模板
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
    		URL url = getClass().getClassLoader().getResource("templates/贫困户基本信息数据导入模板.xlsx");
			File file = new File(url.getFile());
			Workbook wb = WorkbookFactory.create(file);
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+ Encodes.urlEncode(file.getName()));
			wb.write(response.getOutputStream());
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
    }
	
	/**
	 * 恢复误删的贫困户数据
	 */
	@RequiresPermissions("bfll:newJiangsuAc01:return")
    @RequestMapping(value = "return")
	public String ret(NewJiangsuAc01 jiangsuAc01, RedirectAttributes redirectAttributes) {
			//List<JiangsuAc08> listAc08=jiangsuAc08Service.findAc08ByAcid(jiangsuAc01.getId());

			jiangsuAc01Service.delete(jiangsuAc01);
			List<NewJiangsuAb01> jiangsuAb01s = jiangsuAb01Service.findByAcid(jiangsuAc01.getId());
			for(NewJiangsuAb01 jab01:jiangsuAb01s){
				jiangsuAb01Service.delete(jab01);
			}
			jiangsuAc01Service.ret(jiangsuAc01.getId());
			jiangsuAc01.setBgyy("恢复误删的贫困户基本信息");
			tJdlkhXxbgService.saveTJdlkhXxbg(jiangsuAc01, jiangsuAc01.getId(), Const.JdLKHBGLX_12);
			addMessage(redirectAttributes, "恢复贫困户基本信息成功");
		
		return "redirect:"+Global.getAdminPath()+"/bfll/newJiangsuAc01/?repage";
	}
	

}