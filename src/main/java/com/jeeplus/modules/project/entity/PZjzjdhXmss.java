/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 资金直接到户-实施Entity
 * @author cdf
 * @version 2017-03-07
 */
public class PZjzjdhXmss extends DataEntity<PZjzjdhXmss> {
	
	private static final long serialVersionUID = 1L;
	private PZjzjdhXmsb plxid;		// 项目名
	private String sbzj;		// 实施情况
	private String shqk;		// 审核情况
	private String shren;		// 审核人
	private String xmhzb;		// 项目汇总表
	private String zibfsq;		// 资金拨付申请
	private String sstp;		// 实施图片
	private String ssddjwd;		// 实施地点经纬度
	
	public PZjzjdhXmss() {
		super();
	}

	public PZjzjdhXmss(String id){
		super(id);
	}

	@NotNull(message="项目名不能为空")
	@ExcelField(title="项目名", align=2, sort=1)
	public PZjzjdhXmsb getPlxid() {
		return plxid;
	}

	public void setPlxid(PZjzjdhXmsb plxid) {
		this.plxid = plxid;
	}
	
	@ExcelField(title="实施情况", align=2, sort=2)
	public String getSbzj() {
		return sbzj;
	}

	public void setSbzj(String sbzj) {
		this.sbzj = sbzj;
	}
	
//	@ExcelField(title="审核情况", align=2, sort=3)
	public String getShqk() {
		return shqk;
	}

	public void setShqk(String shqk) {
		this.shqk = shqk;
	}
	
//	@ExcelField(title="审核人", align=2, sort=4)
	public String getShren() {
		return shren;
	}

	public void setShren(String shren) {
		this.shren = shren;
	}
	
	@ExcelField(title="项目汇总表", align=2, sort=5)
	public String getXmhzb() {
		return xmhzb;
	}

	public void setXmhzb(String xmhzb) {
		this.xmhzb = xmhzb;
	}
	
	@ExcelField(title="资金拨付申请", align=2, sort=6)
	public String getZibfsq() {
		return zibfsq;
	}

	public void setZibfsq(String zibfsq) {
		this.zibfsq = zibfsq;
	}

	public String getSstp() {
		return sstp;
	}

	public void setSstp(String sstp) {
		this.sstp = sstp;
	}

	@ExcelField(title="实施地点经纬度", align=2, sort=7)
	public String getSsddjwd() {
		return ssddjwd;
	}

	public void setSsddjwd(String ssddjwd) {
		this.ssddjwd = ssddjwd;
	}
	
}