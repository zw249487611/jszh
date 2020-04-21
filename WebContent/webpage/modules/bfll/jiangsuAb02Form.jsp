<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>贫困人口参加社会保险信息管理</title>
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
	
	function addTr(){
		var s=$("#newab01 option").size();
		if(s>0){
			$("#dTable tbody").append(
					'<tr>'+
					'<td>'+
						'<select name="aar040" class="form-control ">'+
							'<option value="2014">2014</option>'+
							'<option value="2015">2015</option>'+
							'<option value="2016">2016</option>'+
							'<option value="2017">2017</option>'+
						'</select>'+
					'</td>'+
					'<td>'+
						'<select name="aab001" class="form-control ">'+
							'<c:forEach items="${newJiangsuAb01s }" var="ab01">'+
								'<option value="${ab01.id }">${ab01.aab002 }</option>'+
							'</c:forEach>'+
						'</select>'+
					'</td>'+
					'<td>'+
						'<select name="aab022" class="form-control ">'+
							'<option value="0">不参加</option>'+
							'<option value="1">参加</option>'+
						'</select>'+
					'</td>'+
					'<td>'+
					'<input type="button" class="btn  btn-sm" value="删除" onclick="delTr(this);">'+
					'</td>'+
					'</tr>'
				);
		}else{
			alert("请先添加贫困人口！");
		}
			
		
		}
	
	function delTr(obj){
		$(obj).parent().parent().remove();
	}
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="jiangsuAb02" action="${ctx}/bfll/jiangsuAb02/save1" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
								<button id="add_column_btn" title="添加" class="btn btn-white btn-sm" type="button" onclick="addTr();" data-placement="left"><i class="fa fa-plus"></i> 添加</button>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer" id="dTable">
				<input name="acid" type="hidden" value="${acid }">
				<div style="display:none; ">
						<select id="newab01" name="newab01" class="form-control ">
							<c:forEach items="${newJiangsuAb01s }" var="ab01">
								<option value="${ab01.id }">${ab01.aab002 }</option>
							</c:forEach>
						</select>
				</div>
				<thead >
							<tr>
								<th class="width-20">分区年度</th>
								<th class="width-20">贫困户姓名</th>
								<th class="width-20">是否参加大病保险</th>
								<th class="width-20">操作</th>
							</tr>
						</thead>
		   <tbody>
		   <c:if test="${not empty ab02s }">
		   		<c:forEach items="${ab02s }" var="ab02">
		   		<tr>
					<td>
						<select name="aar040" class="form-control ">
						<option value="2014" <c:if test="${ab02.aar040=='2014' }">selected="selected"</c:if>>2014</option>
						<option value="2015" <c:if test="${ab02.aar040=='2015' }">selected="selected"</c:if>>2015</option>
						<option value="2016" <c:if test="${ab02.aar040=='2016' }">selected="selected"</c:if>>2016</option>
						<option value="2017" <c:if test="${ab02.aar040=='2017' }">selected="selected"</c:if>>2017</option>
						</select>
					</td>
					<td>
						<select name="aab001" class="form-control ">
							<c:forEach items="${newJiangsuAb01s }" var="ab01">
								<option value="${ab01.id }" <c:if test="${ab02.abid==ab01.id }">selected="selected"</c:if>>${ab01.aab002 }</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<select name="aab022" class="form-control ">
							<option value="0" <c:if test="${ab02.aab022=='0' }">selected="selected"</c:if>>不参加</option>
							<option value="1" <c:if test="${ab02.aab022=='1' }">selected="selected"</c:if>>参加</option>
						</select>
					</td>
					<td>
						<input type="button" class="btn  btn-sm" value="删除" onclick="delTr(this);">
					</td>
				</tr>
		  		</c:forEach>
		   </c:if>
		 	</tbody>
		</table>
	</form:form>
	
</body>
</html>