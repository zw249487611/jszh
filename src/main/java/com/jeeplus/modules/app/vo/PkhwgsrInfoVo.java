package com.jeeplus.modules.app.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.jeeplus.common.persistence.DataEntity;

public class PkhwgsrInfoVo extends DataEntity<PkhwgsrInfoVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	//贫困户编号
	private String pkhbh;
	//贫困人口编号
	private String pkrkbh;
	//姓名
	private String xm;
	//工种
	private String gz;
	//工作单位
	private String gzdw;
	//今年以来收入
	private BigDecimal jnylsr;
	//季度
	private String jd;
	//工作区域
	private String gzqy;
	//工作区域描述
	private String gzqyms;
	//工作区域类型
	private String gzqylx;
	//工作区域类型描述
	private String gzqylxms;
	
	public String getPkhbh() {
		return pkhbh;
	}
	public void setPkhbh(String pkhbh) {
		this.pkhbh = pkhbh;
	}
	public String getPkrkbh() {
		return pkrkbh;
	}
	public void setPkrkbh(String pkrkbh) {
		this.pkrkbh = pkrkbh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getGz() {
		return gz;
	}
	public void setGz(String gz) {
		this.gz = gz;
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public BigDecimal getJnylsr() {
		return jnylsr;
	}
	public void setJnylsr(BigDecimal jnylsr) {
		this.jnylsr = jnylsr;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getGzqy() {
		return gzqy;
	}
	public void setGzqy(String gzqy) {
		this.gzqy = gzqy;
	}
	public String getGzqylx() {
		return gzqylx;
	}
	public void setGzqylx(String gzqylx) {
		this.gzqylx = gzqylx;
	}
	public String getGzqyms() {
		return gzqyms;
	}
	public void setGzqyms(String gzqyms) {
		this.gzqyms = gzqyms;
	}
	public String getGzqylxms() {
		return gzqylxms;
	}
	public void setGzqylxms(String gzqylxms) {
		this.gzqylxms = gzqylxms;
	}
	
}
