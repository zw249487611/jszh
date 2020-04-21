<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>贫困村基本信息管理</title>
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
		<h5>贫困村基本信息列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuXmjd" action="${ctx}/bfll/jiangsuXmjd/" method="post" class="form-inline">
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
			<shiro:hasPermission name="bfll:jiangsuXmjd:add">
				<table:addRow url="${ctx}/bfll/jiangsuXmjd/form" title="贫困村基本信息"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuXmjd:edit">
			    <table:editRow url="${ctx}/bfll/jiangsuXmjd/form" title="贫困村基本信息" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuXmjd:del">
				<table:delRow url="${ctx}/bfll/jiangsuXmjd/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuXmjd:import">
				<table:importExcel url="${ctx}/bfll/jiangsuXmjd/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuXmjd:export">
	       		<table:exportExcel url="${ctx}/bfll/jiangsuXmjd/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column aar002">aar002</th>
				<th  class="sort-column aar003">aar003</th>
				<th  class="sort-column aar004">aar004</th>
				<th  class="sort-column aar005">aar005</th>
				<th  class="sort-column aar006">aar006</th>
				<th  class="sort-column aar011">aar011</th>
				<th  class="sort-column aar012">aar012</th>
				<th  class="sort-column aad004">aad004</th>
				<th  class="sort-column aad028">aad028</th>
				<th  class="sort-column aar010">aar010</th>
				<th  class="sort-column aar001">aar001</th>
				<th  class="sort-column aar022">aar022</th>
				<th  class="sort-column aar023">aar023</th>
				<th  class="sort-column aar024">aar024</th>
				<th  class="sort-column aar025">aar025</th>
				<th  class="sort-column baz002">baz002</th>
				<th  class="sort-column aar008">aar008</th>
				<th  class="sort-column aaf031">aaf031</th>
				<th  class="sort-column aad035">aad035</th>
				<th  class="sort-column aad036">aad036</th>
				<th  class="sort-column aad037">aad037</th>
				<th  class="sort-column aad038">aad038</th>
				<th  class="sort-column aar040">aar040</th>
				<th  class="sort-column aac016">aac016</th>
				<th  class="sort-column aac005">识别标准</th>
				<th  class="sort-column aap110">aap110</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuXmjd">
			<tr>
				<td> <input type="checkbox" id="${jiangsuXmjd.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看贫困村基本信息', '${ctx}/bfll/jiangsuXmjd/form?id=${jiangsuXmjd.id}','800px', '500px')">
					${jiangsuXmjd.aar002}
				</a></td>
				<td>
					${jiangsuXmjd.aar003}
				</td>
				<td>
					${jiangsuXmjd.aar004}
				</td>
				<td>
					${jiangsuXmjd.aar005}
				</td>
				<td>
					${jiangsuXmjd.aar006}
				</td>
				<td>
					${jiangsuXmjd.aar011}
				</td>
				<td>
					${jiangsuXmjd.aar012}
				</td>
				<td>
					${jiangsuXmjd.aad004}
				</td>
				<td>
					${jiangsuXmjd.aad028}
				</td>
				<td>
					${jiangsuXmjd.aar010}
				</td>
				<td>
					${jiangsuXmjd.aar001}
				</td>
				<td>
					${jiangsuXmjd.aar022}
				</td>
				<td>
					${jiangsuXmjd.aar023}
				</td>
				<td>
					${jiangsuXmjd.aar024}
				</td>
				<td>
					${jiangsuXmjd.aar025}
				</td>
				<td>
					${jiangsuXmjd.baz002}
				</td>
				<td>
					${jiangsuXmjd.aar008}
				</td>
				<td>
					${jiangsuXmjd.aaf031}
				</td>
				<td>
					${jiangsuXmjd.aad035}
				</td>
				<td>
					${jiangsuXmjd.aad036}
				</td>
				<td>
					${jiangsuXmjd.aad037}
				</td>
				<td>
					${jiangsuXmjd.aad038}
				</td>
				<td>
					${jiangsuXmjd.aar040}
				</td>
				<td>
					${jiangsuXmjd.aac016}
				</td>
				<td>
					${jiangsuXmjd.aac005}
				</td>
				<td>
					${jiangsuXmjd.aap110}
				</td>
				<td>
					<shiro:hasPermission name="bfll:jiangsuXmjd:view">
						<a href="#" onclick="openDialogView('查看贫困村基本信息', '${ctx}/bfll/jiangsuXmjd/form?id=${jiangsuXmjd.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:jiangsuXmjd:edit">
    					<a href="#" onclick="openDialog('修改贫困村基本信息', '${ctx}/bfll/jiangsuXmjd/form?id=${jiangsuXmjd.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:jiangsuXmjd:del">
						<a href="${ctx}/bfll/jiangsuXmjd/delete?id=${jiangsuXmjd.id}" onclick="return confirmx('确认要删除该贫困村基本信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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