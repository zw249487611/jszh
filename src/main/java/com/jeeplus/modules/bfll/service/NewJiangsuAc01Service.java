/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.modules.bfll.dao.NewJiangsuAb01Dao;
import com.jeeplus.modules.bfll.dao.NewJiangsuAc01Dao;
import com.jeeplus.modules.bfll.dao.NewJiangsuAc07Dao;
import com.jeeplus.modules.bfll.entity.NewJiangsuAb01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc01E;
import com.jeeplus.modules.bfll.entity.NewJiangsuAc07;
import com.jeeplus.modules.project.entity.Const;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.service.AreaService;
import com.jeeplus.modules.sys.service.DictService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 贫困户基本信息Service
 * @author hwm
 * @version 2017-05-09
 */
@Service
@Transactional(readOnly = true)
public class NewJiangsuAc01Service extends CrudService<NewJiangsuAc01Dao, NewJiangsuAc01> {

	@Autowired
	private NewJiangsuAc07Dao jiangsuAc07Dao;
	@Autowired
	private NewJiangsuAb01Dao newJiangsuAb01Dao;
	@Autowired
	private NewJiangsuAc01Dao newJiangsuAc01Dao;
	
	@Autowired
	private DictService dictService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private TJdlkhXxbgService tJdlkhXxbgService;

	
	public NewJiangsuAc01 get(String id) {
		return super.get(id);
	}
	
	public NewJiangsuAc01 getBak(String id) {
		return dao.getBak(id);
	}
	
	public List<NewJiangsuAc01> findList(NewJiangsuAc01 jiangsuAc01) {
		return super.findList(jiangsuAc01);
	}
	
	public Page<NewJiangsuAc01> findPage(Page<NewJiangsuAc01> page, NewJiangsuAc01 jiangsuAc01) {
		return super.findPage(page, jiangsuAc01);
	}
//	zhangwei新加导出
	public Page<NewJiangsuAc01E> findPage2(Page<NewJiangsuAc01E> page, NewJiangsuAc01E newJiangsuAc01) {
		newJiangsuAc01.setPage(page);
		page.setList(newJiangsuAc01Dao.findListExport(newJiangsuAc01));
		return page;
	}
	
	
	public Page<NewJiangsuAc01> findPage1(Page<NewJiangsuAc01> page, NewJiangsuAc01 jiangsuAc01) {
		jiangsuAc01.setPage(page);
		List<NewJiangsuAc01> list= new ArrayList<NewJiangsuAc01>();
		list = dao.findList1(jiangsuAc01);
		/*for(int i=0;i<list.size();i++){
			List<NewJiangsuAb01> jiangsuAb01s=newJiangsuAb01Dao.getHuZhu(list.get(i).getId());
			if(jiangsuAb01s!=null && jiangsuAb01s.size()>0)	{
				NewJiangsuAb01 jiangsuAb01= null;
				if (!StringUtils.isEmpty(jiangsuAc01.getAab002())) {
					jiangsuAb01 = new NewJiangsuAb01();
					for(NewJiangsuAb01 ab01:jiangsuAb01s) {
						if (jiangsuAc01.getAab002().equals(ab01.getAab002())) {
							jiangsuAb01.setAab002(jiangsuAc01.getAab002());
							jiangsuAb01.setAab004(ab01.getAab004());
						}
					}
				} else {
					jiangsuAb01=jiangsuAb01s.get(0);
				}
				NewJiangsuAc01 jiangsuAc012=list.get(i);
				jiangsuAc012.setNewJiangsuAb01(jiangsuAb01);
			}
		}*/
		page.setList(list);
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(NewJiangsuAc01 jiangsuAc01) {
		if(!StringUtils.isEmpty(jiangsuAc01.getCurrentAreaId())){
			Area area= areaService.get(jiangsuAc01.getCurrentAreaId());
			if(area.getType().equals("6")){
				jiangsuAc01.setAar006(area.getId());
				jiangsuAc01.setAar005(area.getParentId());
				area= areaService.get(area.getParentId());
				jiangsuAc01.setAar004(area.getParentId());
			}else if(area.getType().equals("5")){
				jiangsuAc01.setAar005(area.getId());
				jiangsuAc01.setAar004(area.getParentId());
			}else if(area.getType().equals("4")){
				jiangsuAc01.setAar004(area.getId());
			}
		}
		jiangsuAc01.setAar001(jiangsuAc01.getAar006());
		jiangsuAc01.setAar008(jiangsuAc01.getAar006());
		jiangsuAc01.setAdid(jiangsuAc01.getAar006());
		if (jiangsuAc01.getNewJiangsuAb01s() != null) {
			List<NewJiangsuAb01> ab01s = jiangsuAc01.getNewJiangsuAb01s();
			if(ab01s.size() > 0){
				jiangsuAc01.setJtrks(ab01s.size());
				for(NewJiangsuAb01 ab01:ab01s){
					if(ab01.getAab006().equals("01")){
						jiangsuAc01.setHzxm(ab01.getAab002());
						jiangsuAc01.setHzsfzh(ab01.getAab004());
						break;
					}
				}
			}
			
		}
		if (jiangsuAc01.getIsNewRecord()) {
			int lastYear = Integer.parseInt(DateUtils.getYear())-1;
			String hzsfzh = jiangsuAc01.getHzsfzh();
			List<NewJiangsuAb01> ab01List = newJiangsuAb01Dao.findListByHzsfzh(hzsfzh);
			//若ab01贫困人口表里有身份证对应的人口，将对应的户编号取出来拼接成新的贫困户id
			if(ab01List.size()>0){
				String acid=ab01List.get(0).getAcid();
				String acid_new = lastYear+acid.substring(4, acid.length());
				jiangsuAc01.setId(acid_new);
			}else{
				jiangsuAc01.preInsert();
				String pre4Aar006 = jiangsuAc01.getAar006().substring(0, 4);
				jiangsuAc01.setId(lastYear + pre4Aar006 + dictService.getIncrementId("1"));
			}
			jiangsuAc01.setCreateBy(UserUtils.getUser());
			jiangsuAc01.setCreateDate(new Date());
			jiangsuAc01.setUpdateBy(UserUtils.getUser());
			jiangsuAc01.setUpdateDate(new Date());
			dao.insert(jiangsuAc01);
			
			//插入贫困户备份表ac01_bak数据
			NewJiangsuAc01 ac01Bak  = new NewJiangsuAc01();
			try {
				MyBeanUtils.copyBeanNotNull2Bean(jiangsuAc01, ac01Bak);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ac01Bak.setId(null);
			ac01Bak.preInsert();
			dao.insertAc01Bak(ac01Bak);
			
			//插入贫困户收入信息
			NewJiangsuAc07 ac07=jiangsuAc01.getNewJiangsuAc07();
			if(ac07 != null){
				ac07.preInsert();
				ac07.setAcid(jiangsuAc01.getId());
				ac07.setAar001(jiangsuAc01.getAar006());
				ac07.setAar008(jiangsuAc01.getAar006());
				ac07.setAar040(String.valueOf(jiangsuAc01.getAar040()+1));
				ac07.setCreateBy(UserUtils.getUser());
				ac07.setCreateDate(new Date());
				ac07.setUpdateBy(UserUtils.getUser());
				ac07.setUpdateDate(new Date());
				jiangsuAc07Dao.insert(ac07);
			}
			
			//插入贫困户人口信息
			if (jiangsuAc01.getNewJiangsuAb01s() != null) {
				List<NewJiangsuAb01> ab01s = jiangsuAc01.getNewJiangsuAb01s();
				if (ab01s.size() > 0) {
					for (int i = 0; i < ab01s.size(); i++) {
						NewJiangsuAb01 newJiangsuAb01 = ab01s.get(i);
						newJiangsuAb01.preInsert();
						newJiangsuAb01.setId(dictService.getIncrementId("1"));
						newJiangsuAb01.setAcid(jiangsuAc01.getId());
						newJiangsuAb01.setAar001(jiangsuAc01.getAar006());
						newJiangsuAb01.setAar008(jiangsuAc01.getAar006());
						newJiangsuAb01.setAar040(jiangsuAc01.getAar040());
						newJiangsuAb01.setCreateBy(UserUtils.getUser());
						newJiangsuAb01.setCreateDate(new Date());
						newJiangsuAb01.setUpdateBy(UserUtils.getUser());
						newJiangsuAb01.setUpdateDate(new Date());
						newJiangsuAb01Dao.insert(newJiangsuAb01);
						
						//插入贫困人口备份表ab01_bak数据
						newJiangsuAb01.setId(null);
						newJiangsuAb01.preInsert();
						newJiangsuAb01.setAcid(ac01Bak.getId());
						newJiangsuAb01Dao.insertAb01Bak(newJiangsuAb01);
					}
				}
			}
			//贫困户变更信息表插入记录
			tJdlkhXxbgService.saveTJdlkhXxbg(jiangsuAc01,ac01Bak.getId(),Const.JdLKHBGLX_4);
		} else {
			
			//插入贫困户收入信息,若有帮扶人信息，则不修改收入信息，否则更新
			NewJiangsuAc07 ac07=jiangsuAc01.getNewJiangsuAc07();
			ac07.setAcid(jiangsuAc01.getId());
			ac07.setAar001(jiangsuAc01.getAar006());
			ac07.setAar008(jiangsuAc01.getAar006());
			ac07.setAar040(String.valueOf(jiangsuAc01.getAar040()+1));
			ac07.setUpdateBy(UserUtils.getUser());
			ac07.setUpdateDate(new Date());
			jiangsuAc07Dao.update(ac07);
			
			String bglx = compareBean(jiangsuAc01);
			if(!"".equals(bglx)){
				//插入贫困户备份表ac01_bak数据
				NewJiangsuAc01 ac01Bak  = dao.get(jiangsuAc01.getId());
				ac01Bak.setId(null);
				ac01Bak.preInsert();
				dao.insertAc01Bak(ac01Bak);
				
				//更新贫困户基本信息
				jiangsuAc01.preUpdate();
				dao.update(jiangsuAc01);
				
				List<NewJiangsuAb01> jiangsuAb01s = newJiangsuAb01Dao.findByAcid(jiangsuAc01.getId());
				if (jiangsuAb01s != null) {
					for (int i = 0; i < jiangsuAb01s.size(); i++) {
						NewJiangsuAb01 newJiangsuAb01 = jiangsuAb01s.get(i);
						//插入贫困人口备份表ab01_bak数据
						newJiangsuAb01.setId(null);
						newJiangsuAb01.preInsert();
						newJiangsuAb01.setAcid(ac01Bak.getId());
						newJiangsuAb01Dao.insertAb01Bak(newJiangsuAb01);
						}
				}
				List<NewJiangsuAb01> ab01s = jiangsuAc01.getNewJiangsuAb01s();
				jiangsuAb01s = newJiangsuAb01Dao.findByAcid(jiangsuAc01.getId());
				if (ab01s != null) {
					List<String> list = new ArrayList<String>();
					for (int i = 0; i < ab01s.size(); i++) {
						if (!StringUtils.isEmpty(ab01s.get(i).getId())) {
							list.add(ab01s.get(i).getId());
						}
					}
					if (jiangsuAb01s != null) {
						for (int i = 0; i < jiangsuAb01s.size(); i++) {
							boolean b = list.contains(jiangsuAb01s.get(i).getId());
							if (b == false) {
								newJiangsuAb01Dao.deleteByLogic(jiangsuAb01s.get(i));
							}
						}
					}
				} else {
					if (jiangsuAb01s != null) {
						for (int i = 0; i < jiangsuAb01s.size(); i++) {
							newJiangsuAb01Dao.deleteByLogic(jiangsuAb01s.get(i));
						}
					}
				}
	
				if (ab01s != null) {
					for (int i = 0; i < ab01s.size(); i++) {
						NewJiangsuAb01 newJiangsuAb01 = ab01s.get(i);
						if (newJiangsuAb01.getIsNewRecord()) {
							newJiangsuAb01.preInsert();
							newJiangsuAb01.setId(dictService.getIncrementId("1"));
							newJiangsuAb01.setAcid(jiangsuAc01.getId());
							newJiangsuAb01.setAar001(jiangsuAc01.getAar006());
							newJiangsuAb01.setAar008(jiangsuAc01.getAar006());
							newJiangsuAb01.setAar040(jiangsuAc01.getAar040());
							newJiangsuAb01.setCreateBy(UserUtils.getUser());
							newJiangsuAb01.setCreateDate(new Date());
							newJiangsuAb01.setUpdateBy(UserUtils.getUser());
							newJiangsuAb01.setUpdateDate(new Date());
							newJiangsuAb01Dao.insert(newJiangsuAb01);
							
						} else {
							newJiangsuAb01.setAcid(jiangsuAc01.getId());
							newJiangsuAb01.setAar001(jiangsuAc01.getAar006());
							newJiangsuAb01.setAar008(jiangsuAc01.getAar006());
							newJiangsuAb01.setAar040(jiangsuAc01.getAar040());
							newJiangsuAb01.setUpdateBy(UserUtils.getUser());
							newJiangsuAb01.setUpdateDate(new Date());
							newJiangsuAb01.preUpdate();
							newJiangsuAb01Dao.update(newJiangsuAb01);
						}
					}
				}
				//贫困户变更信息表插入记录
				tJdlkhXxbgService.saveTJdlkhXxbg(jiangsuAc01,ac01Bak.getId(),bglx);
			}	
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(NewJiangsuAc01 jiangsuAc01) {
		dao.insertAc01Bak(jiangsuAc01);
		super.delete(jiangsuAc01);
	}
	@Transactional(readOnly = false)
	public void insertEntuty(NewJiangsuAc01 jiangSuAc01) {
		newJiangsuAc01Dao.insert(jiangSuAc01);
	}
	
	/**
	 * 比较贫困户信息是否有差异
	 * @param newJiangsuAc01
	 * @return bglx
	 */
	public String compareBean(NewJiangsuAc01 newJiangsuAc01){
		if(newJiangsuAc01 == null){
			newJiangsuAc01 = new NewJiangsuAc01();
		}
		String bglx=",";
		String jab01Str = "";
		String str = newJiangsuAc01.toString();
		NewJiangsuAc01 jac01= dao.get(newJiangsuAc01.getId());
		if(jac01 != null){
			List<NewJiangsuAb01> jab01s = newJiangsuAb01Dao.findByAcid(jac01.getId());
			jac01.setNewJiangsuAb01s(jab01s);
		}
		if(jac01 == null){
			jac01 = new NewJiangsuAc01();
		}
		String str2 = jac01.toString();
		if(!str.equals(str2)){
			bglx = bglx + Const.JdLKHBGLX_5 +",";
		}
		if(newJiangsuAc01.getSfzcxpk() != null && jac01.getSfzcxpk() != null){
			if(!newJiangsuAc01.getSfzcxpk().equals(jac01.getSfzcxpk())){
				bglx = bglx + Const.JdLKHBGLX_10 +",";
			}
		}else if(newJiangsuAc01.getSfzcxpk() == null && jac01.getSfzcxpk() == null){
			//
		}else{
			bglx = bglx + Const.JdLKHBGLX_10 +",";
		}
		if(newJiangsuAc01.getZcxpkyy() != null && jac01.getZcxpkyy() != null){
			if(!newJiangsuAc01.getZcxpkyy().equals(jac01.getZcxpkyy())){
				bglx = bglx + Const.JdLKHBGLX_11 +",";
			}
		}else if(newJiangsuAc01.getZcxpkyy() == null && jac01.getZcxpkyy() == null){
			//
		}else{
			bglx = bglx + Const.JdLKHBGLX_11 +",";
		}
		int size1 = 0;
		int size2 = 0;
		if(jac01.getNewJiangsuAb01s() != null){
			size2 = jac01.getNewJiangsuAb01s().size();
			for (NewJiangsuAb01 jab01 : jac01.getNewJiangsuAb01s()) {
				jab01Str = jab01Str + jab01.toString();
			}
		}
		if(newJiangsuAc01.getNewJiangsuAb01s() != null){
			size1 = newJiangsuAc01.getNewJiangsuAb01s().size();
			for (NewJiangsuAb01 newJiangsuAb01 : newJiangsuAc01.getNewJiangsuAb01s()) {
				if (newJiangsuAb01.getId() != null && !jab01Str.equals("") && !jab01Str.contains(newJiangsuAb01.toString())) {
					bglx = bglx + Const.JdLKHBGLX_8 + ",";
				}
			}
		}
		if (size1 < size2) {
			bglx = bglx + Const.JdLKHBGLX_9 + ",";
		} else if (size1 > size2) {
			bglx = bglx + Const.JdLKHBGLX_7 + ",";
		}
		if(bglx.equals(",")){
			return "";
		}
		return bglx.substring(1,bglx.length()-1);
	}
	/**
	 * 总人数
	 * @param jiangsuAc01
	 * @return
	 */
	public int gettotalCount(NewJiangsuAc01 jiangsuAc01){
		int total = newJiangsuAb01Dao.gettotalCount(jiangsuAc01);
		return total;
	}
	/**
	 * 恢复贫困户及贫困人口
	 * @param acid
	 */
	public void ret(String acid){
		//恢复贫困户
		newJiangsuAc01Dao.returnAc01(acid);
		//恢复贫困人口
		newJiangsuAc01Dao.returnAb01(acid);
	}
}