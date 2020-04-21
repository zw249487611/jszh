/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.entity;

import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 贫困人口基本信息Entity
 * 
 * @author hwm
 * @version 2017-05-09
 */
public class NewJiangsuAb01E extends DataEntity<NewJiangsuAb01E> {

	private static final long serialVersionUID = 1L;
	private Long aab001; // aab001
	private Long aar040; // aar040 年度
	private Long aac001; // aac001
	private String aab002; // aab002 姓名
	private String aab003; // aab003 性别
	private String aab004; // aab004 证件号码
	private Long aab005; // aab005
	private String aab006; // aab006 与户主关系
	private String aab007; // aab007 民族
	private String aab008; // aab008 文化程度
	private String aab009; // aab009 在校生状况
	private String aab010; // aab010 劳动技能
	private String aab011; // aab011
	private String aab012; // aab012 务工时间
	private String aab015; // aab015 生存状态
	private String aab016; // aab016
	private String aab017; // aab017 健康状况
	private Long aar041; // aar041
	private String aar001; // aar001
	private Long aar022; // aar022
	private String aar023; // aar023
	private Long aar024; // aar024
	private String aar025; // aar025
	private Long baz002; // baz002
	private String aab018; // aab018 证件类型
	private String aab019; // aab019 是否现役军人
	private String aar008; // aar008
	private String aak033; // aak033 政治面貌
	private String aab025; // aab025省
	private String aab026; // aab026市
	private String aab027; // aab027县
	private String aab028; // aab028乡
	private String aab029; // aab029 务工企业名称
	private String aab030; // aab030 是否享受低保
	private String aab031; // aab031 联系电话
	private String aab021; // 婚姻状况
	private String acid; // ac01的id
	private String aab032; // 县区
	private String aab033; // 乡镇
	private String aab034; // 村居

	private String hzsfzh; // 户主身份证号（用于查询贫困户ID）
	
	private String xq;
	private String xz;
	private String cj;
	private String xqName;
	private String xzName;
	private String cjName;
	
	private String sex;//性别
	private String yhzgx;//与户主关系
	private String sczt;//生存状态
	private String jkzk;//健康状况
	private String mz;//民族
	private String whcd;//文化程度
	private String zzmm;//政治面貌
	private String ldjn;//劳动技能
	private String zxszk;//在校生状况
	private String sfxsdb;//是否享受低保
	private String hzxm;//户主姓名
	
	private String aac006; // aac006 贫困户属性
	private String aar010; // aar010 脱贫标志
	
	private String sfzcxpk; // 是否支出性贫困
	private String tpnd; // 脱贫年度
	private String aar012; // 联系电话
	
	public String getAar012() {
		return aar012;
	}

	public void setAar012(String aar012) {
		this.aar012 = aar012;
	}

	public String getTpnd() {
		return tpnd;
	}

	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}

	public String getSfzcxpk() {
		return sfzcxpk;
	}

	public void setSfzcxpk(String sfzcxpk) {
		this.sfzcxpk = sfzcxpk;
	}

	public String getAar010() {
		return aar010;
	}

	public void setAar010(String aar010) {
		this.aar010 = aar010;
	}

	public String getAac006() {
		return aac006;
	}

	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}

	@ExcelField(title = "文化程度", align = 2, sort = 11)
	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	@ExcelField(title = "政治面貌", align = 2, sort = 12)
	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	@ExcelField(title = "劳动技能", align = 2, sort = 13)
	public String getLdjn() {
		return ldjn;
	}

	public void setLdjn(String ldjn) {
		this.ldjn = ldjn;
	}

	@ExcelField(title = "在校生状况", align = 2, sort = 14)
	public String getZxszk() {
		return zxszk;
	}

	public void setZxszk(String zxszk) {
		this.zxszk = zxszk;
	}

	@ExcelField(title = "是否享受低保", align = 2, sort = 15)
	public String getSfxsdb() {
		return sfxsdb;
	}

	public void setSfxsdb(String sfxsdb) {
		this.sfxsdb = sfxsdb;
	}

	@ExcelField(title = "户主姓名", align = 2, sort = 16)
	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	@ExcelField(title = "民族", align = 2, sort = 10)
	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	@ExcelField(title = "健康状况", align = 2, sort = 9)
	public String getJkzk() {
		return jkzk;
	}

	public void setJkzk(String jkzk) {
		this.jkzk = jkzk;
	}

	@ExcelField(title = "生存状态", align = 2, sort = 8)
	public String getSczt() {
		return sczt;
	}

	public void setSczt(String sczt) {
		this.sczt = sczt;
	}

	@ExcelField(title = "与户主关系", align = 2, sort = 8)
	public String getYhzgx() {
		return yhzgx;
	}

	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}

	@ExcelField(title = "性别", align = 2, sort = 7)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


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

	@ExcelField(title = "县区", align = 2, sort = 2)
	public String getXqName() {
		return xqName;
	}

	public void setXqName(String xqName) {
		this.xqName = xqName;
	}

	@ExcelField(title = "乡镇", align = 2, sort = 3)
	public String getXzName() {
		return xzName;
	}

	public void setXzName(String xzName) {
		this.xzName = xzName;
	}
	@ExcelField(title = "村居", align = 2, sort = 4)
	public String getCjName() {
		return cjName;
	}

	public void setCjName(String cjName) {
		this.cjName = cjName;
	}

	public NewJiangsuAb01E() {
		super();
	}

	public NewJiangsuAb01E(String id) {
		super(id);
	}

	public Long getAab001() {
		return aab001;
	}

	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}

	@NotNull(message = "aar040不能为空")
	@ExcelField(title = "分区年度", align = 2, sort = 1)
	public Long getAar040() {
		return aar040;
	}

	public void setAar040(Long aar040) {
		this.aar040 = aar040;
	}

	public Long getAac001() {
		return aac001;
	}

	public void setAac001(Long aac001) {
		this.aac001 = aac001;
	}

	@ExcelField(title = "姓名", align = 2, sort = 5)
	public String getAab002() {
		return aab002;
	}

	public void setAab002(String aab002) {
		this.aab002 = aab002;
	}

	
	public String getAab003() {
		return aab003;
	}

	public void setAab003(String aab003) {
		this.aab003 = aab003;
	}

	@ExcelField(title = "证件号码", align = 2, sort = 6)
	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	public Long getAab005() {
		return aab005;
	}

	public void setAab005(Long aab005) {
		this.aab005 = aab005;
	}

	
	public String getAab006() {
		return aab006;
	}

	public void setAab006(String aab006) {
		this.aab006 = aab006;
	}

//	@ExcelField(title = "民族", align = 2, sort = 9)
	public String getAab007() {
		return aab007;
	}

	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}

//	@ExcelField(title = "文化程度", align = 2, sort = 12)
	public String getAab008() {
		return aab008;
	}

	public void setAab008(String aab008) {
		this.aab008 = aab008;
	}

//	@ExcelField(title = "在校生状况", align = 2, sort = 13)
	public String getAab009() {
		return aab009;
	}

	public void setAab009(String aab009) {
		this.aab009 = aab009;
	}

//	@ExcelField(title = "劳动技能", align = 2, sort = 14)
	public String getAab010() {
		return aab010;
	}

	public void setAab010(String aab010) {
		this.aab010 = aab010;
	}

	public String getAab011() {
		return aab011;
	}

	public void setAab011(String aab011) {
		this.aab011 = aab011;
	}

//	@ExcelField(title = "务工时间", align = 2, sort = 15)
	public String getAab012() {
		return aab012;
	}

	public void setAab012(String aab012) {
		this.aab012 = aab012;
	}

//	@ExcelField(title = "生存状态", align = 2, sort = 9)
	public String getAab015() {
		return aab015;
	}

	public void setAab015(String aab015) {
		this.aab015 = aab015;
	}

	public String getAab016() {
		return aab016;
	}

	public void setAab016(String aab016) {
		this.aab016 = aab016;
	}

//	@ExcelField(title = "健康状况", align = 2, sort = 17)
	public String getAab017() {
		return aab017;
	}

	public void setAab017(String aab017) {
		this.aab017 = aab017;
	}

	public Long getAar041() {
		return aar041;
	}

	public void setAar041(Long aar041) {
		this.aar041 = aar041;
	}

	public String getAar001() {
		return aar001;
	}

	public void setAar001(String aar001) {
		this.aar001 = aar001;
	}

	public Long getAar022() {
		return aar022;
	}

	public void setAar022(Long aar022) {
		this.aar022 = aar022;
	}

	public String getAar023() {
		return aar023;
	}

	public void setAar023(String aar023) {
		this.aar023 = aar023;
	}

	public Long getAar024() {
		return aar024;
	}

	public void setAar024(Long aar024) {
		this.aar024 = aar024;
	}

	public String getAar025() {
		return aar025;
	}

	public void setAar025(String aar025) {
		this.aar025 = aar025;
	}

	public Long getBaz002() {
		return baz002;
	}

	public void setBaz002(Long baz002) {
		this.baz002 = baz002;
	}

//	@ExcelField(title = "证件类型", align = 2, sort = 6)
	public String getAab018() {
		return aab018;
	}

	public void setAab018(String aab018) {
		this.aab018 = aab018;
	}

//	@ExcelField(title = "是否现役军人", align = 2, sort = 18)
	public String getAab019() {
		return aab019;
	}

	public void setAab019(String aab019) {
		this.aab019 = aab019;
	}

	public String getAar008() {
		return aar008;
	}

	public void setAar008(String aar008) {
		this.aar008 = aar008;
	}

//	@ExcelField(title = "政治面貌", align = 2, sort = 11)
	public String getAak033() {
		return aak033;
	}

	public void setAak033(String aak033) {
		this.aak033 = aak033;
	}

	public String getAab025() {
		return aab025;
	}

	public void setAab025(String aab025) {
		this.aab025 = aab025;
	}

	public String getAab026() {
		return aab026;
	}

	public void setAab026(String aab026) {
		this.aab026 = aab026;
	}

	public String getAab027() {
		return aab027;
	}

	public void setAab027(String aab027) {
		this.aab027 = aab027;
	}

	public String getAab028() {
		return aab028;
	}

	public void setAab028(String aab028) {
		this.aab028 = aab028;
	}

//	@ExcelField(title = "务工企业名称", align = 2, sort = 20)
	public String getAab029() {
		return aab029;
	}

	public void setAab029(String aab029) {
		this.aab029 = aab029;
	}

//	@ExcelField(title = "是否享受低保", align = 2, sort = 21)
	public String getAab030() {
		return aab030;
	}

	public void setAab030(String aab030) {
		this.aab030 = aab030;
	}

//	@ExcelField(title = "联系电话", align = 2, sort = 19)
	public String getAab031() {
		return aab031;
	}

	public void setAab031(String aab031) {
		this.aab031 = aab031;
	}

//	@ExcelField(title = "婚姻状况", align = 2, sort = 10)
	public String getAab021() {
		return aab021;
	}

	public void setAab021(String aab021) {
		this.aab021 = aab021;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	
	public String getAab032() {
		return aab032;
	}

	public void setAab032(String aab032) {
		this.aab032 = aab032;
	}

//	@ExcelField(title = "乡镇", align = 2, sort = 2)
	public String getAab033() {
		return aab033;
	}

	public void setAab033(String aab033) {
		this.aab033 = aab033;
	}

//	@ExcelField(title = "村居", align = 2, sort = 3)
	public String getAab034() {
		return aab034;
	}

	public void setAab034(String aab034) {
		this.aab034 = aab034;
	}

	@ExcelField(title = "户主身份证号", align = 2, sort = 16)
	public String getHzsfzh() {
		return hzsfzh;
	}

	public void setHzsfzh(String hzsfzh) {
		this.hzsfzh = hzsfzh;
	}

	public String toString(){
		String str=aar040+aab002+aab003+aab018+aab004+aab006+aab007+aab021+
				aak033+aab008+aab009+aab010+aab015+aab017+aab030+aab031;
		return str;
	}
	
}