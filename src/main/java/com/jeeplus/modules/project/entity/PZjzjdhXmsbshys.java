/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import java.util.Date;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 资金直接到户-申报审核验收Entity
 * @author cdf
 * @version 2017-03-02
 */
public class PZjzjdhXmsbshys extends DataEntity<PZjzjdhXmsbshys> {
	
	private static final long serialVersionUID = 1L;
	private String pid;		// 项目编号
	private String nd;		// 年度
	private String szx;		// 所在县
	private String szz;		// 所在镇
	private String szs;		// 所在村
	private String szzu;		// 所在组
	private String xmmc;		// 项目名称
	private String hzxm;		// 户主姓名
	private String shjg;		// 审核结果
	private Date shrq;		// 审核日期
	private String ssjg;		// 实施情况
	private String ysjg;		// 验收结果
	private Date ysrq;		// 验收日期
	private String sareaId;    //所属区域编号
	
	public PZjzjdhXmsbshys() {
		super();
	}

	public PZjzjdhXmsbshys(String id){
		super(id);
	}

//	@ExcelField(title="项目编号", align=2, sort=1)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@ExcelField(title="年度", align=2, sort=2)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="所在县", align=2, sort=3)
	public String getSzx() {
		return szx;
	}

	public void setSzx(String szx) {
		this.szx = szx;
	}
	
	@ExcelField(title="所在镇", align=2, sort=4)
	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
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
	
	@ExcelField(title="项目名称", align=2, sort=7)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@ExcelField(title="户主姓名", align=2, sort=9)
	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}
	
	public String getShjg() {
		return shjg;
	}

	public void setShjg(String shjg) {
		this.shjg = shjg;
	}

	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}

	@ExcelField(title="验收结果", align=2, sort=11)
	public String getYsjg() {
		return ysjg;
	}

	public void setYsjg(String ysjg) {
		this.ysjg = ysjg;
	}

	public Date getYsrq() {
		return ysrq;
	}

	public void setYsrq(Date ysrq) {
		this.ysrq = ysrq;
	}

	public String getSareaId() {
		return sareaId;
	}

	public void setSareaId(String sareaId) {
		this.sareaId = sareaId;
	}

	@ExcelField(title="实施情况", align=2, sort=10)
	public String getSsjg() {
		return ssjg;
	}

	public void setSsjg(String ssjg) {
		this.ssjg = ssjg;
	}

}