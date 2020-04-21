<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>物标管理管理</title>
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
		<h5>物标管理列表 </h5>
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
	<form:form id="searchForm" modelAttribute="dzdlWb" action="${ctx}/dzdlwb/dzdlWb/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="dzdlwb:dzdlWb:add">
				<table:addRow url="${ctx}/dzdlwb/dzdlWb/form" title="物标管理"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwb:dzdlWb:edit">
			    <table:editRow url="${ctx}/dzdlwb/dzdlWb/form" title="物标管理" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwb:dzdlWb:del">
				<table:delRow url="${ctx}/dzdlwb/dzdlWb/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwb:dzdlWb:import">
				<table:importExcel url="${ctx}/dzdlwb/dzdlWb/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwb:dzdlWb:export">
	       		<table:exportExcel url="${ctx}/dzdlwb/dzdlWb/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column name">物标名称</th>
				<th  class="sort-column details">物标介绍</th>
				<th  class="sort-column type">物标类型</th>
				<th  class="sort-column xlocation">x轴坐标</th>
				<th  class="sort-column ylocation">y轴坐标</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dzdlWb">
			<tr>
				<td> <input type="checkbox" id="${dzdlWb.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看物标管理', '${ctx}/dzdlwb/dzdlWb/form?id=${dzdlWb.id}','800px', '500px')">
					${dzdlWb.name}
				</a></td>
				<td>
					${dzdlWb.details}
				</td>
				<td>
					${fns:getDictLabel(dzdlWb.type, 'dzdl_wb_type', '')}
				</td>
				<td>
					${dzdlWb.xlocation}
				</td>
				<td>
					${dzdlWb.ylocation}
				</td>
				<td>
					<shiro:hasPermission name="dzdlwb:dzdlWb:view">
						<a href="#" onclick="openDialogView('查看物标管理', '${ctx}/dzdlwb/dzdlWb/form?id=${dzdlWb.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="dzdlwb:dzdlWb:edit">
    					<a href="#" onclick="openDialog('修改物标管理', '${ctx}/dzdlwb/dzdlWb/form?id=${dzdlWb.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="dzdlwb:dzdlWb:del">
						<a href="${ctx}/dzdlwb/dzdlWb/delete?id=${dzdlWb.id}" onclick="return confirmx('确认要删除该物标管理吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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