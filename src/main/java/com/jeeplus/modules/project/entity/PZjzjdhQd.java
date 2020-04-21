/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.project.entity;

import com.jeeplus.modules.sys.entity.Area;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 项目启动Entity
 * @author maojl
 * @version 2017-03-01
 */
public class PZjzjdhQd extends DataEntity<PZjzjdhQd> {
	
	private static final long serialVersionUID = 1L;
	private Area sarea;		// 区划编号
	private String zxmmc;		// 主项目名称
	private String xmssdx;		// 项目实施对象
	private String xmssnr;		// 项目实施内容
	private String xmbzbz;		// 项目补助标准
	private String xmsssj;		// 项目实施时间
	private String xmdckh;		// 项目督查考核
	private Date shrq;		// 审核日期
	private String nd;		// 年度
	private Area area;		// 所在县
	private String dqzt;		// 当前状态
	private String hyjy;		// 会议纪要
	private String cbfa;		// 初步方案
	private String zffw;		// 政府发文
	private String qtfj;		// 其他附件
	private String ssdq;		//所属地区
	
	public PZjzjdhQd() {
		super();
	}

	public PZjzjdhQd(String id){
		super(id);
	}

	/*@ExcelField(title="区划编号", align=2, sort=1)*/
	public Area getSarea() {
		return sarea;
	}

	public void setSarea(Area sarea) {
		this.sarea = sarea;
	}
	
	@NotNull(message="项目名称不能为空")
	@ExcelField(title="项目名称", align=2, sort=2)
	public String getZxmmc() {
		return zxmmc;
	}

	public void setZxmmc(String zxmmc) {
		this.zxmmc = zxmmc;
	}
	
	/*@ExcelField(title="项目实施对象", align=2, sort=3)*/
	public String getXmssdx() {
		return xmssdx;
	}

	public void setXmssdx(String xmssdx) {
		this.xmssdx = xmssdx;
	}
	
	/*@ExcelField(title="项目实施内容", align=2, sort=4)*/
	public String getXmssnr() {
		return xmssnr;
	}

	public void setXmssnr(String xmssnr) {
		this.xmssnr = xmssnr;
	}
	
	/*@ExcelField(title="项目补助标准", align=2, sort=5)*/
	public String getXmbzbz() {
		return xmbzbz;
	}

	public void setXmbzbz(String xmbzbz) {
		this.xmbzbz = xmbzbz;
	}
	
	/*@ExcelField(title="项目实施时间", align=2, sort=6)*/
	public String getXmsssj() {
		return xmsssj;
	}

	public void setXmsssj(String xmsssj) {
		this.xmsssj = xmsssj;
	}
	
	/*@ExcelField(title="项目督查考核", align=2, sort=7)*/
	public String getXmdckh() {
		return xmdckh;
	}

	public void setXmdckh(String xmdckh) {
		this.xmdckh = xmdckh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	/*@ExcelField(title="审核日期", align=2, sort=8)*/
	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}
	
	@ExcelField(title="年度", align=2, sort=9)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
	@ExcelField(title="所在县", fieldType=Area.class, value="area.name", align=2, sort=10)
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@ExcelField(title="当前状态", dictType="xmzt", align=2, sort=11)
	public String getDqzt() {
		return dqzt;
	}

	public void setDqzt(String dqzt) {
		this.dqzt = dqzt;
	}
	
	/*@ExcelField(title="会议纪要", align=2, sort=12)*/
	public String getHyjy() {
		return hyjy;
	}

	public void setHyjy(String hyjy) {
		this.hyjy = hyjy;
	}
	
	/*@ExcelField(title="初步方案", align=2, sort=13)*/
	public String getCbfa() {
		return cbfa;
	}

	public void setCbfa(String cbfa) {
		this.cbfa = cbfa;
	}
	
	/*@ExcelField(title="政府发文", align=2, sort=14)*/
	public String getZffw() {
		return zffw;
	}

	public void setZffw(String zffw) {
		this.zffw = zffw;
	}
	
	/*@ExcelField(title="其他附件", align=2, sort=15)*/
	public String getQtfj() {
		return qtfj;
	}

	public void setQtfj(String qtfj) {
		this.qtfj = qtfj;
	}

	public String getSsdq() {
		return ssdq;
	}

	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}
	
}