/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;


import java.math.BigDecimal;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 数据申报审核Entity
 * @author chenjy
 * @version 2017-04-21
 */
public class PZjSjsbsh extends DataEntity<PZjSjsbsh> {
	
	private static final long serialVersionUID = 1L;
	private String nd;		// 年度
	private String zjmc;		// zjmc
	private String ssq;		// 所属区
	private String spzt;		// 审批状态
	private String bkzt;		// 拨款状态
	private BigDecimal xms;		// xms
	private BigDecimal xdje;		// xdje
	private String type;		// 资金类型（1统筹 2到户）
	
	
	public PZjSjsbsh() {
		super();
	}

	public PZjSjsbsh(String id){
		super(id);
	}

	@ExcelField(title="年度", dictType="", align=2, sort=0)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="zjmc", align=2, sort=2)
	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}
	
	@ExcelField(title="所属区", dictType="", align=2, sort=3)
	public String getSsq() {
		return ssq;
	}

	public void setSsq(String ssq) {
		this.ssq = ssq;
	}
	
	@ExcelField(title="审批状态", align=2, sort=4)
	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}
	
	@ExcelField(title="拨款状态", align=2, sort=5)
	public String getBkzt() {
		return bkzt;
	}

	public void setBkzt(String bkzt) {
		this.bkzt = bkzt;
	}
	
	@ExcelField(title="xms", align=2, sort=6)
	public BigDecimal getXms() {
		return xms;
	}

	public void setXms(BigDecimal xms) {
		this.xms = xms;
	}
	
	@ExcelField(title="xdje", align=2, sort=7)
	public BigDecimal getXdje() {
		return xdje;
	}

	public void setXdje(BigDecimal xdje) {
		this.xdje = xdje;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}