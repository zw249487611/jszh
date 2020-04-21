/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;


/**
 * 绩效评估Entity
 * @author xuj
 * @version 2017-03-29
 */
public class PkhrjsrInfoVo{
	
	private static final long serialVersionUID = 1L;
	//年度
	private String nd;
	//人均收入
	private float rjsr;
	//区域编号
	private String qybh;
	//日期
	private String rq;
	//走访次数
	private int zfcs;
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public float getRjsr() {
		return rjsr;
	}
	public void setRjsr(float rjsr) {
		this.rjsr = rjsr;
	}
	public String getQybh() {
		return qybh;
	}
	public void setQybh(String qybh) {
		this.qybh = qybh;
	}
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	public int getZfcs() {
		return zfcs;
	}
	public void setZfcs(int zfcs) {
		this.zfcs = zfcs;
	}
	
}