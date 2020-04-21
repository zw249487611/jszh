package com.jeeplus.modules.project.entity;

import java.util.List;

/**
 * 各种常数定义
 * 
 * @author Petter
 *
 */
public class Const{
	//淮安市本级ID
	public static final String XQ_SbjId = "ead2fd82424b4f33b423c56a631dc468";
	//淮安市本级Code
	public static final String XQ_SbjCode="320800000000";
	//淮安区ID
	public static final String XQ_HaqId = "320803000000";
	//淮阴区ID
	public static final String XQ_HyqId = "320804000000";
	//清浦区ID
	public static final String XQ_QpqId = "320811000000";
	//涟水县ID
	public static final String XQ_LsxId = "320826000000";
	//洪泽区ID
	public static final String XQ_HzqId = "320829000000";
	//盱眙县ID
	public static final String XQ_XyxId = "320830000000";
	//金湖县ID
	public static final String XQ_JhxId = "320831000000";
	//县区id数组(包含市本级)
	public static final String[] XqIdList = {"ead2fd82424b4f33b423c56a631dc468","320803000000","320804000000","320811000000","320826000000","320829000000","320830000000","320831000000"};
	//县区id数组(不包含市本级)
	public static final String[] Area_Xq= {"320803000000","320804000000","320811000000","320826000000","320829000000","320830000000","320831000000"};
	//扶贫办资金类型数组
	public static final String[] Fpb_Types = {"3","4","5","6","7","8","9","55"}; 
	//扶贫办资金类型周报数组
	public static final String[] Fpb_ZbTypes = {"3","4","5","6","6a","6b"};
	
	public static final String[] ssjgIdList = {"sfpb","mzj","cl","jyj","nw","cszh","hszh","zjj"}; 
	//资金类型-农委产业扶贫
	public static final String Cyfp_Type = "6c";
	//资金类型-危房改造
	public static final String Wfgz_Type = "44";
	public static final String Xq = "4";
	public static final String Xz = "5";
	public static final String Cun = "6";
	
	// 【党建扶贫】版块
	public static final String DJFP = "2";
	// 【党建扶贫】版块：【典型经验】子版块
	public static final String DJFP_DXJY = "1";
	// 【党建扶贫】版块：【先锋人物】子版块
	public static final String DJFP_XFRW = "2";
	// 【党建扶贫】版块：【示范项目】子版块
	public static final String DJFP_SFXM = "3";
	
	//是否脱贫标志-未脱贫
	public static final String TPBZ_0 = "0";
	
	//是否脱贫标志-已脱贫
	public static final String TPBZ_1 = "1";
	
	//是否脱贫标志-预脱贫
	public static final String TPBZ_2 = "2";
	
	//是否脱贫标志-未返贫
	public static final String TPBZ_3 = "3";
	
	//建档立卡户变更表变更类型(1:精准识别；2:基本信息修改；3:精准脱贫;4:新增贫困户;5:修改贫困户;6:删除贫困户;7:新增家庭成员;8:修改家庭成员;9:删除家庭成员;10:修改是否支出性贫困;11:修改支出性贫困原因;12:恢复误删除的贫困户)
	public static final String JdLKHBGLX_1 = "1";
	public static final String JdLKHBGLX_2 = "2";
	public static final String JdLKHBGLX_3 = "3";
	public static final String JdLKHBGLX_4 = "4";
	public static final String JdLKHBGLX_5 = "5";
	public static final String JdLKHBGLX_6 = "6";
	public static final String JdLKHBGLX_7 = "7";
	public static final String JdLKHBGLX_8 = "8";
	public static final String JdLKHBGLX_9 = "9";
	public static final String JdLKHBGLX_10 = "10";
	public static final String JdLKHBGLX_11 = "11";
	public static final String JdLKHBGLX_12 = "12";
	
	//app走访预警类型(1.基本信息异常 ；2项目收益异常 3，财政收入异常)
	public static final String APP_ZFYJ_1 = "1";
	public static final String APP_ZFYJ_2 = "2";
	public static final String APP_ZFYJ_3 = "3";
	
	//app走访预警状态(预警状态（0:待办发起，1:预警发起,2:督办，3:已处理）)
	public static final String APP_YJZT_0 = "0";
	public static final String APP_YJZT_1 = "1";
	public static final String APP_YJZT_2 = "2";
	public static final String APP_YJZT_3 = "3";
	
	//社会帮扶---省委帮扶工作队
	public static final String SHBF_SWBFGZD = "省委帮扶工作队";
	//社会帮扶---市委帮扶工作队
	public static final String SHBF_SHIWBFGZD = "市委帮扶工作队";
	//社会帮扶---省委帮扶工作队
	public static final String SHBF_SWBFGZD_TYPE = "41";
	//社会帮扶---市委帮扶工作队
	public static final String SHBF_SHIWBFGZD_TYPE = "42";
	//社会帮扶---项目状态(启动)
	public static final String SHBF_STATUS_1 = "1";
	//社会帮扶---项目状态(验收)
	public static final String SHBF_STATUS_2 = "2";
	//社会帮扶---项目状态(托管)
	public static final String SHBF_STATUS_3 = "3";
	
	public static final String XMSS_TYPE_1 = "1";
	public static final String XMSS_TYPE_2 = "2";
	public static final String SJSB_TYPE_1 = "5";
	public static final String SJSB_TYPE_2 = "6";
	
	//两不愁三保障预警类型(20 失学辍学 ；21 应保未保监督 22 危房全改造监督 23-教育资助监督 24-两不愁预警处置)
	public static final String LBCSBZ_SXCX_20 = "20";
	public static final String LBCSBZ_YBWB_21 = "21";
	public static final String LBCSBZ_WFQGZ_22 = "22";
	public static final String LBCSBZ_WFQGZ_23 = "23";
	public static final String LBCSBZ_YJCZ_24 = "24";

	
	//两不愁三保障预警状态(预警状态（0:待办发起，1:预警发起,2:督办，3:已处理）)
	public static final String LBCSBZ_YJZT_0 = "0";
	public static final String LBCSBZ_YJZT_1 = "1";
	public static final String LBCSBZ_YJZT_2 = "2";
	public static final String LBCSBZ_YJZT_3 = "3";
	
	
	//阳光扶贫江苏银行-贷款申请
	//前置机 上传路径
	public static final String REMOTE_PATH_UPLOAD = "/app/fuping/ygtojsb/";
	//前置机 下载路径
	public static final String REMOTE_PATH_DOWNLOAD = "/app/fuping/jsbtoyg/";
	//本地 上传路径
	public static final String LOCAL_PATH_UPLOAD = "/usr/local/apache-tomcat-8.0.29/webapps/upload/";
	//本地 下载路径
	public static final String LOCAL_PATH_DOWNLOAD = "/usr/local/apache-tomcat-8.0.29/webapps/download/";
	/*//本地 上传路径
	public static final String LOCAL_PATH_UPLOAD = "upload\\";
	//本地 下载路径
	public static final String LOCAL_PATH_DOWNLOAD = "download\\";*/
}
