/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;


/**
 * 绩效评估Entity
 * @author xuj
 * @version 2017-03-29
 */
public class XmjzInfoVo{
	
	private static final long serialVersionUID = 1L;
	//县区
	private String xq;
	//项目名称
	private String xmmc;
	//目前状态
	private String mqzt;
	//项目类型
	private String type;
	public String getXq() {
		return xq;
	}
	public void setXq(String xq) {
		this.xq = xq;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getMqzt() {
		return mqzt;
	}
	public void setMqzt(String mqzt) {
		this.mqzt = mqzt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}