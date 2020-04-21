/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.bfll.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 贫困户基本信息Entity
 * 
 * @author hwm
 * @version 2017-05-09
 */
public class NewJiangsuAc01 extends DataEntity<NewJiangsuAc01> {

	private static final long serialVersionUID = 1L;
	private Long aac001; // aac001
	private Long aar040; // aar040 年度
	private Long aad001; // aad001
	private String aar002; // aar002
	private String aar003; // aar003
	private String aar004; // aar004 县区
	private String aar005; // aar005 乡镇
	private String aar006; // aar006 村居
	private String aar012; // aar012 联系电话
	private String aaq002; // aaq002 开户银行
	private String aac004; // aac004 银行账号
	private String aac005; // aac005 识别标准
	private String aac006; // aac006 贫困户属性
	private String aac007; // aac007 主要致贫原因
	private String aac008; // aac008 其他致贫原因
	private String[] qtzpyy; // 其他致贫原因(数组形式)
	private String aac011; // aac011 致贫原因描述
	private String aac084; // aac084 是否加入农民专业合作社
	private String aar010; // aar010 脱贫标志
	private String aac012; // aac012 是否军烈属
	private String aac013; // aac013 是否独生子女户
	private String aac014; // aac014 是否双女户
	private String aac015; // aac015
	private Long aac016; // aac016
	private Long aac017; // aac017
	private Long aac018; // aac018
	private Long aac019; // aac019
	private Long aar022; // aar022
	private String aar001; // aar001
	private String aar023; // aar023
	private Long aar024; // aar024
	private String aar025; // aar025
	private String aar007; // aar007
	private Long baz002; // baz002
	private String aar008; // aar008
	private Long aad041; // aad041
	private String aar100; // aar100 有效标志
	private Long aar041; // aar041
	private String aac009; // aac009
	private String aac101; // aac101
	private String aac102; // aac102
	private String adid; // ad01的id
	private Long aar057; // 帮扶单位（责任人）数量
	private String aar058; // 帮扶单位（责任人）ID集合
	private String aar059; // 备注

	private String hzxm; // 户主姓名
	private String hzsfzh; // 户主身份证号
	private Integer jtrks; // 家庭人口数
	private String hjbm; // 户籍编码
	private String sfzcxpk; // 是否支出性贫困
	private String zcxpkyy; // 支出性贫困原因

	private NewJiangsuAc07 newJiangsuAc07; // 贫困户收入信息表
//	private JiangsuAc30 jiangsuAc30; // 贫困户生产条件信息表
//	private JiangsuAc31 jiangsuAc31; // 贫困户生活条件信息表
	private List<NewJiangsuAb01> newJiangsuAb01s; // 贫困人口list
	private String aab002;
	private NewJiangsuAb01 newJiangsuAb01;
	private String bgyy;			// 变更原因
	
	private String tpnd;//脱贫年度
	
	public NewJiangsuAc01() {
		super();
	}

	public NewJiangsuAc01(String id) {
		super(id);
	}

	public Long getAac001() {
		return aac001;
	}

	public void setAac001(Long aac001) {
		this.aac001 = aac001;
	}

	@NotNull(message = "分区年度不能为空")
	@ExcelField(title = "分区年度", align = 2, sort = 19)
	public Long getAar040() {
		return aar040;
	}

	public void setAar040(Long aar040) {
		this.aar040 = aar040;
	}

	public Long getAad001() {
		return aad001;
	}

	public void setAad001(Long aad001) {
		this.aad001 = aad001;
	}

	public String getAar002() {
		return aar002;
	}

	public void setAar002(String aar002) {
		this.aar002 = aar002;
	}

	public String getAar003() {
		return aar003;
	}

	public void setAar003(String aar003) {
		this.aar003 = aar003;
	}

	@ExcelField(title = "县区", align = 2, sort = 1)
	public String getAar004() {
		return aar004;
	}

	public void setAar004(String aar004) {
		this.aar004 = aar004;
	}

	@ExcelField(title = "乡镇", align = 2, sort = 2)
	public String getAar005() {
		return aar005;
	}

	public void setAar005(String aar005) {
		this.aar005 = aar005;
	}

	@ExcelField(title = "村居", align = 2, sort = 3)
	public String getAar006() {
		return aar006;
	}

	public void setAar006(String aar006) {
		this.aar006 = aar006;
	}

	@ExcelField(title = "联系电话", align = 2, sort = 6)
	public String getAar012() {
		return aar012;
	}

	public void setAar012(String aar012) {
		this.aar012 = aar012;
	}

	@ExcelField(title = "开户银行", align = 2, sort = 7)
	public String getAaq002() {
		return aaq002;
	}

	public void setAaq002(String aaq002) {
		this.aaq002 = aaq002;
	}

	@ExcelField(title = "银行账号", align = 2, sort = 8)
	public String getAac004() {
		return aac004;
	}

	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}

	@ExcelField(title = "识别标准", align = 2, sort = 9)
	public String getAac005() {
		return aac005;
	}

	public void setAac005(String aac005) {
		this.aac005 = aac005;
	}

	@ExcelField(title = "贫困户属性", align = 2, sort = 10)
	public String getAac006() {
		return aac006;
	}

	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}

	@ExcelField(title = "主要致贫原因", align = 2, sort = 11)
	public String getAac007() {
		return aac007;
	}

	public void setAac007(String aac007) {
		this.aac007 = aac007;
	}

	@ExcelField(title = "其他致贫原因", align = 2, sort = 12)
	public String getAac008() {
		return aac008;
	}

	public void setAac008(String aac008) {
		this.aac008 = aac008;
	}

	@ExcelField(title = "致贫原因描述", align = 2, sort = 13)
	public String getAac011() {
		return aac011;
	}

	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}

	@ExcelField(title = "是否加入农民专业合作社", align = 2, sort = 5)
	public String getAac084() {
		return aac084;
	}

	public void setAac084(String aac084) {
		this.aac084 = aac084;
	}

	@ExcelField(title = "脱贫标志", align = 2, sort = 17)
	public String getAar010() {
		return aar010;
	}

	public void setAar010(String aar010) {
		this.aar010 = aar010;
	}

	@ExcelField(title = "是否军烈属", align = 2, sort = 14)
	public String getAac012() {
		return aac012;
	}

	public void setAac012(String aac012) {
		this.aac012 = aac012;
	}

	@ExcelField(title = "是否独生子女户", align = 2, sort = 15)
	public String getAac013() {
		return aac013;
	}

	public void setAac013(String aac013) {
		this.aac013 = aac013;
	}

	@ExcelField(title = "是否双女户", align = 2, sort = 16)
	public String getAac014() {
		return aac014;
	}

	public void setAac014(String aac014) {
		this.aac014 = aac014;
	}

	public String getAac015() {
		return aac015;
	}

	public void setAac015(String aac015) {
		this.aac015 = aac015;
	}

	public Long getAac016() {
		return aac016;
	}

	public void setAac016(Long aac016) {
		this.aac016 = aac016;
	}

	public Long getAac017() {
		return aac017;
	}

	public void setAac017(Long aac017) {
		this.aac017 = aac017;
	}

	public Long getAac018() {
		return aac018;
	}

	public void setAac018(Long aac018) {
		this.aac018 = aac018;
	}

	public Long getAac019() {
		return aac019;
	}

	public void setAac019(Long aac019) {
		this.aac019 = aac019;
	}

	public Long getAar022() {
		return aar022;
	}

	public void setAar022(Long aar022) {
		this.aar022 = aar022;
	}

	public String getAar001() {
		return aar001;
	}

	public void setAar001(String aar001) {
		this.aar001 = aar001;
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

	public String getAar007() {
		return aar007;
	}

	public void setAar007(String aar007) {
		this.aar007 = aar007;
	}

	public Long getBaz002() {
		return baz002;
	}

	public void setBaz002(Long baz002) {
		this.baz002 = baz002;
	}

	public String getAar008() {
		return aar008;
	}

	public void setAar008(String aar008) {
		this.aar008 = aar008;
	}

	public Long getAad041() {
		return aad041;
	}

	public void setAad041(Long aad041) {
		this.aad041 = aad041;
	}

	public String getAar100() {
		return aar100;
	}

	public void setAar100(String aar100) {
		this.aar100 = aar100;
	}

	public Long getAar041() {
		return aar041;
	}

	public void setAar041(Long aar041) {
		this.aar041 = aar041;
	}

	public String getAac009() {
		return aac009;
	}

	public void setAac009(String aac009) {
		this.aac009 = aac009;
	}

	public String getAac101() {
		return aac101;
	}

	public void setAac101(String aac101) {
		this.aac101 = aac101;
	}

	public String getAac102() {
		return aac102;
	}

	public void setAac102(String aac102) {
		this.aac102 = aac102;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public Long getAar057() {
		return aar057;
	}

	public void setAar057(Long aar057) {
		this.aar057 = aar057;
	}

	public String getAar058() {
		return aar058;
	}

	public void setAar058(String aar058) {
		this.aar058 = aar058;
	}

	@ExcelField(title = "备注", align = 2, sort = 18)
	public String getAar059() {
		return aar059;
	}

	public void setAar059(String aar059) {
		this.aar059 = aar059;
	}


	public NewJiangsuAc07 getNewJiangsuAc07() {
		return newJiangsuAc07;
	}

	public void setNewJiangsuAc07(NewJiangsuAc07 newJiangsuAc07) {
		this.newJiangsuAc07 = newJiangsuAc07;
	}

	public List<NewJiangsuAb01> getNewJiangsuAb01s() {
		return newJiangsuAb01s;
	}

	public void setNewJiangsuAb01s(List<NewJiangsuAb01> newJiangsuAb01s) {
		this.newJiangsuAb01s = newJiangsuAb01s;
	}

	public String getAab002() {
		return aab002;
	}

	public void setAab002(String aab002) {
		this.aab002 = aab002;
	}

	public NewJiangsuAb01 getNewJiangsuAb01() {
		return newJiangsuAb01;
	}

	public void setNewJiangsuAb01(NewJiangsuAb01 newJiangsuAb01) {
		this.newJiangsuAb01 = newJiangsuAb01;
	}

	@ExcelField(title = "户主姓名", align = 2, sort = 20)
	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	@ExcelField(title = "户主身份证号", align = 2, sort = 21)
	public String getHzsfzh() {
		return hzsfzh;
	}

	public void setHzsfzh(String hzsfzh) {
		this.hzsfzh = hzsfzh;
	}

	@ExcelField(title = "家庭人口数", align = 2, sort = 22)
	public Integer getJtrks() {
		return jtrks;
	}

	public void setJtrks(Integer jtrks) {
		this.jtrks = jtrks;
	}

	@ExcelField(title = "户籍编码", align = 2, sort = 4)
	public String getHjbm() {
		return hjbm;
	}

	public void setHjbm(String hjbm) {
		this.hjbm = hjbm;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	public String getSfzcxpk() {
		return sfzcxpk;
	}

	public void setSfzcxpk(String sfzcxpk) {
		this.sfzcxpk = sfzcxpk;
	}

	public String getZcxpkyy() {
		return zcxpkyy;
	}

	public void setZcxpkyy(String zcxpkyy) {
		this.zcxpkyy = zcxpkyy;
	}

	public String getTpnd() {
		return tpnd;
	}

	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}

	public String toString(){
		String str = aar040+aar004+aar005+aar006+aac084+aar012+aaq002+aac004+
				aac005+aac006+aac007+aac008+aac011+aar010+aac012+aac013+aac014+
				hzxm+hzsfzh+jtrks+hjbm+aar059;
		return str;
	}

	public String[] getQtzpyy() {
		return qtzpyy;
	}

	public void setQtzpyy(String[] qtzpyy) {
		this.qtzpyy = qtzpyy;
	}

}