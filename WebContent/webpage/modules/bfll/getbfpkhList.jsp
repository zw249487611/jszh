<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>查看已结对贫困户</title>
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
		<h5>已结对贫困户列表 </h5>
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
	<%-- <div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="jiangsuAk11" action="${ctx}/bfll/jiangsuAk11/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>帮扶单位：</span>
				<form:input path="aap110" htmlEscape="false"  class=" form-control input-sm"/>
			<span>姓名：</span>
				<form:input path="aab002" htmlEscape="false" maxlength="50"  class=" form-control input-sm"/>
			<span>性别：</span>
				<form:input path="aab003" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/>
			<span>证件号码：</span>
				<form:input path="aab004" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>联系电话：</span>
				<form:input path="aar012" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>单位名称：</span>
				<form:input path="aap001" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<span>队长标志：</span>
				<form:input path="aaf031" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div> --%>
	
	<!-- 工具栏 -->
	<%-- <div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:jiangsuAk11:add">
				<table:addRow url="${ctx}/bfll/jiangsuAk11/form" title="帮扶责任人"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAk11:edit">
			    <table:editRow url="${ctx}/bfll/jiangsuAk11/form" title="帮扶责任人" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAk11:del">
				<table:delRow url="${ctx}/bfll/jiangsuAk11/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAk11:import">
				<table:importExcel url="${ctx}/bfll/jiangsuAk11/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAk11:export">
	       		<table:exportExcel url="${ctx}/bfll/jiangsuAk11/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div> --%>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th  class="sort-column">姓名</th>
				<th  class="sort-column">证件号码</th>
				<th  class="sort-column">乡镇</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${jiangsuAb01s}" var="jiangsuAb01">
			<tr>
			    <td class="sort-column">${jiangsuAb01.aab002 }</td>
			    <td class="sort-column">${jiangsuAb01.aab004 }</td>
			    <td class="sort-column">${jiangsuAb01.aar025 }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- 分页代码 -->
	<%-- <table:page page="${page}"></table:page> --%>
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>