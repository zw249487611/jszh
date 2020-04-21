/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;


import java.math.BigDecimal;
import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * xmgcyjEntity
 * @author lil
 * @version 2017-07-31
 */
public class PXmzflrtj_Export extends DataEntity<PXmzflrtj_Export> {
	
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
	private String ssztlx;    // 实施主体类型  2 村   1或空均为镇  目前仅type=9 --产业扶贫有用
	
	//2018-1-12zhangwei添加
	//private String id;		// id
	private String bdcxq;		//被调查县区
	private String xmmc1;		// 项目名称
	

	private String sfzf;		//是否走访
	private String xmjztx;		//项目进展填写
	private String sjsytx;		//实际收益填写
	private String sjfphtx;		//实际分配户填写
	private String pgfxtx;		//评估分析填写
	private String kjswsdxm;	//会计事务所对项目运行情况分析填写
	private String zjsyytx;		//资金使用用途填写
	private String zjsyczwt;	//资金使用存在问题
	
	private String yqsytx; 		//预期收益填写
	private String jxpgtx; 		//绩效评估填写
	private String nf;
	private Integer quarter;
	
	@ExcelField(title = "年度", align = 2, sort = 10)
	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}
	@ExcelField(title = "季度", align = 2, sort = 11)
	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	@ExcelField(title = "被调查县区", align = 2, sort = 1)
	public String getBdcxq() {
		return bdcxq;
	}

	public void setBdcxq(String bdcxq) {
		this.bdcxq = bdcxq;
	}
	@ExcelField(title = "项目名称", align = 2, sort = 2)
	public String getXmmc1() {
		return xmmc1;
	}

	public void setXmmc1(String xmmc1) {
		this.xmmc1 = xmmc1;
	}
	@ExcelField(title = "是否走访", align = 2, sort = 3)
	public String getSfzf() {
		return sfzf;
	}

	public void setSfzf(String sfzf) {
		this.sfzf = sfzf;
	}

	@ExcelField(title = "项目进展填写", align = 2, sort = 4)
	public String getXmjztx() {
		return xmjztx;
	}

	public void setXmjztx(String xmjztx) {
		this.xmjztx = xmjztx;
	}

	@ExcelField(title = "预期收益填写", align = 2, sort = 5)
	public String getYqsytx() {
		return yqsytx;
	}

	public void setYqsytx(String yqsytx) {
		this.yqsytx = yqsytx;
	}

	@ExcelField(title = "绩效评估填写", align = 2, sort = 6)
	public String getJxpgtx() {
		return jxpgtx;
	}

	public void setJxpgtx(String jxpgtx) {
		this.jxpgtx = jxpgtx;
	}

	public PXmzflrtj_Export() {
		super();
	}

	public PXmzflrtj_Export(String id){
		super(id);
	}

	public String getFpid() {
		return fpid;
	}

	public void setFpid(String fpid) {
		this.fpid = fpid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getXmmc() {
		return xmmc;
	}

	
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getSsxid() {
		return ssxid;
	}

	public void setSsxid(String ssxid) {
		this.ssxid = ssxid;
	}

	public String getSszid() {
		return sszid;
	}

	public void setSszid(String sszid) {
		this.sszid = sszid;
	}

	public String getSscid() {
		return sscid;
	}

	public void setSscid(String sscid) {
		this.sscid = sscid;
	}

	public String getSsx() {
		return ssx;
	}

	public void setSsx(String ssx) {
		this.ssx = ssx;
	}

	public String getSsz() {
		return ssz;
	}

	public void setSsz(String ssz) {
		this.ssz = ssz;
	}

	public String getSsc() {
		return ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
	}

	public String getJbrxm() {
		return jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}

	public String getSprxm() {
		return sprxm;
	}

	public void setSprxm(String sprxm) {
		this.sprxm = sprxm;
	}

	public String getXmssdw() {
		return xmssdw;
	}

	public void setXmssdw(String xmssdw) {
		this.xmssdw = xmssdw;
	}

	public String getSjssdd() {
		return sjssdd;
	}

	public void setSjssdd(String sjssdd) {
		this.sjssdd = sjssdd;
	}

	public BigDecimal getXmfpje() {
		return xmfpje;
	}

	public void setXmfpje(BigDecimal xmfpje) {
		this.xmfpje = xmfpje;
	}

	public String getXmfazl() {
		return xmfazl;
	}

	public void setXmfazl(String xmfazl) {
		this.xmfazl = xmfazl;
	}

	public String getShxgzl() {
		return shxgzl;
	}

	public void setShxgzl(String shxgzl) {
		this.shxgzl = shxgzl;
	}

	public String getShbz() {
		return shbz;
	}

	public void setShbz(String shbz) {
		this.shbz = shbz;
	}

	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

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

	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}

	public String getSsztlx() {
		return ssztlx;
	}

	public void setSsztlx(String ssztlx) {
		this.ssztlx = ssztlx;
	}

	public String getSjsytx() {
		return sjsytx;
	}

	public void setSjsytx(String sjsytx) {
		this.sjsytx = sjsytx;
	}

	public String getSjfphtx() {
		return sjfphtx;
	}

	public void setSjfphtx(String sjfphtx) {
		this.sjfphtx = sjfphtx;
	}

	public String getPgfxtx() {
		return pgfxtx;
	}

	public void setPgfxtx(String pgfxtx) {
		this.pgfxtx = pgfxtx;
	}

	public String getKjswsdxm() {
		return kjswsdxm;
	}

	public void setKjswsdxm(String kjswsdxm) {
		this.kjswsdxm = kjswsdxm;
	}

	public String getZjsyytx() {
		return zjsyytx;
	}

	public void setZjsyytx(String zjsyytx) {
		this.zjsyytx = zjsyytx;
	}

	public String getZjsyczwt() {
		return zjsyczwt;
	}

	public void setZjsyczwt(String zjsyczwt) {
		this.zjsyczwt = zjsyczwt;
	}

	
	
	
	
}