<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>相对贫困户基本信息管理列表</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox">
			<div class="ibox-title">
				<h5>相对贫困户基本信息管理列表</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
						class="fa fa-wrench"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#">选项1</a></li>
						<li><a href="#">选项2</a></li>
					</ul>
					<a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
			</div>

			<div class="ibox-content">
				<sys:message content="${message}" />

				<!--查询条件-->
				<div class="row">
					<div class="col-sm-12">
						<form:form id="searchForm" modelAttribute="jiangsuAc01"
							action="${ctx}/bfll/newJiangsuAc01/" method="post"
							class="form-inline">
							<input id="pageNo" name="pageNo" type="hidden"
								value="${page.pageNo}" />
							<input id="pageSize" name="pageSize" type="hidden"
								value="${page.pageSize}" />
							<table:sortColumn id="orderBy" name="orderBy"
								value="${page.orderBy}" callback="sortOrRefresh();" />
							<!-- 支持排序 -->
							<div class="form-group">
								<div class="form-group">
									<span>年度：</span>
									<form:select path="aar040" class="form-control m-b">
										<form:options items="${yearMap}" />
									</form:select>
								</div>
								<div id="areaSelectDiv" class="form-group">
								<form:hidden path="currentAreaId" />
								<span>县区：</span> <select id="4_area" name="4_area"
									class="form-control areaCascadeSelect" style="width: 130px">
								</select> <span>乡镇：</span> <select id="5_area" name="5_area"
									class="form-control areaCascadeSelect" style="width: 130px">
								</select> <span>村：</span> <select id="6_area" name="6_area"
									class="form-control areaCascadeSelect" style="width: 130px">
								</select>
								</div>
								<div class="form-group">
									<span>联系电话：</span> <input type="text" name="aar012"
										value="${jiangsuAc01.aar012}" class="form-control ">
								</div>
								<div class="form-group">
									<span>姓名：</span> <input type="text" name="hzxm"
										value="${jiangsuAc01.hzxm}" class="form-control ">
								</div>
								
								<div class="form-group">
									<span>证件号码：</span>
									<input type="text" name="hzsfzh" value="${jiangsuAc01.hzsfzh}" class="form-control ">
								</div>
								
								<span>贫困户属性：</span>
									<form:select path="aac006"  class="form-control m-b">
										<form:option value="" label=""/>
										<form:options items="${fns:getDictList('pkhsx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
									</form:select>
								
								
								<div class="form-group">
									<span>状态：</span> <select name="delFlag" class="form-control ">
										<option value="0"
											${jiangsuAc01.delFlag == "0" ? "selected='selected'" : "" }
											selected="selected">未删除</option>
										<option value="1"
											${jiangsuAc01.delFlag == "1" ? "selected='selected'" : "" }>已删除</option>
									</select>
								</div>
								<div class="form-group">
									<span>是否支出性贫困：</span> 
									<select name="sfzcxpk" class="form-control ">
										<option value=""
											<c:if test="${newJiangsuAc01.sfzcxpk=='' }">selected="selected"</c:if>>--请选择--</option>
										<option value="0"
											<c:if test="${newJiangsuAc01.sfzcxpk=='0' }">selected="selected"</c:if>>否</option>
										<option value="1"
											<c:if test="${newJiangsuAc01.sfzcxpk=='1' }">selected="selected"</c:if>>是</option>
									</select>
								</div>
								<div class="form-group">
									<span>脱贫年度：</span> 
										<form:select path="tpnd" class="form-control m-b">
											<option value="">--请选择--</option>
											<form:options items="${yearMap}" />
										</form:select>
								</div>
								    &nbsp;&nbsp;<span>脱贫标志：</span>
								<form:select path="Aar010"  class="form-control m-b">
									<option value="">--请选择--</option>
									<form:options items="${fns:getDictList('tpbz')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
								</form:select>
							</div>
						</form:form>
						<br />
					</div>
				</div>

				<div class="row" style="margin-bottom:10px;">
					<div class="col-sm-12">
						<div class="pull-left"
							style="font-size: 18px; font-weight: bold;margin-left:10px;">共${peoplecount}人</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-rounded btn-outline btn-sm "
								onclick="search()">
								<i class="fa fa-search"></i> 查询
							</button>
							<button class="btn btn-primary btn-rounded btn-outline btn-sm "
								onclick="reset()">
								<i class="fa fa-refresh"></i> 重置
							</button>
						</div>
					</div>
				</div>

				<!-- 工具栏 -->
				<div class="row">
					<div class="col-sm-12">
						<div class="pull-left">
							<shiro:hasPermission name="bfll:newJiangsuAc01:add">
								<table:addRow url="${ctx}/bfll/newJiangsuAc01/form"
									title="贫困户基本信息"></table:addRow>
								<!-- 增加按钮 -->
							</shiro:hasPermission>
							<shiro:hasPermission name="bfll:newJiangsuAc01:edit">
								<table:editRow url="${ctx}/bfll/newJiangsuAc01/form"
									title="贫困户基本信息" id="contentTable"></table:editRow>
								<!-- 编辑按钮 -->
							</shiro:hasPermission>
							<shiro:hasPermission name="bfll:newJiangsuAc01:del">
								<table:delRow url="${ctx}/bfll/newJiangsuAc01/deleteAll"
									id="contentTable"></table:delRow>
								<!-- 删除按钮 -->
							</shiro:hasPermission>
							<shiro:hasPermission name="bfll:newJiangsuAc01:import">
								<button id="btnImport" class="btn btn-white btn-sm "
									data-toggle="tooltip" data-placement="left" title="导入">
									<i class="fa fa-folder-open-o"></i> 导入贫困户信息
								</button>
								<div id="importBox" class="hide">
									<form id="importForm"
										action="${ctx}/bfll/newJiangsuAc01/import" method="post"
										enctype="multipart/form-data"
										style="padding-left: 20px; text-align: center;">
										<br /> <input id="uploadFile" name="file" type="file"
											style="width: 330px" />导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！<br />
									</form>
								</div>
							</shiro:hasPermission>
							<shiro:hasPermission name="bfll:newJiangsuAb01:import">
								<button id="btnImport2" class="btn btn-white btn-sm "
									data-toggle="tooltip" data-placement="left" title="导入">
									<i class="fa fa-folder-open-o"></i> 导入贫困人口信息
								</button>
								<div id="importBox2" class="hide">
									<form id="importForm2"
										action="${ctx}/bfll/newJiangsuAb01/import" method="post"
										enctype="multipart/form-data"
										style="padding-left: 20px; text-align: center;">
										<br /> <input id="uploadFile" name="file" type="file"
											style="width: 330px" />导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！<br />
									</form>
								</div>
							</shiro:hasPermission>
							<shiro:hasPermission name="bfll:newJiangsuAc01:export">
								<button id="btnExport" class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" title="导出"><i class="fa fa-file-excel-o"></i> 导出贫困户信息</button>
								<script type="text/javascript">
								$(document).ready(function() {
								
									$("#btnExport").click(function(){
										top.layer.confirm('确认要导出Excel吗?', {icon: 3, title:'系统提示'}, function(index){
										    //do something
										    	//导出之前备份
										    	var url =  $("#searchForm").attr("action");
										    	var pageNo =  $("#pageNo").val();
										    	var pageSize = $("#pageSize").val();
										    	//导出excel
										        $("#searchForm").attr("action","/jzfp/a/bfll/newJiangsuAc01/export");
											    $("#pageNo").val(-1);
												$("#pageSize").val(-1);
												$("#searchForm").submit();
								
												//导出excel之后还原
												$("#searchForm").attr("action",url);
											    $("#pageNo").val(pageNo);
												$("#pageSize").val(pageSize);
										    top.layer.close(index);
										});
									});
								    
								});
								</script>
								<!-- <table:exportExcel url="${ctx}/bfll/newJiangsuAc01/export">导出</table:exportExcel> -->
								<!-- 导出按钮 -->
							</shiro:hasPermission>
						<shiro:hasPermission name="bfll:newJiangsuAc01:export">
								<button id="btnExport2" class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" title="导出"><i class="fa fa-file-excel-o"></i> 导出贫困人口信息</button>
								<script type="text/javascript">
								$(document).ready(function() {
								
									$("#btnExport2").click(function(){
										top.layer.confirm('确认要导出Excel吗?', {icon: 3, title:'系统提示'}, function(index){
										    //do something
										    	//导出之前备份
										    	var url =  $("#searchForm").attr("action");
										    	var pageNo =  $("#pageNo").val();
										    	var pageSize = $("#pageSize").val();
										    	//导出excel
										        $("#searchForm").attr("action","/jzfp/a/bfll/newJiangsuAb01/export1");
											    $("#pageNo").val(-1);
												$("#pageSize").val(-1);
												$("#searchForm").submit();
								
												//导出excel之后还原
												$("#searchForm").attr("action",url);
											    $("#pageNo").val(pageNo);
												$("#pageSize").val(pageSize);
										    top.layer.close(index);
										});
									});
								    
								});
								</script>
							</shiro:hasPermission> 
							<button class="btn btn-white btn-sm " data-toggle="tooltip"
								data-placement="left" onclick="sortOrRefresh()" title="刷新">
								<i class="glyphicon glyphicon-repeat"></i> 刷新
							</button>

						</div>

					</div>
				</div>

				<!-- 表格 -->
				<table id="contentTable"
					class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
					<thead>
						<tr>
							<th><input type="checkbox" class="i-checks"></th>
							<th class="sort-column aar040">分区年度</th>
							<th class="sort-column aab001">户主姓名</th>
							<th class="sort-column aar004">县区</th>
							<th class="sort-column aar005">乡镇/街道</th>
							<th class="sort-column aar006">村/居</th>
							<th class="sort-column aar012">联系电话</th>
							<th class="sort-column aac006">贫困户属性</th>
							<th class="sort-column jtrks">家庭人口数</th>
							<th class="sort-column jtrks">证件号码</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list}" var="jiangsuAc01">
							<tr>
								<td><input type="checkbox" id="${jiangsuAc01.id}"
									class="i-checks"></td>
								<td>${jiangsuAc01.aar040}</td>
								<td>${jiangsuAc01.hzxm}</td>
								<td>${jiangsuAc01.aar004}</td>
								<td>${jiangsuAc01.aar005}</td>
								<td>${jiangsuAc01.aar006}</td>
								<td>${jiangsuAc01.aar012}</td>
								<td>${fns:getDictLabel(jiangsuAc01.aac006, 'pkhsx', '')}</td>
								<td>${jiangsuAc01.jtrks}</td>
								<td>${jiangsuAc01.hzsfzh}</td>
								<td><shiro:hasPermission name="bfll:newJiangsuAc01:view">
										<a href="#"
											onclick="openDialogView('查看贫困户基本信息', '${ctx}/bfll/newJiangsuAc01/form?id=${jiangsuAc01.id}','800px', '500px')"
											class="btn btn-info btn-xs"><i class="fa fa-search-plus"></i>
											查看</a>
									</shiro:hasPermission> <shiro:hasPermission name="bfll:newJiangsuAc01:edit">
										<a href="#"
											onclick="openDialog('修改贫困户基本信息', '${ctx}/bfll/newJiangsuAc01/form?id=${jiangsuAc01.id}','800px', '500px')"
											class="btn btn-success btn-xs"><i class="fa fa-edit"></i>
											修改</a>
									</shiro:hasPermission> <!--  <a href="#" onclick="openDialog('保险信息', '${ctx}/bfll/jiangsuAb02/form1?id=${jiangsuAc01.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 保险信息</a>-->
									
									<shiro:hasPermission name="bfll:newJiangsuAc01:del">
										<c:if test="${jiangsuAc01.delFlag == '0'}">
											<a
												href="${ctx}/bfll/newJiangsuAc01/delete?id=${jiangsuAc01.id}"
												onclick="return confirmx('确认要删除该贫困户基本信息吗？', this.href)"
												class="btn btn-danger btn-xs"><i class="fa fa-trash"></i>
												删除</a>
										</c:if>
									</shiro:hasPermission>
									
									<shiro:hasPermission name="bfll:newJiangsuAc01:return">
										<c:if test="${jiangsuAc01.delFlag == '1'}">
											<a
												href="${ctx}/bfll/newJiangsuAc01/return?id=${jiangsuAc01.id}"
												onclick="return confirmx('确认要恢复该贫困户基本信息吗？', this.href)"
												class="btn btn-success btn-xs"><i class="fa fa-trash"></i>
												恢复</a>
										</c:if>
									</shiro:hasPermission>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 分页代码 -->
				<table:page page="${page}"></table:page>
				<br /> <br />
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnImport").click(function() {
				top.layer.open({
					type : 1,
					area : [ 500, 300 ],
					title : "导入数据",
					content : $("#importBox").html(),
					btn : [ '下载模板', '确定', '关闭' ],
					btn1 : function(index, layero) {
						window.location.href = '${ctx}/bfll/newJiangsuAc01/import/template';
					},
					btn2 : function(index, layero) {
						var inputForm = top.$("#importForm");
						var top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe 
						inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示
						top.$("#importForm").submit();
						top.layer.close(index);
					},

					btn3 : function(index) {
						top.layer.close(index);
					}
				});
			});

			$("#btnImport2").click(function() {
				top.layer.open({
					type : 1,
					area : [ 500, 300 ],
					title : "导入数据",
					content : $("#importBox2").html(),
					btn : [ '下载模板', '确定', '关闭' ],
					btn1 : function(index, layero) {
						window.location.href = '${ctx}/bfll/newJiangsuAb01/import/template';
					},
					btn2 : function(index, layero) {
						var inputForm = top.$("#importForm2");
						var top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe 
						inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示
						top.$("#importForm2").submit();
						top.layer.close(index);
					},

					btn3 : function(index) {
						top.layer.close(index);
					}
				});
			});
		});
	</script>
</body>
</html>