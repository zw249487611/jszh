/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import javax.validation.constraints.NotNull;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 人员数据上报Entity
 * @author lhq
 * @version 2017-03-08
 */
public class PZjRysjsbImport extends DataEntity<PZjRysjsbImport> {
	
	private static final long serialVersionUID = 1L;
	private String fpid;		// 方案分配编号
	private String xmmc;		// 项目名称
	private String spr;			// 审批人
	private Date sprq;			// 审批日期
	private String spzt;		// 审批状态
	private String xm;			// 姓名
	private String sfzh;		// 身份证号
	private String ssq;			// 所属区
	private String ssx;			// 所属乡
	private String ssc;			// 所属村
	private Integer rs;			// 人数
	private String lxfs;		// 联系方式
	private String kh;			// 卡号
	private Double xdje;		// 下达金额
	private String fpfa;		// 分配方案
	private String bksq;		// 拨款申请
	private String qtwj;		// 其他文件
	private String code;		// 统筹区编号
	private String type;		// 类型
	private String bkid;
	private String bkzt;
	private Date bksj;
	private String zjid;
	private String zjmc;
	private String nd;			//年度
	private String ztbm;		//状态编码

	@NotNull(message="方案分配编号不能为空")
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

	@NotNull(message="人数不能为空")
	@ExcelField(title="贫困人口数", align=2, sort=4)
	public Integer getRs() {
		return rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}
	
	@ExcelField(title="所在县", align=2, sort=5)
	public String getSsq() {
		return ssq;
	}

	public void setSsq(String ssq) {
		this.ssq = ssq;
	}
	
	@ExcelField(title="所在镇", align=2, sort=6)
	public String getSsx() {
		return ssx;
	}

	public void setSsx(String ssx) {
		this.ssx = ssx;
	}
	
	@ExcelField(title="所在村", align=2, sort=7)
	public String getSsc() {
		return ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
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
	
	@NotNull(message="卡号不能为空")
	@ExcelField(title="一折通卡号", align=2, sort=10)
	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}
	
	@NotNull(message="实发资金不能为空")
	@ExcelField(title="实发资金", align=2, sort=11)
	public Double getXdje() {
		return xdje;
	}

	public void setXdje(Double xdje) {
		this.xdje = xdje;
	}

	@ExcelField(title="年度", align=2, sort=12)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	public String getFpfa() {
		return fpfa;
	}

	public void setFpfa(String fpfa) {
		this.fpfa = fpfa;
	}
	
	public String getBksq() {
		return bksq;
	}

	public void setBksq(String bksq) {
		this.bksq = bksq;
	}
	
	public String getQtwj() {
		return qtwj;
	}

	public void setQtwj(String qtwj) {
		this.qtwj = qtwj;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}
	
	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getBkzt() {
		return bkzt;
	}

	public void setBkzt(String bkzt) {
		this.bkzt = bkzt;
	}

	public Date getBksj() {
		return bksj;
	}

	public void setBksj(Date bksj) {
		this.bksj = bksj;
	}

	public String getZtbm() {
		return ztbm;
	}

	public void setZtbm(String ztbm) {
		this.ztbm = ztbm;
	}
	
}