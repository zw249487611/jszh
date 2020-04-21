<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>贫困户基本信息管理</title>
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
		<h5>贫困户基本信息列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAc01" action="${ctx}/bfll/jiangsuAc08/list1" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<div class="form-group">
					<span>年度：</span>
					<form:select path="year"  class="form-control m-b">
						<form:options items="${yearMap}"/>
					</form:select>
					<%-- <input id="year" name="year" type="text" maxlength="20" class="laydate-icon form-control layer-date required" value="${jiangsuAd01.year}"/> --%>
				</div>
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
				<div class="form-group">
					<span>姓名：</span>
					<input type="text" name="aab002" value="${jiangsuAc01.aab002}" class="form-control ">
				</div>
				<div class="form-group">
					<span>证件号码：</span>
					<input type="text" name="aab004" value="${jiangsuAc01.aab004}" class="form-control ">
				</div>
				<br/>
				<span>是否结对：</span>
					<select name="sfjd" class="form-control ">
						<option value="" ${jiangsuAc01.sfjd == "" ? "selected='selected'" : "" }>----</option>
						<option value="0" ${jiangsuAc01.sfjd == "0" ? "selected='selected'" : "" }>否</option>
						<option value="1" ${jiangsuAc01.sfjd == "1" ? "selected='selected'" : "" }>是</option>
					</select>
					
				<span>贫困户属性：</span>
					<form:select path="aac006"  class="form-control m-b">
						<form:option value="" label=""/>
						<form:options items="${fns:getDictList('pkhsx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				<span>是否需要结对：</span>
					<select name="xjd" class="form-control ">
						<option value="" ${jiangsuAc01.xjd == "" ? "selected='selected'" : "" }>----</option>
						<option value="0" ${jiangsuAc01.xjd == "0" ? "selected='selected'" : "" }>否</option>
						<option value="1" ${jiangsuAc01.xjd == "1" ? "selected='selected'" : "" }>是</option>
					</select>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	<div class="row" style="margin-bottom:10px;">
		<div class="col-sm-12">
			<div class="pull-left"
				style="font-size: 18px; font-weight: bold;margin-left:10px;">共${peoplecount}人</div>
		</div>
	</div>
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:jiangsuAb01:add">
				<table:addRow url="${ctx}/bfll/jiangsuAb01/form" title="贫困人口基本信息"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAb01:edit">
			    <table:editRow url="${ctx}/bfll/jiangsuAb01/form" title="贫困人口基本信息" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAb01:del">
				<table:delRow url="${ctx}/bfll/jiangsuAb01/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:jiangsuAb01:import">
				<table:importExcel url="${ctx}/bfll/jiangsuAb01/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
				 <shiro:hasPermission name="bfll:jiangsuAc08:export1"> 
	       		<table:exportExcel url="${ctx}/bfll/jiangsuAc08/export1"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column aac001">县区</th>
				<th  class="sort-column aac001">乡镇</th>
				<th  class="sort-column aac001">村居</th>
				<th  class="sort-column aac001">贫困户姓名</th>
				<th  class="sort-column aac001">证件号码</th>
				<th  class="sort-column aac001">是否结对</th>
				<th  class="sort-column aac001">贫困户属性</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAc01">
			<tr>
				
				<td> <input type="checkbox" id="${jiangsuAc01.id}" class="i-checks"></td>
				<td>
					${jiangsuAc01.xq }
				</td>
				<td>
					${jiangsuAc01.xz }
				</td>
				<td>
					${jiangsuAc01.cj }
				</td>
				<td>
					<%-- <input type="hidden" name="pkhId" value="${jiangsuAb01.acid }"> --%>
					${jiangsuAc01.aab002}
				</td>
				<td>
					<%-- <input type="hidden" name="pkhId" value="${jiangsuAb01.acid }"> --%>
					${jiangsuAc01.aab004}
				</td>
				<td>
					${jiangsuAc01.sfjd }
				</td>
				<td>
					   ${fns:getDictLabel(jiangsuAc01.aac006, 'pkhsx', '')}
				</td>
				<td>
					<%-- <shiro:hasPermission name="bfll:jiangsuAb01:view">
						<a href="#" onclick="openDialogView('查看贫困人口基本信息', '${ctx}/bfll/jiangsuAb01/form?id=${jiangsuAb01.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission> --%>
					<%-- <shiro:hasPermission name="bfll:jiangsuAb01:edit"> --%>
    					<a href="#" onclick="openDialog('贫困户与帮扶责任人结对', '${ctx}/bfll/jiangsuAk11/jiedui?pkhId=${jiangsuAc01.id }','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 帮扶责任人</a>
    				<%-- </shiro:hasPermission> --%>
    				<%-- <shiro:hasPermission name="bfll:jiangsuAb01:del">
						<a href="${ctx}/bfll/jiangsuAb01/delete?id=${jiangsuAb01.id}" onclick="return confirmx('确认要删除该贫困人口基本信息吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission> --%>
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