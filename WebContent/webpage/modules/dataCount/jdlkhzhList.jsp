<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>

<head>
    <title>建档立卡户查验监督</title>
    <meta name="decorator" content="default" />
    <style type="text/css">
    .demo-table-expand {
        font-size: 0;
    }

    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }

    .text {
        font-size: 14px;
    }

    .item {
        padding: 10px 0;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 100%;
        margin-bottom: 5px
    }

    .el-card__body {
        padding: 0 15px;
    }

    .el-tabs__item {
        border-radius: 13px 13px 0 0;
        background: #ccc;
        padding: 0 40px;
        color: #000
    }

    .el-tabs__item.is-active {
        border-radius: 13px 13px 0 0 !important;
        background: #438eb9;
        color: #fff
    }

    #myModal,
    #myModalDetail {
        transform: scale(0.9);
    }

    .a_con {
        margin-right: 20px;
        float: left;
    }

    .work_item {
        line-height: 30px;
        color: black;
    }

    .work_label {
        float: left;
    }

    .work_value {
        float: left;
    }

    .clear {
        clear: both;
    }

    .nothing {
        text-align: center;
        padding-top: 50px;
        padding-bottom: 50px;
    }
    
    .photo_con{
    		margin-top: 10px;
	    border: 1px solid #d1dbe5;
	    padding: 20px 10px 10px;
    }
    
    .photo_item{
    		display: inline-block;
    		margin: 0 20px 10px;
    }

    .little_title{
        margin-top: 15px;
    }

    .lbcsbz_title{
        margin-top: 10px;
        font-size: 14px;
        border-bottom: 1px solid #ddd;
        line-height: 40px;
    }
    
    .item_title{
    		margin-bottom:10px;
    }
    
    .myTable{
    		width:100%;
    		border:1px solid #dfe6ec;
    }
    
    .myTable tr th{
    		background-color:#eef1f6;
    }
    
    .myTable tr th,.myTable tr td{
    		border:1px solid #dfe6ec;
    		line-height:46px;
    		min-width:16%;
    		padding-left:10px;
    }
    
    </style>
    <script type="text/javascript">
    $(document).ready(function() {
        var arrId = $('.toggle');
        arrId.each(function(index, obj) {
            var tempTarget = "#" + obj.getAttribute("data-id");
            obj.setAttribute("data-target", tempTarget);

        })

        /* validateForm = $("#searchForm").validate({
            submitHandler: function(form){
                debugger;
                var area = $('#5_area').val();
                if(area == null || area == undefined || area == '' || area=='0'){
                    $("#errobox").text("请选择乡镇!");
                    
                    return;
                }
                loading('正在提交，请稍等...');
                form.submit();
            }
        }); */
        
		$("#btnExportPkrk").click(function(){
			top.layer.confirm('确认要导出Excel吗?', {icon: 3, title:'系统提示'}, function(index){
			    //do something
			    	//导出之前备份
			    	var url =  $("#searchForm").attr("action");
			    	var pageNo =  $("#pageNo").val();
			    	var pageSize = $("#pageSize").val();
			    	//导出excel
			        $("#searchForm").attr("action","${ctx}/datacount/jdlkhzh/exportPkrk");
				    $("#pageNo").val(-1);
					$("#pageSize").val(-1);
					$("#searchForm").submit();

					//导出excel之后还原
					$("#searchForm").attr("action",url);
				    $("#pageNo").val(pageNo);
					$("#pageSize").val(pageSize);
			    top.layer.close(index);
			});
		});
		
    });
    </script>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="ibox">
            <div class="ibox-title">
                <h5>建档立卡户查验监督列表</h5>
                <div class="ibox-tools">
                    <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                    </a> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
                        class="fa fa-wrench"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#">选项1</a></li>
                        <li><a href="#">选项2</a></li>
                    </ul>
                    <a class="close-link"> <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <sys:message content="${message}" />
                <!--查询条件-->
                <div class="row">
                    <div class="col-sm-12">
                        <form:form id="searchForm" modelAttribute="jdlkhzh" action="${ctx}/datacount/jdlkhzh/" method="post" class="form-inline">
                            <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
                            <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
                            <table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();" />
                            <!-- 支持排序 -->
                            <div id="areaSelectDiv" class="form-group">
                                <span>年度：</span>
                                <form:select path="nd" class="form-control m-b">
                                    <form:options items="${yearMap}" />
                                </form:select>
                                <form:hidden path="currentAreaId" />
                                <span>县区：</span> <select id="4_area" name="4_area" class="form-control areaCascadeSelect" style="width: 130px">
                                </select> <span>乡镇：</span> <select id="5_area" name="5_area" class="form-control areaCascadeSelect" style="width: 130px">
                                </select> <span>村：</span> <select id="6_area" name="6_area" class="form-control areaCascadeSelect" style="width: 130px">
                                </select> <span>家庭成员姓名：</span>
                                <form:input path="xm" htmlEscape="false" maxlength="64" class=" form-control input-sm" />
                                <span>身份证号：</span>
                                <form:input path="sfzh" htmlEscape="false" maxlength="64" class=" form-control input-sm" />
                                <span>贫困户属性：</span>
                                <form:select path="pkhsx" class="form-control m-b">
                                    <form:option value="" label="" />
                                    <form:options items="${fns:getDictList('pkhsx')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                                </form:select>
                                <span>致贫原因：</span>
                                <form:select path="zpyy" class="form-control m-b">
                                    <form:option value="" label="" />
                                    <form:options items="${fns:getDictList('zyzpyy')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                                </form:select>
                                <span>是否支出性贫困：</span> <select name="sfzcxpk" class="form-control ">
                                    <option value="" label="" />
                                    <option value="0" <c:if test="${jdlkhzh.sfzcxpk=='0' }">selected="selected"</c:if>>否</option>
                                    <option value="1" <c:if test="${jdlkhzh.sfzcxpk=='1' }">selected="selected"</c:if>>是</option>
                                </select> <span>脱贫年度：</span>
                                <form:select path="tpnd" class="form-control m-b">
                                    <option value="">--请选择--</option>
                                    <form:options items="${yearMap}" />
                                </form:select>
                                &nbsp;&nbsp;<span>脱贫标志：</span>
                                <form:select path="tpbz" class="form-control m-b">
                                    <option value="">--请选择--</option>
                                    <form:options items="${fns:getDictList('tpbz')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                                </form:select>
                               <%--  <span>是否住房有保障：</span> <select name="sfyzf" class="form-control ">
                                    <option value="" label="" />
                                    <option value="0" <c:if test="${jdlkhzh.sfyzf=='0' }">selected="selected"</c:if>>否</option>
                                    <option value="1" <c:if test="${jdlkhzh.sfyzf=='1' }">selected="selected"</c:if>>是</option>
                                </select> --%>
                                <span>是否结对：</span>
                                <form:select path="sfjd" class="form-control m-b">
                                    <form:option value="">--请选择--</form:option>
                                    <form:options items="${fns:getDictList('sfjd')}" itemLabel="label" itemValue="value" htmlEscape="false" />
                                </form:select>
                            </div>
                        </form:form>
                        <br />
                    </div>
                </div>
                <div class="row" style="margin-bottom:10px;">
					<div class="col-sm-12">
						<div class="pull-left"
							style="font-size: 18px; font-weight: bold;margin-left:10px;">${peoplecount}</div>
						<div class="pull-right">
							<button class="btn btn-primary btn-rounded btn-outline btn-sm "
								onclick="search()">
								<i class="fa fa-search"></i> 查询
							</button>
							<button class="btn btn-primary btn-rounded btn-outline btn-sm "
								onclick="reset()">
								<i class="fa fa-refresh"></i> 重置
							</button>
						</div>
					</div>
				</div>
                <!-- 工具栏 -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="pull-left">
                            <shiro:hasPermission name="datacount:jdlkhzh:add">
                                <table:addRow url="${ctx}/datacount/jdlkhzh/form" title="pkhxxzhcx"></table:addRow>
                                <!-- 增加按钮 -->
                            </shiro:hasPermission>
                            <shiro:hasPermission name="datacount:jdlkhzh:edit">
                                <table:editRow url="${ctx}/datacount/jdlkhzh/form" title="pkhxxzhcx" id="contentTable"></table:editRow>
                                <!-- 编辑按钮 -->
                            </shiro:hasPermission>
                            <shiro:hasPermission name="datacount:jdlkhzh:del">
                                <table:delRow url="${ctx}/datacount/jdlkhzh/deleteAll" id="contentTable"></table:delRow>
                                <!-- 删除按钮 -->
                            </shiro:hasPermission>
                            <shiro:hasPermission name="datacount:jdlkhzh:import">
                                <table:importExcel url="${ctx}/datacount/jdlkhzh/import"></table:importExcel>
                                <!-- 导入按钮 -->
                            </shiro:hasPermission>
                            <%-- <shiro:hasPermission name="datacount:jdlkhzh:export"> --%>
                            <table:exportExcel url="${ctx}/datacount/jdlkhzh/export"></table:exportExcel>
                            <!-- 导出按钮 -->
                            <%-- </shiro:hasPermission> --%>
                            <button id="btnExportPkrk" class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" title="导出家庭成员"><i class="fa fa-file-excel-o"></i> 导出家庭成员</button>
                            <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新">
                                <i class="glyphicon glyphicon-repeat"></i> 刷新
                            </button>
                        </div>
                    </div>
                </div>
                <!-- 表格 -->
                <table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
                    <thead>
                        <tr>
                            <!-- <th> <input type="checkbox" class="i-checks"></th> -->
                            <th class="sort-column nd">年度</th>
                            <th class="sort-column dz">家庭地址</th>
                            <th class="sort-column xm">户主姓名</th>
                            <th class="sort-column sfzh">身份证号</th>
                            <th class="sort-column jtrks">家庭人口数</th>
                            <th class="sort-column lxfs" hidden>联系方式</th>
                            <th class="sort-column pkhsx">贫困户属性</th>
                            <th class="sort-column zpyy">致贫原因</th>
                            <th class="sort-column tpbz">脱贫标志</th>
                            <th class="sort-column tpbz">脱贫年度</th>
                            <th class="">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${page.list}" var="jdlkhzh">
                            <!--  onclick="ajaxValue(this)" -->
                            <tr class="toggle accordion-toggle" data-toggle="collapse" data-target="" data-id="${jdlkhzh.sfzh}">
                                <td hidden><input type="checkbox" id="${jdlkhzh.id}" class="i-checks"></td>
                                <td>${jdlkhzh.nd}</td>
                                <td>${jdlkhzh.dz}</td>
                                <td>${jdlkhzh.xm}</td>
                                <td>${jdlkhzh.sfzh}</td>
                                <td>${jdlkhzh.jtrks}</td>
                                <td hidden>${jdlkhzh.lxfs}</td>
                                <td>${fns:getDictLabel(jdlkhzh.pkhsx, 'pkhsx', '')}</td>
                                <td>${fns:getDictLabel(jdlkhzh.zpyy, 'zyzpyy', '')}</td>
                                <td>${fns:getDictLabel(jdlkhzh.tpbz, 'tpbz', '')}</td>
                                <td>${jdlkhzh.tpnd}</td>
                                <td>
                                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal" onclick="getName(this)">查看详情</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <!-- 分页代码 -->
                <table:page page="${page}"></table:page>
                <!-- Modal -->
                <div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document" style="width: 100%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h3 class="modal-title modal-title-content"></h3>
                            </div>
                            <div class="modal-body">
                                <div id="app">
                                    <template>
                                        <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
                                            <el-tab-pane label="基本信息" name="first">
                                                <el-table :data="tableData1_2" border style="width: 100%;margin-bottom:5px">
                                                    <el-table-column prop="户主姓名" label="户主姓名" width="100"> </el-table-column>
                                                    <el-table-column prop="省份证号" label="身份证号"> </el-table-column>
                                                    <el-table-column prop="家庭住址" label="家庭住址"> </el-table-column>
                                                    <el-table-column prop="家庭人口" label="家庭人口" width="100"> </el-table-column>
                                                    <el-table-column prop="联系方式" label="联系方式"> </el-table-column>
                                                    <el-table-column prop="贫困户属性" label="贫困户属性"> </el-table-column>
                                                    <el-table-column prop="致贫原因" label="致贫原因"> </el-table-column>
                                                </el-table>
                                                <el-table :data="tableData1" border style="width: 100%">
                                                    <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                    <el-table-column prop="身份证号" label="身份证号" width="250"> </el-table-column>
                                                    <el-table-column prop="性别" label="性别"> </el-table-column>
                                                    <el-table-column prop="与户主关系" label="与户主关系"> </el-table-column>
                                                    <!-- <el-table-column label="就业情况">
                                                        <template scope="props">
                                                            <span>{{props.row['就业情况']}}</span>&nbsp;&nbsp;&nbsp;
                                                            <el-button v-show="props.row['就业单位']" size="small" data-toggle="modal" data-target="#myModalDetail" @click="showWorksDetail(props)">查看详情</el-button>
                                                        </template>
                                                    </el-table-column> -->
                                                    <el-table-column prop="健康状况" label="健康状况"> </el-table-column>
                                                    <el-table-column prop="慢性病" label="慢性病"> </el-table-column>
                                                    <el-table-column prop="大病" label="大病"> </el-table-column>
                                                </el-table>
                                            </el-tab-pane>
                                            <el-tab-pane label="收入信息" name="second">
                                                <el-card class="box-card" v-loading="loading2" element-loading-text="拼命加载中" style="width:100%">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">脱贫轨迹</span>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData3" border style="width: 100%">
                                                            <el-table-column prop="年度" label="年度"> </el-table-column>
                                                            <el-table-column prop="季度" label="季度"> </el-table-column>
                                                            <el-table-column prop="家庭收入" label="家庭收入(元)"> </el-table-column>
                                                            <el-table-column prop="家庭人口" label="家庭人口"> </el-table-column>
                                                            <el-table-column prop="人均收入" label="人均收入(元)"> </el-table-column>
                                                            <el-table-column prop="帮扶人姓名" label="帮扶责任人姓名"> </el-table-column>
                                                           <!--  <el-table-column prop="是否脱贫" label="是否脱贫"> </el-table-column> -->
                                                            <el-table-column label="操作"> <template scope="props">
                                                                    <el-button size="small" :data-createdate="props.row['走访时间']" :disabled="(props.row['走访时间'] == '') ? true:false" :data-pkhCode="props.row['贫困户编号']" onclick="detailTable(this)">查看</el-button>
                                                                </template> </el-table-column>
                                                        </el-table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" style="width:100%" v-show="(showDetail=='false')? false:true">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">收入详情（单位：元）</span>
                                                    </div>
                                                    <div class="text item">
                                                    	   <h4 class="little_title">帮扶人信息</h4>
                                                        <el-table :data="tableData3_6" border style="width: 100%">
                                                            <el-table-column prop="帮扶人姓名" label="帮扶人姓名">
                                                            </el-table-column>
                                                            <el-table-column prop="帮扶人单位" label="帮扶人单位">
                                                            </el-table-column>
                                                            <el-table-column prop="帮扶人职务" label="帮扶人职务"> </el-table-column>
                                                            <el-table-column prop="帮扶人联系方式" label="帮扶人联系方式"> </el-table-column>
                                                        </el-table>
                                                        <h4 class="little_title">经营性收入</h4>
                                                        <el-table :data="tableData3_1" border style="width: 100%">
                                                            <el-table-column prop="养殖业收入" label="养殖业收入">
                                                            </el-table-column>
                                                            <el-table-column prop="种植业收入" label="种植业收入">
                                                            </el-table-column>
                                                            <el-table-column prop="村集体经济项目收益（省定、市定）" label="村集体经济项目收益（省定、市定）"> </el-table-column>
                                                            <el-table-column prop="直接到户项目补助" label="直接到户项目补助"> </el-table-column>
                                                            <el-table-column prop="统筹带动增收项目收益" label="统筹带动增收项目收益"> </el-table-column>
                                                            <el-table-column prop="其它收入" label="其它收入"> </el-table-column>
                                                        </el-table>
                                                        <h4 class="little_title">工资性收入</h4>
                                                        <el-table :data="tableData3_2" border style="width: 100%">
                                                            <el-table-column prop="家庭成员姓名" label="家庭成员姓名">
                                                            </el-table-column>
                                                            <el-table-column prop="工种" label="工种"> </el-table-column>
                                                            <el-table-column prop="工作单位" label="工作单位"> </el-table-column>
                                                            <el-table-column prop="今年以来收入" label="累计收入"> </el-table-column>
                                                        </el-table>
                                                        <el-table :data="tableDataIncomeOther" border style="width: 25%;margin-top: 10px;">
                                                            <el-table-column prop="工资性其他收入" label="工资性其他收入"> </el-table-column>
                                                        </el-table>
                                                        <h4 class="little_title">财产性收入</h4>
                                                        <el-table :data="tableData3_3" border style="width: 100%">
                                                            <el-table-column prop="资产出租收入" label="资产出租收入">
                                                            </el-table-column>
                                                            <el-table-column prop="红利收入" label="红利收入">
                                                            </el-table-column>
                                                            <el-table-column prop="流转承包土地经营权租金收入" label="流转承包土地经营权租金收入">
                                                            </el-table-column>
                                                            <el-table-column prop="土地流转面积" label="土地流转面积">
                                                            </el-table-column>
                                                            <el-table-column prop="利息收入" label="利息收入">
                                                            </el-table-column>
                                                            <el-table-column prop="其它财产性收入" label="其它财产性收入">
                                                            </el-table-column>
                                                        </el-table>
                                                        <h4 class="little_title">转移性收入</h4>
                                                        <el-table :data="tableData3_4" border style="width: 100%">
                                                            <el-table-column prop="慈善救助" label="慈善救助"> </el-table-column>
                                                            <el-table-column prop="慰问金" label="慰问金"> </el-table-column>
                                                            <el-table-column prop="政策性生产补贴" label="政策性生产补贴"> </el-table-column>
                                                            <el-table-column prop="政策性生活补贴" label="政策性生活补贴"> </el-table-column>
                                                            <el-table-column prop="养老金" label="养老金"> </el-table-column>
                                                            <el-table-column prop="赡养费" label="赡养费"> </el-table-column>
                                                            <el-table-column prop="社会救济和补助" label="社会救济和补助"> </el-table-column>
                                                            <el-table-column prop="教育资助" label="教育资助"> </el-table-column>
                                                            <el-table-column prop="其他" label="其他"> </el-table-column>
                                                        </el-table>
                                                        <h4 class="little_title">其他</h4>
                                                        <el-table :data="tableData3_5" border style="width: 100%">
                                                            <el-table-column prop="其他" label="其他"> </el-table-column>
                                                        </el-table>
                                                    </div>
                                                </el-card>
                                            </el-tab-pane>
                                            <el-tab-pane label="财政资金" name="third">
                                                <el-card class="box-card" v-loading="loading3" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">来源于财政和捐助资金（单位：元）</span>
                                                    </div>
                                                    <div class="text item">
                                                        <h3>1.扶贫开发项目收益</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 230px">统筹带动增收项目收益</th>
                                                                    <td>{{tableData4_21['统筹带动增收项目收益']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 230px">省定经济薄弱村集体经济项目收益
                                                                    </th>
                                                                    <td>{{tableData4_21['省定经济薄弱村集体经济项目收益']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 230px">产业扶贫项目收益
                                                                    </th>
                                                                    <td>{{tableData4_21['扶贫开发项目收益']}}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 230px">市定经济薄弱村集体经济项目收益</th>
                                                                    <td>{{tableData4_21['市定经济薄弱村集体经济项目收益']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 230px">市扶贫专项项目收益</th>
                                                                    <td>{{tableData4_21['市扶贫专项项目收益']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 180px">直接到户项目补助</th>
                                                                    <td>{{tableData4_21['直接到户项目补助']}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <!-- </el-form> -->
                                                        <h3>2.社会救济和补助</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">农村低保</th>
                                                                    <td style="width: 120">{{tableData4_51['农村低保']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">尊老金
                                                                    </th>
                                                                    <td style="width: 120">{{tableData4_51['尊老金']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">救灾救助
                                                                    </th>
                                                                    <td style="width: 120">{{tableData4_51['救灾救助']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">特困人员供养</th>
                                                                    <td style="width: 120">{{tableData4_51['特困人员供养']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 145px">孤儿监护人缺失补助</th>
                                                                    <td>{{tableData4_51['孤儿监护人缺失补助']}}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">残疾人两项补贴</th>
                                                                    <td style="width: 120">{{tableData4_51['残疾人两项补贴']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">医疗救助</th>
                                                                    <td style="width: 120">{{tableData4_51['医疗救助']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">临时救助</th>
                                                                    <td style="width: 120">{{tableData4_51['临时救助']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">残疾人学生补助</th>
                                                                    <td style="width: 120">{{tableData4_51['残疾人学生补助']}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <h3>3.政策性生产补贴</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">农业补贴</th>
                                                                    <td>{{nyStr}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <h3>4.教育补贴</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">幼儿园助学金</th>
                                                                    <td style="width: 120">{{tableData4_41['幼儿园助学金']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">义务教育助学金</th>
                                                                    <td style="width: 120">{{tableData4_41['义务教育助学金']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">高中助学金</th>
                                                                    <td style="width: 120">{{tableData4_41['高中助学金']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">中职助学金</th>
                                                                    <td style="width: 120">{{tableData4_41['中职助学金']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">困难大学生助学金</th>
                                                                    <td style="width: 120">{{tableData4_41['困难大学生助学金']}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <h3>5.慈善救助</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">阳光助医</th>
                                                                    <td style="width: 120">{{tableData4_11['阳光助医']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">儿童大病救助</th>
                                                                    <td style="width: 120">{{tableData4_11['儿童大病救助']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">扶贫助学</th>
                                                                    <td style="width: 120">{{tableData4_11['扶贫助学']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">计生润家</th>
                                                                    <td style="width: 120">{{tableData4_11['计生润家']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">关爱青少年</th>
                                                                    <td style="width: 120">{{tableData4_11['关爱青少年']}}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">情暖江苏</th>
                                                                    <td style="width: 120">{{tableData4_11['情暖江苏']}}</td>
                                                                    <th scope="row" style="background: #ddd; width: 130px">人道万人捐</th>
                                                                    <td style="width: 120">{{tableData4_11['人道万人捐']}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <h3>6.危房改造补贴</h3>
                                                        <table class="table table-bordered" style="width:50%;">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #ddd; width: 130px">各级政府补贴</th>
                                                                    <td style="width: 120">{{tableData4_61['各级政府补贴']}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" v-loading="loading3" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">明细</span>
                                                    </div>
                                                    <div class="text item">
                                                        <template>
                                                            <el-tabs v-model="activeName2" type="card">
                                                                <el-tab-pane label="扶贫开发项目收益" name="first">
                                                                    <el-table :data="tableData4_2" border style="width: 100%">
                                                                        <el-table-column prop="姓名" label="姓名" width="130"> </el-table-column>
                                                                        <el-table-column prop="年度" label="年度" width="100"> </el-table-column>
                                                                        <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>
                                                                        <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>
                                                                        <el-table-column prop="资金名称" label="资金名称"> </el-table-column>
                                                                        <el-table-column prop="身份证号" label="身份证号" width="200"> </el-table-column>
                                                                        <el-table-column prop="金额" label="金额(元)"> </el-table-column>
                                                                    </el-table>
                                                                </el-tab-pane>
                                                                <el-tab-pane label="社会救济和补助" name="second">
                                                                    <el-table :data="tableData4_5" border style="width: 100%">
                                                                        <el-table-column prop="姓名" label="姓名" width="130"> </el-table-column>
                                                                        <el-table-column prop="年度" label="年度" width="100"> </el-table-column>
                                                                        <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>
                                                                        <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>
                                                                        <el-table-column prop="资金名称" label="资金名称"> </el-table-column>
                                                                        <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                                        <el-table-column prop="金额" label="金额(元)"> </el-table-column>
                                                                    </el-table>
                                                                </el-tab-pane>
                                                                <el-tab-pane label="政策性生产补贴" name="third">
                                                                    <el-table :data="tableData4_3" border style="width: 100%">
                                                                        <el-table-column prop="姓名" label="姓名" width="130"> </el-table-column>
                                                                        <el-table-column prop="年度" label="年度" width="100"> </el-table-column>
                                                                        <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>
                                                                        <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>
                                                                        <el-table-column prop="资金名称" label="资金名称"> </el-table-column>
                                                                        <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                                        <el-table-column prop="金额" label="金额(元)"> </el-table-column>
                                                                    </el-table>
                                                                </el-tab-pane>
                                                                <el-tab-pane label="教育资助" name="forth">
                                                                    <el-table :data="tableData4_4" border style="width: 100%">
                                                                        <el-table-column prop="姓名" label="姓名" width="130"> </el-table-column>
                                                                        <el-table-column prop="年度" label="年度" width="100"> </el-table-column>
                                                                        <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>
                                                                        <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>
                                                                        <el-table-column prop="资金名称" label="资金名称"> </el-table-column>
                                                                        <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                                        <el-table-column prop="金额" label="金额(元)"> </el-table-column>
                                                                    </el-table>
                                                                </el-tab-pane>
                                                                <el-tab-pane label="慈善救助" name="fifth">
                                                                    <el-table :data="tableData4_1" border style="width: 100%">
                                                                        <el-table-column prop="姓名" label="姓名" width="130"> </el-table-column>
                                                                        <el-table-column prop="年度" label="年度" width="100"> </el-table-column>
                                                                        <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>
                                                                        <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>
                                                                        <el-table-column prop="资金名称" label="资金名称"> </el-table-column>
                                                                        <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                                        <el-table-column prop="金额" label="金额(元)"> </el-table-column>
                                                                    </el-table>
                                                                </el-tab-pane>
                                                                <el-tab-pane label="危房改造补贴" name="sixth">
                                                                    <el-table :data="tableData4_6" border style="width: 100%">
                                                                        <el-table-column prop="姓名" label="姓名" width="130"> </el-table-column>
                                                                        <el-table-column prop="年度" label="年度" width="100"> </el-table-column>
                                                                        <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>
                                                                        <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>
                                                                        <el-table-column prop="资金名称" label="资金名称"> </el-table-column>
                                                                        <el-table-column prop="资金类型" label="资金类型"> </el-table-column>
                                                                        <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                                        <el-table-column prop="金额" label="金额(元)"> </el-table-column>
                                                                    </el-table>
                                                                </el-tab-pane>
                                                            </el-tabs>
                                                        </template>
                                                    </div>
                                                </el-card>
                                            </el-tab-pane>
                                            <el-tab-pane label="项目实施" name="forth">
                                                <el-table :data="tableData5" border style="width: 100%">
                                                    <el-table-column prop="项目名称" label="项目名称"> </el-table-column>
                                                    <el-table-column prop="项目类别" label="项目类别"> </el-table-column>
                                                    <el-table-column prop="项目地点" label="项目地点"> </el-table-column>
                                                    <el-table-column prop="启动时间" label="启动时间"> </el-table-column>
                                                    <el-table-column prop="项目进展" label="项目进展"> </el-table-column>
                                                    <el-table-column prop="项目阶段性收益" label="项目阶段性收益（元）"> </el-table-column>
                                                    <el-table-column prop="项目实施存在困难" label="项目实施存在困难"> </el-table-column>
                                                </el-table>
                                            </el-tab-pane>
                                            <el-tab-pane label="帮扶力量" name="fifth">
                                                <el-table :data="tableData2" style="width: 100%">
                                                    <el-table-column type="expand"> <template scope="props">
                                                            <el-table :data="props.row['走访记录']" border style="width: 100%">
                                                                <el-table-column prop="年度" label="年度"> </el-table-column>
                                                                <el-table-column prop="季度" label="季度"> </el-table-column>
                                                                <el-table-column prop="走访时间" label="走访时间"> </el-table-column>
                                                                <!-- <el-table-column prop="帮扶措施" label="帮扶措施"> </el-table-column> -->
                                                                <!-- <el-table-column prop="预计脱贫年度" label="预计脱贫年度"> </el-table-column> -->
                                                                <el-table-column label="查看走访记录"> <template scope="props">
                                                                        <el-button size="small" @click="opendia(props.row['走访时间'],props.row['帮扶人编号'],props.row['贫困户编号'])" :data-opend="props.row['走访时间']"> 查看</el-button>
                                                                    </template> </el-table-column>
                                                            </el-table> <!-- :data-createData="props.row['走访时间']" -->
                                                        </template> </el-table-column>
                                                    <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                    <el-table-column prop="单位" label="单位"> </el-table-column>
                                                    <el-table-column prop="职务" label="职务"> </el-table-column>
                                                    <el-table-column prop="联系方式" label="联系方式"> </el-table-column>
                                                </el-table>
                                            </el-tab-pane>
                                            <el-tab-pane label="脱贫信息" name="tab_tpxx">
                                                <div class="nothing" v-if="!table_tpxx || table_tpxx.length==0">无相关数据</div>
                                                <el-card class="box-card" v-loading="loading5" element-loading-text="拼命加载中" v-for="(item,index) in table_tpxx">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">{{item.nd}}年脱贫信息情况</span>
                                                        <div class="el-table__expand-icon btn_openTabItem" :data-toggle="'tpxx_table_'+index" style="float:right;height: 23px;width: 30px;"><i class="el-icon el-icon-arrow-down"></i></div>
                                                    </div>
                                                    <div class="text item" :id="'tpxx_table_'+index">
                                                        <h3>1.阳光扶贫系统采集收入（单位：元）</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">全年收入（采集）</th>
                                                                    <td style="width: 25%">{{item.yjqnsr}}</td>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">人均收入（采集）</th>
                                                                    <td style="width: 25%">{{item.rjsrcj}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <!-- </el-form> -->
                                                        <h3>2.乡镇脱贫审核（单位：元）</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">总收入</th>
                                                                    <td style="width: 25%">{{item.zsr}}</td>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">人均收入</th>
                                                                    <td style="width: 25%">{{item.rjsj}}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">工资性收入</th>
                                                                    <td style="width: 25%">{{item.gzxsr}}</td>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">生产经营性收入</th>
                                                                    <td style="width: 25%">{{item.scjyxsr}}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">财产性收入</th>
                                                                    <td style="width: 25%">{{item.ccxsr}}</td>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">转移性收入</th>
                                                                    <td style="width: 25%">{{item.zyxsr}}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">其他收入</th>
                                                                    <td style="width: 25%">{{item.qtsr}}</td>
                                                                    <th style="background: #eef1f6; width: 25%"></th>
                                                                    <td></td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">脱贫年度</th>
                                                                    <td colspan="3">
                                                                        {{item.tpnd}}
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">签字确认附件</th>
                                                                    <td colspan="3">
                                                                        <div class="a_con" v-for="item_qzqrfj in item.qzqrfjList"><a :href="'http://ygfp.huaian.gov.cn/web/views/jzfp/img_show.html?imgUrl='+encodeURIComponent(item_qzqrfj)" target="_Blank">{{decodeURI(item_qzqrfj.substr(item_qzqrfj.lastIndexOf('/')+1,item_qzqrfj.length))}}</a></div>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                        <h3>3.县区脱贫审核</h3>
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">公示材料</th>
                                                                    <td colspan="3">
                                                                        <div class="a_con" v-for="item_gscl in item.gsclList">
                                                                            <a v-show="isImg(item_gscl)" :href="'http://ygfp.huaian.gov.cn/web/views/jzfp/img_show.html?imgUrl='+encodeURIComponent(item_gscl)" target="_Blank">{{decodeURI(item_gscl.substr(item_gscl.lastIndexOf('/')+1,item_gscl.length))}}</a>
                                                                            <a v-show="!isImg(item_gscl)" :href="item_gscl" target="_Blank">{{decodeURI(item_gscl.substr(item_gscl.lastIndexOf('/')+1,item_gscl.length))}}</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">审核人</th>
                                                                    <td style="width: 25%">{{item.shr}}</td>
                                                                    <th scope="row" style="background: #eef1f6; width: 25%">审核日期</th>
                                                                    <td style="width: 25%">{{item.shsj?((new Date(item.shsj)).getFullYear()+'年'+((new Date(item.shsj)).getMonth()+1)+'月'+(new Date(item.shsj)).getDate()+'日'):''}}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </el-card>
                                            </el-tab-pane>
                                           <!--  <el-tab-pane label="医疗数据" name="tab_medical_data">
                                                <el-card class="box-card" v-loading="loading2" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">数据一览</span>
                                                    </div>
                                                    <div class="text item" id="medicalDiv">
                                                        <el-table :data="tableData6" border style="width: 100%">
                                                            <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                            <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                            <el-table-column prop="入院日期" label="入院日期"> </el-table-column>
                                                            <el-table-column prop="出院日期" label="出院日期"> </el-table-column>
                                                            <el-table-column prop="入院诊断名称" label="入院诊断名称"> </el-table-column>
                                                            <el-table-column prop="出院诊断名称" label="出院诊断名称"> </el-table-column>
                                                            <el-table-column prop="医疗费用总额" label="医疗费用总额"> </el-table-column>
                                                            <el-table-column prop="现金支付" label="现金支付"> </el-table-column>
                                                            <el-table-column label="操作">
                                                                <template scope="props">
                                                                    <el-button size="small" :data-id="props.row['贫困户编号']" onclick="detailMedical(this)">查看</el-button>
                                                                </template>
                                                            </el-table-column>
                                                        </el-table>
                                                    </div>
                                                    <el-card class="box-card" style="width:100%" v-show="(showDetail=='false')? false:true">
                                                        <div slot="header" class="clearfix">
                                                            <span style="line-height: 25px;">数据详情</span>
                                                        </div>
                                                        <div class="text item">
                                                            <el-table :data="tableData6_1" border style="width: 100%">
                                                                <el-table-column prop="姓名" label="姓名"></el-table-column>
                                                                <el-table-column prop="身份证号" label="身份证号"></el-table-column>
                                                                <el-table-column prop="县" label="县"></el-table-column>
                                                                <el-table-column prop="乡" label="乡"></el-table-column>
                                                                <el-table-column prop="村" label="村"></el-table-column>
                                                                <el-table-column prop="金保姓名" label="金保姓名"></el-table-column>
                                                                <el-table-column prop="扶贫个人编号" label="扶贫个人编号"></el-table-column>
                                                                <el-table-column prop="人员类别" label="人员类别"></el-table-column>
                                                                <el-table-column prop="民政人员类别" label="民政人员类别"></el-table-column>
                                                                <el-table-column prop="医疗类别" label="医疗类别"></el-table-column>
                                                            </el-table>
                                                            <el-table :data="tableData6_2" border style="width: 100%">
                                                                <el-table-column prop="入院日期" label="入院日期"></el-table-column>
                                                                <el-table-column prop="出院日期" label="出院日期"></el-table-column>
                                                                <el-table-column prop="入院诊断名称" label="入院诊断名称"></el-table-column>
                                                                <el-table-column prop="出院诊断名称" label="出院诊断名称"></el-table-column>
                                                                <el-table-column prop="医疗费用总额" label="医疗费用总额"></el-table-column>
                                                                <el-table-column prop="统筹支付" label="统筹支付"></el-table-column>
                                                                <el-table-column prop="大病支付" label="大病支付"></el-table-column>
                                                                <el-table-column prop="账户支付" label="账户支付"></el-table-column>
                                                                <el-table-column prop="民政支付" label="民政支付"></el-table-column>
                                                                <el-table-column prop="现金支付" label="现金支付"></el-table-column>
                                                            </el-table>
                                                        </div>
                                                    </el-card>
                                                </el-card>
                                            </el-tab-pane> -->
                                            <el-tab-pane label="两不愁三保障" name="tab_lbcsbz_data">
                                                <el-card class="box-card" v-loading="loading8_6" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">两不愁</span>
                                                    </div>
                                                    <div class="text item" v-if="tableData8_6_1[0] && tableData8_6_1[0]['脱贫年度']">
                                                    		<div class="item_title">乡镇认定收入</div>
                                                        <el-table :data="tableData8_6_1" border style="width: 100%">
                                                            <el-table-column prop="生产经营性收入（乡镇认定）" label="经营性收入"> </el-table-column>
                                                            <el-table-column prop="工资性收入（乡镇认定）" label="工资性收入"> </el-table-column>
                                                            <el-table-column prop="财产性收入（乡镇认定）" label="财产性收入"> </el-table-column>
                                                            <el-table-column prop="转移性收入（乡镇认定）" label="转移性收入"> </el-table-column>  
                                                            <el-table-column prop="其他收入（乡镇认定）" label="其他"> </el-table-column>  
                                                            <el-table-column prop="总收入（乡镇认定）" label="总收入"> </el-table-column>  
                                                            <el-table-column prop="家庭人均收入（乡镇认定）" label="人均收入"> </el-table-column>  
                                                        </el-table>
                                                    </div>
                                                    <div class="text item">
                                                    		<div class="item_title">帮扶责任人采集收入</div>
                                                        <el-table :data="tableData8_6_1" border style="width: 100%">
                                                            <el-table-column prop="生产经营性收入（帮扶采集）" label="经营性收入"> </el-table-column>
                                                            <el-table-column prop="工资性收入（帮扶采集）" label="工资性收入"> </el-table-column>
                                                            <el-table-column prop="财产性收入（帮扶采集）" label="财产性收入"> </el-table-column>
                                                            <el-table-column prop="转移性收入（帮扶采集）" label="转移性收入"> </el-table-column>  
                                                            <el-table-column prop="其他收入（帮扶采集）" label="其他"> </el-table-column>  
                                                            <el-table-column prop="家庭收入（帮扶采集）" label="总收入"> </el-table-column>  
                                                            <el-table-column prop="人均收入（帮扶采集）" label="人均收入"> </el-table-column>  
                                                        </el-table>
                                                    </div>
                                                    <div class="text item">
                                                    		<table class="myTable">
                                                    			<tr>
                                                    				<th>脱贫年度</th>
                                                    				<td>{{tableData8_6_1[0]?(tableData8_6_1[0]['脱贫年度']?tableData8_6_1[0]['脱贫年度']:'未脱贫'):''}}</td>
                                                    				<th>是否预警</th>
                                                    				<td>{{tableData8_6_1[0]?tableData8_6_1[0]['是否预警']:''}}</td>
                                                    				<th>调查结果</th>
                                                    				<td>{{tableData8_6_1[0]?tableData8_6_1[0]['处理结果']:''}}</td>
                                                    			</tr>
                                                    		</table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" v-loading="loading8_1" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">义务教育有保障</span>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData8_1_1" border style="width: 100%">
                                                            <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                            <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                            <el-table-column prop="所在学校" label="所在学校"> </el-table-column>
                                                            <el-table-column prop="年度" label="年度"> </el-table-column>                                                            
                                                        </el-table>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData8_1_2" border style="width: 100%">
                                                            <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                            <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                             <el-table-column prop="资金名称" label="资金名称"> </el-table-column>                                                            
                                                            <el-table-column prop="金额" label="金额"> </el-table-column>
                                                            <el-table-column prop="拨款状态" label="拨款状态"> </el-table-column>   
                                                            <el-table-column prop="拨款时间" label="拨款时间"> </el-table-column>                                                                                                                     
                                                        </el-table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" v-loading="loading8_2" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">住房安全有保障</span>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData8_2" border style="width: 100%">
                                                            <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                            <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                            <el-table-column prop="年度" label="年度"> </el-table-column>
                                                            <el-table-column prop="改造方式" label="改造方式"> </el-table-column>
                                                            <el-table-column prop="改造金额" label="改造金额"> </el-table-column>
                                                            <el-table-column prop="联系电话" label="联系电话"> </el-table-column>
                                                        </el-table>
                                                    </div>
                                                    <div class="text item">
                                                        <div class="photo_name">住房照片</div>
                                                        <div class="photo_con">
                                                        	<el-table :data="photoData8_2_2" border style="width: 100%">
                                                            <el-table-column prop="是否危房" label="是否疑似危房"> </el-table-column>
                                                            <el-table-column label="住房照片"> 
		                                                    		<template scope="props">
		                                                    		  <a :href="props.row['住房照片']" target="_blank" class="el-button el-button--default el-button--small" v-if="props.row['住房照片']">查看</a>
                                                                </template>
		                                                    </el-table-column>
                                                        	</el-table>
                                                        </div>
                                                    </div>
                                                    
                                                    <!-- 
                                                    <div class="text item">
                                                        <div class="photo_name">饮水安全有保障</div>
                                                        <div class="photo_con">
                                                        	<el-table :data="waterData8_1_1" border style="width: 100%">
                                                            <el-table-column prop="是否饮水安全有保障" label="是否饮水安全有保障"> </el-table-column>
                                                        	</el-table>
                                                        </div>
                                                    </div>
                                                     -->
                                                     <div class="text item">
                                                             <div class="photo_name">饮水安全有保障</div>
                                                     
                                                    		<table class="myTable">
                                                    			<tr>
                                                    		<th>是否饮水安全有保障</th>
                                                    				<td>{{waterData8_1_1[0]?(waterData8_1_1[0]['是否饮水安全有保障']?waterData8_1_1[0]['是否饮水安全有保障']:''):''}}</td>
                                                    			</tr>
                                                    		</table>
                                                    </div>
                                                </el-card>
                                                
                                                
                                                
                                                <el-card class="box-card" v-loading="loading8_3" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">基本医疗有保障</span>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData8_3" border style="width: 100%">
                                                            <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                                            <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
                                                            <el-table-column prop="病种" label="病种"> </el-table-column>
                                                            <el-table-column prop="费用" label="医疗费用总额"> </el-table-column>
                                                            <el-table-column prop="统筹支付" label="现金支付"> </el-table-column>
                                                            <el-table-column prop="出院时间" label="出院时间"> </el-table-column>
                                                            <el-table-column prop="缴费时间" label="缴费时间"> </el-table-column>
                                                        </el-table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" v-loading="loading8_7" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">参保类型</span>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData8_7" border style="width: 100%">
                                                        	   <el-table-column prop="姓名" label="姓名" > </el-table-column>
                                                            <el-table-column prop="参保类型" label="参保类型" > </el-table-column>
                                                           <!--  <el-table-column prop="处理结果" label="处理结果"> </el-table-column>
                                                            <el-table-column prop="是否预警" label="是否预警"> </el-table-column>
                                                            	<el-table-column label="附件">
					                                            <template scope="props">
					                                            		<a v-for="fujian in props.row['附件']" :href="fujian.url" target="_blank">{{fujian.name}}<br></a>
					                                            </template>
					                                        </el-table-column> -->
                                                        </el-table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" v-loading="loading8_3" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">签约家庭医生</span>
                                                    </div>
                                                    <div class="text item">
                                                        <el-table :data="tableData8_4" border style="width: 100%">
                                                            <el-table-column prop="医生姓名" label="医生姓名"> </el-table-column>
                                                            <el-table-column prop="所属医疗机构" label="所属医疗机构"> </el-table-column>
                                                            <el-table-column prop="联系电话" label="联系电话"> </el-table-column>
                                                        </el-table>
                                                    </div>
                                                </el-card>
                                                <el-card class="box-card" v-loading="loading8_5" element-loading-text="拼命加载中">
                                                    <div slot="header" class="clearfix">
                                                        <span style="line-height: 25px;">疫苗接种</span>
                                                    </div>
                                                    <div class="text item">
                                                    	  <el-table :data="tableData8_5" style="width: 100%">
		                                                    <el-table-column type="expand"> 
		                                                    		<template scope="props">
		                                                            <el-table :data="props.row['疫苗']" border style="width: 100%">
		                                                                <el-table-column prop="疫苗类型" label="疫苗类型"> </el-table-column>
		                                                                <el-table-column prop="接种日期" label="接种日期"> </el-table-column>
		                                                            </el-table> 
		                                                        </template> 
		                                                    </el-table-column>
		                                                    <el-table-column prop="姓名" label="姓名"> </el-table-column>
		                                                    <el-table-column prop="身份证号" label="身份证号"> </el-table-column>
		                                                </el-table>
                                                    </div>
                                                </el-card>
                                            </el-tab-pane>
                                        </el-tabs>
                                    </template>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看模态 -->
                <div class="modal fade bs-example-modal-lg" id="myModalDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document" style="width: 50%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h3 class="modal-title">就业情况</h3>
                            </div>
                            <div class="modal-body">
                                <div id="app_detail">
                                    <el-table :data="table_jyqk" border style="width: 100%">
                                        <el-table-column prop="姓名" label="姓名"> </el-table-column>
                                        <el-table-column prop="就业单位" label="就业单位"> </el-table-column>
                                        <!-- <el-table-column prop="入职岗位" label="入职岗位"> </el-table-column> -->
                                        <el-table-column label="入职时间">
                                            <template scope="props">
                                                <span>{{new Date(props.row.rzsj).getFullYear()+'年'+(new Date(props.row.rzsj).getMonth()+1)+'月'+new Date(props.row.rzsj).getDate()+'日'}}</span>
                                            </template>
                                        </el-table-column>
                                    </el-table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
    var allId, ajaxId, ajaxNd, ajaxSfzh;
    var app_jyqk = new Vue({
        el: '#app_detail',
        data: {
            table_jyqk: []
        }
    })
    var app = new Vue({
        el: '#app',
        data: function() {
            return {
                activeName: 'first',
                activeName2: 'first',
                isShow: 'false',
                tableData1: [],
                tableData1_2: [],
                tableData2: [],
                tableData3: [],
                tableData4_1: [],
                tableData4_2: [],
                tableData4_3: [],
                tableData4_4: [],
                tableData4_5: [],
                tableData4_6: [],
                tableData4_11: {},
                tableData4_21: {},
                tableData4_31: {},
                tableData4_41: {},
                tableData4_51: {},
                tableData4_61: {},
                tableData5: [],
                tableData6: [],
                tableData6_1: [],
                tableData6_2: [],
                loading2: true,
                loading3: true,
                loading5: true,
                opendiaPkhbh: '2016100000372261233',
                opendiaBfrId: '08c935762c6a4d5ca2e58b9abebece51',
                opendiaCreateDate: '2017-08-31 17:01:45',
                opendiaSfzh: '320826196612174212',
                tableData3_1: [],
                tableData3_2: [],
                tableData3_3: [],
                tableData3_4: [],
                tableData3_5: [],
                tableData3_6: [],
                table_tpxx: { qzqrfjList: [], gsclList: [] },
                showDetail: 'false',
                nyStr: '',
                tableDataIncomeOther: [],
                tableData8_1_1:[],
                tableData8_1_2:[],
                loading8_1: true,
                tableData8_2: [],
                photoData8_2_2:[],
                waterData8_1_1:[],
                loading8_2:true,
                tableData8_3: [],
                loading8_3:true,
                tableData8_4: [],
                tableData8_5: [],
                loading8_5:true,
                loading8_6:true,
                tableData8_6_1:[],
                tableData8_6_2:[],
                loading8_7:true,
                tableData8_7:[]
            };
        },
        methods: {
            opendia(that1, that2, pkhbh) {
                /* console.log(that1+':'+that2) */
                openDialogView('查看走访记录详情', '${ctx}/bfll/jiangsuAk11/rhzfDetail?pkhbh=' + pkhbh + '&bfrId=' + that2 + '&createDate=' + that1 + '&sfzh=' + this.opendiaSfzh, '800px', '500px')

            },
            showWorksDetail: function(props) {
                app_jyqk.table_jyqk = [props.row];
            },
            isImg: function(url) {
                var temp_fileLastName_arr = url.split('.');
                var fileLastName = temp_fileLastName_arr[temp_fileLastName_arr.length - 1];
                fileLastName = fileLastName.toLowerCase();
                if (fileLastName == 'png' || fileLastName == 'jpg' || fileLastName == 'bmp' || fileLastName == 'jpeg' || fileLastName == 'gif') {
                    return true;
                }
                return false;

            },
            handleClick() {
                app.loading5 = false;
                if (app.activeName == 'second') {

                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getJdlkhsrxx',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            id: ajaxId,
                            nd: ajaxNd,
                            sfzh: ajaxSfzh
                        }
                    }).done(function(res) {
                        console.log(res)
                        app.tableData3 = res['收入信息']['脱贫轨迹'];
                        app.tableData4_1 = res['收入信息']['财政和捐助资金']['慈善救助'];
                        app.tableData4_2 = res['收入信息']['财政和捐助资金']['扶贫开发项目收益'];
                        app.tableData4_3 = res['收入信息']['财政和捐助资金']['政策性生产补贴'];
                        app.tableData4_4 = res['收入信息']['财政和捐助资金']['教育资助'];
                        app.tableData4_5 = res['收入信息']['财政和捐助资金']['社会救济和补助'];
                        app.tableData4_6 = res['收入信息']['财政和捐助资金']['危房改造补贴'];
                        app.tableData4_11 = res['收入信息']['财政和捐助资金']['慈善救助合计'];
                        app.tableData4_21 = res['收入信息']['财政和捐助资金']['扶贫开发项目收益合计'];
                        app.tableData4_31 = res['收入信息']['财政和捐助资金']['政策性生产补贴合计'];
                        app.tableData4_41 = res['收入信息']['财政和捐助资金']['教育资助合计'];
                        app.tableData4_51 = res['收入信息']['财政和捐助资金']['社会救济和补助合计'];
                        app.tableData4_61 = res['收入信息']['财政和捐助资金']['危房改造补贴合计'];
                        app.nyStr = res['收入信息']['财政和捐助资金']['政策性生产补贴合计']['农业补贴']
                        app.loading2 = false
                    }).fail(function(data) {
                        alert('请求失败')
                        console.log(data);

                    });
                } else if (app.activeName == 'forth') {

                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getJdlkhxmss',
                        timeout: 15000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            id: ajaxId,
                            nd: ajaxNd,
                            sfzh: ajaxSfzh
                        }
                    }).done(function(res) {
                        /* console.log(res) */
                        app.tableData5 = res['帮扶项目'];
                    }).fail(function(data) {
                        console.log(data);
                    });
                } else if (app.activeName == 'fifth') {
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getJdlkhbfll',
                        timeout: 15000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            id: ajaxId,
                            nd: ajaxNd,
                            sfzh: ajaxSfzh
                        }
                    }).done(function(res) {

                        var bfllData = [];
                        $.each(res['帮扶力量'], function(index) {

                            bfllData.push(res['帮扶力量'][index]['帮扶责任人'])
                        })
                        app.tableData2 = bfllData;
                        /* console.log(bfllData) */
                    }).fail(function(data) {
                        console.log(data);
                    });
                } else if (app.activeName == 'third') {
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getJdlkhsrxx',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            id: ajaxId,
                            nd: ajaxNd,
                            sfzh: ajaxSfzh
                        }
                    }).done(function(res) {
                        console.log(res['收入信息']['财政和捐助资金']['政策性生产补贴合计']['农业补贴'])
                        app.tableData3 = res['收入信息']['脱贫轨迹'];
                        app.tableData4_1 = res['收入信息']['财政和捐助资金']['慈善救助'];
                        app.tableData4_2 = res['收入信息']['财政和捐助资金']['扶贫开发项目收益'];
                        app.tableData4_3 = res['收入信息']['财政和捐助资金']['政策性生产补贴'];
                        app.tableData4_4 = res['收入信息']['财政和捐助资金']['教育资助'];
                        app.tableData4_5 = res['收入信息']['财政和捐助资金']['社会救济和补助'];
                        app.tableData4_6 = res['收入信息']['财政和捐助资金']['危房改造补贴'];
                        app.tableData4_11 = res['收入信息']['财政和捐助资金']['慈善救助合计'];
                        app.tableData4_21 = res['收入信息']['财政和捐助资金']['扶贫开发项目收益合计'];
                        app.tableData4_31 = res['收入信息']['财政和捐助资金']['政策性生产补贴合计'];
                        app.tableData4_41 = res['收入信息']['财政和捐助资金']['教育资助合计'];
                        app.tableData4_51 = res['收入信息']['财政和捐助资金']['社会救济和补助合计'];
                        app.tableData4_61 = res['收入信息']['财政和捐助资金']['危房改造补贴合计'];
                        app.nyStr = res['收入信息']['财政和捐助资金']['政策性生产补贴合计']['农业补贴']
                        app.loading3 = false

                    }).fail(function(data) {
                        alert('请求失败')
                        console.log(data);

                    });
                } else if (app.activeName == 'tab_tpxx') {
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getTpqk0',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            id: ajaxId,
                            nd: ajaxNd,
                            sfzh: ajaxSfzh
                        }
                    }).done(function(res) {
                        app.table_tpxx = res;
                        app.loading5 = false;
                    }).fail(function(data) {
                        alert('请求失败')
                        console.log(data);

                    });
                } else if (app.activeName == 'tab_medical_data') {
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getMedicalData',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            idCard: ajaxSfzh
                        }
                    }).done(function(res) {
                        app.tableData6 = res['医疗数据']['数据一览'];
                        if (app.tableData6.length > 10) {
                            $("#medicalDiv").css('height', '500px');
                            $("#medicalDiv").css('overflow', 'auto');
                        }
                        app.loading2 = false;
                    }).fail(function(data) {
                        alert('请求失败')
                    });
                } else if (app.activeName == 'tab_lbcsbz_data') {
                	//获取收入信息
                	$.ajax({
                        type: "get",
                        url: '${ctx}/zfaqbz/tZfgzqk/getLbcxx',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            acid: ajaxId,
                        }
                    }).done(function(res) {
                        console.log(res)
                        app.tableData8_6_1 = res;
                    }).fail(function(data) {
                        alert('请求失败')
                        console.log(data);
                    });
                	$.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getJdlkhsrxx',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                            id: ajaxId,
                            nd: ajaxNd,
                            sfzh: ajaxSfzh
                        }
                    }).done(function(res) {
                    	app.loading8_6 = false;
                        var nowYear = (new Date()).getFullYear();
                        var useData;
                        for(var i = 0;i<res['收入信息']['脱贫轨迹'].length;i++){
                            if(res['收入信息']['脱贫轨迹'][i]['年度'] == nowYear && res['收入信息']['脱贫轨迹'][i]['季度'] == '第一季度'){
                            		useData = res['收入信息']['脱贫轨迹'][i];
                            }
                        }
                        if(useData){
	                        $.ajax({
	                            type: "get",
	                            url: '${ctx}/datacount/jdlkhzh/getSrgc',
	                            timeout: 15000,
	                            dataType: 'jsonp',
	                            jsonp: 'callback',
	                            data: {
	                                id: useData['贫困户编号'],
	                                createDate: useData['走访时间']
	                            }
	                        }).done(function(res) {
	                        		console.log(1111111,res);
                               // app.loading8_6 = false;
                                
                                app.tableData8_6_2[0] = {};
                                app.tableData8_6_2[0]['经营性收入'] = 0;
                                for(var key in res['经营性收入']){
                                		if(!isNaN(res['经营性收入'][key])){
                                			app.tableData8_6_2[0]['经营性收入'] += res['经营性收入'][key]-0;
                                		}
                                }
                                
                                app.tableData8_6_2[0]['工资性收入'] = 0;
                                for(var i = 0;i<res['工资性收入'].length;i++){
                                		app.tableData8_6_2[0]['工资性收入'] += res['工资性收入'][i]['今年以来收入']-0;
                                }
                                app.tableData8_6_2[0]['工资性收入'] += res['工资性其他收入']-0
                                
                                app.tableData8_6_2[0]['财产性收入'] = 0;
                                for(var key in res['财产性收入']){
                                		if(!isNaN(res['财产性收入'][key])){
                                			app.tableData8_6_2[0]['财产性收入'] += res['财产性收入'][key]-0;
                                		}
                                }
                                
                                app.tableData8_6_2[0]['转移性收入'] = 0;
                                for(var key in res['转移性收入']){
                                		if(!isNaN(res['转移性收入'][key])){
                                			app.tableData8_6_2[0]['转移性收入'] += res['转移性收入'][key]-0;
                                		}
                                }
		                        	
                                app.tableData8_6_2[0]['其他'] = 0;
                                for(var key in res['其他']){
                                		if(!isNaN(res['其他'][key])){
                                			app.tableData8_6_2[0]['其他'] += res['其他'][key]-0;
                                		}
                                }
                                
                                app.tableData8_6_2[0]['总收入'] = app.tableData8_6_2[0]['经营性收入']+app.tableData8_6_2[0]['工资性收入']
                                +app.tableData8_6_2[0]['财产性收入']+app.tableData8_6_2[0]['转移性收入']+app.tableData8_6_2[0]['其他'];
                                
                                app.tableData8_6_2[0]['人均收入'] = (app.tableData8_6_2[0]['总收入']/app.tableData8_6_1[0]['家庭人口数']).toFixed(2);
	                        }).fail(function() {
	                            alert('请求失败')
	                        })
                        }
                    }).fail(function(data) {
                        alert('请求失败')
                        console.log(data);

                    });
                	

                    //义务教育有保障
                    $.ajax({
                        type: "get",
                        url: '${ctx}/ywjnybz/tYwjnybzHuzhu/getYwjnybzDetail',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                        		sfzh: ajaxSfzh,
                                nd: ajaxNd
                        }
                    }).done(function(res) {
                       app.loading8_1 = false;
                       app.tableData8_1_1 = res.ywjyXx;
                       app.tableData8_1_2 = res.ywjyList;
                    }).fail(function(data) {
                        alert('请求失败')
                    });
                    

                    //住房安全有保障
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getZfaqbzDetail',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                        		sfzh: ajaxSfzh
                        			//'320882199011113830'
                    			//ajaxSfzh
                        }
                    }).done(function(res) {
                       app.loading8_2 = false;
                       console.log('tableData8_2_res',res);
                       app.tableData8_2 = res;
                    }).fail(function(data) {
                        alert('请求失败')
                    });
                    //住房安全有保障 : 住房照片
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getZfPhotoDetail',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                        		sfzh: ajaxSfzh
                        			//'320882199011113830'
                    			//ajaxSfzh
                        }
                    }).done(function(res) {
                    		app.photoData8_2_2 = res;
                       console.log('photoData8_2_2_res',res);
                    }).fail(function(data) {
                        alert('请求失败')
                    });
                    
                    //饮水安全有保障 
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getWaterGuarantee',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                    		id: ajaxId
                        }
                    }).done(function(res) {
                    		app.waterData8_1_1 = res;
                    }).fail(function(data) {
                        // alert('请求失败')
                    });
                    

                    //疫苗接种
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getTYufangjzDetail',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                        		sfzh: ajaxSfzh
                        }
                    }).done(function(res) {
                       app.loading8_5 = false;
                       app.tableData8_5 = res;
                    }).fail(function(data) {
                        alert('请求失败')
                    });
                    
                    //参保类型
                    $.ajax({
                        type: "get",
                        url: '${ctx}/zfaqbz/tZfgzqk/getLbcCbxxNew',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                        		acid: ajaxId
                        }
                    }).done(function(res) {
                       app.loading8_7 = false;
                       /* var useData = [];
                       for(var i=0;i<res.length;i++){
	                    	   if(res[i]['姓名']=='无'){
	                    		   continue;
	                    	   }
	                    	   useData.push(res[i]);
                       } */
                       app.tableData8_7 = res;
                       
                    }).fail(function(data) {
                        alert('请求失败')
                    });
                    

                    //基本医疗有保障.签约家庭医生
                    $.ajax({
                        type: "get",
                        url: '${ctx}/datacount/jdlkhzh/getYlbzxx',
                        timeout: 150000,
                        dataType: 'jsonp',
                        jsonp: 'callback',
                        data: {
                        		id: ajaxId
                        }
                    }).done(function(res) {
                       app.loading8_3 = false;
                       console.log(res);
                       app.tableData8_3 = res.ylsjxx;
                       app.tableData8_4 = res.ylqyxx;
                    }).fail(function(data) {
                        alert('请求失败')
                    });

                }
            }
        }
    });
    </script>
    <script>
    function getName(that) {
        app.loading2 = true;
        app.showDetail = 'false';
        app.activeName =  'first';
        app.activeName2 = 'first';
        /* 户主信息  */

        var poorName = $(that).parent().parent().children('td').eq(3).text().replace(/\s/g, "");
        var sfzh = $(that).parent().parent().children('td').eq(4).text().replace(/\s/g, "");
        var address = $(that).parent().parent().children('td').eq(2).text().replace(/\s/g, "");
        var peopleCounts = $(that).parent().parent().children('td').eq(5).text().replace(/\s/g, "");
        var phone = $(that).parent().parent().children('td').eq(6).text().replace(/\s/g, "");
        var pkhsx = $(that).parent().parent().children('td').eq(7).text().replace(/\s/g, "");
        var zpyy = $(that).parent().parent().children('td').eq(8).text().replace(/\s/g, "");
        app.opendiaSfzh = sfzh;

        app.tableData1_2 = [{
            '户主姓名': poorName,
            '省份证号': sfzh,
            '家庭住址': address,
            '家庭人口': peopleCounts,
            '联系方式': phone,
            '贫困户属性': pkhsx,
            '致贫原因': zpyy
        }]
        ajaxId = $(that).parent().parent().children('td').eq(0).find('div input').attr('id');
        app.opendiaPkhbh = ajaxId
        allId = ajaxId
        ajaxNd = $(that).parent().parent().children('td').eq(1).text().replace(/\s/g, "");
        ajaxSfzh = $(that).parent().parent().children('td').eq(4).text().replace(/\s/g, "");
        $.ajax({
            type: "get",
            url: '${ctx}/datacount/jdlkhzh/getJdlkhxx',
            timeout: 15000,
            dataType: 'jsonp',
            jsonp: 'callback',
            data: {
                id: ajaxId,
                nd: ajaxNd,
                sfzh: ajaxSfzh
            }
        }).done(function(res) {

            app.tableData1 = res['家庭信息'];
            $('#app').css('display', 'block')

        }).fail(function(data) {
            console.log(data);
        });



        var poortTitle = '贫困户' + poorName + '的详细信息';
        $('.modal-title-content').html(poortTitle)

        /*  */
    }
    /* 绑定点击事件 */

    function detailTable(that) {

        var ajaxCreateDate = $(that).attr('data-createdate');
        var pkhCode = $(that).attr('data-pkhCode');
        app.showDetail = 'false'
        $.ajax({
            type: "get",
            url: '${ctx}/datacount/jdlkhzh/getSrgc',
            timeout: 15000,
            dataType: 'jsonp',
            jsonp: 'callback',
            data: {
                id: pkhCode,
                createDate: ajaxCreateDate
            }
        }).done(function(res) {
            console.log(res['工资性其他收入'])
            app.tableDataIncomeOther = [{ '工资性其他收入': res['工资性其他收入'] }]

            app.tableData3_1 = [res['经营性收入']];
            app.tableData3_2 = res['工资性收入']
            app.tableData3_3 = [res['财产性收入']]
            app.tableData3_4 = [res['转移性收入']]
            app.tableData3_5 = [res['其他']]
            app.tableData3_6 = [res['帮扶人详请']]
            app.showDetail = 'true'
        }).fail(function() {
            alert('请求失败')
        })
    }

    function detailMedical(that) {
        var id = $(that).attr('data-id');
        app.showDetail = 'false';
        $.ajax({
            type: "get",
            url: '${ctx}/datacount/jdlkhzh/getMedicalDetail',
            timeout: 15000,
            dataType: 'jsonp',
            jsonp: 'callback',
            data: {
                id: id
            }
        }).done(function(res) {
            app.tableData6_1 = [res];
            app.tableData6_2 = [res];
            app.showDetail = 'true';
        }).fail(function() {
            alert('请求失败');
        })
    }

    function toogleContent(){
        console.log(123);
        if($("#xq_con_arrow").hasClass("glyphicon-chevron-down")){
            $("#xq_con_arrow").removeClass("glyphicon-chevron-down");
            $("#xq_con_arrow").addClass("glyphicon-chevron-up");

        }else if($("#xq_con_arrow").hasClass("glyphicon-chevron-up")){
            $("#xq_con_arrow").removeClass("glyphicon-chevron-up");
            $("#xq_con_arrow").addClass("glyphicon-chevron-down");
        }
        $('.xq_con').toggle();
    }
    </script>
</body>

</html>