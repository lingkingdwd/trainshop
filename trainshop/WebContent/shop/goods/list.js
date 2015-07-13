var categoryList = new Array();

$(document).ready(function() {
	function zTreeOnClick(event, treeId, treeNode) {
		for(var i = 0; i < categoryList.length; i++){
			if(treeNode.tId == categoryList[i].catId){
				
			}
		}
		alert(treeNode.tId + ", " + treeNode.name);
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
	
	//招标分类读取
	$.ajax({
		type : 'POST',
		url : basePath + "category/getlist",
		data : {},
		async : false,
		dataType : "json",
		success : function(data) {
			if (data.flag == "1") {
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
})

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