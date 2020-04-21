package com.jeeplus.modules.zjjg.entity;

import com.jeeplus.common.persistence.DataEntity;

public class Common extends DataEntity<Common> {
	// A.ID, A.XMMC, C.NAME, A.SSZT, B.AREA_ID, C.ID, C.TYPE 

 private String id;
 private String axmmc;
 private String cname;
 private String asszt;
 private String bareaid;
 private String cid;
 private String ctype;
 private String xqid;
public String getXqid() {
	return xqid;
}
public void setXqid(String xqid) {
	this.xqid = xqid;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAxmmc() {
	return axmmc;
}
public void setAxmmc(String axmmc) {
	this.axmmc = axmmc;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getAsszt() {
	return asszt;
}
public void setAsszt(String asszt) {
	this.asszt = asszt;
}
public String getBareaid() {
	return bareaid;
}
public void setBareaid(String bareaid) {
	this.bareaid = bareaid;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCtype() {
	return ctype;
}
public void setCtype(String ctype) {
	this.ctype = ctype;
}

}
