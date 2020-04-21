/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 资金直接到户-申报Entity
 * 
 * @author cdf
 * @version 2017-03-02
 */
public class ItemListExportZjdh extends DataEntity<ItemListExportZjdh> {

	private static final long serialVersionUID = 1L;
	private String fpid; // 项目编号
	private String xmmc; // 项目名称
	private String xm;   // 农户姓名
	private Integer rs;  // 人口数
	private String szx;  // 所在县
	private String szz;  // 所在镇
	private String szc;  // 所在村
	private String sfzh; // 身份证号
	private String lxfs; // 电话号码
	private String kh;   // 一折通卡号
	private Double xdje; // 下达金额
	private String nd;   // 年度
	private String zjid; // 资金编号
	private String zjmc; // 资金名称
	private String spzt; // 审批状态
	private String type; // 项目类型
	private String code; // 统筹区编号
	
	private String szzu; // 所在组

	@ExcelField(title="项目编号", align=2, sort=1)
	public String getFpid() {
		return fpid;
	}

	public void setFpid(String fpid) {
		this.fpid = fpid;
	}

	@ExcelField(title="项目名称", align=2, sort=2)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@ExcelField(title="农户姓名", align=2, sort=3)
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@ExcelField(title="贫困人口数", align=2, sort=4)
	public Integer getRs() {
		return rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	@ExcelField(title="所在县", align=2, sort=5)
	public String getSzx() {
		return szx;
	}

	public void setSzx(String szx) {
		this.szx = szx;
	}

	@ExcelField(title="所在镇", align=2, sort=6)
	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
	}

	@ExcelField(title="所在村", align=2, sort=7)
	public String getSzc() {
		return szc;
	}

	public void setSzc(String szc) {
		this.szc = szc;
	}

	@ExcelField(title="身份证号", align=2, sort=8)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	@ExcelField(title="联系方式", align=2, sort=9)
	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	@ExcelField(title="一折通卡号", align=2, sort=10)
	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public Double getXdje() {
		return xdje;
	}

	public void setXdje(Double xdje) {
		this.xdje = xdje;
	}

	@ExcelField(title="年度", align=2, sort=11)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getZjid() {
		return zjid;
	}

	public void setZjid(String zjid) {
		this.zjid = zjid;
	}

	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSzzu() {
		return szzu;
	}

	public void setSzzu(String szzu) {
		this.szzu = szzu;
	}

}