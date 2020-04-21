<!--经济薄弱村帮扶工作组: jjbrcbfgzz.jsp-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>入户信息录入统计临时</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
			if ($("#xqSelect").find("option").size() == 1) {
				$.getJSON("${ctx}/bfll/jiangsuAa11/getByParent", {aaa113: '320800000000'}, function (data) {
					if (data.success) {
						var $xqSelect = $("#xqSelect");
						$xqSelect.find("option:gt(0)").remove();
						$.each(data.body.data, function(i, item) {
							var $option = $("<option/>").val(item.aar001).text(item.aar009);
							if ('${jiangsuAc07.xq}' == item.aar001) {
								$option.attr("selected", "selected");
							}
							$xqSelect.append($option);
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
				
				chkExportBtnVisible();
			});
			
			
			chkExportBtnVisible();
		});
		
		// 根据乡镇是否为空，判断“导出”按钮是否需要显示
		function chkExportBtnVisible() {
			var xz = $("#xzSelect").val();
			if (xz) {
				$("#btnExport").show();
			} else {
				$("#btnExport").hide();
			}
		}
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
				<h5>县区走访数据录入统计</h5>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="col-sm-12">
						<form:form id="searchForm" modelAttribute="jiangsuAc07" action="${ctx}/bfll/jiangsuAc07/listNotMatch" method="post" class="form-inline">
							<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
							<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
							<div class="form-group mar-lft">
								<span>县区：</span>
								<select id="xqSelect" name="xq" class="form-control "  style="width:100px" >
									<option value="">--请选择--</option>
									<c:if test="${xqArea != null }">
										<option value="${xqArea.code } ">${xqArea }</option>
									</c:if>
								</select>
							</div>
							<div class="form-group mar-lft">
								<span>乡镇：</span>
								<select id="xzSelect" name="xz" class="form-control "  style="width:100px" >
									<c:choose>
										<c:when test="${not empty xzList }">
											<option value="">--请选择--</option>
											<c:if test="${not empty xzList }">
												<c:forEach items="${xzList }" var="xz">
													<option value="${xz.aar001 }" ${jiangsuAc07.xz eq xz.aar001 ? "selected='selected'" : "" }>${xz.aar009 }</option>
												</c:forEach>
											</c:if>
										</c:when>
										<c:otherwise>
											<option value="${xzArea.code }">${xzArea }</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							
							<div class="form-group mar-bom mar-lft">
								<span>季度：</span>
								<select name="quarter" class="form-control"  style="width:150px" >
									<option value="1" ${jiangsuAc07.quarter == '1' ? "selected='selected'" : "" }>1</option>
									<option value="2" ${jiangsuAc07.quarter == '2' ? "selected='selected'" : "" }>2</option>
									<option value="3" ${jiangsuAc07.quarter == '3' ? "selected='selected'" : "" }>3</option>
									<option value="4" ${jiangsuAc07.quarter == '4' ? "selected='selected'" : "" }>4</option>
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
			<!-- 下面改了它的源，不太懂 -->
					       	<shiro:hasPermission name="bfll:JiangsuAc07:export1">
								<table:exportExcel url="${ctx}/bfll/JiangsuAc07/export" ></table:exportExcel><!-- 导出按钮 -->
				       		</shiro:hasPermission>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 table-responsive">
						<table id="contentTable" class="table table-bordered table-hover table-condensed dataTables-example dataTable">
						    <thead>
						        <tr  style="font-size:13px">
						            <th nowrap="nowrap" >县（区）</th>
						            <th nowrap="nowrap" >乡（镇）</th>
						            <th nowrap="nowrap" >走访时间</th>
						            <th nowrap="nowrap" >户主姓名</th>
						            <th nowrap="nowrap" >经营性收入</th>
						            <th nowrap="nowrap" >转移性收入</th>
						            <th nowrap="nowrap"  >详情</th> 
						        </tr>
						    </thead>
						    <tbody>
						    	<c:forEach items="${page.list}" var="jiangsuAc07">
									<tr  style="font-size:12px">
										<td>${jiangsuAc07.xq }</td>
										<td>${jiangsuAc07.xz }</td>
										<td>${jiangsuAc07.zfsj }</td>
										<td align="center">${jiangsuAc07.hzxm }</td>
										<td>${jiangsuAc07.jyxsr }</td>
										<td>${jiangsuAc07.zyxsr }</td>
										<td>测试</td>
										
										<!-- 下面暂时没修改，先用着 -->
										<%-- <td>
											<c:if test="${jiangsuAk11.hasZf eq '是'}">
												<a href="#" onclick="openDialog('查看走访记录详情', '${ctx}/bfll/jiangsuAk11/rhzfDetail?pkhbh=${jiangsuAk11.acid}&bfrId=${jiangsuAk11.id}&createDate=<fmt:formatDate value="${jiangsuAk11.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>&sfzh=${jiangsuAk11.farmerSfzh }','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 查看</a>
											</c:if>
										</td> --%>
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