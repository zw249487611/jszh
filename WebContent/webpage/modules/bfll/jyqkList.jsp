<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>就业情况管理</title>
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
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>就业情况列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jyqk" action="${ctx}/bfll/jyqk/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div id="areaSelectDiv" class="form-group">
			<%-- <span>帮扶单位：</span>
				<form:input path="aap110" htmlEscape="false"  class=" form-control input-sm"/> --%>
			<span>姓名：</span>
				<form:input path="xm" htmlEscape="false" maxlength="50"  class=" form-control input-sm"/>
			<%-- <span>性别：</span>
				<form:input path="aab003" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/> --%>
			<span>身份证号：</span>
				<form:input path="sfzh" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
				
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
		 	<br/>
	</form:form>
	</div>	
	<br/>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
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
				<th  class="sort-column xqname">县区</th>
				<th  class="sort-column xzname">乡镇</th>
				<th  class="sort-column cjname">村居</th>
				<th  class="sort-column xm">姓名</th>
				<th  class="sort-column sfzh">身份证号</th>
				<th  class="sort-column jydw">就业单位</th>
				<th  class="sort-column rzsj">入职时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jyqk">
			<tr>
				<td> <input type="checkbox" id="${jyqk.id}" class="i-checks"></td>
				<td>
					${jyqk.xqname}
				</td>
				<td>
					${jyqk.xzname}
				</td>
				<td>
					${jyqk.cjname}
				</td>
				<td>
					${jyqk.xm}
				</td>
				<td>
					${jyqk.sfzh}
				</td>
				<td>
					${jyqk.jydw}
				</td>
				<td>
				    ${jyqk.rzsj}
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