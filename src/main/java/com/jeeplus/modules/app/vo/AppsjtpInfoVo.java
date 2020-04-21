package com.jeeplus.modules.app.vo;

import java.io.Serializable;

import com.jeeplus.common.persistence.DataEntity;

public class AppsjtpInfoVo extends DataEntity<AppsjtpInfoVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	//贫困户编号
	private String pkhbh;
	//文件路径
	private String wjlj;
	//登录人id
	private String loginId;
	//新增标识
	private String xzbs;
	//
	private String tempDate;
	//季度
	private String jd;
	//年度
	private String nd;
	private String pkcbh;// 贫困村编号
	private String bfrbh;
	private String createDateTime;
	public String getPkhbh() {
		return pkhbh;
	}
	public void setPkhbh(String pkhbh) {
		this.pkhbh = pkhbh;
	}
	public String getWjlj() {
		return wjlj;
	}
	public void setWjlj(String wjlj) {
		this.wjlj = wjlj;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getXzbs() {
		return xzbs;
	}
	public void setXzbs(String xzbs) {
		this.xzbs = xzbs;
	}
	public String getTempDate() {
		return tempDate;
	}
	public void setTempDate(String tempDate) {
		this.tempDate = tempDate;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getPkcbh() {
		return pkcbh;
	}
	public void setPkcbh(String pkcbh) {
		this.pkcbh = pkcbh;
	}
	public String getBfrbh() {
		return bfrbh;
	}
	public void setBfrbh(String bfrbh) {
		this.bfrbh = bfrbh;
	}
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	
}
