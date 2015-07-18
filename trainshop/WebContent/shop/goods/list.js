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
});

function pageInit()
{
	$.ajax({
		async: false,
		type: "GET",
		url: basePath + "goods/getlist",
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
			                "lengthMenu": "_MENU_ 条记录每页",
			                "zeroRecords": "没有找到记录",
			                "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
			                "infoEmpty": "无记录",
			                "infoFiltered": "(从 _MAX_ 条记录过滤)",
			                "paginate": {
			                    "previous": "上一页",
			                    "next": "下一页"
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

