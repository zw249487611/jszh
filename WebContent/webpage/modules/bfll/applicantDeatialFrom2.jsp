
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>录入信息管理</title>
<meta name="decorator" content="default" />

<style type="text/css">
.tableEdit {
	border-top: 1px solid #EEE;
	width: 100%;
	padding: 0;
	margin: 0;
	margin-bottom: 10px;
}

.fonSiz {
	font-size: 12px;
	font-weight: bold;
}

tr {
	border-left: 1px solid #EEE;
}

td {
	border-right: 1px solid #EEE;
	border-bottom: 1px solid #EEE;
	background: #fff;
	font-size: 14px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

.input-xlarge {
	width: 96%;
	height: 30px;
	border: 1px solid #e3e6f3;
}

.input-jbxx {
	width: 10%;
	height: 28px;
	border: 1px solid #e3e6f3;
	margin-right: 5px;
}

.col-red {
	padding-top: 20px;
	color: red;
}

.jtcy-th {
	border: 0px;
}

.jtcy-th th {
	padding: 5px;
	text-align: center;
	border-left: 1px solid #e3e6f3;
	border-right: 1px solid #e3e6f3;
	border-bottom: 1px solid #e3e6f3;
}
</style>
<script type="text/javascript">
	var index = 0;
	var index2 = 0;

	
	$(document).ready(
			function() {
				initRelocateDifficultyValue();
				initCausationOtherValueValue();
				//initWarnValue();
				//$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										//loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
										} else {
											error.insertAfter(element);
										}
									}
								});
				initGroup();
			});

	
	function initRelocateDifficultyValue() {
		var value = $("#relocateDifficultyValue").val();
		if ("" == value)
			return;

		var vals = value.split(",");
		for (var i = vals.length - 1; i >= 0; i--) {
			$("input[name='relocateDifficulty'][value ='" + vals[i] + "']")
					.attr("checked", true);
		}
	}

	function initCausationOtherValueValue() {
		var value = $("#causationOtherValue").val();
		if ("" == value)
			return;
		var vals = value.split(",");
		for (var i = vals.length - 1; i >= 0; i--) {
			$("input[name='causationOther'][value ='" + vals[i] + "']").attr(
					"checked", true);
		}
	}
	
	function initWarnValue() {
		var value = $("#warnValue").val();
		if ("" == value)
			return;
		var vals = value.split(",");
		for (var i = vals.length - 1; i >= 0; i--) {
			$("input[name='warnValue'][value ='" + vals[i] + "']").attr(
					"checked", true);
		}
	}

</script>
</head>
<body>
	<ul class="nav nav-tabs">
	</ul>
	<br />
	<input type="hidden" id="groupValue"
		value="${poorApplyUser.countryName}" />
	<form:form id="inputForm" modelAttribute="poorApplyUser"
		action="${ctx}/poor/poorApplyUser/savecustom" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<form:hidden path="incomeid" />
		<form:hidden path="livingid" />
		<form:hidden path="elsewhereRelocateid" />
		<form:hidden path="warnValue" />
		<input type="hidden" name="userid" value="${userid}">
		<sys:message content="${message}" />
		<table class="tableEdit">
			<tr>
				<td colspan="6" class="fonSiz">基本信息</td>
			</tr>
			<tr>
				<td align="right" width="10%">家庭住址：</td>
				<td><input  htmlEscape="false"
						maxlength="200" class="input-xlarge " readonly="readonly" value=""/></td>
				<td align="right">镇(乡、苏木)：</td>
				<td>${downName}</td>
				<td align="right" width="10%"><span class="col-red">*</span>行政村：</td>
				<td><input type="text" class="input-xlarge" value="${poorApplyUser.countryName }" readonly="readonly"></td><!--  -->
			</tr>
			<tr>
				<td align="right" width="10%"><span class="col-red">*</span>所属组(屯)：</td>
				<td><input type="text" class="input-xlarge" value="${poorApplyUser.countryName }" readonly="readonly"></td>
				<td align="right" width="10%">开户银行：</td>
				<td><input type="text" class="input-xlarge" value="${poorApplyUser.aaq002 }" readonly="readonly"></td>
				<td align="right" width="10%">银行账号：</td>
				<td><input type="text" class="input-xlarge" value="${poorApplyUser.aac004 }" readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right" width="10%">联系电话：</td>
				<td><input type="text" class="input-xlarge" value="${poorApplyUser.aar012 }" readonly="readonly"></td>
				<td align="right">识别标准(单选)：</td>
				<td>国家标准:<input type="radio" name="recognitionStandard" value="0" readonly="readonly" <c:if test="${poorApplyUser.aac005=='0' }">checked="checked"</c:if> >
					省定标准:<input type="radio" name="recognitionStandard" value="1" readonly="readonly" <c:if test="${poorApplyUser.aac005=='1' }">checked="checked"</c:if> >
					市定标准:<input type="radio" name="recognitionStandard" value="2" readonly="readonly" <c:if test="${poorApplyUser.aac005=='2' }">checked="checked"</c:if> >
					
				</td>
				<td align="right">贫困户属性(单选)：</td>
				<td>一般贫困户:<input type="radio" name="poorProperty" value="0" readonly="readonly" <c:if test="${poorApplyUser.aac006==0 }">checked="checked"</c:if> >
					低保贫困户:<input type="radio" name="poorProperty" value="1" readonly="readonly" <c:if test="${poorApplyUser.aac006==1 }">checked="checked"</c:if> >
					五保贫困户:<input type="radio" name="poorProperty" value="2" readonly="readonly" <c:if test="${poorApplyUser.aac006==2 }">checked="checked"</c:if> >
				</td>
			</tr>
			<tr>
				<td align="right">是否军烈属：</td>
				<td>否:<input type="radio" name="martyr" value="0" readonly="readonly" <c:if test="${poorApplyUser.aac012==0 }">checked="checked"</c:if> >
				是:<input type="radio" name="martyr" value="1" readonly="readonly" <c:if test="${poorApplyUser.aac012==1 }">checked="checked"</c:if> >
				</td>
				<!-- <td align="right">采集结果:</td>
				<td colspan="3">
					家庭拥有汽车:<input type="checkbox"  name="warnValue" value="1"/> 
					财政供养人员:<input type="checkbox" name="warnValue" value="0"/> 
					房产超标:<input type="checkbox"   name="warnValue" value="2"/>  
					家庭拥有大型农具:<input type="checkbox" name="warnValue" value="3"/>
					高退休金人员:<input type="checkbox" name="warnValue" value="4"/>	
					已死亡人员:<input type="checkbox" name="warnValue" value="5"/>
					个体户，企业拥有者:<input type="checkbox" name="warnValue" value="6"/>
					公积金贷款人员:<input type="checkbox" name="warnValue" value="7"/>
					自来水使用超标人员:<input type="checkbox" name="warnValue" value="8"/>					
				</td> -->
			</tr>
		</table>

		<table class="tableEdit">
			<tr>
				<td colspan="16" class="fonSiz">家庭成员</td>
			</tr>
			<tr class="jtcy-th">
				<th width="120">家庭成员名称</th>
				<th width="60">性别</th>
				<th width="120">证件号码</th>
				<th width="100">与户主关系</th>
				<th width="100">民族</th>
				<th width="100">政治面貌</th>
				<th width="100">文化程度</th>
				<th width="100">在校生状况</th>
				<th width="100">健康状况</th>
				<th width="100">劳动技能</th>
				<th width="100">务工情况</th>
				<th width="100">务工时间</th>
				<th width="60">是否现役军人</th>
				<th width="80">是否参加重大医疗保险</th>
				<th width="60">是否享受低保</th>
				<th width="120">务工企业名称</th>
			</tr>

			<c:forEach items="${poorHomeMemberList}" var="home">
				<tr>
					<td>${home.aab012 }</td>
					<td>${home.aab003 }</td>
					<td>${home.aab004 }</td>
					<td>${home.aab006 }</td>
					<td>${home.aab007 }</td>
					<td>${home.aak033 }</td>
					<td>${home.aab008 }</td>
					<td>${home.aab009 }</td>
					<td>${home.aab017 }</td>
					<td>${home.aab010 }</td>
					<td>${home.aab029 }</td>
					<td><fmt:formatDate value="${home.aab012 }" pattern="YYYY-MM-DD"/></td>
					<td>${home.aab019 }</td>
					<td></td>
					<td></td>
					<td>${home.aab029 }</td>
				</tr>
			</c:forEach>
		</table>

		<table class="tableEdit">
			<tr>
				<td colspan="4" class="fonSiz">致贫原因</td>
			</tr>
			<tr>
				<td align="right" width="10%">主要致贫原因(单选)：${poorApplyUser.aac007 }</td>
				<td>因病:<input type="radio" readonly="readonly" value="0" name="causationChief" <c:if test="${poorApplyUser.aac007==0 }">checked="checked"</c:if> />
					因残:<input type="radio" readonly="readonly" value="1" name="causationChief" <c:if test="${poorApplyUser.aac007==1 }">checked="checked"</c:if> />
					因学:<input type="radio" readonly="readonly" value="2" name="causationChief" <c:if test="${poorApplyUser.aac007==2 }">checked="checked"</c:if> />
					因灾:<input type="radio" readonly="readonly" value="3" name="causationChief" <c:if test="${poorApplyUser.aac007==3 }">checked="checked"</c:if> />
					缺土地:<input type="radio" readonly="readonly" value="4" name="causationChief" <c:if test="${poorApplyUser.aac007==4 }">checked="checked"</c:if> />
					缺水:<input type="radio" readonly="readonly" value="5" name="causationChief" <c:if test="${poorApplyUser.aac007==5 }">checked="checked"</c:if> />
					缺技术:<input type="radio" readonly="readonly" value="6" name="causationChief" <c:if test="${poorApplyUser.aac007==6 }">checked="checked"</c:if> />
					缺劳动力:<input type="radio" readonly="readonly" value="7" name="causationChief" <c:if test="${poorApplyUser.aac007==7 }">checked="checked"</c:if> />
					缺资金:<input type="radio" readonly="readonly" value="8" name="causationChief" <c:if test="${poorApplyUser.aac007==8 }">checked="checked"</c:if> />
					交通条件落后:<input type="radio" readonly="readonly" value="9" name="causationChief" <c:if test="${poorApplyUser.aac007==9 }">checked="checked"</c:if> />
					自身发展动力不足:<input type="radio" readonly="readonly" value="10" name="causationChief" <c:if test="${poorApplyUser.aac007==10 }">checked="checked"</c:if> />
				</td>
				<td align="right" width="12%">其他致贫原因(最多选两项)：</td>
				<td>
				<input type="hidden"
					value="${poorApplyUser.aac008}"
					id="causationOtherValue"> 
					因病:<input type="checkbox" readonly="readonly" value="0" name="causationOther" <c:if test="${poorApplyUser.aac008==0 }">checked="checked"</c:if> />
					
					因残 :<input type="checkbox" readonly="readonly" value="1" name="causationOther" <c:if test="${poorApplyUser.aac008==1 }">checked="checked"</c:if> />
					因学 :<input type="checkbox" readonly="readonly" value="2" name="causationOther" <c:if test="${poorApplyUser.aac008==2 }">checked="checked"</c:if> />
					因灾 :<input type="checkbox" readonly="readonly" value="3" name="causationOther" <c:if test="${poorApplyUser.aac008==3 }">checked="checked"</c:if> />
					因婚 :<input type="checkbox" readonly="readonly" value="4" name="causationOther" <c:if test="${poorApplyUser.aac008==4 }">checked="checked"</c:if> />
					缺土地:<input type="checkbox" readonly="readonly" value="5" name="causationOther" <c:if test="${poorApplyUser.aac008==5 }">checked="checked"</c:if> />
					缺水 :<input type="checkbox" readonly="readonly" value="6" name="causationOther" <c:if test="${poorApplyUser.aac008==6 }">checked="checked"</c:if> />
					缺技术 :<input type="checkbox" readonly="readonly" value="7" name="causationOther" <c:if test="${poorApplyUser.aac008==7 }">checked="checked"</c:if> />
					缺劳动力:<input type="checkbox" readonly="readonly" value="8" name="causationOther" <c:if test="${poorApplyUser.aac008==8 }">checked="checked"</c:if> />
					缺资金:<input type="checkbox" readonly="readonly" value="9" name="causationOther" <c:if test="${poorApplyUser.aac008==9 }">checked="checked"</c:if> />
					交通条件落后 :<input type="checkbox" readonly="readonly" value="10" name="causationOther" <c:if test="${poorApplyUser.aac008==10 }">checked="checked"</c:if> />
					自身发展动力不足:<input type="checkbox" readonly="readonly" value="11" name="causationOther" <c:if test="${poorApplyUser.aac008==11 }">checked="checked"</c:if> />
				</td>
			</tr>
		</table>
		<table class="tableEdit">
			<tr>
				<td colspan="6" class="fonSiz">收入情况</td>
			</tr>
			<tr>
				<td align="right" width="10%">工资性收入(元)：</td>
				<td><input name="wageIncome" class="input-xlarge " readonly="true" value="${poorApplyUser.aac073 }" /></td>
				<td align="right" width="10%">生产经营性收入(元)：</td>
				<td><input name="operatingIncome" class="input-xlarge " readonly="true" value="${poorApplyUser.aac071 }" /></td>
				<td align="right" width="10%">财产性收入(元)：</td>
				<td><input name="ownershipIncome" class="input-xlarge " readonly="true" value="${poorApplyUser.aac072 }"/></td>
			</tr>
			<tr>
				<td align="right">转移性收入(元)：</td>
				<td><input name="transferIncome" class="input-xlarge " readonly="true" value="${poorApplyUser.aac085 }"/></td>
				<td align="right">计划生育金(元)：</td>
				<td><input name="birthControl" class="input-xlarge " readonly="true" value="${poorApplyUser.aac076 }"/></td>
				<td align="right">低保金(元)：</td>
				<td><input name="lowIncome" class="input-xlarge " readonly="true" value="${poorApplyUser.aac077 }"/></td>
			</tr>
			<tr>
				<td align="right">五保金(元)：</td>
				<td><input name="wubaojin" class="input-xlarge " readonly="true" value="${poorApplyUser.aac086 }"/></td>
				<td align="right">养老保险金(元)：</td>
				<td><input name="pensionInsurance" class="input-xlarge " readonly="true" value="${poorApplyUser.aac087 }"/></td>
				<td align="right">生态补偿金(元)：</td>
				<td><input name="ecologicalCompensation" class="input-xlarge " readonly="true" value="${poorApplyUser.aac078 }"/></td>
			</tr>
			<tr>
				<td align="right">其他转移性收入(元)：</td>
				<td><input name="surplusTransferIncome" class="input-xlarge " readonly="true" value="${poorApplyUser.aac083 }"/></td>
				<td align="right">生产经营性支出(元)：</td>
				<td colspan="3"><input path="operatingPay" class="input-xlarge " value="${poorApplyUser.aac074 }"/></td>
			</tr>
		</table>
		<table class="tableEdit">
			<tr>
				<td colspan="6" class="fonSiz">生产生活条件</td>
			</tr>
			<tr>
				<td align="right" width="10%">耕地面积(亩)：</td>
				<td><form:input path="agriculturalAcreage" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac301 }" /></td>
				<td align="right" width="10%">有效灌溉面积(亩)：</td>
				<td><form:input path="effectiveIrrigationArea"
						htmlEscape="false" maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac302 }" /></td>
				<td align="right" width="10%">林地面积(亩)：</td>
				<td><form:input path="forestryArea" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac303 }" /></td>
			</tr>
			<tr>
				<td align="right">退耕还林面积(亩)：</td>
				<td><form:input path="restoreForestryArea" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.raac304 }" /></td>
				<td align="right">林果面积(亩)：</td>
				<td><form:input path="fruitTreeArea" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac305 }" /></td>
				<td align="right">牧草地面积(亩)：</td>
				<td><form:input path="grasslandArea" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac306 }" /></td>
			</tr>
			<tr>
				<td align="right">水面面积(亩)：</td>
				<td><form:input path="waterArea" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac307 }" /></td>
				<td align="right">是否通生产用电：</td>
				<td>否:<input type="radio" name="produceElectricPower"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.aac308=='0' }">checked="checked"</c:if> /> 
					是:<input type="radio" name="produceElectricPower" htmlEscape="false" maxlength="200"
						value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.aac308=='1' }">checked="checked"</c:if>/>
				</td>
				<td align="right">与村主干路距离(公里)：</td>
				<td><input type="type" name="highwayDistance" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac315 }"/></td>
			</tr>
			<tr>
				<td align="right">入户路类型：</td>
				<td><input type="type" name="highwayType" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac316 }"/></td>
				<td align="right">是否通生活用电：</td>
				<td>否:<input type="radio" name="circularTelegramWhether"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.aac313=='0' }">checked="checked"</c:if>/>
					是:<input type="radio" name="circularTelegramWhether" htmlEscape="false" maxlength="200"
						value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.aac313=='1' }">checked="checked"</c:if>/>
				</td>
				<td align="right">住房面积(平方米)：</td>
				<td><form:input path="floorSpace" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac317 }"/></td>
			</tr>
			<tr>
				<td align="right">饮水是否困难：</td>
				<td>否:<input type="radio" name="drinkingWateDifficulty"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.aac311=='0' }">checked="checked"</c:if>/>
					是:<input type="radio" name="drinkingWateDifficulty" htmlEscape="false" maxlength="200"
						value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.aac311=='1' }">checked="checked"</c:if>/>
				</td>
				<td align="right">饮水是否安全：</td>
				<td>否:<input type="radio" name="drinkingWaterSecurity"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.aac312=='0' }">checked="checked"</c:if>/>
					是:<input type="radio" name="drinkingWaterSecurity" htmlEscape="false" maxlength="200"
						value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.aac312=='1' }">checked="checked"</c:if>/>
				</td>
				<td align="right">主要燃料类型：</td>
				<td><form:input path="chiefFuelType" htmlEscape="false"
						maxlength="100" class="input-xlarge " readonly="true" value="${poorApplyUser.aac320 }"/></td>
			</tr>
			<tr>
				<td align="right">是否加入农民专业合作社：</td>
				<td>否:<input type="radio" name="farmersClubs" htmlEscape="false"
						maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.aac084=='0' }">checked="checked"</c:if>/>
					是:<input type="radio" name="farmersClubs" htmlEscape="false" maxlength="200" value="1"
						lable="test" readonly="true" <c:if test="${poorApplyUser.aac084=='1' }">checked="checked"</c:if>/>
				</td>
				<td align="right">有无卫生厕所：</td>
				<td colspan="3">无:<input type="radio" name="washroom"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.AAC319=='0' }">checked="checked"</c:if>/>
					有:<input type="radio" name="washroom" htmlEscape="false" maxlength="200" value="1"
						lable="test" readonly="true" <c:if test="${poorApplyUser.AAC319=='1' }">checked="checked"</c:if>/>
				</td>
			</tr>
		</table>

		<table class="tableEdit">
			<tr>
				<td colspan="9" class="fonSiz">帮扶状况</td>
			</tr>
			<tr class="jtcy-th">
				<th>姓名</th>
				<th>性别</th>
				<th>政治面貌</th>
				<th>帮扶单位名称</th>
				<th>帮扶开始时间</th>
				<th>帮扶结束时间</th>
				<th>隶属关系</th>
				<th>单位地址</th>
				<th>联系电话</th>
			</tr>
			<c:forEach items="${poorAidIntendantList}" var="ai">
				<tr>
					<td>${ai.aab002}</td>
					<td>${ai.aab03}</td>
					<td>${ai.aak033 }</td>
					<td>${ai.aap001 }</td>
					<td><fmt:formatDate value="${ai.beginTime }" pattern="YYYY-MM-DD"/></td>
					<td><fmt:formatDate value="${ai.endTime }" pattern="YYYY-MM-DD"/></td>
					<td>${ai.aap004 }</td>
					<td>${ai.aar013 }</td>
					<td>${ai.aar012 }</td>
				</tr>
			</c:forEach>
		</table>

		<table class="tableEdit">
			<tr>
				<td colspan="6" class="fonSiz">易地扶贫搬迁</td>
			</tr>
			<tr>
				<td align="right" width="13%">是否搬迁户(单选)：</td>
				<td>否:<input type="radio" name="relocateWhether"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.relocateWhether=='0' }">checked="checked"</c:if>/>
					是:<input type="radio" name="relocateWhether" htmlEscape="false" maxlength="200"
						value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.relocateWhether=='1' }">checked="checked"</c:if>/>
				</td>
				<td align="right" width="13%">搬迁方式(单选)：</td>
				<td>行政区整体搬迁:<input type="radio" name="relocateWay"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.relocateWay=='0' }">checked="checked"</c:if>/>
					自然村（村民小组）整体搬迁:<input type="radio" name path="relocateWay"
						htmlEscape="false" maxlength="200" value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.relocateWay=='1' }">checked="checked"</c:if>/>
					建档立卡贫困户个别搬迁:<input type="radio" name path="relocateWay" htmlEscape="false"
						maxlength="200" value="2" lable="test" readonly="true" <c:if test="${poorApplyUser.relocateWay=='2' }">checked="checked"</c:if>/>
				</td>
				<td align="right" width="13%">安置方式(单选)：</td>
				<td>集中安置:<input type="radio" name="arrangeForWay"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.arrangeForWay=='0' }">checked="checked"</c:if>/>
					分散安置:<input type="radio" name="arrangeForWay" htmlEscape="false"
						maxlength="200" value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.arrangeForWay=='1' }">checked="checked"</c:if>/>
				</td>
			</tr>
			<tr>
				<td align="right">安置地(单选)：</td>
				<td>县城安置:<input type="radio" name="resettlement"
						htmlEscape="false" maxlength="200" value="0" lable="test" readonly="true" <c:if test="${poorApplyUser.resettlement=='0' }">checked="checked"</c:if>/>
					乡镇安置:<input type="radio" name="resettlement" htmlEscape="false"
						maxlength="200" value="1" lable="test" readonly="true" <c:if test="${poorApplyUser.resettlement=='1' }">checked="checked"</c:if>/> 
					村内安置:<input type="radio" name="resettlement" htmlEscape="false" maxlength="200" value="2"
						lable="test" readonly="true" <c:if test="${poorApplyUser.resettlement=='2' }">checked="checked"</c:if>/>
					村外安置:<input type="radio" name="resettlement"
						htmlEscape="false" maxlength="200" value="3" lable="test" readonly="true" <c:if test="${poorApplyUser.resettlement=='3' }">checked="checked"</c:if>/>
					县外安置:<input type="radio" name="resettlement" htmlEscape="false"
						maxlength="200" value="4" lable="test" readonly="true" <c:if test="${poorApplyUser.resettlement=='4' }">checked="checked"</c:if>/>
				</td>
				<td align="right">搬迁可能存在的困难(可多选)：</td>
				<td colspan="3"><input type="hidden"
					value="${poorApplyUser.relocateDifficulty}"
					id="relocateDifficultyValue"> 
						缺乏资金 :<input type="checkbox" name="relocateDifficulty" htmlEscape="false" maxlength="100"
						value="0" readonly="true" <c:if test="${poorApplyUser.relocateDifficulty=='0' }">checked="checked"</c:if>/>
						搬迁后找不到工作:<input type="checkbox" name="relocateDifficulty"
						htmlEscape="false" maxlength="100" value="1" readonly="true" <c:if test="${poorApplyUser.relocateDifficulty=='1' }">checked="checked"</c:if>/>
						搬迁后生活没着落:<input type="checkbox" name="relocateDifficulty" htmlEscape="false" maxlength="100"
						value="2" readonly="true" <c:if test="${poorApplyUser.relocateDifficulty=='2' }">checked="checked"</c:if>/>
						其他:<input type="checkbox" name="relocateDifficulty"
						htmlEscape="false" maxlength="100" value="3" readonly="true" <c:if test="${poorApplyUser.relocateDifficulty=='3' }">checked="checked"</c:if>/>
						</td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>