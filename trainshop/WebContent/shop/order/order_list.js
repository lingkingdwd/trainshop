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
	
	$('body').on('click', 'button[name="editBtn"]', function(){
		var orderId=$(this).attr("orderId");
		initModal(orderId);
		$("#btn_save").show();
		$("#modalOrder").modal("show");
	});
	
	$('body').on('click', 'button[name="showBtn"]', function(){
		var orderId=$(this).attr("orderId");
		initModal(orderId);
		$("#btn_save").hide();
		$("#modalOrder").modal("show");
	});
	$('#btn_search').on( 'click', function () {
		orderTable.clear().draw();
		var param={};
		if($("#i_train").val()!="")
		     param.trainNumber=$("#i_train").val();
		else
			param.trainNumber="";
		
		if($("#i_order").val()!="")
		     param.orderSn=$("#i_order").val();
		else
			param.orderSn="";
		
		if($("#s_status").val()!="")
			param.orderStatus=$("#s_status").val();
		
		console.log(JSON.stringify(param));
		
		$.ajax({
			async: false,
			type: "POST",
			url: basePath + "order/queryOrderlist",
			dataType: "json",
			data:{data:JSON.stringify(param)},
			success: function(resp) {	
				orderDatas=resp.data;
				$.each(orderDatas,function(index,item){
					orderTable.row.add(item).draw();
				});
			},
			error: function() {
				alert("数据加载失败！");
			}
		});
    } );
	
       
});

function initModal(orderId)
{
	$.each(orderDatas,function(index,item)
			{
		       if(item.orderId==orderId)
		    $("#i_orderId").val(item.orderId);
		   	$("#i_orderSn").val(item.orderSn);
		   	$("#i_time").val(item.addTime);
		   	$("#i_train").val(item.trainNumber);
		   	$("#i_carriage").val(item.carriage);
		   	$("#i_seat").val(item.seatNumber);
		   	$("#i_gAmount").val(item.goodsAmount);
		   	$("#i_oAmount").val(item.orderAmount);
		   	$("#s_status").val(item.orderStatus);
			});

}

function saveOrder()
{
	alert("保存成功!");
//	
//	    $("#i_orderId").val(item.orderId);
//	   	$("#i_orderSn").val(item.orderSn);
//	   	$("#i_time").val(item.addTime);
//	   	$("#i_train").val(item.trainNumber);
//	   	$("#i_carriage").val(item.carriage);
//	   	$("#i_seat").val(item.seatNumber);
//	   	$("#i_gAmount").val(item.goodsAmount);
//	   	$("#i_oAmount").val(item.orderAmount);
//	   	$("#s_status").val(item.orderStatus);
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
			              { data: 'goodsAmount' },
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
	                          {
	                        	  targets: 1,
	                              render: function (data, type, row) {
	                            	  var dat=new Date();
	                            	 return dat.getFullYear()+'-'+dat.getMonth()+'-'+dat.getDate()+" "+dat.getHours()+":"+dat.getMinutes()+":"+dat.getSeconds();
	                              }
	                          },
	                          {
	                        	  targets: 7,
	                              render: function (data, type, row) {
	                            	 var status="未确认";
	                            	 if(row.orderStatus==1)
	                            		 status="已确认";
	                            	 if(row.orderStatus==2)
	                            		 status="已取消";
	                            	 if(row.orderStatus==3)
	                            		 status="无效";
	                            	 if(row.orderStatus==4)
	                            		 status="退货";
	                            	 if(row.orderStatus==5)
	                            		 status="已分单";
	                            	 else
	                            		 status="未确认";
	                            	 return status;
	                              }
	                          },
	                          {
	                        	  targets: 8,
	                              render: function (data, type, row) {
	                            	 var html='<td><button type="button" class="btn btn-success" name="editBtn" orderId="' + row.orderId + '" href="javascript:;">编辑</button><button type="button" class="btn btn-info" name="showBtn" orderId="' + row.orderId + '" href="javascript:;">订单详情</button></td>';
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

