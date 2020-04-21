/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.app.vo;


import java.util.List;
import java.util.Map;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 医疗保障信息Entity
 * @author chenll
 * @version 2019-03-31
 */
public class RhzfYlbzVo extends DataEntity<RhzfYlbzVo> {
	
	private static final long serialVersionUID = 1L;
	private String acId="";		// 贫困户id
	private String name="";		// 姓名
	private String jkzk="";		// 健康状况
	private String mxb="";		// 长期慢性病
	private String mxbName="";		// 长期慢性病名称
	private String hydb="";		// 患有大病
	private String hydbName="";		// 患有大病名称
	private String isjz="";//是否得到了救助
	private String remark="";//备注
	private String acid="";		// 贫困户id
	
	private List<Map<String, String>> mxbMap;   // 慢性病集合
	private List<Map<String, String>> hydbMap;   // 患有大病集合
	
	private String xq;
	private String xz;
	private String cj;
	private String xqName;
	private String xzName;
	private String cjName;
	
	
	
	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getCj() {
		return cj;
	}

	public void setCj(String cj) {
		this.cj = cj;
	}

	public String getXqName() {
		return xqName;
	}

	public void setXqName(String xqName) {
		this.xqName = xqName;
	}

	public String getXzName() {
		return xzName;
	}

	public void setXzName(String xzName) {
		this.xzName = xzName;
	}

	public String getCjName() {
		return cjName;
	}

	public void setCjName(String cjName) {
		this.cjName = cjName;
	}

	public String getIsjz() {
		return isjz;
	}

	public void setIsjz(String isjz) {
		this.isjz = isjz;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public RhzfYlbzVo() {
		super();
	}

	public RhzfYlbzVo(String id){
		super(id);
	}

	public String getAcId() {
		return acId;
	}

	public void setAcId(String acId) {
		this.acId = acId;
	}
	
	@ExcelField(title="姓名", align=2, sort=8)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJkzk() {
		return jkzk;
	}

	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}

	public String getMxb() {
		return mxb;
	}

	public void setMxb(String mxb) {
		this.mxb = mxb;
	}

	public String getMxbName() {
		return mxbName;
	}

	public void setMxbName(String mxbName) {
		this.mxbName = mxbName;
	}

	public String getHydb() {
		return hydb;
	}

	public void setHydb(String hydb) {
		this.hydb = hydb;
	}

	public String getHydbName() {
		return hydbName;
	}

	public void setHydbName(String hydbName) {
		this.hydbName = hydbName;
	}

	public List<Map<String, String>> getMxbMap() {
		return mxbMap;
	}

	public void setMxbMap(List<Map<String, String>> mxbMap) {
		this.mxbMap = mxbMap;
	}

	public List<Map<String, String>> getHydbMap() {
		return hydbMap;
	}

	public void setHydbMap(List<Map<String, String>> hydbMap) {
		this.hydbMap = hydbMap;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

}