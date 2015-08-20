var categoryList = new Array();
var currentGoods;

var editor = null;

$(document).ready(function() {
	var goodsUpdate = new GoodsUpdate();
	goodsUpdate.createAddCondition();
	
	var goodsId = $("#goodsId").val();
	if(goodsId != ""){
		var obj = new Object();
		obj.goodsId = goodsId;
		
		var param = {data:JSON.stringify(obj)};
		callAjax(basePath + "goods/getGoodsById",'POST', param, function(data){
			if (data.flag == "1") {
				currentGoods = data.DATA;
				
				editor = CKEDITOR.replace('goodsDesc'); 
				
				goodsUpdate.initModal(data);
			}
			else{
				layer.alert("获取商品信息失败!");
			}
		});
	}
	
	$("#category").on("click",function(){
		$('#categoryModalId').modal('show');
	});
	
	$("#saveBtn").on('click', goodsUpdate.addGoods);
		
	//goodsPublish.createGoodsTable();
	
//	$("#addGoods").on("click", {getList:categoryManage.createGoodsTable}, categoryManage.addGoods);
//	
//	$("#saveCategory").on("click",{getList:categoryManage.getCategoryList}, categoryManage.updateCategory);
//	
//	$("#deleteCategory").on("click",{getList:categoryManage.getCategoryList}, categoryManage.deleteCategory);
});

function GoodsUpdate(){
	this.initModal = function (data){
		var rowData = data.DATA;
	    $("#goodsName").val(rowData.goodsName);
		$("#categoryId").val(rowData.catId);
		$("#category").val(rowData.catName);
		$("#goodsSn").val(rowData.goodsSn);
		$("#shopPrice").val(rowData.shopPrice);
		$("#marketPrice").val(rowData.marketPrice);
		$("#promotePrice").val(rowData.promotePrice);
		$("#goodsBrief").val(rowData.goodsBrief);
		//$("#goodsDesc").val(rowData.goodsDesc);
		$("#integral").val(rowData.integral);
		$("input[name='isBest']:checked").val(rowData.isBest);
		$("input[name='isNew']:checked").val(rowData.isNew);
		$("input[name='isHot']:checked").val(rowData.isHot);
		$("input[name='isPromote']:checked").val(rowData.isPromote);
		$("#giveIntegral").val(rowData.giveIntegral);
		$("#sellerNote").val(rowData.sellerNote);
		
		editor.setData(rowData.goodsDesc); 
		
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
		
	    $('#goodsThumb').on('fileclear', function(event, key) {
	        currentGoods.goodsThumb = "";
	    });
	    $('#goodsThumb').on('fileclear', function(event, key) {
	        currentGoods.goodsImg = "";
	    });
	    $('#originalImg').on('fileclear', function(event, key) {
	        currentGoods.originalImg = "";
	    });
	};
	
	this.createAddCondition = function(){
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
	
	this.addGoods = function(event){
		var obj = new Object();
		var val = "";
		val = $("#goodsName").val();
		if (val != "" && val != null) {
			obj.goodsName = val;
		}
		else{
			layer.alert("请输入商品名称!"); 
			return;
		}
		val = $("#categoryId").val();
		if (val != "" && val != null) {
			obj.catId = val;
		}
		else{
			layer.alert("请选择商品分类!"); 
			return;
		}
		val = $("#goodsSn").val();
		if (val != "" && val != null) {
			obj.goodsSn = val;
		}
		else{
			layer.alert("请输入商品货号!"); 
			return;
		}
		
		val = $("#shopPrice").val();
		if (val != "" && val != null) {
			obj.shopPrice = val;
		}
		else{
			layer.alert("请输入商品售价!"); 
			return;
		}
		
		obj.goodsId = $("#goodsId").val();
		obj.marketPrice = $("#marketPrice").val();
		obj.promotePrice = $("#promotePrice").val();
		obj.goodsBrief = $("#goodsBrief").val();
		obj.integral = $("#integral").val();
		obj.isBest = $("input[name='isBest']:checked").val();
		obj.isNew = $("input[name='isNew']:checked").val();
		obj.isHot = $("input[name='isHot']:checked").val();
		obj.isPromote = $("input[name='isPromote']:checked").val();
		obj.giveIntegral = $("#giveIntegral").val();
		obj.sellerNote = $("#sellerNote").val();
		obj.goodsNumber = 0;
		//obj.goodsDesc = $("#goodsDesc").val();
		
		var content = editor.getData(); 
		obj.goodsDesc = content;
		
		obj.goodsThumb = currentGoods.goodsThumb;
		obj.goodsImg = currentGoods.goodsImg;
		obj.originalImg = currentGoods.originalImg;
			
		var param = {data:JSON.stringify(obj)};
			
		var options = { 
			method:"POST",
			datatype : "text",
			url: basePath + "goods/saveOrUpdate",
			data: param,
			semantic:true,
			beforeSubmit: function (formData, jqForm, options) {   
				var queryString = $.param(formData);   	
				return true;
			}, 
			error:function(request){
				
			},
			success: function (data) {
				var returnData = eval('(' + data + ')');
				var flag = returnData.flag;
				if("1" == flag) {
		        	$("#saveBtn").removeAttr("disabled");
					layer.alert("商品修改成功!");
				}
		        else{
					$("#saveBtn").removeAttr("disabled");
					layer.alert(returnData.message);  
				}  
			}  
		};
		$("#addGoodsForm").ajaxSubmit(options);
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
	
	$('#backList').on('click', function (e) {
    	location.href = basePath + "goods/init";
    });
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