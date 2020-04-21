<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>人大边缘户走访主表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>人大边缘户走访主表列表 </h5>
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
	<form:form id="searchForm" modelAttribute="rdbyhZf" action="${ctx}/bfll/rdbyhZf/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>年度：</span>
				<form:input path="nd" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>边缘户id：</span>
				<form:input path="byhid" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>帮扶人id：</span>
				<form:input path="bfrid" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:rdbyhZf:add">
				<table:addRow url="${ctx}/bfll/rdbyhZf/form" title="人大边缘户走访主表"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhZf:edit">
			    <table:editRow url="${ctx}/bfll/rdbyhZf/form" title="人大边缘户走访主表" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhZf:del">
				<table:delRow url="${ctx}/bfll/rdbyhZf/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhZf:import">
				<table:importExcel url="${ctx}/bfll/rdbyhZf/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhZf:export">
	       		<table:exportExcel url="${ctx}/bfll/rdbyhZf/export"></table:exportExcel><!-- 导出按钮 -->
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
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column nd">年度</th>
				<th  class="sort-column grxj">个人小结</th>
				<th  class="sort-column remarks">备注信息</th>
				<th  class="sort-column byhid">边缘户id</th>
				<th  class="sort-column bfrid">帮扶人id</th>
				<th  class="sort-column dwxx">定位信息</th>
				<th  class="sort-column zfsj">走访时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rdbyhZf">
			<tr>
				<td> <input type="checkbox" id="${rdbyhZf.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看人大边缘户走访主表', '${ctx}/bfll/rdbyhZf/form?id=${rdbyhZf.id}','800px', '500px')">
					${rdbyhZf.nd}
				</a></td>
				<td>
					${rdbyhZf.grxj}
				</td>
				<td>
					${rdbyhZf.remarks}
				</td>
				<td>
					${rdbyhZf.byhid}
				</td>
				<td>
					${rdbyhZf.bfrid}
				</td>
				<td>
					${rdbyhZf.dwxx}
				</td>
				<td>
					${rdbyhZf.zfsj}
				</td>
				<td>
					<shiro:hasPermission name="bfll:rdbyhZf:view">
						<a href="#" onclick="openDialogView('查看人大边缘户走访主表', '${ctx}/bfll/rdbyhZf/form?id=${rdbyhZf.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:rdbyhZf:edit">
    					<a href="#" onclick="openDialog('修改人大边缘户走访主表', '${ctx}/bfll/rdbyhZf/form?id=${rdbyhZf.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:rdbyhZf:del">
						<a href="${ctx}/bfll/rdbyhZf/delete?id=${rdbyhZf.id}" onclick="return confirmx('确认要删除该人大边缘户走访主表吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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