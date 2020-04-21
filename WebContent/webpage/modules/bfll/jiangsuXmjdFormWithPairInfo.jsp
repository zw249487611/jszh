<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>项目帮扶责任人结对信息</title>
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
				    	 var $dwTd = $("<td/>").text(object.aap001);
				    	 var $znzwTd = $("<td/>").append($("#znzwTemplate").html());
				    	 $znzwTd.find("input[name='zrrbh']").val(object.id);// 设置帮扶责任人ID
				    	 var $lxfsTd = $("<td/>").text(object.aar012);
				    	 var $delTd = $("<td/>").html('<button title="删除" class="btn btn-white btn-sm" type="button" onclick="delBfzrr(this)" data-placement="left"><i class="fa fa-trash-o"></i> 删除</button>')
				    	 var $tr = $("<tr/>").append($xmTd).append($dwTd).append($znzwTd).append($lxfsTd).append($delTd);
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
			top.layer.confirm('确认要删除吗?', {icon: 3, title:'系统提示'}, function(index){
			var xmjdZrrId=$("input[name='xmjdZrrId']",$(obj).parents("tr:first")).attr("value");
			 $.ajax({
	   		        type: "post",
	   		        url: "${ctx}/bfll/jiangsuXmjd/deleteByXmjdZrrId",
	   		      	data: {xmjdZrrId:xmjdZrrId},
	   		        cache: false,
	   		        async : false,
	   		        dataType: "json",
	   		        success: function (data)
	   		        {
	   		        	$(obj).parents("tr").remove();
	   		        },
	   		        error:function (XMLHttpRequest, textStatus, errorThrown) {      
	   		            alert("请求失败！");
	   		        }
	   		     });
			 top.layer.close(index);
			});
		}
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox">
	    	<div class="ibox-content">
				<h2 class="text-center">项目帮扶责任人结对信息</h2>
				<form:form id="inputForm" modelAttribute="jiangsuXmjd" action="${ctx}/bfll/jiangsuXmjd/updatePairInfo" method="post" class="form-horizontal">
					<sys:message content="${message}"/>	
					<form:hidden path="id"/>
					<input type="hidden" name="year" value="${param.year }">
					<input type="hidden" name="xq" value="${param.xq }">
					<input type="hidden" name="xz" value="${param.xz }">
					<input type="hidden" name="cj" value="${param.cj }">
					<%-- <table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">牵头单位：</label></td>
								<td class="width-35">
									<sys:gridselect url="${ctx}/bfll/jiangsuAp11/gridSelect" id="aap110" name="aap110"  value="${jiangsuXmjd.nd}"  title="选择帮扶单位" labelName="ap11.aap001" 
						 				labelValue="${jiangsuXmjd.nd}" cssClass="form-control required" fieldLabels="单位名称" fieldKeys="aap001" searchLabel="单位名称" searchKey="aap001" ></sys:gridselect>
								</td>
							</tr>
						</tbody>
					</table> --%>
					<div class="row"  style="padding-left:1%">
						<h3>帮扶责任人</h3>
					</div>
					<div id="znzwTemplate" class="hidden">
						<input type="hidden" name="xmjdZrrId" value=""/>
						<input type="hidden" name="zrrbh" value=""/>
						<select name="znzwbh" class="form-control required">
							<c:forEach items="${fns:getDictList('xmjdzrr_znzw')}" var="znzw">
								<option value="${znzw.value }">${znzw.label }</option>
							</c:forEach>
						</select>
					</div>
					<button id="add_bfzrr_btn" title="添加" class="btn btn-white btn-sm" type="button" data-placement="left" style="margin-bottom:5px;"><i class="fa fa-plus"></i> 添加</button>
					<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<thead>
							<tr>
								<th class="width-25">姓名</th>
								<th class="width-25">单位名称</th>
								<th class="width-25">组内职务名称</th>
								<th class="width-25">联系方式</th>
								<th class="width-25">操作</th>
								<!-- <th class="width-20">组内职务</th>
								<th class="width-20">联系方式</th>
								<th class="width-10">操作</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${jiangsuXmjd.zrrList}" var="zrr" varStatus="s">
								<tr id="0">
									<td>${zrr.xm }</td>
									<td>${zrr.dwbh }</td>
									<td>
										<input type="hidden" name="xmjdZrrId" value="${zrr.id }"/>
										<input type="hidden" name="zrrbh" value="${zrr.zrrbh }"/>
										<select name="znzwbh" class="form-control required">
											<c:forEach items="${fns:getDictList('xmjdzrr_znzw')}" var="znzw">
												<option value="${znzw.value }" ${zrr.znzwbh == znzw.value ? "selected='selected'" : "" }>${znzw.label }</option>
											</c:forEach>
										</select>
									</td>
									<td>${zrr.lxfs }</td>
									<%-- <td>${ak11.aar012 }</td> --%>
									<td>
										<button title="删除" class="btn btn-white btn-sm" type="button" onclick="delBfzrr(this)" data-placement="left"><i class="fa fa-trash-o"></i> 删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>