/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 直接到户县区汇总表Entity
 * @author query
 * @version 2017-04-17
 */
public class VXqhzb extends DataEntity<VXqhzb> {
	
	private static final long serialVersionUID = 1L;
	private String pid;		// 项目编号
	private String nd;		// 年度
	private String szx;		// 所在县
	private String szz;		// 所在镇
	private String sareaId;		// 所属区域编码
	private Long fchs;		// fchs
	private Long fcrs;		// fcrs
	private Long xms;		// xms
	private Long czzj;		// czzj
	private Long grcz;		// grcz
	private Long hjzj;		// hjzj

	private Long yqsy;		// yqsy
	private Long rjzs;		// rjzs
	
	@ExcelField(title="收益", align=2, sort=10)
	public Long getYqsy() {
		return yqsy;
	}

	public void setYqsy(Long yqsy) {
		this.yqsy = yqsy;
	}
	
	@ExcelField(title="人均增收", align=2, sort=10)
	public Long getRjzs() {
		return rjzs;
	}

	public void setRjzs(Long rjzs) {
		this.rjzs = rjzs;
	}


	public VXqhzb() {
		super();
	}

	public VXqhzb(String id){
		super(id);
	}

	//@ExcelField(title="项目编号", align=2, sort=0)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	//@ExcelField(title="年度", align=2, sort=1)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="所在县", align=2, sort=2)
	public String getSzx() {
		return szx;
	}

	public void setSzx(String szx) {
		this.szx = szx;
	}
	
	@ExcelField(title="所在镇", align=2, sort=3)
	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
	}
	
	//@ExcelField(title="所属区域编码", align=2, sort=4)
	public String getSareaId() {
		return sareaId;
	}

	public void setSareaId(String sareaId) {
		this.sareaId = sareaId;
	}
	
	@NotNull(message="fchs不能为空")
	@ExcelField(title="扶持户数", align=2, sort=5)
	public Long getFchs() {
		return fchs;
	}

	public void setFchs(Long fchs) {
		this.fchs = fchs;
	}
	
	@ExcelField(title="扶持人数", align=2, sort=6)
	public Long getFcrs() {
		return fcrs;
	}

	public void setFcrs(Long fcrs) {
		this.fcrs = fcrs;
	}
	
	@NotNull(message="xms不能为空")
	@ExcelField(title="项目个数", align=2, sort=7)
	public Long getXms() {
		return xms;
	}

	public void setXms(Long xms) {
		this.xms = xms;
	}
	
	@ExcelField(title="财政资金", align=2, sort=8)
	public Long getCzzj() {
		return czzj;
	}

	public void setCzzj(Long czzj) {
		this.czzj = czzj;
	}
	
	@ExcelField(title="个人出资", align=2, sort=9)
	public Long getGrcz() {
		return grcz;
	}

	public void setGrcz(Long grcz) {
		this.grcz = grcz;
	}
	
	@ExcelField(title="合计资金", align=2, sort=10)
	public Long getHjzj() {
		return hjzj;
	}

	public void setHjzj(Long hjzj) {
		this.hjzj = hjzj;
	}
	
}