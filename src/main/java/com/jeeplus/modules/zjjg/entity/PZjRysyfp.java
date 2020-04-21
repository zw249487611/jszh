/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 人员收益分配Entity
 * @author xj
 * @version 2017-05-16
 */
public class PZjRysyfp extends DataEntity<PZjRysyfp> {
	
	private static final long serialVersionUID = 1L;
	private String nd;		// 年度
	private String zjmc;		// 资金名称
	private String pid;		// 配套资金id
	private String swh;		// 省文号
	private Date bksj;		// 拨款时间
	private String pzh;		// 凭证号
	private BigDecimal je;		// 金额
	private String bkd;		// 拨款单
	private String bkmx;		// 拨款明细
	private String type;		// 资金类型
	private String shzt;		// 审核状态
	private String code;		// 统筹区编号
	
	public PZjRysyfp() {
		super();
	}

	public PZjRysyfp(String id){
		super(id);
	}

	@ExcelField(title="年度", align=2, sort=1)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="资金名称", align=2, sort=2)
	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}
	
	@ExcelField(title="配套资金id", align=2, sort=3)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@ExcelField(title="省文号", align=2, sort=4)
	public String getSwh() {
		return swh;
	}

	public void setSwh(String swh) {
		this.swh = swh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="拨款时间", align=2, sort=5)
	public Date getBksj() {
		return bksj;
	}

	public void setBksj(Date bksj) {
		this.bksj = bksj;
	}
	
	@ExcelField(title="凭证号", align=2, sort=6)
	public String getPzh() {
		return pzh;
	}

	public void setPzh(String pzh) {
		this.pzh = pzh;
	}
	
	@ExcelField(title="金额", align=2, sort=7)
	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}
	
	@ExcelField(title="拨款单", align=2, sort=8)
	public String getBkd() {
		return bkd;
	}

	public void setBkd(String bkd) {
		this.bkd = bkd;
	}
	
	@ExcelField(title="拨款明细", align=2, sort=9)
	public String getBkmx() {
		return bkmx;
	}

	public void setBkmx(String bkmx) {
		this.bkmx = bkmx;
	}
	
	@ExcelField(title="资金类型", align=2, sort=10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="审核状态", align=2, sort=11)
	public String getShzt() {
		return shzt;
	}

	public void setShzt(String shzt) {
		this.shzt = shzt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}