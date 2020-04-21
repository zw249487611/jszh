<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>行政区划信息管理</title>
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
		<h5>行政区划信息列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAa11" action="${ctx}/bfll/jiangsuAa11/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>aaa011：</span>
				<form:input path="aaa011" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aar001：</span>
				<form:input path="aar001" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>aar009：</span>
				<form:input path="aar009" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<span>aaa113：</span>
				<form:input path="aaa113" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aaa112：</span>
				<form:input path="aaa112" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aaa114：</span>
				<form:input path="aaa114" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aaa115：</span>
				<form:input path="aaa115" htmlEscape="false" maxlength="30"  class=" form-control input-sm"/>
			<span>aar022：</span>
				<form:input path="aar022" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aar023：</span>
				<form:input path="aar023" htmlEscape="false" maxlength="50"  class=" form-control input-sm"/>
			<span>aar024：</span>
				<form:input path="aar024" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aar025：</span>
				<form:input path="aar025" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<span>aar033：</span>
				<form:input path="aar033" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/>
			<span>baz002：</span>
				<form:input path="baz002" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aaa116：</span>
				<form:input path="aaa116" htmlEscape="false"  class=" form-control input-sm"/>
			<span>aar008：</span>
				<form:input path="aar008" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>aaa117：</span>
				<form:input path="aaa117" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:jiangsuAa11:add">
				<table:addRow url="${ctx}/bfll/jiangsuAa11/form" title="行政区划信息"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAa11:edit">
			    <table:editRow url="${ctx}/bfll/jiangsuAa11/form" title="行政区划信息" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAa11:del">
				<table:delRow url="${ctx}/bfll/jiangsuAa11/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAa11:import">
				<table:importExcel url="${ctx}/bfll/jiangsuAa11/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAa11:export">
	       		<table:exportExcel url="${ctx}/bfll/jiangsuAa11/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column aaa011">aaa011</th>
				<th  class="sort-column aar001">aar001</th>
				<th  class="sort-column aar009">aar009</th>
				<th  class="sort-column aaa113">aaa113</th>
				<th  class="sort-column aaa112">aaa112</th>
				<th  class="sort-column aaa114">aaa114</th>
				<th  class="sort-column aaa115">aaa115</th>
				<th  class="sort-column aar022">aar022</th>
				<th  class="sort-column aar023">aar023</th>
				<th  class="sort-column aar024">aar024</th>
				<th  class="sort-column aar025">aar025</th>
				<th  class="sort-column aar033">aar033</th>
				<th  class="sort-column baz002">baz002</th>
				<th  class="sort-column aaa116">aaa116</th>
				<th  class="sort-column aar008">aar008</th>
				<th  class="sort-column aaa117">aaa117</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAa11">
			<tr>
				<td> <input type="checkbox" id="${jiangsuAa11.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看行政区划信息', '${ctx}/bfll/jiangsuAa11/form?id=${jiangsuAa11.id}','800px', '500px')">
					${jiangsuAa11.aaa011}
				</a></td>
				<td>
					${jiangsuAa11.aar001}
				</td>
				<td>
					${jiangsuAa11.aar009}
				</td>
				<td>
					${jiangsuAa11.aaa113}
				</td>
				<td>
					${jiangsuAa11.aaa112}
				</td>
				<td>
					${jiangsuAa11.aaa114}
				</td>
				<td>
					${jiangsuAa11.aaa115}
				</td>
				<td>
					${jiangsuAa11.aar022}
				</td>
				<td>
					${jiangsuAa11.aar023}
				</td>
				<td>
					${jiangsuAa11.aar024}
				</td>
				<td>
					${jiangsuAa11.aar025}
				</td>
				<td>
					${jiangsuAa11.aar033}
				</td>
				<td>
					${jiangsuAa11.baz002}
				</td>
				<td>
					${jiangsuAa11.aaa116}
				</td>
				<td>
					${jiangsuAa11.aar008}
				</td>
				<td>
					${jiangsuAa11.aaa117}
				</td>
				<td>
					<shiro:hasPermission name="bfll:jiangsuAa11:view">
						<a href="#" onclick="openDialogView('查看行政区划信息', '${ctx}/bfll/jiangsuAa11/form?id=${jiangsuAa11.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:jiangsuAa11:edit">
    					<a href="#" onclick="openDialog('修改行政区划信息', '${ctx}/bfll/jiangsuAa11/form?id=${jiangsuAa11.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:jiangsuAa11:del">
						<a href="${ctx}/bfll/jiangsuAa11/delete?id=${jiangsuAa11.id}" onclick="return confirmx('确认要删除该行政区划信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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