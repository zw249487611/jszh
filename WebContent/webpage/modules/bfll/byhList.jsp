<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>边缘户管理</title>
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
		<h5>边缘户列表 </h5>
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
	<form:form id="searchForm" modelAttribute="byh" action="${ctx}/bfll/byh/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div id="areaSelectDiv" class="form-group">
			<span>户主姓名：</span>
				<form:input path="hzxm" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>身份证号：</span>
				<form:input path="sfzh" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>手机号：</span>
				<form:input path="sjh" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>年度：</span>
			
				<select name="nd" class="form-control ">
											<option value=""  <c:if test="${nd=='' }">selected="selected"</c:if>>--请选择--</option>
											<option value="2017" <c:if test="${nd=='2017' }">selected="selected"</c:if> >2017</option>
											<option value="2016" <c:if test="${nd=='2016' }">selected="selected"</c:if> >2016</option>
											<option value="2015" <c:if test="${nd=='2015' }">selected="selected"</c:if> >2015</option>
				</select>
				<form:hidden path="currentAreaId" />
			<span>县区：</span>
			<select id="4_area" name="4_area" class="form-control areaCascadeSelect" style="width:130px">
			</select>
			<span>乡镇：</span>
			<select id="5_area" name="5_area" class="form-control areaCascadeSelect" style="width:130px">
			</select>
			<span>村：</span>
			<select id="6_area" name="6_area" class="form-control areaCascadeSelect" style="width:130px">
			</select>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:byh:add">
				<table:addRow url="${ctx}/bfll/byh/form" title="边缘户"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:byh:edit">
			    <table:editRow url="${ctx}/bfll/byh/form" title="边缘户" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:byh:del">
				<table:delRow url="${ctx}/bfll/byh/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:byh:import">
				<table:importExcel url="${ctx}/bfll/byh/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:byh:export">
	       		<table:exportExcel url="${ctx}/bfll/byh/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column hzxm">户主姓名</th>
				<th  class="sort-column sfzh">身份证号</th>
				<th  class="sort-column sjh">手机号</th>
				<th  class="sort-column nd">年度</th>
				<th  class="sort-column xq">县区</th>
				<th  class="sort-column xz">乡镇</th>
				<th  class="sort-column cj">村居</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="byh">
			<tr>
				<td> <input type="checkbox" id="${byh.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看边缘户', '${ctx}/bfll/byh/form?id=${byh.id}','800px', '500px')">
					${byh.hzxm}
				</a></td>
				<td>
					${byh.sfzh}
				</td>
				<td>
					${byh.sjh}
				</td>
				<td>
					${byh.nd}
				</td>
				<td>
					${byh.xqName}
				</td>
				<td>
					${byh.xzName}
				</td>
				<td>
					${byh.cjName}
				</td>
				<td>
					<shiro:hasPermission name="bfll:byh:view">
						<a href="#" onclick="openDialogView('查看边缘户', '${ctx}/bfll/byh/form?id=${byh.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:byh:edit">
    					<a href="#" onclick="openDialog('修改边缘户', '${ctx}/bfll/byh/form?id=${byh.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:byh:del">
						<a href="${ctx}/bfll/byh/delete?id=${byh.id}" onclick="return confirmx('确认要删除该边缘户吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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