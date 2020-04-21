<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶责任人管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#contentTable thead tr th input.i-checks').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定 
	    	  $('#contentTable tbody tr td input.i-checks').iCheck('check');
	    	});

		    $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定 
	    	  $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
	    	});
		});
		
		var object;
		var jsonStr = '${jsonList}';
		// console.log(jsonStr);
		// jsonStr = jsonStr && jsonStr.replace(/\\/g, '\\\\');
		// console.log(jsonStr.replace(/\\/g, '\\\\'));
	    var jsonarray = $.parseJSON(jsonStr || "[]");
	    
	    function getSelectedJson(id){
	    	for(var i=0;i<jsonarray.length;i++){
	    		if(id == jsonarray[i].id){
	    			return jsonarray[i];
	    		}
	    	}
	    }
	    
	    for(var i=0,l=jsonarray.length;i<l;i++){
	    }
		function getSelectedItem(){

			var size = $("#contentTable tbody tr td input.i-checks:checked").size();
			  if(size == 0 ){
					top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
					return "-1";
				  }

			  if(size > 1 ){
					top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
					return "-1";
				  }
			    var id =  $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("id");
			    
				var label = $("#contentTable tbody tr td input.i-checks:checkbox:checked").parent().parent().parent().find(".codelabel").html();
				return id+"_item_"+label;
		}
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="jiangsuAk11" action="${ctx}/bfll/jiangsuAk11/gridSelect" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input name="excludeIds" type="hidden" value="${param.excludeIds}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<%-- <span>帮扶单位：</span>
				<form:input path="aap110" htmlEscape="false"  class=" form-control input-sm"/> --%>
			<span>姓名：</span>
				<form:input path="aab002" htmlEscape="false" maxlength="50"  class=" form-control input-sm"/>
			<span>性别：</span>
				<form:select path="aab003" class=" form-control input-sm">
					<form:option value=""></form:option>
					<form:option value="1">男</form:option>
					<form:option value="2">女</form:option>
				</form:select>
			<span>证件号码：</span>
				<form:input path="aab004" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>联系电话：</span>
				<form:input path="aar012" htmlEscape="false" maxlength="20"  class=" form-control input-sm"/>
			<span>单位名称：</span>
				<form:input path="aap001" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
			<%-- <span>队长标志：</span>
				<form:input path="aaf031" htmlEscape="false" maxlength="3"  class=" form-control input-sm"/> --%>
		 </div>	
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
				<th  class="sort-column aap001">单位名称</th>
				<th  class="sort-column aap004">隶属关系</th>
				<th  class="sort-column aab005">出生日期</th> -->
				<th  class="sort-column aaf031">职务级别</th>
				<th  class="sort-column aap001">帮扶单位名称</th>
				<th  class="sort-column aap051">帮扶单位类型</th>
				<th  class="sort-column aap004">隶属关系</th>
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
					${jiangsuAk11.aap004}
				</td>
				<td>
					${jiangsuAk11.aab005}
				</td> --%>
				<td>
					${jiangsuAk11.joblevel}
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