/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 确认及拨款Entity
 * @author lhq
 * @version 2017-03-13
 */
public class PZjZhddw extends DataEntity<PZjZhddw> {
	
	private static final long serialVersionUID = 1L;
	private String fpid;		// 方案分配编号
	private String ssx;			// 所属县
	private String ssxid;		// 所属县编号
	private String ssz;			// 所属镇
	private String sszid;		// 所属镇编号
	private String xmmc;		// 项目名称
	private String jbrxm;		// 经办人姓名
	private String sprxm;		// 审批人姓名
	private String xmssdw;		// 项目实施单位
	private BigDecimal xmje = new BigDecimal(0);		// 项目金额
	private String spr;			// 审批人
	private Date sprq;			// 审批日期
	private String spzt;		// 审批状态
	private String zfsqd;		// 支付申请单
	private String bkd;			// 拨款单
	private String code;		// 统筹区编号
	private String type;		// 类型
	private String nd;			// 年度
	private Date bksj;			// 拨款时间
	private Date enddate;		// 截止时间
	private String pzh;			// 凭证号
	private BigDecimal  bkje;    //拨款金额 
	private  BigDecimal cxdje = new BigDecimal(0);		// 项目金额
	
	
	public BigDecimal getCxdje() {
		return cxdje;
	}

	public void setCxdje(BigDecimal cxdje) {
		this.cxdje = cxdje;
	}

	public BigDecimal getBkje() {
		return bkje;
	}

	public void setBkje(BigDecimal bkje) {
		this.bkje = bkje;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getBksj() {
		return bksj;
	}

	public void setBksj(Date bksj) {
		this.bksj = bksj;
	}

	public String getPzh() {
		return pzh;
	}

	public void setPzh(String pzh) {
		this.pzh = pzh;
	}

	public PZjZhddw() {
		super();
	}

	public PZjZhddw(String id){
		super(id);
	}

	@NotNull(message="方案分配编号不能为空")
	@ExcelField(title="方案分配编号", align=2, sort=1)
	public String getFpid() {
		return fpid;
	}

	public void setFpid(String fpid) {
		this.fpid = fpid;
	}
	
	@ExcelField(title="所属乡", align=2, sort=2)
	public String getSsx() {
		return ssx;
	}

	public void setSsx(String ssx) {
		this.ssx = ssx;
	}
	
	public String getSsxid() {
		return ssxid;
	}

	public void setSsxid(String ssxid) {
		this.ssxid = ssxid;
	}

	public String getSsz() {
		return ssz;
	}

	public void setSsz(String ssz) {
		this.ssz = ssz;
	}

	public String getSszid() {
		return sszid;
	}

	public void setSszid(String sszid) {
		this.sszid = sszid;
	}

	@ExcelField(title="项目名称", align=2, sort=3)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@ExcelField(title="经办人姓名", align=2, sort=4)
	public String getJbrxm() {
		return jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}
	
	@ExcelField(title="审批人姓名", align=2, sort=5)
	public String getSprxm() {
		return sprxm;
	}

	public void setSprxm(String sprxm) {
		this.sprxm = sprxm;
	}
	
	@ExcelField(title="项目实施单位", align=2, sort=6)
	public String getXmssdw() {
		return xmssdw;
	}

	public void setXmssdw(String xmssdw) {
		this.xmssdw = xmssdw;
	}
	
	@NotNull(message="项目金额不能为空")
	@ExcelField(title="项目金额", align=2, sort=7)
	public BigDecimal getXmje() {
		return xmje;
	}

	public void setXmje(BigDecimal xmje) {
		this.xmje = xmje;
	}
	
	@ExcelField(title="审批人", align=2, sort=8)
	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="审批日期", align=2, sort=9)
	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}
	
	@ExcelField(title="审批状态", align=2, sort=10)
	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}
	
	@ExcelField(title="支付申请单", align=2, sort=11)
	public String getZfsqd() {
		return zfsqd;
	}

	public void setZfsqd(String zfsqd) {
		this.zfsqd = zfsqd;
	}
	
	@ExcelField(title="拨款单", align=2, sort=12)
	public String getBkd() {
		return bkd;
	}

	public void setBkd(String bkd) {
		this.bkd = bkd;
	}
	
	@ExcelField(title="统筹区编号", align=2, sort=19)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@ExcelField(title="类型", align=2, sort=20)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
}