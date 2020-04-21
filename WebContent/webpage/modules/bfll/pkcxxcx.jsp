<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>贫困村信息查询</title>
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
		<h5>贫困村信息查询 </h5>
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
	<form:form id="searchForm" modelAttribute="jddsrrkzpyyhzbModel" action="${ctx}/bfll/jiangsuAb01/getPkcxx" method="post" class="form-inline">
				<div class="form-group mar-bom mar-lft">
					<span>县区：</span>
					<select id="xqSelect" name="xq" id="xq" class="form-control " style="width: 110px;">
						<option value="">--请选择--</option>
						<c:if test="${not empty xqList }">
							<c:forEach items="${xqList }" var="xq">
								<option value="${xq.aar001 }" ${jddsrrkzpyyhzbModel.xq eq xq.aar001 ? "selected='selected'" : "" }>${xq.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="form-group mar-bom mar-lft">
					<span>乡镇：</span>
					<select id="xzSelect" name="xz" id="xz" class="form-control" style="width: 150px;">
						<option value="">--请选择--</option>
						<c:if test="${not empty xzList }">
							<c:forEach items="${xzList }" var="xz">
								<option value="${xz.aar001 }" ${jddsrrkzpyyhzbModel.xz eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="form-group mar-bom mar-lft">
					<span>村居：</span>
					<select id="cjSelect" name="cj" id="cj" class="form-control" style="width: 150px;">
						<option value="">--请选择--</option>
						<c:if test="${not empty cjList }">
							<c:forEach items="${cjList }" var="cj">
								<option value="${cj.aar001 }" ${jddsrrkzpyyhzbModel.cj eq cj.aar001 ? "selected='selected'" : "" }>${cj.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="pull-right">
					<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
				</div>
			</form:form>
	<br/>
	</div>
	</div>
	<c:if test="${not empty appshcxInfoVo}">
	<div id="contentDiv">
	<!-- 表格 -->
	<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		<thead><tr><th colspan="2">${year}年收入情况</th></tr></thead>
		   <tbody>
		    <c:if test="${not empty appshcxInfoVo.xmxxList}">
		   <c:forEach items="${appshcxInfoVo.xmxxList}" var="PkcsrlyInfoVo" varStatus="status">
			   		<tr><td colspan="2" class="">收入来源${status.index + 1}</td></tr>
					<tr>
						<td><label class="">项目名称：</label></td>
						<td>
							${PkcsrlyInfoVo.xmmc}
						</td>
					</tr>
					<tr>
						<td><label class="">项目地点：</label></td>
						<td>
							${PkcsrlyInfoVo.xmdd}
						</td>
					</tr>
					<tr>
						<td><label class="">实施主体：</label></td>
						<td>
							${PkcsrlyInfoVo.xmsszt}
						</td>
					</tr>
					<tr>
						<td><label class="">主要内容：</label></td>
						<td>
							${PkcsrlyInfoVo.xmzynr}
						</td>
					</tr>
					<tr>
						<td><label class="">起始时间：</label></td>
						<td>
							${PkcsrlyInfoVo.xmkssj}
						</td>
					</tr>
					<tr>
						<td><label class="">截止时间：</label></td>
						<td>
							${PkcsrlyInfoVo.xmjssj}
						</td>
					</tr>
					<tr>
						<td><label class="">项目进展：</label></td>
						<td>
							${PkcsrlyInfoVo.xmjz}
						</td>
					</tr>
					<tr>
						<td><label class="">目前收益：</label></td>
						<td>
							${PkcsrlyInfoVo.mqsy}
						</td>
					</tr>
					<tr>
						<td><label class="">收益分配：</label></td>
						<td>
							${PkcsrlyInfoVo.syfp}
						</td>
					</tr>
					<tr>
						<td><label class="">预计年收益（元）：</label></td>
						<td>
							${PkcsrlyInfoVo.yqnsy}
						</td>
					</tr>
					<tr>
						<td><label class="">绩效评估：</label></td>
						<td>
							${PkcsrlyInfoVo.jxpg}
						</td>
					</tr>
					<tr>
						<td><label class="">会计师事务所对项目运行情况的评价：</label></td>
						<td>
							${PkcsrlyInfoVo.xmyxqkfx}
						</td>
					</tr>
					<tr>
						<td><label class="">备注：</label></td>
						<td>
							${PkcsrlyInfoVo.bz}
						</td>
					</tr>
				</c:forEach>
				</c:if>
				<c:if test="${empty appshcxInfoVo.xmxxList}"><tr><td colspan="2" class="">暂无收入数据</td></tr></c:if>
		</tbody>
	</table>
	<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		<thead><tr><th colspan="2">各类帮扶资金使用情况</th></tr></thead>
		   <tbody>
		     <c:if test="${not empty appshcxInfoVo.zjsyqkList}">
		   		<c:forEach items="${appshcxInfoVo.zjsyqkList}" var="PkczjsyqkInfoVo" varStatus="status">
			   <tr><td colspan="2" class="">使用项目${status.index + 1}</td></tr>
					<tr>
						<td><label class=" ">资金名称：</label></td>
						<td>
							${PkczjsyqkInfoVo.zjmc}
						</td>
					</tr>
					<tr>
						<td><label class=" ">资金来源：</label></td>
						<td>
							${PkczjsyqkInfoVo.zjly}
						</td>
					</tr>
					<tr>
						<td><label class=" ">资金数量：</label></td>
						<td>
							${PkczjsyqkInfoVo.zjsl}
						</td>
					</tr>
					<tr>
						<td><label class=" ">使用情况：</label></td>
						<td>
							${PkczjsyqkInfoVo.zjsyqk}
						</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${empty appshcxInfoVo.zjsyqkList}"><tr><td colspan="2" class="">暂无使用数据</td></tr></c:if>
				
		 	</tbody>
		</table>
		<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		<thead><tr><th colspan="2">脱贫计划</th></tr></thead>
		   <tbody>
				<tr>
					<td colspan="2">${appshcxInfoVo.tpjh}</td>
				</tr>
		 	</tbody>
		</table>
	<br/>
	<br/>
	</div>
	</c:if>
	
	</div>
	</div>
	</div>
</body>
</html>