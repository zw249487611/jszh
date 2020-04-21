/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.project.entity.Const;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.entity.Office;
import com.jeeplus.modules.sys.entity.Role;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.utils.UserUtils;

import net.sf.json.JSONObject;

/**
 * 区域Controller
 * @author jeeplus
 * @version 2013-5-15
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/area")
public class AreaController extends BaseController {

	@Autowired
	private AreaService areaService;
	
	@ModelAttribute("area")
	public Area get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return areaService.get(id);
		}else{
			return new Area();
		}
	}

	@RequiresPermissions("sys:area:list")
	@RequestMapping(value = {"list", ""})
	public String list(Area area, Model model) {
		model.addAttribute("list", areaService.findAll());
		return "modules/sys/areaList";
	}

	@RequiresPermissions(value={"sys:area:view","sys:area:add","sys:area:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Area area, Model model) {
		if (area.getParent()==null||area.getParent().getId()==null){
			area.setParent(UserUtils.getUser().getOffice().getArea());
		}else{
			area.setParent(areaService.get(area.getParent().getId()));
		}
		
//		// 自动获取排序号
//		if (StringUtils.isBlank(area.getId())){
//			int size = 0;
//			List<Area> list = areaService.findAll();
//			for (int i=0; i<list.size(); i++){
//				Area e = list.get(i);
//				if (e.getParent()!=null && e.getParent().getId()!=null
//						&& e.getParent().getId().equals(area.getParent().getId())){
//					size++;
//				}
//			}
//			area.setCode(area.getParent().getCode() + StringUtils.leftPad(String.valueOf(size > 0 ? size : 1), 4, "0"));
//		}
		model.addAttribute("area", area);
		return "modules/sys/areaForm";
	}
	
	@RequiresPermissions(value={"sys:area:add","sys:area:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Area area, Model model, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/area";
		}
		if (!beanValidator(model, area)){
			return form(area, model);
		}
		areaService.save(area);
		addMessage(redirectAttributes, "保存区域'" + area.getName() + "'成功");
		return "redirect:" + adminPath + "/sys/area/";
	}
	
	@RequiresPermissions("sys:area:del")
	@RequestMapping(value = "delete")
	public String delete(Area area, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/area";
		}
//		if (Area.isRoot(id)){
//			addMessage(redirectAttributes, "删除区域失败, 不允许删除顶级区域或编号为空");
//		}else{
			areaService.delete(area);
			addMessage(redirectAttributes, "删除区域成功");
//		}
		return "redirect:" + adminPath + "/sys/area/";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findAll();
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}/*查找乡镇和以上areaTree*/
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeDataXzPlus")
	public List<Map<String, Object>> treeDataXzPlus(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> list = areaService.findAll();
		List<Area> listXzPlus=new ArrayList<Area>();
		for(Area area:list){
			if(Integer.parseInt(area.getType())<6){
				listXzPlus.add(area);
			}
		}
		for (int i=0; i<listXzPlus.size(); i++){
			Area e = listXzPlus.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	@ResponseBody
	@RequestMapping(value = "queryVillageByUser")
	public List<Area> queryVillageByUser(){
		User user = UserUtils.getUser();
		String areaId = "320803109000";
		if(user.isAdmin()){
			
		}else{
			Office office = user.getOffice();
			Area area = office.getArea();
			areaId = area.getId();
		}
		
		List<Area> childAreaList = areaService.queryGroupByVillageIdByParentId(areaId);
		return childAreaList;
	}
	
	@ResponseBody
	@RequestMapping(value = "queryGroupByVillageId")
	public List<Area> queryGroupByVillageId(String id){
		if(null == id || "".equals(id))
			return new ArrayList<Area>();
		
		List<Area> childAreaList = areaService.queryGroupByVillageIdByParentId(id);
		return childAreaList;
	}
	
	@ResponseBody
	@RequestMapping(value = "queryCountryList")
	public List<Area> queryCountryList(){
		Area area=new Area();
		area.setType("4");
		return areaService.findList2(area);
	}
	
	/**
	 * 获取机构JSON数据。
	 * @param extId 排除的ID
	 * @param type	类型（1：公司；2：部门/小组/其它：3：用户）
	 * @param grade 显示级别
	 * @param response
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "gtxtreeData")
	public List<Map<String, Object>> gjxtreeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String type,
			@RequestParam(required=false) Long grade, @RequestParam(required=false) Boolean isAll, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Area> arealist = areaService.findAll();
		List<Area> newArealist = new ArrayList<Area>();
		for(Area a : arealist){
			if(!(Const.Cun.equals(a.getType()))){
				newArealist.add(a);
			}
		}
		for (int i=0; i<newArealist.size(); i++){
			Area e = newArealist.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> areamap = Maps.newHashMap();
				areamap.put("id", e.getId());
				areamap.put("pId", e.getParentId());
				areamap.put("name", e.getName());
				mapList.add(areamap);
			}
		}
		return mapList;
	}
	
	/**
	 * @param fuAreaId
	 * @return 根据区域父节点查询子一级区域
	 */
	@RequestMapping(value = "getTypeArea")
	@ResponseBody
	public List<JSONObject> getTypeArea(@RequestParam(required=false) String fuAreaId){
		JSONObject json = new JSONObject();
		json.put("areaId","");
		json.put("areaName","---请选择---");
		List<JSONObject> areaJsonList = new ArrayList<JSONObject>();
		areaJsonList.add(json);
		List<Area> areaList = areaService.getAreaListByParentId(fuAreaId);
		for(Area area : areaList){
			JSONObject j = new JSONObject();
			j.put("areaId",area.getId());
			j.put("areaName",area.getName());
			areaJsonList.add(j);
		}
		return areaJsonList;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getAllTypeArea")
	@ResponseBody
	public JSONObject getAllTypeArea(@RequestParam(required=false) String currentAreaId){
		JSONObject json = new JSONObject();
		User user = UserUtils.getUser();
		String areaId = user.getOffice().getArea().getId();
		Area area = areaService.get(areaId);
		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		List<JSONObject> areaJsonList_4 = new ArrayList<JSONObject>();//县区List
		List<JSONObject> areaJsonList_5 = new ArrayList<JSONObject>();//乡镇List
		List<JSONObject> areaJsonList_6 = new ArrayList<JSONObject>();//村居List
		String areaId_4 = "";
		String areaId_5 = "";
		List<Area> areaList = areaService.getAreaListByParentId(area.getId());
		boolean isDataScopeAll = false;
		for (Role r : user.getRoleList()){
			if (!dataScope.contains(r.getDataScope())){
				if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())){
					isDataScopeAll = true;
				}else{
					isDataScopeAll = false;
				}
				dataScope.add(r.getDataScope());
			}
		}
		Area parentArea = new Area();
		boolean flag =false;
		if (!isDataScopeAll){
			if(area.getType().equals("3")){
				JSONObject j = new JSONObject();
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_4 = j.getJSONArray("areaJsonList");
				areaId_4 = j.getString("fuAreaId");
				flag = j.getBoolean("flag");
				if(!areaId_4.equals("")){
					areaList = areaService.getAreaListByParentId(areaId_4);
					j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
					areaJsonList_5 = j.getJSONArray("areaJsonList");
					areaId_5 = j.getString("fuAreaId");
					flag = j.getBoolean("flag");
				}
				if(!areaId_5.equals("")){
					areaList = areaService.getAreaListByParentId(areaId_5);
					j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
					areaJsonList_6 = j.getJSONArray("areaJsonList");
				}
			}else if(area.getType().equals("4")){
				JSONObject j = new JSONObject();
				j.put("areaId",area.getId());
				j.put("areaName",area.getName());
				j.put("selected","selected");
				areaJsonList_4.add(j);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_5 = j.getJSONArray("areaJsonList");
				areaId_5 = j.getString("fuAreaId");
				flag = j.getBoolean("flag");
				if(!areaId_5.equals("")){
					areaList = areaService.getAreaListByParentId(areaId_5);
					j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
					areaJsonList_6 = j.getJSONArray("areaJsonList");
				}
			}else if(area.getType().equals("5")){
				JSONObject j = new JSONObject();
				parentArea = areaService.get(area.getParentId());
				j.put("areaId",parentArea.getId());
				j.put("areaName",parentArea.getName());
				j.put("selected","selected");
				areaJsonList_4.add(j);
				j = new JSONObject();
				j.put("areaId",area.getId());
				j.put("areaName",area.getName());
				j.put("selected","selected");
				areaJsonList_5.add(j);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_6 = j.getJSONArray("areaJsonList");
			}
		}else{
			JSONObject j = new JSONObject();
			j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
			areaJsonList_4 = j.getJSONArray("areaJsonList");
			areaId_4 = j.getString("fuAreaId");
			flag = j.getBoolean("flag");
			if(!areaId_4.equals("")){
				areaList = areaService.getAreaListByParentId(areaId_4);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_5 = j.getJSONArray("areaJsonList");
				areaId_5 = j.getString("fuAreaId");
				flag = j.getBoolean("flag");
			}
			if(!areaId_5.equals("")){
				areaList = areaService.getAreaListByParentId(areaId_5);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_6 = j.getJSONArray("areaJsonList");
			}
		}
		json.put("areaJsonList_4", areaJsonList_4);
		json.put("areaJsonList_5", areaJsonList_5);
		json.put("areaJsonList_6", areaJsonList_6);
		return json;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getAllTypeAreaXz")
	@ResponseBody
	public JSONObject getAllTypeAreaXz(@RequestParam(required=false) String currentAreaId,@RequestParam(required=false) String xqcode){
		JSONObject json = new JSONObject();
		User user = UserUtils.getUser();
		String areaId = user.getOffice().getArea().getId();
		Area area = areaService.get(areaId);
		if("3".endsWith(area.getType())){
			area = areaService.get(xqcode);
		}
		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		List<JSONObject> areaJsonList_4 = new ArrayList<JSONObject>();//县区List
		List<JSONObject> areaJsonList_5 = new ArrayList<JSONObject>();//乡镇List
		List<JSONObject> areaJsonList_6 = new ArrayList<JSONObject>();//村居List
		String areaId_4 = "";
		String areaId_5 = "";
		List<Area> areaList = areaService.getAreaListByParentId(area.getId());
		boolean isDataScopeAll = false;
		/*for (Role r : user.getRoleList()){
			if (!dataScope.contains(r.getDataScope())){
				if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())){
					isDataScopeAll = true;
				}else{
					isDataScopeAll = false;
				}
				dataScope.add(r.getDataScope());
			}
		}*/
		Area parentArea = new Area();
		boolean flag =false;
		if (!isDataScopeAll){
			if(area.getType().equals("3")){
				JSONObject j = new JSONObject();
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_4 = j.getJSONArray("areaJsonList");
				areaId_4 = j.getString("fuAreaId");
				flag = j.getBoolean("flag");
				if(!areaId_4.equals("")){
					areaList = areaService.getAreaListByParentId(areaId_4);
					j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
					areaJsonList_5 = j.getJSONArray("areaJsonList");
					areaId_5 = j.getString("fuAreaId");
					flag = j.getBoolean("flag");
				}
				if(!areaId_5.equals("")){
					areaList = areaService.getAreaListByParentId(areaId_5);
					j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
					areaJsonList_6 = j.getJSONArray("areaJsonList");
				}
			}else if(area.getType().equals("4")){
				JSONObject j = new JSONObject();
				j.put("areaId",area.getId());
				j.put("areaName",area.getName());
				j.put("selected","selected");
				areaJsonList_4.add(j);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_5 = j.getJSONArray("areaJsonList");
				areaId_5 = j.getString("fuAreaId");
				flag = j.getBoolean("flag");
				if(!areaId_5.equals("")){
					areaList = areaService.getAreaListByParentId(areaId_5);
					j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
					areaJsonList_6 = j.getJSONArray("areaJsonList");
				}
			}else if(area.getType().equals("5")){
				JSONObject j = new JSONObject();
				parentArea = areaService.get(area.getParentId());
				j.put("areaId",parentArea.getId());
				j.put("areaName",parentArea.getName());
				j.put("selected","selected");
				areaJsonList_4.add(j);
				j = new JSONObject();
				j.put("areaId",area.getId());
				j.put("areaName",area.getName());
				j.put("selected","selected");
				areaJsonList_5.add(j);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_6 = j.getJSONArray("areaJsonList");
			}
		}else{
			JSONObject j = new JSONObject();
			j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
			areaJsonList_4 = j.getJSONArray("areaJsonList");
			areaId_4 = j.getString("fuAreaId");
			flag = j.getBoolean("flag");
			if(!areaId_4.equals("")){
				areaList = areaService.getAreaListByParentId(areaId_4);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_5 = j.getJSONArray("areaJsonList");
				areaId_5 = j.getString("fuAreaId");
				flag = j.getBoolean("flag");
			}
			if(!areaId_5.equals("")){
				areaList = areaService.getAreaListByParentId(areaId_5);
				j = areaService.getListByQueryAreaId(currentAreaId, areaList,flag);
				areaJsonList_6 = j.getJSONArray("areaJsonList");
			}
		}
		json.put("areaJsonList_4", areaJsonList_4);
		json.put("areaJsonList_5", areaJsonList_5);
		json.put("areaJsonList_6", areaJsonList_6);
		return json;
	}
	
	
}
