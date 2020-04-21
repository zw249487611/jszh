/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.modules.project.entity.PZjzjdhXmsb;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 审核Entity
 * @author maojl
 * @version 2017-03-03
 */
public class PZjzjdhXmsh extends DataEntity<PZjzjdhXmsh> {
	
	private static final long serialVersionUID = 1L;
	private PZjzjdhXmsb pro;		// 项目立项编号
	private String xmmc;		// 项目名称
	private String shqk;		// 审核情况
	private String shren;		// 审核人
	private String xmspb;		// 项目审批表
	private Date shrq;		// 审核日期
	private String sftg;		// 是否通过
	private String xmshyj;		// 项目审核意见
	private Date beginShrq;		// 开始 审核日期
	private Date endShrq;		// 结束 审核日期
	
	public PZjzjdhXmsh() {
		super();
	}

	public PZjzjdhXmsh(String id){
		super(id);
	}

	@NotNull(message="项目立项编号不能为空")
	@ExcelField(title="项目立项编号", align=2, sort=1)
	public PZjzjdhXmsb getPro() {
		return pro;
	}

	public void setPro(PZjzjdhXmsb pro) {
		this.pro = pro;
	}
	
	@ExcelField(title="项目名称", align=2, sort=2)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	
	@ExcelField(title="审核情况", dictType="", align=2, sort=3)
	public String getShqk() {
		return shqk;
	}

	public void setShqk(String shqk) {
		this.shqk = shqk;
	}
	
	@ExcelField(title="审核人", align=2, sort=4)
	public String getShren() {
		return shren;
	}

	public void setShren(String shren) {
		this.shren = shren;
	}
	
	@ExcelField(title="项目审批表", align=2, sort=5)
	public String getXmspb() {
		return xmspb;
	}

	public void setXmspb(String xmspb) {
		this.xmspb = xmspb;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="审核日期不能为空")
	@ExcelField(title="审核日期", align=2, sort=6)
	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}
	
	@ExcelField(title="是否通过", dictType="", align=2, sort=7)
	public String getSftg() {
		return sftg;
	}

	public void setSftg(String sftg) {
		this.sftg = sftg;
	}
	
	@ExcelField(title="项目审核意见", align=2, sort=8)
	public String getXmshyj() {
		return xmshyj;
	}

	public void setXmshyj(String xmshyj) {
		this.xmshyj = xmshyj;
	}
	
	public Date getBeginShrq() {
		return beginShrq;
	}

	public void setBeginShrq(Date beginShrq) {
		this.beginShrq = beginShrq;
	}
	
	public Date getEndShrq() {
		return endShrq;
	}

	public void setEndShrq(Date endShrq) {
		this.endShrq = endShrq;
	}
		
}