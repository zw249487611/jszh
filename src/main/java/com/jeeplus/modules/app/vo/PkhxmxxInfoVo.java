package com.jeeplus.modules.app.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jeeplus.common.persistence.DataEntity;

public class PkhxmxxInfoVo extends DataEntity<PkhxmxxInfoVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	//贫困户编号
	private String pkhbh;
	//项目编号
	private String xmbh;
	//项目名称
	private String xxmc;
	//项目地点
	private String xmdd;
	//项目类型
	private String xmlx;
	//启动时间
	private String qdsj;
	//户主证件号码
	private String hzzjhm;
	//户主姓名
	private String hzxm;
	//项目进展
	private String xmjz;
	//项目收益
	private BigDecimal xmsy;
	//项目实施困难
	private String xmsskn;
	//有效标志
	private String yxbz;
	//季度
	private String jd;
	//编号集合
	private List<String> ids;
	private String hzsfzh;
	private String nd;
	
	private String ffsj;//发放实际
	private String ffje;//发放金额
	
	public String getFfsj() {
		return ffsj;
	}
	public void setFfsj(String ffsj) {
		this.ffsj = ffsj;
	}
	public String getFfje() {
		return ffje;
	}
	public void setFfje(String ffje) {
		this.ffje = ffje;
	}
	public String getHzsfzh() {
		return hzsfzh;
	}
	public void setHzsfzh(String hzsfzh) {
		this.hzsfzh = hzsfzh;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getPkhbh() {
		return pkhbh;
	}
	public void setPkhbh(String pkhbh) {
		this.pkhbh = pkhbh;
	}
	public String getXxmc() {
		return xxmc;
	}
	public void setXxmc(String xxmc) {
		this.xxmc = xxmc;
	}
	public String getXmdd() {
		return xmdd;
	}
	public void setXmdd(String xmdd) {
		this.xmdd = xmdd;
	}
	public String getXmlx() {
		return xmlx;
	}
	public void setXmlx(String xmlx) {
		this.xmlx = xmlx;
	}
	public String getQdsj() {
		return qdsj;
	}
	public void setQdsj(String qdsj) {
		this.qdsj = qdsj;
	}
	public String getHzzjhm() {
		return hzzjhm;
	}
	public void setHzzjhm(String hzzjhm) {
		this.hzzjhm = hzzjhm;
	}
	public String getHzxm() {
		return hzxm;
	}
	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}
	public String getXmjz() {
		return xmjz;
	}
	public void setXmjz(String xmjz) {
		this.xmjz = xmjz;
	}
	public BigDecimal getXmsy() {
		return xmsy;
	}
	public void setXmsy(BigDecimal xmsy) {
		this.xmsy = xmsy;
	}
	public String getXmsskn() {
		return xmsskn;
	}
	public void setXmsskn(String xmsskn) {
		this.xmsskn = xmsskn;
	}
	public String getYxbz() {
		return yxbz;
	}
	public void setYxbz(String yxbz) {
		this.yxbz = yxbz;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public String getXmbh() {
		return xmbh;
	}
	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}
	
}
