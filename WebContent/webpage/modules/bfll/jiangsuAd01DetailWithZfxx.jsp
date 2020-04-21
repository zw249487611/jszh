<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>经济薄弱村走访信息</title>
	<meta name="decorator" content="default"/>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox">
	    	<div class="ibox-content">
				<h2 class="text-center">经济薄弱村帮扶力量</h2>
				<form:form id="inputForm" modelAttribute="jiangsuAd01" method="post" class="form-horizontal">
					<sys:message content="${message}"/>	
					<div class="row"  style="padding-left:1%">
						<h3>基本信息</h3>
					</div>
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">名称：</label></td>
								<td class="width-35">
									${result.cunm }
								</td>
								<td class="width-15 active"><label class="pull-right">类型：</label></td>
								<td class="width-35">
									${result.brclx }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">村民总户数：</label></td>
								<td class="width-35">
									${result.cmzhs }
								</td>
								<td class="width-15 active"><label class="pull-right">村民总人数：</label></td>
								<td class="width-35">
									${result.cmzrs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">低收入农户数：</label></td>
								<td class="width-35">
									${result.dsrnhs }
								</td>
								<td class="width-15 active"><label class="pull-right">低收入人口数：</label></td>
								<td class="width-35">
									${result.dsrrks }
								</td>
							</tr>
						</tbody>
					</table>
					<div class="row"  style="padding-left:1%">
						<h3>${result.fqnd -1}年底收入情况</h3>
					</div>
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">年集体经济收入（元）：</label></td>
								<td class="width-35">
									${result.qnnjtsr }
								</td>
								<td class="width-15 active"><label class="pull-right">直接营业性收入：</label></td>
								<td class="width-35">
									${result.qnzjjysr }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">上缴及发包收入：</label></td>
								<td class="width-35">
									${result.qnsjjfbsr }
								</td>
								<td class="width-15 active"><label class="pull-right">投资收益：</label></td>
								<td class="width-35">
									${result.qntzsy }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">其他收入：</label></td>
								<td class="width-35">
									${result.qnqtsr }
								</td>
								<td class="width-15 active"><label class="pull-right">收入明细：</label></td>
								<td class="width-35">
									${result.srmx }
								</td>
							</tr>
						</tbody>
					</table>
					<div class="row"  style="padding-left:1%">
						<h3>${result.fqnd}年收入情况</h3>
					</div>
					<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">目前收入（元）：</label></td>
								<td class="width-35">
									总计：${result.zj }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">直接经营性收入：</label></td>
								<td class="width-35">
									${result.zjjyxsr }
								</td>
								<td class="width-15 active"><label class="pull-right">上缴及发包收入：</label></td>
								<td class="width-35">
									${result.sjjfbsr }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">投资收益：</label></td>
								<td class="width-35">
									${result.tzsy }
								</td>
								<td class="width-15 active"><label class="pull-right">其他收入：</label></td>
								<td class="width-35">
									${result.qtsr }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">预计${result.fqnd}年村集体经济收入：</label></td>
								<td class="width-35">
									${result.yjjtsr }
								</td>
							</tr>
						</tbody>
					</table>
					<div class="row"  style="padding-left:1%">
						<h3>帮扶组对该村脱贫情况分析</h3>
					</div>
					<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">贫困程度：</label></td>
								<td class="width-35">
									${result.pkcd }
								</td>
								<td class="width-15 active"><label class="pull-right">脱贫难点：</label></td>
								<td class="width-35">
									${result.tpnd }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">急需帮扶措施：</label></td>
								<td class="width-35">
									${result.jxbfcs }
								</td>
								<td class="width-15 active"><label class="pull-right">脱贫计划：</label></td>
								<td class="width-35">
									${result.tpjh }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">脱贫年度：</label></td>
								<td class="width-35">
									${result.tpyear }
								</td>
							</tr>
						</tbody>
					</table>
					<div class="row"  style="padding-left:1%">
						<h3>帮扶力量</h3>
					</div>
					<table id="contentTable" class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
						<tbody>
							<tr>
								<td class="width-15 active"><label class="pull-right">省级帮扶单位：</label></td>
								<td class="width-35">
									${result.sjbfdw }
								</td>
								<td class="width-15 active"><label class="pull-right">帮扶队员：</label></td>
								<td class="width-35">
									${result.bfdy }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.bfdyzw }
								</td>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.bfdylxfs }
								</td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">市县乡联动帮扶组成员单位及帮扶人员：</label></td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">1.帮扶牵头单位：${result.bfqtdw }</label></td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">帮扶组组长：</label></td>
								<td class="width-35">
									${result.bfzz }
								</td>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.bfzzzw }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.bfzzlxfs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">帮扶组副组长：</label></td>
								<td class="width-35">
									${result.bfzfzz }
								</td>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.bfzfzzzw }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.bfzfzzlxfs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">联络员：</label></td>
								<td class="width-35">
									${result.lly }
								</td>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.llyzw }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.llylxfs }
								</td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">2.帮扶成员单位：</label></td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">县区四套班子帮扶人员姓名：${result.xqstbzbfryxm }</label></td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.xqstbzbfryzw }
								</td>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.xqstbzbfrylxfs }
								</td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">县区帮扶部门：${result.xqbfbm }</label></td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">主要负责人：</label></td>
								<td class="width-35">
									${result.xqbfbmzyfzr }
								</td>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.xqbfbmlxfs }
								</td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">乡镇三套班子帮扶人员姓名：${result.xzstbzbfryxm }</label></td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.xzstbzbfryzw }
								</td>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.xzstbzbfrylxfs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">财务辅导人员姓名：</label></td>
								<td class="width-35">
									${result.cwfdryxm }
								</td>
								<td class="width-15 active"><label class="pull-right">单位：</label></td>
								<td class="width-35">
									${result.cwfdrydw }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.cwfdryzw }
								</td>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.cwfdrylxfs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">法律援助人员姓名：</label></td>
								<td class="width-35">
									${result.flyzryxm }
								</td>
								<td class="width-15 active"><label class="pull-right">单位：</label></td>
								<td class="width-35">
									${result.flyzrydw }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">职务：</label></td>
								<td class="width-35">
									${result.flyzryzw }
								</td>
								<td class="width-15 active"><label class="pull-right">联系方式：</label></td>
								<td class="width-35">
									${result.flyzrylxfs }
								</td>
							</tr>
							<tr>
								<td class="active" colspan="4"><label class="pull-left">低收入农户市，县，乡，村帮扶责任人数</label></td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">总数：</label></td>
								<td class="width-35">
									${result.zrs }
								</td>
								<td class="width-15 active"><label class="pull-right">市级：</label></td>
								<td class="width-35">
									${result.srs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">县（区）级：</label></td>
								<td class="width-35">
									${result.qrs }
								</td>
								<td class="width-15 active"><label class="pull-right">乡级：</label></td>
								<td class="width-35">
									${result.xrs }
								</td>
							</tr>
							<tr>
								<td class="width-15 active"><label class="pull-right">村级：</label></td>
								<td class="width-35">
									${result.crs }
								</td>
								<td class="width-15 active"><label class="pull-right">其他帮扶力量：</label></td>
								<td class="width-35">
									${result.qtbfll }
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>