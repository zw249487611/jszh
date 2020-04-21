<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>申请管理</title>
<meta name="decorator" content="default" />

<script type="text/javascript">
	$(document).ready(function() {
	
	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	function findCheckedVal() {
		var chk_value = "";
		var villageNumbers = new Array();//村
		var villagesandtownsNumbers=new Array();//乡镇
		$('input[name="asww"]:checked').each(function() {
			chk_value += $(this).val() + ",";
			
			villageNumbers.push($(this).parents("td").find('.villageNumber').val());
			villagesandtownsNumbers.push($(this).parents("td").find('.villagesandtownsNumber').val());
		});
		
		if (chk_value == "") {
			top.$.jBox.tip("请查询后选择用户！","info",{persistent:true,opacity:0});
			return;
		}
		
		for(var i = 0;i<villageNumbers.length-1;i++){
			if(villageNumbers[i] != villageNumbers[i+1]){
				top.$.jBox.tip("请选择相同村成员！","info",{persistent:true,opacity:0});
				return;
			}
		}
		 var groupName=prompt('请输入小组名称','');
		console.log(groupName);
		if(groupName==null){
			return;
		}
		if(groupName==''){
			top.$.jBox.tip("请输入小组名称！","info",{persistent:true,opacity:0});
			return;
		}

		if (chk_value != ""&&groupName!='') {
			$.ajax({
				type : "POST",
				url : "${ctx}/shake/shakePovertyApplyuser/addCustom",
				data : {
					
					villagenumber : villageNumbers[0],
					groupnumber : groupName,
					chkvalue : chk_value
				},
				dataType:'json',
				error : function(request) {
					top.$.jBox.tip("请求错误！","error",{persistent:true,opacity:0});
				},
				success : function(data) {
					if (data.success) {
						top.$.jBox.tip("发起成功！","info",{persistent:true,opacity:0});
						window.location.href="${ctx}/bfll/jiangsuAb01/tpfqlist"
					}
				}
			});
		}
	}

	function parseArea(data, id) {
		$("#" + id).empty();
		if (id == "groupNumber") {
			$("#" + id).append('<option value="">请选择组</option>');
		}
		for (var i = 0; i < data.length; i++) {
			$("#" + id).append(
					'<option value="'+data[i].id+'">' + data[i].name
							+ '</option>');
		}
	}

	
	function villageChange(id) {
		$.getJSON("${ctx}/sys/area/queryGroupByVillageId", {
			id : id
		}, function(data) {
			console.log(data);
			parseArea(data, "groupNumber");
		})
	}
	function refresh(){
		window.location.href="${ctx}/bfll/jiangsuAb01/tpfqlist"
	}
</script>
</head>
<body class="gray-bg">
	
	<div class="wrapper wrapper-content">
		<div class="ibox">
			<div class="ibox-content" style="padding-bottom: 50px;">
				<ul class="nav nav-tabs">
					<li><a href="${ctx}/bfll/jiangsuAb01/">脱贫发起列表</a></li>
				</ul>
				<div style="padding-left: 0px; padding-top: 10px; padding-bottom: 10px;">
					<form:form id="searchForm" modelAttribute="shakePovertyModel"
						action="${ctx}/bfll/jiangsuAb01/tpfqlist" method="post"
						class="breadcrumb form-search">
						<input id="pageNo" name="pageNo" type="hidden"
							value="${page.pageNo}" />
						<input id="pageSize" name="pageSize" type="hidden"
							value="${page.pageSize}" />
						<ul class="ul-form" style="margin: 0px; padding: 0px;">
							
							<li><label>行政村：</label> 
							<form:select path="villageNumber"
									onchange="villageChange(this.value)" id="villageNumber"
									htmlEscape="false" maxlength="100" class="input-medium"
									style="height:32px;">
									<option value="">请选择行政村</option>
									<c:forEach items="${villagenumber}" var="villagenumber">
										<option value="${villagenumber.id}">${villagenumber.name}</option>
									</c:forEach>
								</form:select></li>
							<%-- <li><label>所属组：</label> <form:select path="groupNumber"
									id="groupNumber" htmlEscape="false" maxlength="100"
									class="input-medium" style="height:32px;">
									<option value="">请选择组</option>

								</form:select></li> --%>
							<li class="btns"><input id="btnSubmit"
								class="btn btn-primary" type="submit" style="height: 32px;"
								value="查询" /></li>
							<li class="clearfix"></li>
						</ul>
					</form:form>
				</div>
				<sys:message content="${message}" />


				<!-- 工具栏 -->
				<div class="row">
					<div class="col-sm-12">
						<div class="pull-left">
							<button class="btn btn-white btn-sm " data-toggle="tooltip"
								data-placement="left" onclick="refresh()" title="刷新">
								<i class="glyphicon glyphicon-repeat"></i> 刷新
							</button>
							<input onclick="findCheckedVal();" class="btn btn-primary"
								type="button"
								style="height: 28px; line-height: 8px; font-size: 12px;"
								value="发起" />
						</div>
					</div>
				</div>

				<table id="contentTable"
					class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
					<thead>
						<tr>
							<th><input type="checkbox" class="i-checks"> 序号</th>
							<th class="sort-column">村</th>
							<th class="sort-column">户主名称</th>
							<th class="sort-column">家庭人口</th>
							<th class="sort-column">工资性收入</th>
							<th class="sort-column">生产经营性收入</th>
							<th class="sort-column">财产性收入</th>
							<th class="sort-column">转移性收入</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list}" var="jiangsuAb01" varStatus="s">
							<tr>
								<td><input type="checkbox" name="asww" id="${jiangsuAb01.id}"
									 value="${jiangsuAb01.id}" class="i-checks">
									${s.index+1}
									<input type="hidden" class="villageNumber" value="${jiangsuAb01.villageNumber}"/>
									<input type="hidden" class="villagesandtownsNumber" value="${jiangsuAb01.villagesandtownsNumber}"/>
								</td>
								<td>${jiangsuAb01.village}</td>
								<td>${jiangsuAb01.AAB002}</td>
								<td>${jiangsuAb01.familyPopulation}</td>
								<td>${jiangsuAb01.AAC073}</td>
								<td>${jiangsuAb01.AAC071}</td>
								<td>${jiangsuAb01.AAC072}</td>
								<td>${jiangsuAb01.AAC085}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<table:page page="${page}"></table:page>
			</div>
		</div>
	</div>
</body>
</html>