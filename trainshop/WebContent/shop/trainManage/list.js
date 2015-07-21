var trainTable;
var trainDatas=new Array;
var orgId=1;

var goodTable;
var goodTable2;
var goodDatas=new Array;
var goodDatas2=new Array;
$(document).ready(function() {
	pageInit();
	var trainGoodsManage = new TrainGoodsManage();
	trainGoodsManage.getOrgList();
//	trainGoodsManage.InitTrainTable();
//	getTrainData(orgId);
	
	
	 $('#trainTable a.btn-success').on('click', function (e) {
//		 initModal(trRowData);
         $("#modalGoodList").modal("show");
     });
	 $('#trainTable a.btn-info').on('click', function (e) {
//		 initModal(trRowData);
		 $("#modalGoodAdd").modal("show");
     });
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
function TrainGoodsManage(){
	var zTreeOnClick = function(event, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			orgId=sNodes[0].id;
			getTrainData(orgId);
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
			columns :[
			        { data: "trainId"},
		//	        { data: "orgId" },
			        { data: "trainNumber" },
			        { data: "startStation" },
			        { data: "endStation" },
			        { data: "startTime" },
			        { data: "endTime" },
			        { data: null }
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
			};
		
}
function pageInit()
{

	$.ajax({
		async: false,
		type: "GET",
		url: basePath + "goods/getlist",
		dataType: "json",
		success: function(data) {	
//			goodsTable.init();
//			console.log(data);
			goodDatas=data.DATA;
			goodsTable =$("#goodsTable").DataTable({
			    data:goodDatas,
			    columns: [
			              { data: 'goodsId' },
			              { data: 'goodsNumber' },
			              { data: 'goodsName' },
			              { data: 'catId' },
			              { data: 'marketPrice' },
			              { data: 'shopPrice' },
			              { data: 'promotePrice' },
			              { data: 'goodsBrief' },
			              { data: 'goodsDesc' },
			              { data: 'integral' },
			              { data: 'isBest' },
			              { data: 'isNew' },
			              { data: 'isHot' },
			              { data: 'isPromote' },
			              { data: 'giveIntegral' },
			              { data: 'sellerNote' },
			              { data: null}
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
					   },
	                      columnDefs: [{
	                              visible: false,
	                              targets: [0,6,8,9,10,11,12,13,14,15]
	                          },
	                          {
	                        	  targets: 1,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class ="view-class" href="javascript:;">'+row.goodsSn+'</a></td>';
	                                 return html;
	                              }
	                          },
	                          {
	                        	  targets: 16,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class="btn btn-info" value="'+row.goodsId+'" href="javascript:;">上架</a></td>';
	                                 return html;
	                              }
	                          }
	                      ]
			});
		},
		error: function() {
			alert("页面加载失败！");
		}
	});
	
	$.ajax({
		async: false,
		type: "GET",
		url: basePath + "goods/getlist",
		dataType: "json",
		success: function(data) {	
//			goodsTable.init();
//			console.log(data);
			goodDatas2=data.DATA;
			goodsTable2 =$("#goodsTable2").DataTable({
			    data:goodDatas2,
			    columns: [
			              { data: 'goodsId' },
			              { data: 'goodsNumber' },
			              { data: 'goodsName' },
			              { data: 'catId' },
			              { data: 'marketPrice' },
			              { data: 'shopPrice' },
			              { data: 'promotePrice' },
			              { data: 'goodsBrief' },
			              { data: 'goodsDesc' },
			              { data: 'integral' },
			              { data: 'isBest' },
			              { data: 'isNew' },
			              { data: 'isHot' },
			              { data: 'isPromote' },
			              { data: 'giveIntegral' },
			              { data: 'sellerNote' },
			              { data: null}
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
					   },
	                      columnDefs: [{
	                              visible: false,
	                              targets: [0,6,8,9,10,11,12,13,14,15]
	                          },
	                          {
	                        	  targets: 1,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class ="view-class" href="javascript:;">'+row.goodsSn+'</a></td>';
	                                 return html;
	                              }
	                          },
	                          {
	                        	  targets: 16,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class="btn btn-info" value="'+row.goodsId+'" href="javascript:;">下架</a></td>';
	                                 return html;
	                              }
	                          }
	                      ]
			});
		},
		error: function() {
			alert("页面加载失败！");
		}
	});
	
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
		                    		 var html='<td><a class="btn btn-info" value="'+row.goodsId+'" href="javascript:;">商品上车</a><a class="btn btn-success" value="'+row.goodsId+'" href="javascript:;">商品列表</a></td>';
	                                 return html;
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