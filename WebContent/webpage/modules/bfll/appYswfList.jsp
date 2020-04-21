<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>住房管理监督</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.jtzfzp').each(function(){
				var url = $(this).attr("href");
				if(url == ''){
					$(this).css("cursor", "default");
	                $(this).css("background", "gray");
	                $(this).css("border-color", "gray");
	                $(this).attr('href', '#');     //修改<a>的 href属性值为 #  这样状态栏不会显示链接地址  
	                $(this).click(function (event) {
	                    event.preventDefault();   // 如果<a>定义了 target="_blank“ 需要这句来阻止打开新页面
	                });
				}else if(url.indexOf("|") >= 0){
					var newUrl = url.replace('|','');
					$(this).attr("href",newUrl);
					$(this).attr("url",newUrl);
				}
			})
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>疑似危房户列表 </h5>
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
	<form:form id="searchForm" modelAttribute="jiangsuAc01" action="${ctx}/bfll/jiangsuAc01/listYsWf" method="post" class="form-inline">
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
			 <span>处理状态：</span>
			<form:select path="status"  class="form-control m-b">
				<form:option value="" label="---请选择---"/>
				<form:option value="未处理" label="未处理"/>
				<form:option value="已处理" label="已处理"/>
			</form:select>
			<span>户主身份证号：</span>
				<form:input path="hzsfzh" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
				
			<span>复核结果是否属实：</span>
					<form:select path="fhjgsfss"  class="form-control m-b" >
						<form:option value="" label="请选择" />
				<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>								
				</form:select>				
				
			<%-- <span>户主姓名：</span>
				<form:input path="hzxm" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/>
			<span>户主身份证号：</span>
				<form:input path="hzsfzh" htmlEscape="false" maxlength="255"  class=" form-control input-sm"/> --%>
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
				<th  class="sort-column num">脱贫状态</th>
				<th >现有住房照片</th>
				<th  >帮扶人姓名</th>
				<th  >帮扶人联系方式</th>
				<th  >处理状态</th>
				<th  >复核结果是否属实</th>
				<th  >操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jiangsuAc01">
			<tr>
				<td> <input type="checkbox" id="${jiangsuAc01.id}" class="i-checks"></td>
				<td>
					${jiangsuAc01.xq}
				</td>
				<td>
					${jiangsuAc01.xz}
				</td>
				<td>
					${jiangsuAc01.cj}
				</td>
				
				<td>
					${jiangsuAc01.hzxm}
				</td>
				<td>
					${jiangsuAc01.hzsfzh}
				</td>
				<td>
				${jiangsuAc01.tpbz}
				</td>
				<td style="text-align:center;">
				 <a href="${jiangsuAc01.jtzfzp}" url="${jiangsuAc01.jtzfzp}" target="_blank" class="btn btn-info btn-xs jtzfzp"  ><i class="fa fa-search-plus" "></i>查看图片</a> 
				</td>
				<td>
				${jiangsuAc01.bfrxm}
				</td>
				<td>
				${jiangsuAc01.bfrlxfs}
				</td>
				<td>
				${jiangsuAc01.status}
				</td>
				<td>
				${fns:getDictLabel(jiangsuAc01.fhjgsfss, 'yes_no', '')}
				</td>
				<td>
				<c:if test="${jiangsuAc01.status eq '未处理'}">
				<a href="#" onclick="openDialog('处理详情', '${ctx}/zfaqbz/tZfcljd/form?acid=${jiangsuAc01.id}','600px', '400px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 处理详情</a>
				</c:if>
				<c:if test="${jiangsuAc01.status eq '已处理'}">
				<a href="#" onclick="openDialog('处理详情', '${ctx}/zfaqbz/tZfcljd/form?acid=${jiangsuAc01.id}','600px', '400px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 处理详情</a>
					</c:if>
				</td>
			
				  <%-- 	 <td> <c:if test="${tJyzzffHuzhu.status eq '未处理'}">
					<a href="#" onclick="openDialog('处理详情', '${ctx}/jyzzff/tJyzzffHuzhu/form?acid=${tJyzzffHuzhu.acid}','600px', '400px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 处理详情</a>
					</c:if>
					  <c:if test="${tJyzzffHuzhu.status eq '已处理'}">
					<a href="#" onclick="openDialogView('处理详情', '${ctx}/jyzzff/tJyzzffHuzhu/form?acid=${tJyzzffHuzhu.acid}','600px', '400px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 处理详情</a>
					</c:if>
				</td> --%>
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