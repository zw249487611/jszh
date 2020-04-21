/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.TreeDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author jeeplus
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	public List<Area> getByParentId();
	public List<Area> getAreaListByParentId(String id);
	public List<Area> findList2(Area area);
	public List<Area> findListByProperty(@Param(value="propertyName")String propertyName, @Param(value="value")Object value);
	public Area findAreaByid(String id);
	public List<Area> getAreaListByParentName(String name);
	public Area getAreaByJgid(String jgid);
	public List<Area> queryGroupByVillageIdByParentId(String id);
	public Area querynamebyid(String id);
	public Area getAreaByCode(String code);
	
	public List<Area> getAreaByType(String type);
	
	public List<Area> getAreaByName(String name);
	
	public Area getParentByChildId(String id);
}
