<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>住房管理监督</title>
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
		<h5>待改造危房户列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAc01" action="${ctx}/bfll/jiangsuAc01/listWf" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
	    <div class="form-group">
			<%-- <span>年度：</span>
				<form:select path="year"  class="form-control m-b" >
					<form:options items="${yearMap}"/>
				</form:select> --%>
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
			<span>户主姓名：</span>
				<form:input path="hzxm" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>户主身份证号：</span>
				<form:input path="hzsfzh" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>是否脱贫：</span>
			<form:select path="tpbz" class="form-control m-b">
                <option value="">--请选择--</option>
                <form:options items="${fns:getDictList('tpbz')}" itemLabel="label" itemValue="value" htmlEscape="false" />
            </form:select>
            <span>改造状态：</span>
			<form:select path="zt"  class="form-control m-b">
				<form:option value="" label="---请选择---"/>
				<form:option value="0" label="未改造"/>
				<form:option value="1" label="改造中"/>
				<form:option value="2" label="已改造"/>
				<form:option value="3" label="无需改造"/>
			</form:select>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
		 	<%-- <shiro:hasPermission name="sys:tYwjnybzHuzhu:add">
				<table:addRow url="${ctx}/sys/tYwjnybzHuzhu/form" title="教学资助发放"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="sys:tYwjnybzHuzhu:edit">
			    <table:editRow url="${ctx}/sys/tYwjnybzHuzhu/form" title="教学资助发放" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="sys:tYwjnybzHuzhu:del">
				<table:delRow url="${ctx}/sys/tYwjnybzHuzhu/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button> --%>
		
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
				<th  class="sort-column xq">县区</th>
				<th  class="sort-column xz">乡镇</th>
				<th  class="sort-column cj">村居</th>
				<th  class="sort-column hzxm">户主姓名</th>
				<th  class="sort-column hzsfzh">户主身份证号</th>
				<th  class="sort-column num">危险性等级</th>
				<th  class="sort-column names">改造状态</th>
				<th  class="sort-column tpbzName">是否脱贫</th>
				<th  class="sort-column names">脱贫年度</th>
									<c:if test="${jiangsuAc01.zt == '3' || jiangsuAc01.zt == '无需改造'}">
				
												<th >备注</th>
												</c:if>
																<th  class="sort-column names">操作</th>
												
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAc01Temp">
			<tr>
				<td> <input type="checkbox" id="${jiangsuAc01Temp.id}" class="i-checks"></td>
				<td>
					${jiangsuAc01Temp.xq}
				</td>
				<td>
					${jiangsuAc01Temp.xz}
				</td>
				<td>
					${jiangsuAc01Temp.cj}
				</td>
				
				<td>
					${jiangsuAc01Temp.hzxm}
				</td>
				<td>
					${jiangsuAc01Temp.hzsfzh}
				</td>
				<td>
				${jiangsuAc01Temp.wxdj}
				</td>
				<td>
				${jiangsuAc01Temp.zt}
				</td>
				<td>
				${jiangsuAc01Temp.tpbzName}
				</td>
				<td>
				${jiangsuAc01Temp.tpnd}
				</td>
				
					<c:if test="${jiangsuAc01.zt == '3' || jiangsuAc01.zt == '无需改造'}">
                   <td>
				${jiangsuAc01Temp.remarks}
				</td>								</c:if>
								
			<%-- 	<td>
				    <c:if test="${tJyzzffHuzhu.status eq '未处理'}">
					<a href="#" onclick="openDialog('处理详情', '${ctx}/jyzzff/tJyzzffHuzhu/form?acid=${tJyzzffHuzhu.acid}','600px', '400px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 处理详情</a>
					</c:if>
					  <c:if test="${tJyzzffHuzhu.status eq '已处理'}">
					<a href="#" onclick="openDialogView('处理详情', '${ctx}/jyzzff/tJyzzffHuzhu/form?acid=${tJyzzffHuzhu.acid}','600px', '400px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 处理详情</a>
					</c:if>
				</td> --%>
				<td>
    					<a href="#" onclick="openDialog('修改', '${ctx}/bfll/jiangsuAc01/formWf?id=${jiangsuAc01Temp.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>修改</a>
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