<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>建档立卡信息变更履历管理</title>
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
		<h5>建档立卡信息变更履历列表 </h5>
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
	<form:form id="searchForm" modelAttribute="TJdlkhXxbg" action="${ctx}/bfll/tJdlkhXxbg/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div id="areaSelectDiv" class="form-group">
			<span>年度：</span>
			<form:select path="nd"  class="form-control m-b">
				<form:options items="${yearMap}" />
			</form:select>
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
			<span>户主姓名：</span>
			<form:input path="hzxm" htmlEscape="false" class=" form-control input-sm setName"/>
		 	<span>变更类型：</span>
				<form:select path="bglx"  class="form-control m-b">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('bglx')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th  class="sort-column nd">年度</th>
				<th  class="sort-column xqname">县区</th>
				<th  class="sort-column xzname">乡镇</th>
				<th  class="sort-column cunname">村</th>
				<th  class="sort-column hzxm">户主姓名</th>
				<th  class="sort-column bglx">变更类型</th>
				<th  class="sort-column createDate">变更时间</th>
				<th  class="sort-column createBy">操作人</th>
				<th  class="sort-column bgyy">变更原因</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tJdlkhXxbg">
			<tr>
				<td> <input type="checkbox" id="${tJdlkhXxbg.id}" class="i-checks"></td>
				<td>
					${tJdlkhXxbg.nd}
				</a></td>
				<td>
					${tJdlkhXxbg.xqname}
				</td>
				<td>
					${tJdlkhXxbg.xzname}
				</td>
				<td>
					${tJdlkhXxbg.cunname}
				</td>
				<td>
					${tJdlkhXxbg.hzxm}
				</td>
				<td>
					${fns:getDictLabels(tJdlkhXxbg.bglx, 'bglx', '')}
				</td>
				<td>
					<fmt:formatDate value="${tJdlkhXxbg.createDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${tJdlkhXxbg.createBy.name}
				</td>
				<td data-toggle="tooltip" title="${tJdlkhXxbg.bgyy}" style="vertical-align:middle;">
					<p style="margin-bottom:0px;width:80px;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">${tJdlkhXxbg.bgyy}</p>   
				</td>
				<td>
					<a href="#" onclick="openDialogView('查看建档立卡信息变更履历', '${ctx}/bfll/newJiangsuAc012/form?id=${tJdlkhXxbg.acidBak}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i>变更履历</a>
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