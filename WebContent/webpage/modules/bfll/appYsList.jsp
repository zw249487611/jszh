<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>饮水安全有保障</title>
<meta name="decorator" content="default" />
<style type="text/css">
	.table_my>tbody>tr>td,.table_my>thead>tr>th{
		text-align:center;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="ibox">
			<div class="ibox-title">
				<h5>饮水安全有保障</h5>
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
						<table class="table table-bordered table_my">
							<thead>
								<tr>
									<th rowspan="2">县区</th>
									<th rowspan="2">户数</th>
									<th rowspan="2">人口</th>
									<th colspan="2">已实现区域供水</th>
									<th rowspan="2">入户率</th>
								</tr>
								<tr>
									<th>户数</th>
									<th>人口</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>全&nbsp;&nbsp;&nbsp;市</td>
									<td>1080782</td>
									<td>4044580</td>
									<td>1061958</td>
									<td>3975652</td>
									<td>98.26%</td>
								</tr>
								<tr>
									<td>清江浦</td>
									<td>25124</td>
									<td>110339</td>
									<td>25124</td>
									<td>110339</td>
									<td>100.00%</td>
								</tr>
								<tr>
									<td>淮&nbsp;&nbsp;&nbsp;阴</td>
									<td>193479</td>
									<td>761625</td>
									<td>184474</td>
									<td>722253</td>
									<td>95.35%</td>
								</tr>
								<tr>
									<td>淮&nbsp;&nbsp;&nbsp;安</td>
									<td>233706</td>
									<td>958773</td>
									<td>233706</td>
									<td>958773</td>
									<td>100.00%</td>
								</tr>
								<tr>
									<td>洪&nbsp;&nbsp;&nbsp;泽</td>
									<td>60209</td>
									<td>215377</td>
									<td>60209</td>
									<td>215377</td>
									<td>100.00%</td>
								</tr>
								<tr>
									<td>涟&nbsp;&nbsp;&nbsp;水</td>
									<td>301931</td>
									<td>948970</td>
									<td>292112</td>
									<td>919414</td>
									<td>96.75%</td>
								</tr>
								<tr>
									<td>盱&nbsp;&nbsp;&nbsp;眙</td>
									<td>194575</td>
									<td>789659</td>
									<td>194575</td>
									<td>789659</td>
									<td>100.00%</td>
								</tr>
								<tr>
									<td>金&nbsp;&nbsp;&nbsp;湖</td>
									<td>71758</td>
									<td>259837</td>
									<td>71758</td>
									<td>259837</td>
									<td>100.00%</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>