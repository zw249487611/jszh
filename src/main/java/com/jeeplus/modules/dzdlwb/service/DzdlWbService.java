/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlwb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.dzdlwb.entity.DzdlWb;
import com.jeeplus.modules.dzdlwb.dao.DzdlWbDao;

/**
 * 物标管理Service
 * @author 刘泽敏
 * @version 2016-10-26
 */
@Service
@Transactional(readOnly = true)
public class DzdlWbService extends CrudService<DzdlWbDao, DzdlWb> {

	public DzdlWb get(String id) {
		return super.get(id);
	}
	
	public List<DzdlWb> findList(DzdlWb dzdlWb) {
		return super.findList(dzdlWb);
	}
	
	public Page<DzdlWb> findPage(Page<DzdlWb> page, DzdlWb dzdlWb) {
		return super.findPage(page, dzdlWb);
	}
	
	@Transactional(readOnly = false)
	public void save(DzdlWb dzdlWb) {
		super.save(dzdlWb);
	}
	
	@Transactional(readOnly = false)
	public void delete(DzdlWb dzdlWb) {
		super.delete(dzdlWb);
	}
	
	
	
	
}