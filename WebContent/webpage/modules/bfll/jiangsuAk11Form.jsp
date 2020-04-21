<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶责任人管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  var phone=$("#aar012").val();
			  var id=$("#id").val();
			  var url = "${ctx}/bfll/jiangsuAk11/checkPhone";
			  var result = $.ajax({
		   		        type: "post",
		   		        url: url,
		   		      	data: {phone:phone,id:id},
		   		        cache: false,
		   		        async : false,
		   		        dataType: "json",
		   		        success: function (data)
		   		        {
		   		        },
		   		        error:function (XMLHttpRequest, textStatus, errorThrown) {      
		   		            alert("请求失败！");
		   		        }
		   		     }).responseText;
			 var j=JSON.parse(result);
			/*  var checkPhone=data.body.checkPhone; */
			   /*  if(j.body.checkPhone==3){
				    alert("该帮扶责任人已经结对,无法修改,请解出结对后再修改!")
	   		 	 	return false;
	        	} */
	        	if(j.body.checkPhone==2){
	        		$("#inputForm").submit();
	        		return true;
	        	}
	        	if(j.body.checkPhone==1){
	        		alert("手机号码已存在！")
	   		 	 	return false;
	        	}
			 return eval(result).body.checkPhone;
		  }
		}
		$(document).ready(function() {
			
			/* laydate({
	            elem: '#aab005', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	            format: 'YYYY-MM-DD',
	            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	        }); */
			validateForm = $("#inputForm").validate({
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
			});
	        var isnpc=$("#isnpc").val();
	        if(isnpc=="20"){
	        	$("#npch2").show();
				$("#npctable").show();
	        	}
	        else{
				$("#npch2").hide();
				$("#npctable").hide();
			}
	        initAreaSelect();
	        
		});
		
		/* function getUnitInfo(){
			var unitId=$("#apid").val();
			var url = "${ctx}/bfll/jiangsuAk11/getUnitInfo";
			 $.ajax({
	   		        type: "post",
	   		        url: url,
	   		      	data: {unitId:unitId},
	   		        cache: false,
	   		        async : false,
	   		        dataType: "json",
	   		        success: function (data)
	   		        {
	   		           var jiangsuAp11=data.body.jiangsuAp11;
	   		           $("#aap001").val(jiangsuAp11.aap001);
	   		           $("#aar013").val(jiangsuAp11.aar013);
	   		        },
	   		        error:function (XMLHttpRequest, textStatus, errorThrown) {      
	   		            alert("请求失败！");
	   		        }
	   		     });
		} */
		function initAreaSelect() {
			if ($(".xqSelect").eq(0).find("option").size() == 1) {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {
					aaa113 : '320800000000'
				}, function(data) {
					if (data.success) {
						$(".xqSelect").each(function() {
							$(this).find("option:gt(0)").remove();
							var $xqselect = $(this);
							$.each(data.body.data, function(i, item) {
								alert(item.aar009);
								$xqselect.append($("<option/>").val(item.aar001).text(item.aar009));
							});

							var value = $xqselect.attr("actvalue");
							if ("" != value) {
								$xqselect.val(value);
								$xqselect.trigger("change");
							}

						})

					} else {

					}
				});
			}
		}
		function npcChange(value) {
			if(value=="20"){
				$("#npch2").show();
				$("#npctable").show();
			}else{
				$("#npch2").hide();
				$("#npctable").hide();
				
			}
		}
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="jiangsuAk11" action="${ctx}/bfll/jiangsuAk11/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		        <tr>
					<td class="width-15 active"><label class="pull-right">帮扶单位类型：</label></td>
					<td class="width-35">
					    <select name="aap051" class="form-control ">
							<option value="国家机关" <c:if test="${jiangsuAk11.aap051=='国家机关'}">selected="selected"</c:if>>国家机关</option>
							<option value="社会团体" <c:if test="${jiangsuAk11.aap051=='社会团体'}">selected="selected"</c:if>>社会团体</option>
							<option value="高等院校" <c:if test="${jiangsuAk11.aap051=='高等院校'}">selected="selected"</c:if>>高等院校</option>
							<option value="国有企业" <c:if test="${jiangsuAk11.aap051=='国有企业'}">selected="selected"</c:if>>国有企业</option>
							<option value="东部对口帮扶省市" <c:if test="${jiangsuAk11.aap051=='东部对口帮扶省市'}">selected="selected"</c:if>>东部对口帮扶省市</option>
							<option value="定点机构" <c:if test="${jiangsuAk11.aap051=='定点机构'}">selected="selected"</c:if>>定点机构</option>
							<option value="村民自治组织" <c:if test="${jiangsuAk11.aap051=='村民自治组织'}">selected="selected"</c:if>>村民自治组织</option>
						</select>
					</td>
					<td class="width-15 active"><label class="pull-right">隶属关系：</label></td>
					<td class="width-35">
						<select id="aap004" name="aap004" class="form-control ">
							<option value="中央" <c:if test="${jiangsuAk11.aap004=='中央'}">selected="selected"</c:if>>中央</option>
							<option value="省" <c:if test="${jiangsuAk11.aap004=='省'}">selected="selected"</c:if>>省</option>
							<option value="市、地区" <c:if test="${jiangsuAk11.aap004=='市、地区'}">selected="selected"</c:if>>市、地区</option>
							<option value="区" <c:if test="${jiangsuAk11.aap004=='区'}">selected="selected"</c:if>>区</option>
							<option value="县" <c:if test="${jiangsuAk11.aap004=='县'}">selected="selected"</c:if>>县</option>
							<option value="街道" <c:if test="${jiangsuAk11.aap004=='街道'}">selected="selected"</c:if>>街道</option>
							<option value="镇" <c:if test="${jiangsuAk11.aap004=='镇'}">selected="selected"</c:if>>镇</option>
							<option value="乡" <c:if test="${jiangsuAk11.aap004=='乡'}">selected="selected"</c:if>>乡</option>
							<option value="居民委员会" <c:if test="${jiangsuAk11.aap004=='居民委员会'}">selected="selected"</c:if>>居民委员会</option>
							<option value="村民委员会" <c:if test="${jiangsuAk11.aap004=='村民委员会'}">selected="selected"</c:if>>村民委员会</option>
							<option value="军队" <c:if test="${jiangsuAk11.aap004=='军队'}">selected="selected"</c:if>>军队</option>
							<option value="其他" <c:if test="${jiangsuAk11.aap004=='其他'}">selected="selected"</c:if>>其他</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">帮扶单位：</label></td>
					<td class="width-35">
							<sys:gridselect  url="${ctx}/bfll/jiangsuAk11/selectdw" id="apid" name="apid" value="${jiangsuAk11.apid}"  title="选择单位名称" labelName="jiangsuAk11.aap001" labelValue="${jiangsuAk11.aap001}" 
								cssClass="form-control" fieldLabels="单位名称|帮扶单位类型" fieldKeys="aap001|aap051" searchLabel="单位名称" searchKey="aap001"></sys:gridselect>
						<!--<form:input path="aap001" htmlEscape="false"    class="form-control "/>  -->
						
						<%-- <select id="apid" name="apid" class="form-control ">
						<option value="">请选择单位</option>
							<c:forEach items="${jiangsuAp11s }" var="jiangsuAp11">
								<option value="${jiangsuAp11.id }" <c:if test="${jiangsuAp11.id==jiangsuAk11.apid }">selected="selected"</c:if> >${jiangsuAp11.aap001 }</option>
							</c:forEach>
							
						</select> --%>
					</td>
					<td class="width-15 active"><label class="pull-right">姓名：</label></td>
					<td class="width-35">
						<form:input path="aab002" htmlEscape="false"    class="form-control required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">是否第一书记：</label></td>
					<td class="width-35">
						<%-- <form:input path="aak032" htmlEscape="false"    class="form-control "/> --%>
						<!-- <select name="aak032" class="form-control ">
							<option value="0">否</option>
							<option value="1">是</option>
						</select> -->
						<form:select path="aak032" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('firstsecretarymark')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">是否工作队队长：</label></td>
					<td class="width-35">
						<%-- <form:input path="aak031" htmlEscape="false"    class="form-control "/> --%>
					<!-- 	<select name="aak031" class="form-control ">
							<option value="0">否</option>
							<option value="1">是</option>
						</select> -->
						<form:select path="aak031" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('captainmark')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">是否驻村队员：</label></td>
					<td class="width-35">
						<%-- <form:input path="aak039" htmlEscape="false"    class="form-control "/> --%>
						<!-- <select name="aak039" class="form-control ">
							<option value="0">否</option>
							<option value="1">是</option>
						</select> -->
						<form:select path="aak039" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('whethervillagemembers')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">性别：</label></td>
					<td class="width-35">
						<%-- <form:input path="aab003" htmlEscape="false"    class="form-control "/> --%>
						<!-- <select name="aab003" class="form-control ">
							<option value="1">男</option>
							<option value="2">女</option>
						</select> -->
						<form:select path="aab003" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">证件号码：</label></td>
					<td class="width-35">
						<form:input path="aab004" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">联系电话：</label></td>
					<td class="width-35">
						<form:input path="aar012" htmlEscape="false"    class="form-control required"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">是否结对：</label></td>
					<td class="width-35">
						<form:input path="sfjd" htmlEscape="false" readonly="true" class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">结对户数：</label></td>
					<td class="width-35">
						<form:input path="jdhs" htmlEscape="false" readonly="true" class="form-control"/>
					</td>
				</tr>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">单位地址：</label></td>
					<td class="width-35">
						<form:input path="aar013" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">单位名称：</label></td>
					<td class="width-35">
						<form:input path="aap001" htmlEscape="false"    class="form-control "/>
					</td>
				</tr> --%>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">隶属关系：</label></td>
					<td class="width-35">
						<form:input path="aap004" htmlEscape="false"    class="form-control "/>
						<!-- <select id="aap004" name="aap004" class="form-control ">
							<option value="10">中央</option>
							<option value="20">省</option>
							<option value="40">市、地区</option>
							<option value="50">县（区）</option>
							<option value="51">区</option>
							<option value="52">县</option>
							<option value="60">街道、镇、乡</option>
							<option value="61">街道</option>
						</select> -->
						<form:select path="aap004" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('lsgx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">出生日期：</label></td>
					<td class="width-35">
						<form:input path="aab005" htmlEscape="false"    class="form-control "/>
						<input id="aab005" name="aab005" type="text" maxlength="20" class="laydate-icon form-control layer-date input-sm required"
value="<fmt:formatDate value="${jiangsuAk11.aab005}" pattern="yyyy-MM-dd"/>"/>
					</td>
				</tr> --%>
				<tr>
					<td class="width-15 active"><label class="pull-right">职务级别：</label></td>
					<td class="width-35">
						<%-- <form:input path="aaf031" htmlEscape="false"    class="form-control "/> --%>
						<!-- <select id="aaf031" name="aaf031" class="form-control ">
							<option value="101">国家级正职</option>
							<option value="102">国家级副职</option>
							<option value="111"></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
						</select> -->
						<form:select path="aaf031" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('joblevel')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<%-- <td class="width-15 active"><label class="pull-right">学历：</label></td>
					<td class="width-35">
						<form:input path="aak036" htmlEscape="false"    class="form-control "/>
						<form:select path="aak036" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('educational')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td> --%>
					
					<td class="width-15 active"><label class="pull-right">是否人大代表：</label></td>
					<td class="width-35">
					<form:select path="isnpc" class="form-control " onchange="npcChange(this.value)" id="isnpc">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('ISNPC')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
						<%-- <form:input path="aak036" htmlEscape="false"    class="form-control "/> --%>
						<%-- <form:select path="aak036" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('educational')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select> --%>
					</td>
				</tr>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">技术特长：</label></td>
					<td class="width-35">
						<form:input path="aak037" htmlEscape="false"    class="form-control "/>
						<form:select path="aak037" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('expertise')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr> --%>
		 	</tbody>
		</table>
		  
		<hr />
		<h2 align = "center" id="npch2">人大代表信息</h2>
		<table id="npctable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		<tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">代表类型：</label></td>
					<td class="width-35">
						<form:select path="npctype" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('NPC_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">所属县区</label></td>
					<td class="width-35"><select id="xqSelect" name="xq"
						class="form-control required"
						actvalue="${jiangsuAk11.xq}">
							<option value="">--请选择--</option>
							<c:if test="${not empty xqList }">
							<c:forEach items="${xqList }" var="xq">
								<option value="${xq.aar001 }" ${jiangsuAk11.xq eq xq.aar001 ? "selected='selected'" : "" }>${xq.aar009 }</option>
							</c:forEach>
						</c:if>
					</select></td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">所在代表团：</label></td>
					<td class="width-35">
						<form:input path="delegation" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">所在单位及职务：</label></td>
					<td class="width-35">
						<form:input path="unitandduty" htmlEscape="false"    class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">微信号：</label></td>
					<td class="width-35">
						<form:input path="wechat" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">企业名称：</label></td>
					<td class="width-35">
						<form:input path="enterprisename" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">所属行业：</label></td>
					<td class="width-35">
						<form:input path="industryowned" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主要产品：</label></td>
					<td class="width-35">
						<form:input path="mainproduct" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">2016年产值（万元）：</label></td>
					<td class="width-35">
						<form:input path="output" htmlEscape="false"    class="form-control number "/>
					</td>
					<td class="width-15 active"><label class="pull-right">企业现有职工（人）：</label></td>
					<td class="width-35">
						<form:input path="existingstaff" htmlEscape="false"    class="form-control number "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">企业性质：</label></td>
					<td class="width-35">
						<form:select path="nature" class="form-control">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('NATURE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">2016年缴纳税收（万元）：</label></td>
					<td class="width-35">
						<form:input path="tax" htmlEscape="false" class="form-control number " />
					</td>
					
				</tr>
		</tbody>
		</table>
	</form:form>
</body>
</html>