/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.dao;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc07;

/**
 * 贫困户收入信息表DAO接口
 * @author hwm
 * @version 2017-05-09
 */
@MyBatisDao
public interface NewJiangsuAc07Dao extends CrudDao<NewJiangsuAc07> {

	NewJiangsuAc07 findByAcid(@Param("id") String id, @Param("quarter") String quarter);
	
	NewJiangsuAc07 findByAcidAndNd(@Param("id") String id, @Param("nd") String nd);

	
}