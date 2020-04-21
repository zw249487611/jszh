package com.jeeplus.modules.app.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PkhDetailInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;
	//是否可修改
	private String ifkxg;
	// 是否新增
	private String isAdd;
	// 新增贫困户编号
	private String id;
	// 帮扶人ID
	private String bfrbh;
	// 帮扶人姓名
	private String bfrxm;
	// 帮扶人联系电话
	private String lxdh;
	// 所属县(区)
	private String ssxq;
	// 所属乡镇
	private String ssxz;
	// 所属村
	private String ssc;
	// 村编号
	private String cbh;
	// 贫困户编号
	private String pkhbh;
	// 户主姓名
	private String hzxm;
	// 户主身份证号
	private String hzsfzh;
	// 家庭人口数
	private int jtrks;
	// 户主联系方式
	private String hzlxfs;
	// 家庭成员
	private List<PkrkInfoVo> jtcy;
	// 贫困户属性
	private String pkhsx;
	// 致贫原因
	private String zpyy;
	// 备注
	private String remark;
	// 帮扶责任人姓名
	private String bfzrrxm;
	// 帮扶单位
	private String bfdw;
	// 职务
	private String zw;
	// 帮扶人联系方式
	private String bfrlxfs;
	// 直接到户项目
	private List<PkhxmxxInfoVo> zjdhxm;
	// 扶贫小额贷款
	private String xedk;
	// 慈善及公益增送物资
	private String csjgyzswz;
	// 其它
	private String qtbf;
	// 今年以来家庭收入
	private BigDecimal jnyljtsr;
	// 今年以来人均收入
	private BigDecimal jnylrjsr;
	// 预计全年家庭收入
	private BigDecimal yjqnjtsr;
	// 预计全年人均收入
	private BigDecimal yjqnrjsr;
	// 经营性收入
	private BigDecimal jyxsr;
	// 水稻（亩）
	private BigDecimal sdms;
	// 水稻收入
	private BigDecimal sdsr;
	// 小麦（亩）
	private BigDecimal xmms;
	// 小麦收入
	private BigDecimal xmsr;
	// 玉米（亩）
	private BigDecimal ymms;
	// 玉米收入
	private BigDecimal ymsr;
	// 其他种植（亩）
	private BigDecimal qtzzms;
	// 其它种植收入
	private BigDecimal qtzzsr;
	// 鸡（只）
	private int jzs;
	// 鸡收入
	private BigDecimal jsr;
	// 猪（头）
	private int zts;
	// 猪收入
	private BigDecimal zsr;
	// 羊（只）
	private int yzs;
	// 羊收入
	private BigDecimal ysr;
	// 其它养殖
	private int qtyzs;
	// 其他养殖收入
	private BigDecimal qtyzsr;
	// 养殖业其它收入
	private BigDecimal yzqtsr;
	// 工资性收入
	private BigDecimal gzxsr;
	// 务工收入
	private List<PkhwgsrInfoVo> wgsr;
	// 其他工资性收入
	private BigDecimal qtar;
	// 财产性收入
	private BigDecimal ccxsr;
	// 利息收入
	private BigDecimal lxsr;
	// 红利收入
	private BigDecimal hlsr;
	// 流转承包土地经营权租金收入
	private BigDecimal lzcbtdjyqzjsr;
	// 资产出租收入
	private BigDecimal zcczsr;
	// 其它财产性收入
	private BigDecimal qtccxsr;
	// 转移性收入
	private BigDecimal zyxsr;
	// 带动增收项目收益分配
	private BigDecimal ddzsxmsyfp;
	// 村集体经济项目收益分配
	private BigDecimal cjtjjxmsyfp;
	// 直接到户项目收益
	private BigDecimal zjdhxmsy;
	// 社会救济和补助
	private BigDecimal shjjhbz;
	// 政策性生产补贴
	private BigDecimal zcxscbt;
	// 政策性生活补贴
	private BigDecimal zcxshbt;
	// 危房改造补贴
	private BigDecimal wfgzbt;
	// 教育资助
	private BigDecimal jyzz;
	// 慈善捐助
	private BigDecimal csjz;
	// 养老金
	private BigDecimal ylj;
	// 帮扶慰问金
	private BigDecimal bfwwj;
	// 其它
	private String qt;
	// 其它收入
	private BigDecimal qtsr;
	// 贫困程度
	private String pkcd;
	// 脱贫难度
	private String tpnd;
	// 急需帮扶措施
	private String jxbfcs;
	// 脱贫计划
	private String tpjh;
	// 脱贫年度
	private String tpyear;
	// 分区年度
	private String fqnd;
	// 季度
	private String jd;
	// 定位地址
	private String dwdz;
	// 图片列表
	private List<AppsjtpInfoVo> urls;
	// 图片转换后的字符串
	private String urlStr;
	// 创建时间
	private String createDate;
	// 脱贫情况编号
	private String tpqkid;
	// 签到信息
	private List<AppQdxxInfoVo> qdxxList;
	// 培训需求
	private String pxxq;
	// 岗位需求
	private String gwxq;
	// 培训需求
	private String pxxqName;
	// 岗位需求
	private String gwxqName;
	// 培训需求集合
	private List<Map<String, String>> pxxqMap;
	// 岗位需求集合
	private List<Map<String, String>> gwxqMap;

	// 是否与实际收入相符（0：不相符; 1：相符）
	private Integer isMatchActual;
	// 收入情况备注
	private String incomeRemark;
	// （转移性收入）是否与实际收入相符（0：不相符; 1：相符）
	private Integer zyxsrIsMatchActual;
	// （转移性收入）收入情况备注
	private String zyxsrIncomeRemark;

	// 脱贫标志
	private String sftp;

	// 是否与实际情况相符(0:否 1:是)
	private String isAccord;

	//APP预警信息表编号(2：家庭人员信息预警)
	private String appYjxxId2;

	//预警类型
	private String yjTYpe;

	//边缘户
	// 边缘户id
	private String byhid;
	//人大备注
	private String remarkForByh;
	//个人小结
	private String grxj;
	//人大姓名
	private String dbxm;
	//代表类型
	private String npclabel;
	//所在代表团
	private String delegation;
	//所在单位及职务
	private String unitandduty;
	//微信号
	private String wechat;
	//人大手机
	private String rdsj;
	//走访id
	private String zfid;
	//人大类型
	private String rdType;//10:否 20:是
	//贫困户编号集合
	private List<String> pkhbhList;
	private int index;
	//是否脱贫
	private String isTp;//0:否 1:是
	//土地流转面积
	private BigDecimal tdlzmj;
	//纬度	lng
	private String lng;
	//经度	lat
	private String lat;
	//赡养费
	private BigDecimal syf;


	// 山芋（亩）
	private BigDecimal shanyu;
	// 山芋收入
	private BigDecimal shanyusr;
	// 油菜（亩）
	private BigDecimal youcai;
	// 油菜收入
	private BigDecimal youcaisr;
	// 花生（亩）
	private BigDecimal huasheng;
	// 花生收入
	private BigDecimal huashengsr;
	// 大豆（亩）
	private BigDecimal dadou;
	// 大豆收入
	private BigDecimal dadousr;
	//露天种植蔬菜（亩）
	private BigDecimal lutianshucai;
	// 露天种植蔬菜收入
	private BigDecimal lutianshucaisr;
	// 大棚西瓜（亩）
	private BigDecimal dapengxigua;
	// 大棚西瓜
	private BigDecimal dapengxiguasr;
	// 蛋鸡（只）
	private BigDecimal danji;
	// 蛋鸡收入
	private BigDecimal danjisr;
	// 鸭（只）
	private BigDecimal ya;
	// 鸭收入
	private BigDecimal yasr;
	// 鹅（只）
	private BigDecimal e;
	// 鹅收入
	private BigDecimal esr;
	// 鱼（亩）
	private BigDecimal yu;
	// 鱼收入
	private BigDecimal yusr;
	// 螃蟹（亩）
	private BigDecimal pangxie;
	// 螃蟹收入
	private BigDecimal pangxiesr;
	// 龙虾（亩）
	private BigDecimal longxia;
	// 龙虾收入
	private BigDecimal longxiasr;
	// 大棚草莓（亩）
	private BigDecimal dapengcaomei;
	// 大棚草莓收入
	private BigDecimal dapengcaomeisr;
	// 大棚香瓜（亩）
	private BigDecimal dapengxianggua;
	// 大棚香瓜收入
	private BigDecimal dapengxiangguasr;
	// 大棚食用菌（亩）
	private BigDecimal dapengshiyongjun;
	// 大棚食用菌收入
	private BigDecimal dapengshiyongjunsr;
	// 大棚红椒（亩）
	private BigDecimal dapenghongjiao;
	// 大棚红椒收入
	private BigDecimal dapenghongjiaosr;
	//子女数
	private int zinvshu;
	//走访年度
	private String nd;
	
	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBfrbh() {
		return bfrbh;
	}

	public void setBfrbh(String bfrbh) {
		this.bfrbh = bfrbh;
	}

	public String getSsxq() {
		return ssxq;
	}

	public void setSsxq(String ssxq) {
		this.ssxq = ssxq;
	}

	public String getSsxz() {
		return ssxz;
	}

	public void setSsxz(String ssxz) {
		this.ssxz = ssxz;
	}

	public String getSsc() {
		return ssc;
	}

	public void setSsc(String ssc) {
		this.ssc = ssc;
	}

	public String getCbh() {
		return cbh;
	}

	public void setCbh(String cbh) {
		this.cbh = cbh;
	}

	public String getPkhbh() {
		return pkhbh;
	}

	public void setPkhbh(String pkhbh) {
		this.pkhbh = pkhbh;
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

	public int getJtrks() {
		return jtrks;
	}

	public void setJtrks(int jtrks) {
		this.jtrks = jtrks;
	}

	public String getHzlxfs() {
		return hzlxfs;
	}

	public void setHzlxfs(String hzlxfs) {
		this.hzlxfs = hzlxfs;
	}

	public String getPkhsx() {
		return pkhsx;
	}

	public void setPkhsx(String pkhsx) {
		this.pkhsx = pkhsx;
	}

	public String getZpyy() {
		return zpyy;
	}

	public void setZpyy(String zpyy) {
		this.zpyy = zpyy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBfzrrxm() {
		return bfzrrxm;
	}

	public void setBfzrrxm(String bfzrrxm) {
		this.bfzrrxm = bfzrrxm;
	}

	public String getBfdw() {
		return bfdw;
	}

	public void setBfdw(String bfdw) {
		this.bfdw = bfdw;
	}

	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getBfrlxfs() {
		return bfrlxfs;
	}

	public void setBfrlxfs(String bfrlxfs) {
		this.bfrlxfs = bfrlxfs;
	}

	public String getXedk() {
		return xedk;
	}

	public void setXedk(String xedk) {
		this.xedk = xedk;
	}

	public String getCsjgyzswz() {
		return csjgyzswz;
	}

	public void setCsjgyzswz(String csjgyzswz) {
		this.csjgyzswz = csjgyzswz;
	}

	public String getQtbf() {
		return qtbf;
	}

	public void setQtbf(String qtbf) {
		this.qtbf = qtbf;
	}

	public BigDecimal getJnyljtsr() {
		return jnyljtsr;
	}

	public void setJnyljtsr(BigDecimal jnyljtsr) {
		this.jnyljtsr = jnyljtsr;
	}

	public BigDecimal getJnylrjsr() {
		return jnylrjsr;
	}

	public void setJnylrjsr(BigDecimal jnylrjsr) {
		this.jnylrjsr = jnylrjsr;
	}

	public BigDecimal getYjqnjtsr() {
		return yjqnjtsr;
	}

	public void setYjqnjtsr(BigDecimal yjqnjtsr) {
		this.yjqnjtsr = yjqnjtsr;
	}

	public BigDecimal getYjqnrjsr() {
		return yjqnrjsr;
	}

	public void setYjqnrjsr(BigDecimal yjqnrjsr) {
		this.yjqnrjsr = yjqnrjsr;
	}

	public BigDecimal getJyxsr() {
		return jyxsr;
	}

	public void setJyxsr(BigDecimal jyxsr) {
		this.jyxsr = jyxsr;
	}

	public BigDecimal getSdms() {
		return sdms;
	}

	public void setSdms(BigDecimal sdms) {
		this.sdms = sdms;
	}

	public BigDecimal getSdsr() {
		return sdsr;
	}

	public void setSdsr(BigDecimal sdsr) {
		this.sdsr = sdsr;
	}

	public BigDecimal getXmms() {
		return xmms;
	}

	public void setXmms(BigDecimal xmms) {
		this.xmms = xmms;
	}

	public BigDecimal getXmsr() {
		return xmsr;
	}

	public void setXmsr(BigDecimal xmsr) {
		this.xmsr = xmsr;
	}

	public BigDecimal getYmms() {
		return ymms;
	}

	public void setYmms(BigDecimal ymms) {
		this.ymms = ymms;
	}

	public BigDecimal getYmsr() {
		return ymsr;
	}

	public void setYmsr(BigDecimal ymsr) {
		this.ymsr = ymsr;
	}

	public BigDecimal getQtzzms() {
		return qtzzms;
	}

	public void setQtzzms(BigDecimal qtzzms) {
		this.qtzzms = qtzzms;
	}

	public BigDecimal getQtzzsr() {
		return qtzzsr;
	}

	public void setQtzzsr(BigDecimal qtzzsr) {
		this.qtzzsr = qtzzsr;
	}

	public int getJzs() {
		return jzs;
	}

	public void setJzs(int jzs) {
		this.jzs = jzs;
	}

	public BigDecimal getJsr() {
		return jsr;
	}

	public void setJsr(BigDecimal jsr) {
		this.jsr = jsr;
	}

	public int getZts() {
		return zts;
	}

	public void setZts(int zts) {
		this.zts = zts;
	}

	public BigDecimal getZsr() {
		return zsr;
	}

	public void setZsr(BigDecimal zsr) {
		this.zsr = zsr;
	}

	public int getYzs() {
		return yzs;
	}

	public void setYzs(int yzs) {
		this.yzs = yzs;
	}

	public BigDecimal getYsr() {
		return ysr;
	}

	public void setYsr(BigDecimal ysr) {
		this.ysr = ysr;
	}

	public int getQtyzs() {
		return qtyzs;
	}

	public void setQtyzs(int qtyzs) {
		this.qtyzs = qtyzs;
	}

	public BigDecimal getQtyzsr() {
		return qtyzsr;
	}

	public void setQtyzsr(BigDecimal qtyzsr) {
		this.qtyzsr = qtyzsr;
	}

	public BigDecimal getGzxsr() {
		return gzxsr;
	}

	public void setGzxsr(BigDecimal gzxsr) {
		this.gzxsr = gzxsr;
	}

	public List<PkhwgsrInfoVo> getWgsr() {
		return wgsr;
	}

	public void setWgsr(List<PkhwgsrInfoVo> wgsr) {
		this.wgsr = wgsr;
	}

	public BigDecimal getQtar() {
		return qtar;
	}

	public void setQtar(BigDecimal qtar) {
		this.qtar = qtar;
	}

	public BigDecimal getCcxsr() {
		return ccxsr;
	}

	public void setCcxsr(BigDecimal ccxsr) {
		this.ccxsr = ccxsr;
	}

	public BigDecimal getLxsr() {
		return lxsr;
	}

	public void setLxsr(BigDecimal lxsr) {
		this.lxsr = lxsr;
	}

	public BigDecimal getHlsr() {
		return hlsr;
	}

	public void setHlsr(BigDecimal hlsr) {
		this.hlsr = hlsr;
	}

	public BigDecimal getLzcbtdjyqzjsr() {
		return lzcbtdjyqzjsr;
	}

	public void setLzcbtdjyqzjsr(BigDecimal lzcbtdjyqzjsr) {
		this.lzcbtdjyqzjsr = lzcbtdjyqzjsr;
	}

	public BigDecimal getZcczsr() {
		return zcczsr;
	}

	public void setZcczsr(BigDecimal zcczsr) {
		this.zcczsr = zcczsr;
	}

	public BigDecimal getQtccxsr() {
		return qtccxsr;
	}

	public void setQtccxsr(BigDecimal qtccxsr) {
		this.qtccxsr = qtccxsr;
	}

	public BigDecimal getZyxsr() {
		return zyxsr;
	}

	public void setZyxsr(BigDecimal zyxsr) {
		this.zyxsr = zyxsr;
	}

	public BigDecimal getDdzsxmsyfp() {
		return ddzsxmsyfp;
	}

	public void setDdzsxmsyfp(BigDecimal ddzsxmsyfp) {
		this.ddzsxmsyfp = ddzsxmsyfp;
	}

	public BigDecimal getCjtjjxmsyfp() {
		return cjtjjxmsyfp;
	}

	public void setCjtjjxmsyfp(BigDecimal cjtjjxmsyfp) {
		this.cjtjjxmsyfp = cjtjjxmsyfp;
	}

	public BigDecimal getZjdhxmsy() {
		return zjdhxmsy;
	}

	public void setZjdhxmsy(BigDecimal zjdhxmsy) {
		this.zjdhxmsy = zjdhxmsy;
	}

	public BigDecimal getShjjhbz() {
		return shjjhbz;
	}

	public void setShjjhbz(BigDecimal shjjhbz) {
		this.shjjhbz = shjjhbz;
	}

	public BigDecimal getZcxscbt() {
		return zcxscbt;
	}

	public void setZcxscbt(BigDecimal zcxscbt) {
		this.zcxscbt = zcxscbt;
	}

	public BigDecimal getZcxshbt() {
		return zcxshbt;
	}

	public void setZcxshbt(BigDecimal zcxshbt) {
		this.zcxshbt = zcxshbt;
	}

	public BigDecimal getJyzz() {
		return jyzz;
	}

	public void setJyzz(BigDecimal jyzz) {
		this.jyzz = jyzz;
	}

	public BigDecimal getCsjz() {
		return csjz;
	}

	public void setCsjz(BigDecimal csjz) {
		this.csjz = csjz;
	}

	public BigDecimal getYlj() {
		return ylj;
	}

	public void setYlj(BigDecimal ylj) {
		this.ylj = ylj;
	}

	public BigDecimal getBfwwj() {
		return bfwwj;
	}

	public void setBfwwj(BigDecimal bfwwj) {
		this.bfwwj = bfwwj;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public BigDecimal getQtsr() {
		return qtsr;
	}

	public void setQtsr(BigDecimal qtsr) {
		this.qtsr = qtsr;
	}

	public String getPkcd() {
		return pkcd;
	}

	public void setPkcd(String pkcd) {
		this.pkcd = pkcd;
	}

	public String getTpnd() {
		return tpnd;
	}

	public void setTpnd(String tpnd) {
		this.tpnd = tpnd;
	}

	public String getJxbfcs() {
		return jxbfcs;
	}

	public void setJxbfcs(String jxbfcs) {
		this.jxbfcs = jxbfcs;
	}

	public String getTpjh() {
		return tpjh;
	}

	public void setTpjh(String tpjh) {
		this.tpjh = tpjh;
	}

	public String getTpyear() {
		return tpyear;
	}

	public void setTpyear(String tpyear) {
		this.tpyear = tpyear;
	}

	public String getFqnd() {
		return fqnd;
	}

	public void setFqnd(String fqnd) {
		this.fqnd = fqnd;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getBfrxm() {
		return bfrxm;
	}

	public void setBfrxm(String bfrxm) {
		this.bfrxm = bfrxm;
	}

	public List<PkrkInfoVo> getJtcy() {
		return jtcy;
	}

	public void setJtcy(List<PkrkInfoVo> jtcy) {
		this.jtcy = jtcy;
	}

	public BigDecimal getYzqtsr() {
		return yzqtsr;
	}

	public void setYzqtsr(BigDecimal yzqtsr) {
		this.yzqtsr = yzqtsr;
	}

	public List<PkhxmxxInfoVo> getZjdhxm() {
		return zjdhxm;
	}

	public void setZjdhxm(List<PkhxmxxInfoVo> zjdhxm) {
		this.zjdhxm = zjdhxm;
	}

	public String getDwdz() {
		return dwdz;
	}

	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}

	public List<AppsjtpInfoVo> getUrls() {
		return urls;
	}

	public void setUrls(List<AppsjtpInfoVo> urls) {
		this.urls = urls;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}

	public String getUrlStr() {
		return urlStr;
	}

	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}

	public String getTpqkid() {
		return tpqkid;
	}

	public void setTpqkid(String tpqkid) {
		this.tpqkid = tpqkid;
	}

	public List<AppQdxxInfoVo> getQdxxList() {
		return qdxxList;
	}

	public void setQdxxList(List<AppQdxxInfoVo> qdxxList) {
		this.qdxxList = qdxxList;
	}

	public String getPxxq() {
		return pxxq;
	}

	public void setPxxq(String pxxq) {
		this.pxxq = pxxq;
	}

	public String getGwxq() {
		return gwxq;
	}

	public void setGwxq(String gwxq) {
		this.gwxq = gwxq;
	}

	public List<Map<String, String>> getPxxqMap() {
		return pxxqMap;
	}

	public void setPxxqMap(List<Map<String, String>> pxxqMap) {
		this.pxxqMap = pxxqMap;
	}

	public List<Map<String, String>> getGwxqMap() {
		return gwxqMap;
	}

	public void setGwxqMap(List<Map<String, String>> gwxqMap) {
		this.gwxqMap = gwxqMap;
	}

	public String getPxxqName() {
		return pxxqName;
	}

	public void setPxxqName(String pxxqName) {
		this.pxxqName = pxxqName;
	}

	public String getGwxqName() {
		return gwxqName;
	}

	public void setGwxqName(String gwxqName) {
		this.gwxqName = gwxqName;
	}

	public Integer getIsMatchActual() {
		return isMatchActual;
	}

	public void setIsMatchActual(Integer isMatchActual) {
		this.isMatchActual = isMatchActual;
	}

	public String getIncomeRemark() {
		return incomeRemark;
	}

	public void setIncomeRemark(String incomeRemark) {
		this.incomeRemark = incomeRemark;
	}

	public Integer getZyxsrIsMatchActual() {
		return zyxsrIsMatchActual;
	}

	public void setZyxsrIsMatchActual(Integer zyxsrIsMatchActual) {
		this.zyxsrIsMatchActual = zyxsrIsMatchActual;
	}

	public String getZyxsrIncomeRemark() {
		return zyxsrIncomeRemark;
	}

	public void setZyxsrIncomeRemark(String zyxsrIncomeRemark) {
		this.zyxsrIncomeRemark = zyxsrIncomeRemark;
	}

	public String getSftp() {
		return sftp;
	}

	public void setSftp(String sftp) {
		this.sftp = sftp;
	}


	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getByhid() {
		return byhid;
	}

	public void setByhid(String byhid) {
		this.byhid = byhid;
	}

	public String getRemarkForByh() {
		return remarkForByh;
	}

	public void setRemarkForByh(String remarkForByh) {
		this.remarkForByh = remarkForByh;
	}

	public String getGrxj() {
		return grxj;
	}

	public void setGrxj(String grxj) {
		this.grxj = grxj;
	}


	public String getDbxm() {
		return dbxm;
	}

	public void setDbxm(String dbxm) {
		this.dbxm = dbxm;
	}

	public String getNpclabel() {
		return npclabel;
	}

	public void setNpclabel(String npclabel) {
		this.npclabel = npclabel;
	}

	public String getDelegation() {
		return delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getUnitandduty() {
		return unitandduty;
	}

	public void setUnitandduty(String unitandduty) {
		this.unitandduty = unitandduty;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getRdsj() {
		return rdsj;
	}

	public void setRdsj(String rdsj) {
		this.rdsj = rdsj;
	}

	public String getZfid() {
		return zfid;
	}

	public void setZfid(String zfid) {
		this.zfid = zfid;
	}

	public String getRdType() {
		return rdType;
	}

	public void setRdType(String rdType) {
		this.rdType = rdType;
	}

	public String getIsAccord() {
		return isAccord;
	}

	public void setIsAccord(String isAccord) {
		this.isAccord = isAccord;
	}

	public String getYjTYpe() {
		return yjTYpe;
	}

	public void setYjTYpe(String yjTYpe) {
		this.yjTYpe = yjTYpe;
	}

	public String getAppYjxxId2() {
		return appYjxxId2;
	}

	public void setAppYjxxId2(String appYjxxId2) {
		this.appYjxxId2 = appYjxxId2;
	}
	public List<String> getPkhbhList() {
		return pkhbhList;
	}
	public int getIndex() {
		return index;
	}

	public void setPkhbhList(List<String> pkhbhList) {
		this.pkhbhList = pkhbhList;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public String getIsTp() {
		return isTp;
	}

	public void setIsTp(String isTp) {
		this.isTp = isTp;
	}

	public BigDecimal getTdlzmj() {
		return tdlzmj;
	}

	public void setTdlzmj(BigDecimal tdlzmj) {
		this.tdlzmj = tdlzmj;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public BigDecimal getSyf() {
		return syf;
	}

	public void setSyf(BigDecimal syf) {
		this.syf = syf;
	}

	public BigDecimal getShanyu() {
		return shanyu;
	}

	public void setShanyu(BigDecimal shanyu) {
		this.shanyu = shanyu;
	}

	public BigDecimal getShanyusr() {
		return shanyusr;
	}

	public void setShanyusr(BigDecimal shanyusr) {
		this.shanyusr = shanyusr;
	}

	public BigDecimal getYoucai() {
		return youcai;
	}

	public void setYoucai(BigDecimal youcai) {
		this.youcai = youcai;
	}

	public BigDecimal getYoucaisr() {
		return youcaisr;
	}

	public void setYoucaisr(BigDecimal youcaisr) {
		this.youcaisr = youcaisr;
	}

	public BigDecimal getHuasheng() {
		return huasheng;
	}

	public void setHuasheng(BigDecimal huasheng) {
		this.huasheng = huasheng;
	}

	public BigDecimal getHuashengsr() {
		return huashengsr;
	}

	public void setHuashengsr(BigDecimal huashengsr) {
		this.huashengsr = huashengsr;
	}

	public BigDecimal getDadou() {
		return dadou;
	}

	public void setDadou(BigDecimal dadou) {
		this.dadou = dadou;
	}

	public BigDecimal getDadousr() {
		return dadousr;
	}

	public void setDadousr(BigDecimal dadousr) {
		this.dadousr = dadousr;
	}

	public BigDecimal getLutianshucai() {
		return lutianshucai;
	}

	public void setLutianshucai(BigDecimal lutianshucai) {
		this.lutianshucai = lutianshucai;
	}

	public BigDecimal getLutianshucaisr() {
		return lutianshucaisr;
	}

	public void setLutianshucaisr(BigDecimal lutianshucaisr) {
		this.lutianshucaisr = lutianshucaisr;
	}
	public BigDecimal getDapengxigua() {
		return dapengxigua;
	}

	public void setDapengxigua(BigDecimal dapengxigua) {
		this.dapengxigua = dapengxigua;
	}

	public BigDecimal getDapengxiguasr() {
		return dapengxiguasr;
	}

	public void setDapengxiguasr(BigDecimal dapengxiguasr) {
		this.dapengxiguasr = dapengxiguasr;
	}

	public BigDecimal getDanji() {
		return danji;
	}

	public void setDanji(BigDecimal danji) {
		this.danji = danji;
	}

	public BigDecimal getDanjisr() {
		return danjisr;
	}

	public void setDanjisr(BigDecimal danjisr) {
		this.danjisr = danjisr;
	}

	public BigDecimal getYa() {
		return ya;
	}

	public void setYa(BigDecimal ya) {
		this.ya = ya;
	}

	public BigDecimal getYasr() {
		return yasr;
	}

	public void setYasr(BigDecimal yasr) {
		this.yasr = yasr;
	}

	public BigDecimal getE() {
		return e;
	}

	public void setE(BigDecimal e) {
		this.e = e;
	}

	public BigDecimal getEsr() {
		return esr;
	}

	public void setEsr(BigDecimal esr) {
		this.esr = esr;
	}

	public BigDecimal getYu() {
		return yu;
	}

	public void setYu(BigDecimal yu) {
		this.yu = yu;
	}

	public BigDecimal getYusr() {
		return yusr;
	}

	public void setYusr(BigDecimal yusr) {
		this.yusr = yusr;
	}

	public BigDecimal getPangxie() {
		return pangxie;
	}

	public void setPangxie(BigDecimal pangxie) {
		this.pangxie = pangxie;
	}

	public BigDecimal getPangxiesr() {
		return pangxiesr;
	}

	public void setPangxiesr(BigDecimal pangxiesr) {
		this.pangxiesr = pangxiesr;
	}

	public BigDecimal getLongxia() {
		return longxia;
	}

	public void setLongxia(BigDecimal longxia) {
		this.longxia = longxia;
	}

	public BigDecimal getLongxiasr() {
		return longxiasr;
	}

	public void setLongxiasr(BigDecimal longxiasr) {
		this.longxiasr = longxiasr;
	}

	public BigDecimal getDapengcaomei() {
		return dapengcaomei;
	}

	public void setDapengcaomei(BigDecimal dapengcaomei) {
		this.dapengcaomei = dapengcaomei;
	}

	public BigDecimal getDapengcaomeisr() {
		return dapengcaomeisr;
	}

	public void setDapengcaomeisr(BigDecimal dapengcaomeisr) {
		this.dapengcaomeisr = dapengcaomeisr;
	}

	public BigDecimal getDapengxianggua() {
		return dapengxianggua;
	}

	public void setDapengxianggua(BigDecimal dapengxianggua) {
		this.dapengxianggua = dapengxianggua;
	}

	public BigDecimal getDapengxiangguasr() {
		return dapengxiangguasr;
	}

	public void setDapengxiangguasr(BigDecimal dapengxiangguasr) {
		this.dapengxiangguasr = dapengxiangguasr;
	}

	public BigDecimal getDapengshiyongjun() {
		return dapengshiyongjun;
	}

	public void setDapengshiyongjun(BigDecimal dapengshiyongjun) {
		this.dapengshiyongjun = dapengshiyongjun;
	}

	public BigDecimal getDapengshiyongjunsr() {
		return dapengshiyongjunsr;
	}

	public void setDapengshiyongjunsr(BigDecimal dapengshiyongjunsr) {
		this.dapengshiyongjunsr = dapengshiyongjunsr;
	}

	public BigDecimal getDapenghongjiao() {
		return dapenghongjiao;
	}

	public void setDapenghongjiao(BigDecimal dapenghongjiao) {
		this.dapenghongjiao = dapenghongjiao;
	}

	public BigDecimal getDapenghongjiaosr() {
		return dapenghongjiaosr;
	}

	public void setDapenghongjiaosr(BigDecimal dapenghongjiaosr) {
		this.dapenghongjiaosr = dapenghongjiaosr;
	}

	public int getZinvshu() {
		return zinvshu;
	}

	public void setZinvshu(int zinvshu) {
		this.zinvshu = zinvshu;
	}

	public BigDecimal getWfgzbt() {
		return wfgzbt;
	}

	public void setWfgzbt(BigDecimal wfgzbt) {
		this.wfgzbt = wfgzbt;
	}

	public String getIfkxg() {
		return ifkxg;
	}

	public void setIfkxg(String ifkxg) {
		this.ifkxg = ifkxg;
	}

}
