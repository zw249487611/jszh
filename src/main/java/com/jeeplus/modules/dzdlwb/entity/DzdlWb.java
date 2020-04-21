/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlwb.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 物标管理Entity
 * @author 刘泽敏
 * @version 2016-10-26
 */
public class DzdlWb extends DataEntity<DzdlWb> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 物标名称
	private String details;		// 物标介绍
	private String type;		// 物标类型
	private String logo;		// 物标logo
	private String description;		// 物标详细介绍
	private String picture;		// 物标图片
	private String mp3desc;		// 音频介绍
	private String mp4desc;		// 视频介绍
	private String xlocation;		// x轴坐标
	private String ylocation;		// y轴坐标
	
	public DzdlWb() {
		super();
	}

	public DzdlWb(String id){
		super(id);
	}

	@ExcelField(title="物标名称", align=2, sort=6)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelField(title="物标介绍", align=2, sort=7)
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	@ExcelField(title="物标类型", dictType="", align=2, sort=8)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@ExcelField(title="物标logo", align=2, sort=9)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@ExcelField(title="物标详细介绍", align=2, sort=10)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ExcelField(title="物标图片", align=2, sort=11)
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@ExcelField(title="音频介绍", align=2, sort=12)
	public String getMp3desc() {
		return mp3desc;
	}

	public void setMp3desc(String mp3desc) {
		this.mp3desc = mp3desc;
	}
	
	@ExcelField(title="视频介绍", align=2, sort=13)
	public String getMp4desc() {
		return mp4desc;
	}

	public void setMp4desc(String mp4desc) {
		this.mp4desc = mp4desc;
	}
	
	@ExcelField(title="x轴坐标", align=2, sort=14)
	public String getXlocation() {
		return xlocation;
	}

	public void setXlocation(String xlocation) {
		this.xlocation = xlocation;
	}
	
	@ExcelField(title="y轴坐标", align=2, sort=15)
	public String getYlocation() {
		return ylocation;
	}

	public void setYlocation(String ylocation) {
		this.ylocation = ylocation;
	}
	
}