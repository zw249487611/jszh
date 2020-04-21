<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>正在实施产业项目情况管理</title>
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
		<h5>2017年已实施项目 </h5>
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
	<form:form id="searchForm" modelAttribute="tZzsscyxmqk" action="${ctx}/bfll/tZzsscyxmqk/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		<!--  
			<span>村(作为外键)：</span>
				<form:input path="adid" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>项目名称：</span>
				<form:input path="xmmc" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>项目地点：</span>
				<form:input path="xmdd" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>项目主要内容：</span>
				<form:input path="xmzynr" htmlEscape="false" maxlength="5000"  class=" form-control input-sm"/>
			<span>目前实施进度：</span>
				<form:input path="mqssjd" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>资金来源(万元)-省级以上：</span>
				<form:input path="shengjys" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>资金来源(万元)-省级：</span>
				<form:input path="shengj" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>资金来源(万元)-市级：</span>
				<form:input path="shij" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>资金来源(万元)-县级以下：</span>
				<form:input path="xianjyx" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>资金来源(万元)-自筹：</span>
				<form:input path="zic" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>项目实施单位：</span>
				<form:input path="xmssdw" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>-->
			<div class="form-group mar-bom mar-lft">
				<span>县区：</span>
				<select id="xqSelect" name="xq" class="form-control " style="width: 110px;">
					<option value="">--请选择--</option>
					<c:if test="${not empty xqList }">
						<c:forEach items="${xqList }" var="xq">
							<option value="${xq.aar001 }" ${tZzsscyxmqk.xq eq xq.aar001 ? "selected='selected'" : "" }>${xq.aar009 }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="form-group mar-bom mar-lft">
				<span>乡镇：</span>
				<select id="xzSelect" name="xz" class="form-control" style="width: 150px;">
					<option value="">--请选择--</option>
					<c:if test="${not empty xzList }">
						<c:forEach items="${xzList }" var="xz">
							<option value="${xz.aar001 }" ${tZzsscyxmqk.xz eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
						</c:forEach>
					</c:if>
				</select>
			</div>
			<div class="form-group mar-bom mar-lft">
				<span>村居：</span>
				<select id="cjSelect" name="cj" class="form-control" style="width: 150px;">
					<option value="">--请选择--</option>
					<c:if test="${not empty cjList }">
						<c:forEach items="${cjList }" var="cj">
							<option value="${cj.aar001 }" ${tZzsscyxmqk.cj eq cj.aar001 ? "selected='selected'" : "" }>${cj.aar009 }</option>
						</c:forEach>
					</c:if>
				</select>
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
			<shiro:hasPermission name="bfll:tZzsscyxmqk:add">
				<table:addRow url="${ctx}/bfll/tZzsscyxmqk/form" title="正在实施产业项目情况"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tZzsscyxmqk:edit">
			    <table:editRow url="${ctx}/bfll/tZzsscyxmqk/form" title="正在实施产业项目情况" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tZzsscyxmqk:del">
				<table:delRow url="${ctx}/bfll/tZzsscyxmqk/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tZzsscyxmqk:import">
				<table:importExcel url="${ctx}/bfll/tZzsscyxmqk/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="bfll:tZzsscyxmqk:export">
	       		<table:exportExcel url="${ctx}/bfll/tZzsscyxmqk/export"></table:exportExcel><!-- 导出按钮 -->
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
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable" style="table-layout: fixed;">
		<thead>
			<tr >
				<th rowspan="2"> <input type="checkbox"  class="i-checks"></th>
				<th class="sort-column xq" rowspan="2">县区</th>
	            <th class="sort-column xz" rowspan="2">乡镇</th>
	            <th class="sort-column cj" rowspan="2">村</th>
				<!-- <th  class="sort-column adid" rowspan="2" >村(作为外键)</th> -->
				<th  class="sort-column xmmc" rowspan="2">项目名称</th>
				<th  class="sort-column xmdd" rowspan="2">项目地点</th>
				<th  class="sort-column xmssdw" rowspan="2">项目实施单位</th>
				<th  class="sort-column xmzynr" rowspan="2">项目主要内容</th>
				<th  class="sort-column mqssjd" rowspan="2">目前实施进度</th>
				<th  class="sort-column shengjys" colspan="4" style="text-align: center;">资金来源(万元)</th>
				<th rowspan="2" >操作</th>
			</tr>
			<tr>
				<th  class="sort-column shengjys">省级及以上</th>
				<!--  <th  class="sort-column shengj" >省级</th>-->
				<th  class="sort-column shij" >市级</th>
				<th  class="sort-column xianjyx">县级及以下</th>
				<th  class="sort-column zic">自筹</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tZzsscyxmqk">
			<tr>
				<td> <input type="checkbox" id="${tZzsscyxmqk.id}" class="i-checks"></td>
				<td>${tZzsscyxmqk.xq }</td>
				<td>${tZzsscyxmqk.xz }</td>
				<td>
				<a  href="#" onclick="openDialogView('2017年已实施项目', '${ctx}/bfll/tZzsscyxmqk/form?id=${tZzsscyxmqk.id}','800px', '500px')">
				${tZzsscyxmqk.cj }
				</a>
				</td>
				<!-- 
				<td><a  href="#" onclick="openDialogView('查看正在实施产业项目情况', '${ctx}/bfll/tZzsscyxmqk/form?id=${tZzsscyxmqk.id}','800px', '500px')">
					${tZzsscyxmqk.adid}
				</a></td>
				 -->
				<td>
					${tZzsscyxmqk.xmmc}
				</td>
				<td>
					${tZzsscyxmqk.xmdd}
				</td>
				<td>
					${tZzsscyxmqk.xmssdw}
				</td>
				<td style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
					${tZzsscyxmqk.xmzynr}
				</td>
				<td style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden;">
					${tZzsscyxmqk.mqssjd}
				</td>
				<td>
					${tZzsscyxmqk.shengjys}
				</td>
				<!--  
				<td>
					${tZzsscyxmqk.shengj}
				</td>
				-->
				<td>
					${tZzsscyxmqk.shij}
				</td>
				<td>
					${tZzsscyxmqk.xianjyx}
				</td>
				<td>
					${tZzsscyxmqk.zic}
				</td>
				<td>
					<shiro:hasPermission name="bfll:tZzsscyxmqk:view">
						<a href="#" onclick="openDialogView('2017年已实施项目', '${ctx}/bfll/tZzsscyxmqk/form?id=${tZzsscyxmqk.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="bfll:tZzsscyxmqk:edit">
    					<a href="#" onclick="openDialog('修改正在实施产业项目情况', '${ctx}/bfll/tZzsscyxmqk/form?id=${tZzsscyxmqk.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="bfll:tZzsscyxmqk:del">
						<a href="${ctx}/bfll/tZzsscyxmqk/delete?id=${tZzsscyxmqk.id}" onclick="return confirmx('确认要删除该正在实施产业项目情况吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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