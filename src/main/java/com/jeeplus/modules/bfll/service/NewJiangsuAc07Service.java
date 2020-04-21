/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.bfll.dao.NewJiangsuAc07Dao;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc07;

/**
 * 贫困户收入信息表Service
 * @author hwm
 * @version 2017-05-09
 */
@Service
@Transactional(readOnly = true)
public class NewJiangsuAc07Service extends CrudService<NewJiangsuAc07Dao, NewJiangsuAc07> {

	public NewJiangsuAc07 get(String id) {
		return super.get(id);
	}
	
	public List<NewJiangsuAc07> findList(NewJiangsuAc07 jiangsuAc07) {
		return super.findList(jiangsuAc07);
	}
	
	public Page<NewJiangsuAc07> findPage(Page<NewJiangsuAc07> page, NewJiangsuAc07 jiangsuAc07) {
		return super.findPage(page, jiangsuAc07);
	}
	
	@Transactional(readOnly = false)
	public void save(NewJiangsuAc07 jiangsuAc07) {
		super.save(jiangsuAc07);
	}
	
	@Transactional(readOnly = false)
	public void delete(NewJiangsuAc07 jiangsuAc07) {
		super.delete(jiangsuAc07);
	}

	public NewJiangsuAc07 findByAcid(String id, String quarter) {
		return dao.findByAcid(id, quarter);
	}
	
	public NewJiangsuAc07 findByAcidAndNd(String id, String nd) {
		return dao.findByAcidAndNd(id, nd);
	}
	
	
	
	
}