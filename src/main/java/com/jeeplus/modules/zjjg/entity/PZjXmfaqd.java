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
public class PZjXmfaqd extends DataEntity<PZjXmfaqd> {
	
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
	private String fplx;
	public String getFplx() {
		return fplx;
	}

	public void setFplx(String fplx) {
		this.fplx = fplx;
	}

	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	
	
	public String getBdcxq() {
		return bdcxq;
	}

	public void setBdcxq(String bdcxq) {
		this.bdcxq = bdcxq;
	}

	public String getXmmc1() {
		return xmmc1;
	}

	public void setXmmc1(String xmmc1) {
		this.xmmc1 = xmmc1;
	}

	public String getSfzf() {
		return sfzf;
	}

	public void setSfzf(String sfzf) {
		this.sfzf = sfzf;
	}

	public String getXmjztx() {
		return xmjztx;
	}

	public void setXmjztx(String xmjztx) {
		this.xmjztx = xmjztx;
	}

	public String getYqsytx() {
		return yqsytx;
	}

	public void setYqsytx(String yqsytx) {
		this.yqsytx = yqsytx;
	}

	public String getJxpgtx() {
		return jxpgtx;
	}

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

	public PZjXmfaqd() {
		super();
	}

	public PZjXmfaqd(String id){
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

	public void setJxpgtx(String jxpgtx) {
		this.jxpgtx = jxpgtx;
	}
	
}