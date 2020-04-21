/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 资金直接到户-申报Entity
 * @author cdf
 * @version 2017-03-02
 */
public class PZjzjdhXmsb extends DataEntity<PZjzjdhXmsb> {
	
	private static final long serialVersionUID = 1L;
	private String pid;		// 项目编号
	private String nd;		// 年度
	private String szx;		// 所在县
	private String szz;		// 所在镇
	private String szs;		// 所在村
	private String szzu;		// 所在组
	private String xmmc;		// 项目名称
	private String hbh;		// 户编号
	private String hzxm;		// 户主姓名
	private String nl;		// 年龄
	private String xb;		// 性别
	private String whcd;		// 文化程度
	private String jdlkrk;		// 建档立卡人口
	private String sfzh;		// 身份证号
	private String lxdh;		// 电话号码
	private String yztxm;		// 一折通姓名
	private String yzth;		// 一折通号
	private String bfzrr;		// 帮扶责任人
	private String bflxdh;		// 帮扶人联系电话
	private BigDecimal sqczzj = new BigDecimal(0);		// 申请财政资金
	private BigDecimal grcz = new BigDecimal(0);		// 个人出资
	private BigDecimal qtbfzj = new BigDecimal(0);		// 其他帮扶资金
	private BigDecimal hjzj = new BigDecimal(0);		// 总计
	private String ssqx;		// 实施期限
	private String ssdd;		// 实施地点
	private String ssgm;		// 实施规模
	private BigDecimal yqsy;		// 预期收益
	private String xzzt;		// 项目状态
	private String xmdckh;		// 项目督查考核
	private String sareaId;    //所属区域编号
	private String xuhao;      //序号,表格导出用
	

	public PZjzjdhXmsb() {
		super();
	}

	public PZjzjdhXmsb(String id){
		super(id);
	}

//	@ExcelField(title="项目编号", align=2, sort=1)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@ExcelField(title="序号", align=2, sort=1)
	public String getXuhao() {
		return xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	
	@ExcelField(title="年度", align=2, sort=2)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="所在县", align=2, sort=3)
	public String getSzx() {
		return szx;
	}

	public void setSzx(String szx) {
		this.szx = szx;
	}
	
	@ExcelField(title="所在镇", align=2, sort=4)
	public String getSzz() {
		return szz;
	}

	public void setSzz(String szz) {
		this.szz = szz;
	}
	
	@ExcelField(title="所在村", align=2, sort=5)
	public String getSzs() {
		return szs;
	}

	public void setSzs(String szs) {
		this.szs = szs;
	}
	
	@ExcelField(title="所在组", align=2, sort=6)
	public String getSzzu() {
		return szzu;
	}

	public void setSzzu(String szzu) {
		this.szzu = szzu;
	}
	
	@ExcelField(title="户主姓名", align=2, sort=9)
	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}
	
	@ExcelField(title="建档立卡人口", align=2, sort=13)
	public String getJdlkrk() {
		return jdlkrk;
	}

	public void setJdlkrk(String jdlkrk) {
		this.jdlkrk = jdlkrk;
	}
	

	@ExcelField(title="身份证号", align=2, sort=14)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
	@ExcelField(title="一折通姓名", align=2, sort=16)
	public String getYztxm() {
		return yztxm;
	}

	public void setYztxm(String yztxm) {
		this.yztxm = yztxm;
	}
	
	@ExcelField(title="一折通号", align=2, sort=17)
	public String getYzth() {
		return yzth;
	}

	public void setYzth(String yzth) {
		this.yzth = yzth;
	}
	
	
	@ExcelField(title="项目名称", align=2, sort=7)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@NotNull(message="申请财政资金不能为空")
	@ExcelField(title="申请财政资金", align=2, sort=20)
	public BigDecimal getSqczzj() {
		return sqczzj;
	}

	public String getHbh() {
		return hbh;
	}

	public void setHbh(String hbh) {
		this.hbh = hbh;
	}
	
	
	
	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}
	
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}
	
	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	
	@ExcelField(title="预期收益", align=2, sort=27)
	public BigDecimal getYqsy() {
		return yqsy;
	}

	public void setYqsy(BigDecimal yqsy) {
		this.yqsy = yqsy;
	}
	
	@ExcelField(title="电话号码", align=2, sort=20)
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	
	
	
	public String getBfzrr() {
		return bfzrr;
	}

	public void setBfzrr(String bfzrr) {
		this.bfzrr = bfzrr;
	}
	
	public String getBflxdh() {
		return bflxdh;
	}

	public void setBflxdh(String bflxdh) {
		this.bflxdh = bflxdh;
	}
	
	
	public void setSqczzj(BigDecimal sqczzj) {
		this.sqczzj = sqczzj;
	}
	
	
	public BigDecimal getGrcz() {
		return grcz;
	}

	public void setGrcz(BigDecimal grcz) {
		this.grcz = grcz;
	}
	
	
	public BigDecimal getQtbfzj() {
		return qtbfzj;
	}

	public void setQtbfzj(BigDecimal qtbfzj) {
		this.qtbfzj = qtbfzj;
	}
	
	
	public BigDecimal getHjzj() {
		hjzj = sqczzj.add(grcz).add(qtbfzj);
		return hjzj;
	}

	public void setHjzj(BigDecimal hjzj) {
		hjzj = sqczzj.add(grcz).add(qtbfzj);
	}
	
	
	public String getSsqx() {
		return ssqx;
	}

	public void setSsqx(String ssqx) {
		this.ssqx = ssqx;
	}
	
	
	public String getSsdd() {
		return ssdd;
	}

	public void setSsdd(String ssdd) {
		this.ssdd = ssdd;
	}
	
	
	public String getSsgm() {
		return ssgm;
	}

	public void setSsgm(String ssgm) {
		this.ssgm = ssgm;
	}
	
	
	
	
	public String getXzzt() {
		return xzzt;
	}

	public void setXzzt(String xzzt) {
		this.xzzt = xzzt;
	}
	
	public String getXmdckh() {
		return xmdckh;
	}

	public void setXmdckh(String xmdckh) {
		this.xmdckh = xmdckh;
	}

	public String getSareaId() {
		return sareaId;
	}

	public void setSareaId(String sareaId) {
		this.sareaId = sareaId;
	}
	
}