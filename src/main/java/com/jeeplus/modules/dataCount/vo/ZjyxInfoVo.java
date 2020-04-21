/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;

import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;

/**
 * 资金运行信息Entity
 * @author maojl
 * @version 2017-09-04
 */
public class ZjyxInfoVo extends DataEntity<ZjyxInfoVo> {
	
	private static final long serialVersionUID = 1L;
	private String xmid;//项目id	
	private String nd;//年度	
	private String zjmc;//资金名称
	private String fpdxmje;//分配到项目资金额（万元）
	private String bkje;//拨款金额（万元）
	private Date bkrq;//拨款日期
	private String bkdw;//拨款单位
	
	public String getXmid() {
		return xmid;
	}
	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getZjmc() {
		return zjmc;
	}
	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}
	public String getFpdxmje() {
		return fpdxmje;
	}
	public void setFpdxmje(String fpdxmje) {
		this.fpdxmje = fpdxmje;
	}
	public String getBkje() {
		return bkje;
	}
	public void setBkje(String bkje) {
		this.bkje = bkje;
	}
	public Date getBkrq() {
		return bkrq;
	}
	public void setBkrq(Date bkrq) {
		this.bkrq = bkrq;
	}
	public String getBkdw() {
		return bkdw;
	}
	public void setBkdw(String bkdw) {
		this.bkdw = bkdw;
	}
}