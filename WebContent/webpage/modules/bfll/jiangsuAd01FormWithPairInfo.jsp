<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>经济薄弱村帮扶力量</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		/* jdcldxnjj */
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
			var carMessage = $('#jdcldxnjj').val();
			
			var aad101Array = [];
			$("select[name='ad10.aad101']:visible").each(function () {
				var val = $(this).val();
				if (val != '10') {
					aad101Array.push(val);
				}
			});
			var noRepeatAad101Array = unique(aad101Array);
			if (aad101Array.length != noRepeatAad101Array.length) {
				top.layer.alert('每一种组内职务只能分配一个帮扶责任人!', {icon: 0, title:'警告'});
				return false;
			}
		
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
				var $selectedAk11s = $("#contentTable").find("input:hidden[name='ad10.akid']");
				var excludeIds = '';
				if ($selectedAk11s) {
					var ak11IdArray = new Array();
					$selectedAk11s.each(function () {
						ak11IdArray.push($(this).val());
					});
					excludeIds = "'" + ak11IdArray.join("','") + "'";
				}
				var dlg = top.layer.open({
				    type: 2,  
				    maxmin: true,
				    title:"选择帮扶责任人",
				    name:'friend',
				    content: "${ctx}/bfll/jiangsuAk11/gridSelect?excludeIds=" + excludeIds,
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
				    	 $znzwTd.find("input[name='ad10.akid']").val(object.id);// 设置帮扶责任人ID
				    	 var $lxfsTd = $("<td/>").text(object.aar012);
				    	 var $delTd = $("<td/>").html('<button title="删除" class="btn btn-white btn-sm" type="button" onclick="delBfzrr(this)" data-placement="left"><i class="fa fa-trash-o"></i> 删除</button>')
				    	 var $tr = $("<tr/>").append($xmTd).append($znzwTd).append($lxfsTd).append($delTd);
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
		
		// 最简单数组去重法
		function unique(array){
		  var n = []; //一个新的临时数组
		  //遍历当前数组
		  for(var i = 0; i < array.length; i++){
		    //如果当前数组的第i已经保存进了临时数组，那么跳过，
		    //否则把当前项push到临时数组里面
		    if (n.indexOf(array[i]) == -1) n.push(array[i]);
		  }
		  return n;
		}
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox">
	    	<div class="ibox-content">
				<h2 class="text-center">经济薄弱村帮扶力量</h2>
				<form:form id="inputForm" modelAttribute="jiangsuAd01" action="${ctx}/bfll/jiangsuAd01/updatePairInfo" method="post" class="form-horizontal">
					<sys:message content="${message}"/>	
					<form:hidden path="id"/>
					<input type="hidden" name="year" value="${param.year }">
					<input type="hidden" name="xq" value="${param.xq }">
					<input type="hidden" name="xz" value="${param.xz }">
					<input type="hidden" name="cj" value="${param.cj }">
					<div class="row"  style="padding-left:1%">
						<h3>基本信息</h3>
					</div>
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>村党组织书记姓名：</label></td>
								<td class="width-35">
									<input name="aad104" value="${jiangsuAd01.aad104 }" class="form-control required"/>
								</td>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>村党组织书记联系方式：</label></td>
								<td class="width-35">
									<input name="aad105" value="${jiangsuAd01.aad105 }" class="form-control required"/>
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>村主任姓名：</label></td>
								<td class="width-35">
									<input name="aad106" value="${jiangsuAd01.aad106 }" class="form-control required"/>
								</td>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>村主任联系方式：</label></td>
								<td class="width-35">
									<input name="aad107" value="${jiangsuAd01.aad107 }" class="form-control required"/>
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>村会计姓名：</label></td>
								<td class="width-35">
									<input name="aad108" value="${jiangsuAd01.aad108 }" class="form-control required"/>
								</td>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>村会计联系方式：</label></td>
								<td class="width-35">
									<input name="aad109" value="${jiangsuAd01.aad109 }" class="form-control required"/>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="row"  style="padding-left:1%">
						<h3>省级帮扶单位</h3>
					</div>
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">省级帮扶单位：</label></td>
								<td class="width-35">
									<sys:gridselect url="${ctx}/bfll/jiangsuAp11/gridSelectS" id="aad110" name="aad110"  value="${jiangsuAd01.aad110}"  title="选择省级帮扶单位" labelName="ap11S.aap001" 
						 				labelValue="${jiangsuAd01.ap11S.aap001}" cssClass="form-control" fieldLabels="单位名称" fieldKeys="aap001" searchLabel="单位名称" searchKey="aap001" ></sys:gridselect>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="row"  style="padding-left:1%">
						<h3>市县乡联动帮扶组</h3>
					</div>
					<div id="znzwTemplate" class="hidden">
						<input type="hidden" name="ad10.akid" value=""/>
						<select name="ad10.aad101" class="form-control required">
							<c:forEach items="${fns:getDictList('bfzrr_znzw')}" var="znzw">
								<option value="${znzw.value }">${znzw.label }</option>
							</c:forEach>
						</select>
					</div>
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right"><font color="red">*</font>牵头单位：</label></td>
								<td class="width-35">
									<sys:gridselect url="${ctx}/bfll/jiangsuAp11/gridSelect" id="aap110" name="aap110"  value="${jiangsuAd01.aap110}"  title="选择帮扶单位" labelName="ap11.aap001" 
						 				labelValue="${jiangsuAd01.ap11.aap001}" cssClass="form-control required" fieldLabels="单位名称" fieldKeys="aap001" searchLabel="单位名称" searchKey="aap001" ></sys:gridselect>
								</td>
							</tr>
						</tbody>
					</table>
					<button id="add_bfzrr_btn" title="添加" class="btn btn-white btn-sm" type="button" data-placement="left" style="margin-bottom:5px;"><i class="fa fa-plus"></i> 添加</button>
					<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<thead>
							<tr>
								<th class="width-25">姓名</th>
								<!-- 
								<th class="width-25">单位</th>
								 -->
								<th class="width-20">组内职务</th>
								<th class="width-20">联系方式</th>
								<th class="width-10">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${jiangsuAd01.ak11List}" var="ak11" varStatus="s">
								<tr id="0">
									<td>${ak11.aab002 }</td>
									<!-- 
									<td>${ak11.aap001 }</td>
									 -->
									<td>
										<input type="hidden" name="ad10.akid" value="${ak11.id }"/>
										<select name="ad10.aad101" class="form-control required">
											<c:forEach items="${fns:getDictList('bfzrr_znzw')}" var="znzw">
												<option value="${znzw.value }" ${ak11.jiangsuAd10.aad101 eq znzw.value ? "selected='selected'" : "" }>${znzw.label }</option>
											</c:forEach>
										</select>
									</td>
									<td>${ak11.aar012 }</td>
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