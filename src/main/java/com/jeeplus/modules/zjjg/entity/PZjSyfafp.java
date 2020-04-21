/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 收益方案分配Entity
 * 
 * @author lhq
 * @version 2017-05-12
 */
public class PZjSyfafp extends DataEntity<PZjSyfafp> {

	private static final long serialVersionUID = 1L;

	private String zjid; 	// 县区组织配套资金ID
	private String zjmc; 	// 县区组织配套资金名称
	private String xmid; 	// 项目ID
	private String xmmc; 	// 项目名称

	private String nd; 		// 年度
	private String nhxm; 	// 农户 姓名
	private String sfzh; 	// 农户 身份证号
	private Double xdje;	// 农户 下达金额
	private String yztkh; 	// 农户 一折通卡号
	
	private String code; 	// 用户区编号
	private String type; 	// 数据记录类型(1:统筹带动、2:直接到户、4:市扶贫专项、6:省定薄弱村、5:市定薄弱村)

	private String spr;			// 审批人
	private Date sprq;			// 审批日期
	private String spzt;		// 审批状态
	private String xm;			// 姓名
	private String ssq;			// 所属区
	private String ssx;			// 所属乡
	private String ssc;			// 所属村
	private Integer rs;			// 人数
	private String lxfs;		// 联系方式
	private String kh;			// 卡号
	private String fpfa;		// 分配方案
	private String bksq;		// 拨款申请
	private String qtwj;		// 其他文件
	private String bkid;
	private String bkzt;		//拨款状态
	private Date bksj;			//拨款时间
	
	private String ztbm;		//状态编码
	private String dcry;     	//调查人员
	private String dcyj;	 	//调查意见
	private String dcbg; 	 	//调查报告
	private String isChecked; 	//是否确认
	private String wtlx;  		// 问题类型
	private String dcdw;		//
	private String sjzt;        //数据状态
	private String fppc;		//分配批次
	
	private BigDecimal sumHjzj;
	private int count;
	
	
	
	public BigDecimal getSumHjzj() {
		return sumHjzj;
	}

	public void setSumHjzj(BigDecimal sumHjzj) {
		this.sumHjzj = sumHjzj;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFppc() {
		return fppc;
	}

	public void setFppc(String fppc) {
		this.fppc = fppc;
	}

	public String getSjzt() {
		return sjzt;
	}

	public void setSjzt(String sjzt) {
		this.sjzt = sjzt;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	
	@NotNull(message="收益方案分配项目名称不能为空")
	@ExcelField(title="项目名称", align=2, sort=2)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getZjid() {
		return zjid;
	}

	public void setZjid(String zjid) {
		this.zjid = zjid;
	}
	
	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}

	@NotNull(message="收益方案分配年度不能为空")
	@ExcelField(title="年度", align=2, sort=3)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	@NotNull(message="收益方案分配农户姓名不能为空")
	@ExcelField(title="农户姓名", align=2, sort=4)
	public String getNhxm() {
		return nhxm;
	}

	public void setNhxm(String nhxm) {
		this.nhxm = nhxm;
	}

	@NotNull(message="收益方案分配农身份证号不能为空")
	@ExcelField(title="身份证号", align=2, sort=5)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	@ExcelField(title="下达金额", align=2, sort=6)
	public Double getXdje() {
		return xdje;
	}

	public void setXdje(Double xdje) {
		this.xdje = xdje;
	}

	@NotNull(message="收益方案分配一折通卡号不能为空")
	@ExcelField(title="一折通卡号", align=2, sort=7)
	public String getYztkh() {
		return yztkh;
	}

	public void setYztkh(String yztkh) {
		this.yztkh = yztkh;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSsq() {
		return ssq;
	}

	public void setSsq(String ssq) {
		this.ssq = ssq;
	}

	public String getSsx() {
		return ssx;
	}

	public void setSsx(String ssx) {
		this.ssx = ssx;
	}

	public String getSsc() {
		return ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
	}

	public Integer getRs() {
		return rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getFpfa() {
		return fpfa;
	}

	public void setFpfa(String fpfa) {
		this.fpfa = fpfa;
	}

	public String getBksq() {
		return bksq;
	}

	public void setBksq(String bksq) {
		this.bksq = bksq;
	}

	public String getQtwj() {
		return qtwj;
	}

	public void setQtwj(String qtwj) {
		this.qtwj = qtwj;
	}

	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getBkzt() {
		return bkzt;
	}

	public void setBkzt(String bkzt) {
		this.bkzt = bkzt;
	}

	public Date getBksj() {
		return bksj;
	}

	public void setBksj(Date bksj) {
		this.bksj = bksj;
	}

	public String getZtbm() {
		return ztbm;
	}

	public void setZtbm(String ztbm) {
		this.ztbm = ztbm;
	}

	public String getDcry() {
		return dcry;
	}

	public void setDcry(String dcry) {
		this.dcry = dcry;
	}

	public String getDcyj() {
		return dcyj;
	}

	public void setDcyj(String dcyj) {
		this.dcyj = dcyj;
	}

	public String getDcbg() {
		return dcbg;
	}

	public void setDcbg(String dcbg) {
		this.dcbg = dcbg;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public String getWtlx() {
		return wtlx;
	}

	public void setWtlx(String wtlx) {
		this.wtlx = wtlx;
	}

	public String getDcdw() {
		return dcdw;
	}

	public void setDcdw(String dcdw) {
		this.dcdw = dcdw;
	}

}