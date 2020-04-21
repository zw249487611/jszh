var rczf_desc = new Vue({
	el : '#rhcc_desc',
	data : {
		cchs : '   ',
		yxl : '   '
	}
});

var tableDatas = [];

var tableDataName = [ '抽查农户知道建档立卡身份', '抽查农户知道帮扶责\n任人单位，姓名等基本信息',
		'抽查帮扶责任人上门走访', '抽查帮扶责任人提出脱\n贫计划和帮扶措施', '抽查农户了解“阳光扶贫”\n工作，知晓相关政策' ];

$('#contentTable').find('tr').each(function() {
	var tableData = [];
	$(this).find('td').each(function() {
		if ($(this).text().trim() != '') {
			tableData.push($(this).text().trim());
		}
	});
	tableDatas.push(tableData);
});

var cchs = 0;
var yxl = 0;
var yxlData = [];
var yxlDataStr = [];
var xqName = [];
var dbs = [ 0, 0, 0, 0, 0 ];
for (var i = 1; i < tableDatas.length; i++) {
	var rowData = tableDatas[i];
	cchs += parseInt(rowData[1]);
	console.log(rowData[8]);
	yxl += parseFloat(rowData[8].substr(0, rowData[8].length - 1));
	yxlData.push(parseFloat(rowData[8].substr(0, rowData[8].length - 1)));
	yxlDataStr.push(rowData[8]);
	xqName.push(rowData[0]);
	dbs[0] += parseFloat(rowData[3]);
	dbs[1] += parseFloat(rowData[4]);
	dbs[2] += parseFloat(rowData[5]);
	dbs[3] += parseFloat(rowData[6]);
	dbs[4] += parseFloat(rowData[7]);
}
yxl = yxl / (tableDatas.length - 1);

rczf_desc.cchs = cchs;
rczf_desc.yxl = yxl.toFixed(2) + "%";


if(yxlDataStr.length<=1){
	$('#pie_con_con').hide();
}

// 有效率的占比
var option_pies = [];
var pies = [];

$('#pie_con').css('max-width',(150*yxlDataStr.length)+"px");

for (var i = 0; i < yxlDataStr.length; i++) { 
	
	$('#pie_con').append('<div id="pie_yxl'+i+'" class="pie_yxl"></div>');
	
	var pie_i = echarts.init(document.getElementById('pie_yxl' + i));
	
	var option_pie = {
		title : [{
			text : xqName[i],
			x : 'center',
			y : 'bottom',
			textStyle : {
				fontSize : '15',
				fontWeight : 'normal',
			}
		},{
			text : yxlDataStr[i] ,
			x : 'center',
			y : 'center',
			textStyle : {
				fontSize : '15',
				fontWeight : 'normal',
			}
		}],
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : ['45%', '60%'],
			center : [ '50%', '45%' ],
			label : {
				normal : {
					show : false,
					position : 'center',
					textStyle : {
						color : 'black'
					}
				},
				emphasis : {
					show : false,
				}
			},
			data : [ {
				value : 100 - yxlData[i],
				name : 'other'
			},{
				value : yxlData[i],
				name : 'data',
			}],
		} ],
		color : ['#c1c1c1', '#036eb7' ]
	};
	if(yxlData[i]>=75){
		option_pie.color = ['#c1c1c1','#009100'];
	}else if(yxlData[i]>=60){
		option_pie.color = ['#c1c1c1','#FFD306'];
	}else{
		option_pie.color = ['#c1c1c1','#CE0000'];
	}
	pie_i.setOption(option_pie);
	pies.push(pie_i);
	option_pies.push(option_pie);
}

// 抽查指标达标户数
var bar_dbl = echarts.init(document.getElementById('bar_dbl'));
var option_bar_dbl = {
	color : baseColor,
	title : {
		text : '抽查指标达标户数',
		x : 'center',
	},
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
	grid : {
		left : '3%',
		right : '4%',
		bottom : '10%',
		containLabel : true
	},
	xAxis : [ {
		type : 'category',
		data : tableDataName,
		axisTick : {
			alignWithLabel : true
		},
		axisLabel : {
			interval : 0,
		}
	} ],
	yAxis : [ {
		type : 'value'
	} ],
	series : [ {
		name : '达标户数',
		type : 'bar',
		barWidth : '60%',
		data : dbs
	} ]
};
bar_dbl.setOption(option_bar_dbl);