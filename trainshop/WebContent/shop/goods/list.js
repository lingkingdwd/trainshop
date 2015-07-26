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
	$('#goodsTable').on('click', '.view-class', function (e) {
		var goodsId = $(this).attr('goodsId');
		initModal(goodsId);
		$("#modalGood").modal("show");
		$("#add-save").hide();
	});
	 /*$('#goodsTable a.btn-info').on('click', function (e) {
		 initModal(trRowData);
		 $("#modalGood").modal("show");
		 $("#add-save").show();
     });*/
	$('body').on('click', 'button[name="editBtn"]', function(){
		var goodsId = $(this).attr('goodsId');
		location.href = basePath + "goods/initUpdate?goodsId=" + goodsId;
	});
	$('body').on('click', 'button[name="deleteBtn"]', function (e) {
		e.preventDefault();

		if (confirm("确定删除该商品吗 ?") == false) {
			return;
		}
		
		var btn = $(this);

		var goodId = $(this).attr('goodsId');
		$.ajax({
       		async: false,
       		type: "POST",
       		url: basePath + "goods/deleteGood",
       		dataType: "json",
       		data:{id:goodId},
       		success: function(data) {	
				if(data.flag==1) {
					goodsTable.clear().draw();
					$.ajax({
						type : 'GET',
						url :basePath + "goods/getAllList",
						async : false,
						dataType : "json",
						success : function(resp) {
							goodDatas=$.makeArray(resp.DATA);
							$.each(goodDatas,function(index,item){
								goodsTable.row.add(item).draw();
							});
				//			trainTable.draw();
						},
						error : function(data) {
							layer.alert("数据请求失败!", 8);
						}
					});
					//$(btn).parent().parent().remove();
					layer.alert("商品删除成功!");
				}
				else{
					alert(data.message);
				}
       		},
       		error: function() {
       			alert("删除失败！");
       		}
       	});
	});
       
       createAddCondition();
       
       $("#category").on("click",function(){
			$('#categoryModalId').modal('show');
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

function initModal(goodsId)
{
	var rowData;
	for(var i = 0; i < goodDatas.length; i++){
		if(goodDatas[i].goodsId == goodsId){
			rowData = goodDatas[i];
		}
	}
	
    $("#goodsName").val(rowData.goodsName);
	$("#categoryId").val(rowData.catId);
	$("#category").val(rowData.catName);
	$("#goodsSn").val(rowData.goodsSn);
	$("#shopPrice").val(rowData.shopPrice);
	$("#marketPrice").val(rowData.marketPrice);
	$("#promotePrice").val(rowData.promotePrice);
	$("#goodsBrief").val(rowData.goodsBrief);
	$("#goodsDesc").val(rowData.goodsDesc);
	$("#integral").val(rowData.integral);
	$("input[name='isBest']:checked").val(rowData.isBest);
	$("input[name='isNew']:checked").val(rowData.isNew);
	$("input[name='isHot']:checked").val(rowData.isHot);
	$("input[name='isPromote']:checked").val(rowData.isPromote);
	$("#giveIntegral").val(rowData.giveIntegral);
	$("#sellerNote").val(rowData.sellerNote);
	
	$('#goodsThumb').fileinput('clear');
	$('#goodsImg').fileinput('clear');
	$('#originalImg').fileinput('clear');

	var goodsThumb = "";
	if(rowData.goodsThumb != ""){
		goodsThumb = "<img src='" + pathNoSlash + rowData.goodsThumb + "' class='file-preview-image' alt='微缩图片' title='微缩图片'>";
	}
	
	var thumb = [];
	if(goodsThumb != ""){
		thumb = [goodsThumb];
	}
	
	$("#goodsThumb").fileinput({
		initialPreview : thumb,
		showCaption: false,
		showUpload: false,
		showPreview: true,
		previewFileType: "image",
		maxFileSize: 3000,
		allowedFileTypes: ["image"]
	});
	
	var goodsImg = "";
	if(rowData.goodsImg != ""){
		goodsImg = "<img src='" + pathNoSlash + rowData.goodsImg + "' class='file-preview-image' alt='实际大小图片' title='实际大小图片'>";
	}
	
	var img = [];
	if(goodsImg != ""){
		img = [goodsImg];
	}
	$("#goodsImg").fileinput({
		initialPreview: img,
		showCaption: false,
		showUpload: false,
		showPreview: true,
		previewFileType: "image",
		maxFileSize: 3000,
		allowedFileTypes: ["image"]
	});
	
	var originalImg = "";
	if(rowData.originalImg != ""){
		originalImg = "<img src='" + pathNoSlash + rowData.originalImg + "' class='file-preview-image' alt='原始图片' title='原始图片'>";
	}
	
	var original = [];
	if(originalImg != ""){
		original = [originalImg];
	}
	$("#originalImg").fileinput({
		initialPreview: original,
		showCaption: false,
		showUpload: false,
		showPreview: true,
		previewFileType: "image",
		maxFileSize: 3000,
		allowedFileTypes: ["image"]
	});
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
	                            	 var html='<td>'+row.goodsSn+'</td>';
	                                 return html;
	                              }
	                          },
	                          {
	                        	  targets: 2,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class ="view-class" goodsId="' + row.goodsId + '">'+row.goodsName+'</a></td>';
	                                 return html;
	                              }
	                          },
	                          {
	                        	  targets: 17,
	                              render: function (data, type, row) {
	                            	 var html='<td><button type="button" class="btn btn-info" name="editBtn" goodsId="' + row.goodsId + '" href="javascript:;">编辑</button><button type="button" class="btn btn-danger" name="deleteBtn" goodsId="' + row.goodsId + '">删除</button></td>';
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

