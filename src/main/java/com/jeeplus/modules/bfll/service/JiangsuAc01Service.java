package com.jeeplus.modules.bfll.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.bfll.dao.JiangsuAb01Dao;
import com.jeeplus.modules.bfll.dao.JiangsuAc01Dao;
import com.jeeplus.modules.bfll.entity.JiangsuAc01;
@Service
@Transactional(readOnly = true)
public class JiangsuAc01Service extends CrudService<JiangsuAc01Dao, JiangsuAc01>{
	@Autowired
	private JiangsuAb01Dao jiangsuAb01Dao;
	
	@Autowired
	private JiangsuAc01Dao jiangsuAc01Dao;
	
	public JiangsuAc01 get(String id) {
		return super.get(id);
	}
	
	public List<JiangsuAc01> findList(JiangsuAc01 jiangsuAc01) {
		return super.findList(jiangsuAc01);
	}
	
	public Page<JiangsuAc01> findPage(Page<JiangsuAc01> page, JiangsuAc01 jiangsuAc01) {
		return super.findPage(page, jiangsuAc01);
	}
	@Transactional(readOnly = false)
	public Page<JiangsuAc01> findPage1(Page<JiangsuAc01> page, JiangsuAc01 jiangsuAc01) {
		jiangsuAc01.setPage(page);
		List<JiangsuAc01> list= new ArrayList<JiangsuAc01>();
		//if (!StringUtils.isEmpty(jiangsuAc01.getAab002())) {
			list= dao.findList1(jiangsuAc01);
		//} else {
			//list= dao.findList0(jiangsuAc01);
		//}
		/*for(int i=0;i<list.size();i++){
			JiangsuAc01 jiangsuAc012=list.get(i);
			String xzqh=list.get(i).getAar008();
			String xq1=xzqh.substring(0,6);
			xq.concat("000000");
			String xq=xq1+"000000";
			JiangsuAa11 jiangsuAa111=jiangsuAa11Dao.findUniqueByProperty("aar001",xq);
			jiangsuAc012.setXq(jiangsuAa111.getAar009());
			String xz1=xzqh.substring(0,9);
			String xz= xz1.concat("000");
			JiangsuAa11 jiangsuAa112=jiangsuAa11Dao.findUniqueByProperty("aar001",xz);
			jiangsuAc012.setXz(jiangsuAa112.getAar009());
			String cj=xzqh;
			JiangsuAa11 jiangsuAa113=jiangsuAa11Dao.findUniqueByProperty("aar001",cj);
			jiangsuAc012.setCj(jiangsuAa113.getAar009());
		}*/
		/*for(int i=0;i<list.size();i++){
			List<JiangsuAb01> jiangsuAb01s=jiangsuAb01Dao.getHuZhu(list.get(i).getId());
			if(jiangsuAb01s!=null)	{
				JiangsuAb01 jiangsuAb01= null;
				if (!StringUtils.isEmpty(jiangsuAc01.getAab002())) {
					jiangsuAb01 = new JiangsuAb01();
					for(JiangsuAb01 ab01:jiangsuAb01s) {
						if (jiangsuAc01.getAab002().equals(ab01.getAab002())) {
							jiangsuAb01.setAab002(jiangsuAc01.getAab002());
							jiangsuAb01.setAab004(ab01.getAab004());
						}
					}
				} else {
					jiangsuAb01=jiangsuAb01s.get(0);
				}
				JiangsuAc01 jiangsuAc012=list.get(i);
				jiangsuAc012.setJiangsuAb01(jiangsuAb01);
			}
		}*/
		page.setList(list);
		return page;
	}
	
	public List<JiangsuAc01> findListBySfzh(String  sfzh) {
		return jiangsuAc01Dao.findListBySfzh(sfzh);
	}
	
	public List<Map<String, Object>> getXzPkhCount(Integer pkhYear, String xzCode) {
		return jiangsuAc01Dao.getXzPkhCount(pkhYear, xzCode);
	}
	
	@Transactional(readOnly = false)
	public void updateTpndByXqqrid(String xqqrid,String tpnd) {
		jiangsuAc01Dao.updateTpndByXqqrid(xqqrid, tpnd);
	}
	@Transactional(readOnly = false)
	public void updateIsWf(JiangsuAc01 jiangsuAc01) {
		jiangsuAc01Dao.updateIsWf(jiangsuAc01);
		jiangsuAc01Dao.updateZfaqbz(jiangsuAc01);
	}
	
	//已脱贫的危房户信息
	public Page<JiangsuAc01> findListBywfh(Page<JiangsuAc01> page, JiangsuAc01 jiangsuAc01) {
		jiangsuAc01.setPage(page);
		page.setList(dao.findListBywfh(jiangsuAc01));
		return page;
	}
	
	//疑似危房户信息
	public Page<JiangsuAc01> findListByyswfh(Page<JiangsuAc01> page, JiangsuAc01 jiangsuAc01) {
		 jiangsuAc01.setPage(page);
		 page.setList(dao.findListByyswfh(jiangsuAc01));
		 return page;
		}

	//查询危房全改造详情页面
	public JiangsuAc01 getWf(String id) {
		return dao.getWf(id);
	}
	//更新危房全改造备注等信息
	@Transactional(readOnly = false)
	public void updateWf(JiangsuAc01 t) {
		dao.updateWf(t);
	}
}
