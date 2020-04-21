package com.jeeplus.modules.app.vo;

import java.io.Serializable;
import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;

public class PkrkInfoVo extends DataEntity<PkrkInfoVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	//编号
	private String id;
	//贫困户编号	
	private String pkhbh;
	//姓名
	private String xm;
	//性别
	private String xb;
	//证件类型	
	private String zjlx;
	//身份证号
	private String sfzh;
	//出生日期
	private String csrq;
	//与户主关系
	private String yhzgx;
	//民族
	private String mz;
	//婚姻状况
	private String hyzk;
	//政治面貌
	private String zzmm;
	//文化程度
	private String whcd;
	//在校生状况
	private String zxszk;
	//劳动技能
	private String ldjn;
	//联系方式
	private String lxfs;
	//务工时间
	private String wgsj;
	//务工所在省
	private String wgszs;
	//务工所在市
	private String wgszshi;
	//务工所在县
	private String wgszx;
	//务工所在乡
	private String wgszxiang;
	//务工企业名称
	private String wgqymc;
	//健康状况
	private String jkzk;
	//是否享受低保
	private String sfxsdb;
	//是否现役军人
	private String sfxyjr;
	//生存状态
	private String sczt;
	//分区年度
	private String fqnd;
	//就业（就学）情况
	private String jyjxqk;
	//就业单位
	private String jydw;
	//就业时间
	private String rzsj;
	//就业岗位
	private String  rzgw;
	
	public String getPkhbh() {
		return pkhbh;
	}
	public void setPkhbh(String pkhbh) {
		this.pkhbh = pkhbh;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getZxszk() {
		return zxszk;
	}
	public void setZxszk(String zxszk) {
		this.zxszk = zxszk;
	}
	public String getLdjn() {
		return ldjn;
	}
	public void setLdjn(String ldjn) {
		this.ldjn = ldjn;
	}
	public String getWgsj() {
		return wgsj;
	}
	public void setWgsj(String wgsj) {
		this.wgsj = wgsj;
	}
	public String getWgszs() {
		return wgszs;
	}
	public void setWgszs(String wgszs) {
		this.wgszs = wgszs;
	}
	public String getWgszshi() {
		return wgszshi;
	}
	public void setWgszshi(String wgszshi) {
		this.wgszshi = wgszshi;
	}
	public String getWgszx() {
		return wgszx;
	}
	public void setWgszx(String wgszx) {
		this.wgszx = wgszx;
	}
	public String getWgszxiang() {
		return wgszxiang;
	}
	public void setWgszxiang(String wgszxiang) {
		this.wgszxiang = wgszxiang;
	}
	public String getWgqymc() {
		return wgqymc;
	}
	public void setWgqymc(String wgqymc) {
		this.wgqymc = wgqymc;
	}
	public String getSfxsdb() {
		return sfxsdb;
	}
	public void setSfxsdb(String sfxsdb) {
		this.sfxsdb = sfxsdb;
	}
	public String getSfxyjr() {
		return sfxyjr;
	}
	public void setSfxyjr(String sfxyjr) {
		this.sfxyjr = sfxyjr;
	}
	public String getSczt() {
		return sczt;
	}
	public void setSczt(String sczt) {
		this.sczt = sczt;
	}
	public String getFqnd() {
		return fqnd;
	}
	public void setFqnd(String fqnd) {
		this.fqnd = fqnd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getYhzgx() {
		return yhzgx;
	}
	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}
	public String getHyzk() {
		return hyzk;
	}
	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getJyjxqk() {
		return jyjxqk;
	}
	public void setJyjxqk(String jyjxqk) {
		this.jyjxqk = jyjxqk;
	}
	public String getJkzk() {
		return jkzk;
	}
	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getJydw() {
		return jydw;
	}
	public void setJydw(String jydw) {
		this.jydw = jydw;
	}
	public String getRzsj() {
		return rzsj;
	}
	public void setRzsj(String rzsj) {
		this.rzsj = rzsj;
	}
	public String getRzgw() {
		return rzgw;
	}
	public void setRzgw(String rzgw) {
		this.rzgw = rzgw;
	}
	
}
