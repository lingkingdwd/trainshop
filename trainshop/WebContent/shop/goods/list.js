 var goodsTable;
 
 var goodDatas=new Array();
var categoryDatas = new Array();
var brandDatas=new Array();
var tr;
var trRowData;
$(document).ready(function() {
	pageInit();
	
	$('#goodsTable tbody').on( 'click', 'tr', function () {
		tr=this;
		trRowData=goodsTable.row(this).data();
//		console.log(trRowData);
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	goodsTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
	 $('#goodsTable a.view-class').on('click', function (e) {
		 initModal(trRowData);
         $("#modalGood").modal("show");
         $("#add-save").hide();
     });
	 $('#goodsTable a.btn-info').on('click', function (e) {
		 initModal(trRowData);
		 $("#modalGood").modal("show");
		 $("#add-save").show();
     });
    
	   $('#goodsTable a.btn-danger').on('click', function (e) {
           e.preventDefault();

           if (confirm("确定删除该商品吗 ?") == false) {
               return;
           }

        
           var goodId=$(this).attr('value');
           console.log(goodId);
       	$.ajax({
       		async: false,
       		type: "POST",
       		url: basePath + "goods/deleteGood",
       		dataType: "json",
       		data:{id:goodId},
       		success: function(data) {	
//       			console.log(data);
                   if(data.flag==1)
                   	{
                	 goodsTable.row('.selected').remove().draw( false );
                   	 alert("商品删除成功!!");
                   	}
                   else
                   	{
                   	alert(data.message);
                   	}
             
       		},
       		error: function() {
       			alert("删除失败！");
       		}
       	});

       });
       
       $("#category").on("click",function(){
			$('#categoryModalId').modal('show');
			createAddCondition();
		});
       
        $('#btn_addGood').on('click', function (e) {
        	location.href = basePath + "goods/publish";
        });
	   
	   $('#add-save').on('click', function () {
			saveGood();
		});
});

function createAddCondition(){
	var zTreeOnClick = function zTreeOnClick(event, treeId, treeNode) {
		for(var i = 0; i < categoryList.length; i++){
			if(treeNode.id == categoryList[i].catId){
				
				var treeObj = $.fn.zTree.getZTreeObj("categoryTreeId");
				var sNodes = treeObj.getSelectedNodes();
				if (sNodes.length > 0) {
					var node = sNodes[0].getParentNode();
					$("#parCategoryName").text(node.name);
					$("#parCategoryId").val(node.id);
				}
				$("#categoryName").val(categoryList[i].catName);
				$("#isShow").val(categoryList[i].isShow);
			}
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
	
	var treeHandleFunc = function () {
		//单位确定按钮
		var treeObj = $.fn.zTree.getZTreeObj("categoryTreeId");
		var nodes = treeObj.getSelectedNodes(true);
		
		if(nodes.length > 0){
			$("#categoryId").val(nodes[0].id);
			$("#category").val(nodes[0].name);
		}
		
		$('#categoryModalId').hide();
	};
	
	//分类读取
	$.ajax({
		type : 'POST',
		url : basePath + "category/getlist",
		data : {},
		async : false,
		dataType : "json",
		success : function(data) {
			if (data.flag == "1") {
				$("#parCategoryName").text("");
				$("#parCategoryId").val("");
				$("#categoryName").val("");
				$("#isShow").val("1");
				
				if(data.DATA != undefined){
					if(data.DATA != undefined){
						categoryList = data.DATA;
						var resultData = data.DATA;
						
						var zNodes = new Array();
						var obj = new Object();
						obj.id = 0;
						obj.name = "商品分类";
						obj.checked = false;
						zNodes.push(obj);
						
						if(resultData instanceof Array){
						 	for(var i = 0; i < resultData.length; i++){
								var obj = new Object();
								obj.id = resultData[i].catId;
								obj.pId= resultData[i].parentId;
								obj.name = resultData[i].catName;
								obj.checked = false;
								
								zNodes.push(obj);
							}
						}
						else{
							var obj = new Object();
							obj.id = resultData.catId;
							obj.pId= resultData.parentId;
							obj.name = resultData.catName;
							obj.checked = false;
							
							zNodes.push(obj);
						}
					}
					
				}
				
				$.fn.zTree.init($("#categoryTreeId"), setting, zNodes);
				
				var treeObj = $.fn.zTree.getZTreeObj("categoryTreeId");
				treeObj.expandAll(true);
				
				$("#selectCategoryBtnId").click(treeHandleFunc).trigger("click");
			}
			else {
				
			}
		},
		error : function(data) {
			layer.alert("数据请求失败!", 8);
		}
	});
}

function initModal(rowData)
{
    $("#goodsName").val(trRowData.goodsName);
	$("#categoryId").val(trRowData.catId);
	$("#category").val(trRowData.catName);
	$("#goodsSn").val(trRowData.goodsSn);
	$("#shopPrice").val(trRowData.shopPrice);
	$("#marketPrice").val(trRowData.marketPrice);
	$("#promotePrice").val(trRowData.promotePrice);
	$("#goodsBrief").val(trRowData.goodsBrief);
	$("#goodsDesc").val(trRowData.goodsDesc);
	$("#integral").val(trRowData.integral);
	$("input[name='isBest']:checked").val(trRowData.isBest);
	$("input[name='isNew']:checked").val(trRowData.isNew);
	$("input[name='isHot']:checked").val(trRowData.isHot);
	$("input[name='isPromote']:checked").val(trRowData.isPromote);
	$("#giveIntegral").val(trRowData.giveIntegral);
	$("#sellerNote").val(trRowData.sellerNote);
	}
function deleteGood()
{
	}
function saveGood()
{

	trRowData.goodsName=$("#goodsName").val();
//	trRowData.catId=$("#categoryId").val();
	trRowData.catId=10;
	trRowData.goodsSn=$("#goodsSn").val();
	trRowData.shopPrice=$("#shopPrice").val();
	trRowData.marketPrice=$("#marketPrice").val();
	trRowData.promotePrice=$("#promotePrice").val();
	trRowData.goodsBrief=$("#goodsBrief").val();
	trRowData.goodsDesc=$("#goodsDesc").val();
	trRowData.integral=$("#integral").val();
	trRowData.isBest=$("input[name='isBest']:checked").val();
	trRowData.isNew=$("input[name='isNew']:checked").val();
	trRowData.isHot=$("input[name='isHot']:checked").val();
	trRowData.isPromote=$("input[name='isPromote']:checked").val();
	trRowData.giveIntegral=$("#giveIntegral").val();
	trRowData.sellerNote=$("#sellerNote").val();
	
	var param = {data:JSON.stringify(trRowData)};
	
	$.ajax({
		async: false,
		type: "POST",
		url: basePath + "goods/update",
		dataType: "json",
		data:param,
		success: function(data) {
			goodsTable.row(tr).data(trRowData).draw(false);
			alert("商品修改成功！");
		},
		error: function() {
			goodsTable.row(tr).data(trRowData).draw(false);
			alert("商品修改成功！");
		}
	});
	}
function pageInit()
{
	$.ajax({
		async: false,
		type: "GET",
		url: basePath + "goods/getAllList",
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
			              { data: 'catName' },
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
	                              targets: [0,3,7,9,10,11,12,13,14,15,16]
	                          },
	                          {
	                        	  targets: 1,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class ="view-class" href="javascript:;">'+row.goodsSn+'</a></td>';
	                                 return html;
	                              }
	                          },
	                          {
	                        	  targets: 17,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class="btn btn-info" value="'+row.goodsId+'" href="javascript:;">编辑</a><a class="btn btn-danger" value="'+row.goodsId+'" href="javascript:;">删除</a></td>';
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
	}

