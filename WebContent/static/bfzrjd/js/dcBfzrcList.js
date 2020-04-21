var nowYear = new Date().getFullYear();
var yearsCount = nowYear - 2017 + 1;
var years = [];
for (var i = 0; i < yearsCount; i++) {
	years.push(nowYear - i);
}
var quarter = Math.floor((new Date().getMonth()) / 3 + 1);

var selected = $('#year_dcRhcj').text();
var dcRhcj_years = new Vue({
	el : '#dcRhcj_years',
	data : {
		selected:selected,
		years : years
	}
});

var year = $('#dcRhcj_years option:selected').val();
quarter = $('#select_quarter option:selected').val();

var rczf_desc = new Vue({
	el : '#rczf_desc',
	data : {
		bfr : "   ",
		zfcs : "   "
	}
});

var myChart2 = echarts.init(document.getElementById('map_page2'));
var convertData2 = function(data) {
	var res = [];
	for (var i = 0; i < data.length; i++) {
		var geoCoord = geoCoordMap[data[i].name];
		if (geoCoord) {
			res.push({
				name : data[i].name,
				value : geoCoord.concat(data[i].value)
			});
		}
	}
	return res;
};
var option2;

echarts.registerMap('mapData', mapData);
option2 = {
	animation : true,
	animationDuration : 1000,
	animationEasing : 'cubicInOut',
	animationDurationUpdate : 1000,
	animationEasingUpdate : 'cubicInOut',
	toolbox : {
		iconStyle : {
			normal : {
				borderColor : '#fff'
			},
			emphasis : {
				borderColor : '#b1e4ff'
			}
		}
	},
	geo : {
		map : 'mapData',
		label : {
			normal : {
				show : false,
				textStyle : {
					fontSize : 16,
					color : 'rgba(255,255,255,0.7)'
				}
			},
			emphasis : {
				show : true,
				textStyle : {
					fontSize : 16,
					color : 'rgba(255,255,255,0.7)'
				}
			},
		},
		zoom : 1.25,
		roam : false,
		itemStyle : {
			emphasis : {
				areaColor : '#2984c3'
			}
		},
	},
	tooltip : {
		trigger : 'item',
		formatter : function(params) {
			if (params.seriesIndex == 1) {
				return params.name + '<br>走访率: ' + params.data.value[4]
						+ '<br> 图片上传率：' + params.data.value[3] + '<br> 定位率：'
						+ params.data.value[2] + "<br>帮扶措施录入率："
						+ params.data.value[3];
			}
		}
	},
	grid : {
		right : 40,
		top : 100,
		bottom : 40,
		width : '30%'
	},
	xAxis : {
		type : 'value',
		scale : true,
		position : 'top',
		boundaryGap : false,
		splitLine : {
			show : false
		},
		axisLine : {
			show : false
		},
		axisTick : {
			show : false
		},
		axisLabel : {
			margin : 2,
			textStyle : {
				color : '#aaa'
			}
		},
	},
	yAxis : {
		type : 'category',
		nameGap : 16,
		axisLine : {
			show : false,
			lineStyle : {
				color : '#ddd'
			}
		},
		axisTick : {
			show : false,
			lineStyle : {
				color : '#ddd'
			}
		},
		axisLabel : {
			interval : 0,
			textStyle : {
				color : '#ddd'
			}
		},
		data : []
	},
	series : [ {
		zoom : 1.25,
		name : '13',
		type : 'map',
		map : 'mapData',
		roam : false,
		label : {
			normal : {
				show : false,
				textStyle : {
					fontSize : 16,
					color : 'rgba(255,255,255,0.7)'
				}
			},
			emphasis : {
				show : true,
				textStyle : {
					fontSize : 16,
					color : 'rgba(255,255,255,0.7)'
				}
			},
		},
		itemStyle : {
			normal : {
				areaColor : '#DDDDFF'
			},
			emphasis : {
				areaColor : '#2984c3'
			}
		},
		data : [ {
			name : '',
			value : 234,
			label : {
				normal : {
					show : true,
				}
			},
			itemStyle : {
				normal : {
					areaColor : '#2984c3'
				}
			}
		} ],

	}, {
		name : '到户走访记录',
		type : 'scatter',
		coordinateSystem : 'geo',
		data : [],
		symbolSize : function(val) {
			return val[2] / 10;
		},
		label : {
			normal : {
				formatter : '{b}',
				position : 'right',
				show : false
			},
			emphasis : {
				show : true
			}
		},
		itemStyle : {
			normal : {
				color : '#FFFF00'
			}
		}
	} ]
};

var nowCountry1 = "";
myChart2.setOption(option2);

function initqx_page3(mapArea) {
	if (qxCode[mapArea] == undefined) {
		return;
	}
	$.ajax({
		type : "get",
		url : BASEURL + "/dataCount/zfqktj/getTpfxRczf",
		timeout : 15000,
		dataType : 'jsonp',
		jsonp : 'callback',
		data : {
			year : year,
			quarter : quarter
		}
	}).done(function(data) {
		console.log('data2:');
		console.log(data);
		initData2_page3(data);
	}).fail(function(data) {
		console.log(data);
	});

}

function initData_page3(data) {
	var useData = [];
	var useData1 = [];
	var useData1_index = 0;
	var pages = [];
	for (var i = 1; i < data.length; i++) {
		useData.push(data[i]);
		var nowUseData1_index = useData1_index;
		if ((i - 1) % 7 == 0) {
			useData1[useData1_index++] = [];
			pages.push(useData1_index);
		}
		nowUseData1_index = useData1_index - 1;
		useData1[nowUseData1_index].push(data[i]);
	}
	if (NOWAREA == '全市') {
		option2.series[0].itemStyle.normal.areaColor = '#2984c3';
		option2.series[0].label.normal.show = true;
		app1.xqName = '县区';
	}else{
		app1.xqName = '乡镇';
	}
	option2.series[0].data[0].name = NOWAREA;
	option2.series[1].data = convertData2(useData);
	myChart2.setOption(option2);
	app1.tableDtata = useData1;
	app1.pages = pages;
	app1.nowpage = 0;

	$('.page_num').removeClass('active');
	$('#pages-1').addClass('active');
}

initqx_page3(NOWAREA);

function initData2_page3(data) {
	// 县区编码
	var xqCode = data.xqCode;
	NOWAREA = qxLKKBackCode[xqCode];
	console.log('NOWAREA : ');
	console.log(NOWAREA);
	// 获取map数据
	$.ajax({
		type : "get",
		url : BASEURL + "/dataCount/zfqktj/getPkcZfqk",
		timeout : 15000,
		dataType : 'jsonp',
		jsonp : 'callback',
		data : {
			id : xqCode,
			nd : year,
			jd : quarter
		}
	}).done(function(data) {
		initData_page3(data);
	}).fail(function(data) {
		console.log(data);
	});
	// 帮扶责任人数，走访次数
	var bfrszfcs = data.bfrszfcs;
	rczf_desc.bfr = bfrszfcs.bfrs;
	rczf_desc.zfcs = bfrszfcs.zfcs;
	// 脱贫分析采集完整率
	var tpfxcjwzl = data.tpfxcjwzl;
	var barNames = [];
	var barData = [];
	for (var i = 0; i < tpfxcjwzl.length; i++) {
		barNames.push(tpfxcjwzl[i].name);
		barData.push(parseFloat(tpfxcjwzl[i].value));
	}
	// option_bar_wzl.xAxis[0].data = barNames;
	option_bar_wzl.series[0].data = barData;
	bar_wzl.setOption(option_bar_wzl);
	// 入户采集排行榜
	var rhcjphb = data.rccjphb;
	$('#pie_con').css('max-width',(150*rhcjphb.length)+"px");
	for (var i = 0; i < rhcjphb.length; i++) {
		$('#pie_con').append('<div id="pie_phb'+i+'" class="pie_phb"></div>');
		var pie = echarts.init(document.getElementById('pie_phb' + i));
		var option_pie = {
				title : [ {
					text : '',
					x : 'center',
					y : 'bottom',
					textStyle : {
						fontSize : '16',
						fontWeight : 'normal'
					}
				}, {
					text : '',
					x : 'center',
					y : 'center',
					textStyle : {
						fontSize : '16',
						fontWeight : 'normal'
					}
				} ],
				series : [ {
					name : '访问来源',
					type : 'pie',
					radius : ['45%', '60%'],
					center : [ '50%', '45%' ],
					label : {
						normal : {
							show : false,
						},
						emphasis : {
							show : false,
						}
					},
					data : [ {
						value : 0,
						name : '走访率'
					}, {
						value : 100,
						name : 'other'
					} ],
				} ],
				color : [ '#036eb7', '#fff' ]
			};
		
		var cjl = rhcjphb[i].cjl;
		var name = rhcjphb[i].name;
		var cjlData = parseFloat(cjl.substr(0, cjl.length - 1));
		var otherData = 100 - cjlData;
		var pieData = [ {
			name : "other",
			value : otherData
		} ,{
			name : cjl + "   " + name,
			value : cjlData
		}];
		if (cjlData >= 95) {
			option_pie.color = ['#c1c1c1', '#009100' ];
		} else if (cjlData >= 90) {
			option_pie.color = ['#c1c1c1', '#FFD306'];
		} else {
			option_pie.color = [ '#c1c1c1','#CE0000'];
		}
		option_pie.series[0].data = pieData;

		option_pie.title[0].text = name;
		option_pie.title[1].text = cjl;
		pie.setOption(option_pie);
	}

}

// 表格
var app1 = new Vue({
	el : '#table_zfbl2',
	data : {
		tableDtata : [],
		xzCode : xzCode,
		nowpage : 0,
		pages : [],
		xqName:''
	},
	methods : {
		changePage_page3 : function(evt) {
			app1.nowpage = $(event.target).text() - 1;
			$('.page_num').removeClass('active');
			$(event.target).addClass('active');
		}
	}
});

// 脱贫分析采集完整率
var bar_wzl = echarts.init(document.getElementById('bar_wzl'));
var option_bar_wzl = {
	color : [ '#9393FF' ],
	title : {
		text : '脱贫分析采集完整率',
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
		bottom : '3%',
		containLabel : true
	},
	xAxis : [ {
		type : 'category',
		data : [ '贫困程度', '脱贫难点', '帮扶措施', '脱贫计划', '脱贫年度', '2017年收入总收入\n与分项收入一致',
				'联动帮扶组组建到位' ],
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
		name : '完整率',
		type : 'bar',
		barWidth : '60%',
		data : []
	} ]
};
bar_wzl.setOption(option_bar_wzl);

