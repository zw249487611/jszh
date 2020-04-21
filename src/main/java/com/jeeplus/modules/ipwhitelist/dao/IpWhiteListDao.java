/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.ipwhitelist.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.ipwhitelist.entity.IpWhiteList;

/**
 * ip白名单DAO接口
 * @author maojl
 * @version 2019-01-23
 */
@MyBatisDao
public interface IpWhiteListDao extends CrudDao<IpWhiteList> {

	
}