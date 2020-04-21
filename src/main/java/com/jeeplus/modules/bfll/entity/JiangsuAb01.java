/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.entity;

import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 贫困人口基本信息Entity
 * @author tangtq
 * @version 2017-03-30
 */
public class JiangsuAb01 extends DataEntity<JiangsuAb01> {
	
	private static final long serialVersionUID = 1L;
	private String acid;
	/*private Double aab001;		// aab001
*/	private Double aar040;		// aar040
	/*private Double aac001;		// aac001
*/	private String aab002;		// aab002
	private String aab003;		// aab003
	private String aab004;		// aab004
	private Double aab005;		// aab005
	private String aab006;		// aab006
	private String aab007;		// aab007
	private String aab008;		// aab008
	private String aab009;		// aab009
	private String aab010;		// aab010
	private String aab011;		// aab011
	private String aab012;		// aab012
	private String aab015;		// aab015
	private String aab016;		// aab016
	private String aab017;		// aab017
	private Double aar041;		// aar041
	private String aar001;		// aar001
	private Double aar022;		// aar022
	private String aar023;		// aar023
	private Double aar024;		// aar024
	private String aar025;		// aar025
	private Double baz002;		// baz002
	private String aab018;		// aab018
	private String aab019;		// aab019
	private String aar008;		// aar008
	private String aak033;		// aak033
	private String aab025;		// aab025
	private String aab026;		// aab026
	private String aab027;		// aab027
	private String aab028;		// aab028
	private String aab029;		// aab029
	private String aab030;		// aab030
	private String aab031;		// aab031
	
	private String familyPopulation; 	// 家庭人口
	
	private String AAR001; //地区编号
	private String AAR009; //地区名称
	private String villageNumber;
	private String groupNumber;
	
	private String AAC082;	//工资性收入 
	private String AAc071;	// 生产经营性收入 
	private String AAc072;	//财产性收入 
	private String AAc090;	//转移性收入  
	
	private String bfzerId; //帮扶责任人ID
	private String bfzerxm; //帮扶责任人姓名
	private String nl;//年龄
	public String getVillageNumber() {
		return villageNumber;
	}

	public void setVillageNumber(String villageNumber) {
		this.villageNumber = villageNumber;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getBfzerId() {
		return bfzerId;
	}

	public void setBfzerId(String bfzerId) {
		this.bfzerId = bfzerId;
	}

	public String getBfzerxm() {
		return bfzerxm;
	}

	public void setBfzerxm(String bfzerxm) {
		this.bfzerxm = bfzerxm;
	}

	public JiangsuAb01() {
		super();
	}

	public JiangsuAb01(String id){
		super(id);
	}

	
	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	/*@NotNull(message="aab001不能为空")
	@ExcelField(title="aab001", align=2, sort=1)
	public Double getAab001() {
		return aab001;
	}

	public void setAab001(Double aab001) {
		this.aab001 = aab001;
	}*/
	
	@NotNull(message="aar040不能为空")
	@ExcelField(title="aar040", align=2, sort=2)
	public Double getAar040() {
		return aar040;
	}

	public void setAar040(Double aar040) {
		this.aar040 = aar040;
	}
	
	/*@NotNull(message="aac001不能为空")
	@ExcelField(title="aac001", align=2, sort=3)
	public Double getAac001() {
		return aac001;
	}

	public void setAac001(Double aac001) {
		this.aac001 = aac001;
	}*/
	
	@ExcelField(title="aab002", align=2, sort=4)
	public String getAab002() {
		return aab002;
	}

	public void setAab002(String aab002) {
		this.aab002 = aab002;
	}
	
	@ExcelField(title="aab003", align=2, sort=5)
	public String getAab003() {
		return aab003;
	}

	public void setAab003(String aab003) {
		this.aab003 = aab003;
	}
	
	@ExcelField(title="aab004", align=2, sort=6)
	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	
	@ExcelField(title="aab005", align=2, sort=7)
	public Double getAab005() {
		return aab005;
	}

	public void setAab005(Double aab005) {
		this.aab005 = aab005;
	}
	
	@ExcelField(title="aab006", align=2, sort=8)
	public String getAab006() {
		return aab006;
	}

	public void setAab006(String aab006) {
		this.aab006 = aab006;
	}
	
	@ExcelField(title="aab007", align=2, sort=9)
	public String getAab007() {
		return aab007;
	}

	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}
	
	@ExcelField(title="aab008", align=2, sort=10)
	public String getAab008() {
		return aab008;
	}

	public void setAab008(String aab008) {
		this.aab008 = aab008;
	}
	
	@ExcelField(title="aab009", align=2, sort=11)
	public String getAab009() {
		return aab009;
	}

	public void setAab009(String aab009) {
		this.aab009 = aab009;
	}
	
	@ExcelField(title="aab010", align=2, sort=12)
	public String getAab010() {
		return aab010;
	}

	public void setAab010(String aab010) {
		this.aab010 = aab010;
	}
	
	@ExcelField(title="aab011", align=2, sort=13)
	public String getAab011() {
		return aab011;
	}

	public void setAab011(String aab011) {
		this.aab011 = aab011;
	}
	
	@ExcelField(title="aab012", align=2, sort=14)
	public String getAab012() {
		return aab012;
	}

	public void setAab012(String aab012) {
		this.aab012 = aab012;
	}
	
	@ExcelField(title="aab015", align=2, sort=15)
	public String getAab015() {
		return aab015;
	}

	public void setAab015(String aab015) {
		this.aab015 = aab015;
	}
	
	@ExcelField(title="aab016", align=2, sort=16)
	public String getAab016() {
		return aab016;
	}

	public void setAab016(String aab016) {
		this.aab016 = aab016;
	}
	
	@ExcelField(title="aab017", align=2, sort=17)
	public String getAab017() {
		return aab017;
	}

	public void setAab017(String aab017) {
		this.aab017 = aab017;
	}
	
	@ExcelField(title="aar041", align=2, sort=18)
	public Double getAar041() {
		return aar041;
	}

	public void setAar041(Double aar041) {
		this.aar041 = aar041;
	}
	
	@ExcelField(title="aar001", align=2, sort=19)
	public String getAar001() {
		return aar001;
	}

	public void setAar001(String aar001) {
		this.aar001 = aar001;
	}
	
	@ExcelField(title="aar022", align=2, sort=20)
	public Double getAar022() {
		return aar022;
	}

	public void setAar022(Double aar022) {
		this.aar022 = aar022;
	}
	
	@ExcelField(title="aar023", align=2, sort=21)
	public String getAar023() {
		return aar023;
	}

	public void setAar023(String aar023) {
		this.aar023 = aar023;
	}
	
	@ExcelField(title="aar024", align=2, sort=22)
	public Double getAar024() {
		return aar024;
	}

	public void setAar024(Double aar024) {
		this.aar024 = aar024;
	}
	
	@ExcelField(title="aar025", align=2, sort=23)
	public String getAar025() {
		return aar025;
	}

	public void setAar025(String aar025) {
		this.aar025 = aar025;
	}
	
	@ExcelField(title="baz002", align=2, sort=24)
	public Double getBaz002() {
		return baz002;
	}

	public void setBaz002(Double baz002) {
		this.baz002 = baz002;
	}
	
	@ExcelField(title="aab018", align=2, sort=25)
	public String getAab018() {
		return aab018;
	}

	public void setAab018(String aab018) {
		this.aab018 = aab018;
	}
	
	@ExcelField(title="aab019", align=2, sort=26)
	public String getAab019() {
		return aab019;
	}

	public void setAab019(String aab019) {
		this.aab019 = aab019;
	}
	
	@ExcelField(title="aar008", align=2, sort=27)
	public String getAar008() {
		return aar008;
	}

	public void setAar008(String aar008) {
		this.aar008 = aar008;
	}
	
	@ExcelField(title="aak033", align=2, sort=28)
	public String getAak033() {
		return aak033;
	}

	public void setAak033(String aak033) {
		this.aak033 = aak033;
	}
	
	@ExcelField(title="aab025", align=2, sort=29)
	public String getAab025() {
		return aab025;
	}

	public void setAab025(String aab025) {
		this.aab025 = aab025;
	}
	
	@ExcelField(title="aab026", align=2, sort=30)
	public String getAab026() {
		return aab026;
	}

	public void setAab026(String aab026) {
		this.aab026 = aab026;
	}
	
	@ExcelField(title="aab027", align=2, sort=31)
	public String getAab027() {
		return aab027;
	}

	public void setAab027(String aab027) {
		this.aab027 = aab027;
	}
	
	@ExcelField(title="aab028", align=2, sort=32)
	public String getAab028() {
		return aab028;
	}

	public void setAab028(String aab028) {
		this.aab028 = aab028;
	}
	
	@ExcelField(title="aab029", align=2, sort=33)
	public String getAab029() {
		return aab029;
	}

	public void setAab029(String aab029) {
		this.aab029 = aab029;
	}
	
	@ExcelField(title="aab030", align=2, sort=34)
	public String getAab030() {
		return aab030;
	}

	public void setAab030(String aab030) {
		this.aab030 = aab030;
	}
	
	@ExcelField(title="aab031", align=2, sort=35)
	public String getAab031() {
		return aab031;
	}

	public void setAab031(String aab031) {
		this.aab031 = aab031;
	}

	public String getFamilyPopulation() {
		return familyPopulation;
	}

	public void setFamilyPopulation(String familyPopulation) {
		this.familyPopulation = familyPopulation;
	}

	public String getAAR001() {
		return AAR001;
	}

	public void setAAR001(String aAR001) {
		AAR001 = aAR001;
	}

	public String getAAR009() {
		return AAR009;
	}

	public void setAAR009(String aAR009) {
		AAR009 = aAR009;
	}

	public String getAAC082() {
		return AAC082;
	}

	public void setAAC082(String aAC082) {
		AAC082 = aAC082;
	}

	public String getAAc071() {
		return AAc071;
	}

	public void setAAc071(String aAc071) {
		AAc071 = aAc071;
	}

	public String getAAc072() {
		return AAc072;
	}

	public void setAAc072(String aAc072) {
		AAc072 = aAc072;
	}

	public String getAAc090() {
		return AAc090;
	}

	public void setAAc090(String aAc090) {
		AAc090 = aAc090;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

}