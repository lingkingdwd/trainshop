var orderTable;
var orderDatas=new Array();
$(document).ready(function() {
	pageInit();
	
	$('#orderTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	orderTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
	$('#orderTable a.btn-info').on( 'click', function () {
		var orderId=$(this).attr("orderId");
		initModal(orderId);
    } );
       
});

function initModal(orderId)
{
	var rowData;
	$.each(orderDatas,function(index,item)
			{
		       if(item.orderId==orderId)
		    	   rowData=item;
			});
	
    $("#OrdersName").val(rowData.OrdersName);
	$("#categoryId").val(rowData.catId);
	$("#category").val(rowData.catName);
	$("#OrdersSn").val(rowData.OrdersSn);
	$("#shopPrice").val(rowData.shopPrice);
	$("#marketPrice").val(rowData.marketPrice);
	$("#promotePrice").val(rowData.promotePrice);
	$("#OrdersBrief").val(rowData.OrdersBrief);
	$("#OrdersDesc").val(rowData.OrdersDesc);
	$("#integral").val(rowData.integral);
	$("input[name='isBest']:checked").val(rowData.isBest);
	$("input[name='isNew']:checked").val(rowData.isNew);
	$("input[name='isHot']:checked").val(rowData.isHot);
	$("input[name='isPromote']:checked").val(rowData.isPromote);
	$("#giveIntegral").val(rowData.giveIntegral);
	$("#sellerNote").val(rowData.sellerNote);
	
	$('#OrdersThumb').fileinput('clear');
	$('#OrdersImg').fileinput('clear');
	$('#originalImg').fileinput('clear');

}
function pageInit()
{
	$.ajax({
		async: false,
		type: "GET",
		url: basePath + "order/getOrderlist",
		dataType: "json",
		success: function(resp) {	
			orderDatas=resp.data;
			orderTable =$("#orderTable").DataTable({
			    data:orderDatas,
			    columns: [
			              { data: 'orderSn' },
			              { data: 'addTime' },
			              { data: 'trainNumber' },
			              { data: 'carriage' },
			              { data: 'seatNumber' },
			              { data: 'OrdersAmount' },
			              { data: 'orderAmount' },
			              { data: 'orderStatus' },
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
	                      columnDefs: [
//	                          {
//	                        	  targets: 1,
//	                              render: function (data, type, row) {
//	                            	 var html='<td>'+row.orderId+'</td>';
//	                                 return html;
//	                              }
//	                          },
//	                          {
//	                        	  targets: 2,
//	                              render: function (data, type, row) {
//	                            	 var html='<td><a class ="view-class" orderId="' + row.orderId + '">'+row.OrdersName+'</a></td>';
//	                                 return html;
//	                              }
//	                          },
	                          {
	                        	  targets: 8,
	                              render: function (data, type, row) {
	                            	 var html='<td><button type="button" class="btn btn-info" name="showBtn" orderId="' + row.orderId + '" href="javascript:;">订单明细</button></td>';
	                                 return html;
	                              }
	                          }
	                      ]
			});
		},
		error: function() {
			alert("页面加载失败！");
		}
	});
	}

