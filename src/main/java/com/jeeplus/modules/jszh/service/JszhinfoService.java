/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.jszh.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.jszh.entity.Jszhinfo;
import com.jeeplus.modules.jszh.dao.JszhinfoDao;

/**
 * 江苏智淮员工身体状况Service
 * @author zhangw
 * @version 2020-02-02
 */
@Service
@Transactional(readOnly = true)
public class JszhinfoService extends CrudService<JszhinfoDao, Jszhinfo> {

	public Jszhinfo get(String id) {
		return super.get(id);
	}
	
	public List<Jszhinfo> findList(Jszhinfo jszhinfo) {
		return super.findList(jszhinfo);
	}
	
	public Page<Jszhinfo> findPage(Page<Jszhinfo> page, Jszhinfo jszhinfo) {
		return super.findPage(page, jszhinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(Jszhinfo jszhinfo) {
		super.save(jszhinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(Jszhinfo jszhinfo) {
		super.delete(jszhinfo);
	}
	
	
	
	
}