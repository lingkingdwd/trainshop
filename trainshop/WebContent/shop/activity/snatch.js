var orgList = new Array();
var trainTable;
var trainDatas = new Array;

$(document).ready(function() {
	var snatchManage = new GoodsActivityManage();
	snatchManage.createTable();
	
	$("#createBtn").on("click", trainManage.addTrain);
	
	$("#saveBtn").on("click",{createTrainTable:trainManage.createTrainTable}, trainManage.saveTrain);
	
	//$("button[name='editBtn']").live("click", trainManage.updateTrain);
	$('body').on('click', 'button[name="editBtn"]', trainManage.updateTrain);
	//$("button[name='deleteBtn']").live("click", {createTrainTable:trainManage.createTrainTable}, trainManage.deleteTrain);
	$('body').on('click', 'button[name="deleteBtn"]', trainManage.deleteTrain);
});

function getTrainData(orgId)
{
	trainTable.clear().draw();
	//组织机构读取
	$.ajax({
		type : 'POST',
		url :basePath + "train/getListByOrg",
		data : {id:orgId},
		async : false,
		dataType : "json",
		success : function(resp) {
			trainDatas=$.makeArray(resp.data);
			$.each(trainDatas,function(index,item){
				trainTable.row.add(item).draw();
			});
//			trainTable.draw();
		},
		error : function(data) {
			layer.alert("数据请求失败!", 8);
		}
	});
}

function GoodsActivityManage(){
	
	this.createTable = function (){
		$.ajax({
			async: false,
			type: "POST",
			url: basePath + "goodsActivity/getAllList",
			dataType: "json",
			data:{id:0},
			success: function(resp) {	
				trainDatas=resp.data;
				trainTable=$("#goodsActivityTable").DataTable({
					data:trainDatas,
					columns :[{ data: "actId"},
			//	        { data: "orgId" },
				        { data: "actName" },
				        { data: "goodsName" },
				        { data: "startTime" },
				        { data: "endTime" },
				        { data: "endTime" },
				        {data:null}
					],
			        columnDefs:[{
                    	targets:[6],
                    	render:function(data,type,row)
                    	{
                    		 var html='<button type="button" name="editBtn" trainId="' + row.trainId + '" class="btn btn-stroke btn-xs btn-success marright5 "' +
								'title="编辑">' +
								'<i class="fa fa-pencil"></i></button>' + 
								'<button type="button" name="deleteBtn" trainId="' + row.trainId + '" class="btn btn-stroke btn-xs btn-danger marright5 ' +
								'title="删除">' +
								'<i class="fa fa-times"></i></button>';
								
                             return html;
                    	}
                    }],
					"language": {
						"sProcessing": "处理中...",
	       		       "sLengthMenu": "显示 _MENU_ 项结果",
	       		       "sZeroRecords": "没有匹配结果",
	       		       "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
	       		       "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
	       		       "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
	       		       "sInfoPostFix": "",
	       		       "sSearch": "搜索:",
	       		       "sUrl": "",
	       		       "sEmptyTable": "表中数据为空",
	       		       "sLoadingRecords": "载入中...",
	       		       "sInfoThousands": ",",
	       		       "oPaginate": {
	       		           "sFirst": "首页",
	       		           "sPrevious": "上页",
	       		           "sNext": "下页",
	       		           "sLast": "末页"
	       		       },
	       		       "oAria": {
	       		           "sSortAscending": ": 以升序排列此列",
	       		           "sSortDescending": ": 以降序排列此列"
	       		   		}
       		   }
				});
			},
			error: function() {
				alert("页面加载失败！");
			}
		});
	}
	
	this.saveTrain = function(event){
		var orgId = $("#orgId").val();
		if(orgId == ""){
			var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
			var sNodes = treeObj.getSelectedNodes();
			if (sNodes.length > 0) {
				var node = sNodes[0];
				
				var obj = new Object();
				obj.orgId = node.id;
				obj.trainId = $("#trainId").val();
				obj.trainNumber = $("#trainNumber").val();
				obj.startStation = $("#startStation").val();
				obj.endStation = $("#endStation").val();
				
				var startTime;
				if($("#startTime").val() != ""){
					startTime = $("#startTime").val();
					obj.startTime = startTime;
				}
				var endTime;
				if($("#endTime").val() != ""){
					endTime = $("#endTime").val();
					obj.endTime = endTime;
				}
				
				var param = {data:JSON.stringify(obj)};
			
				callAjax(basePath + "train/create",'POST', param, function(data){
					if (data.flag == "1") {
						layer.alert("列车添加成功!");
						
						if(event != undefined){
							/*var createTrainTable = event.data.createTrainTable;
							createTrainTable();*/
							
							getTrainData(node.id);
							
							$("#newTrainWin").modal("hide");
						}
					}
					else{
						layer.alert("组织机构组织机构添加失败!");
					}
				});
			}
			else{
				layer.alert("请选择父级组织机构!", 8);
			}
		}
		else{
			var obj = new Object();
			obj.trainId = $("#trainId").val();
			obj.orgId = $("#orgId").val();
			obj.trainNumber = $("#trainNumber").val();
			obj.startStation = $("#startStation").val();
			obj.endStation = $("#endStation").val();
			
			var startTime;
			if($("#startTime").val() != ""){
				startTime = $("#startTime").val();
				obj.startTime = startTime;
			}
			var endTime;
			if($("#endTime").val() != ""){
				endTime = $("#endTime").val();
				obj.endTime = endTime;
			}
			
			var param = {data:JSON.stringify(obj)};
		
			callAjax(basePath + "train/create",'POST', param, function(data){
				if (data.flag == "1") {
					layer.alert("列车修改成功!");
					
					if(event != undefined){
						/*var createTrainTable = event.data.createTrainTable;
						createTrainTable();*/
						
						getTrainData(orgId);
						
						$("#newTrainWin").modal("hide");
					}
				}
				else{
					layer.alert("组织机构组织机构添加失败!");
				}
			});
		}
		
	};
	
	this.updateTrain = function(){
		var trainId = $(this).attr("trainId");
		for(var i = 0; i < trainDatas.length; i++){
			if(trainId == trainDatas[i].trainId){
				$("#trainId").val(trainDatas[i].trainId);
				$("#orgId").val(trainDatas[i].orgId);
				$("#trainNumber").val(trainDatas[i].trainNumber);
				$("#startStation").val(trainDatas[i].startStation);
				$("#endStation").val(trainDatas[i].endStation);
				
				$("#startTime").val(trainDatas[i].startTime);
				$("#endTime").val(trainDatas[i].endTime);
				
				$("#newTrainWin").modal("show");
			}
		}
	};
	
	this.deleteTrain = function(event){
		var trainId = $(this).attr("trainId");
		if(trainId == "" || trainId == null){
			layer.alert("列车号为空！");
			return;
		}
		
		var param = {
			data:trainId
		};
		
		callAjax(basePath + "train/delete", 'POST', param, function(data){
			if(data.flag == 0){
				layer.alert("删除成功！");
				
				getTrainData($("#orgId").val());
				
				/*var createTrainTable = event.data.createTrainTable;
				createTrainTable();*/
			}
			else{
				layer.alert(data.msg);
			}
		});
	};
	
	this.addTrain = function(){
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0 && sNodes[0].id != "0") {
			var node = sNodes[0];
			
			$("#orgId").val(node.id);
			
			$("#trainId").val("");
			$("#trainNumber").val("");
			$("#startStation").val("");
			$("#endStation").val("");
			
			$("#startTime").val("");
			$("#endTime").val("");
			
			$("#newTrainWin").modal("show");
		}
		else{
			layer.alert("请选择组织机构!", 8);
		}
	};
}

function createOneCondition(fieldname, valList){
	var condition = new Object();
	var dataList = new Array();
	if (valList instanceof Array) {
		for ( var i = 0; i < valList.length; i++) {
			dataList.push(valList[i]);
		}
	} else {
		dataList.push(valList);
	}
	var table = new Object();
	table.item = dataList;
	
	condition.FIELDNAME = fieldname;
	condition.TABLE = table;

	return condition;
}