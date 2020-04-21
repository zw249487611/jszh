<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>正在实施产业项目情况管理</title>
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
		<form:form id="inputForm" modelAttribute="tZzsscyxmqk" action="${ctx}/bfll/tZzsscyxmqk/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   		<tr>
					<td class="width-15 active"><label class="pull-right">县区</label></td>
					<td class="width-35">
						<form:input path="xq" htmlEscape="false" value="${tZzsscyxmqk.xq }"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">乡镇</label></td>
					<td class="width-35">
						<form:input path="xz" htmlEscape="false" value="${tZzsscyxmqk.xz }" class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">村：</label></td>
					<td class="width-35">
						<form:input path="adid" htmlEscape="false" value="${tZzsscyxmqk.cj }"   class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">项目名称：</label></td>
					<td class="width-35">
						<form:input path="xmmc" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目地点：</label></td>
					<td class="width-35">
						<form:input path="xmdd" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">项目实施单位：</label></td>
					<td class="width-35">
						<form:input path="xmssdw" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">项目主要内容：</label></td>
					<td class="width-35">
						<form:textarea path="xmzynr" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">目前实施进度：</label></td>
					<td class="width-35">
						<form:input path="mqssjd" htmlEscape="false"    class="form-control "/>
					</td>
					
				</tr>
				<tr>
				<td class="width-15 active"><label class="pull-right">省级及以上资金：</label></td>
					<td class="width-35">
						<form:input path="shengjys" htmlEscape="false"    class="form-control "/>
					</td>
				<!-- 
					<td class="width-15 active"><label class="pull-right">资金来源(万元)-省级：</label></td>
					<td class="width-35">
						<form:input path="shengj" htmlEscape="false"    class="form-control "/>
					</td>
					 -->
					<td class="width-15 active"><label class="pull-right">市级资金：</label></td>
					<td class="width-35">
						<form:input path="shij" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">县级及以下资金：</label></td>
					<td class="width-35">
						<form:input path="xianjyx" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">自筹资金：</label></td>
					<td class="width-35">
						<form:input path="zic" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>