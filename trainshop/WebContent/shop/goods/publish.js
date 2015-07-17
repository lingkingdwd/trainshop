var categoryList = new Array();

$(document).ready(function() {
	$("#originalImg").fileinput({
		showCaption: false,
		showUpload: false,
		showPreview: true,
		previewFileType: "image",
		maxFileSize: 3000,
		allowedFileTypes: ["image"]
	});
	
	$("#category").on("click",function(){
		$('#categoryModalId').modal('show');
	});
	
	var goodsPublish = new GoodsPublish();
	//goodsPublish.createGoodsTable();
	
//	$("#addGoods").on("click", {getList:categoryManage.createGoodsTable}, categoryManage.addGoods);
//	
//	$("#saveCategory").on("click",{getList:categoryManage.getCategoryList}, categoryManage.updateCategory);
//	
//	$("#deleteCategory").on("click",{getList:categoryManage.getCategoryList}, categoryManage.deleteCategory);
});

function GoodsPublish(){
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
			}
			else {
				
			}
		},
		error : function(data) {
			layer.alert("数据请求失败!", 8);
		}
	});
	
	this.addGoods = function(event){
		var treeObj = $.fn.zTree.getZTreeObj("categoryTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			var node = sNodes[0];
			
			var obj = new Object();
			obj.parentId = node.id;
			obj.catName = $("#categoryName").val();
			obj.isShow = $("#isShow").val();
			obj.showInNav = 0;
			obj.sortOrder = 50;
			obj.catDesc = "";
			obj.grade = 0;
			obj.filterAttr = "0";
			obj.keywords = "";
			
			var param = {data:JSON.stringify(obj)};
		
			callAjax(basePath + "category/create",'POST', param, function(data){
				if (data.flag == "1") {
					layer.alert("分类分类添加成功!");
					
					if(event != undefined){
						var getCategoryList = event.data.getList;
						getCategoryList();
					}
				}
				else{
					layer.alert("分类分类添加失败!");
				}
			});
		}
		else{
			layer.alert("请选择父级分类!", 8);
		}
	};
	
	this.updateCategory = function(event){
		var treeObj = $.fn.zTree.getZTreeObj("categoryTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			var node = sNodes[0];
			
			for(var i = 0; i < categoryList.length; i++){
				if(node.id == categoryList[i].catId){
					categoryList[i].catName = $("#categoryName").val();
					categoryList[i].isShow = $("#isShow").val();
					
					var param = {data:JSON.stringify(categoryList[i])};
					callAjax(basePath + "category/create",'POST', param, function(data){
						if (data.flag == "1") {
							layer.alert("分类修改成功!");
							
							if(event != undefined){
								var getCategoryList = event.data.getList;
								getCategoryList();
							}
						}
						else{
							layer.alert("分类修改失败!");
						}
					});
				}
			}
		}
		else{
			layer.alert("请选择分类!", 8);
		}
	};
	
	this.deleteCategory = function(event){
		var treeObj = $.fn.zTree.getZTreeObj("categoryTreeId");
		var sNodes = treeObj.getSelectedNodes();
		if (sNodes.length > 0) {
			var node = sNodes[0];
			
			var param = {data:node.id};
			callAjax(basePath + "category/delete",'POST', param, function(data){
				if (data.flag == "1") {
					layer.alert("分类删除成功!");
					
					if(event != undefined){
						var getCategoryList = event.data.getList;
						getCategoryList();
					}
				}
				else{
					layer.alert("分类删除失败!");
				}
			});
		}
		else{
			layer.alert("请选择分类!", 8);
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