<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>待改造危房户详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
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
			
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="jiangsuAc01" action="${ctx}/bfll/jiangsuAc01/saveWf" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div id="areaSelectDiv">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   <form:hidden path="currentAreaId" />
		  	<tr>
					<td class="width-15 active"><label class="pull-right">县区：</label></td>
					<td class="width-15">
						<select id="4_area" name="4_area"  readonly="true" class="form-control areaCascadeSelect" >
						</select>
					</td>
					<td class="width-15 active"><label class="pull-right">乡镇：</label></td>
					<td class="width-15">
						<select id="5_area" name="5_area" readonly="true" class="form-control areaCascadeSelect" >
						</select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">村居：</label></td>
					<td class="width-15">
						<select id="6_area" name="6_area" readonly="true" class="form-control areaCascadeSelect" >
						</select>
					</td>
					<td class="width-15 active"><label class="pull-right">户主姓名：</label></td>
					<td class="width-35">
						<form:input path="hzxm" htmlEscape="false"  readonly="true"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">户主身份证号：</label></td>
					<td class="width-35">
						<form:input path="hzsfzh" htmlEscape="false"  readonly="true"  class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">危险性等级：</label></td>
					<td class="width-35">
						<form:input path="wxdj" htmlEscape="false"  readonly="true"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">改造状态：</label></td>
					<td class="width-35">
						<form:select path="zt" readonly="true" class="form-control m-b">
						<form:option value="" label="---请选择---"/>
						<form:option value="0" label="未改造"/>
						<form:option value="1" label="改造中"/>
						<form:option value="2" label="已改造"/>
						<form:option value="3" label="无需改造"/>
					</form:select>
					<td class="width-15 active"><label class="pull-right">备注信息 : </label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>