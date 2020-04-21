/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.bfll.dao.NewJiangsuAb01Dao;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01E;
import com.jeeplus.modules.sys.service.DictService;

/**
 * 贫困人口基本信息Service
 * @author hwm
 * @version 2017-05-09
 */
@Service
@Transactional(readOnly = true)
public class NewJiangsuAb01Service extends CrudService<NewJiangsuAb01Dao, NewJiangsuAb01> {
	
	@Autowired
	private DictService dictService;

	public NewJiangsuAb01 get(String id) {
		return super.get(id);
	}
	
	public List<NewJiangsuAb01> findList(NewJiangsuAb01 jiangsuAb01) {
		return super.findList(jiangsuAb01);
	}
	
	public Page<NewJiangsuAb01> findPage(Page<NewJiangsuAb01> page, NewJiangsuAb01 jiangsuAb01) {
		return super.findPage(page, jiangsuAb01);
	}
	
	@Transactional(readOnly = false)
	public void save(NewJiangsuAb01 jiangsuAb01) {
		if (jiangsuAb01.getIsNewRecord()) {
			jiangsuAb01.preInsert();
			jiangsuAb01.setId(dictService.getIncrementId("1"));
			dao.insert(jiangsuAb01);
		} else {
			jiangsuAb01.preUpdate();
			dao.update(jiangsuAb01);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(NewJiangsuAb01 jiangsuAb01) {
		dao.insertAb01Bak(jiangsuAb01);
		super.delete(jiangsuAb01);
	}

	public List<NewJiangsuAb01> findByAcid(String id) {
		return dao.findByAcid(id);
	}
	
	public List<NewJiangsuAb01> findByAcidBak(String id) {
		return dao.findByAcidBak(id);
	}

	public Page<NewJiangsuAb01E> findPage1(Page<NewJiangsuAb01E> page, NewJiangsuAb01E newjiangsuAb01) {
		newjiangsuAb01.setPage(page);
		page.setList(dao.findListExport1(newjiangsuAb01));
		return page;
	}
	
	public List<NewJiangsuAb01> findListBySfzh(String sfzh) {
		return dao.findListBySfzh(sfzh);
	}
}