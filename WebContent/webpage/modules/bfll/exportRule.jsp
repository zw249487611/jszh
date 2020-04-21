<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>帮扶责任人管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	</script>
</head>
<body class="hideScroll">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
				<h1>帮扶责任人批量导入,表格导入规则</h1>
				<h3>1.帮扶单位:按实际单位名称填写</h3>
				<h3>2.帮扶单位类型,只能填写以下选项内容:</h3>
				<p style="color:red">国家机关</br>
				      社会团体</br>
				      高等院校</br>
				      国有企业</br>
				      东部对口帮扶省市</br>
				      定点机构</br>
				      村民自治组织</p>
				<h3>3.帮扶单位隶属关系,只能填写以下选项内容:</h3>
				<p style="color:red">中央</br>
				      省</br>
				      市、地区</br>
				      区</br>
				      县</br>
				      街道</br>
				      镇</br>
				      乡</br>
				      居民委员会</br>
				      村民委员会</br>
				      军队</br>
				      其他</p>
			     <h3>4.姓名:正常填写帮扶责任人姓名</h3>
			     <h3>5.是否第一书记:只能填写是/否</h3>
			     <h3>6.是否工作队队长:只能填写是/否</h3>
			     <h3>7.是否驻村队员:只能填写是/否</h3>
			     <h3>8.性别:只能填写男/女</h3>
			     <h3>9.职务级别,只能填写以下选项内容:</h3>
			     <p style="color:red">国家级正职</br>
			               国家级副职</br>
			               省部级正职</br>
			               省部级副职</br>
			               厅局级正职</br>
			               厅局级副职</br>
			               县处级正职</br>
			               县处级副职</br>
			               乡科级正职</br>
			               乡科级副职</br>
			               科员级</br>
			               办事员级</br>
			               未定职</p>
			     <h3>10.证件号码:填写身份证号码或其他有效证件号码</h3>
			     <h3>11.联系电话:请填写帮扶责任人的手机号码，如与系统中已经录入的帮扶责任人号码重复，将无法存入系统</h3>
				<div class="pull-right">
			<input type="button" name="Submit" value="返回"  class="btn btn-white btn-sm " onclick="javascript:window.history.back(-1);">
	        </div>
</body>
	
	
</html>