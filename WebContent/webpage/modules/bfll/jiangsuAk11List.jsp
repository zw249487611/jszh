<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶责任人管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			if ($("#xqSelect").find("option").size() == 1) {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: '320800000000'}, function (data) {
					if (data.success) {
						var $xqSelect = $("#xqSelect");
						$xqSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item) {
							$xqSelect.append($("<option/>").val(item.aar001).text(item.aar009));
						});
					} else {
						
					}
				});
			}
			
			$("#xqSelect").on("change", function () {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: $(this).val()}, function (data) {
					if (data.success) {
						var $xzSelect = $("#xzSelect");
						$xzSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item){
							$xzSelect.append($("<option/>").val(item.aar001).text(item.aar009));
						});
					} else {
						
					}
				});
			});
			
			$("#xzSelect").on("change", function () {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: $(this).val()}, function (data) {
					if (data.success) {
						var $cjSelect = $("#cjSelect");
						$cjSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item) {
							$cjSelect.append($("<option/>").val(item.aar001).text(item.aar009));
						});
					} else {
						
					}
				});
			});
		});
		function goExport(){
				window.location.href="${ctx}/bfll/jiangsuAk11/exportRule";
		}
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>帮扶责任人列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAk11" action="${ctx}/bfll/jiangsuAk11/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group" id="areaSelectDiv">
			<%-- <span>帮扶单位：</span>
				<form:input path="aap110" htmlEscape="false"  class=" form-control input-sm"/> --%>
			<span>姓名：</span>
				<form:input path="aab002" htmlEscape="false" maxlength="50"  class=" form-control input-sm"/>
			<%-- <span>性别：</span>
				<form:input path="aab003" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/> --%>
			<span>证件号码：</span>
				<form:input path="aab004" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>联系电话：</span>
				<form:input path="aar012" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<%-- <span>单位名称：</span>
				<form:input path="aap001" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/> --%>
			<%-- <span>队长标志：</span>
				<form:input path="aaf031" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/> --%>
				<form:hidden path="currentAreaId" />
				<span>县区：</span> <select id="4_area" name="4_area"
					class="form-control areaCascadeSelect" style="width: 130px">
				</select> <span>乡镇：</span> <select id="5_area" name="5_area"
					class="form-control areaCascadeSelect" style="width: 130px">
				</select> <span>村：</span> <select id="6_area" name="6_area"
					class="form-control areaCascadeSelect" style="width: 130px">
				</select>
			</div>
		 	<br/>
			<span>是否结对：</span>
			<form:select path="sfjd" class="form-control ">
				<form:option value="" label="--请选择--"/>
				<form:option value="1" label="是"/>
				<form:option value="0" label="否"/>
			</form:select>
		 	<span>结对户数：</span>
			<form:input path="jdhs" htmlEscape="false" maxlength="20" class=" form-control number input-sm"/>
	</form:form>
	</div>	
	<br/>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="bfll:jiangsuAk11:add">
				<table:addRow url="${ctx}/bfll/jiangsuAk11/form" title="帮扶责任人"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<%-- <shiro:hasPermission name="bfll:jiangsuAk11:edit">
			    <table:editRow url="${ctx}/bfll/jiangsuAk11/form" title="帮扶责任人" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="bfll:jiangsuAk11:del">
				<table:delRow url="${ctx}/bfll/jiangsuAk11/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<%-- <shiro:hasPermission name="bfll:jiangsuAk11:import">  --%>
				<%-- <table:importExcel url="${ctx}/bfll/jiangsuAk11/import"></table:importExcel> --%><!-- 导入按钮 -->
			<%-- </shiro:hasPermission> --%>
			
<%-- 			<shiro:hasPermission name="bfll:jiangsuAk11:export"> --%>
<%-- 	       		<table:exportExcel url="${ctx}/bfll/jiangsuAk11/export"></table:exportExcel><!-- 导出按钮 --> --%>
<%-- 	       	</shiro:hasPermission> --%>
	       	
	       	<shiro:hasPermission name="bfll:jiangsuAk11:exportBfzrr">
	       		<table:exportExcel url="${ctx}/bfll/jiangsuAk11/exportBfzrr"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
			<!-- <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="goExport()" title="导入规则"> 导入规则</button> -->
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
				<th  class="sort-column sfjd">是否结对</th>
				<th  class="sort-column jdhs">结对户数</th>
				<!--  th  class="sort-column isnpc">是否人大代表</th>-->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAk11">
			<tr>
				<td> <input type="checkbox" id="${jiangsuAk11.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看帮扶责任人', '${ctx}/bfll/jiangsuAk11/form?id=${jiangsuAk11.id}','800px', '500px')">
					${jiangsuAk11.aap110}
					<c:forEach items="${jiangsuAp11s }" var="jiangsuAp11">
						<c:if test="${jiangsuAp11.id=jiangsuAk11.aap110 }">${jiangsuAp11.aap001 }</c:if>
					</c:forEach>
				</a></td> --%>
				<td>
					${jiangsuAk11.aab002}
				</td>
				<td>
					<%-- ${fns:getDictLabel(jiangsuAk11.aab003, 'lsgx', '')} --%>
					
					<c:if test="${jiangsuAk11.aab003=='1'}">男</c:if>
					<c:if test="${jiangsuAk11.aab003=='2'}">女</c:if>
				</td>
				<td>
					${jiangsuAk11.aab004}
				</td>
				<td>
					${jiangsuAk11.aar012}
				</td>
				<%-- <td>
					${jiangsuAk11.aar013}
				</td>
				<td>
					${jiangsuAk11.aap001}
				</td>
				<td>
					${fns:getDictLabel(jiangsuAk11.aap004, 'lsgx', '')}
					${jiangsuAk11.aap004}
				</td>
				<td>
					<fmt:formatDate value="${jiangsuAk11.aab005}" pattern="yyyy-MM-dd"/>
				</td> --%>
				<td>
				<%-- 	${jiangsuAk11.aaf031} --%>
					${fns:getDictLabel(jiangsuAk11.aaf031, 'joblevel', '')}
				</td>
				<td>
				    ${jiangsuAk11.aap001}
				</td>
				<td>
					${jiangsuAk11.aap051}
				</td>
				<td>
					${jiangsuAk11.aap004}
				</td>
				<td>
					${jiangsuAk11.sfjd}
				</td>
				<td>
					${jiangsuAk11.jdhs}
				</td>
			 <!--
				<td>
					${fns:getDictLabel(jiangsuAk11.isnpc, 'ISNPC', '')}
				</td>-->
				<td>
					<shiro:hasPermission name="bfll:jiangsuAk11:view">
						<a href="#" onclick="openDialogView('查看帮扶责任人', '${ctx}/bfll/jiangsuAk11/form?id=${jiangsuAk11.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:jiangsuAk11:edit">
    					<a href="#" onclick="openDialog('修改帮扶责任人', '${ctx}/bfll/jiangsuAk11/form?id=${jiangsuAk11.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>修改</a>
    				</shiro:hasPermission>
    				    <a href="#" onclick="openDialog('查看已结对贫困户', '${ctx}/bfll/jiangsuAk11/getbfpkh?id=${jiangsuAk11.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>查看结对贫困户</a>
<%--     				    <a href="#" onclick="openDialog('增加已结对贫困户', '${ctx}/bfll/jiangsuAk11/addpkh?id=${jiangsuAk11.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>增加结对贫困户</a> --%>
    				<shiro:hasPermission name="bfll:jiangsuAk11:del">
						<a href="${ctx}/bfll/jiangsuAk11/delete?id=${jiangsuAk11.id}" onclick="return confirmx('确认要删除该帮扶责任人吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:jiangsuAk11:reset">
						<a href="${ctx}/bfll/jiangsuAk11/reset?id=${jiangsuAk11.id}" onclick="return confirmx('确认要重置密码吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-edit"></i> 重置密码</a>
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