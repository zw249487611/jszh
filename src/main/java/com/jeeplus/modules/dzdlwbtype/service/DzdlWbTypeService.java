/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlwbtype.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.dzdlwbtype.entity.DzdlWbType;
import com.jeeplus.modules.dzdlwbtype.dao.DzdlWbTypeDao;

/**
 * 电子导览物标类型管理Service
 * @author 刘泽敏
 * @version 2016-10-25
 */
@Service
@Transactional(readOnly = true)
public class DzdlWbTypeService extends CrudService<DzdlWbTypeDao, DzdlWbType> {

	public DzdlWbType get(String id) {
		return super.get(id);
	}
	
	public List<DzdlWbType> findList(DzdlWbType dzdlWbType) {
		return super.findList(dzdlWbType);
	}
	
	public Page<DzdlWbType> findPage(Page<DzdlWbType> page, DzdlWbType dzdlWbType) {
		return super.findPage(page, dzdlWbType);
	}
	
	@Transactional(readOnly = false)
	public void save(DzdlWbType dzdlWbType) {
		super.save(dzdlWbType);
	}
	
	@Transactional(readOnly = false)
	public void delete(DzdlWbType dzdlWbType) {
		super.delete(dzdlWbType);
	}
	
	
	
	
}