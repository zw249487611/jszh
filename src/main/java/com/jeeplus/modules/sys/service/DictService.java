/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sys.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.service.CrudService;
import com.jeeplus.common.utils.CacheUtils;
import com.jeeplus.modules.sys.dao.DictDao;
import com.jeeplus.modules.sys.entity.Area;
import com.jeeplus.modules.sys.entity.Dict;
import com.jeeplus.modules.sys.utils.DictUtils;
import com.jeeplus.modules.sys.utils.UserUtils;

/**
 * 字典Service
 * @author jeeplus
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}
	
	public String getLabel(Dict dict){
		return dao.getLabel(dict);
	}
	
	/**
	 * 生成自增长id
	 * @param str
	 * @return
	 */
	public String getIncrementId(String str){
		Integer incrementId = dao.getIncrementId(str);
		String incrementStr ="0000000";
		if(incrementId != null && incrementId != 0){
			incrementStr = String.valueOf(incrementId);
			switch(incrementStr.length()){
			case 1:
				incrementStr = "000000"+incrementStr;
				break;
			case 2:
				incrementStr = "00000"+incrementStr;
				break;
			case 3:
				incrementStr = "0000"+incrementStr;
				break;
			case 4:
				incrementStr = "000"+incrementStr;
				break;
			case 5:
				incrementStr = "00"+incrementStr;
				break;
			case 6:
				incrementStr = "0"+incrementStr;
				break;
			}
		}
		String areaId = UserUtils.getUser().getOffice().getArea().getId();
		Area area = areaService.get(areaId);
		String areaCode = area.getCode();
		areaCode = areaCode.substring(0, 4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		String dateStr = sdf.format(new Date());
		incrementStr = areaCode + dateStr + incrementStr;
		return  incrementStr;
	}

}
