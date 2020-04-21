/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.TreeDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author jeeplus
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
	public Office getByCode(String code);
	
	public Office getByAreaIdType(@Param(value="areaId")String areaId,@Param(value="type")String type);

	public Office getOfficeByAreaIdAndType(String areaId, String type);
	
	public List<Office> findSonList(Office office);
}
