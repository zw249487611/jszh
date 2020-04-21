<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况管理</title>
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
		<h5>市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况列表 </h5>
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
	<form:form id="searchForm" modelAttribute="tLdbfz" action="${ctx}/bfll/tLdbfz/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>村(作为外键)：</span>
				<form:input path="adid" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>市县乡联动组组成人员：</span>
				<form:input path="zcry" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>市县乡联动组参与产业扶贫情况：</span>
				<form:input path="cycyfpqk" htmlEscape="false" maxlength="1000"  class=" form-control input-sm"/>
			<span>乡镇扶贫专干、村扶贫书记（主任）人员情况：</span>
				<form:input path="fpryqk" htmlEscape="false" maxlength="1000"  class=" form-control input-sm"/>
			<span>乡镇扶贫专干、村扶贫书记（主任）参与产业扶贫情况：</span>
				<form:input path="zgcyfpqk" htmlEscape="false" maxlength="1000"  class=" form-control input-sm"/>
			<span>村民服务中心面积：</span>
				<form:input path="cmfwzxmj" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>村民服务中心具备功能：</span>
				<form:input path="cmfwzxjbgn" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>村民服务中心使用情况：</span>
				<form:input path="cmfwzxsyqk" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span> 备注：</span>
				<form:input path="bz" htmlEscape="false" maxlength="1000"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:tLdbfz:add">
				<table:addRow url="${ctx}/bfll/tLdbfz/form" title="市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tLdbfz:edit">
			    <table:editRow url="${ctx}/bfll/tLdbfz/form" title="市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tLdbfz:del">
				<table:delRow url="${ctx}/bfll/tLdbfz/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tLdbfz:import">
				<table:importExcel url="${ctx}/bfll/tLdbfz/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tLdbfz:export">
	       		<table:exportExcel url="${ctx}/bfll/tLdbfz/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column adid">村(作为外键)</th>
				<th  class="sort-column zcry">市县乡联动组组成人员</th>
				<th  class="sort-column cycyfpqk">市县乡联动组参与产业扶贫情况</th>
				<th  class="sort-column fpryqk">乡镇扶贫专干、村扶贫书记（主任）人员情况</th>
				<th  class="sort-column zgcyfpqk">乡镇扶贫专干、村扶贫书记（主任）参与产业扶贫情况</th>
				<th  class="sort-column cmfwzxmj">村民服务中心面积</th>
				<th  class="sort-column cmfwzxjbgn">村民服务中心具备功能</th>
				<th  class="sort-column cmfwzxsyqk">村民服务中心使用情况</th>
				<th  class="sort-column bz"> 备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tLdbfz">
			<tr>
				<td> <input type="checkbox" id="${tLdbfz.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况', '${ctx}/bfll/tLdbfz/form?id=${tLdbfz.id}','800px', '500px')">
					${tLdbfz.adid}
				</a></td>
				<td>
					${tLdbfz.zcry}
				</td>
				<td>
					${tLdbfz.cycyfpqk}
				</td>
				<td>
					${tLdbfz.fpryqk}
				</td>
				<td>
					${tLdbfz.zgcyfpqk}
				</td>
				<td>
					${tLdbfz.cmfwzxmj}
				</td>
				<td>
					${tLdbfz.cmfwzxjbgn}
				</td>
				<td>
					${tLdbfz.cmfwzxsyqk}
				</td>
				<td>
					${tLdbfz.bz}
				</td>
				<td>
					<shiro:hasPermission name="bfll:tLdbfz:view">
						<a href="#" onclick="openDialogView('查看市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况', '${ctx}/bfll/tLdbfz/form?id=${tLdbfz.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:tLdbfz:edit">
    					<a href="#" onclick="openDialog('修改市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况', '${ctx}/bfll/tLdbfz/form?id=${tLdbfz.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:tLdbfz:del">
						<a href="${ctx}/bfll/tLdbfz/delete?id=${tLdbfz.id}" onclick="return confirmx('确认要删除该市县乡联动帮扶组参与产业扶贫和村民服务中心建设情况吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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