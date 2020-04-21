/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.jszh.entity;


import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 江苏智淮员工身体状况Entity
 * @author zhangw
 * @version 2020-02-02
 */
public class Jszhinfo extends DataEntity<Jszhinfo> {
	
	private static final long serialVersionUID = 1L;
	private String xm;		// 员工姓名
	private String department;		// 所在部门
	private String zt;		// 状态（症状）
	private String dd;		// 所在地点（如：在家）
	private String date;		// 日期
	
	public Jszhinfo() {
		super();
	}

	public Jszhinfo(String id){
		super(id);
	}

	@ExcelField(title="姓名", align=2, sort=1)
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@ExcelField(title="所在部门", align=2, sort=2)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@ExcelField(title="身体状况", align=2, sort=3)
	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	@ExcelField(title="所在地点", align=2, sort=4)
	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	@ExcelField(title="日期", align=2, sort=5)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}