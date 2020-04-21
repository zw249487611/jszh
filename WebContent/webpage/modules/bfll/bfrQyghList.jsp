<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶责任人查询管理</title>
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
		<h5>帮扶责任人查询列表 </h5>
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
	<form:form id="searchForm" modelAttribute="bfrQygh" action="${ctx}/bfll/bfrQygh/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>姓名:</span>
				<form:input path="aab002" htmlEscape="false" maxlength="50"  class=" form-control input-sm"/>
			<span>联系方式：</span>
				<form:input path="lxfs" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<!--  
			<span>证件号码：</span>
				<form:input path="zjhm" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>-->
			<span>县区名称：</span>
				<form:input path="xqname" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<span>乡镇名称</span>
				<form:input path="xzname" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<%-- <div class="pull-left">
			<shiro:hasPermission name="bfll:bfrQygh:add">
				<table:addRow url="${ctx}/bfll/bfrQygh/form" title="帮扶责任人查询"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:bfrQygh:edit">
			    <table:editRow url="${ctx}/bfll/bfrQygh/form" title="帮扶责任人查询" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:bfrQygh:del">
				<table:delRow url="${ctx}/bfll/bfrQygh/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:bfrQygh:import">
				<table:importExcel url="${ctx}/bfll/bfrQygh/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:bfrQygh:export">
	       		<table:exportExcel url="${ctx}/bfll/bfrQygh/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div> --%>
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
				<!-- <th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column akid">akid</th>
				<th  class="sort-column aab002">aab002</th>
				<th  class="sort-column xzid">xzid</th>
				<th  class="sort-column xzname">xzname</th>
				<th  class="sort-column xqid">xqid</th>
				<th  class="sort-column xqname">xqname</th>
				<th  class="sort-column lxfs">lxfs</th>
				<th  class="sort-column zjhm">zjhm</th> -->
				<!-- <th>操作</th> -->
				<th> <input type="checkbox" class="i-checks"></th>
				<!-- <th  class="sort-column aap110">帮扶单位编号</th> -->
				<th  class="sort-column aab002">姓名</th>
				<th  class="sort-column aab003">性别</th>
				<th  class="sort-column aab004">证件号码</th>
				<th  class="sort-column aar012">联系电话</th>
				<!-- <th  class="sort-column aar013">单位地址</th>
				<th  class="sort-column aap001">单位名称</th> -->
				<!-- <th  class="sort-column aap004">隶属关系</th>
				<th  class="sort-column aab005">出生日期</th> -->
				<th  class="sort-column aaf031">职务级别</th>
				<th  class="sort-column aap001">帮扶单位名称</th>
				<th  class="sort-column aap051">帮扶单位类型</th>
				<th  class="sort-column aap004">隶属关系</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bfrQygh">
			<tr>
				<td> <input type="checkbox" id="${bfrQygh.id}" class="i-checks"></td>
				<td>
					${bfrQygh.jiangsuAk11.aab002}
				</td>
				<td>
					<c:if test="${bfrQygh.jiangsuAk11.aab003=='1'}">男</c:if>
					<c:if test="${bfrQygh.jiangsuAk11.aab003=='2'}">女</c:if>
				</td>
				<td>
					${bfrQygh.jiangsuAk11.aab004}
				</td>
				<td>
					${bfrQygh.jiangsuAk11.aar012}
				</td>
				<td>
					${fns:getDictLabel(bfrQygh.jiangsuAk11.aaf031, 'joblevel', '')}
				</td>
				<td>
				    ${bfrQygh.jiangsuAk11.aap001}
				</td>
				<td>
				    ${bfrQygh.jiangsuAk11.aap051}
				</td>
				<td>
				    ${bfrQygh.jiangsuAk11.aap004}
				</td>
				<%-- <td><a  href="#" onclick="openDialogView('查看帮扶责任人查询', '${ctx}/bfll/bfrQygh/form?id=${bfrQygh.id}','800px', '500px')">
					${bfrQygh.akid}
				</a></td>
				<td>
					${bfrQygh.aab002}
				</td>
				<td>
					${bfrQygh.xzid}
				</td>
				<td>
					${bfrQygh.xzname}
				</td>
				<td>
					${bfrQygh.xqid}
				</td>
				<td>
					${bfrQygh.xqname}
				</td>
				<td>
					${bfrQygh.lxfs}
				</td>
				<td>
					${bfrQygh.zjhm}
				</td> --%>
				<%-- <td>
					<shiro:hasPermission name="bfll:bfrQygh:view">
						<a href="#" onclick="openDialogView('查看帮扶责任人查询', '${ctx}/bfll/bfrQygh/form?id=${bfrQygh.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:bfrQygh:edit">
    					<a href="#" onclick="openDialog('修改帮扶责任人查询', '${ctx}/bfll/bfrQygh/form?id=${bfrQygh.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:bfrQygh:del">
						<a href="${ctx}/bfll/bfrQygh/delete?id=${bfrQygh.id}" onclick="return confirmx('确认要删除该帮扶责任人查询吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
				</td> --%>
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