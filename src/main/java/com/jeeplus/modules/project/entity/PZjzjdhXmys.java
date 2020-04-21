/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.modules.project.entity.PZjzjdhXmsb;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 项目验收Entity
 * @author maojl
 * @version 2017-03-07
 */
public class PZjzjdhXmys extends DataEntity<PZjzjdhXmys> {
	
	private static final long serialVersionUID = 1L;
	private PZjzjdhXmsb plxid;		// 项目名称
	private String ysr;		// 验收人
	private Date yssj;		// 验收时间
	private BigDecimal bfzj;		// 拨付资金
	private String sftg;		// 是否通过
	private String ysqk;		// 验收情况
	private Date shrq;		// 审核日期
	private String xmysbg;		// 项目验收报告
	private String xmsszp;		// 典型增收项目实施照片
	private Date beginYssj;		// 开始 验收时间
	private Date endYssj;		// 结束 验收时间
	private String xmmc; 		//项目名称
	public PZjzjdhXmys() {
		super();
	}

	public PZjzjdhXmys(String id){
		super(id);
	}

	@ExcelField(title="项目名称", align=2, sort=1)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@NotNull(message="项目名称不能为空")
	public PZjzjdhXmsb getPlxid() {
		return plxid;
	}

	public void setPlxid(PZjzjdhXmsb plxid) {
		this.plxid = plxid;
	}
	
	@ExcelField(title="验收人", align=2, sort=2)
	public String getYsr() {
		return ysr;
	}

	public void setYsr(String ysr) {
		this.ysr = ysr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="验收时间不能为空")
	@ExcelField(title="验收时间", align=2, sort=3)
	public Date getYssj() {
		return yssj;
	}

	public void setYssj(Date yssj) {
		this.yssj = yssj;
	}
	
	@NotNull(message="拨付资金不能为空")
	@ExcelField(title="拨付资金", align=2, sort=4)
	public BigDecimal getBfzj() {
		return bfzj;
	}

	public void setBfzj(BigDecimal bfzj) {
		this.bfzj = bfzj;
	}
	
	@ExcelField(title="是否通过", dictType="", align=2, sort=7)
	public String getSftg() {
		return sftg;
	}

	public void setSftg(String sftg) {
		this.sftg = sftg;
	}
	
	@ExcelField(title="验收情况", dictType="ysqk", align=2, sort=5)
	public String getYsqk() {
		return ysqk;
	}

	public void setYsqk(String ysqk) {
		this.ysqk = ysqk;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="审核日期", align=2, sort=6)
	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}
	
	@ExcelField(title="项目验收报告", align=2, sort=7)
	public String getXmysbg() {
		return xmysbg;
	}

	public void setXmysbg(String xmysbg) {
		this.xmysbg = xmysbg;
	}
	
	@ExcelField(title="典型增收项目实施照片", align=2, sort=8)
	public String getXmsszp() {
		return xmsszp;
	}

	public void setXmsszp(String xmsszp) {
		this.xmsszp = xmsszp;
	}
	
	public Date getBeginYssj() {
		return beginYssj;
	}

	public void setBeginYssj(Date beginYssj) {
		this.beginYssj = beginYssj;
	}
	
	public Date getEndYssj() {
		return endYssj;
	}

	public void setEndYssj(Date endYssj) {
		this.endYssj = endYssj;
	}
		
}