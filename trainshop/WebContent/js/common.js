function callAjax(url, type, param, func) {
	var loadi;
	if (param != null) {
		$.ajax({
			cache : true,
			type : type,
			url : url,
			async : false,
			data : param,
			dataType : "json",
			beforeSend : function(XMLHttpRequest) {
				loadi = layer.load('数据处理中…');
			},
			complete : function(XMLHttpRequest, textStatus) {
				layer.close(loadi);
			},
			error : function(request) {
				alert("数据库连接超时或发生错误，请联系管理员!");
			},
			success : func
		});
	} else {
		$.ajax({
			cache : true,
			type : type,
			url : url,
			async : true,
			dataType : "json",
			beforeSend : function(XMLHttpRequest) {
				loadi = layer.load('数据处理中…');
			},
			complete : function(XMLHttpRequest, textStatus) {
				layer.close(loadi);
			},
			error : function(request) {
				alert("数据库连接超时或发生错误，请联系管理员!");
			},
			success : func
		});
	}
};

function callAjaxByAsync(url, type, param,func) {
	var loadi;
	if (param != null) {
		$.ajax({
			cache : true,
			type : type,
			url : url,
			async : true,
			data : param,
			dataType : "json",
			beforeSend : function(XMLHttpRequest) {
				loadi = layer.load('数据处理中…');
			},
			complete : function(XMLHttpRequest, textStatus) {
				layer.close(loadi);
			},
			error : function(request) {
				alert("数据库连接超时或发生错误，请联系管理员!");
			},
			success : func
		});
	} else {
		$.ajax({
			cache : true,
			type : type,
			url : url,
			async : true,
			dataType : "json",
			beforeSend : function(XMLHttpRequest) {
				loadi = layer.load('数据处理中…');
			},
			complete : function(XMLHttpRequest, textStatus) {
				layer.close(loadi);
			},
			error : function(request) {
				alert("数据库连接超时或发生错误，请联系管理员!");
			},
			success : func
		});
	}
};
/**
 * 解析json数据，返回数组
 * @param data
 * @returns {Array}
 */

function parseJsonData(data)
{
	var items=new Array();
	if(data!=undefined)
		{
		$.each(data,function(index,item)
				{
			 items.push(item);
				});
		}
	
	return items;
}


var oLanguage = {
	"sProcessing" : "正在加载数据...",
	"sLengthMenu" : "显示_MENU_条 ",
	"sZeroRecords" : "没有您要搜索的内容",
	"sInfo" : "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
	"sInfoEmpty" : "记录数为0",
	"sInfoFiltered" : "(全部记录数 _MAX_  条)",
	"sInfoPostFix" : "",
	"sSearch" : "搜索",
	"sUrl" : "",
	"oPaginate" : {
		"sFirst" : "第一页",
		"sPrevious" : " 上一页 ",
		"sNext" : " 下一页 ",
		"sLast" : " 最后一页 "
	}
}

function createDataTables(tableId, sAjaxSource, columns, retrieveData){
	$("#goodsTable").dataTable({
		"oLanguage" : oLanguage,
		"bJQueryUI": true,
		"bPaginate" : true,// 分页按钮
		"bFilter" : false,// 搜索栏
		"bLengthChange" : false,// 每行显示记录数
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
        "aoColumns": [columns],
        "fnServerData" : retrieveData
	});
}