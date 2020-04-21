/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.ipwhitelist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.ipwhitelist.entity.IpWhiteList;
import com.jeeplus.modules.ipwhitelist.dao.IpWhiteListDao;

/**
 * ip白名单Service
 * @author maojl
 * @version 2019-01-23
 */
@Service
@Transactional(readOnly = true)
public class IpWhiteListService extends CrudService<IpWhiteListDao, IpWhiteList> {

	public IpWhiteList get(String id) {
		return super.get(id);
	}
	
	public List<IpWhiteList> findList(IpWhiteList ipWhiteList) {
		return super.findList(ipWhiteList);
	}
	
	public Page<IpWhiteList> findPage(Page<IpWhiteList> page, IpWhiteList ipWhiteList) {
		return super.findPage(page, ipWhiteList);
	}
	
	@Transactional(readOnly = false)
	public void save(IpWhiteList ipWhiteList) {
		super.save(ipWhiteList);
	}
	
	@Transactional(readOnly = false)
	public void delete(IpWhiteList ipWhiteList) {
		super.delete(ipWhiteList);
	}
	
	
	
	
}