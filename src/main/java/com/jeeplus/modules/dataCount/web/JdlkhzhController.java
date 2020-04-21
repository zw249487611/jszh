/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.web;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.dataCount.entity.Jdlkhzh;
import com.jeeplus.modules.dataCount.service.JdlkhzhService;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 贫困户信息综合查询Controller
 * @author 陆凯凯
 * @version 2017-08-30
 */
@Controller
@RequestMapping(value = "${adminPath}/datacount/jdlkhzh")
public class JdlkhzhController extends BaseController {

	@Autowired
	private JdlkhzhService jdlkhzhService;
	@Autowired
	private AreaService areaService;
	
	
	@ModelAttribute
	public Jdlkhzh get(@RequestParam(required=false) String id) {
		Jdlkhzh entity = null;
		/*if (StringUtils.isNotBlank(id)){
			entity = jdlkhzhService.get(id);
		}*/
		if (entity == null){
			entity = new Jdlkhzh();
		}
		return entity;
	}
	
	/**
	 * 贫困户信息综合查询列表页面
	 */
	@RequestMapping(value = {"list", ""})
	public String list(Jdlkhzh jdlkhzh, HttpServletRequest request, HttpServletResponse response, Model model) {
		String type = UserUtils.getUser().getOffice().getArea().getType();
		System.out.println(type+"_____-----");
		if(StringUtils.isNotEmpty(jdlkhzh.getCurrentAreaId()) && !jdlkhzh.getCurrentAreaId().equals("0")){
			Area area = areaService.get(jdlkhzh.getCurrentAreaId());
			switch(area.getType()){
			case "4":
				jdlkhzh.setXq(area.getId());
				break;
			case "5":
				jdlkhzh.setXz(area.getId());
				break;
			case "6":
				jdlkhzh.setXc(area.getId());
				break;
			}
		}else if(jdlkhzh.getCurrentAreaId()==null ||(!type.equals("3")&& jdlkhzh.getCurrentAreaId().equals(""))){
			if(type.equals("3")){
				//默认选中金湖县
				if(StringUtils.isEmpty(jdlkhzh.getXm()) && StringUtils.isEmpty(jdlkhzh.getSfzh())&&StringUtils.isEmpty(jdlkhzh.getPkhsx())&& StringUtils.isEmpty(jdlkhzh.getZpyy())){
					jdlkhzh.setXq("320803000000");
					jdlkhzh.setCurrentAreaId("320803000000");
				}
			}else{
				String areaCode = UserUtils.getUser().getOffice().getArea().getId();
				switch(type){
				case "4":
					jdlkhzh.setXq(areaCode);
					break;
				case "5":
					jdlkhzh.setXz(areaCode);
					break;
				case "6":
					jdlkhzh.setXc(areaCode);
					break;
				}
			}
			
			
		}
		//个人资金跳转到建档立卡页面自带身份证号信息
		String sfzh= request.getParameter("sfzh");
		if(!StringUtils.isEmpty(sfzh)&StringUtils.isEmpty(jdlkhzh.getSfzh())){
			jdlkhzh.setSfzh(sfzh);
		}
		//若年度为空，默认未当前年度-1
		if(StringUtils.isEmpty(jdlkhzh.getNd())){
			String year = DateUtils.getYear();
			int nd = Integer.parseInt(year);
			jdlkhzh.setNd(String.valueOf(--nd));
		}
		String countStr = jdlkhzhService.gettotalCount(jdlkhzh);
		if(countStr != null){
			String[] countStrList = countStr.split(",");
			if(countStrList.length == 8){
				countStr="总计："+countStrList[0]+"户、"+countStrList[1]+"人"
						/*+"</br>未脱贫"+countStrList[2]+"人"
			+"</br>分类统计：正常"+countStrList[2]+"人、"+"死亡"+countStrList[3]+"人、"+"嫁出"+countStrList[4]+"人、"+"加入"+countStrList[5]+"人、"+"迁出"+countStrList[6]+"人、"+"删除"+countStrList[7]+"人"*/;
			}
		}
		
		model.addAttribute("peoplecount", countStr);
		
		Page<Jdlkhzh> page = jdlkhzhService.findPage(new Page<Jdlkhzh>(request, response), jdlkhzh);
		model.addAttribute("yearMap", getYears());
		model.addAttribute("page", page);
		return "modules/dataCount/jdlkhzhList";
	}
	/**
	 * 得到当前以及前五年的年份
	 */
	public  TreeMap<Integer,String> getYears(){
		TreeMap<Integer,String> yearMap = new TreeMap<Integer,String>();
		int year = Integer.parseInt(DateUtils.getYear());
		
		for(int i = year; i > 2015 ; i--){
			yearMap.put(i, i+"年");
		}
		return yearMap;
	}
	/**
	 * 获取贫困户家庭信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getJdlkhxx")
	@ResponseBody
	public String getJdlkhxx(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "sfzh", required = false) String sfzh,@RequestParam(value = "nd", required = false) String nd,HttpServletRequest request, HttpServletResponse response) {
		String resultArray = jdlkhzhService.getJdlkhxx(id,sfzh,nd);
		return callback + "(" + resultArray + ")" ;
	}
	/**
	 * 获取贫困户收入信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getJdlkhsrxx")
	@ResponseBody
	public String getJdlkhsrxx(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "sfzh", required = false) String sfzh,@RequestParam(value = "nd", required = false) String nd,HttpServletRequest request, HttpServletResponse response) {
		String resultArray = jdlkhzhService.getJdlkhsrxx(id,sfzh,nd);
		return callback + "(" + resultArray + ")" ;
	}
	/**
	 * 获取贫困户项目实施
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getJdlkhxmss")
	@ResponseBody
	public String getJdlkhxmss(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "sfzh", required = false) String sfzh,@RequestParam(value = "nd", required = false) String nd,HttpServletRequest request, HttpServletResponse response) {
		String resultArray = jdlkhzhService.getJdlkhxmss(id,sfzh,nd);
		return callback + "(" + resultArray + ")" ;
	}
	
	/**
	 * 获取脱贫情况
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getTpqk")
	@ResponseBody
	public String getTpqk(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request, HttpServletResponse response) {
		String resultArray = jdlkhzhService.getTpqk(id);
		return callback + "(" + resultArray + ")" ;
	}
	
	/**
	 * 获取脱贫情况json数组 zhangwei
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getTpqk0")
	@ResponseBody
	public String getTpqk0(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request, HttpServletResponse response) {
		String resultArray = jdlkhzhService.getTpqkxx(id);
		return callback + "(" + resultArray + ")";
	}
	
	/**
	 * 获取贫困户综合收入明细
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getSrgc")
	@ResponseBody
	public String getSrgc(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "callback", required = false) String callback,
			@RequestParam(value = "createDate", required = false) String createDate,HttpServletRequest request, HttpServletResponse response) {
		String resultArray = jdlkhzhService.getSrgc(id,createDate);
		return callback + "(" + resultArray + ")" ;
	}
	
	
	//zhangwei添加导出功能
	/**
	 * 导出excel文件
	 */
//		@RequiresPermissions("datacount:jdlkhzh:export")
    @RequestMapping(value = "export",method={RequestMethod.POST,RequestMethod.GET})
    public String exportFile(Jdlkhzh jdlkhzh, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			if(StringUtils.isNotEmpty(jdlkhzh.getCurrentAreaId()) && !jdlkhzh.getCurrentAreaId().equals("0")){
				Area area = areaService.get(jdlkhzh.getCurrentAreaId());
				switch(area.getType()){
				case "4":
					jdlkhzh.setXq(area.getId());
					break;
				case "5":
					jdlkhzh.setXz(area.getId());
					break;
				case "6":
					jdlkhzh.setXc(area.getId());
					break;
				}
			}else if(StringUtils.isEmpty(jdlkhzh.getCurrentAreaId())){
				String type = UserUtils.getUser().getOffice().getArea().getType();
				String areaCode = UserUtils.getUser().getOffice().getArea().getId();
				switch(type){
				case "4":
					jdlkhzh.setXq(areaCode);
					break;
				case "5":
					jdlkhzh.setXz(areaCode);
					break;
				case "6":
					jdlkhzh.setXc(areaCode);
					break;
				}
			}
            String fileName = "建档立卡综合查询表"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Jdlkhzh> page = jdlkhzhService.findPage1(new Page<Jdlkhzh>(request, response, -1), jdlkhzh);
    		new ExportExcel("建档立卡综合查询表", Jdlkhzh.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出建档立卡综合查询表记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/datacount/jdlkhzh/?repage";
    }
    
	/**
	 * 导出家庭成员
	 * @param jdlkhzh
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
    @RequestMapping(value = "exportPkrk", method={RequestMethod.POST,RequestMethod.GET})
    public String exportPkrkFile(Jdlkhzh jdlkhzh, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
    	try {
			if(StringUtils.isNotEmpty(jdlkhzh.getCurrentAreaId()) && !jdlkhzh.getCurrentAreaId().equals("0")){
				Area area = areaService.get(jdlkhzh.getCurrentAreaId());
				switch(area.getType()){
				case "4":
					jdlkhzh.setXq(area.getId());
					break;
				case "5":
					jdlkhzh.setXz(area.getId());
					break;
				case "6":
					jdlkhzh.setXc(area.getId());
					break;
				}
			}else if(StringUtils.isEmpty(jdlkhzh.getCurrentAreaId())){
				String type = UserUtils.getUser().getOffice().getArea().getType();
				String areaCode = UserUtils.getUser().getOffice().getArea().getId();
				switch(type){
				case "4":
					jdlkhzh.setXq(areaCode);
					break;
				case "5":
					jdlkhzh.setXz(areaCode);
					break;
				case "6":
					jdlkhzh.setXc(areaCode);
					break;
				}
			}
            String fileName = "贫困户家庭成员成员信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Jdlkhzh> page = jdlkhzhService.findListExportRen(new Page<Jdlkhzh>(request, response, -1), jdlkhzh);
    		new ExportExcel("贫困户家庭成员成员信息", Jdlkhzh.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出贫困户家庭成员成员信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/datacount/jdlkhzh/?repage";
    }
    
}