/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.dao;

import java.util.List;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.app.vo.PkhDetailInfoVo;
import com.jeeplus.modules.app.vo.PkhwgsrInfoVo;
import com.jeeplus.modules.app.vo.PkhxmxxInfoVo;
import com.jeeplus.modules.app.vo.TpxxInfoVo;
import com.jeeplus.modules.dataCount.entity.Jdlkhzh;
import com.jeeplus.modules.zjjg.entity.PZjRysjsb;

/**
 * 贫困户信息综合查询DAO接口
 * @author 陆凯凯
 * @version 2017-08-30
 */
@MyBatisDao
public interface JdlkhzhDao extends CrudDao<Jdlkhzh> {
	/**
	 * 获取数据条数
	 * @return
	 */
	int findCount();
	
	/**
	 * 获取家庭成员信息
	 * @param acid
	 * @return
	 */
	List<Jdlkhzh> findJtcyxx(String acid);
	
	/**
	 * 获取家庭成员信息的医疗保障
	 * @param acid
	 * @return
	 */
	List<Jdlkhzh> findYlbzQk(String acid);
	
	/**
	 * 获取家庭成员所有身份证号
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<String> findSfzhm(String nd,String sfzh,String id);
	
	/**
	 * 导出建档立卡户数据
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<Jdlkhzh> findListExport(Jdlkhzh jdlkhzh);
	
	/**
	 * 导出家庭成员数据
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<Jdlkhzh> findListExportRen(Jdlkhzh jdlkhzh);
	
	//获取脱贫年度
	String findTpnd(String id);

	//根据所在年的id，去查2017年的id
	String findTpxx2017(String id);
	//根据所在年份年的id，去查2017年的id
	String findTpxx2016(String id);

	
	//总人数
	String gettotalCount(Jdlkhzh jdlkhzh);
	
	/**
	 * 动态监测findList
	 * @return
	 */
	public List<Jdlkhzh> findList4DyWarn(Jdlkhzh jdlkhzh);
	
	/**
	 * 因病返贫预警findList
	 * @return
	 */
	public List<Jdlkhzh> findList4DisPoor(Jdlkhzh jdlkhzh);

	/**
	 * 获取脱贫轨迹
	 * @param sfzh
	 * @param nd
	 * @return
	 */
	List<PkhDetailInfoVo> findTpgj(PkhDetailInfoVo param);

	/**
	 * 获取扶贫开发项目收益
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<PZjRysjsb> findFpkfxmsy(Jdlkhzh param);
	
	/**
	 * 获取社会救济补助
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<PZjRysjsb> findShjjhbz(Jdlkhzh param);
	
	/**
	 * 获取政策性生产补贴
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<PZjRysjsb> findZcxscbt(Jdlkhzh param);
	
	/**
	 * 获取教育资助
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<PZjRysjsb> findJyzz(Jdlkhzh param);
	/**
	 * 慈善救助
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<PZjRysjsb> findCsjz(Jdlkhzh param);

	/**
	 * 获取帮扶项目信息
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<PkhxmxxInfoVo> findBfxmxx(String id);
	
	/**
	 * 获取脱贫信息
	 * @param nd
	 * @param sfzh
	 * @return
	 */
	List<TpxxInfoVo> findTpxx(String id);
	
	
	/**
	 * 根据acid查询
	 * @param adid
	 * @return
	 */
	TpxxInfoVo getJdlkAcid(String id);
	
	
	/**
	 * 脱贫信息
	 * @return
	 */
	TpxxInfoVo getJdlkTpxx(String id);
	
	/**
	 * 根据ac07查询
	 * @param adid
	 * @return
	 */
	TpxxInfoVo getJdlkCjsr(String nd,String hbh);
	
	/**
	 * 获取贫困户的详细信息
	 * @param param
	 * @return
	 */
	PkhDetailInfoVo findPkhxx(PkhDetailInfoVo param);
	
	/**
	 * 获取务工收入信息
	 * @param param
	 * @return
	 */
	List<PkhwgsrInfoVo> findWgsrxx(PkhDetailInfoVo param);
	
	
	
}