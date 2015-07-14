function callAjax(url, type, param,func) {
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
	"sLengthMenu": "每页显示 _MENU_条",  
	"sZeroRecords": "没有找到符合条件的数据",  
	"sProcessing": "&lt;img src=’./loading.gif’ /&gt;",  
	"sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",  
	"sInfoEmpty": "没有记录",  
	"sInfoFiltered": "(从 _MAX_ 条记录中过滤)",  
	"sSearch": "搜索：",  
	"oPaginate": {  
		"sFirst": "首页",  
		"sPrevious": "前一页",  
		"sNext": "后一页",  
		"sLast": "尾页"  
	}
}