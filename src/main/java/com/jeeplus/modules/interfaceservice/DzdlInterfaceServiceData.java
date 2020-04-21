/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.interfaceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeeplus.common.json.AjaxJson;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.dzdlwbtype.service.DzdlWbTypeService;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 电子导览管理Controller,主要用来对外提供接口数据服务
 * @author 刘泽敏
 * @version 2016-10-28
 */
@Controller
@RequestMapping(value = "${adminPath}/interfaceService")
public class DzdlInterfaceServiceData extends BaseController {

	@Autowired
	private DzdlWbTypeService dzdlWbTypeService;

	/**
	 * 返回物标类型信息
	 */
	@ResponseBody
	@RequestMapping(value = "dzdlwbtypeData", method = RequestMethod.POST)
	public AjaxJson infoData() {
		AjaxJson j = new AjaxJson();
		j.setSuccess(true);
		j.setErrorCode("-1");
		j.setMsg("获取物标类型信息!");
		j.put("data", UserUtils.getUser());
		return j;
	}

}