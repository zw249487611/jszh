<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>医疗数据一览</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	$(function(){
		$("#xqSelect").on("change", function () {
            $.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: $(this).val()}, function (data) {
                if (data.success) {
                    var $xzSelect = $("#xzSelect");
                    $xzSelect.find("option:gt(0)").remove();
                    $.each(data.body.data, function (i, item) {
                        $xzSelect.append($("<option/>").val(item.aar001).text(item.aar009));
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
		<h5>医疗数据列表 </h5>
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
	<div class="row col-sm-12">
	<form:form id="searchForm" modelAttribute="medicalData" action="${ctx}/bfll/medicalData/list" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
      	<span>县区：</span>
        <select id="xqSelect" name="area" class="form-control " style="width: 110px;">
            <option value="">--请选择--</option>
            <c:if test="${not empty xqList }">
                <c:forEach items="${xqList }" var="xq">
                    <option value="${xq.aar001 }" ${medicalData.area eq xq.aar001 ? "selected='selected'" : "" }>${xq.aar009 }</option>
                </c:forEach>
            </c:if>
        </select>
        <span>乡镇：</span>
        <select id="xzSelect" name="town" class="form-control" style="width: 110px;">
            <option value="">--请选择--</option>
            <c:if test="${not empty xzList }">
                <c:forEach items="${xzList }" var="xz">
                    <option value="${xz.aar001 }" ${medicalData.town eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
                </c:forEach>
            </c:if>
        </select>
        <span>姓名：</span>
		<form:input path="name" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
        <span>身份证号：</span>
		<form:input path="idCard" htmlEscape="false" maxlength="100"  class=" form-control input-sm"/>
		<span>导入月份：</span>
		<input name="importDate" id="importDate" value="${medicalData.importDate}" class="laydate-icon form-control layer-date" style="width:120px;" onclick="WdatePicker({dateFmt:'yyyy-MM'});" />
		<!-- 
		<span>入院月份：</span>
		<input name="hospitalIn" id="hospitalIn" value="${medicalData.hospitalIn}" class="laydate-icon form-control layer-date" style="width:120px;" onclick="WdatePicker({dateFmt:'yyyy-MM'});"/>
        -->
  	</form:form>
		<br/>
	</div>
	<!-- 工具栏 -->
	<!-- 工具栏 -->
	<div class="row">
		<div class="col-sm-12">
			<%--<div class="pull-left">
				<table:exportExcel url="${ctx}/medical/export"></table:exportExcel><!-- 导出按钮 -->
			</div>--%>
			<div class="pull-left">
				<table:importExcel url="${ctx}/bfll/medicalData/import"></table:importExcel><!-- 导入按钮 -->
			</div>
			<div class="pull-right">
				<button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
				<button class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
			</div>
		</div>
	</div>
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th style="white-space:nowrap;text-align:center;" class="sort-column name">姓名</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column idCard">身份证号</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column area">区县</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column town">乡镇</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column country">村</th>
				<!--  
				<th style="white-space:nowrap;text-align:center;" class="sort-column hospitalIn">入院日期</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column hospitalOut">出院日期</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column diseaseNameIn">入院诊断名称</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column diseaseNameOut">出院诊断名称</th>
				-->
				<th style="white-space:nowrap;text-align:center;" class="sort-column totalCost">医疗费用总额</th>
				<th style="white-space:nowrap;text-align:center;" class="sort-column cashCost">现金支付</th>
				<th style="white-space:nowrap;text-align:center;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="data">
				<tr>
					<td>
						${data.name}
					</td>
					<td>
						${data.idCard}
					</td>
					<td>
						${data.area}
					</td>
					<td>
						${data.town}
					</td>
					<td>
						${data.country}
					</td>
					<!-- 
					<td>
						${data.hospitalIn}
					</td>
					<td>
						${data.hospitalOut}
					</td>
					<td>
						${data.diseaseNameIn}
					</td>
					<td>
						${data.diseaseNameOut}
					</td>
					 -->
					<td>
						<fmt:formatNumber value="${data.totalCost}" pattern="#.##" type="number"/>
					</td>
					<td>
						<fmt:formatNumber value="${data.cashCost}" pattern="#.##" type="number"/>
					</td>
					<td style="text-align:center;width:160px;">
						<a href="#" onclick="openDialogView('查看详细', '${ctx}/bfll/medicalData/form?id=${data.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看详细</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>
</div>

</body>
</html>