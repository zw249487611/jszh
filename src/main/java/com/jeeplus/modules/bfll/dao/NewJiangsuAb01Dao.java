/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.bfll.entity.JiangsuAc01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01E;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01;

/**
 * 贫困人口基本信息DAO接口
 * @author hwm
 * @version 2017-05-09
 */
@MyBatisDao
public interface NewJiangsuAb01Dao extends CrudDao<NewJiangsuAb01> {

	List<NewJiangsuAb01> findByAcid(String id);
	
	List<NewJiangsuAb01> findByAcidBak(String id);

	List<NewJiangsuAb01> getHuZhu(String id);
	
	public int insertAb01Bak(NewJiangsuAb01 entity);

	public int gettotalCount(NewJiangsuAc01 jiangsuAc01);
	
	List<NewJiangsuAb01> findListByHzsfzh(String  hzsfzh);

	public int gettotalCount1(JiangsuAc01 jiangsuAc01);

	List<NewJiangsuAb01E> findListExport1(NewJiangsuAb01E newjiangsuAb01);//导出贫困人口
	
	List<NewJiangsuAb01> findListBySfzh(String sfzh);
}