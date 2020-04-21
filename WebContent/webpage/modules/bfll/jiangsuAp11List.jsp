<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶单位信息管理</title>
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
		<h5>帮扶单位信息列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAp11" action="${ctx}/bfll/jiangsuAp11/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div id="areaSelectDiv" class="form-group">
		<div class="form-group">
			
			<span>单位名称：</span>
				<form:input path="aap001" htmlEscape="false" maxlength="100"   style="width:130px;margin-right:5px"   class=" form-control input-sm"/>
			<!--  
			<span>联系人姓名：</span>
				<form:input path="aar011" htmlEscape="false" maxlength="10"  style="width:100px;margin-right:5px" class=" form-control input-sm"/>
			<span>联系电话：</span>
				<form:input path="aar012" htmlEscape="false" maxlength="15"  style="width:120px;margin-right:5px" class=" form-control input-sm"/>-->
			<span>帮扶单位类型：</span>
				<form:select path="aap051"  class="form-control m-b" style="margin-right:5px">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('bfdwlx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			<span>县区：</span>
			<form:select path="currentAreaId" class="form-control m-b">
					<option value="">--请选择--</option>
					<form:options items="${xqMap}" />
				</form:select> 

		 </div>	
		 </div>
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:jiangsuAp11:add">
				<table:addRow url="${ctx}/bfll/jiangsuAp11/form" title="帮扶单位信息"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAp11:del">
				<table:delRow url="${ctx}/bfll/jiangsuAp11/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAp11:import">
				<table:importExcel url="${ctx}/bfll/jiangsuAp11/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAp11:export">
	       		<table:exportExcel url="${ctx}/bfll/jiangsuAp11/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th nowrap="nowrap" class="sort-column aap051">帮扶单位类型</th>
				<th nowrap="nowrap" class="sort-column aap001">单位名称</th>
				<th nowrap="nowrap" class="sort-column aap004">隶属关系</th>
				<th nowrap="nowrap" class="sort-column aar016">是否后台支持部门</th>
				<!--  
				<th nowrap="nowrap" class="sort-column aap002">单位地址</th>
				<th nowrap="nowrap" class="sort-column aap003">组织机构代码</th>
				<th nowrap="nowrap" class="sort-column aap004">隶属关系</th>
				<th nowrap="nowrap" class="sort-column aar011">联系人姓名</th>
				<th nowrap="nowrap" class="sort-column aar012">联系电话</th>
				<th nowrap="nowrap" class="sort-column aar013">联系地址</th>
				<th nowrap="nowrap" class="sort-column aar014">邮政编码</th>
				<th nowrap="nowrap" class="sort-column aar015">电子邮箱</th>-->
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAp11">
			<tr>
				<td> <input type="checkbox" id="${jiangsuAp11.id}" class="i-checks"></td>
				<td>
					${fns:getDictLabel(jiangsuAp11.aap051, 'bfdwlx', '')}
				</td>
				<td>
					${jiangsuAp11.aap001}
				</td>
				<td>
					${fns:getDictLabel(jiangsuAp11.aap004, 'lsgx', '')}
				</td>
				<td>
					${fns:getDictLabel(jiangsuAp11.aar016, 'yes_no', '')}
				</td>
				<!--  
				<td>
					${jiangsuAp11.aap002}
				</td>
				<td>
					${jiangsuAp11.aap003}
				</td>
				<td>
					${fns:getDictLabel(jiangsuAp11.aap004, 'lsgx', '')}
				</td>
				<td>
					${jiangsuAp11.aar011}
				</td>
				<td>
					${jiangsuAp11.aar012}
				</td>
				<td>
					${jiangsuAp11.aar013}
				</td>
				<td>
					${jiangsuAp11.aar014}
				</td>
				<td>
					${jiangsuAp11.aar015}
				</td>
				-->
				<td>
					<shiro:hasPermission name="bfll:jiangsuAp11:view">
						<a style="margin-bottom:2px" href="#" onclick="openDialogView('查看帮扶单位信息', '${ctx}/bfll/jiangsuAp11/form?id=${jiangsuAp11.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i>查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:jiangsuAp11:edit">
    					<a style="margin-bottom:2px" href="#" onclick="openDialog('修改帮扶单位信息', '${ctx}/bfll/jiangsuAp11/form?id=${jiangsuAp11.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:jiangsuAp11:del">
						<a href="${ctx}/bfll/jiangsuAp11/delete?id=${jiangsuAp11.id}" onclick="return confirmx('确认要删除该帮扶单位信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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