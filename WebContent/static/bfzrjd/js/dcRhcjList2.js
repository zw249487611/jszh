var nowYear = new Date().getFullYear();
var yearsCount = nowYear - 2017 + 1;
var years = [];
for (var i = 0; i < yearsCount; i++) {
	years.push(nowYear - i);
}
var quarter = Math.floor((new Date().getMonth())/3+1);


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


function initqx_page3(mapArea) {
	if (qxCode[mapArea] == undefined) {
		return;
	}
	$.ajax({
		type : "get",
		url : BASEURL + "/dataCount/zfqktj/getTpfxRhzf",
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
		if ((i - 1) % 100 == 0) {
			useData1[useData1_index++] = [];
			pages.push(useData1_index);
		}
		nowUseData1_index = useData1_index - 1;
		useData1[nowUseData1_index].push(data[i]);
	}
	if(NOWAREA == '全市'){
		app1.xqName = '县区';
	}else{
		app1.xqName = '乡镇';
	}
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
	//获取地区code对应表
	$.ajax({
		type : "get",
		url : BASEURL + "/sys/area/getAllTypeArea",
		timeout : 15000,
		data : {
			currentAreaId : xqCode,
		}
	}).done(function(data) {
		var useData = data.areaJsonList_6;
		if(useData.length==0){
			useData = data.areaJsonList_5;
		}
		if(useData.length==0){
			useData = data.areaJsonList_4;
		}
		console.log(1122,useData);
		for(var i = 0;i<useData.length;i++){
			if(useData[i].areaId){
				AREAMAP[useData[i].areaName] = useData[i].areaId;
			}
		}
	}).fail(function(data) {
		console.log(data);
	});
	
	//获取map数据
	$.ajax({
		type : "get",
		url : BASEURL + "/dataCount/zfqktj/getPkhZfqk",
		timeout : 15000,
		dataType : 'jsonp',
		jsonp : 'callback',
		data : {
			id : xqCode,
			nd:year,
			jd:quarter
		}
	}).done(function(data) {
		initData_page3(data);
	}).fail(function(data) {
		console.log(data);
	});
}

