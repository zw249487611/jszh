/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.ipwhitelist.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * ip白名单Entity
 * @author maojl
 * @version 2019-01-23
 */
public class IpWhiteList extends DataEntity<IpWhiteList> {
	
	private static final long serialVersionUID = 1L;
	private String beginIp;		// 开始ip
	private String endIp;		// 结束ip
	private String qdbz;		// 是否启用
	
	public IpWhiteList() {
		super();
	}

	public IpWhiteList(String id){
		super(id);
	}

	@ExcelField(title="开始ip", align=2, sort=7)
	public String getBeginIp() {
		return beginIp;
	}

	public void setBeginIp(String beginIp) {
		this.beginIp = beginIp;
	}
	
	@ExcelField(title="结束ip", align=2, sort=8)
	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	
	@ExcelField(title="是否启用", dictType="", align=2, sort=9)
	public String getQdbz() {
		return qdbz;
	}

	public void setQdbz(String qdbz) {
		this.qdbz = qdbz;
	}
	
}