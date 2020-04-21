<!--经济薄弱村帮扶工作组: jjbrcbfgzz.jsp-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>经济薄弱村帮扶工作组</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			/**
			laydate({
	            elem: '#year', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	            format: 'YYYY',
	            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	        });*/
			
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
<body>
	<div class="row">
		<div class="col-sm-12">
			<form:form id="searchForm" modelAttribute="jiangsuAd01" action="${ctx}/bfll/jiangsuAd01/listWithPairInfo" method="post" class="form-inline">
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
				<div class="form-group">
					<span>年度：</span>
					<form:select path="year"  class="form-control m-b">
						<form:options items="${yearMap}"/>
					</form:select>
					<!-- 
					<input id="year" name="year" type="text" maxlength="20" class="laydate-icon form-control layer-date required" value="${jiangsuAd01.year}"/>
					 -->
				</div>
				<div class="form-group">
					<span>县区：</span>
					<select id="xqSelect" name="xq" class="form-control ">
						<option value="">--请选择--</option>
						<c:if test="${not empty xqList }">
							<c:forEach items="${xqList }" var="xq">
								<option value="${xq.aar001 }" ${jiangsuAd01.xq eq xq.aar001 ? "selected='selected'" : "" }>${xq.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="form-group">
					<span>乡镇：</span>
					<select id="xzSelect" name="xz" class="form-control ">
						<option value="">--请选择--</option>
						<c:if test="${not empty xzList }">
							<c:forEach items="${xzList }" var="xz">
								<option value="${xz.aar001 }" ${jiangsuAd01.xz eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="form-group">
					<span>村居：</span>
					<select id="cjSelect" name="cj" class="form-control ">
						<option value="">--请选择--</option>
						<c:if test="${not empty cjList }">
							<c:forEach items="${cjList }" var="cj">
								<option value="${cj.aar001 }" ${jiangsuAd01.cj eq cj.aar001 ? "selected='selected'" : "" }>${cj.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="pull-right">
					<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
					<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
				</div>
			</form:form>
			<br/>
		</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
		<div class="col-sm-12">
			<div class="pull-left">
				<shiro:hasPermission name="bfll:jiangsuAd01:import">
					<table:importExcel url="${ctx}/bfll/jiangsuAd01/import"></table:importExcel><!-- 导入按钮 -->
				</shiro:hasPermission>
		       	<button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
			</div>
		</div>
	</div>
	
	<table id="contentTable" class="table table-bordered table-hover table-condensed dataTables-example dataTable">
	    <thead>
	        <tr>
	            <th colspan="8" class="text-center">基本信息</th>
	            <th colspan="7" class="text-center">市县乡联动帮扶组成员单位及帮扶人员</th>
	            <th rowspan="2">财务辅导人员</th>
	            <th rowspan="2">法律援助人员</th>
	            <th rowspan="2">操作</th>
	        </tr>
	        <tr>
	            <th>县/区</th>
	            <th>乡/镇</th>
	            <th>村</th>
	            <th>类型</th>
	            <!-- <th>集体经济收入（万元）</th> -->
	            <th>低收入农户数</th>
	            <th>村党组织书记</th>
	            <th>村主任</th>
	            <th>村会计</th>
	            <th>帮扶牵头单位</th>
	            <th>帮扶组组长</th>
	            <th>帮扶组副组长</th>
	            <th>帮扶联络员</th>
	            <th>县区四套班子帮扶人</th>
	            <th>县区帮扶部门主要责任人</th>
	            <th>乡镇三套班子帮扶人</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${page.list}" var="jiangsuAd01">
				<tr>
					<td>${jiangsuAd01.xq }</td>
					<td>${jiangsuAd01.xz }</td>
					<td>${jiangsuAd01.cj }</td>
					<td>
						<c:choose>
							<c:when test="${jiangsuAd01.lx == '02'}">省定</c:when>
							<c:when test="${jiangsuAd01.lx == '03'}">市定</c:when>
						</c:choose>
					</td>
					<%-- <td><fmt:formatNumber value="${jiangsuAd01.jtjjsr }" type="number"/></td> --%>
					<td>${jiangsuAd01.dsrnhs }</td>
					<td>${jiangsuAd01.aad104 }</td>
					<td>${jiangsuAd01.aad106 }</td>
					<td>${jiangsuAd01.aad108 }</td>
					<td>${jiangsuAd01.bfqtdw }</td>
					<td>${jiangsuAd01.bfzzz }</td>
					<td>${jiangsuAd01.bfzfzz }</td>
					<td>${jiangsuAd01.bflly }</td>
					<td>${jiangsuAd01.xqstbzbfr }</td>
					<td>${jiangsuAd01.bfbmzyfzr }</td>
					<td>${jiangsuAd01.xzstbzbfr }</td>
					<td>${jiangsuAd01.cwfdr }</td>
					<td>${jiangsuAd01.flyzr }</td>
					<td>
						<c:if test="${isAdmin or areaId eq jiangsuAd01.xqId }">
							<shiro:hasPermission name="bfll:jiangsuAd01:edit">
								<a href="#" onclick="openDialog('修改经济薄弱村帮扶力量', '${ctx}/bfll/jiangsuAd01/formWithPairInfo?id=${jiangsuAd01.id}&year=${param.year}&xq=${param.xq }&xz=${param.xz }&cj=${param.cj }','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
							</shiro:hasPermission>
						</c:if>
					</td>
				</tr>
			</c:forEach>
	    </tbody>
	</table>
	<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
</body>
</html>