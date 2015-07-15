var orgList = new Array();

$(document).ready(function() {
	var orgManage = new OrgManage();
	orgManage.getOrgList();
	
	$("#addOrg").on("click", {getList:orgManage.getOrgList}, orgManage.addOrg);
	
	$("#saveOrg").on("click",{getList:orgManage.getOrgList}, orgManage.updateOrg);
	
	$("#deleteOrg").on("click",{getList:orgManage.getOrgList}, orgManage.deleteOrg);
	
	$('#example').dataTable({
		/*基本参数设置，以下参数设置和默认效果一致*/  
        "bPaginate": true, //翻页功能  
        "bLengthChange": false, //改变每页显示数据数量  
        "bFilter": true, //过滤功能  
        "bSort": true, //排序功能  
        "bInfo": true,//页脚信息  
        "bAutoWidth": true,//自动宽度  
        /*默认排序设置*/  
        "aaSorting": [[ 4, "desc" ]],//设置第5个元素为默认排序  
        /*默认翻页样式设置*/  
        "sPaginationType": "full_numbers",  
        /*是否开启主题*/  
        "bJQueryUI": true,  
        /*语言设置*/  
        "oLanguage": {  
            "sLengthMenu": "每页显示 _MENU_条",  
            "sZeroRecords": "没有找到符合条件的数据",  
            "sProcessing": "<img src=’./loading.gif’ />",  
            "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",  
            "sInfoEmpty": "木有记录",  
            "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",  
            "sSearch": "搜索：",  
            "oPaginate": {  
                "sFirst": "首页",  
                "sPrevious": "前一页",  
                "sNext": "后一页",  
                "sLast": "尾页"  
            }  
        }  
    });
});

function OrgManage(){
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