/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jeeplus.common.persistence.DataEntity;

/**
 * 资金运行信息Entity
 * @author maojl
 * @version 2017-09-04
 */
public class XmsyInfoVo extends DataEntity<XmsyInfoVo> {
	
	private static final long serialVersionUID = 1L;
	private String xmid;//项目id
	private Date ydsysj;//合同约定收益时间
	private Date sjsysj;//实际收益时间
	private BigDecimal ydsyje;//合同约定收益金额
	private BigDecimal sjsyje;//实际收益金额
	private BigDecimal sjsyl;//实际收益率（实际收益/实际投入）
	private String sygjdw;//收益归集单位
	private String syfpshdw;//收益分配方案审核单位
	private BigDecimal cyfpsyje;//参与分配收益金额
	private String sydcId;//收益到村Id
	private BigDecimal sydcje;//收益到村金额
	private String sydhId;//收益到户Id
	private BigDecimal sydhje;//收益到户金额
	private String sszt;//实施主体
	private BigDecimal fpdxmje;//分配到项目资金额（万元）
	
	public String getXmid() {
		return xmid;
	}
	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	public Date getYdsysj() {
		return ydsysj;
	}
	public void setYdsysj(Date ydsysj) {
		this.ydsysj = ydsysj;
	}
	public Date getSjsysj() {
		return sjsysj;
	}
	public void setSjsysj(Date sjsysj) {
		this.sjsysj = sjsysj;
	}
	public BigDecimal getYdsyje() {
		return ydsyje;
	}
	public void setYdsyje(BigDecimal ydsyje) {
		this.ydsyje = ydsyje;
	}
	public BigDecimal getSjsyje() {
		return sjsyje;
	}
	public void setSjsyje(BigDecimal sjsyje) {
		this.sjsyje = sjsyje;
	}
	public BigDecimal getSjsyl() {
		return sjsyl;
	}
	public void setSjsyl(BigDecimal sjsyl) {
		this.sjsyl = sjsyl;
	}
	public String getSygjdw() {
		return sygjdw;
	}
	public void setSygjdw(String sygjdw) {
		this.sygjdw = sygjdw;
	}
	public String getSyfpshdw() {
		return syfpshdw;
	}
	public void setSyfpshdw(String syfpshdw) {
		this.syfpshdw = syfpshdw;
	}
	public BigDecimal getCyfpsyje() {
		return cyfpsyje;
	}
	public void setCyfpsyje(BigDecimal cyfpsyje) {
		this.cyfpsyje = cyfpsyje;
	}
	public BigDecimal getSydcje() {
		return sydcje;
	}
	public void setSydcje(BigDecimal sydcje) {
		this.sydcje = sydcje;
	}
	public BigDecimal getSydhje() {
		return sydhje;
	}
	public void setSydhje(BigDecimal sydhje) {
		this.sydhje = sydhje;
	}
	public String getSydcId() {
		return sydcId;
	}
	public void setSydcId(String sydcId) {
		this.sydcId = sydcId;
	}
	public String getSydhId() {
		return sydhId;
	}
	public void setSydhId(String sydhId) {
		this.sydhId = sydhId;
	}
	public String getSszt() {
		return sszt;
	}
	public void setSszt(String sszt) {
		this.sszt = sszt;
	}
	public BigDecimal getFpdxmje() {
		return fpdxmje;
	}
	public void setFpdxmje(BigDecimal fpdxmje) {
		this.fpdxmje = fpdxmje;
	}
}