/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;


/**
 * 数据统计-贫困村基本信息Entity
 * @author lukk
 * @version 2017-03-29
 */
public class PkcjbxxInfoVo{
	
	private static final long serialVersionUID = 1L;
	//区划编号
	private String code;
	//县区
	private String xq;
	//乡镇
	private String xz;
	//村名
	private String pkcName;
	//类型
	private String lx;
	//总户数
	private int zhs;
	//总人口数
	private int zrks;
	//低收入户数
	private int dsrhs;
	//低收入人口数
	private int dsrrks;
	//脱贫年度
	private String tpnd;
	//省定薄弱村数量
	private int sdbrcsl;
	//市定薄弱村数量
	private int shidbrcsl;
	//脱贫年度各数量
	private int count;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getXq() {
		return xq;
	}
	public void setXq(String xq) {
		this.xq = xq;
	}
	public String getXz() {
		return xz;
	}
	public void setXz(String xz) {
		this.xz = xz;
	}
	public String getPkcName() {
		return pkcName;
	}
	public void setPkcName(String pkcName) {
		this.pkcName = pkcName;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public int getZhs() {
		return zhs;
	}
	public void setZhs(int zhs) {
		this.zhs = zhs;
	}
	public int getZrks() {
		return zrks;
	}
	public void setZrks(int zrks) {
		this.zrks = zrks;
	}
	public int getDsrhs() {
		return dsrhs;
	}
	public void setDsrhs(int dsrhs) {
		this.dsrhs = dsrhs;
	}
	public int getDsrrks() {
		return dsrrks;
	}
	public void setDsrrks(int dsrrks) {
		this.dsrrks = dsrrks;
	}
	public String getTpnd() {
		return tpnd;
	}
	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}
	public int getSdbrcsl() {
		return sdbrcsl;
	}
	public void setSdbrcsl(int sdbrcsl) {
		this.sdbrcsl = sdbrcsl;
	}
	public int getShidbrcsl() {
		return shidbrcsl;
	}
	public void setShidbrcsl(int shidbrcsl) {
		this.shidbrcsl = shidbrcsl;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}