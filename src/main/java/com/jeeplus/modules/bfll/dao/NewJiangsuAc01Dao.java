/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01E;

/**
 * 贫困户基本信息DAO接口
 * @author hwm
 * @version 2017-05-09
 */
@MyBatisDao
public interface NewJiangsuAc01Dao extends CrudDao<NewJiangsuAc01> {
	
	NewJiangsuAc01 getBak(String id);

	List<NewJiangsuAc01> findList1(NewJiangsuAc01 jiangsuAc01);
	
	public int insertAc01Bak(NewJiangsuAc01 entity);

	/**
	 * 导出贫困户管理数据
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<NewJiangsuAc01E> findListExport(NewJiangsuAc01E newJiangsuAc01);
	/**
	 * 恢复贫困户
	 * @param id
	 * @return
	 */
	int returnAc01(String id);
	/**
	 * 恢复贫困人口
	 * @param id
	 * @return
	 */
	int returnAb01(String acid);
	
}