<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>边缘户管理</title>
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
		<form:form id="inputForm" modelAttribute="byh" action="${ctx}/bfll/byh/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div id="areaSelectDiv">
		
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">户主姓名：</label></td>
					<td class="width-35">
						<form:input path="hzxm" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">身份证号：</label></td>
					<td class="width-35">
						<form:input path="sfzh" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">手机号：</label></td>
					<td class="width-35">
						<form:input path="sjh" htmlEscape="false"    class="form-control " onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</td>
					<td class="width-15 active"><label class="pull-right">年度：</label></td>
					<td class="width-35">
						<select name="nd" class="form-control ">
											<option value="2015" <c:if test="${byh.nd=='2015' }">selected="selected"</c:if>>2015</option>
											<option value="2016" <c:if test="${byh.nd=='2016' }">selected="selected"</c:if>>2016</option>
											<option value="2017" <c:if test="${byh.nd=='2017' }">selected="selected"</c:if>>2017</option>
						</select>
					</td>
				</tr>
				<form:hidden path="currentAreaId" />
				<tr>
					<td class="width-15 active"><label class="pull-right">县区：</label></td>
					<td class="width-35">
						<select id="4_area" name="4_area" class="form-control areaCascadeSelect" >
						</select>
					</td>
					<td class="width-15 active"><label class="pull-right">乡镇：</label></td>
					<td class="width-35">
						<select id="5_area" name="5_area" class="form-control areaCascadeSelect" >
						</select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">村居：</label></td>
					<td class="width-35">
						<select id="6_area" name="6_area" class="form-control areaCascadeSelect" >
						</select>
					</td>
					<td class="width-15 active"><label class="pull-right">地址</label></td>
		   			<td class="width-35" >
		   			<form:input path="dz" htmlEscape="false"    class="form-control "/>
		   			</td>
		  		</tr>
		 	</tbody>
		</table>
		</div>
	</form:form>
</body>
</html>