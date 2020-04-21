/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.modules.project.entity.PZjzjdhQd;
import com.jeeplus.modules.sys.entity.Area;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 宣传到户Entity
 * @author dingL
 * @version 2017-03-07
 */
public class PZjzjdhXcdh extends DataEntity<PZjzjdhXcdh> {
	
	private static final long serialVersionUID = 1L;
	private PZjzjdhQd pid;		// 项目编号
	//private PZjzjdhQd faPro;		// 项目名称
	private Area szx;		// 所在县
	private Area szz;		// 所在镇
	private String szc;		// 所在村
	private String szzu;		// 所在组
	private String nhxm;		// 农户姓名
	private String zcxcr;		// 政策宣传人
	private String gsxctp;		// 公示现场图片
	private Date ccrq;		// 抽查日期
	private String ssdq;	//所属地区
	

	public PZjzjdhXcdh() {
		super();
	}

	public PZjzjdhXcdh(String id){
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
	
	/*@ExcelField(title="项目名称", align=2, sort=1)
	public PZjzjdhQd getFaPro() {
		return faPro;
	}

	public void setFaPro(PZjzjdhQd faPro) {
		this.faPro = faPro;
	}*/
	
	@ExcelField(title="所在县", fieldType=Area.class, value="szx.name", align=2, sort=2)
	public Area getSzx() {
		return szx;
	}

	public void setSzx(Area szx) {
		this.szx = szx;
	}
	
	@ExcelField(title="所在镇", fieldType=Area.class, value="szz.name", align=2, sort=3)
	public Area getSzz() {
		return szz;
	}

	public void setSzz(Area szz) {
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
	
	/*@ExcelField(title="政策宣传人", align=2, sort=7)*/
	public String getZcxcr() {
		return zcxcr;
	}

	public void setZcxcr(String zcxcr) {
		this.zcxcr = zcxcr;
	}
	
	/*@ExcelField(title="公示现场图片", align=2, sort=8)*/
	public String getGsxctp() {
		return gsxctp;
	}

	public void setGsxctp(String gsxctp) {
		this.gsxctp = gsxctp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="抽查日期", align=2, sort=9)
	public Date getCcrq() {
		return ccrq;
	}

	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	}

	public String getSsdq() {
		return ssdq;
	}

	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}
	
}