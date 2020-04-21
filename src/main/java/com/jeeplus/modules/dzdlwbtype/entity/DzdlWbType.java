/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.dzdlwbtype.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 电子导览物标类型管理Entity
 * @author 刘泽敏
 * @version 2016-10-25
 */
public class DzdlWbType extends DataEntity<DzdlWbType> {
	
	private static final long serialVersionUID = 1L;
	private Integer type;		// 类型
	private String logo;		// 物标logo
	private String desc;		// 描述说明
	
	public DzdlWbType() {
		super();
	}

	public DzdlWbType(String id){
		super(id);
	}

	@ExcelField(title="类型", dictType="", align=2, sort=7)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	@ExcelField(title="物标logo", align=2, sort=8)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@ExcelField(title="描述说明", align=2, sort=9)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}