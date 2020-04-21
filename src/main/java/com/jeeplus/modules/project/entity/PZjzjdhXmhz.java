/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 资金直接到户-申报Entity
 * @author cdf
 * @version 2017-03-02
 */
public class PZjzjdhXmhz extends DataEntity<PZjzjdhXmhz> {
	
	private static final long serialVersionUID = 1L;
	private String xh; 	     //序号
	private String szz;		// 所在镇
	private String fchs;		// 扶持户数
	private String fcrs;		// 扶持人数
	private String xms;		// 项目数
	private BigDecimal fczj;		// 扶持资金
	private String nd;  	//年度

	public PZjzjdhXmhz() {
		super();
	}

	public PZjzjdhXmhz(String id){
		super(id);
	}

	@ExcelField(title="序号", align=2, sort=1)
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
	
	@ExcelField(title="年度", align=2, sort=2)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	@ExcelField(title="所在镇", align=2, sort=3)
	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
	}
	
	@ExcelField(title="扶持户数", align=2, sort=4)
	public String getFchs() {
		return fchs;
	}

	public void setFchs(String fchs) {
		this.fchs = fchs;
	}

	@ExcelField(title="扶持人数", align=2, sort=5)
	public String getFcrs() {
		return fcrs;
	}

	public void setFcrs(String fcrs) {
		this.fcrs = fcrs;
	}

	@ExcelField(title="项目数", align=2, sort=6)
	public String getXms() {
		return xms;
	}

	public void setXms(String xms) {
		this.xms = xms;
	}

	@ExcelField(title="扶持资金", align=2, sort=7)
	public BigDecimal getFczj() {
		return fczj;
	}

	public void setFczj(BigDecimal fczj) {
		this.fczj = fczj;
	}
}