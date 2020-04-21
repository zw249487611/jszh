/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlviewspot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.dzdlviewspot.entity.DzdlViewSpot;
import com.jeeplus.modules.dzdlviewspot.dao.DzdlViewSpotDao;

/**
 * 电子导览景点Service
 * @author 刘泽敏
 * @version 2016-10-27
 */
@Service
@Transactional(readOnly = true)
public class DzdlViewSpotService extends CrudService<DzdlViewSpotDao, DzdlViewSpot> {

	public DzdlViewSpot get(String id) {
		return super.get(id);
	}
	
	public List<DzdlViewSpot> findList(DzdlViewSpot dzdlViewSpot) {
		return super.findList(dzdlViewSpot);
	}
	
	public Page<DzdlViewSpot> findPage(Page<DzdlViewSpot> page, DzdlViewSpot dzdlViewSpot) {
		return super.findPage(page, dzdlViewSpot);
	}
	
	@Transactional(readOnly = false)
	public void save(DzdlViewSpot dzdlViewSpot) {
		super.save(dzdlViewSpot);
	}
	
	@Transactional(readOnly = false)
	public void delete(DzdlViewSpot dzdlViewSpot) {
		super.delete(dzdlViewSpot);
	}
	
	
	
	
}