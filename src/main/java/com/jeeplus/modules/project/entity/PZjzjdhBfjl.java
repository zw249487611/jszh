/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.modules.project.entity.PZjzjdhQd;
import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 扶贫用户明细Entity
 * @author dingL
 * @version 2017-03-03
 */
public class PZjzjdhBfjl extends DataEntity<PZjzjdhBfjl> {
	
	private static final long serialVersionUID = 1L;
	private PZjzjdhQd pid;		// 项目编号
	private String szx;		// 所在县
	private String szz;		// 所在镇
	private String szc;		// 所在村
	private String szzu;		// 所在组
	private String nhxm;		// 农户姓名
	private String hh;		// 户号
	private String sfzh;		// 身份证号
	private String bfpc;		// 帮扶批次
	private String bfzrr;		// 帮扶责任人
	private String bfjl;		// 帮扶记录
	private String bfwj;		// 帮扶记录文件
	
	public PZjzjdhBfjl() {
		super();
	}

	public PZjzjdhBfjl(String id){
		super(id);
	}

	@NotNull(message="项目编号不能为空")
	@ExcelField(title="项目编号", align=2, sort=1)
	public PZjzjdhQd getPid() {
		return pid;
	}

	public void setPid(PZjzjdhQd pid) {
		this.pid = pid;
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
	
	@ExcelField(title="所在村", align=2, sort=4)
	public String getSzc() {
		return szc;
	}

	public void setSzc(String szc) {
		this.szc = szc;
	}
	
	@ExcelField(title="所在组", align=2, sort=5)
	public String getSzzu() {
		return szzu;
	}

	public void setSzzu(String szzu) {
		this.szzu = szzu;
	}
	
	@ExcelField(title="农户姓名", align=2, sort=6)
	public String getNhxm() {
		return nhxm;
	}

	public void setNhxm(String nhxm) {
		this.nhxm = nhxm;
	}
	
	@ExcelField(title="户号", align=2, sort=7)
	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}
	
	@ExcelField(title="身份证号", align=2, sort=8)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
	@ExcelField(title="帮扶批次", dictType="bfpc", align=2, sort=9)
	public String getBfpc() {
		return bfpc;
	}

	public void setBfpc(String bfpc) {
		this.bfpc = bfpc;
	}
	
	@ExcelField(title="帮扶责任人", align=2, sort=10)
	public String getBfzrr() {
		return bfzrr;
	}

	public void setBfzrr(String bfzrr) {
		this.bfzrr = bfzrr;
	}
	
	@ExcelField(title="帮扶记录", align=2, sort=11)
	public String getBfjl() {
		return bfjl;
	}

	public void setBfjl(String bfjl) {
		this.bfjl = bfjl;
	}
	
	@ExcelField(title="帮扶记录文件", align=2, sort=12)
	public String getBfwj() {
		return bfwj;
	}

	public void setBfwj(String bfwj) {
		this.bfwj = bfwj;
	}
	
}