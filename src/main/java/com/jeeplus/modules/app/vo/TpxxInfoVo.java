package com.jeeplus.modules.app.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jeeplus.common.persistence.DataEntity;

public class TpxxInfoVo extends DataEntity<TpxxInfoVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	//人均收入(采集)
	private BigDecimal rjsrcj;
	//预计全年收入
	private BigDecimal yjqnsr;
	//其它收入
	private BigDecimal qtsr;
	//工资性收入
	private BigDecimal gzxsr;
	//生产经营性收入
	private BigDecimal scjyxsr;
	//财产性收入
	private BigDecimal ccxsr;
	//转移性收入
	private BigDecimal zyxsr;
	//总收入
	private BigDecimal zsr;
	//人均收入
	private BigDecimal rjsj;
	//签字确认附件
	private String qzqrfj;
	//签字确认附件集合
	private List<String> qzqrfjList;
	//脱贫年度
	private String tpnd;
	//公示材料
	private String gscl;
	//公示材料集合
	private List<String> gsclList;
	//审核人
	private String shr;
	//审核日期
	private Date shsj;
	//ac01年度
	private String nd;
	//户编号
	private String hbh;
	
	public BigDecimal getRjsrcj() {
		return rjsrcj;
	}
	public void setRjsrcj(BigDecimal rjsrcj) {
		this.rjsrcj = rjsrcj;
	}
	public BigDecimal getYjqnsr() {
		return yjqnsr;
	}
	public void setYjqnsr(BigDecimal yjqnsr) {
		this.yjqnsr = yjqnsr;
	}
	public BigDecimal getQtsr() {
		return qtsr;
	}
	public void setQtsr(BigDecimal qtsr) {
		this.qtsr = qtsr;
	}
	public BigDecimal getGzxsr() {
		return gzxsr;
	}
	public void setGzxsr(BigDecimal gzxsr) {
		this.gzxsr = gzxsr;
	}
	public BigDecimal getScjyxsr() {
		return scjyxsr;
	}
	public void setScjyxsr(BigDecimal scjyxsr) {
		this.scjyxsr = scjyxsr;
	}
	public BigDecimal getCcxsr() {
		return ccxsr;
	}
	public void setCcxsr(BigDecimal ccxsr) {
		this.ccxsr = ccxsr;
	}
	public BigDecimal getZyxsr() {
		return zyxsr;
	}
	public void setZyxsr(BigDecimal zyxsr) {
		this.zyxsr = zyxsr;
	}
	public BigDecimal getZsr() {
		return zsr;
	}
	public void setZsr(BigDecimal zsr) {
		this.zsr = zsr;
	}
	public BigDecimal getRjsj() {
		return rjsj;
	}
	public void setRjsj(BigDecimal rjsj) {
		this.rjsj = rjsj;
	}
	public String getQzqrfj() {
		return qzqrfj;
	}
	public void setQzqrfj(String qzqrfj) {
		this.qzqrfj = qzqrfj;
	}
	public List<String> getQzqrfjList() {
		return qzqrfjList;
	}
	public void setQzqrfjList(List<String> qzqrfjList) {
		this.qzqrfjList = qzqrfjList;
	}
	public String getTpnd() {
		return tpnd;
	}
	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}
	public String getGscl() {
		return gscl;
	}
	public void setGscl(String gscl) {
		this.gscl = gscl;
	}
	public List<String> getGsclList() {
		return gsclList;
	}
	public void setGsclList(List<String> gsclList) {
		this.gsclList = gsclList;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public Date getShsj() {
		return shsj;
	}
	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getHbh() {
		return hbh;
	}
	public void setHbh(String hbh) {
		this.hbh = hbh;
	}
	
	
}
