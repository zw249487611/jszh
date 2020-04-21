package com.jeeplus.modules.bfll.entity;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

public class JiangsuAc01 extends DataEntity<JiangsuAc01> {
	private static final long serialVersionUID = 1L;

	// 贫困户基本信息表 poor_essential_information+ poor_poverty_causes
	/*
	 * private String id;//userid
	 */ /* private Integer Aac001; */
	private String adid;// 贫困村编号
	private String Aar008;// 所在行政区划代码
	private String Aar012;// 联系电话
	private String Aaq002;// 开户银行
	private String Aac004;// 银行账号
	private String Aac005;// 识别标准
	private String aac006;// 贫困户属性
	private String Aac007;// 主要致贫原因
	private String Aac008;// 其他致贫原因
	private String Aac011;// 致贫原因描述
	private String Aad041;// 自然村编号
	private String Aac012;// 是否军烈属
	private String Aac013;// 是否独生子女户
	private String Aac014;// 是否双女户
	private String Aar010;// 脱贫标志
	private Integer Aar057;// 帮扶单位（责任人）数量
	private String Aar058;// 帮扶单位（责任人）ID集合
	private Integer Aar040;// 分区年度
	private String aar004;
	private String aar005;
	private String aar006;
	private String tpnd;

	private JiangsuAb01 jiangsuAb01;
	private String aab002;

	private String sfjd;// 是否结对
	private String xjd;// 是否需要结对

	private String cj;// 村居
	private String xz;// 乡镇
	private String xq;// 县区
	private String year;// 查询的年份
	private String aab004; // 户主身份证号码

	private String bfrxm; // 帮扶人姓名
	private String bfrlxfs; // 帮扶人联系方式
	private String bfdw; // 帮扶单位
	private Integer sfyzf;// 是否有住房（0：无；1：有；）
	private String jtzfzp; //家庭住房照片
	private String isWf; //是否危房1：是0：不是
	///住房安全有保障
	private String nd; //住房安全有保障下的年度
	private String ztz;//改造金额
	private String gzfs;//改造方式
    private String sfss;//是否属实
    private String remark;//备注；
    
    ///已脱贫危房户
    private String hzxm;   //户主姓名
    private String hzsfzh; //户主身份证
    private String wxdj; //危险等级
    private String zt;  //改造状态
    private String tpbz;  //脱贫标志
    
    private String remarks;//改造备注
    
    //参保类型
    private String cblx;//参保类型
    
    private String name;//参保人姓名
    
    private String sfzh;//参保人身份证号
    private String tpbzName;
    
    
    private String status;//疑似危房处理情况
    
    
    private String fhjgsfss;//疑似危房处理情况 复核结果是否属实  1-属实，0-不属实
    
    
    
  	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFhjgsfss() {
  		return fhjgsfss;
  	}

  	public void setFhjgsfss(String fhjgsfss) {
  		this.fhjgsfss = fhjgsfss;
  	}

    
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCblx() {
		return cblx;
	}

	public void setCblx(String cblx) {
		this.cblx = cblx;
	}

	public String getTpbzName() {
		return tpbzName;
	}

	public void setTpbzName(String tpbzName) {
		this.tpbzName = tpbzName;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getZtz() {
		return ztz;
	}

	public void setZtz(String ztz) {
		this.ztz = ztz;
	}

	public String getGzfs() {
		return gzfs;
	}

	public void setGzfs(String gzfs) {
		this.gzfs = gzfs;
	}

	public String getSfss() {
		return sfss;
	}

	public void setSfss(String sfss) {
		this.sfss = sfss;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ExcelField(title = "帮扶单位", align = 2, sort = 10)
	public String getBfdw() {
		return bfdw;
	}

	public void setBfdw(String bfdw) {
		this.bfdw = bfdw;
	}

	public Integer getSfyzf() {
		return sfyzf;
	}

	public void setSfyzf(Integer sfyzf) {
		this.sfyzf = sfyzf;
	}

	@ExcelField(title = "帮扶人姓名", align = 2, sort = 8)
	public String getBfrxm() {
		return bfrxm;
	}

	public void setBfrxm(String bfrxm) {
		this.bfrxm = bfrxm;
	}

	@ExcelField(title = "帮扶人联系方式", align = 2, sort = 9)
	public String getBfrlxfs() {
		return bfrlxfs;
	}

	public void setBfrlxfs(String bfrlxfs) {
		this.bfrlxfs = bfrlxfs;
	}

	@ExcelField(title = "是否结对", align = 2, sort = 6)
	public String getSfjd() {
		return sfjd;
	}

	public void setSfjd(String sfjd) {
		this.sfjd = sfjd;
	}

	public String getAar004() {
		return aar004;
	}

	public void setAar004(String aar004) {
		this.aar004 = aar004;
	}

	public String getAar005() {
		return aar005;
	}

	public void setAar005(String aar005) {
		this.aar005 = aar005;
	}

	public String getAar006() {
		return aar006;
	}

	public void setAar006(String aar006) {
		this.aar006 = aar006;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@ExcelField(title = "村居", align = 2, sort = 3)
	public String getCj() {
		return cj;
	}

	public void setCj(String cj) {
		this.cj = cj;
	}

	@ExcelField(title = "乡镇", align = 2, sort = 2)
	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	@ExcelField(title = "县区", align = 2, sort = 1)
	public String getXq() {
		return xq;
	}

	public void setXq(String xq) {
		this.xq = xq;
	}


	public JiangsuAb01 getJiangsuAb01() {
		return jiangsuAb01;
	}

	public void setJiangsuAb01(JiangsuAb01 jiangsuAb01) {
		this.jiangsuAb01 = jiangsuAb01;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public Integer getAac001() { return Aac001; } public void setAac001(Integer
	 * aac001) { Aac001 = aac001; }
	 */

	public String getAar008() {
		return Aar008;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public void setAar008(String aar008) {
		Aar008 = aar008;
	}

	public String getAar012() {
		return Aar012;
	}

	public void setAar012(String aar012) {
		Aar012 = aar012;
	}

	public String getAaq002() {
		return Aaq002;
	}

	public void setAaq002(String aaq002) {
		Aaq002 = aaq002;
	}

	public String getAac004() {
		return Aac004;
	}

	public void setAac004(String aac004) {
		Aac004 = aac004;
	}

	public String getAac005() {
		return Aac005;
	}

	public void setAac005(String aac005) {
		Aac005 = aac005;
	}

	@ExcelField(title = "贫困户属性", align = 2, sort = 7)
	public String getAac006() {
		return aac006;
	}

	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}

	public String getAac007() {
		return Aac007;
	}

	public void setAac007(String aac007) {
		Aac007 = aac007;
	}

	public String getAac008() {
		return Aac008;
	}

	public void setAac008(String aac008) {
		Aac008 = aac008;
	}

	public String getAac011() {
		return Aac011;
	}

	public void setAac011(String aac011) {
		Aac011 = aac011;
	}

	public String getAad041() {
		return Aad041;
	}

	public void setAad041(String aad041) {
		Aad041 = aad041;
	}

	public String getAac012() {
		return Aac012;
	}

	public void setAac012(String aac012) {
		Aac012 = aac012;
	}

	public String getAac013() {
		return Aac013;
	}

	public void setAac013(String aac013) {
		Aac013 = aac013;
	}

	public String getAac014() {
		return Aac014;
	}

	public void setAac014(String aac014) {
		Aac014 = aac014;
	}

	public String getAar010() {
		return Aar010;
	}

	public void setAar010(String aar010) {
		Aar010 = aar010;
	}

	public Integer getAar057() {
		return Aar057;
	}

	public void setAar057(Integer aar057) {
		Aar057 = aar057;
	}

	public String getAar058() {
		return Aar058;
	}

	public void setAar058(String aar058) {
		Aar058 = aar058;
	}

	public Integer getAar040() {
		return Aar040;
	}

	public void setAar040(Integer aar040) {
		Aar040 = aar040;
	}

	@ExcelField(title = "贫困户姓名", align = 2, sort = 4)
	public String getAab002() {
		return aab002;
	}

	public void setAab002(String aab002) {
		this.aab002 = aab002;
	}

	@ExcelField(title = "证件号码", align = 2, sort = 5)
	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	public String getTpnd() {
		return tpnd;
	}

	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}

	public String getXjd() {
		return xjd;
	}

	public void setXjd(String xjd) {
		this.xjd = xjd;
	}

	public String getJtzfzp() {
		return jtzfzp;
	}

	public void setJtzfzp(String jtzfzp) {
		this.jtzfzp = jtzfzp;
	}

	public String getIsWf() {
		return isWf;
	}

	public void setIsWf(String isWf) {
		this.isWf = isWf;
	}

	public String getHzxm() {
		return hzxm;
	}

	public void setHzxm(String hzxm) {
		this.hzxm = hzxm;
	}

	public String getHzsfzh() {
		return hzsfzh;
	}

	public void setHzsfzh(String hzsfzh) {
		this.hzsfzh = hzsfzh;
	}

	public String getWxdj() {
		return wxdj;
	}

	public void setWxdj(String wxdj) {
		this.wxdj = wxdj;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}


	public String getTpbz() {
		return tpbz;
	}

	public void setTpbz(String tpbz) {
		this.tpbz = tpbz;
	}

}
