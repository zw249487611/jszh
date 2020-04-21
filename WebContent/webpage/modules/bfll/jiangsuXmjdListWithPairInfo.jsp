<!--经济薄弱村帮扶工作组: jjbrcbfgzz.jsp-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶力量</title>
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
<body class="gray-bg">
<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>项目结对信息列表 </h5>
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
			<form:form id="searchForm" modelAttribute="jiangsuXmjd" action="${ctx}/bfll/jiangsuXmjd/listWithPairInfo" method="post" class="form-inline">
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
				<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
				<div class="form-group">
					<span>年度：</span>
					<form:select path="nd"  class="form-control m-b">
					<form:options items="${yearMap}"/>
				</form:select>
					<!-- 
					<input id="nd" name="nd" type="text" maxlength="20" class="laydate-icon form-control layer-date required" value="${jiangsuXmjd.nd}"/>
					 -->
				</div>
				<%-- <div class="form-group">
					<span>资金管理项目类型：</span>
					<select id="type" name="type" class="form-control ">
						<option value="">--请选择--</option>
						
							<c:forEach items="${fns:getDictList('zjjg_type')}" var="zjtype">
							<c:if test="${zjtype.label =='统筹到项目'}">
								<option value="${zjtype.value }" ${jiangsuXmjd.type eq zjtype.value ? "selected='selected'" : "" }>${zjtype.label }</option>
							</c:if>
							</c:forEach>
					</select>
				</div> --%>
				<div class="form-group">
				<span>项目名称：</span>
				<form:input path="xmmc" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
				</div>
			 	<%-- <div class="form-group">
					<span>县区：</span>
					<select id="xmtype" name="xmtype" class="form-control ">
						<option value="">--请选择--</option>
						<c:if test="${not empty xqList }">
							<c:forEach items="${fns:getDictList('zjjg_type')}" var="type">
								<option value="${type.value }" ${jiangsuXmjd.xq eq xq.aar001 ? "selected='selected'" : "" }>${type.label }</option>
							</c:forEach>
						</c:if>
					</select>
				</div> --%>
				<%--<div class="form-group">
					<span>乡镇：</span>
					<select id="xzSelect" name="xz" class="form-control ">
						<option value="">--请选择--</option>
						<c:if test="${not empty xzList }">
							<c:forEach items="${xzList }" var="xz">
								<option value="${xz.aar001 }" ${jiangsuXmjd.xz eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
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
								<option value="${cj.aar001 }" ${jiangsuXmjd.cj eq cj.aar001 ? "selected='selected'" : "" }>${cj.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div> --%>
			</form:form>
			<br/>
		</div>
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
	<table id="contentTable" class="table table-bordered table-hover table-condensed dataTables-example dataTable">
	    <thead>
	        <!-- <tr>
	            <th colspan="6" class="text-center">基本信息</th>
	            <th colspan="8" class="text-center">市县乡联动帮扶组成员单位及帮扶人员</th>
	            <th rowspan="2">财务辅导人员</th>
	            <th rowspan="2">法律援助人员</th>
	            <th rowspan="2">操作</th>
	        </tr> -->
	        <tr>
	            <th style="white-space:nowrap;text-align:center;" class="sort-column type">资金管理项目类型</th>
	            <th style="white-space:nowrap;text-align:center;" class="sort-column nd">年度</th>
	            <th style="white-space:nowrap;text-align:left;" class="sort-column xmmc">项目名称</th>
	            <th style="white-space:nowrap;text-align:center;" class="sort-column sszt">实施主体</th>
	            <th style="white-space:nowrap;text-align:center;" class="sort-column kssj">开始时间</th>
	            <th style="white-space:nowrap;text-align:center;" class="sort-column zzsj">终止时间</th>
	            
	            <th style="white-space:nowrap;text-align:center;">操作</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${page.list}" var="jiangsuXmjd">
				<tr>
					<td style="text-align:center;">
											<c:forEach items="${fns:getDictList('zjjg_type')}" var="types">
												<%-- <option value="${types.value }" ${jiangsuXmjd.type eq types.value? "selected='selected'" : "" }>${types.label }</option> --%>
												<c:if test="${types.value==jiangsuXmjd.type}">${types.label}</c:if>
											</c:forEach>
					</td>
					<td style="text-align:center;">${jiangsuXmjd.nd }</td>
					<td style="text-align:left;">${jiangsuXmjd.xmmc }</td>
					<td style="text-align:center;">
					<c:choose>
						  <c:when test="${fn:length(jiangsuXmjd.sszt) >= 10}">
					
					        <span class="spa2" title="${jiangsuXmjd.sszt}">${fn:substring(jiangsuXmjd.sszt,0,10)}…</span>
					     </c:when>
					     <c:otherwise>
					         <span class="spa2" title="${jiangsuXmjd.sszt}">${jiangsuXmjd.sszt}</span>
					     </c:otherwise>
					 </c:choose>
					</td>
					<td style="text-align:center;">
					<fmt:formatDate value="${jiangsuXmjd.kssj }" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td style="text-align:center;">
					<fmt:formatDate value="${jiangsuXmjd.zzsj }" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<%-- <td>
						<c:choose>
							<c:when test="${jiangsuXmjd.lx == '02'}">省定</c:when>
							<c:when test="${jiangsuXmjd.lx == '03'}">市定</c:when>
						</c:choose>
					</td> --%>
					
					<td style="text-align:center;">
						<shiro:hasPermission name="zjjg:pZjPtzj:view">
							<a href="#" onclick="openDialogView('查看项目帮扶责任人结对信息', '${ctx}/bfll/jiangsuXmjd/formWithPairInfo?id=${jiangsuXmjd.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="bfll:jiangsuXmjd:edit">
							<a href="#" onclick="openDialog('修改项目帮扶责任人结对信息', '${ctx}/bfll/jiangsuXmjd/formWithPairInfo?id=${jiangsuXmjd.id}&nd=${param.nd}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
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