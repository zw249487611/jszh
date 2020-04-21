/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.zjjg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 数据上报Entity
 * @author dingl
 * @version 2017-03-12
 */
public class PZjSjsb extends DataEntity<PZjSjsb> {
	
	private static final long serialVersionUID = 1L;
	private PZjXmfaqd fpid;		// 方案分配编号
	private String zjmc;		// 资金名称
	private String pid;			// 项目编号
	private String xmmc;		// 项目名称
	private String ssq;			// 所属区
	private String ssqcode;		// 所属区
	private String jbrxm;		// 经办人姓名
	private String sprxm;		// 审批人姓名
	private BigDecimal xdje;	// 下达金额
	private BigDecimal cxdje;    //村下达金额
	private String ssdd;		// 实施地点(现所属村)
	private String ssddcode;	// 所属村父ID
	private String xmssjd;		// 项目实施进度
	private String spr;			// 审批人
	private Date sprq;			// 审批日期
	private String spzt;		// 审批状态
	private String xmjd;		// 项目阶段
	private String ssfa;		// 实施方案
	private String hyjy;		// 会议纪要
	private String gscl;		// 公示材料
	private String xmlx;		// 项目类型
	private String xczp;		// 现场照片
	private String zbtzs;		// 中标通知书
	private String xckyb;		// 现场勘验表
	private String ysbg;		// 验收报告
	private String jlbg;		// 监理报告
	private String sjbg;		// 审计报告
	private String qtcl;		// 其它材料
	private String code;		// 统筹区编号
	private String type;		// 类型
	private String bhzt;		// 驳回状态
	private String flag;		// 标识位
	private String nd;			// 标识位
	
	private String zbdlht;			// 招标代理合同
	private String sjht;			// 设计合同
	private String sght;			// 施工合同
	private String jlht;			// 监理合同
	private String lybh;			// 履约保函
	private String gcjld;			// 工程计量单
	private String fpzzzp;			// 发票、转账支票
	private String zfsqd;        //支付申请单
	private String qtht;        //其他合同
	private String ms;        //描述
	private String bkid;        //拨款id
	private Date enddate;      //截止日期
	private Date bksj;        //拨款时间
	private BigDecimal sumXdje;      
	private String ssztlx; // 实施主体类型  2 为村  其他为镇  仅type=9时候有作用
	
	//1-6张威添加
	private String isbk;//是否拨款
	
	//子项目个数
	private String count;
	
	//资金拨付进度
	private String zjbfjd;
	
	//项目实施进度比较(1:>= 2:<= 3:=)
	private String compXmssjd;
	
	//资金拨付进度比较(1:>= 2:<= 3:=)
	private String compZjbfjd;
	
	private String isYj;//是否预警

	public String getIsbk() {
		return isbk;
	}

	public void setIsbk(String isbk) {
		this.isbk = isbk;
	}

	public BigDecimal getSumXdje() {
		return sumXdje;
	}

	public void setSumXdje(BigDecimal sumXdje) {
		this.sumXdje = sumXdje;
	}

	public Date getBksj() {
		return bksj;
	}

	public void setBksj(Date bksj) {
		this.bksj = bksj;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getQtht() {
		return qtht;
	}

	public void setQtht(String qtht) {
		this.qtht = qtht;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getZfsqd() {
		return zfsqd;
	}

	public void setZfsqd(String zfsqd) {
		this.zfsqd = zfsqd;
	}

	public BigDecimal getCxdje() {
		return cxdje;
	}

	public void setCxdje(BigDecimal cxdje) {
		this.cxdje = cxdje;
	}

	public String getZbdlht() {
		return zbdlht;
	}

	public void setZbdlht(String zbdlht) {
		this.zbdlht = zbdlht;
	}

	public String getSjht() {
		return sjht;
	}

	public void setSjht(String sjht) {
		this.sjht = sjht;
	}

	public String getSght() {
		return sght;
	}

	public void setSght(String sght) {
		this.sght = sght;
	}

	public String getJlht() {
		return jlht;
	}

	public void setJlht(String jlht) {
		this.jlht = jlht;
	}

	public String getLybh() {
		return lybh;
	}

	public void setLybh(String lybh) {
		this.lybh = lybh;
	}

	public String getGcjld() {
		return gcjld;
	}

	public void setGcjld(String gcjld) {
		this.gcjld = gcjld;
	}

	public String getFpzzzp() {
		return fpzzzp;
	}

	public void setFpzzzp(String fpzzzp) {
		this.fpzzzp = fpzzzp;
	}

	public PZjSjsb() {
		super();
	}

	public PZjSjsb(String id){
		super(id);
	}

	@ExcelField(title="方案分配编号", align=2, sort=1)
	public PZjXmfaqd getFpid() {
		return fpid;
	}

	public void setFpid(PZjXmfaqd fpid) {
		this.fpid = fpid;
	}
	
	@ExcelField(title="所属区", align=2, sort=2)
	public String getSsq() {
		return ssq;
	}

	public void setSsq(String ssq) {
		this.ssq = ssq;
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
	
	@NotNull(message="下达金额不能为空")
	@ExcelField(title="下达金额", align=2, sort=6)
	public BigDecimal getXdje() {
		return xdje;
	}

	public void setXdje(BigDecimal xdje) {
		this.xdje = xdje;
	}
	
	@ExcelField(title="实施地点", align=2, sort=7)
	public String getSsdd() {
		return ssdd;
	}

	public void setSsdd(String ssdd) {
		this.ssdd = ssdd;
	}
	
	@ExcelField(title="项目实施进度", dictType="xmssjd", align=2, sort=8)
	public String getXmssjd() {
		return xmssjd;
	}

	public void setXmssjd(String xmssjd) {
		this.xmssjd = xmssjd;
	}
	
	@ExcelField(title="审批人", align=2, sort=9)
	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="审批日期", align=2, sort=10)
	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}
	
	@ExcelField(title="审批状态", align=2, sort=11)
	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}
	
	@ExcelField(title="项目阶段", align=2, sort=12)
	public String getXmjd() {
		return xmjd;
	}

	public void setXmjd(String xmjd) {
		this.xmjd = xmjd;
	}
	
	@ExcelField(title="实施方案", align=2, sort=13)
	public String getSsfa() {
		return ssfa;
	}

	public void setSsfa(String ssfa) {
		this.ssfa = ssfa;
	}
	
	@ExcelField(title="会议纪要", align=2, sort=14)
	public String getHyjy() {
		return hyjy;
	}

	public void setHyjy(String hyjy) {
		this.hyjy = hyjy;
	}
	
	@ExcelField(title="公示材料", align=2, sort=15)
	public String getGscl() {
		return gscl;
	}

	public void setGscl(String gscl) {
		this.gscl = gscl;
	}
	
	@ExcelField(title="项目类型", align=2, sort=16)
	public String getXmlx() {
		return xmlx;
	}

	public void setXmlx(String xmlx) {
		this.xmlx = xmlx;
	}
	
	@ExcelField(title="项目编号", align=2, sort=17)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@ExcelField(title="现场照片", align=2, sort=18)
	public String getXczp() {
		return xczp;
	}

	public void setXczp(String xczp) {
		this.xczp = xczp;
	}
	
	@ExcelField(title="中标通知书", align=2, sort=19)
	public String getZbtzs() {
		return zbtzs;
	}

	public void setZbtzs(String zbtzs) {
		this.zbtzs = zbtzs;
	}
	
	@ExcelField(title="现场勘验表", align=2, sort=20)
	public String getXckyb() {
		return xckyb;
	}

	public void setXckyb(String xckyb) {
		this.xckyb = xckyb;
	}
	
	@ExcelField(title="验收报告", align=2, sort=21)
	public String getYsbg() {
		return ysbg;
	}

	public void setYsbg(String ysbg) {
		this.ysbg = ysbg;
	}
	
	@ExcelField(title="监理报告", align=2, sort=22)
	public String getJlbg() {
		return jlbg;
	}

	public void setJlbg(String jlbg) {
		this.jlbg = jlbg;
	}
	
	@ExcelField(title="审计报告", align=2, sort=23)
	public String getSjbg() {
		return sjbg;
	}

	public void setSjbg(String sjbg) {
		this.sjbg = sjbg;
	}
	
	@ExcelField(title="其它材料", align=2, sort=24)
	public String getQtcl() {
		return qtcl;
	}

	public void setQtcl(String qtcl) {
		this.qtcl = qtcl;
	}
	
	@ExcelField(title="统筹区编号", align=2, sort=25)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@ExcelField(title="类型", align=2, sort=32)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="驳回状态", align=2, sort=32)
	public String getBhzt() {
		return bhzt;
	}

	public void setBhzt(String bhzt) {
		this.bhzt = bhzt;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getSsqcode() {
		return ssqcode;
	}

	public void setSsqcode(String ssqcode) {
		this.ssqcode = ssqcode;
	}

	public String getSsddcode() {
		return ssddcode;
	}

	public void setSsddcode(String ssddcode) {
		this.ssddcode = ssddcode;
	}

	public String getSsztlx() {
		return ssztlx;
	}

	public void setSsztlx(String ssztlx) {
		this.ssztlx = ssztlx;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getZjbfjd() {
		return zjbfjd;
	}

	public void setZjbfjd(String zjbfjd) {
		this.zjbfjd = zjbfjd;
	}

	public String getCompXmssjd() {
		return compXmssjd;
	}

	public void setCompXmssjd(String compXmssjd) {
		this.compXmssjd = compXmssjd;
	}

	public String getCompZjbfjd() {
		return compZjbfjd;
	}

	public void setCompZjbfjd(String compZjbfjd) {
		this.compZjbfjd = compZjbfjd;
	}

	public String getIsYj() {
		return isYj;
	}

	public void setIsYj(String isYj) {
		this.isYj = isYj;
	}
	
	
}