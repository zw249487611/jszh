/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 贫困户信息综合查询Entity
 * 
 * @author 陆凯凯
 * @version 2017-08-30
 */
public class Jdlkhzh extends DataEntity<Jdlkhzh> {

	private static final long serialVersionUID = 1L;
	private String nd; // 年度
	private String xq; // 县区
	private String xz; // 乡镇
	private String xc; // 乡村
	private String xm; // 姓名 6
	private String sfzh; // 身份证号 2(证件号码) 7
	private String jtrks; // 家庭人口数 2（人数） 8
	private String dz;
	private String yhzgx; // 2 与户主关系 9
	private List<String> yearList;
	private String lxfs; // 2 联系电话 18
	private String pkhsx; // 贫困户属性
	private String zpyy; // 致贫原因
	private String jkzk; // 健康状况 13
	private String xb;
	private String whcd; // 文化程度 11
	private String jyqk; // 就业情况

	// 就业新增字段
	private String jydw;// 就业单位
	private String rzgw;// 入职岗位
	private Date rzsj;// 入职时间
	private String sfzcxpk; // 是否支出性贫困
	private String tpnd;// 脱贫年度
	private String tpbz;// 脱贫标识

	// zhangwei新加实体
	private String xqname; // 县区 1
	private String xzname; // 乡镇 2
	private String xcname; // 乡村 3
	private String hbh; // 户编号 4
	private String rbh; // 人编号 5
	private String nation; // 民族 10
	private String zxszk; // 在校生状况 12
	private String ldjn; // 劳动技能 14
	private String pkhsxname; // 贫困户属性 16
	private String zpyyname; // 致贫原因 （主要致贫原因）17

	private String sftp; // 是否脱贫 （脱贫属性） 15
	private String sfyzf; // 是否有住房
	
	private String mxbName;//慢性病
	private String hydbName;//大病
	private String sfjd;	// 是否结对
	private BigDecimal rjsr;//人均收入
	private BigDecimal jtzsr;//家庭总收入
	private BigDecimal ybzc;//因病支出
	
	

	public String getMxbName() {
		return mxbName;
	}

	public void setMxbName(String mxbName) {
		this.mxbName = mxbName;
	}

	public String getHydbName() {
		return hydbName;
	}

	public void setHydbName(String hydbName) {
		this.hydbName = hydbName;
	}

	@ExcelField(title = "主要致贫原因", align = 2, sort = 17)
	public String getZpyyname() {
		return zpyyname;
	}

	public void setZpyyname(String zpyyname) {
		this.zpyyname = zpyyname;
	}

	@ExcelField(title = "贫困户属性", align = 2, sort = 16)
	public String getPkhsxname() {
		return pkhsxname;
	}

	public void setPkhsxname(String pkhsxname) {
		this.pkhsxname = pkhsxname;
	}

	@ExcelField(title = "县(市、区、旗)", align = 2, sort = 1)
	public String getXqname() {
		return xqname;
	}

	public void setXqname(String xqname) {
		this.xqname = xqname;
	}

	@ExcelField(title = "乡(镇)", align = 2, sort = 2)
	public String getXzname() {
		return xzname;
	}

	public void setXzname(String xzname) {
		this.xzname = xzname;
	}

	@ExcelField(title = "行政村", align = 2, sort = 3)
	public String getXcname() {
		return xcname;
	}

	public void setXcname(String xcname) {
		this.xcname = xcname;
	}

	@ExcelField(title = "户编号", align = 2, sort = 4)
	public String getHbh() {
		return hbh;
	}

	public void setHbh(String hbh) {
		this.hbh = hbh;
	}

	@ExcelField(title = "人编号", align = 2, sort = 5)
	public String getRbh() {
		return rbh;
	}

	public void setRbh(String rbh) {
		this.rbh = rbh;
	}

	@ExcelField(title = "民族", align = 2, sort = 10)
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@ExcelField(title = "在校生状况", align = 2, sort = 12)
	public String getZxszk() {
		return zxszk;
	}

	public void setZxszk(String zxszk) {
		this.zxszk = zxszk;
	}

	@ExcelField(title = "劳动技能", align = 2, sort = 14)
	public String getLdjn() {
		return ldjn;
	}

	public void setLdjn(String ldjn) {
		this.ldjn = ldjn;
	}

	@ExcelField(title = "脱贫属性", align = 2, sort = 15)
	public String getSftp() {
		return sftp;
	}

	public void setSftp(String sftp) {
		this.sftp = sftp;
	}

	@ExcelField(title = "文化程度", align = 2, sort = 11)
	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getJyqk() {
		return jyqk;
	}

	public void setJyqk(String jyqk) {
		this.jyqk = jyqk;
	}

	private List<String> sfzhList;

	public Jdlkhzh() {
		super();
	}

	public Jdlkhzh(String id) {
		super(id);
	}

//	@ExcelField(title = "年度", align = 2, sort = 7)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

//	@ExcelField(title = "县区", dictType = "", align = 2, sort = 8)
	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}

//	@ExcelField(title = "乡镇", dictType = "", align = 2, sort = 9)
	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

//	@ExcelField(title = "乡村", dictType = "", align = 2, sort = 10)
	public String getXc() {
		return xc;
	}

	public void setXc(String xc) {
		this.xc = xc;
	}

	@ExcelField(title = "姓名", align = 2, sort = 6)
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@ExcelField(title = "身份证号", align = 2, sort = 7)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	@ExcelField(title = "家庭人口数", align = 2, sort = 8)
	public String getJtrks() {
		return jtrks;
	}

	public void setJtrks(String jtrks) {
		this.jtrks = jtrks;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	@ExcelField(title = "与户主关系", align = 2, sort = 9)
	public String getYhzgx() {
		return yhzgx;
	}

	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	@ExcelField(title = "联系电话", align = 2, sort = 18)
	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getPkhsx() {
		return pkhsx;
	}

	public void setPkhsx(String pkhsx) {
		this.pkhsx = pkhsx;
	}

	public String getZpyy() {
		return zpyy;
	}

	public void setZpyy(String zpyy) {
		this.zpyy = zpyy;
	}

	@ExcelField(title = "健康状况", align = 2, sort = 13)
	public String getJkzk() {
		return jkzk;
	}

	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public List<String> getSfzhList() {
		return sfzhList;
	}

	public void setSfzhList(List<String> sfzhList) {
		this.sfzhList = sfzhList;
	}

	public String getSfzcxpk() {
		return sfzcxpk;
	}

	public void setSfzcxpk(String sfzcxpk) {
		this.sfzcxpk = sfzcxpk;
	}

	public String getTpnd() {
		return tpnd;
	}

	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}

	@ExcelField(title = "脱贫标志", align = 2, sort = 14)
	public String getTpbz() {
		return tpbz;
	}

	public void setTpbz(String tpbz) {
		this.tpbz = tpbz;
	}

	public String getJydw() {
		return jydw;
	}

	public void setJydw(String jydw) {
		this.jydw = jydw;
	}

	public String getRzgw() {
		return rzgw;
	}

	public void setRzgw(String rzgw) {
		this.rzgw = rzgw;
	}

	public Date getRzsj() {
		return rzsj;
	}

	public void setRzsj(Date rzsj) {
		this.rzsj = rzsj;
	}

	public String getSfyzf() {
		return sfyzf;
	}

	public void setSfyzf(String sfyzf) {
		this.sfyzf = sfyzf;
	}

	public String getSfjd() {
		return sfjd;
	}

	public void setSfjd(String sfjd) {
		this.sfjd = sfjd;
	}

	public BigDecimal getRjsr() {
		return rjsr;
	}

	public void setRjsr(BigDecimal rjsr) {
		this.rjsr = rjsr;
	}

	public BigDecimal getJtzsr() {
		return jtzsr;
	}

	public void setJtzsr(BigDecimal jtzsr) {
		this.jtzsr = jtzsr;
	}

	public BigDecimal getYbzc() {
		return ybzc;
	}

	public void setYbzc(BigDecimal ybzc) {
		this.ybzc = ybzc;
	}
	
}