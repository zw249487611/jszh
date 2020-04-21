<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>贫困村走访收入修改</title>
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
		<h5>贫困村走访收入修改 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAd30" action="${ctx}/bfll/jiangsuAd30/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
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
			<span>年度：</span>
				<form:select path="aar040"  class="form-control m-b" >
					<form:option value="" label="--请选择--"/>
					<form:options items="${yearMap}" />
				</form:select>
			<span>季度：</span>
				<form:select path="aar041"  class="form-control m-b" >
					<form:option value="" label="--请选择--"/>
					<form:option value="1" label="1"/>
					<form:option value="2" label="2"/>
					<form:option value="3" label="3"/>
					<form:option value="4" label="4"/>
				</form:select>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:jiangsuAd30:add">
				<table:addRow url="${ctx}/bfll/jiangsuAd30/form" title="贫困村基本信息"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAd30:edit">
			    <table:editRow url="${ctx}/bfll/jiangsuAd30/form" title="贫困村基本信息" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAd30:del">
				<table:delRow url="${ctx}/bfll/jiangsuAd30/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAd30:import">
				<table:importExcel url="${ctx}/bfll/jiangsuAd30/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAd30:export">
	       		<table:exportExcel url="${ctx}/bfll/jiangsuAd30/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column aar040">年度</th>
				<th  class="sort-column aar041">季度</th>
				<th  class="sort-column xqName">县区</th>
				<th  class="sort-column xzName">乡镇</th>
				<th  class="sort-column cjName">村</th>
				<th  class="sort-column aad304">直接经营性收入</th>
				<th  class="sort-column aad305">上缴及发包收入</th>
				<th  class="sort-column aad306">投资收益</th>
				<th  class="sort-column aad307">其他收入</th>
				<th  class="sort-column aad311">总计</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAd30">
			<tr>
				<td> <input type="checkbox" id="${jiangsuAd30.id}" class="i-checks"></td>
				<td>
					${jiangsuAd30.aar040}
				</td>
				<td>
					${jiangsuAd30.aar041}
				</td>
				<td>
					${jiangsuAd30.xqName}
				</td>
				<td>
					${jiangsuAd30.xzName}
				</td>
				<td>
				<a  href="#" onclick="openDialogView('查看村走访收入', '${ctx}/bfll/jiangsuAd30/form?id=${jiangsuAd30.id}','800px', '500px')">
					${jiangsuAd30.cjName}
				</a></td>
				<td>
					${jiangsuAd30.aad304}
				</td>
				<td>
					${jiangsuAd30.aad305}
				</td>
				<td>
					${jiangsuAd30.aad306}
				</td>
				<td>
					${jiangsuAd30.aad307}
				</td>
				<td>
					${jiangsuAd30.aad311}
				</td>
				<td>
					<shiro:hasPermission name="bfll:jiangsuAd30:view">
						<a href="#" onclick="openDialogView('查看村走访收入信息', '${ctx}/bfll/jiangsuAd30/form?id=${jiangsuAd30.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:jiangsuAd30:edit">
    					<a href="#" onclick="openDialog('修改村走访收入信息', '${ctx}/bfll/jiangsuAd30/form?id=${jiangsuAd30.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:jiangsuAd30:del">
						<a href="${ctx}/bfll/jiangsuAd30/delete?id=${jiangsuAd01.id}" onclick="return confirmx('确认要删除该村走访收入信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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