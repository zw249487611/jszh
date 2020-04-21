<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>数据详细</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	</script>
</head>
<body class="hideScroll">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">姓名：</label></td>
					<td class="width-35">
						${medicalData.name}
					</td>
					<td class="width-15 active"><label class="pull-right">身份证号：</label></td>
					<td class="width-35" >
						${medicalData.idCard}
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">扶贫个人编号：</label></td>
					<td class="width-35" >
						${medicalData.poorId}
					</td>
					<td class="width-15 active"><label class="pull-right">县：</label></td>
					<td class="width-35">
						${medicalData.area}
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">乡：</label></td>
					<td class="width-35" >
                    	${medicalData.town}			
                    </td>
					<td class="width-15 active"><label class="pull-right">村：</label></td>
					<td class="width-35" >
                    	${medicalData.country}
                    </td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">金保姓名：</label></td>
					<td class="width-35" >
                    	${medicalData.systemName}			
                    </td>
                    <td class="width-15 active"><label class="pull-right">人员类别：</label></td>
					<td class="width-35">
						${medicalData.peopleType}	
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">民政人员类别：</label></td>
					<td class="width-35">
						${medicalData.staffType}
					</td>
					<td class="width-15 active"><label class="pull-right">医疗类别：</label></td>
					<td class="width-35" >
                    	${medicalData.medicalType}			
                    </td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">入院日期：</label></td>
					<td class="width-35" >
                    	${medicalData.hospitalIn}			
                    </td>
					<td class="width-15 active"><label class="pull-right">出院日期：</label></td>
					<td class="width-35">
						${medicalData.hospitalOut}
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">入院诊断名称：</label></td>
					<td class="width-35" >
                    	${medicalData.diseaseNameIn}			
                    </td>
                    <td class="width-15 active"><label class="pull-right">出院诊断名称：</label></td>
					<td class="width-35">
						${medicalData.diseaseNameOut}
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">医疗费用总额：</label></td>
					<td class="width-35" >
                    	${medicalData.totalCost}			
                    </td>
                    <td class="width-15 active"><label class="pull-right">统筹支付：</label></td>
					<td class="width-35">
						${medicalData.expenseMoney}
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">大病支付：</label></td>
					<td class="width-35">
						${medicalData.seriousIllnessMoney}
					</td>
					<td class="width-15 active"><label class="pull-right">账户支付：</label></td>
					<td class="width-35">
						${medicalData.accountMoney}
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">民政支付：</label></td>
					<td class="width-35">
						${medicalData.civilAssistanceMoney}
					</td>
					<td class="width-15 active"><label class="pull-right">现金：</label></td>
					<td class="width-35">
						${medicalData.cashCost}
					</td>
				</tr>
		   </tbody>
		</table>
</body>
</html>