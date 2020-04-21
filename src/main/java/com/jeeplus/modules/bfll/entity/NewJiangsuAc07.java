/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 贫困户收入信息表Entity
 * @author hwm
 * @version 2017-05-09
 */
public class NewJiangsuAc07 extends DataEntity<NewJiangsuAc07> {
	
	private static final long serialVersionUID = 1L;
	private String acid;		// acid
	private Long aac060;		// aac060
	private Long aac101;		// aac101
	private Long aac100;		// aac100
	private Long aac061;		// aac061
	private Double aac062;		// 水稻(亩)
	private Double aac063;		// 小麦(亩)
	private Double aac064;		// 玉米(亩)
	private Double aac065;		// 其它(亩)
	private Long aac066;		// 鸡(只)
	private Long aac067;		// 猪(只)
	private Long aac068;		// 羊(只)
	private Long aac069;		// 其它(只)
	private Double aac071;		// aac071
	private Double aac072;		// aac072
	private Double aac073;		// aac073
	private Double aac074;		// aac074
	private Double aac075;		// aac075
	private Double aac076;		// aac076
	private Double aac077;		// aac077
	private Double aac078;		// aac078
	private Double aac079;		// aac079
	private Double aac080;		// 其它（元）
	private Double aac081;		// aac081
	private Double aac082;		// aac082
	private Double aac083;		// aac083
	private Double aac084;		// 财产性收入
	private Double aac085;		// aac085
	private Double aac086;		// aac086
	private Double aac087;		// aac087
	private Double aac088;		// aac088
	private Double aac089;		// 其他财产性收入
	private Double aac090;		// 转移性收入
	private Double aac091;		// 带动增收项目收入
	private Double aac092;		// 村集体经济收益分配
	private Double aac093;		// 社会救济和补助
	private Double aac094;		// 政策性生产补贴
	private Double aac095;		// 政策性生活补贴
	private Double aac096;		// 教育资助
	private Double aac097;		// 养老金
	private Double aac098;		// 帮扶慰问金
	private Double aac099;		// 其他收入
	private String aar001;		// aar001
	private Double aar022;		// aar022
	private String aar023;		// aar023
	private Double aar024;		// aar024
	private String aar025;		// aar025
	private Double baz002;		// baz002
	private String aar008;		// aar008
	private String aac102;		// 其它
	private String aar040;		// aar040
	private String aar041;		// 季度
	
	public NewJiangsuAc07() {
		super();
	}

	public NewJiangsuAc07(String id){
		super(id);
	}

	@ExcelField(title="acid", align=2, sort=1)
	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}
	
	@ExcelField(title="aac060", align=2, sort=2)
	public Long getAac060() {
		return aac060;
	}

	public void setAac060(Long aac060) {
		this.aac060 = aac060;
	}
	
	@ExcelField(title="aac101", align=2, sort=3)
	public Long getAac101() {
		return aac101;
	}

	public void setAac101(Long aac101) {
		this.aac101 = aac101;
	}
	
	@ExcelField(title="aac100", align=2, sort=4)
	public Long getAac100() {
		return aac100;
	}

	public void setAac100(Long aac100) {
		this.aac100 = aac100;
	}
	
	@ExcelField(title="aac061", align=2, sort=5)
	public Long getAac061() {
		return aac061;
	}

	public void setAac061(Long aac061) {
		this.aac061 = aac061;
	}
	
	@ExcelField(title="水稻(亩)", align=2, sort=6)
	public Double getAac062() {
		return aac062;
	}

	public void setAac062(Double aac062) {
		this.aac062 = aac062;
	}
	
	@ExcelField(title="小麦(亩)", align=2, sort=7)
	public Double getAac063() {
		return aac063;
	}

	public void setAac063(Double aac063) {
		this.aac063 = aac063;
	}
	
	@ExcelField(title="玉米(亩)", align=2, sort=8)
	public Double getAac064() {
		return aac064;
	}

	public void setAac064(Double aac064) {
		this.aac064 = aac064;
	}
	
	@ExcelField(title="其它(亩)", align=2, sort=9)
	public Double getAac065() {
		return aac065;
	}

	public void setAac065(Double aac065) {
		this.aac065 = aac065;
	}
	
	@ExcelField(title="鸡(只)", align=2, sort=10)
	public Long getAac066() {
		return aac066;
	}

	public void setAac066(Long aac066) {
		this.aac066 = aac066;
	}
	
	@ExcelField(title="猪(只)", align=2, sort=11)
	public Long getAac067() {
		return aac067;
	}

	public void setAac067(Long aac067) {
		this.aac067 = aac067;
	}
	
	@ExcelField(title="羊(只)", align=2, sort=12)
	public Long getAac068() {
		return aac068;
	}

	public void setAac068(Long aac068) {
		this.aac068 = aac068;
	}
	
	@ExcelField(title="其它(只)", align=2, sort=13)
	public Long getAac069() {
		return aac069;
	}

	public void setAac069(Long aac069) {
		this.aac069 = aac069;
	}
	
	@ExcelField(title="aac071", align=2, sort=14)
	public Double getAac071() {
		return aac071;
	}

	public void setAac071(Double aac071) {
		this.aac071 = aac071;
	}
	
	@ExcelField(title="aac072", align=2, sort=15)
	public Double getAac072() {
		return aac072;
	}

	public void setAac072(Double aac072) {
		this.aac072 = aac072;
	}
	
	@ExcelField(title="aac073", align=2, sort=16)
	public Double getAac073() {
		return aac073;
	}

	public void setAac073(Double aac073) {
		this.aac073 = aac073;
	}
	
	@ExcelField(title="aac074", align=2, sort=17)
	public Double getAac074() {
		return aac074;
	}

	public void setAac074(Double aac074) {
		this.aac074 = aac074;
	}
	
	@ExcelField(title="aac075", align=2, sort=18)
	public Double getAac075() {
		return aac075;
	}

	public void setAac075(Double aac075) {
		this.aac075 = aac075;
	}
	
	@ExcelField(title="aac076", align=2, sort=19)
	public Double getAac076() {
		return aac076;
	}

	public void setAac076(Double aac076) {
		this.aac076 = aac076;
	}
	
	@ExcelField(title="aac077", align=2, sort=20)
	public Double getAac077() {
		return aac077;
	}

	public void setAac077(Double aac077) {
		this.aac077 = aac077;
	}
	
	@ExcelField(title="aac078", align=2, sort=21)
	public Double getAac078() {
		return aac078;
	}

	public void setAac078(Double aac078) {
		this.aac078 = aac078;
	}
	
	@ExcelField(title="aac079", align=2, sort=22)
	public Double getAac079() {
		return aac079;
	}

	public void setAac079(Double aac079) {
		this.aac079 = aac079;
	}
	
	@ExcelField(title="其它（元）", align=2, sort=23)
	public Double getAac080() {
		return aac080;
	}

	public void setAac080(Double aac080) {
		this.aac080 = aac080;
	}
	
	@ExcelField(title="aac081", align=2, sort=24)
	public Double getAac081() {
		return aac081;
	}

	public void setAac081(Double aac081) {
		this.aac081 = aac081;
	}
	
	@ExcelField(title="aac082", align=2, sort=25)
	public Double getAac082() {
		return aac082;
	}

	public void setAac082(Double aac082) {
		this.aac082 = aac082;
	}
	
	@ExcelField(title="aac083", align=2, sort=26)
	public Double getAac083() {
		return aac083;
	}

	public void setAac083(Double aac083) {
		this.aac083 = aac083;
	}
	
	@ExcelField(title="财产性收入", align=2, sort=27)
	public Double getAac084() {
		return aac084;
	}

	public void setAac084(Double aac084) {
		this.aac084 = aac084;
	}
	
	@ExcelField(title="aac085", align=2, sort=28)
	public Double getAac085() {
		return aac085;
	}

	public void setAac085(Double aac085) {
		this.aac085 = aac085;
	}
	
	@ExcelField(title="aac086", align=2, sort=29)
	public Double getAac086() {
		return aac086;
	}

	public void setAac086(Double aac086) {
		this.aac086 = aac086;
	}
	
	@ExcelField(title="aac087", align=2, sort=30)
	public Double getAac087() {
		return aac087;
	}

	public void setAac087(Double aac087) {
		this.aac087 = aac087;
	}
	
	@ExcelField(title="aac088", align=2, sort=31)
	public Double getAac088() {
		return aac088;
	}

	public void setAac088(Double aac088) {
		this.aac088 = aac088;
	}
	
	@ExcelField(title="其他财产性收入", align=2, sort=32)
	public Double getAac089() {
		return aac089;
	}

	public void setAac089(Double aac089) {
		this.aac089 = aac089;
	}
	
	@ExcelField(title="转移性收入", align=2, sort=33)
	public Double getAac090() {
		return aac090;
	}

	public void setAac090(Double aac090) {
		this.aac090 = aac090;
	}
	
	@ExcelField(title="带动增收项目收入", align=2, sort=34)
	public Double getAac091() {
		return aac091;
	}

	public void setAac091(Double aac091) {
		this.aac091 = aac091;
	}
	
	@ExcelField(title="村集体经济收益分配", align=2, sort=35)
	public Double getAac092() {
		return aac092;
	}

	public void setAac092(Double aac092) {
		this.aac092 = aac092;
	}
	
	@ExcelField(title="社会救济和补助", align=2, sort=36)
	public Double getAac093() {
		return aac093;
	}

	public void setAac093(Double aac093) {
		this.aac093 = aac093;
	}
	
	@ExcelField(title="政策性生产补贴", align=2, sort=37)
	public Double getAac094() {
		return aac094;
	}

	public void setAac094(Double aac094) {
		this.aac094 = aac094;
	}
	
	@ExcelField(title="政策性生活补贴", align=2, sort=38)
	public Double getAac095() {
		return aac095;
	}

	public void setAac095(Double aac095) {
		this.aac095 = aac095;
	}
	
	@ExcelField(title="教育资助", align=2, sort=39)
	public Double getAac096() {
		return aac096;
	}

	public void setAac096(Double aac096) {
		this.aac096 = aac096;
	}
	
	@ExcelField(title="养老金", align=2, sort=40)
	public Double getAac097() {
		return aac097;
	}

	public void setAac097(Double aac097) {
		this.aac097 = aac097;
	}
	
	@ExcelField(title="帮扶慰问金", align=2, sort=41)
	public Double getAac098() {
		return aac098;
	}

	public void setAac098(Double aac098) {
		this.aac098 = aac098;
	}
	
	@ExcelField(title="其他收入", align=2, sort=42)
	public Double getAac099() {
		return aac099;
	}

	public void setAac099(Double aac099) {
		this.aac099 = aac099;
	}
	
	@ExcelField(title="aar001", align=2, sort=43)
	public String getAar001() {
		return aar001;
	}

	public void setAar001(String aar001) {
		this.aar001 = aar001;
	}
	
	@ExcelField(title="aar022", align=2, sort=44)
	public Double getAar022() {
		return aar022;
	}

	public void setAar022(Double aar022) {
		this.aar022 = aar022;
	}
	
	@ExcelField(title="aar023", align=2, sort=45)
	public String getAar023() {
		return aar023;
	}

	public void setAar023(String aar023) {
		this.aar023 = aar023;
	}
	
	@ExcelField(title="aar024", align=2, sort=46)
	public Double getAar024() {
		return aar024;
	}

	public void setAar024(Double aar024) {
		this.aar024 = aar024;
	}
	
	@ExcelField(title="aar025", align=2, sort=47)
	public String getAar025() {
		return aar025;
	}

	public void setAar025(String aar025) {
		this.aar025 = aar025;
	}
	
	@ExcelField(title="baz002", align=2, sort=48)
	public Double getBaz002() {
		return baz002;
	}

	public void setBaz002(Double baz002) {
		this.baz002 = baz002;
	}
	
	@ExcelField(title="aar008", align=2, sort=49)
	public String getAar008() {
		return aar008;
	}

	public void setAar008(String aar008) {
		this.aar008 = aar008;
	}
	
	@ExcelField(title="其它", align=2, sort=50)
	public String getAac102() {
		return aac102;
	}

	public void setAac102(String aac102) {
		this.aac102 = aac102;
	}
	
	@ExcelField(title="aar040", align=2, sort=51)
	public String getAar040() {
		return aar040;
	}

	public void setAar040(String aar040) {
		this.aar040 = aar040;
	}
	
	@ExcelField(title="季度", align=2, sort=52)
	public String getAar041() {
		return aar041;
	}

	public void setAar041(String aar041) {
		this.aar041 = aar041;
	}
	
}