<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>电子导览物标类型管理管理</title>
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
		<h5>电子导览物标类型管理列表 </h5>
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
	<form:form id="searchForm" modelAttribute="dzdlWbType" action="${ctx}/dzdlwbtype/dzdlWbType/" method="post" class="form-inline">
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
			<shiro:hasPermission name="dzdlwbtype:dzdlWbType:add">
				<table:addRow url="${ctx}/dzdlwbtype/dzdlWbType/form" title="电子导览物标类型管理"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwbtype:dzdlWbType:edit">
			    <table:editRow url="${ctx}/dzdlwbtype/dzdlWbType/form" title="电子导览物标类型管理" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwbtype:dzdlWbType:del">
				<table:delRow url="${ctx}/dzdlwbtype/dzdlWbType/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwbtype:dzdlWbType:import">
				<table:importExcel url="${ctx}/dzdlwbtype/dzdlWbType/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="dzdlwbtype:dzdlWbType:export">
	       		<table:exportExcel url="${ctx}/dzdlwbtype/dzdlWbType/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column type">类型</th>
				<th  class="sort-column logo">物标logo</th>
				<th  class="sort-column desc">描述说明</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dzdlWbType">
			<tr>
				<td> <input type="checkbox" id="${dzdlWbType.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看电子导览物标类型管理', '${ctx}/dzdlwbtype/dzdlWbType/form?id=${dzdlWbType.id}','800px', '500px')">
					${fns:getDictLabel(dzdlWbType.type, 'dzdl_wb_type', '')}
				</a></td>
				<td>
					${dzdlWbType.logo}
				</td>
				<td>
					${dzdlWbType.desc}
				</td>
				<td>
					<shiro:hasPermission name="dzdlwbtype:dzdlWbType:view">
						<a href="#" onclick="openDialogView('查看电子导览物标类型管理', '${ctx}/dzdlwbtype/dzdlWbType/form?id=${dzdlWbType.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="dzdlwbtype:dzdlWbType:edit">
    					<a href="#" onclick="openDialog('修改电子导览物标类型管理', '${ctx}/dzdlwbtype/dzdlWbType/form?id=${dzdlWbType.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="dzdlwbtype:dzdlWbType:del">
						<a href="${ctx}/dzdlwbtype/dzdlWbType/delete?id=${dzdlWbType.id}" onclick="return confirmx('确认要删除该电子导览物标类型管理吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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