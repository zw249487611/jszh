/**
 * Copyright &copy; 2016-2021 <a href="http://www.luxdo.cn/">Luxdo</a> All rights reserved.
 */
package com.jeeplus.modules.dataCount.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.app.util.Global;
import com.jeeplus.modules.app.vo.PkhDetailInfoVo;
import com.jeeplus.modules.app.vo.PkhwgsrInfoVo;
import com.jeeplus.modules.app.vo.PkhxmxxInfoVo;
import com.jeeplus.modules.app.vo.TpxxInfoVo;
import com.jeeplus.modules.dataCount.dao.JdlkhzhDao;
import com.jeeplus.modules.dataCount.entity.Jdlkhzh;
import com.jeeplus.modules.zjjg.entity.PZjRysjsb;

/**
 * 贫困户信息综合查询Service
 * @author 陆凯凯
 * @version 2017-08-30
 */
@Service
@Transactional(readOnly = true)
public class JdlkhzhService extends CrudService<JdlkhzhDao, Jdlkhzh> {
	@Autowired
	private JdlkhzhDao jdlkhzhDao;
	
	public Jdlkhzh get(String id) {
		return super.get(id);
	}
	
	public List<Jdlkhzh> findList(Jdlkhzh jdlkhzh) {
		return super.findList(jdlkhzh);
	}
	
	public Page<Jdlkhzh> findPage(Page<Jdlkhzh> page, Jdlkhzh jdlkhzh) {
		return super.findPage(page, jdlkhzh);
	}
//	zhangwei新加导出
	public Page<Jdlkhzh> findPage1(Page<Jdlkhzh> page, Jdlkhzh jdlkhzh) {
		jdlkhzh.setPage(page);
		page.setList(jdlkhzhDao.findListExport(jdlkhzh));
		return page;
	}
	
	public Page<Jdlkhzh> findListExportRen(Page<Jdlkhzh> page, Jdlkhzh jdlkhzh) {
		jdlkhzh.setPage(page);
		page.setList(jdlkhzhDao.findListExportRen(jdlkhzh));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(Jdlkhzh jdlkhzh) {
		super.save(jdlkhzh);
	}
	
	@Transactional(readOnly = false)
	public void delete(Jdlkhzh jdlkhzh) {
		super.delete(jdlkhzh);
	}
	/**
	 * 获取家庭信息
	 * @param id
	 * @param sfzh
	 * @param nd
	 * @return
	 */
	@Transactional(readOnly = false)
	public String getJdlkhxx(String id,String sfzh,String nd) {
		JSONObject result = new JSONObject();
		//获取家庭信息
		List<Jdlkhzh> jtcyList = jdlkhzhDao.findJtcyxx(id);
		JSONArray jtcyArray = new JSONArray();
		for(Jdlkhzh jtcy : jtcyList){
			JSONObject jtcyObj = new JSONObject();
			jtcyObj.put("姓名", jtcy.getXm());
			jtcyObj.put("身份证号",jtcy.getSfzh());
			jtcyObj.put("与户主关系",jtcy.getYhzgx());
			jtcyObj.put("性别",jtcy.getXb());
			jtcyObj.put("就业情况",jtcy.getJyqk());
			jtcyObj.put("入学情况",jtcy.getWhcd());
			jtcyObj.put("健康状况",jtcy.getJkzk());
			jtcyObj.put("就业单位",jtcy.getJydw());
			jtcyObj.put("入职岗位",jtcy.getRzgw());
			jtcyObj.put("慢性病",jtcy.getMxbName());
			jtcyObj.put("大病",jtcy.getHydbName());
			jtcyObj.put("rzsj",jtcy.getRzsj());
			jtcyArray.add(jtcyObj);
		}
		result.put("家庭信息", jtcyArray);
		//result.put("帮扶力量", bfllArray);
		//result.put("收入信息", srqkObj);
		//result.put("帮扶项目", bfxmArray);
		return result.toJSONString();
	}
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
	
	/**
	 * 总人数
	 * @param jiangsuAc01
	 * @return
	 */
	public String gettotalCount(Jdlkhzh jdlkhzh){
		String total = jdlkhzhDao.gettotalCount(jdlkhzh);
		return total;
	}
	
	/**
	 * 获取收入信息
	 * @param id 贫困户编号
	 * @param sfzh
	 * @param nd
	 * @return
	 */
	@Transactional(readOnly = false)
	public String getJdlkhsrxx(String id,String sfzh,String nd) {
		int tempyear = Integer.parseInt(nd)+1;
		String year = String.valueOf(tempyear);
		JSONObject result = new JSONObject();	
		//收入信息
		JSONObject srqkObj = new JSONObject();
		//判断是否是数字
		List<String> acidList = new ArrayList<String>();
		//acidList.add(id);
		//判断贫困户编号前四位（例如：2017）是否是数字
		boolean flag =isNumeric(id.substring(0, 4));
		PkhDetailInfoVo vo = new PkhDetailInfoVo();
		if(flag){
			int tempnd = Integer.parseInt(id.substring(0, 4));
			//循环遍历出历史所有贫困户编号到2017年为止
			for(int i = tempnd; i > 2015;i-- ){
				acidList.add(String.valueOf(i)+id.substring(4));
				if(i==2016){
					//贫困户编号
					vo.setPkhbh(String.valueOf(i)+id.substring(4));
				}
			}
		}
		
		//贫困户编号集合
		vo.setPkhbhList(acidList);
		//户主身份证号码
		vo.setHzsfzh(sfzh);
		
		//脱贫轨迹
		List<PkhDetailInfoVo> tpgjList =  jdlkhzhDao.findTpgj(vo);
		JSONArray tpgjArray = new JSONArray();
		if(tpgjList.size() > 0){
			for(PkhDetailInfoVo tpgj : tpgjList){
				JSONObject tpgjObj = new JSONObject();
				tpgjObj.put("贫困户编号", tpgj.getPkhbh());
				tpgjObj.put("年度", tpgj.getFqnd());
				tpgjObj.put("季度", tpgj.getJd());
				tpgjObj.put("家庭收入", tpgj.getJnyljtsr());
				tpgjObj.put("家庭人口", tpgj.getJtrks());
				tpgjObj.put("人均收入", tpgj.getJnylrjsr().setScale(2, BigDecimal.ROUND_HALF_UP));
				tpgjObj.put("是否脱贫", tpgj.getSftp());
				tpgjObj.put("收入信息编号", tpgj.getId());
				tpgjObj.put("走访时间", tpgj.getCreateDate());
				tpgjObj.put("帮扶人姓名", tpgj.getBfzrrxm());
				tpgjArray.add(tpgjObj);
			}
		}
		srqkObj.put("脱贫轨迹", tpgjArray);
		
		List<String> sfzhList = jdlkhzhDao.findSfzhm(nd,sfzh,id);
		Jdlkhzh param = new Jdlkhzh();
		param.setNd(year);
		param.setSfzhList(sfzhList);
		//财政和捐助资金
		JSONObject czhjzzjObj = new JSONObject();
		//统筹带动增收项目收益
		BigDecimal tcddzsxmsy = BigDecimal.valueOf(0);
		//省定经济薄弱村集体经济项目收益
		BigDecimal shengdjjbrcjtjjxmsy = BigDecimal.valueOf(0);
		//市定经济薄弱村集体经济项目收益
		BigDecimal shidjjbrcjtjjxmsy = BigDecimal.valueOf(0);
		//市扶贫专项项目收益
		BigDecimal sfpzxxmsy = BigDecimal.valueOf(0);
		//直接到户项目补助
		BigDecimal zjdhxmbz = BigDecimal.valueOf(0);
		
		//扶贫项目收益
		BigDecimal fpxmsy = BigDecimal.valueOf(0);
		
		List<PZjRysjsb> fpkfxmsyList = jdlkhzhDao.findFpkfxmsy(param);
		JSONArray fpkfxmsyArray = new JSONArray();
		if(fpkfxmsyList.size() > 0){
			for(PZjRysjsb fpkfxmsy : fpkfxmsyList){
				JSONObject fpkfxmsyObj = new JSONObject();
				fpkfxmsyObj.put("年度", fpkfxmsy.getNd());
				fpkfxmsyObj.put("资金名称", fpkfxmsy.getXmmc());
				fpkfxmsyObj.put("资金类型", fpkfxmsy.getZjlx());
				fpkfxmsyObj.put("金额", fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
				fpkfxmsyObj.put("拨款时间", fpkfxmsy.getBkDate());
				fpkfxmsyObj.put("拨款状态", fpkfxmsy.getBkzt());
				fpkfxmsyObj.put("姓名", fpkfxmsy.getXm());
				fpkfxmsyObj.put("身份证号", fpkfxmsy.getSfzh());
				fpkfxmsyArray.add(fpkfxmsyObj);
				
				//fpxmsy =  fpxmsy.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
				//System.out.println("-----产业扶贫-----"+fpxmsy);
				//System.out.println();
				switch(fpkfxmsy.getZjType()){
				case "1":
					tcddzsxmsy = tcddzsxmsy.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "6":
					shengdjjbrcjtjjxmsy = shengdjjbrcjtjjxmsy.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "5":
					shidjjbrcjtjjxmsy = shidjjbrcjtjjxmsy.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "4":
					sfpzxxmsy = sfpzxxmsy.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "2":
					zjdhxmbz = zjdhxmbz.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "9":
					fpxmsy =  fpxmsy.add(fpkfxmsy.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				}
			}
		}
		JSONObject fpkfxmsyObj = new JSONObject();
		fpkfxmsyObj.put("统筹带动增收项目收益", tcddzsxmsy);
		fpkfxmsyObj.put("省定经济薄弱村集体经济项目收益", shengdjjbrcjtjjxmsy);
		fpkfxmsyObj.put("市定经济薄弱村集体经济项目收益", shidjjbrcjtjjxmsy);
		fpkfxmsyObj.put("市扶贫专项项目收益", sfpzxxmsy);
		fpkfxmsyObj.put("直接到户项目补助", zjdhxmbz);
		fpkfxmsyObj.put("扶贫开发项目收益", fpxmsy);
		czhjzzjObj.put("扶贫开发项目收益", fpkfxmsyArray);
		czhjzzjObj.put("扶贫开发项目收益合计", fpkfxmsyObj);
		//社会救济和补助
		//农村低保
		BigDecimal ncdb = BigDecimal.valueOf(0);
		//尊老金
		BigDecimal zlj = BigDecimal.valueOf(0);
		//救灾救助
		BigDecimal jzjz = BigDecimal.valueOf(0);
		//特困人员供养
		BigDecimal tkrygy = BigDecimal.valueOf(0);
		//孤儿监护人缺失补助
		BigDecimal gejhrqsbz = BigDecimal.valueOf(0);
		//残疾人两项补贴
		BigDecimal cjrlxbt = BigDecimal.valueOf(0);
		//医疗救助
		BigDecimal yljz = BigDecimal.valueOf(0);
		//临时救助
		BigDecimal lsjz = BigDecimal.valueOf(0);
		//残疾人学生补助
		BigDecimal cjrxsbz = BigDecimal.valueOf(0);
		List<PZjRysjsb> shjjhbzList = jdlkhzhDao.findShjjhbz(param);
		JSONArray shjjhbzArray = new JSONArray();
		if(shjjhbzList.size() > 0){
			for(PZjRysjsb shjjhbz : shjjhbzList){
				JSONObject shjjhbzObj = new JSONObject();
				shjjhbzObj.put("年度", shjjhbz.getNd());
				shjjhbzObj.put("资金名称", shjjhbz.getXmmc());
				shjjhbzObj.put("资金类型", shjjhbz.getZjlx());
				shjjhbzObj.put("金额", shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
				shjjhbzObj.put("拨款时间", shjjhbz.getBkDate());
				shjjhbzObj.put("拨款状态", shjjhbz.getBkzt());
				shjjhbzObj.put("姓名", shjjhbz.getXm());
				shjjhbzObj.put("身份证号", shjjhbz.getSfzh());
				shjjhbzArray.add(shjjhbzObj);
				switch(shjjhbz.getZjType()){
				case "20":
					ncdb = ncdb.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "24":
					zlj = zlj.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "23":
					jzjz = jzjz.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "25":
					tkrygy = tkrygy.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "26":
					gejhrqsbz = gejhrqsbz.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "27":
					cjrlxbt = cjrlxbt.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "21":
					yljz = yljz.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "22":
					lsjz = lsjz.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "29":
					cjrxsbz = cjrxsbz.add(shjjhbz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				}
			}
		}
		JSONObject shjjhbzObj = new JSONObject();
		shjjhbzObj.put("农村低保", ncdb);
		shjjhbzObj.put("尊老金", zlj);
		shjjhbzObj.put("救灾救助", jzjz);
		shjjhbzObj.put("特困人员供养", tkrygy);
		shjjhbzObj.put("孤儿监护人缺失补助", gejhrqsbz);
		shjjhbzObj.put("残疾人两项补贴", cjrlxbt);
		shjjhbzObj.put("医疗救助", yljz);
		shjjhbzObj.put("临时救助", lsjz);
		shjjhbzObj.put("残疾人学生补助", cjrxsbz);
		czhjzzjObj.put("社会救济和补助", shjjhbzArray);
		czhjzzjObj.put("社会救济和补助合计", shjjhbzObj);
		//政策性生产补贴
		//农业补贴
		BigDecimal nybt = BigDecimal.valueOf(0);
		List<PZjRysjsb> zcxscbtList = jdlkhzhDao.findZcxscbt(param);
		JSONArray zcxscbtArray = new JSONArray();
		if(zcxscbtList.size() > 0){
			for(PZjRysjsb zcxscbt : zcxscbtList){
				JSONObject zcxscbtObj = new JSONObject();
				zcxscbtObj.put("年度", zcxscbt.getNd());
				zcxscbtObj.put("资金名称", zcxscbt.getXmmc());
				zcxscbtObj.put("资金类型", zcxscbt.getZjlx());
				zcxscbtObj.put("金额", zcxscbt.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
				zcxscbtObj.put("拨款时间", zcxscbt.getBkDate());
				zcxscbtObj.put("拨款状态", zcxscbt.getBkzt());
				zcxscbtObj.put("姓名", zcxscbt.getXm());
				zcxscbtObj.put("身份证号", zcxscbt.getSfzh());
				zcxscbtArray.add(zcxscbtObj);
				nybt = nybt.add(zcxscbt.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
			}
		}
		JSONObject zcxscbtObj = new JSONObject();
		zcxscbtObj.put("农业补贴",nybt);
		czhjzzjObj.put("政策性生产补贴", zcxscbtArray);
		czhjzzjObj.put("政策性生产补贴合计", zcxscbtObj);
		//教育资助
		//幼儿园助学金
		BigDecimal yezxj = BigDecimal.valueOf(0);
		//义务教育助学金
		BigDecimal ywjyzxj = BigDecimal.valueOf(0);
		//高中助学金
		BigDecimal gzzxj = BigDecimal.valueOf(0);
		//中职助学金
		BigDecimal zzzxj = BigDecimal.valueOf(0);
		//困难大学生助学金
		BigDecimal nkdxszxj = BigDecimal.valueOf(0);
		List<PZjRysjsb> jyzzList = jdlkhzhDao.findJyzz(param);
		JSONArray jyzzArray = new JSONArray();
		if(jyzzList.size() > 0){
			for(PZjRysjsb jyzz : jyzzList){
				JSONObject jyzzObj = new JSONObject();
				jyzzObj.put("年度", jyzz.getNd());
				jyzzObj.put("资金名称", jyzz.getXmmc());
				jyzzObj.put("资金类型", jyzz.getZjlx());
				jyzzObj.put("金额", jyzz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
				jyzzObj.put("拨款时间", jyzz.getBkDate());
				jyzzObj.put("拨款状态", jyzz.getBkzt());
				jyzzObj.put("姓名", jyzz.getXm());
				jyzzObj.put("身份证号", jyzz.getSfzh());
				jyzzObj.put("户主身份证号", jyzz.getHzsfzh());
				jyzzArray.add(jyzzObj);
				switch(jyzz.getZjType()){
				case "30":
					yezxj = yezxj.add(jyzz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "31":
					ywjyzxj = ywjyzxj.add(jyzz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "32":
					gzzxj = gzzxj.add(jyzz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "33":
					zzzxj = zzzxj.add(jyzz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "34":
					nkdxszxj = nkdxszxj.add(jyzz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				}
			}
		}
		JSONObject jyzzObj = new JSONObject();
		jyzzObj.put("幼儿园助学金", yezxj);
		jyzzObj.put("义务教育助学金", ywjyzxj);
		jyzzObj.put("高中助学金", gzzxj);
		jyzzObj.put("中职助学金", zzzxj);
		jyzzObj.put("困难大学生助学金", nkdxszxj);
		
		czhjzzjObj.put("教育资助", jyzzArray);
		czhjzzjObj.put("教育资助合计", jyzzObj);
		//慈善救助
		//阳光助医
		BigDecimal ygzy = BigDecimal.valueOf(0);
		//儿童大病救助
		BigDecimal etdbjz = BigDecimal.valueOf(0);
		//扶贫助学
		BigDecimal fpzx = BigDecimal.valueOf(0);
		//计生润家
		BigDecimal jsrj = BigDecimal.valueOf(0);
		//关爱青少年
		BigDecimal gaqsn = BigDecimal.valueOf(0);
		//情暖江苏
		BigDecimal qnjs = BigDecimal.valueOf(0);
		//人道万人捐
		BigDecimal rdwrj = BigDecimal.valueOf(0);
		List<PZjRysjsb> csjzList = jdlkhzhDao.findCsjz(param);
		JSONArray csjzArray = new JSONArray();
		if(csjzList.size() > 0){
			for(PZjRysjsb csjz : csjzList){
				JSONObject csjzObj = new JSONObject();
				csjzObj.put("年度", csjz.getNd());
				csjzObj.put("资金名称", csjz.getXmmc());
				csjzObj.put("资金类型", csjz.getZjlx());
				csjzObj.put("金额", csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
				csjzObj.put("拨款时间", csjz.getBkDate());
				csjzObj.put("拨款状态", csjz.getBkzt());
				csjzObj.put("姓名", csjz.getXm());
				csjzObj.put("身份证号", csjz.getSfzh());
				csjzArray.add(csjzObj);
				switch(csjz.getZjlx()){
				case "儿童大病救助":
					etdbjz = etdbjz.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "关爱青少年":
					gaqsn = gaqsn.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "情暖江苏":
					qnjs = qnjs.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "扶贫助学":
					fpzx = fpzx.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "阳光助医":
					ygzy = ygzy.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "计生润家":
					jsrj = jsrj.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				case "人道万人捐":
					rdwrj = rdwrj.add(csjz.getXdje().setScale(2, BigDecimal.ROUND_HALF_UP));
					break;
				}
			}
		}
		JSONObject csjzhjobj = new JSONObject();
		csjzhjobj.put("阳光助医", ygzy);
		csjzhjobj.put("儿童大病救助", etdbjz);
		csjzhjobj.put("扶贫助学", fpzx);
		csjzhjobj.put("计生润家", jsrj);
		csjzhjobj.put("关爱青少年", gaqsn);
		csjzhjobj.put("情暖江苏", qnjs);
		csjzhjobj.put("人道万人捐", rdwrj);
		czhjzzjObj.put("慈善救助", csjzArray);
		czhjzzjObj.put("慈善救助合计", csjzhjobj);
		
		srqkObj.put("财政和捐助资金", czhjzzjObj);		
		result.put("收入信息", srqkObj);	
		return result.toJSONString();
	}
	
	/**
	 * 获取帮扶力量
	 * @param id
	 * @param sfzh
	 * @param nd
	 * @return
	 */
	@Transactional(readOnly = false)
	public String getJdlkhxmss(String id,String sfzh,String nd) {
		JSONObject result = new JSONObject();
		
		//帮扶项目
		List<PkhxmxxInfoVo> xmList = jdlkhzhDao.findBfxmxx(id);
		
		JSONArray bfxmArray = new JSONArray();
		if(xmList.size() > 0){
			for(PkhxmxxInfoVo xm : xmList){
				JSONObject bfxmObj = new JSONObject();
				bfxmObj.put("项目名称", xm.getXxmc());
				bfxmObj.put("项目类别", xm.getXmlx());
				bfxmObj.put("项目地点", xm.getXmdd());
				bfxmObj.put("启动时间", xm.getQdsj());
				bfxmObj.put("项目进展", xm.getXmjz());
				bfxmObj.put("项目阶段性收益", xm.getXmsy());
				bfxmObj.put("项目实施存在困难", xm.getXmsskn());
				bfxmArray.add(bfxmObj);
			}
		}
		result.put("帮扶项目", bfxmArray);
		return result.toJSONString();
	}
	
	/**
	 * 获取脱贫情况
	 * @param id
	 * @param sfzh
	 * @param nd
	 * @return
	 */
	@Transactional(readOnly = false)
	public String getTpqk(String id) {
		JSONObject result = new JSONObject();
		//脱贫信息
		List<TpxxInfoVo> xmList = jdlkhzhDao.findTpxx(id);
		if(null != xmList && xmList.size()>0)
		{
			TpxxInfoVo vo = xmList.get(0);
			//签字确认附件
			if(null != vo.getQzqrfj() && !"".equals(vo.getQzqrfj()))
			{
				vo.setQzqrfjList(getUrls(vo.getQzqrfj()));
			}
			//公示材料
			if(null != vo.getGscl() && !"".equals(vo.getGscl()))
			{
				vo.setGsclList(getUrls(vo.getGscl()));
			}
			result.put("rjsrcj", vo.getRjsrcj());
			result.put("yjqnsr", vo.getYjqnsr());
			result.put("qtsr", vo.getQtsr());
			result.put("gzxsr", vo.getGzxsr());
			result.put("scjyxsr", vo.getScjyxsr());
			result.put("ccxsr", vo.getCcxsr());
			result.put("zyxsr", vo.getZyxsr());
			result.put("zsr", vo.getZsr());
			result.put("rjsj", vo.getRjsj());
			result.put("qzqrfjList", vo.getQzqrfjList());
			result.put("tpnd", vo.getTpnd());
			result.put("gsclList", vo.getGsclList());
			result.put("shr", vo.getShr());
			result.put("shsj", vo.getShsj());
		}
		
		return result.toJSONString();
	}
	
	private List<String> getUrls(String urls){
		List<String> urlList = new ArrayList<String>();
		if(null !=urls && urls.length()>1)
		{
			String[] list = urls.substring(1, urls.length()).split("\\|");
			for (String string : list) {
				string = "http://"+ Global.DEFAULT_IP+Global.DEFAULT_PORT+string;
				urlList.add(string);
			}
		}
		return urlList;
	}
	
	
	/**
	 * 获取脱贫情况jsonArray尝试
	 * @param id
	 * @param sfzh
	 * @param nd
	 * @return
	 */
	@Transactional(readOnly = false)
	public String getTpqkxx(String id) {
		JSONObject result2 = new JSONObject(); //2017
		JSONArray jsonArray = new JSONArray();
		TpxxInfoVo tpxx = jdlkhzhDao.getJdlkAcid(id);
		//2017脱贫信息
		TpxxInfoVo tpxx0= jdlkhzhDao.getJdlkTpxx(tpxx.getHbh());
		if(tpxx0!=null){
		  if(null !=tpxx0.getId() && !"".equals(tpxx0.getId())){
		   TpxxInfoVo tpxx1= jdlkhzhDao.getJdlkCjsr(tpxx0.getNd(),tpxx0.getHbh());
		   if(tpxx1 !=null){
			   result2.put("rjsrcj", tpxx1.getRjsrcj());
			   result2.put("yjqnsr", tpxx1.getYjqnsr());
		   }
		  }
		}
			if(tpxx0 != null)
			{
					//签字确认附件
					if(null != tpxx0.getQzqrfj() && !"".equals(tpxx0.getQzqrfj()))
					{
						tpxx0.setQzqrfjList(getUrls(tpxx0.getQzqrfj()));
					}
					//公示材料
					if(null != tpxx0.getGscl() && !"".equals(tpxx0.getGscl()))
					{
						tpxx0.setGsclList(getUrls(tpxx0.getGscl()));
					}
					if(tpxx0 != null){
						result2.put("qtsr", tpxx0.getQtsr());
						result2.put("gzxsr", tpxx0.getGzxsr());
						result2.put("scjyxsr", tpxx0.getScjyxsr());
						result2.put("ccxsr", tpxx0.getCcxsr());
						result2.put("zyxsr", tpxx0.getZyxsr());
						result2.put("zsr", tpxx0.getZsr());
						result2.put("rjsj", tpxx0.getRjsj());
						result2.put("qzqrfjList", tpxx0.getQzqrfjList());
						result2.put("tpnd", tpxx0.getTpnd());
						result2.put("gsclList", tpxx0.getGsclList());
						result2.put("shr", tpxx0.getShr());
						result2.put("shsj", tpxx0.getShsj());
						result2.put("nd", tpxx0.getTpnd());
						jsonArray.add(result2);
					}
			}
		System.out.println(jsonArray.toString());
		return jsonArray.toJSONString();
	}
	
	
	/**
	 * 获取APP采集的收入构成
	 * @return
	 */
	public String getSrgc(String acid,String createDate){
		JSONObject srgcObj = new JSONObject();
		PkhDetailInfoVo param = new PkhDetailInfoVo();
		param.setPkhbh(acid);
		param.setCreateDate(createDate);
		PkhDetailInfoVo vo = dao.findPkhxx(param);
		//获取务工收入信息
		List<PkhwgsrInfoVo> wgxx = dao.findWgsrxx(param);
		
		//帮扶人信息
		JSONObject bfrObj = new JSONObject();
		bfrObj.put("帮扶人姓名", vo.getBfzrrxm());
		bfrObj.put("帮扶人单位", vo.getBfdw());
		bfrObj.put("帮扶人职务", vo.getZw());
		bfrObj.put("帮扶人联系方式", vo.getBfrlxfs());
		srgcObj.put("帮扶人详请", bfrObj);
		
		//经营性收入
		JSONObject jyxsrObj = new JSONObject();
		jyxsrObj.put("统筹带动增收项目收益", vo.getDdzsxmsyfp());
		jyxsrObj.put("村集体经济项目收益（省定、市定）", vo.getCjtjjxmsyfp());
		jyxsrObj.put("直接到户项目补助", vo.getZjdhxmsy());
		jyxsrObj.put("种植业收入", vo.getSdsr().add(vo.getXmsr()).add(vo.getYmsr()).add(vo.getQtzzsr()));
		jyxsrObj.put("养殖业收入", vo.getJsr().add(vo.getZsr()).add(vo.getYsr()).add(vo.getQtyzsr()));
//		jyxsrObj.put("其它收入", vo.getQtyzsr());
		jyxsrObj.put("其它收入", vo.getYzqtsr()); //
		srgcObj.put("经营性收入", jyxsrObj);
		
		//工资性收入
		JSONArray gzxsrArray = new JSONArray();
		if(wgxx.size() > 0){
			for(PkhwgsrInfoVo wgsr : wgxx){
				JSONObject gzxsrObj = new JSONObject();
				gzxsrObj.put("家庭成员姓名", wgsr.getXm());
				gzxsrObj.put("工种", wgsr.getGz());
				gzxsrObj.put("工作单位", wgsr.getGzdw());
				gzxsrObj.put("今年以来收入", wgsr.getJnylsr());
				gzxsrArray.add(gzxsrObj);
			}
		}
		srgcObj.put("工资性收入", gzxsrArray);
		srgcObj.put("工资性其他收入", vo.getQtar());
		//财产性收入
		JSONObject ccxsrObj = new JSONObject();
		ccxsrObj.put("利息收入", vo.getLxsr());
		ccxsrObj.put("红利收入", vo.getHlsr());
		ccxsrObj.put("资产出租收入", vo.getZcczsr());
		ccxsrObj.put("流转承包土地经营权租金收入", vo.getLzcbtdjyqzjsr());
		ccxsrObj.put("土地流转面积", vo.getTdlzmj());
		ccxsrObj.put("其它财产性收入", vo.getQtccxsr());
		srgcObj.put("财产性收入", ccxsrObj);
		//转移性收入
		JSONObject zyxsrObj = new JSONObject();
		zyxsrObj.put("社会救济和补助", vo.getShjjhbz());
		zyxsrObj.put("政策性生产补贴", vo.getZcxscbt());
		zyxsrObj.put("政策性生活补贴", vo.getZcxshbt());
		zyxsrObj.put("教育资助", vo.getJyzz());
		zyxsrObj.put("慈善救助", vo.getCsjz());
		zyxsrObj.put("慰问金", vo.getBfwwj());
		zyxsrObj.put("养老金", vo.getYlj());
		zyxsrObj.put("赡养费", vo.getSyf());
		zyxsrObj.put("其他", vo.getQt());
		srgcObj.put("转移性收入", zyxsrObj);
		//其他
		JSONObject qtObj = new JSONObject();
		qtObj.put("其他", vo.getQtsr());
		srgcObj.put("其他", qtObj);
		return srgcObj.toJSONString();
	}
}