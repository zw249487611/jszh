/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.vo;


/**
 * 绩效评估Entity
 * @author xuj
 * @version 2017-03-29
 */
public class XiangzhenzfqkVo{
	
	private static final long serialVersionUID = 1L;
	//镇名称
	private String name;
	//贫困村或者贫困户数
	private int pks;
	//帮扶责任人
	private int bfrs;
	//走访次数
	private int zfcs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPks() {
		return pks;
	}
	public void setPks(int pks) {
		this.pks = pks;
	}
	public int getBfrs() {
		return bfrs;
	}
	public void setBfrs(int bfrs) {
		this.bfrs = bfrs;
	}
	public int getZfcs() {
		return zfcs;
	}
	public void setZfcs(int zfcs) {
		this.zfcs = zfcs;
	}
	
}