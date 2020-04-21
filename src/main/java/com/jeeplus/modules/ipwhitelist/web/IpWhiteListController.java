/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.ipwhitelist.web;

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
import com.jeeplus.modules.ipwhitelist.entity.IpWhiteList;
import com.jeeplus.modules.ipwhitelist.service.IpWhiteListService;

/**
 * ip白名单Controller
 * @author maojl
 * @version 2019-01-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ipwhitelist/ipWhiteList")
public class IpWhiteListController extends BaseController {

	@Autowired
	private IpWhiteListService ipWhiteListService;
	
	@ModelAttribute
	public IpWhiteList get(@RequestParam(required=false) String id) {
		IpWhiteList entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ipWhiteListService.get(id);
		}
		if (entity == null){
			entity = new IpWhiteList();
		}
		return entity;
	}
	
	/**
	 * ip白名单列表页面
	 */
	@RequiresPermissions("ipwhitelist:ipWhiteList:list")
	@RequestMapping(value = {"list", ""})
	public String list(IpWhiteList ipWhiteList, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<IpWhiteList> page = ipWhiteListService.findPage(new Page<IpWhiteList>(request, response), ipWhiteList); 
		model.addAttribute("page", page);
		return "modules/ipwhitelist/ipWhiteListList";
	}

	/**
	 * 查看，增加，编辑ip白名单表单页面
	 */
	@RequiresPermissions(value={"ipwhitelist:ipWhiteList:view","ipwhitelist:ipWhiteList:add","ipwhitelist:ipWhiteList:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IpWhiteList ipWhiteList, Model model) {
		model.addAttribute("ipWhiteList", ipWhiteList);
		return "modules/ipwhitelist/ipWhiteListForm";
	}

	/**
	 * 保存ip白名单
	 */
	@RequiresPermissions(value={"ipwhitelist:ipWhiteList:add","ipwhitelist:ipWhiteList:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IpWhiteList ipWhiteList, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ipWhiteList)){
			return form(ipWhiteList, model);
		}
		if(!ipWhiteList.getIsNewRecord()){//编辑表单保存
			IpWhiteList t = ipWhiteListService.get(ipWhiteList.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ipWhiteList, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ipWhiteListService.save(t);//保存
		}else{//新增表单保存
			ipWhiteListService.save(ipWhiteList);//保存
		}
		addMessage(redirectAttributes, "保存ip白名单成功");
		return "redirect:"+Global.getAdminPath()+"/ipwhitelist/ipWhiteList/?repage";
	}
	
	/**
	 * 删除ip白名单
	 */
	@RequiresPermissions("ipwhitelist:ipWhiteList:del")
	@RequestMapping(value = "delete")
	public String delete(IpWhiteList ipWhiteList, RedirectAttributes redirectAttributes) {
		ipWhiteListService.delete(ipWhiteList);
		addMessage(redirectAttributes, "删除ip白名单成功");
		return "redirect:"+Global.getAdminPath()+"/ipwhitelist/ipWhiteList/?repage";
	}
	
	/**
	 * 批量删除ip白名单
	 */
	@RequiresPermissions("ipwhitelist:ipWhiteList:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ipWhiteListService.delete(ipWhiteListService.get(id));
		}
		addMessage(redirectAttributes, "删除ip白名单成功");
		return "redirect:"+Global.getAdminPath()+"/ipwhitelist/ipWhiteList/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ipwhitelist:ipWhiteList:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IpWhiteList ipWhiteList, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "ip白名单"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IpWhiteList> page = ipWhiteListService.findPage(new Page<IpWhiteList>(request, response, -1), ipWhiteList);
    		new ExportExcel("ip白名单", IpWhiteList.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出ip白名单记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ipwhitelist/ipWhiteList/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ipwhitelist:ipWhiteList:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IpWhiteList> list = ei.getDataList(IpWhiteList.class);
			for (IpWhiteList ipWhiteList : list){
				try{
					ipWhiteListService.save(ipWhiteList);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条ip白名单记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条ip白名单记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入ip白名单失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ipwhitelist/ipWhiteList/?repage";
    }
	
	/**
	 * 下载导入ip白名单数据模板
	 */
	@RequiresPermissions("ipwhitelist:ipWhiteList:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "ip白名单数据导入模板.xlsx";
    		List<IpWhiteList> list = Lists.newArrayList(); 
    		new ExportExcel("ip白名单数据", IpWhiteList.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ipwhitelist/ipWhiteList/?repage";
    }
	
	
	

}