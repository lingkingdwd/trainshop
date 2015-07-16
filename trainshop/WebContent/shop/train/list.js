var orgList = new Array();

$(document).ready(function() {
	var trainManage = new TrainManage();
	//trainManage.createTrainTable();
	trainManage.getOrgList();
	
	trainManage.createTrainTable();
	
	/*$("#addOrg").on("click", {getList:orgManage.getOrgList}, orgManage.addOrg);
	
	$("#saveOrg").on("click",{getList:orgManage.getOrgList}, orgManage.updateOrg);
	
	$("#deleteOrg").on("click",{getList:orgManage.getOrgList}, orgManage.deleteOrg);*/
});

function TrainManage(){
	var zTreeOnClick = function(event, treeId, treeNode) {
		for(var i = 0; i < orgList.length; i++){
			if(treeNode.id == orgList[i].orgId){
				
				var treeObj = $.fn.zTree.getZTreeObj("orgTreeId");
				var sNodes = treeObj.getSelectedNodes();
				if (sNodes.length > 0) {
					var node = sNodes[0].getParentNode();
					$("#parOrgName").text(node.name);
					$("#parOrgId").val(node.id);
				}
				$("#orgName").val(orgList[i].cnname);
				$("#status").val(orgList[i].status);
				$("#orgcode").val(orgList[i].orgcode);
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
		var sAjaxSource = basePath + "train/getlist";
		var columns = [
	        { data: 'trainId', sClass:'left'},
	        { data: 'orgId', sClass:'left' },
	        { data: 'trainNumber', sClass:'left' },
	        { data: 'startStation', sClass:'left' },
	        { data: 'endStation', sClass:'left' },
	        { data: 'startTime', sClass:'left' },
	        { data: 'endTime', sClass:'left' },
	        { data: 'createtime', sClass:'left' },
	        { data: 'createuser', sClass:'left' },
	        { data: 'updateuser', sClass:'left' },
	        { data: 'updatetime', sClass:'left' }
	    ];
        	
        var fnServerData = function(sSource, aoData, fnCallback) {
			$.ajax({
				"type" : 'post',
				"url" : sSource,
				"dataType" : "json",
				"data" : {
					aoData : JSON.stringify(aoData)
				},
				"success" : function(resp) {
					fnCallback(resp);
				}
			});
		}
		
		var retrieveData = function( sSource, aoData, fnCallback ) {  
			$.ajax({
				"type" : 'post',
				"url" : sSource,
				"dataType" : "json",
				"data" : {
					data : JSON.stringify(aoData)
				},
				"success" : function(resp) {
					fnCallback(resp);
				}
			});
		}
		
		
		
		/*$("#goodsTable").dataTable({
			//"oLanguage" : oLanguage,
			"bJQueryUI": true,
			"bPaginate" : true,// 分页按钮
			"bFilter" : true,// 搜索栏
			"bLengthChange" : true,// 每行显示记录数
			"iDisplayLength" : 10,// 每页显示行数
			"bSort" : false,// 排序
			//"aLengthMenu": [[50,100,500,1000,10000], [50,100,500,1000,10000]],//定义每页显示数据数量
			//"iScrollLoadGap":400,//用于指定当DataTable设置为滚动时，最多可以一屏显示多少条数据
			//"aaSorting": [[4, "desc"]],
			"bInfo" : true,// Showing 1 to 10 of 23 entries 总记录数没也显示多少等信息
			"bWidth":true,
			//"sScrollY": "62%",
	        //"sScrollX": "210%",
	        "bScrollCollapse": true,
			"sPaginationType" : "full_numbers", // 分页，一共两种样式 另一种为two_button // 是datatables默认
			"bProcessing" : true,
			"bServerSide" : true,
			"bDestroy": true,
			"bSortCellsTop": true,	
	        "sAjaxSource": sAjaxSource, 
	        "aoColumns": columns,
	        "fnServerData" : fnServerData
	    });*/
		
		createDataTables("goodsTable", sAjaxSource, columns, retrieveData);
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