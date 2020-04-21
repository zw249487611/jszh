/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.dao;

import java.util.List;
import java.util.Map;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.app.vo.RhzfJyxxVo;
import com.jeeplus.modules.app.vo.RhzfYlbzVo;
import com.jeeplus.modules.bfll.entity.JiangsuAb01;

/**
 * 贫困人口基本信息DAO接口
 * @author tangtq
 * @version 2017-03-30
 */
@MyBatisDao
public interface JiangsuAb01Dao extends CrudDao<JiangsuAb01> {

	
	List<JiangsuAb01> findAllByUserId(JiangsuAb01 jab);


	List<JiangsuAb01> findList1(JiangsuAb01 jiangsuAb01);


	List<JiangsuAb01> getHuZhu(String id);
	
	List<JiangsuAb01> findListByAcid(String acid);
	
	List<RhzfJyxxVo> findListByAcidAndBirth(String acid);
	
	List<RhzfYlbzVo> findListByAcidAndYlbz(String acid);
	
	List<RhzfYlbzVo> findListByNoAcidAndYlbz(String acid);
	
	/**
	 * 根据贫困户编号查询该户所有的人员的身份证号
	 * @param pkhbh
	 * @return
	 */
	List<Map<String, String>> findAllSfzhByPkhbh(String pkhbh);
	
	List<JiangsuAb01> findNllist(JiangsuAb01 jab);
	
	List<String> findAllSfzhByAcid(JiangsuAb01 jab); 
}