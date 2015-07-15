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

function createDataTables(tableId, sAjaxSource, columns, fnServerData){
	$("#" + tableId).dataTable({
		"oLanguage" : oLanguage,
		//"bJQueryUI": true,
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
	    "sAjaxSource": sAjaxSource, /*'/getInfo.action', */
	    "aoColumns": columns,/*[{ "mData": "id", 'sClass':'left'},
        	{ "mData": "name", 'sClass':'center'}, 
        	{ "mData": "account",'sClass':'left'},
        	{ "mData": "logintime", 'sClass':'left'}
            	
            	{ "mData": "pass<a href="http://www.it165.net/edu/ebg/" target="_blank" class="keylink">word</a>",'sClass':'left',"mRender":function(data,type,full){
            		return "<button type='button' onclick=fuck11("+data+")>"+data+"</button>"
            		}
            	}
            	
		],*/
        "fnServerData" : fnServerData/*function(sSource, aoData, fnCallback) {
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
		}*/
	});
}