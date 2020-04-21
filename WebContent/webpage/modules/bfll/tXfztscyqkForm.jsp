<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2018年计划新发展特色产业情况管理</title>
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
		<form:form id="inputForm" modelAttribute="tXfztscyqk" action="${ctx}/bfll/tXfztscyqk/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		  	<tr>
					<td class="width-15 active"><label class="pull-right">县区</label></td>
					<td class="width-35">
						<form:input path="xq" htmlEscape="false" value="${tXfztscyqk.xq }"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">乡镇</label></td>
					<td class="width-35">
						<form:input path="xz" htmlEscape="false" value="${tXfztscyqk.xz }" class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">村：</label></td>
					<td class="width-35">
						<form:input path="adid" htmlEscape="false" value="${tXfztscyqk.cj }" class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">特色产业类别：</label></td>
					<td class="width-35">
						<form:input path="tscylb" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">特色产业名称：</label></td>
					<td class="width-35">
						<form:input path="tscymc" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">拟实施地点：</label></td>
					<td class="width-35">
						<form:input path="nssdd" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">拟实施主体：</label></td>
					<td class="width-35">
						<form:input path="nsszt" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">发展目标及预期扶贫成效：</label></td>
					<td class="width-35">
						<form:textarea path="fzmbjyqfpcx" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">生产要素：</label></td>
					<td class="width-35">
						<form:textarea path="scys" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">政策措施：</label></td>
					<td class="width-35">
						<form:textarea path="zccs" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">资金扶持：</label></td>
					<td class="width-35">
						<form:textarea path="zjfc" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">其他：</label></td>
					<td class="width-35">
						<form:input path="qt" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
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