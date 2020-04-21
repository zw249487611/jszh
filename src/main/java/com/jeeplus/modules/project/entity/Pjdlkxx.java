/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;


import com.jeeplus.common.persistence.DataEntity;

/**
 * 建档立卡表Entity
 * @author admin
 * @version 2017-03-08
 */
public class Pjdlkxx extends DataEntity<Pjdlkxx> {
	
	private static final long serialVersionUID = 1L;
	private String hzxm;//户主姓名
	private String xb;//性别
	private String nl;//年龄
	private String whcd;//文化程度
	private String sfzh;//身份证号
	private String lxdh;//联系电话
	private String yztxm;//一折通姓名
	private String yzth;//一折通号
	private String bfr;//帮扶人
	private String bfrdh;//帮扶人电话
	private int jdlkrk;//建档立卡人口
	private String ssxq;//所属县区
	private String ssxz;//所属乡镇
	private String ssc;//所属村
	private String areaCode; //所属区域code
	private String xm;
	private String szx;
	private String szz;
	private String szc;
	private String yhkh;
	private String rs;
	
	public String getSsxq() {
		return ssxq;
	}

	public void setSsxq(String ssxq) {
		this.ssxq = ssxq;
	}

	public String getSsxz() {
		return ssxz;
	}

	public void setSsxz(String ssxz) {
		this.ssxz = ssxz;
	}

	public String getSsc() {
		return ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}


	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}


	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getYzth() {
		return yzth;
	}

	public void setYzth(String yzth) {
		this.yzth = yzth;
	}

	public String getBfr() {
		return bfr;
	}

	public void setBfr(String bfr) {
		this.bfr = bfr;
	}

	public String getBfrdh() {
		return bfrdh;
	}

	public void setBfrdh(String bfrdh) {
		this.bfrdh = bfrdh;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getYztxm() {
		return yztxm;
	}

	public void setYztxm(String yztxm) {
		this.yztxm = yztxm;
	}

	public int getJdlkrk() {
		return jdlkrk;
	}

	public void setJdlkrk(int jdlkrk) {
		this.jdlkrk = jdlkrk;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSzx() {
		return szx;
	}

	public void setSzx(String szx) {
		this.szx = szx;
	}

	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
	}

	public String getSzc() {
		return szc;
	}

	public void setSzc(String szc) {
		this.szc = szc;
	}

	public String getYhkh() {
		return yhkh;
	}

	public void setYhkh(String yhkh) {
		this.yhkh = yhkh;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}
	
	
	
}