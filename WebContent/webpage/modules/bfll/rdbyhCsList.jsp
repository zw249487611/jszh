<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>边缘户帮扶措施管理</title>
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
		<h5>边缘户帮扶措施列表 </h5>
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
	<form:form id="searchForm" modelAttribute="rdbyhCs" action="${ctx}/bfll/rdbyhCs/" method="post" class="form-inline">
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
			<shiro:hasPermission name="bfll:rdbyhCs:add">
				<table:addRow url="${ctx}/bfll/rdbyhCs/form" title="边缘户帮扶措施"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhCs:edit">
			    <table:editRow url="${ctx}/bfll/rdbyhCs/form" title="边缘户帮扶措施" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhCs:del">
				<table:delRow url="${ctx}/bfll/rdbyhCs/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhCs:import">
				<table:importExcel url="${ctx}/bfll/rdbyhCs/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:rdbyhCs:export">
	       		<table:exportExcel url="${ctx}/bfll/rdbyhCs/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column bfid">人大边缘户走访主表id</th>
				<th  class="sort-column zfxx">致富信息</th>
				<th  class="sort-column jszx">技术咨询</th>
				<th  class="sort-column fcdhxm">扶持到户项目</th>
				<th  class="sort-column zzznrs">资助子女人数</th>
				<th  class="sort-column jzwz">捐助物资</th>
				<th  class="sort-column dycs">调研次数</th>
				<th  class="sort-column tpta">脱贫提案件数</th>
				<th  class="sort-column remarks">备注信息</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rdbyhCs">
			<tr>
				<td> <input type="checkbox" id="${rdbyhCs.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看边缘户帮扶措施', '${ctx}/bfll/rdbyhCs/form?id=${rdbyhCs.id}','800px', '500px')">
					${rdbyhCs.bfid}
				</a></td>
				<td>
					${rdbyhCs.zfxx}
				</td>
				<td>
					${rdbyhCs.jszx}
				</td>
				<td>
					${rdbyhCs.fcdhxm}
				</td>
				<td>
					${rdbyhCs.zzznrs}
				</td>
				<td>
					${rdbyhCs.jzwz}
				</td>
				<td>
					${rdbyhCs.dycs}
				</td>
				<td>
					${rdbyhCs.tpta}
				</td>
				<td>
					${rdbyhCs.remarks}
				</td>
				<td>
					<shiro:hasPermission name="bfll:rdbyhCs:view">
						<a href="#" onclick="openDialogView('查看边缘户帮扶措施', '${ctx}/bfll/rdbyhCs/form?id=${rdbyhCs.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:rdbyhCs:edit">
    					<a href="#" onclick="openDialog('修改边缘户帮扶措施', '${ctx}/bfll/rdbyhCs/form?id=${rdbyhCs.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:rdbyhCs:del">
						<a href="${ctx}/bfll/rdbyhCs/delete?id=${rdbyhCs.id}" onclick="return confirmx('确认要删除该边缘户帮扶措施吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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