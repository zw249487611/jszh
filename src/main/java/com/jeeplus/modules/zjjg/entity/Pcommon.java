/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 县区项目方案确定Entity
 * @author xj
 * @version 2017-04-20
 */
public class Pcommon extends DataEntity<Pcommon> {
	
	private static final long serialVersionUID = 1L;
	private String fpid;		// 资金id
	private String pid;		// 项目id
	private String xmmc;		// 项目名称
	private String ssxid;		// 所属县id
	private String sszid;		// 所属镇id
	private String sscid;		// 所属村id
	private String ssx;		// 所属县
	private String ssz;		// 所属镇
	private String ssc;		// 所属村
	private String jbrxm;		// 经办人姓名
	private String sprxm;		// 审批人姓名
	private String xmssdw;		// 项目实施单位
	private String sjssdd;		// 时间实施地点
	private BigDecimal xmfpje;		// 项目分配金额
	private String xmfazl;		// 项目方案资料
	private String shxgzl;		// 审核相关资料
	private String shbz;		// 审核标志
	private String shr;		// 审核人
	private Date shrq;		// 审核日期
	private Date enddate;		// 截止日期
	private String type;		// 资金类型
	private String nd;		// 年度
	private String zjmc;		// 资金名称
	private String ssztlx;   // 实施主体类型  2 村  其他为镇  仅type=9有用
	private String fplx;
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public Pcommon() {
		super();
	}

	public Pcommon(String id){
		super(id);
	}

	@ExcelField(title="资金id", align=2, sort=1)
	public String getFpid() {
		return fpid;
	}

	public void setFpid(String fpid) {
		this.fpid = fpid;
	}
	
	@ExcelField(title="项目id", align=2, sort=2)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@ExcelField(title="项目名称", align=2, sort=3)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@ExcelField(title="所属县id", align=2, sort=4)
	public String getSsxid() {
		return ssxid;
	}

	public void setSsxid(String ssxid) {
		this.ssxid = ssxid;
	}
	
	@ExcelField(title="所属镇id", align=2, sort=5)
	public String getSszid() {
		return sszid;
	}

	public void setSszid(String sszid) {
		this.sszid = sszid;
	}
	
	@ExcelField(title="所属村id", align=2, sort=6)
	public String getSscid() {
		return sscid;
	}

	public void setSscid(String sscid) {
		this.sscid = sscid;
	}
	
	@ExcelField(title="所属县", align=2, sort=7)
	public String getSsx() {
		return ssx;
	}

	public void setSsx(String ssx) {
		this.ssx = ssx;
	}
	
	@ExcelField(title="所属镇", align=2, sort=8)
	public String getSsz() {
		return ssz;
	}

	public void setSsz(String ssz) {
		this.ssz = ssz;
	}
	
	@ExcelField(title="所属村", align=2, sort=9)
	public String getSsc() {
		return ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
	}
	
	@ExcelField(title="经办人姓名", align=2, sort=10)
	public String getJbrxm() {
		return jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}
	
	@ExcelField(title="审批人姓名", align=2, sort=11)
	public String getSprxm() {
		return sprxm;
	}

	public void setSprxm(String sprxm) {
		this.sprxm = sprxm;
	}
	
	@ExcelField(title="项目实施单位", align=2, sort=12)
	public String getXmssdw() {
		return xmssdw;
	}

	public void setXmssdw(String xmssdw) {
		this.xmssdw = xmssdw;
	}
	
	@ExcelField(title="时间实施地点", align=2, sort=13)
	public String getSjssdd() {
		return sjssdd;
	}

	public void setSjssdd(String sjssdd) {
		this.sjssdd = sjssdd;
	}
	
	@ExcelField(title="项目分配金额", align=2, sort=14)
	public BigDecimal getXmfpje() {
		return xmfpje;
	}

	public void setXmfpje(BigDecimal xmfpje) {
		this.xmfpje = xmfpje;
	}
	
	@ExcelField(title="项目方案资料", align=2, sort=15)
	public String getXmfazl() {
		return xmfazl;
	}

	public void setXmfazl(String xmfazl) {
		this.xmfazl = xmfazl;
	}
	
	@ExcelField(title="审核相关资料", align=2, sort=16)
	public String getShxgzl() {
		return shxgzl;
	}

	public void setShxgzl(String shxgzl) {
		this.shxgzl = shxgzl;
	}
	
	@ExcelField(title="审核标志", align=2, sort=17)
	public String getShbz() {
		return shbz;
	}

	public void setShbz(String shbz) {
		this.shbz = shbz;
	}
	
	@ExcelField(title="审核人", align=2, sort=18)
	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="审核日期", align=2, sort=19)
	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}
	
	@ExcelField(title="资金类型", align=2, sort=20)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSsztlx() {
		return ssztlx;
	}

	public void setSsztlx(String ssztlx) {
		this.ssztlx = ssztlx;
	}

	public String getFplx() {
		return fplx;
	}

	public void setFplx(String fplx) {
		this.fplx = fplx;
	}

}