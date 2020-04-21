package com.jeeplus.modules.app.vo;

import java.io.Serializable;

import com.jeeplus.common.persistence.DataEntity;


public class AppQdxxInfoVo extends DataEntity<AppQdxxInfoVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	//脱贫情况编号
	private String tpqkid;
	//信息采集地点
	private String xxcjdd;
	//经度
	private String lng;
	//纬度
	private String lat;
	//季度
	private String jd;
	//年度
	private String nd;
	public String getTpqkid() {
		return tpqkid;
	}
	public void setTpqkid(String tpqkid) {
		this.tpqkid = tpqkid;
	}
	public String getXxcjdd() {
		return xxcjdd;
	}
	public void setXxcjdd(String xxcjdd) {
		this.xxcjdd = xxcjdd;
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
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
}
