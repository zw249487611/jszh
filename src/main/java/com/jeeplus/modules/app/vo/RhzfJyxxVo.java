/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.app.vo;


import java.util.List;
import java.util.Map;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 就业创业信息Entity
 * @author chenll
 * @version 2019-03-31
 */
public class RhzfJyxxVo extends DataEntity<RhzfJyxxVo> {
	
	private static final long serialVersionUID = 1L;
	private String trainId="";		// 创业培训目录id
	private String name="";		// 姓名
	private String sfzh="";		// 身份证号码
	private String jyzk="";		// 就业状况
	private String jyyw="";		// 有无就业愿望
	private String pxyw="";		// 培训愿望
	private String pxgz="";		// 培训工种
	private String pxgzName="";		// 培训工种名称
	private String jylxName="";		// 就业类型名称
	private String cyyw="";		// 创业愿望
	private List<Map<String, String>> pxgzMap;   // 培训工种集合
	private List<Map<String, String>> jylxMap;   // 就业类型集合
	private String jylx="";		// 就业类型
	private String bzxx="";		// 备注信息
	
	private String xq;
	private String xz;
	private String cj;
	private String nd;
	
	public RhzfJyxxVo() {
		super();
	}

	public RhzfJyxxVo(String id){
		super(id);
	}

	
	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	
	@ExcelField(title="姓名", align=2, sort=2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="身份证号码", align=2, sort=3)
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
	@ExcelField(title="就业状况", dictType="yes_no", align=2, sort=7)
	public String getJyzk() {
		return jyzk;
	}

	public void setJyzk(String jyzk) {
		this.jyzk = jyzk;
	}
	
	@ExcelField(title="有无就业愿望", dictType="has_not", align=2, sort=8)
	public String getJyyw() {
		return jyyw;
	}

	public void setJyyw(String jyyw) {
		this.jyyw = jyyw;
	}
	
	@ExcelField(title="培训愿望", dictType="has_not", align=2, sort=9)
	public String getPxyw() {
		return pxyw;
	}

	public void setPxyw(String pxyw) {
		this.pxyw = pxyw;
	}
	
	@ExcelField(title="培训工种", dictType="gz", align=2, sort=10)
	public String getPxgz() {
		return pxgz;
	}

	public void setPxgz(String pxgz) {
		this.pxgz = pxgz;
	}
	
	@ExcelField(title="创业愿望", dictType="has_not", align=2, sort=11)
	public String getCyyw() {
		return cyyw;
	}

	public void setCyyw(String cyyw) {
		this.cyyw = cyyw;
	}

	public List<Map<String, String>> getPxgzMap() {
		return pxgzMap;
	}

	public void setPxgzMap(List<Map<String, String>> pxgzMap) {
		this.pxgzMap = pxgzMap;
	}

	public String getPxgzName() {
		return pxgzName;
	}

	public void setPxgzName(String pxgzName) {
		this.pxgzName = pxgzName;
	}
	@ExcelField(title="就业类型", dictType="jylx", align=2, sort=12)
	public String getJylx() {
		return jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	public List<Map<String, String>> getJylxMap() {
		return jylxMap;
	}

	public void setJylxMap(List<Map<String, String>> jylxMap) {
		this.jylxMap = jylxMap;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public String getJylxName() {
		return jylxName;
	}

	public void setJylxName(String jylxName) {
		this.jylxName = jylxName;
	}
	@ExcelField(title="县区", align=2, sort=4)
	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}
	@ExcelField(title="乡镇", align=2, sort=5)
	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}
	@ExcelField(title="村", align=2, sort=6)
	public String getCj() {
		return cj;
	}

	public void setCj(String cj) {
		this.cj = cj;
	}
	@ExcelField(title="年度", align=2, sort=1)
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}
	
}