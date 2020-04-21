/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.app.vo.RhzfJyxxVo;
import com.jeeplus.modules.app.vo.RhzfYlbzVo;
import com.jeeplus.modules.bfll.dao.JiangsuAb01Dao;
import com.jeeplus.modules.bfll.entity.JiangsuAb01;

/**
 * 贫困人口基本信息Service
 * @author tangtq
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class JiangsuAb01Service extends CrudService<JiangsuAb01Dao, JiangsuAb01> {
	
	public JiangsuAb01 get(String id) {
		return super.get(id);
	}
	
	public List<JiangsuAb01> findList(JiangsuAb01 jiangsuAb01) {
		return super.findList(jiangsuAb01);
	}
	
	public Page<JiangsuAb01> findPage(Page<JiangsuAb01> page, JiangsuAb01 jiangsuAb01) {
		return super.findPage(page, jiangsuAb01);
	}
	/*@Transactional(readOnly = false)
	public Page<JiangsuAb01> findPage1(Page<JiangsuAb01> page, JiangsuAb01 jiangsuAb01) {
		jiangsuAb01.setPage(page);
		List<JiangsuAb01> jiangsuAb01s=dao.findList(jiangsuAb01);
		for(int i=0;i<jiangsuAb01s.size();i++){
			JiangsuAc08 jiangsuAc08=jiangsuAc08Dao.findUniqueByProperty("acid", jiangsuAb01s.get(i).getAcid());
			List<JiangsuAc08> jiangsuAc08=jiangsuAc08Dao.findAc08ByAcid(jiangsuAb01s.get(i).getAcid());
			if(jiangsuAc08!=null){
				JiangsuAk11 jiangsuAk11=jiangsuAk11Dao.findUniqueByProperty("id", jiangsuAc08.getAkid());
				JiangsuAb01 jiangsuAb012= jiangsuAb01s.get(i);
				jiangsuAb012.setBfzerId(jiangsuAk11.getId());
				jiangsuAb012.setBfzerxm(jiangsuAk11.getAab002());
				dao.insert(jiangsuAb012);
			}
			
		}
		page.setList(jiangsuAb01s);
		return page;
	}*/
	@Transactional(readOnly = false)
	public void save(JiangsuAb01 jiangsuAb01) {
		super.save(jiangsuAb01);
	}
	
	@Transactional(readOnly = false)
	public void delete(JiangsuAb01 jiangsuAb01) {
		super.delete(jiangsuAb01);
	}
	
	
	@Transactional(readOnly = false)
	public List<JiangsuAb01> findAllByUserId(JiangsuAb01 jab) {
		
		return this.dao.findAllByUserId(jab);
	}

	
	@Transactional(readOnly = false)
	public List<JiangsuAb01> findListByAcid(String acid) {
		
		return this.dao.findListByAcid(acid);
	}
	
	@Transactional(readOnly = false)
	public List<RhzfJyxxVo> findListByAcidAndBirth(String acid) {
		
		return this.dao.findListByAcidAndBirth(acid);
	}
	
	@Transactional(readOnly = false)
	public List<RhzfYlbzVo> findListByAcidAndYlbz(String acid) {
		
		return this.dao.findListByAcidAndYlbz(acid);
	}

	@Transactional(readOnly = false)
	public List<RhzfYlbzVo> findListByNoAcidAndYlbz(String acid) {
		
		return this.dao.findListByNoAcidAndYlbz(acid);
	}
	

	
	public List<JiangsuAb01> findNlList(JiangsuAb01 jiangsuAb01) {
		return dao.findNllist(jiangsuAb01);
	}
	
	public List<String> findAllSfzhByAcid(JiangsuAb01 jiangsuAb01)
	{
		return dao.findAllSfzhByAcid(jiangsuAb01);
	}
}