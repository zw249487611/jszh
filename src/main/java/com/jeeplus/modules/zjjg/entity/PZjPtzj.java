/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 省级资金指标录入Entity
 * @author lhq
 * @version 2017-04-06
 */
public class PZjPtzj extends DataEntity<PZjPtzj> {
	
	private static final long serialVersionUID = 1L;
	private String nd;		// 年度
	private String type;		// 类型
	private String zjid;		// 资金编号
	private String xmmc;		// 资金名称
	private String zjlx;		// 资金类型
	private String jbrxm;		// 经办人姓名
	private BigDecimal xdzj;		// 下达资金
	private BigDecimal spzj;		// 市配资金
	private Date dzrq;		// 到账日期
	private String zjly;		// 资金来源
	
	public PZjPtzj() {
		super();
	}

	public PZjPtzj(String id){
		super(id);
	}

	@ExcelField(title="年度", align=2, sort=1)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="类型", align=2, sort=2)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="资金编号", align=2, sort=3)
	public String getZjid() {
		return zjid;
	}

	public void setZjid(String zjid) {
		this.zjid = zjid;
	}
	
	@ExcelField(title="资金名称", align=2, sort=4)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@ExcelField(title="资金类型", align=2, sort=5)
	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	
	@ExcelField(title="经办人姓名", align=2, sort=6)
	public String getJbrxm() {
		return jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}
	
	@NotNull(message="下达资金不能为空")
	@ExcelField(title="下达资金", align=2, sort=7)
	public BigDecimal getXdzj() {
		return xdzj;
	}

	public void setXdzj(BigDecimal xdzj) {
		this.xdzj = xdzj;
	}
	
	@ExcelField(title="市配资金", align=2, sort=8)
	public BigDecimal getSpzj() {
		return spzj;
	}

	public void setSpzj(BigDecimal spzj) {
		this.spzj = spzj;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="到账日期不能为空")
	@ExcelField(title="到账日期", align=2, sort=9)
	public Date getDzrq() {
		return dzrq;
	}

	public void setDzrq(Date dzrq) {
		this.dzrq = dzrq;
	}

	public String getZjly() {
		return zjly;
	}

	public void setZjly(String zjly) {
		this.zjly = zjly;
	}
	
}