<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶单位信息管理</title>
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
	<style>
		/*移除 input type="number" 时浏览器自带的上下箭头*/
		input::-webkit-inner-spin-button {
			-webkit-appearance: none;
			}
		input::-webkit-outer-spin-button {
			-webkit-appearance: none;
			}
	</style>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="jiangsuAp11" action="${ctx}/bfll/jiangsuAp11/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div id="areaSelectDiv">

		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>帮扶单位类型：</label></td>
					<td class="width-35">
						<form:select path="aap051" class="form-control required">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('bfdwlx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>单位名称：</label></td>
					<td class="width-35">
						<form:input path="aap001" htmlEscape="false" id="newAap001" class="form-control required"/>
					</td>
				</tr>
				<!--  
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>单位地址：</label></td>
						<td class="width-35">
							<form:input path="aap002" htmlEscape="false" id="newAap002" class="form-control required"/>
						</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>组织机构代码：</label></td>
					<td class="width-35">
						<form:input path="aap003" htmlEscape="false"    class="form-control required"/>
					</td>
				</tr>-->
				<tr>
					<td class="width-15 active"><label class="pull-right">隶属关系：</label></td>
					<td class="width-35">
						<form:select path="aap004" class="form-control">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('lsgx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>是否后台支持部门：</label></td>
					<td class="width-35">
						<form:select path="aar016" class="form-control required ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
						<!--  
					<td class="width-15 active"></td>
						<td class="width-35">
							
						</td>-->
						<!--  
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>联系人姓名：</label></td>
					<td class="width-35">
						<form:input path="aar011" htmlEscape="false"    class="form-control required"/>
					</td>-->
					
				</tr>
				
				<tr>
					<td class="width-15 active"><label class="pull-right">县区：</label></td>
					<td class="width-35">
						<form:select path="currentAreaId" class="form-control m-b">
						<option value="">--请选择--</option>
							<form:options items="${xqMap}" />
						</form:select> 
					</td>
					<!-- 
					<td class="width-15 active"><label class="pull-right">乡镇：</label></td>
					<td class="width-35">
						<select id="5_area" name="5_area" class="form-control areaCascadeSelect" >
						</select>
					</td> -->
				</tr>
				<!-- 
				<tr>
					<td class="width-15 active"><label class="pull-right">村居：</label></td>
					<td class="width-35">
						<select id="6_area" name="6_area" class="form-control areaCascadeSelect" >
						</select>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" >
		   			</td>
		  		</tr>
		  		-->
				<!--  
				
				<tr>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>联系电话：</label></td>
						<td class="width-35">
							<form:input path="aar012" htmlEscape="false" type="number" minlength="11" maxlength="11" class="form-control required"/>
						</td>
					<td class="width-15 active"><label class="pull-right"><font color="red">*</font>联系地址：</label></td>
					<td class="width-35">
						<form:input path="aar013" htmlEscape="false"    class="form-control required"/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">邮政编码：</label></td>
						<td class="width-35">
							<form:input path="aar014" htmlEscape="false" type="number" minlength="6" maxlength="6" class="form-control "/>
						</td>
					<td class="width-15 active"><label class="pull-right">电子邮箱：</label></td>
					<td class="width-35">
						<form:input path="aar015" htmlEscape="false"  type="email"   class="form-control "/>
					</td>
					
		  		</tr>-->
		 	</tbody>
		</table>
				</div>
	</form:form>
</body>
</html>