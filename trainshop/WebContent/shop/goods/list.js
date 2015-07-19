 var goodsTable;
 
 var goodDatas=new Array();
var categoryDatas = new Array();
var brandDatas=new Array();
$(document).ready(function() {
	pageInit();
	
	$('#goodsTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	goodsTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
 
    
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
       
        $('#btn_addGood').on('click', function (e) {
        	location.href = basePath + "goods/publish";
        });
});

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
			              { data: 'goodsSn' },
			              { data: 'goodsName' },
			              { data: 'goodsNumber' },
			              { data: 'marketPrice' },
			              { data: 'shopPrice' },
			              { data: 'keywords' },
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
	                              targets: 0
	                          },
	                          {
	                        	  targets: 1,
	                              render: function (data, type, row) {
	                            	 var html='<td><a href="javascript:;">'+row.goodsSn+'</a></td>';
	                                 return html;
	                              }
	                          },
	                          {
	                        	  targets: 7,
	                              render: function (data, type, row) {
	                            	 var html='<td><a class="btn btn-danger" value="'+row.goodsId+'" href="javascript:;"><i class="glyphicon glyphicon-trash icon-white"></i>删除</a></td>';
	                                 return html;
	                              }
	                          }
	                      ]
			});
		},
		error: function() {
			showMessage("页面加载失败！");
		}
	});
	}

