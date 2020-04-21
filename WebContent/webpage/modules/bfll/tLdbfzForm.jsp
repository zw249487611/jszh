<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况管理</title>
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
		<form:form id="inputForm" modelAttribute="tLdbfz" action="${ctx}/bfll/tLdbfz/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">村(作为外键)：</label></td>
					<td class="width-35">
						<form:input path="adid" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">市县乡联动组组成人员：</label></td>
					<td class="width-35">
						<form:input path="zcry" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">市县乡联动组参与产业扶贫情况：</label></td>
					<td class="width-35">
						<form:textarea path="cycyfpqk" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">乡镇扶贫专干、村扶贫书记（主任）人员情况：</label></td>
					<td class="width-35">
						<form:input path="fpryqk" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">乡镇扶贫专干、村扶贫书记（主任）参与产业扶贫情况：</label></td>
					<td class="width-35">
						<form:textarea path="zgcyfpqk" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">村民服务中心面积：</label></td>
					<td class="width-35">
						<form:input path="cmfwzxmj" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">村民服务中心具备功能：</label></td>
					<td class="width-35">
						<form:textarea path="cmfwzxjbgn" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">村民服务中心使用情况：</label></td>
					<td class="width-35">
						<form:input path="cmfwzxsyqk" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right"> 备注：</label></td>
					<td class="width-35">
						<form:input path="bz" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>