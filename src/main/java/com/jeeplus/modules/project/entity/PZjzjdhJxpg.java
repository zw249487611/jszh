/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.modules.project.entity.PZjzjdhQd;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 绩效评估Entity
 * @author maojl
 * @version 2017-03-07
 */
public class PZjzjdhJxpg extends DataEntity<PZjzjdhJxpg> {
	
	private static final long serialVersionUID = 1L;
	private PZjzjdhQd plxid;		// 项目名称
	private String sbzj;		// 申报资金
	private String shqk;		// 审核情况
	private BigDecimal bfzj;		// 拨付资金
	private String shren;		// 审核人
	private Date shrq;		// 审核日期
	private String jxpgbg;		// 绩效评估报告
	private String sytjb;		// 收益统计表
	
	public PZjzjdhJxpg() {
		super();
	}

	public PZjzjdhJxpg(String id){
		super(id);
	}

	@NotNull(message="项目名称不能为空")
	@ExcelField(title="项目名称", align=2, sort=1)
	public PZjzjdhQd getPlxid() {
		return plxid;
	}

	public void setPlxid(PZjzjdhQd plxid) {
		this.plxid = plxid;
	}
	
	@ExcelField(title="申报资金", align=2, sort=2)
	public String getSbzj() {
		return sbzj;
	}

	public void setSbzj(String sbzj) {
		this.sbzj = sbzj;
	}
	
	@ExcelField(title="审核情况", dictType="", align=2, sort=3)
	public String getShqk() {
		return shqk;
	}

	public void setShqk(String shqk) {
		this.shqk = shqk;
	}
	
	@ExcelField(title="拨付资金", align=2, sort=4)
	public BigDecimal getBfzj() {
		return bfzj;
	}

	public void setBfzj(BigDecimal bfzj) {
		this.bfzj = bfzj;
	}
	
	@ExcelField(title="审核人", align=2, sort=5)
	public String getShren() {
		return shren;
	}

	public void setShren(String shren) {
		this.shren = shren;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="审核日期", align=2, sort=6)
	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}
	
	@ExcelField(title="绩效评估报告", align=2, sort=7)
	public String getJxpgbg() {
		return jxpgbg;
	}

	public void setJxpgbg(String jxpgbg) {
		this.jxpgbg = jxpgbg;
	}
	
	@ExcelField(title="收益统计表", align=2, sort=8)
	public String getSytjb() {
		return sytjb;
	}

	public void setSytjb(String sytjb) {
		this.sytjb = sytjb;
	}
	
}