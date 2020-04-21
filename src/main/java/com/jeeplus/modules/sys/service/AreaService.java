/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.service.TreeService;
import com.jeeplus.modules.sys.dao.AreaDao;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.utils.UserUtils;

import net.sf.json.JSONObject;

/**
 * 区域Service
 * @author jeeplus
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {
	@Autowired
	private AreaDao AreaDao;
	public List<Area> findAll(){
		return UserUtils.getAreaList();
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}

	public List<Area> getByParentId() {
		
		return AreaDao.getByParentId();
	}

	public List<Area> getAreaListByParentId(String id) {
		return AreaDao.getAreaListByParentId(id);
	}
	
	public List<Area> findList2(Area area){
		return AreaDao.findList2(area);
	}
	
	public List<Area> findListByProperty(String propertyName, Object value) {
		return AreaDao.findListByProperty(propertyName, value);
	}
	
	public Area findAreaByid(String id){
		return AreaDao.findAreaByid(id);
	}
	
	public List<Area> getAreaListByParentName(String name) {
		return AreaDao.getAreaListByParentName(name);
	}
	
	public Area getAreaByJgid(String jgid) {
		return AreaDao.getAreaByJgid(jgid);
	}

	public List<Area> queryGroupByVillageIdByParentId(String id) {
		return AreaDao.queryGroupByVillageIdByParentId(id);
	}
	
	public Area querynamebyid(String id) {
		return AreaDao.querynamebyid(id);
	}
	
	public Area getAreaByCode(String code) {
		return AreaDao.getAreaByCode(code);
	}
	
	public List<Area> getAreaByName(String name) {
		return AreaDao.getAreaByName(name);
	}
	
	public JSONObject getListByQueryAreaId(String queryAreaId,List<Area> areaList,boolean flag){
		JSONObject json = new JSONObject();
		JSONObject j = new JSONObject();
		String fuAreaId = "";
		if(queryAreaId == null || queryAreaId.equals("")){
			queryAreaId ="null";
		}
		Area queryArea = get(queryAreaId);
		String queryAreaParentIds = "";
		if(queryArea != null && queryArea.getParentIds() != null){
			queryAreaParentIds = queryArea.getParentIds();
		}
		List<JSONObject> areaJsonList = new ArrayList<JSONObject>();
		j.put("areaId","");
		j.put("areaName","---请选择---");
		j.put("selected","");
		areaJsonList.add(j);
		for(Area a : areaList){
			j = new JSONObject();
			j.put("areaId",a.getId());
			j.put("areaName",a.getName());
			if(queryAreaId.equals(a.getId())){
				j.put("selected","selected");
				fuAreaId = a.getId();
				flag = true;
			}else if(queryAreaParentIds.contains(a.getId())){
				if(!flag){
					j.put("selected","selected");
					fuAreaId = a.getId();
				}
			}else{
				j.put("selected","");
			}
			areaJsonList.add(j);
		}
		json.put("areaJsonList", areaJsonList);
		json.put("fuAreaId", fuAreaId);
		json.put("flag", flag);
		return json;
	}
	
	public Area getCity() {
		return dao.findAreaByid("ead2fd82424b4f33b423c56a631dc468");
	}
	/**
	 * 根据子ID获取父类区域
	 * @param id
	 * @return
	 */
	public Area getParentByChildId(String id){
		return dao.getParentByChildId(id);
	}
}
