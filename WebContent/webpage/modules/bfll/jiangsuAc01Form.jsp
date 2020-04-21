<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>贫困户基本信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	var validateForm;
	function doSubmit() {//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		if ($("#inputForm").valid()) {
			
			var b = new Array();//与户主关系
			var liveState = [];//生存状态
			$("#targetTbody tr").each(function(loop) {
				if (loop % 4 == 0) {
				$(this).find("td").each(function(index) {
					if (index == 2) {
						b.push($(this).find('select option:selected').val());
					}
				});
				}
				if(loop%4==1){
					$(this).find("td").each(function(index) {
						if(index == 5){
							liveState.push($(this).find('select option:selected').val());
						}
					});
				}
			});
			
			var hzgx = b;
            var hzgx_num = 0;
            for (var i = 0; i < hzgx.length; i++) {
				if (hzgx[i] == "01" && (liveState[i]==1 || liveState[i]==4)) {
					hzgx_num++;
				}
			}
            
          	//判断是否都不属于正常用户
            var allAbnormal = true;
            for(var i = 0;i<liveState.length;i++){
            		if(liveState[i] == 1 || liveState[i] == 4){
            			allAbnormal = false;
            			break;
            		}
            }
            if (hzgx_num == 0 && !allAbnormal) {
            	alert("家庭成员必须有且只有一个户主");
            	return false;
            }
            
            if (hzgx_num > 1) {
            	alert("家庭成员必须有且只有一个户主");
            	return false;
            }

			var a = new Array();
			$("#jqsbaTable tr").each(function() {
				$(this).find("td").each(function(index) {
					if (index == 4) {
						a.push($(this).find('input').val());
					}
				});
			});

			var vals = [];
			$("input[name='olderaab004']").each(function(index, item) {
				vals.push($(this).val());
			});
			//console.log(a);
			var na = a.sort();
			//console.log(na);
			for (var i = 0; i < na.length - 1; i++) {
				if (na[i] == na[i + 1]) {
					alert("身份证号码重复：" + na[i])
					return false;
				}
			}

			var d = new Array();
			$("#targetTbody tr").each(function(loop) {
				if (loop % 4 == 2) {
					$(this).find("td").each(function(index) {
						if (index == 1) {
							d.push($(this).find('input').val());
						}
					});
				}
			});
			var b = d.join(",");
			var nd = "${newJiangsuAc01.aar040}";
			if(nd == ''){
				nd = $("#aar040").val();
			}
			if (checkCardNum(b, vals,nd)) {
				$("#inputForm").submit();
				return true;
			} else {
				return false;
			}
		}
	}
	function checkCardNum(b, vals,nd) {
		var flag = false;
		$.ajax({
			type : "get",
			url : '${ctx}/bfll/newJiangsuAb01/checkNumber',
			data : {
				numbers : b,
				oldNumbers : vals,
				nd:nd
			},
			cache : false,
			async : false,
			dataType : "json",
			traditional : true,
			success : function(data) {
				console.log(data);
				var a = data.body.number;
				if (a == '') {
					flag = true;
				} else {
					alert("身份证号重复:" + a);
					flag = false;
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("请求失败！");
			}
		});
		return flag;
	}

	$(document).ready(function() {
		/* validateForm = $("#inputForm").validate({				
			submitHandler: function(form){
				loading('正在提交，请稍等...');
				form.submit();
			},
			errorContainer: "#messageBox",
			errorPlacement: function(error, element) {
				$("#messageBox").text("输入有误，请先更正。");
				if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
					error.appendTo(element.parent().parent());
				} else {
					error.insertAfter(element);
				}
			}
		}); */


		$("#add_column_btn").on("click", function() {
			// 增加表行
			/* var trCount = $("#jqsbaTable tr[id]").length; */
			var trCount = $('#targetTbody').children().length / 2;
			var $tr = $("#jqsbaTable tr[id]:eq(0)").clone();
			$tr.find("label.error").remove();// 移除错误提示的label
			
			var $trCopy0 = $('tbody#targetTbody tr#0').clone();
			
			var $trCopy1 = $("tr#demo0.accordian-body.collapse").clone();
			
			$trCopy0.find("input").each(function(i) {
				if ($(this).attr("name")) {
					var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + trCount + "]$2");
					$(this).attr("name", newName).val("");
					$(this).attr("id", newName);
				}
			});
			$trCopy0.find("select").each(function(i) {
				var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + trCount + "]$2");
				$(this).attr("name", newName).val("");
				$(this).attr("id", newName);
			});
			
			$trCopy0.find("[data-toggle='collapse']").attr("data-target","#demo"+trCount)
			
			$trCopy0.find("[data-value='0']").attr("data-value",trCount);
			$trCopy0.attr("id", trCount);
			
			$trCopy1.find("input").each(function(i) {
				if ($(this).attr("name")) {
					var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + trCount + "]$2");
					$(this).attr("name", newName).val("");
					$(this).attr("id", newName);
				}
			});
			$trCopy1.find("select").each(function(i) {
				var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + trCount + "]$2");
				$(this).attr("name", newName).val("");
				$(this).attr("id", newName);
			}); 
			$trCopy1.attr("id", "demo"+trCount);
			
			$('#targetTbody').append($trCopy0).append($trCopy1)
			
			
		});

	});

	/* 删除添加时贫困人口的某一行 */
	function delRow(that) {
		var indexRow = $(that).attr('data-value');
		var trCount = $('#targetTbody').children().length / 2;
		if (trCount == 1) return;
		$('#'+indexRow).remove()
		$('#demo'+indexRow).remove()
		
		for(var index = Number(indexRow); index < trCount; index++) {
			$('#'+(index+1)).find("input").each(function(i) {
				if ($(this).attr("name")) {
					var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + index + "]$2");
					$(this).attr("name", newName)
					$(this).attr("id", newName);
				}
			});
			$('#'+(index+1)).find("select").each(function(i) {
				var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + index + "]$2");
				$(this).attr("name", newName)
				$(this).attr("id", newName);
			});
			
			$('#'+(index+1)).find("[data-toggle='collapse']").attr("data-target","#demo"+index);
			$('#'+(index+1)).find("[data-value='"+(index+1)+"']").attr("data-value",index);
			$('#'+(index+1)).attr("id", index);
			
			$('#demo'+(index+1)).find("input").each(function(i) {
				if ($(this).attr("name")) {
					var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + index + "]$2");
					$(this).attr("name", newName)
					$(this).attr("id", newName);
				}
			});
			$('#demo'+(index+1)).find("select").each(function(i) {
				var newName = $(this).attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + index + "]$2");
				$(this).attr("name", newName)
				$(this).attr("id", newName);
			}); 
			$('#demo'+(index+1)).attr("id", "demo"+index);
		}
		
	}
	
	function initLayDate() {
		$('.birthday').each(function() {

			laydate({
				elem : '#' + $(this).attr('id'), //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
				format : 'YYYY-MM-DD',
				event : 'focus' //响应事件。如果没有传入event，则按照默认的click
			});
		})
	}

	function delTr(obj) {
		$(obj).parent().parent().remove();
		var trCount = $("#jqsbaTable tbody tr").length;
		for (var i = 0; i < trCount; i++) {
			$("#jqsbaTable tbody tr").eq(i+1).find("td").each(function() {
				var obj = $(this).find("input");
				if (obj.length != 0) {
					if (obj.attr("name")) {
						var newName = obj.attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + i + "]$2");
						obj.attr("name", newName);
					}

				}
				obj = $(this).find("select");
				if (obj.length != 0) {
					var newName = obj.attr("name").replace(/(\w)\[\d\](.*)/, "$1[" + i + "]$2");
					obj.attr("name", newName);
				}
			});
		}
	}
</script>
</head>
<body class="hideScroll">

	<form:form style="overflow-x:hidden" id="inputForm" modelAttribute="newJiangsuAc01"
		action="${ctx}/bfll/newJiangsuAc01/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<h3>贫困户基本信息</h3>
		<table
			class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			<tbody>
				<div id="areaSelectDiv" class="form-group">
				<tr>
					<td class="width-15 active"><label class="pull-right">分区年度：</label></td>
					<td class="width-35">
						<form:select path="aar040" class="form-control">
							<form:options items="${yearMap}" />
						</form:select>
					</td>
					<td class="width-15 active">
						<label class="pull-right">县区：</label>
						<form:hidden path="currentAreaId" />
					</td>
					<td class="width-35">
						<select id="4_area" name="4_area" class="form-control areaCascadeSelect"></select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active">
						<label class="pull-right">乡镇：</label>
					</td>
					<td class="width-35">
						<select id="5_area" name="5_area" class="form-control areaCascadeSelect" ></select>
					</td>
					<td class="width-15 active">
						<label class="pull-right">村：</label>
					</td>
					<td class="width-35">
						<select id="6_area" name="6_area" class="form-control areaCascadeSelect" ></select>
								
					</td>
				</tr>
				</div>
				<tr>
					<td class="width-15 active"><label class="pull-right">是否加入农民专业合作社：</label></td>
					<td class="width-35">
						<form:select path="aac084" class="form-control">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">联系电话：</label></td>
					<td class="width-35"><form:input path="aar012"
							htmlEscape="false" maxlength="11"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							class="form-control " /></td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">开户银行：</label></td>
					<td class="width-35"><form:input path="aaq002"
							htmlEscape="false" maxlength="100" class="form-control " /></td>
					<td class="width-15 active"><label class="pull-right">银行账号：</label></td>
					<td class="width-35"><form:input path="aac004"
							htmlEscape="false" maxlength="30"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							class="form-control " /></td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">识别标准：</label></td>
					<td class="width-35"><form:select path="aac005"
							class="form-control ">
							<form:option value="" label="" />
							<form:options items="${fns:getDictList('sbbz')}"
								itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select></td>
					<td class="width-15 active"><label class="pull-right">贫困户属性：</label></td>
					<td class="width-35"><form:select path="aac006"
							class="form-control ">
							<form:option value="" label="" />
							<form:options items="${fns:getDictList('pkhsx')}"
								itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select></td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">主要致贫原因：</label></td>
					<td class="width-35"><form:select path="aac007"
							class="form-control ">
							<form:option value="" label="" />
							<form:options items="${fns:getDictList('zyzpyy')}"
								itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select></td>
					<td class="width-15 active"><label class="pull-right">其他致贫原因：</label></td>
					<td class="width-35">
						<form:checkboxes path="qtzpyy" items="${fns:getDictList('qtzpyy')}" itemLabel="label" itemValue="value" htmlEscape="false" cssClass="i-checks required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">致贫原因描述：</label></td>
					<td class="width-35"><form:input path="aac011"
							htmlEscape="false" maxlength="100" class="form-control " /></td>
					<%-- <td class="width-15 active"><label class="pull-right">有效标志：</label></td>
					<td class="width-35"><select name="aar100"
						class="form-control">
							<option value="0"
								<c:if test="${newJiangsuAc01.aar100=='0' }">selected="selected"</c:if>>无效</option>
							<option value="1"
								<c:if test="${newJiangsuAc01.aar100=='1' }">selected="selected"</c:if>>有效</option>
					</select></td> --%>
					<td class="width-15 active"><label class="pull-right">脱贫标志：</label></td>
					<td class="width-35">
						<form:select path="aar010" class="form-control ">
							<form:option value="" label="" />
							<form:options items="${fns:getDictList('tpbz')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					<%-- <select name="aar010"
						class="form-control">
							<option value="0"
								<c:if test="${newJiangsuAc01.aar010=='0' }">selected="selected"</c:if>>未脱贫</option>
							<option value="1"
								<c:if test="${newJiangsuAc01.aar010=='1' }">selected="selected"</c:if>>已脱贫</option>
							<option value="2"
								<c:if test="${newJiangsuAc01.aar010=='2' }">selected="selected"</c:if>>预脱贫</option>
							<option value="3"
								<c:if test="${newJiangsuAc01.aar010=='3' }">selected="selected"</c:if>>返贫</option>
					</select> --%>
					</td>
				</tr>
				<tr>
					<td class="width-15 active">
						<label class="pull-right">是否支出性贫困：</label>
					</td>
					<td class="width-35">
						<form:select path="sfzcxpk" class="form-control">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">支出性贫困原因：</label></td>
					<td class="width-35"><form:input path="zcxpkyy"
							htmlEscape="false" maxlength="100" class="form-control " /></td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">是否军烈属：</label></td>
					<td class="width-35">
						<form:select path="aac012" class="form-control">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">是否独生子女户：</label></td>
					<td class="width-35">
						<form:select path="aac013" class="form-control">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">是否双女户：</label></td>
					<td class="width-35">
						<form:select path="aac014" class="form-control">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">户籍编码：</label></td>
					<td class="width-35"><form:input path="hjbm"
							htmlEscape="false" maxlength="100" class="form-control " />
					</td>
				</tr>

				<tr>
					<td class="width-15 active"><label class="pull-right">备注：</label></td>
					<td class="width-35"><textarea name="aar059" maxlength="250"
							cols="20" rows="3" style="width:100%">${newJiangsuAc01.aar059 }</textarea></td>
					<td class="width-15 active"></td>
					<td class="width-35"></td>
				</tr>
				
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">是否双女户：</label></td>
					<td class="width-35">
						<form:select path="aac014" class="form-control">
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false" />
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">户主姓名：</label></td>
					<td class="width-35"><form:input path="hzxm"
							htmlEscape="false" maxlength="100" class="form-control required" />
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">户主身份证号：</label></td>
					<td class="width-35"><form:input path="hzsfzh"
							htmlEscape="false" maxlength="20" class="form-control required " />
					</td>
					<td class="width-15 active"><label class="pull-right">家庭人口数：</label></td>
					<td class="width-35"><form:input path="jtrks"
							htmlEscape="false" maxlength="100"
							class="form-control required number " /></td>
				</tr>

				<tr>
					<td class="width-15 active"><label class="pull-right">户籍编码：</label></td>
					<td class="width-35"><form:input path="hjbm"
							htmlEscape="false" maxlength="100" class="form-control " />
					</td>
					<td class="width-15 active"><label class="pull-right">备注：</label></td>
					<td class="width-35"><textarea name="aar059" maxlength="250"
							cols="20" rows="3" style="width:100%">${newJiangsuAc01.aar059 }</textarea></td>
				</tr> --%>
			</tbody>
		</table>
		<br>
		<br>
		<br>
		<h3>贫困人口基本信息</h3>
		<c:if test="${empty isHiden}">
			<div class="row">
				<div class="col-sm-12">
					<div class="pull-left">
						<button id="add_column_btn" title="添加"
							class="btn btn-white btn-sm" type="button" data-placement="left">
							<i class="fa fa-plus"></i> 添加
						</button>
					</div>
				</div>
			</div>
		</c:if>
		
		<table class="table table-condensed" style="border-collapse:collapse;">
		    <thead>
		        <tr>
		            <!-- <th>分区年度</th> -->
		            <th>姓名</th>
		            <th>性别</th>
		            <th>与户主关系</th>
		            <!-- <th>民族</th>
		            <th>婚姻状况</th>
		            <th>政治面貌</th> -->
					<th>操作</th>
		        </tr>
		    </thead>
		
		    <tbody id="targetTbody">
		    	<c:if test="${not empty newJiangsuAb01s }">
					<c:forEach items="${newJiangsuAb01s }" var="newJiangsuAb01"
						varStatus="statu">
						<tr  id="${statu.index}" style="cursor: move;">
							<input type="hidden" name="olderaab004" value="${newJiangsuAb01.aab004 }" >
				        	<!-- 年度 -->
							<input name="newJiangsuAb01s[${statu.index}].id"
									   value="${newJiangsuAb01.id }" 
									   type="hidden"> 
							<%-- <td>
								<select name="newJiangsuAb01s[${statu.index}].aar040"
										class="form-control "
										placeholder="年度">
										<c:forEach items="${yearMap}" var="year">
											<option value="${year.key}"
												<c:if test="${newJiangsuAb01.aar040==year.key}">selected="selected"</c:if>>${year.value}</option>
										</c:forEach>
								</select> 
							</td>--%>
							<!-- 姓名 -->
				            <td>
								<input name="newJiangsuAb01s[${statu.index}].aab002"
									   maxlength="50" 
									   class="form-control required"
									   value="${newJiangsuAb01.aab002 }"
									   type="text"
									   placeholder="姓名" />
							</td>
							<!-- 性别 -->
				            <td>
				            	<select name="newJiangsuAb01s[${statu.index}].aab003"
										class="form-control ">
										<c:forEach items="${fns:getDictList('sex')}" var="sex">
											<option value="${sex.value }"
												<c:if test="${newJiangsuAb01.aab003==sex.value }">selected="selected"</c:if>>${sex.label }</option>
										</c:forEach>
								</select>
				            </td>
				            <!-- 与户主关系 -->
				            <td>
				            	<select name="newJiangsuAb01s[${statu.index}].aab006"
										class="form-control "
										placeholder="与户主关系">
										<c:forEach items="${fns:getDictList('yhzgx')}" var="yhzgx">
											<option value="${yhzgx.value }"
												<c:if test="${newJiangsuAb01.aab006==yhzgx.value }">selected="selected"</c:if>>${yhzgx.label }</option>
										</c:forEach>
								</select>
				            </td>
				            <!-- 民族 -->
				           <%--  <td>
				            	<select name="newJiangsuAb01s[${statu.index}].aab007"
										class="form-control "
										placeholder="民族">
										<c:forEach items="${fns:getDictList('nation_dict')}"
											var="nation">
											<option value="${nation.value }"
												<c:if test="${newJiangsuAb01.aab007==nation.value }">selected="selected"</c:if>>${nation.label }</option>
										</c:forEach>
								</select>
				            </td> --%>
				            <!-- 婚姻状况 -->
				            <%-- <td>
				            	<select name="newJiangsuAb01s[${statu.index}].aab021"
									    class="form-control "
									    placeholder="婚姻状况">
										<c:forEach items="${fns:getDictList('hyzk')}" var="hyzk">
											<option value="${hyzk.value }"
												<c:if test="${newJiangsuAb01.aab021==hyzk.value }">selected="selected"</c:if>>${hyzk.label }</option>
										</c:forEach>
								</select>
				            </td> --%>
							<!-- 政治面貌 -->
							<%-- <td>
								<select name="newJiangsuAb01s[${statu.index}].aak033"
										class="form-control "
										placeholder="政治面貌">
										<c:forEach items="${fns:getDictList('zzmm')}" var="zzmm">
											<option value="${zzmm.value }"
												<c:if test="${newJiangsuAb01.aak033==zzmm.value }">selected="selected"</c:if>>${zzmm.label }</option>
										</c:forEach>
								</select>
							</td> --%>
							<td>
								<span data-toggle="collapse" data-target="#demo${statu.index}" class="btn btn-info btn-xs accordion-toggle">详情查看及修改</span>
								<span class="btn btn-warning btn-xs" data-value="${statu.index}"  onclick="delRow(this)">删除</span>
							</td>
				        </tr>
				        <tr class="accordian-body collapse" id="demo${statu.index}">
							
							<th colspan="8">
								<table class="table table-condensed" >
									<tbody>
										<tr>
											<th>证件类型</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab018"
														class="form-control ">
														<c:forEach items="${fns:getDictList('zjlx')}" var="zjlx">
															<option value="${zjlx.value }"
																<c:if test="${newJiangsuAb01.aab018==zjlx.value }">selected="selected"</c:if>>${zjlx.label }</option>
														</c:forEach>
												</select>
											</td>
											<th>证件号码 </th>
											<td colspan="3">
												<input name="newJiangsuAb01s[${statu.index}].aab004"
														maxlength="25" 
														class="form-control required"
														value="${newJiangsuAb01.aab004 }" 
														type="text" />
											</td>	
											<th>文化程度</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab008"
														class="form-control ">
														<c:forEach items="${fns:getDictList('whcd')}" var="whcd">
															<option value="${whcd.value }"
																<c:if test="${newJiangsuAb01.aab008==whcd.value }">selected="selected"</c:if>>${whcd.label }</option>
														</c:forEach>
												</select>
											</td>
											<th>在校生状况</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab009"
														class="form-control ">
														<c:forEach items="${fns:getDictList('zxszk')}" var="zxszk">
															<option value="${zxszk.value }"
																<c:if test="${newJiangsuAb01.aab009==zxszk.value }">selected="selected"</c:if>>${zxszk.label }</option>
														</c:forEach>
												</select>
											</td>
												
										</tr>
										<tr>					
											<th>劳动技能</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab010"
														class="form-control ">
														<c:forEach items="${fns:getDictList('ldjn')}" var="ldjn">
															<option value="${ldjn.value }"
																<c:if test="${newJiangsuAb01.aab010==ldjn.value }">selected="selected"</c:if>>${ldjn.label }</option>
														</c:forEach>
												</select>
											</td>
											<th>生存状态</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab015"
														class="form-control ">
														<c:forEach items="${fns:getDictList('sczt')}" var="sczt">
															<option value="${sczt.value }"
																<c:if test="${newJiangsuAb01.aab015==sczt.value }">selected="selected"</c:if>>${sczt.label }</option>
														</c:forEach>
												</select>
											</td>
	
											<th>健康状况</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab017"
														class="form-control ">
														<c:forEach items="${fns:getDictList('jkzk')}" var="jkzk">
															<option value="${jkzk.value }"
																<c:if test="${newJiangsuAb01.aab017==jkzk.value }">selected="selected"</c:if>>${jkzk.label }</option>
														</c:forEach>
												</select>
											</td>
											<th>是否享受低保</th>
											<td>
												<select name="newJiangsuAb01s[${statu.index}].aab030"
														class="form-control ">
														<c:forEach items="${fns:getDictList('yes_no')}" var="yesNo">
															<option value="${yesNo.value }"
																<c:if test="${newJiangsuAb01.aab030==yesNo.value }">selected="selected"</c:if>>${yesNo.label }</option>
														</c:forEach>
												</select>
											</td>
											<th>联系电话</th>
											<td>
												<input name="newJiangsuAb01s[${statu.index}].aab031"
													   value="${newJiangsuAb01.aab031 }" class="form-control "
													   onkeyup="this.value=this.value.replace(/\D/g,'')"
													   onafterpaste="this.value=this.value.replace(/\D/g,'')"
													   type="text" />
											</td>
										</tr>
									</tbody>
								</table>
							</th>	
						</tr>
						
					</c:forEach>
				</c:if>

				<c:if test="${ empty newJiangsuAb01s }">
					<tr id="0">
			        	<!-- 年度 -->
						<%-- <td>
							<select name="newJiangsuAb01s[0].aar040"
									class="form-control required"
									placeholder="年度">
									<c:forEach items="${yearMap}" var="year">
										<option value="${year.key}">${year.value}</option>
									</c:forEach>
								</select>
						</td> --%>
						<!-- 姓名 -->
			            <td>
							<input name="newJiangsuAb01s[0].aab002"
								   maxlength="50"
								   class="form-control required" 
								   type="text"
								   placeholder="姓名" />
						</td>
						<!-- 性别 -->
			            <td>
			            	<select name="newJiangsuAb01s[0].aab003"
									class="form-control required"
									placeholder="性别">
									<c:forEach items="${fns:getDictList('sex')}" var="sex">
										<option value="${sex.value }">${sex.label }</option>
									</c:forEach>
							</select>
			            </td>
			            <!-- 与户主关系 -->
			            <td>
			            	<select name="newJiangsuAb01s[0].aab006"
									class="form-control required"
									placeholder="与户主关系">
									<c:forEach items="${fns:getDictList('yhzgx')}" var="yhzgx">
										<option value="${yhzgx.value }">${yhzgx.label }</option>
									</c:forEach>
		
							</select>
			            </td>
			            <!-- 民族 -->
			            <td>
			            	<select name="newJiangsuAb01s[0].aab007"
									class="form-control required"
									placeholder="民族">
									<c:forEach items="${fns:getDictList('nation_dict')}"
										var="nation">
										<option value="${nation.value }">${nation.label }</option>
									</c:forEach>
							</select>
			            </td>
			            <!-- 婚姻状况 -->
			            <td>
			            	<select name="newJiangsuAb01s[0].aab021"
									class="form-control "
									placeholder="婚姻状况">
									<c:forEach items="${fns:getDictList('hyzk')}" var="hyzk">
										<option value="${hyzk.value }">${hyzk.label }</option>
									</c:forEach>
							</select>
			            </td>
			            
			            <td>
							<select name="newJiangsuAb01s[0].aak033"
									class="form-control required"
									placeholder="政治面貌">
									<c:forEach items="${fns:getDictList('zzmm')}" var="zzmm">
										<option value="${zzmm.value }">${zzmm.label }</option>
									</c:forEach>
							</select>
			            
						</td>
						<td>
							<span data-toggle="collapse" data-target="#demo0" class="btn btn-info btn-xs accordion-toggle">详情查看及修改</span>
							<span class="btn btn-warning btn-xs" data-value='0' onclick="delRow(this)">删除</span>
						</td>
			        </tr>
			        
			        
			        <tr class="accordian-body collapse" id="demo0" >
						
						<th colspan="8">
							<table class="table table-condensed" >
								<tbody>
									<tr>
										<th>证件类型</th>
										<td>
											<select name="newJiangsuAb01s[0].aab018"
													class="form-control required">
													<c:forEach items="${fns:getDictList('zjlx')}" var="zjlx">
														<option value="${zjlx.value }">${zjlx.label }</option>
													</c:forEach>
											</select>
										</td>
										<th>证件号码 </th>
										<td colspan="3">
											<input name="newJiangsuAb01s[0].aab004" maxlength="25"
												   class="form-control required" type="text" />
										</td>		

										<th>文化程度</th>
										<td>
											<select name="newJiangsuAb01s[0].aab008"
													class="form-control required">
													<c:forEach items="${fns:getDictList('whcd')}" var="whcd">
														<option value="${whcd.value }">${whcd.label }</option>
													</c:forEach>
											</select>
										</td>
										<th>在校生状况</th>
										<td>
											<select name="newJiangsuAb01s[0].aab009"
													class="form-control required">
													<c:forEach items="${fns:getDictList('zxszk')}" var="zxszk">
														<option value="${zxszk.value }">${zxszk.label }</option>
													</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th>劳动技能</th>
										<td>
											<select name="newJiangsuAb01s[0].aab010"
													class="form-control required">
													<c:forEach items="${fns:getDictList('ldjn')}" var="ldjn">
														<option value="${ldjn.value }">${ldjn.label }</option>
													</c:forEach>
											</select>
										</td>
									
										<th>生存状态</th>
										<td>
											<select name="newJiangsuAb01s[0].aab015"
													class="form-control ">
													<c:forEach items="${fns:getDictList('sczt')}" var="sczt">
														<option value="${sczt.value }" >${sczt.label }</option>
													</c:forEach>
											</select>
										</td>
										<th>健康状况</th>
										<td>
											<select name="newJiangsuAb01s[0].aab017"
												    class="form-control required">
													<c:forEach items="${fns:getDictList('jkzk')}" var="jkzk">
														<option value="${jkzk.value }">${jkzk.label }</option>
													</c:forEach>
											</select>
										</td>
										<th>是否享受低保</th>
										<td>
											<select name="newJiangsuAb01s[0].aab030"
													class="form-control required">
													<c:forEach items="${fns:getDictList('yes_no')}" var="yesNo">
														<option value="${yesNo.value }">${yesNo.label }</option>
													</c:forEach>
											</select>
										</td>
										<th>联系电话</th>
										<td>
											<input name="newJiangsuAb01s[0].aab031"
												   class="form-control "
												   onkeyup="this.value=this.value.replace(/\D/g,'')"
												   onafterpaste="this.value=this.value.replace(/\D/g,'')"
												   type="text" />
										</td>
									</tr>
								</tbody>
							</table>
						</th>	
					</tr>
			        
				</c:if>
					
					
			 
		    </tbody>
		    
		</table>
		
		
		<!-- 新增时所需的靠背的部分  -->
		<div hidden id="trCopy">
			<table>
				<tbody>
	       		</tbody>
			</table>
			<table>
				<tbody>
				</tbody>
			</table>
		</div>
		
		
		
		
		
		
		<h3>贫困户收入信息</h3>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   		<%-- <tr>
					<td class="width-15 active"><label class="pull-right">家庭年收入：</label></td>
					<td class="width-35">
						<form:input path="jiangsuAc07.aac081" htmlEscape="false"    class="form-control "/>
						<input name="newJiangsuAc07.aac081" id="jiangsuAc07.aac081" maxlength="16" value="${newJiangsuAc07.aac081 }" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					<td class="width-15 active"><label class="pull-right">人均收入：</label></td>
					<td class="width-35">
						<form:input path="jiangsuAc07.aac082" htmlEscape="false"    class="form-control "/>
						<input name="newJiangsuAc07.aac082" id="jiangsuAc07.aac082" maxlength="16" value="${newJiangsuAc07.aac082 }" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
				</tr> --%>
				<c:if test="${empty hasBfr }">
				<tr hidden>
					<td class="width-35">
						<input name="newJiangsuAc07.id" id="jiangsuAc07.id" type ="hidden" value="${newJiangsuAc07.id}" class="form-control " >
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">生产经营性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac071" id="jiangsuAc07.aac071" maxlength="16" value="${newJiangsuAc07.aac071 }" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					<td class="width-15 active"><label class="pull-right">工资性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac082" id="jiangsuAc07.aac082" maxlength="16" value="${newJiangsuAc07.aac082 }" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">财产性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac084" id="jiangsuAc07.aac084" maxlength="16" value="${newJiangsuAc07.aac084}" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					<td class="width-15 active"><label class="pull-right">转移性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac090" id="jiangsuAc07.aac090" maxlength="16" value="${newJiangsuAc07.aac090	 }" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其他收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac099" id="jiangsuAc07.aac99" maxlength="16" value="${newJiangsuAc07.aac099 }" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
				</tr>
				</c:if>
				<c:if test="${not empty hasBfr }">
				<tr hidden>
					<td class="width-35">
						<input name="newJiangsuAc07.id" id="jiangsuAc07.id" type ="hidden" value="${newJiangsuAc07.id}" class="form-control " >
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">生产经营性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac071" id="jiangsuAc07.aac071" maxlength="16" value="${newJiangsuAc07.aac071 }" disabled="disabled" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					<td class="width-15 active"><label class="pull-right">工资性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac082" id="jiangsuAc07.aac082" maxlength="16" value="${newJiangsuAc07.aac082 }" disabled="disabled" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">财产性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac084" id="jiangsuAc07.aac084" maxlength="16" value="${newJiangsuAc07.aac084}" disabled="disabled" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					<td class="width-15 active"><label class="pull-right">转移性收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac090" id="jiangsuAc07.aac090" maxlength="16" value="${newJiangsuAc07.aac090	 }" disabled="disabled" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其他收入：</label></td>
					<td class="width-35">
						<input name="newJiangsuAc07.aac099" id="jiangsuAc07.aac99" maxlength="16" value="${newJiangsuAc07.aac099 }" disabled="disabled" class="form-control " onkeyup="value=value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
					</td>
				</tr>
				</c:if>
			</tbody>
		</table>
		<h3>变更原因</h3>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		  <tr>
		   <td class="width-15 active"><label class="pull-right">备注：</label></td>
					<td class="width-35"><textarea name="bgyy" maxlength="250"
							cols="20" rows="3" class="form-control required" style="width:100%">${newJiangsuAc01.bgyy}</textarea></td>
		   </tr>
			</tbody>
		</table>			
		
	</form:form>
</body>
</html>