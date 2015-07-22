var orgList = new Array();
var trainTable;
var trainDatas=new Array;
var orgId=1;

$(document).ready(function() {
	var trainManage = new TrainManage();
	trainManage.getOrgList();
	trainManage.createTrainTable();
	//createTrainTable();
	
	//trainManage.createTrainTable();
	
	/*$("#addOrg").on("click", {getList:orgManage.getOrgList}, orgManage.addOrg);
	
	$("#saveOrg").on("click",{getList:orgManage.getOrgList}, orgManage.updateOrg);
	
	$("#deleteOrg").on("click",{getList:orgManage.getOrgList}, orgManage.deleteOrg);*/
});

function createTrainTable(){
	$.ajax({
		async: false,
		type: "POST",
		url: basePath + "train/getListByOrg",
		dataType: "json",
		data:{id:1},
		success: function(resp) {	
			trainDatas = resp.data;
			trainTable = $("#trainTable").DataTable({
				data:trainDatas,
				columns :[
				        { data: "trainId"},
			//	        { data: "orgId" },
				        { data: "trainNumber" },
				        { data: "startStation" },
				        { data: "endStation" },
				        { data: "startTime" },
				        { data: "endTime" },
				        {data:null}
					    ],
		        columnDefs:[
		                    {
		                    	targets:[6],
		                    	render:function(data,type,row)
		                    	{
		                    		 /*var html='<td><a class="btn btn-info" value="'+row.goodsId+'" href="javascript:;">商品上车</a><a class="btn btn-success" value="'+row.goodsId+'" href="javascript:;">商品列表</a></td>';
	                                 return html;*/
		                    	}
		                    }
		                    ],
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

function TrainManage(){
	var zTreeOnClick = function(event, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			orgId=sNodes[0].id;
			getTrainData(orgId);
		}
	};
	
	var setting = {
		/*check: {
			enable: true,
			chkStyle: "radio"
		},*/
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: zTreeOnClick
		}
	};
	
	this.getOrgList = function (){
		//组织机构读取
		$.ajax({
			type : 'POST',
			url : basePath + "org/getlist",
			data : {},
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.flag == "1") {
					$("#parOrgName").text("");
					$("#parOrgId").val("");
					$("#orgName").val("");
					$("#status").val("1");
					
					if(data.DATA != undefined){
						if(data.DATA != undefined){
							orgList = data.DATA;
							var resultData = data.DATA;
							
							var zNodes = new Array();
							var obj = new Object();
							obj.id = 0;
							obj.name = "铁路总公司";
							obj.checked = false;
							zNodes.push(obj);
							
							if(resultData instanceof Array){
							 	for(var i = 0; i < resultData.length; i++){
									var obj = new Object();
									obj.id = resultData[i].orgId;
									obj.pId= resultData[i].parentorgid;
									obj.name = resultData[i].cnname;
									obj.orgcode = resultData[i].orgcode;
									obj.checked = false;
									
									zNodes.push(obj);
								}
							}
							else{
								var obj = new Object();
								obj.id = resultData.orgId;
								obj.pId= resultData.parentorgid;
								obj.name = resultData.cnname;
								obj.checked = false;
								
								zNodes.push(obj);
							}
						}
					}
					
					$.fn.zTree.init($("#orgTreeId"), setting, zNodes);
					
					var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
					treeObj.expandAll(true);
				}
				else {
					
				}
			},
			error : function(data) {
				layer.alert("数据请求失败!", 8);
			}
		});
	};
	
	this.createTrainTable = function (){
		$.ajax({
			async: false,
			type: "POST",
			url: basePath + "train/getListByOrg",
			dataType: "json",
			data:{id:1},
			success: function(resp) {	
				trainDatas=resp.data;
				trainTable=$("#trainTable").DataTable({
					data:trainDatas,
					columns :[{ data: "trainId"},
			//	        { data: "orgId" },
				        { data: "trainNumber" },
				        { data: "startStation" },
				        { data: "endStation" },
				        { data: "startTime" },
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
	
//		var sAjaxSource = basePath + "train/getlist";
//		var columns = [
//	        { "data": "trainId", "class":"left"},
//	        { "data": "orgId", "class":"left" },
//	        { "data": "trainNumber", "class":"left" },
//	        { "data": "startStation", "class":"left" },
//	        { "data": "endStation", "class":"left" },
//	        { "data": "startTime", "class":"left" },
//	        { "data": "endTime", "class":"left" },
//	        { "data": "createtime", "class":"left" },
//	        { "data": "createuser", "class":"left" },
//	        { "data": "updateuser", "class":"left" },
//	        { "data": "updatetime", "class":"left" }
//	    ];
        	
//		var retrieveData = function( sSource, aoData, fnCallback ) {  
//			$.ajax({
//				"type" : 'POST',
//				"url" : sSource,
//				"dataType" : "json",
//				"data" : {
//					data : JSON.stringify(aoData)
//				},
//				"success" : function(resp) {
////					fnCallback(resp);
//					$("#trainTable").DataTable({
//						data:resp.DATA,
//						columns :[
//							        { "data": "trainId", "class":"left"},
//							        { "data": "orgId", "class":"left" },
//							        { "data": "trainNumber", "class":"left" },
//							        { "data": "startStation", "class":"left" },
//							        { "data": "endStation", "class":"left" },
//							        { "data": "startTime", "class":"left" },
//							        { "data": "endTime", "class":"left" },
//							        { "data": "createtime", "class":"left" },
//							        { "data": "createuser", "class":"left" },
//							        { "data": "updateuser", "class":"left" },
//							        { "data": "updatetime", "class":"left" }
//							    ]
//					});
//				}
//			});
//		}
//		console.log(retrieveData);
//		createDataTables("goodsTable", sAjaxSource, columns, retrieveData);
	}
	
	this.addOrg = function(event){
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			var node = sNodes[0];
			
			var obj = new Object();
			obj.parentorgid = node.id;
			obj.cnname = $("#orgName").val();
			obj.status = $("#status").val();
			obj.orgcode = $("#orgcode").val();
			obj.deltag = $("#status").val();
			
			var param = {data:JSON.stringify(obj)};
		
			callAjax(basePath + "org/create",'POST', param, function(data){
				if (data.flag == "1") {
					layer.alert("组织机构组织机构添加成功!");
					
					if(event != undefined){
						var getOrgList = event.data.getList;
						getOrgList();
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
	};
	
	this.updateOrg = function(event){
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			var node = sNodes[0];
			
			for(var i = 0; i < orgList.length; i++){
				if(node.id == orgList[i].orgId){
					orgList[i].cnname = $("#orgName").val();
					orgList[i].status = $("#status").val();
					orgList[i].orgcode = $("#orgcode").val();
					orgList[i].deltag = $("#status").val();
					
					var param = {data:JSON.stringify(orgList[i])};
					callAjax(basePath + "org/create",'POST', param, function(data){
						if (data.flag == "1") {
							layer.alert("组织机构修改成功!");
							
							if(event != undefined){
								var getOrgList = event.data.getList;
								getOrgList();
							}
						}
						else{
							layer.alert("组织机构修改失败!");
						}
					});
				}
			}
		}
		else{
			layer.alert("请选择组织机构!", 8);
		}
	};
	
	this.deleteOrg = function(event){
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			var node = sNodes[0];
			
			var param = {data:node.id};
			callAjax(basePath + "org/delete",'POST', param, function(data){
				if (data.flag == "1") {
					layer.alert("组织机构删除成功!");
					
					if(event != undefined){
						var getOrgList = event.data.getList;
						getOrgList();
					}
				}
				else{
					layer.alert("组织机构删除失败!");
				}
			});
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