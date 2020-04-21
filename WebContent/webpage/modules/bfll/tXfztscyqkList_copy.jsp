<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2018年计划新发展特色产业情况管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			if ($("#xqSelect").find("option").size() == 1) {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: '320800000000'}, function (data) {
					if (data.success) {
						var $xqSelect = $("#xqSelect");
						$xqSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item) {
							$xqSelect.append($("<option/>").val(item.aar001).text(item.aar009));
						});
					} else {
						
					}
				});
			}
			
			$("#xqSelect").on("change", function () {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: $(this).val()}, function (data) {
					if (data.success) {
						var $xzSelect = $("#xzSelect");
						$xzSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item){
							$xzSelect.append($("<option/>").val(item.aar001).text(item.aar009));
						});
					} else {
						
					}
				});
			});
			
			$("#xzSelect").on("change", function () {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: $(this).val()}, function (data) {
					if (data.success) {
						var $cjSelect = $("#cjSelect");
						$cjSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item) {
							$cjSelect.append($("<option/>").val(item.aar001).text(item.aar009));
						});
					} else {
						
					}
				});
			});
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>十三五期间规划项目 </h5>
		<div class="ibox-tools">
			<a class="collapse-link">
				<i class="fa fa-chevron-up"></i>
			</a>
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-wrench"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#">选项1</a>
				</li>
				<li><a href="#">选项2</a>
				</li>
			</ul>
			<a class="close-link">
				<i class="fa fa-times"></i>
			</a>
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="tXfztscyqk" action="${ctx}/bfll/tXfztscyqk/list" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		<!--  
			<span>村(作为外键)：</span>
				<form:input path="adid" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>特色产业类别：</span>
				<form:input path="tscylb" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>特色产业名称：</span>
				<form:input path="tscymc" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>拟实施地点：</span>
				<form:input path="nssdd" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>拟实施主体：</span>
				<form:input path="nsszt" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>发展目标及预期扶贫成效：</span>
				<form:input path="fzmbjyqfpcx" htmlEscape="false" maxlength="5000"  class=" form-control input-sm"/>
			<span>生产要素：</span>
				<form:input path="scys" htmlEscape="false" maxlength="5000"  class=" form-control input-sm"/>
			<span>政策措施：</span>
				<form:input path="zccs" htmlEscape="false" maxlength="5000"  class=" form-control input-sm"/>
			<span>资金扶持：</span>
				<form:input path="zjfc" htmlEscape="false" maxlength="5000"  class=" form-control input-sm"/>
			<span>其他：</span>
				<form:input path="qt" htmlEscape="false" maxlength="1000"  class=" form-control input-sm"/>
		-->
		<div class="form-group mar-bom mar-lft">
				<span>县区：</span>
				<select id="xqSelect" name="xq" class="form-control " style="width: 110px;">
					<option value="">--请选择--</option>
					<c:if test="${not empty xqList }">
						<c:forEach items="${xqList }" var="xq">
							<option value="${xq.aar001 }" ${tXfztscyqk.xq eq xq.aar001 ? "selected='selected'" : "" }>${xq.aar009 }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="form-group mar-bom mar-lft">
				<span>乡镇：</span>
				<select id="xzSelect" name="xz" class="form-control" style="width: 150px;">
					<option value="">--请选择--</option>
					<c:if test="${not empty xzList }">
						<c:forEach items="${xzList }" var="xz">
							<option value="${xz.aar001 }" ${tXfztscyqk.xz eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="form-group mar-bom mar-lft">
				<span>村居：</span>
				<select id="cjSelect" name="cj" class="form-control" style="width: 150px;">
					<option value="">--请选择--</option>
					<c:if test="${not empty cjList }">
						<c:forEach items="${cjList }" var="cj">
							<option value="${cj.aar001 }" ${tXfztscyqk.cj eq cj.aar001 ? "selected='selected'" : "" }>${cj.aar009 }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>	
		 </div>	
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:tXfztscyqk:add">
				<table:addRow url="${ctx}/bfll/tXfztscyqk/form" title="2018年计划新发展特色产业情况"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tXfztscyqk:edit">
			    <table:editRow url="${ctx}/bfll/tXfztscyqk/form" title="2018年计划新发展特色产业情况" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tXfztscyqk:del">
				<table:delRow url="${ctx}/bfll/tXfztscyqk/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tXfztscyqk:import">
				<table:importExcel url="${ctx}/bfll/tXfztscyqk/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tXfztscyqk:export">
	       		<table:exportExcel url="${ctx}/bfll/tXfztscyqk/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable" style="table-layout: fixed;">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<!--  <th  class="sort-column adid">村(作为外键)</th>-->
				<th class="sort-column xq" >县区</th>
	            <th class="sort-column xz" >乡镇</th>
	            <th class="sort-column cj" >村</th>
				<th  class="sort-column tscylb">特色产业类别</th>
				<th  class="sort-column tscymc">特色产业名称</th>
				<th  class="sort-column nssdd">拟实施地点</th>
				<th  class="sort-column nsszt">拟实施主体</th>
				<th  class="sort-column fzmbjyqfpcx">发展目标及预期扶贫成效</th>
				<th  class="sort-column scys">生产要素</th>
				<th  class="sort-column zccs">政策措施</th>
				<th  class="sort-column zjfc">资金扶持</th>
				<th  class="sort-column qt">其他</th>
				<th  class="sort-column remarks">备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tXfztscyqk">
			<tr>
				<td> <input type="checkbox" id="${tXfztscyqk.id}" class="i-checks"></td>
				<td>${tXfztscyqk.xq }</td>
				<td>${tXfztscyqk.xz }</td>
				<td>
				<a  href="#" onclick="openDialogView('十三五期间规划项目', '${ctx}/bfll/tXfztscyqk/form?id=${tXfztscyqk.id}','800px', '500px')">
				${tXfztscyqk.cj }
				</a></td>
				<!--  
				<td><a  href="#" onclick="openDialogView('查看2018年计划新发展特色产业情况', '${ctx}/bfll/tXfztscyqk/form?id=${tXfztscyqk.id}','800px', '500px')">
					${tXfztscyqk.adid}
				</a></td>
				-->
				<td>
					${tXfztscyqk.tscylb}
				</td>
				<td>
					${tXfztscyqk.tscymc}
				</td>
				<td>
					${tXfztscyqk.nssdd}
				</td>
				<td>
					${tXfztscyqk.nsszt}
				</td>
				<td style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
					${tXfztscyqk.fzmbjyqfpcx}
				</td>
				<td style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
					${tXfztscyqk.scys}
				</td>
				<td style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
					${tXfztscyqk.zccs}
				</td>
				<td style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
					${tXfztscyqk.zjfc}
				</td>
				<td>
					${tXfztscyqk.qt}
				</td>
				<td>
					${tXfztscyqk.remarks}
				</td>
				<td>
					<shiro:hasPermission name="bfll:tXfztscyqk:view">
						<a href="#" onclick="openDialogView('十三五期间规划项目', '${ctx}/bfll/tXfztscyqk/form?id=${tXfztscyqk.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:tXfztscyqk:edit">
    					<a href="#" onclick="openDialog('修改2018年计划新发展特色产业情况', '${ctx}/bfll/tXfztscyqk/form?id=${tXfztscyqk.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:tXfztscyqk:del">
						<a href="${ctx}/bfll/tXfztscyqk/delete?id=${tXfztscyqk.id}" onclick="return confirmx('确认要删除该2018年计划新发展特色产业情况吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>