/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 帮扶关系Entity
 * @author dingL
 * @version 2017-03-03
 */
public class PZjzjdhBfgx extends DataEntity<PZjzjdhBfgx> {
	
	private static final long serialVersionUID = 1L;
	private String szx;		// 所在县
	private String szz;		// 所在镇
	private String szc;		// 所在村
	private String szzu;		// 所在组
	private String nhxm;		// 农户姓名
	private String sfzh;		// 身份证号
	private String hh;		// 户号
	
	public PZjzjdhBfgx() {
		super();
	}

	public PZjzjdhBfgx(String id){
		super(id);
	}

	@ExcelField(title="所在县", align=2, sort=1)
	public String getSzx() {
		return szx;
	}

	public void setSzx(String szx) {
		this.szx = szx;
	}
	
	@ExcelField(title="所在镇", align=2, sort=2)
	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
	}
	
	@ExcelField(title="所在村", align=2, sort=3)
	public String getSzc() {
		return szc;
	}

	public void setSzc(String szc) {
		this.szc = szc;
	}
	
	@ExcelField(title="所在组", align=2, sort=4)
	public String getSzzu() {
		return szzu;
	}

	public void setSzzu(String szzu) {
		this.szzu = szzu;
	}
	
	@ExcelField(title="农户姓名", align=2, sort=5)
	public String getNhxm() {
		return nhxm;
	}

	public void setNhxm(String nhxm) {
		this.nhxm = nhxm;
	}
	
	@ExcelField(title="身份证号", align=2, sort=6)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
	@ExcelField(title="户号", align=2, sort=7)
	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}
	
}