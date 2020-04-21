/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01;
import com.jeeplus.modules.bfll.entity.TJdlkhXxbg;

import com.jeeplus.modules.bfll.dao.TJdlkhXxbgDao;

/**
 * 建档立卡信息变更履历Service
 * @author 王彧
 * @version 2017-11-07
 */
@Service
@Transactional(readOnly = true)
public class TJdlkhXxbgService extends CrudService<TJdlkhXxbgDao, TJdlkhXxbg> {
	
	public TJdlkhXxbg get(String id) {
		return super.get(id);
	}
	
	public List<TJdlkhXxbg> findList(TJdlkhXxbg tJdlkhXxbg) {
		return super.findList(tJdlkhXxbg);
	}
	
	public Page<TJdlkhXxbg> findPage(Page<TJdlkhXxbg> page, TJdlkhXxbg tJdlkhXxbg) {
		return super.findPage(page, tJdlkhXxbg);
	}
	
	@Transactional(readOnly = false)
	public void save(TJdlkhXxbg tJdlkhXxbg) {
		super.save(tJdlkhXxbg);
	}
	
	@Transactional(readOnly = false)
	public void delete(TJdlkhXxbg tJdlkhXxbg) {
		super.delete(tJdlkhXxbg);
	}
	
	@Transactional(readOnly = false)
	public void saveTJdlkhXxbg(NewJiangsuAc01 newJiangsuAc01,String acidBak,String bglx){
		TJdlkhXxbg tJdlkhXxbg = new TJdlkhXxbg();
		if(newJiangsuAc01 != null){
			tJdlkhXxbg.setAcid(newJiangsuAc01.getId());
			tJdlkhXxbg.setBgyy(newJiangsuAc01.getBgyy());
			tJdlkhXxbg.setBglx(bglx);
			tJdlkhXxbg.setAcidBak(acidBak);
			tJdlkhXxbg.setNd(newJiangsuAc01.getAar040().toString());
		}
		if(tJdlkhXxbg != null){
			save(tJdlkhXxbg);
		}
	}
	
}