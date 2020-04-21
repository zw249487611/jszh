<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>边缘户帮扶责任人管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	var validateForm;
	/* jdcldxnjj */
	function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		var carMessage = $('#jdcldxnjj').val();
		
		if(validateForm.form()){
			$("#inputForm").submit();
			return true;
		}

		return false;
	}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({

				submitHandler: function(form){
					var carMessage = $('#jdcldxnjj');
					//loading('正在提交，请稍等...');
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
			
			$("#add_bfzrr_btn").on("click", function () {
				var dlg = top.layer.open({
				    type: 2,  
				    maxmin: true,
				    title:"选择帮扶责任人",
				    name:'friend',
				    content: "${ctx}/bfll/jiangsuAk11/gridSelect" ,
				    btn: ['确定', '关闭'],
				    yes: function(index, layero){
				    	 var iframeWin = layero.find('iframe')[0].contentWindow; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    	 var item = iframeWin.getSelectedItem();
				    	 if(item == "-1"){
					    	 return;
				    	 }
				    	 object = iframeWin.getSelectedJson(item.split('_item_')[0]);
				    	 // 组装帮扶责任人表格行
				    	 var $xmTd = $("<td/>").text(object.aab002);
				    	 $xmTd.append('<input type="hidden" name="jiangsuAk113.akid" value="'+object.id+'"/>');
				    	 /* var $dwTd = $("<td/>").text(object.aap001); */
				    	/*  var $znzwTd = $("<td/>").append($("#znzwTemplate").html());
				    	 $znzwTd.find("input[name='jiangsuAk113.akid']").val(object.id);// 设置帮扶责任人ID */
				    	 
				    	 var $lxfsTd = $("<td/>").text(object.aar012);
				    	 var $lxfsTd1 = $("<td/>").text(object.aap001);
				    	 var $delTd = $("<td/>").html('<button title="删除" class="btn btn-white btn-sm" type="button" onclick="delBfzrr(this)" data-placement="left"><i class="fa fa-trash-o"></i> 删除</button>')
				    	 var $tr = $("<tr/>").append($xmTd).append($lxfsTd).append($lxfsTd1).append($delTd);
				    	 $("#contentTable tbody").append($tr);
				    	 
						 top.layer.close(index);//关闭对话框。
					  },
					  cancel: function(index){ 
				      }
				});
				top.layer.full(dlg);
			})
		});
		function delBfzrr(obj) {
			$(obj).parents("tr").remove();
		}
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
		<h5>帮扶责任人 </h5>
		<form:form id="inputForm" modelAttribute="byhJdxx" action="${ctx}/bfll/byhJdxx/updatebyhjiedui" method="post" class="form-horizontal">
		
		
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	<!-- 表格 -->
		<input type="hidden" name="byhId" value="${byhId }">
		<button id="add_bfzrr_btn" title="添加" class="btn btn-white btn-sm" type="button" data-placement="left" style="margin-bottom:5px;"><i class="fa fa-plus"></i> 添加</button>
		<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				
								<th class="width-25">姓名</th>
								<!-- <th class="width-25">单位</th> -->
								<th class="width-20">联系方式</th>
								<th class="width-20">帮扶单位</th>
								<th class="width-10">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${jiangsuAk11s}" var="jiangsuAk113">
		
			<tr>
				<%-- <td> <input type="checkbox" id="${jiangsuAk113.id}" class="i-checks"></td> --%>
				<td>
					${jiangsuAk113.aab002}
					<input type="hidden" name="jiangsuAk113.akid" value="${jiangsuAk113.id}"/>
				</td>
				<%-- <td>${jiangsuAk113.aap001 }</td> --%>
				<td>${jiangsuAk113.aar012 }</td>
				<td>${jiangsuAk113.aap001 }</td>
				<td>
				<button title="删除" class="btn btn-white btn-sm" type="button" onclick="delBfzrr(this)" data-placement="left"><i class="fa fa-trash-o"></i> 删除</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		<!-- 分页代码 -->
	<%-- <table:page page="${page}"></table:page> --%>
	<br/>
	<br/>
	</div>
	</form:form>
	</div>
	</div>
</body>
</html>