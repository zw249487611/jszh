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
public class PZjzjdhXmsbCunExp extends DataEntity<PZjzjdhXmsbCunExp> {
	
	private static final long serialVersionUID = 1L;
	private String xuhao;		// 项目序号
	private String nd;			//年度
	private String szs;		// 所在村
	private String szzu;		// 所在组
	private String xmmc;		// 项目名称
	private String hzxm;		// 户主姓名
	private BigDecimal sqczzj;		// 申请财政资金
	private BigDecimal yqsy;		// 预期收益
	private String sarea_id;
	public PZjzjdhXmsbCunExp() {
		super();
	}

	public PZjzjdhXmsbCunExp(String id){
		super(id);
	}

	@ExcelField(title="序号", align=2, sort=1)
	public String getXuhao() {
		return xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	
	@ExcelField(title="年度", align=2, sort=2)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	@ExcelField(title="所在村", align=2, sort=5)
	public String getSzs() {
		return szs;
	}

	

	public void setSzs(String szs) {
		this.szs = szs;
	}
	
	@ExcelField(title="所在组", align=2, sort=6)
	public String getSzzu() {
		return szzu;
	}

	public void setSzzu(String szzu) {
		this.szzu = szzu;
	}
	
	@ExcelField(title="户主姓名", align=2, sort=9)
	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}
	
	@ExcelField(title="项目名称", align=2, sort=7)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@NotNull(message="申请财政资金不能为空")
	@ExcelField(title="申请财政资金", align=2, sort=20)
	public BigDecimal getSqczzj() {
		return sqczzj;
	}

	public void setSqczzj(BigDecimal sqczzj) {
		this.sqczzj = sqczzj;
	}
	
	
	
	@ExcelField(title="预期收益", align=2, sort=27)
	public BigDecimal getYqsy() {
		return yqsy;
	}

	public void setYqsy(BigDecimal yqsy) {
		this.yqsy = yqsy;
	}

	public String getSarea_id() {
		return sarea_id;
	}

	public void setSarea_id(String sarea_id) {
		this.sarea_id = sarea_id;
	}
	
	
	
}