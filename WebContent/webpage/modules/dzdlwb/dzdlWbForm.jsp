<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>物标管理管理</title>
	<meta name="decorator" content="default"/>
	 <link href="${ctxStatic}/summernote/summernote.css" rel="stylesheet">
	 <link href="${ctxStatic}/summernote/summernote-bs3.css" rel="stylesheet">
	 <script src="${ctxStatic}/summernote/summernote.min.js"></script>
	 <script src="${ctxStatic}/summernote/summernote-zh-CN.js"></script>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#description").val($("#rich_description").next().find(".note-editable").html());//取富文本的值
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
			
				//富文本初始化
			$('#rich_description').summernote({
                lang: 'zh-CN'
            });

			$("#rich_description").next().find(".note-editable").html(  $("#description").val());

			$("#rich_description").next().find(".note-editable").html(  $("#rich_description").next().find(".note-editable").text());
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="dzdlWb" action="${ctx}/dzdlwb/dzdlWb/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">物标名称：</label></td>
					<td class="width-35">
						<form:input path="name" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">物标介绍：</label></td>
					<td class="width-35">
						<form:input path="details" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">物标类型：</label></td>
					<td class="width-35">
						<form:select path="type" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('dzdl_wb_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
					<td class="width-15 active"><label class="pull-right">物标logo：</label></td>
					<td class="width-35">
						<form:hidden id="logo" path="logo" htmlEscape="false" maxlength="128" class="form-control"/>
						<sys:ckfinder input="logo" type="files" uploadPath="/dzdlwb/dzdlWb" selectMultiple="true"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">物标详细介绍：</label></td>
					<td class="width-35">
						<form:hidden path="description"/>
						<div id="rich_description">
                           

                        </div>
					</td>
					<td class="width-15 active"><label class="pull-right">物标图片：</label></td>
					<td class="width-35">
						<form:hidden id="picture" path="picture" htmlEscape="false" maxlength="200" class="form-control"/>
						<sys:ckfinder input="picture" type="files" uploadPath="/dzdlwb/dzdlWb" selectMultiple="true"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">音频介绍：</label></td>
					<td class="width-35">
						<form:hidden id="mp3desc" path="mp3desc" htmlEscape="false" maxlength="64" class="form-control"/>
						<sys:ckfinder input="mp3desc" type="files" uploadPath="/dzdlwb/dzdlWb" selectMultiple="true"/>
					</td>
					<td class="width-15 active"><label class="pull-right">视频介绍：</label></td>
					<td class="width-35">
						<form:hidden id="mp4desc" path="mp4desc" htmlEscape="false" maxlength="64" class="form-control"/>
						<sys:ckfinder input="mp4desc" type="files" uploadPath="/dzdlwb/dzdlWb" selectMultiple="true"/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">x轴坐标：</label></td>
					<td class="width-35">
						<form:input path="xlocation" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">y轴坐标：</label></td>
					<td class="width-35">
						<form:input path="ylocation" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
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