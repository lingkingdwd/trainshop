var trainTable;
var trainDatas=new Array;
$(document).ready(function() {
	var trainGoodsManage = new TrainGoodsManage();
	trainGoodsManage.getOrgList();
//	trainGoodsManage.InitTrainTable();
	trainTable=$("#trainTable").DataTable({
		ajax: {
			url:basePath + "train/getListByOrg?id='0'",
			type : 'POST'
		},
//		retrieve: true,
		columns :[
		        { data: "trainId"},
	//	        { data: "orgId" },
		        { data: "trainNumber" },
		        { data: "startStation" },
		        { data: "endStation" },
		        { data: "startTime" },
		        { data: "endTime" }
			    ],
	  "processing": true,
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

	
	

});

function TrainGoodsManage(){
	var zTreeOnClick = function(event, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			//console.log(trainTable);
//			$('#trainTable').dataTable().fnClearTable();
//			//刷新选中局下的列车列表
//			var trainTable=$('#trainTable').dataTable();
			trainTable.ajax.url( basePath + "train/getListByOrg?id="+sNodes[0].id ).load();
//			$.ajax({
//				type : 'POST',
//				url : basePath + "train/getListByOrg",
//				dataType : "json",
//				data : {
//					id : JSON.stringify(sNodes[0].id)
//				},
//				"success" : function(resp) {
//					
//					if(resp.flag=="1")
//						{
////						trainDatas=$.makeArray(resp.DATA);
//						
//						
//						}
//					else
//						{
//						alert(resp.message);
//						}
//					
//				}
//			});
//		
		}
	};
	
	var setting = {
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
					if(data.DATA != undefined){
						if(data.DATA != undefined){
							var resultData = $.makeArray(data.DATA);
							var zNodes = new Array();
							//构建根节点
							var obj = new Object();
							obj.id = 0;
							obj.name = "铁路总公司";
							obj.checked = false;
							zNodes.push(obj);
							
						 	for(var i = 0; i < resultData.length; i++){
								var obj = new Object();
								obj.id = resultData[i].orgId;
								obj.pId= resultData[i].parentorgid;
								obj.name = resultData[i].cnname;
								obj.orgcode = resultData[i].orgcode;
								obj.checked = false;
								
								zNodes.push(obj);
							}
						 	
						 	$.fn.zTree.init($("#orgTreeId"), setting, zNodes);
							
							var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
							treeObj.expandAll(true);
						}
					}
					
				}
				else {
					alert(data.message);
				}
			},
			error : function(data) {
				layer.alert("数据请求失败!", 8);
			}
		});
	};
	
		this.InitTrainTable=function()
		{
			trainTable=$("#trainTable").DataTable({
				data:trainDatas,
				retrieve: true,
				columns :[
				        { data: "trainId"},
			//	        { data: "orgId" },
				        { data: "trainNumber" },
				        { data: "startStation" },
				        { data: "endStation" },
				        { data: "startTime" },
				        { data: "endTime" }
					    ],
			  "processing": true,
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
		};
		
}
