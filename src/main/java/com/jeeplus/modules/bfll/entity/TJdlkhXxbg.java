/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 建档立卡信息变更履历Entity
 * @author 王彧
 * @version 2017-11-07
 */
public class TJdlkhXxbg extends DataEntity<TJdlkhXxbg> {
	
	private static final long serialVersionUID = 1L;
	private String acid;		// 贫困户编号
	private String bglx;		// 变更类型(1:精准识别；2:基本信息修改；3:精准脱贫;4:新增贫困户;5:修改贫困户;6:删除贫困户;7:新增家庭成员;8:修改家庭成员;9:删除家庭成员;)
	private String nd;			// 年度
	private String acidBak; 	// 贫困户备份表编号
	private String bgyy;		// 变更原因
	private String hzxm;		// 户主姓名
	private String xqname;		// 县区名称
	private String xzname;		// 乡镇名称
	private String cunname;		// 村名称
	
	private String xq;//县区
	private String xz;
	private String xc;
	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}

	public TJdlkhXxbg() {
		super();
	}

	public TJdlkhXxbg(String id){
		super(id);
	}

	@ExcelField(title="贫困户编号", align=2, sort=1)
	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}
	
	@ExcelField(title="变更类型(1:精准识别；2:基本信息修改；3:精准脱贫)", align=2, sort=2)
	public String getBglx() {
		return bglx;
	}

	public void setBglx(String bglx) {
		this.bglx = bglx;
	}
	
	@ExcelField(title="年度", align=2, sort=3)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getAcidBak() {
		return acidBak;
	}

	public void setAcidBak(String acidBak) {
		this.acidBak = acidBak;
	}

	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getXqname() {
		return xqname;
	}

	public void setXqname(String xqname) {
		this.xqname = xqname;
	}

	public String getXzname() {
		return xzname;
	}

	public void setXzname(String xzname) {
		this.xzname = xzname;
	}

	public String getCunname() {
		return cunname;
	}

	public void setCunname(String cunname) {
		this.cunname = cunname;
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getXc() {
		return xc;
	}

	public void setXc(String xc) {
		this.xc = xc;
	}
	
}