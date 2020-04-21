package com.jeeplus.modules.bfll.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.bfll.entity.JiangsuAc01;

@MyBatisDao
public interface JiangsuAc01Dao extends CrudDao<JiangsuAc01>{

	void insertMsgToAc(JiangsuAc01 jac);

	List<JiangsuAc01> findList0(JiangsuAc01 jiangsuAc01);
	List<JiangsuAc01> findList1(JiangsuAc01 jiangsuAc01);
	
	List<JiangsuAc01> findListBySfzh(String sfzh);
	
	List<Map<String, Object>> getXzPkhCount(@Param("pkhYear") Integer pkhYear, @Param("xzCode") String xzCode);
	
	void updateTpbzByPkhId(@Param(value="pkhId")String pkhId,@Param(value="code")String code);
	
	void updateTpndByXqqrid(@Param(value="xqqrid")String xqqrid,@Param(value="tpnd")String tpnd);
	
	void uploadJtzfzp(JiangsuAc01 jiangsuAc01);
	JiangsuAc01 getJtzfzp(JiangsuAc01 jiangsuAc01);
	int deleteJtzfzp(JiangsuAc01 jiangsuAc01);
	void updateIsWf(JiangsuAc01 jiangsuAc01);

	//更新住房安全有保障中的是否属实和备注
	void updateZfaqbz(JiangsuAc01 jiangsuAc01);
	
	//已脱贫的危房户信息
	 List<JiangsuAc01> findListBywfh(JiangsuAc01 jiangsuAc01);
	 
	//疑似危房户信息
	 List<JiangsuAc01> findListByyswfh(JiangsuAc01 jiangsuAc01);

	 //查询危房全改造form详情
	JiangsuAc01 getWf(String id);

	//更新修改危房全改造备注等信息
	void updateWf(JiangsuAc01 t);
}
