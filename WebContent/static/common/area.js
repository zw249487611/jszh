/**
 * 区域级联下拉选择
 */

$(function () {
	var locat = (window.location+'').split('/');
	if('tool'== locat[3]){
		locat =  locat[0]+'//'+locat[2];
	}else{
		locat =  locat[0]+'//'+locat[2]+'/'+locat[3];
	};
	var currentAreaId = $("#currentAreaId").val();
	if($("#areaSelectDiv").length > 0){
		$.ajax({
			type : "POST",
		    url : locat + '/a/sys/area/getAllTypeArea?currentAreaId='+currentAreaId,
			dataType: "json",
		    success : function(result) {
		    	var selected_4="";
		    	var selected_5="";
		    	var selected_6="";
		    	for(var i=0;i<result.areaJsonList_4.length;i++){
		    		$("#4_area").append("<option value='"+result.areaJsonList_4[i].areaId+"' selected='"+result.areaJsonList_4[i].selected+"'>"+result.areaJsonList_4[i].areaName+"</option>");
		    		if(result.areaJsonList_4[i].selected == 'selected'){
		    			selected_4 = result.areaJsonList_4[i].areaId
		    		}
		    	}
		    	$("#4_area").val(selected_4);
		    	for(var i=0;i<result.areaJsonList_5.length;i++){
		    		$("#5_area").append("<option value='"+result.areaJsonList_5[i].areaId+"' selected='"+result.areaJsonList_5[i].selected+"'>"+result.areaJsonList_5[i].areaName+"</option>");
		    		if(result.areaJsonList_5[i].selected == 'selected'){
		    			selected_5 = result.areaJsonList_5[i].areaId
		    		}
		    	}
		    	$("#5_area").val(selected_5);
		    	for(var i=0;i<result.areaJsonList_6.length;i++){
		    		$("#6_area").append("<option value='"+result.areaJsonList_6[i].areaId+"' selected='"+result.areaJsonList_6[i].selected+"'>"+result.areaJsonList_6[i].areaName+"</option>");
		    		if(result.areaJsonList_6[i].selected == 'selected'){
		    			selected_6 = result.areaJsonList_6[i].areaId
		    		}
		    	}
		    	$("#6_area").val(selected_6);
		    },
		    error : function(){
		    	console.log("出错了");
			}
		});
	}
	$(".areaCascadeSelect").change(function (){
		var name = $(this).attr("name");
		var fuAreaId = $(this).val();
		var areaType = name.split("_")[0];
		var count=0;
		if(areaType == '4'){
			count = parseInt(areaType) + 1 ;
			$("#"+count+"_area").empty();
			count = count + 1;
			$("#"+count+"_area").empty();
		}else if(areaType == '5'){
			count = parseInt(areaType) + 1 ;
			$("#"+count+"_area").empty();
		}
		$("#"+name).val(fuAreaId);
		areaType = parseInt(areaType) + 1;
		name = areaType + "_area";
		$.ajax({
			type : "POST",
		    url : locat + '/a/sys/area/getTypeArea?fuAreaId=' + fuAreaId,
			dataType: "json",
		    success : function(result) {
		    	for(var i=0;i<result.length;i++){
		    		$("#"+name).append("<option value='"+result[i].areaId+"'>"+result[i].areaName+"</option>");
		    	}
		    	if(fuAreaId == ''){
		    		if($("#5_area").val() != ''){
		    			fuAreaId = $("#5_area").val();
		    		}else if($("#4_area").val() != ''){
		    			fuAreaId = $("#4_area").val();
		    		}
		    	}
		    	$("#currentAreaId").val(fuAreaId).change();
		    },
		    error : function(){
		    	console.log("出错了");
			}
		});
	});
});