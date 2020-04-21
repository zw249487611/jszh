<!--经济薄弱村帮扶工作组: jjbrcbfgzz.jsp-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>结对低收入人口致贫原因汇总表</title>
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
	<style>
		/* .text-hidden{
			width:10px;
			height:2px;
			text-overflow:ellipsis;
		} */
		.mar-bom{
			margin-bottom:10px;
			margin-top:10px
		}
		.mar-lft{
		margin:10px
		}
	</style>
</head>
<body style="background:#f3f3f4">
	<div class="wrapper wrapper-content">
		<div class="ibox">
			<div class="ibox-title">
				<h5>结对低收入人口致贫原因汇总表</h5>
			</div>
			<div class="ibox-content">
	<div class="row">
		<div class="col-sm-12">
			<form:form id="searchForm" modelAttribute="jddsrrkzpyyhzbModel" action="${ctx}/bfll/jiangsuAb01/getZpyyhz" method="post" class="form-inline">
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
				<div class="form-group mar-bom mar-lft">
					<span>县区：</span>
					<select id="xqSelect" name="xq" class="form-control " style="width: 110px;">
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
					<select id="xzSelect" name="xz" class="form-control" style="width: 150px;">
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
					<select id="cjSelect" name="cj" class="form-control" style="width: 150px;">
						<option value="">--请选择--</option>
						<c:if test="${not empty cjList }">
							<c:forEach items="${cjList }" var="cj">
								<option value="${cj.aar001 }" ${jddsrrkzpyyhzbModel.cj eq cj.aar001 ? "selected='selected'" : "" }>${cj.aar009 }</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div class="form-group mar-bom mar-lft">
					<span>性别：</span>
					<select name="xb" class="form-control">
						<option value="">--请选择--</option>
						<option value="1" ${jddsrrkzpyyhzbModel.xb eq "1" ? "selected='selected'" : "" }>男</option>
						<option value="2" ${jddsrrkzpyyhzbModel.xb eq "2" ? "selected='selected'" : "" }>女</option>
					</select>
				</div>
				<div class="form-group mar-bom mar-lft">
					<span>年龄：</span>
					<!--<form:input path="minnf" type="hidden" htmlEscape="false" maxlength="10"  class=" form-control input-sm"/>-->
					<input type="text" name="minnl" class=" form-control input-sm" style="width:80px;" value="${param.minnl }">~
					<input type="text" name="maxnl" class=" form-control input-sm" style="width:80px;" value="${param.maxnl }">
					<!--  <form:input path="maxnf" type="hidden" htmlEscape="false" maxlength="10"  class=" form-control input-sm"/>-->
				</div>
				<div class="form-group mar-bom mar-lft">
					<span>贫困户属性：</span>
					<select name="pkhsx" class="form-control">
						<option value="">--请选择--</option>
						<option value="01" ${jddsrrkzpyyhzbModel.pkhsx eq "01" ? "selected='selected'" : "" }>一般贫困户</option>
						<option value="02" ${jddsrrkzpyyhzbModel.pkhsx eq "02" ? "selected='selected'" : "" }>低保户</option>
						<option value="03" ${jddsrrkzpyyhzbModel.pkhsx eq "03" ? "selected='selected'" : "" }>五保户</option>
						<option value="04" ${jddsrrkzpyyhzbModel.pkhsx eq "04" ? "selected='selected'" : "" }>低保户贫困户</option>
						<option value="05" ${jddsrrkzpyyhzbModel.pkhsx eq "05" ? "selected='selected'" : "" }>一般农户</option>
						<option value="06" ${jddsrrkzpyyhzbModel.pkhsx eq "06" ? "selected='selected'" : "" }>五保贫困户</option>
					</select>
				</div>
				<br>
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
		       	<button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12 table-responsive">
	<table id="contentTable" class="table table-bordered table-hover table-condensed dataTables-example dataTable">
	    <thead>
	        <tr style="font-size:13px">
	            <th nowrap="nowrap">乡镇</th>
	            <th nowrap="nowrap">村</th>
	            <th nowrap="nowrap">姓名</th>
	            <th nowrap="nowrap">性别</th>
	            <th nowrap="nowrap">年龄</th>
	            <th nowrap="nowrap">致贫原因</th>
	            <th nowrap="nowrap">户主</th>
	            <th nowrap="nowrap">与户主关系</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${page.list}" var="jddsrrkzpyyhzbModel">
				<tr  style="font-size:12px">
					<td>${jddsrrkzpyyhzbModel.xz}</td>
					<td>${jddsrrkzpyyhzbModel.cj}</td>
					<td>${jddsrrkzpyyhzbModel.xm}</td>
					<td>${jddsrrkzpyyhzbModel.xb}</td>
					<td>${jddsrrkzpyyhzbModel.nl}</td>
					<td>${jddsrrkzpyyhzbModel.zpyy }</td>
					<td>${jddsrrkzpyyhzbModel.hzxm }</td>
					<td>${jddsrrkzpyyhzbModel.yhzgx }</td>
				</tr>
			</c:forEach>
	    </tbody>
	</table>
	
	<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>