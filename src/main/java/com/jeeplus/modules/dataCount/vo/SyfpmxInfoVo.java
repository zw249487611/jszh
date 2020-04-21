/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;

import com.jeeplus.common.persistence.DataEntity;

/**
 * 收益分配明细信息Entity
 * @author maojl
 * @version 2017-09-04
 */
public class SyfpmxInfoVo extends DataEntity<SyfpmxInfoVo> {
	
	private static final long serialVersionUID = 1L;
	private String syfpid;//收益方案分配id
	private String ssq;//县区
	private String ssxz;//乡镇
	private String ssc;//村居
	private String xm;//户主姓名
	private String rs;//家庭人口
	private String sfzh;//身份证号
	private String kh;//一折通卡号
	private String fpje;//分配金额
	private String bkzt;//拨款状态
	private String fprq;//分配日期
	private String fplx;//分配类型
	public String getSyfpid() {
		return syfpid;
	}
	public void setSyfpid(String syfpid) {
		this.syfpid = syfpid;
	}
	public String getSsq() {
		return ssq;
	}
	public void setSsq(String ssq) {
		this.ssq = ssq;
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
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getRs() {
		return rs;
	}
	public void setRs(String rs) {
		this.rs = rs;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getKh() {
		return kh;
	}
	public void setKh(String kh) {
		this.kh = kh;
	}
	public String getFpje() {
		return fpje;
	}
	public void setFpje(String fpje) {
		this.fpje = fpje;
	}
	public String getBkzt() {
		return bkzt;
	}
	public void setBkzt(String bkzt) {
		this.bkzt = bkzt;
	}
	public String getFprq() {
		return fprq;
	}
	public void setFprq(String fprq) {
		this.fprq = fprq;
	}
	public String getFplx() {
		return fplx;
	}
	public void setFplx(String fplx) {
		this.fplx = fplx;
	}
}