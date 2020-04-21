<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>贫困村走访收入修改管理</title>
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
		<form:form id="inputForm" modelAttribute="jiangsuAd30" action="${ctx}/bfll/jiangsuAd30/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">年度：</label></td>
					<td class="width-35">
						<form:input path="aar040" htmlEscape="false"  readonly="true"  class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">季度：</label></td>
					<td class="width-35">
						<form:input path="aar041" htmlEscape="false"   readonly="true"   class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">县区：</label></td>
					<td class="width-35">
						<form:input path="xqName" htmlEscape="false"  readonly="true"  class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">乡镇：</label></td>
					<td class="width-35">
						<form:input path="xzName" htmlEscape="false"   readonly="true"   class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">村：</label></td>
					<td class="width-35">
						<form:input path="cjName" htmlEscape="false"  readonly="true"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">直接经营性收入：</label></td>
					<td class="width-35">
						<form:input path="aad304" htmlEscape="false"   class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">上缴及发包收入：</label></td>
					<td class="width-35">
						<form:input path="aad305" htmlEscape="false"   class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">投资收益：</label></td>
					<td class="width-35">
						<form:input path="aad306" htmlEscape="false"   class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">其他收入：</label></td>
					<td class="width-35">
						<form:input path="aad307" htmlEscape="false"   class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">总计：</label></td>
					<td class="width-35">
						<form:input path="aad311" htmlEscape="false"   class="form-control "/>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>