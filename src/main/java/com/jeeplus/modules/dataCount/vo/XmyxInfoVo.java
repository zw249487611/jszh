/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;

import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;

/**
 * 项目信息Entity
 * @author maojl
 * @version 2017-09-04
 */
public class XmyxInfoVo extends DataEntity<XmyxInfoVo> {
	
	private static final long serialVersionUID = 1L;
	private String nd;//年度	
	private String xmmc;//项目名称
	private String xmlb;//项目类别
	private String xmlx;//项目类型
	private String sszt;//实施主体
	private String ssdd;//实施地点
	private String ssnr;//实施内容
	private String xmtz;//项目投资
	private Date lzrq;//论证日期
	private String lzjg;//论证结果
	private String lzhyjy;//论证会议纪要
	private Date psrq;//评审日期
	private String psjg;//评审结果
	private String pshyjy;//评审会议纪要
	private Date qdrq;//确定日期
	private String qdjg;//确定结果
	private String xqwhyjy;//县区委（政府）会议纪要
	private Date lxpfrq;//立项批复时间
	private String lxpfbm;//立项批复部门
	private String lxpfwh;//立项批复文号
	private String lxpfwj;//立项批复文件
	private Date zbrq;//中标日期
	private String zbdw;//中标（施工）单位
	private Date htkgrq;//合同约定开工日期
	private Date htjgrq;//合同约定竣工日期
	private String xmjd;//项目进度
	private String gcjld;//工程计量单（进度附件）
	private String jldw;//监理单位
	private String jlbg;//监理报告
	private Date ysrq;//验收日期
	private String ysdw;//验收单位
	private String ysjg;//验收结果
	private String sjbg;//审计报告
	private Date jxpgrq;//绩效评估日期
	private String jxpgdw;//绩效评估单位
	private String jxpgjg;//绩效评估结果
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getXmlb() {
		return xmlb;
	}
	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}
	public String getXmlx() {
		return xmlx;
	}
	public void setXmlx(String xmlx) {
		this.xmlx = xmlx;
	}
	public String getSszt() {
		return sszt;
	}
	public void setSszt(String sszt) {
		this.sszt = sszt;
	}
	public String getSsdd() {
		return ssdd;
	}
	public void setSsdd(String ssdd) {
		this.ssdd = ssdd;
	}
	public String getSsnr() {
		return ssnr;
	}
	public void setSsnr(String ssnr) {
		this.ssnr = ssnr;
	}
	public String getXmtz() {
		return xmtz;
	}
	public void setXmtz(String xmtz) {
		this.xmtz = xmtz;
	}
	public Date getLzrq() {
		return lzrq;
	}
	public void setLzrq(Date lzrq) {
		this.lzrq = lzrq;
	}
	public String getLzjg() {
		return lzjg;
	}
	public void setLzjg(String lzjg) {
		this.lzjg = lzjg;
	}
	public String getLzhyjy() {
		return lzhyjy;
	}
	public void setLzhyjy(String lzhyjy) {
		this.lzhyjy = lzhyjy;
	}
	public Date getPsrq() {
		return psrq;
	}
	public void setPsrq(Date psrq) {
		this.psrq = psrq;
	}
	public String getPsjg() {
		return psjg;
	}
	public void setPsjg(String psjg) {
		this.psjg = psjg;
	}
	public String getPshyjy() {
		return pshyjy;
	}
	public void setPshyjy(String pshyjy) {
		this.pshyjy = pshyjy;
	}
	public Date getQdrq() {
		return qdrq;
	}
	public void setQdrq(Date qdrq) {
		this.qdrq = qdrq;
	}
	public String getQdjg() {
		return qdjg;
	}
	public void setQdjg(String qdjg) {
		this.qdjg = qdjg;
	}
	public String getXqwhyjy() {
		return xqwhyjy;
	}
	public void setXqwhyjy(String xqwhyjy) {
		this.xqwhyjy = xqwhyjy;
	}
	public Date getLxpfrq() {
		return lxpfrq;
	}
	public void setLxpfrq(Date lxpfrq) {
		this.lxpfrq = lxpfrq;
	}
	public String getLxpfbm() {
		return lxpfbm;
	}
	public void setLxpfbm(String lxpfbm) {
		this.lxpfbm = lxpfbm;
	}
	public String getLxpfwh() {
		return lxpfwh;
	}
	public void setLxpfwh(String lxpfwh) {
		this.lxpfwh = lxpfwh;
	}
	public String getLxpfwj() {
		return lxpfwj;
	}
	public void setLxpfwj(String lxpfwj) {
		this.lxpfwj = lxpfwj;
	}
	public Date getZbrq() {
		return zbrq;
	}
	public void setZbrq(Date zbrq) {
		this.zbrq = zbrq;
	}
	public String getZbdw() {
		return zbdw;
	}
	public void setZbdw(String zbdw) {
		this.zbdw = zbdw;
	}
	public Date getHtkgrq() {
		return htkgrq;
	}
	public void setHtkgrq(Date htkgrq) {
		this.htkgrq = htkgrq;
	}
	public Date getHtjgrq() {
		return htjgrq;
	}
	public void setHtjgrq(Date htjgrq) {
		this.htjgrq = htjgrq;
	}
	public String getXmjd() {
		return xmjd;
	}
	public void setXmjd(String xmjd) {
		this.xmjd = xmjd;
	}
	public String getGcjld() {
		return gcjld;
	}
	public void setGcjld(String gcjld) {
		this.gcjld = gcjld;
	}
	public String getJldw() {
		return jldw;
	}
	public void setJldw(String jldw) {
		this.jldw = jldw;
	}
	public String getJlbg() {
		return jlbg;
	}
	public void setJlbg(String jlbg) {
		this.jlbg = jlbg;
	}
	public Date getYsrq() {
		return ysrq;
	}
	public void setYsrq(Date ysrq) {
		this.ysrq = ysrq;
	}
	public String getYsdw() {
		return ysdw;
	}
	public void setYsdw(String ysdw) {
		this.ysdw = ysdw;
	}
	public String getYsjg() {
		return ysjg;
	}
	public void setYsjg(String ysjg) {
		this.ysjg = ysjg;
	}
	public String getSjbg() {
		return sjbg;
	}
	public void setSjbg(String sjbg) {
		this.sjbg = sjbg;
	}
	public Date getJxpgrq() {
		return jxpgrq;
	}
	public void setJxpgrq(Date jxpgrq) {
		this.jxpgrq = jxpgrq;
	}
	public String getJxpgdw() {
		return jxpgdw;
	}
	public void setJxpgdw(String jxpgdw) {
		this.jxpgdw = jxpgdw;
	}
	public String getJxpgjg() {
		return jxpgjg;
	}
	public void setJxpgjg(String jxpgjg) {
		this.jxpgjg = jxpgjg;
	}
	
	
}