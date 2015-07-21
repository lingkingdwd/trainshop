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
	$('#trainTable tbody').on( 'click', 'tr', function () {
		tr=this;
		trTrainData=trainTable.row(this).data();
    } );
	$('#goodsTable tbody').on( 'click', 'tr', function () {
		tr=this;
		trGoodData=goodTable.row(this).data();
    } );
	$('#goodsTable2 tbody').on( 'click', 'tr', function () {
		tr=this;
		trGoodData2=goodTable2.row(this).data();
    } );
	
	 $('#trainTable a.btn-success').on('click', function (e) {
		 var trainId=trTrainData.trainId;
		 getGoodsData(trainId);
         $("#modalGoodList").modal("show");
     });
	 $('#trainTable a.btn-info').on('click', function (e) {
		 $("#modalGoodAdd").modal("show");
     });
	 
	 $('#goodsTable a.btn-primary').on('click', function (e) {
		 var good=new Object;
		 good.goodsId=trGoodData.goodsId;
		 good.trainId=trTrainData.trainId;
		 good.goodsNumber=trGoodData.goodsNumber;
		 good.shopPrice=trGoodData.shopPrice;
		 good.promotePrice=trGoodData.promotePrice;
		 good.promoteStartDate=11414111;
		 good.promoteEndDate=11414111;
		 good.warnNumber=10;
		 good.remark="";
		 onGood(good);
     });
	 
	 $('#goodsTable2 a.btn-warning').on('click', function (e) {
		 alert('xxx');
		 var goodId=trGoodData.goodId;
		 offGood(goodId);
     });
});
function onGood(good)
{
	$.ajax({
		async: false,
		type: "POST",
		url: basePath + "trainGoods/onGood",
		dataType: "json",
		data:{data:JSON.stringify(good)},
		success: function(data) {	
            if(data.flag==1)
            	{
            	goodTable2.row.add(good).draw( false );
            	 alert("商品上架成功!!");
            	}
            else
            	{
            	alert(data.message);
            	}
      
		},
		error: function() {
			alert("上架失败！");
		}
	});

	}
function offGood(goodId)
{
    if (confirm("确定下架该商品吗 ?") == false) {
        return;
    }
	$.ajax({
		async: false,
		type: "POST",
		url: basePath + "trainGoods/offGood",
		dataType: "json",
		data:{id:goodId},
		success: function(data) {	
//			console.log(data);
            if(data.flag==1)
            	{
            	goodsTable2.row('.selected').remove().draw( false );
            	 alert("商品下架成功!!");
            	}
            else
            	{
            	alert(data.message);
            	}
      
		},
		error: function() {
			alert("下架失败！");
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

function getGoodsData(trainId)
{
	goodTable2.clear().draw();
	$.ajax({
		type : 'POST',
		url :basePath + "trainGoods/getListByTrain",
//		data : {id:6},
		data : {id:trainId},
		async : false,
		dataType : "json",
		success : function(resp) {
			goodDatas2=$.makeArray(resp.data);
			$.each(goodDatas2,function(index,item){
				goodTable2.row.add(item).draw();
			});
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
			goodTable =$("#goodsTable").DataTable({
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
	                              targets: [0,3,4,6,8,9,10,11,12,13,14,15]
	                          },
	                          {
	                        	  targets: 16,
	                              render: function (data, type, row) {
	                            	  var html='<td><a class="btn btn-primary" value="'+row.goodsId+'" href="javascript:;">上架</a></td>';
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
	
	goodTable2 =$("#goodsTable2").DataTable({
	    data:goodDatas2,
	    columns: [
	              { data: 'trainId' },
	              { data: 'goodsId' },
	              { data: 'goodsNumber' },
	              { data: 'remark' },
//	              { data: 'marketPrice' },
	              { data: 'shopPrice' },
	              { data: 'promotePrice' },
	              { data: 'promoteStartDate' },
	              { data: 'promoteEndDate' },
	              { data: 'remark' },
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
               	   visibale:false,
            	   targets:[1]
               },
                      {
                    	  targets: 9,
                          render: function (data, type, row) {
                        	 var html='<td><a class="btn btn-warning" value="'+row.goodsId+'" href="javascript:;">下架</a></td>';
                             return html;
                          }
                      }
                  ]
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
//				        { data: "trainId"},
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
		                    	targets:[5],
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