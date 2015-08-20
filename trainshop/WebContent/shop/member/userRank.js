var userRankTable;
var userRankData = new Array;

$(document).ready(function() {
	var userRankManage = new UserRankManage();
	userRankManage.createUserRankTable();
	
	$("#createBtn").on("click", userRankManage.addUserRank);
	$("#searchBtn").on("click", userRankManage.queryUserRank);
	
	$("#saveBtn").on("click",{queryUserRank:userRankManage.queryUserRank}, userRankManage.saveUserRank);
	
	$('body').on('click', 'button[name="editBtn"]', userRankManage.update);
	$('body').on('click', 'button[name="deleteBtn"]', {queryUserRank:userRankManage.queryUserRank}, userRankManage.deleteUserRank);
});

function UserRankManage(){
	this.queryUserRank = function(){
		userRankTable.clear().draw();
		
		var obj = new Object();
		obj.rankName = $("#searchRankName").val();
		
		var param = {data:JSON.stringify(obj)};
	
		callAjax(basePath + "userRank/getList", 'POST',  param, function(resp){
			userRankData = resp.DATA;
			$.each(userRankData,function(index,item){
				userRankTable.row.add(item).draw();
			});
		});
	}
	
	this.createUserRankTable = function (){
		$.ajax({
			async: false,
			type: "POST",
			url: basePath + "userRank/getList",
			dataType: "json",
			data:{rankId:0},
			success: function(resp) {	
				userRankData = resp.DATA;
				userRankTable = $("#userRankTable").DataTable({
					data:userRankData,
					columns :[{ data: "rankId"},
				        { data: "rankName" },
				        { data: "minPoints" },
				        { data: "maxPoints" },
				        { data: "discount" },
				        { data: "showPrice" },
				        { data: "specialRank"},
				        {data : ""}
					],
			        columnDefs:[{
                    	targets:[7],
                    	render:function(data,type,row) {
                    		 var html='<button type="button" name="editBtn" rankId="' + row.rankId + '" class="btn btn-stroke btn-xs btn-success marright5 "' +
								'title="编辑">' +
								'<i class="fa fa-pencil"></i></button>' + 
								'<button type="button" name="deleteBtn" rankId="' + row.rankId + '" class="btn btn-stroke btn-xs btn-danger marright5 ' +
								'title="删除">' +
								'<i class="fa fa-times"></i></button>';
								
                             return html;
                    	}
                    },
                    {
		                targets: [0],
		                visible: false,
		                searchable: false
		            }],
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
       		   		}
				});
			},
			error: function() {
				alert("页面加载失败！");
			}
		});
	}
	
	this.saveUserRank = function(event){
		var rankId = $("#rankId").val();
		
		var obj = new Object();
		
		if($("#rankName").val() == ""){
			layer.alert("会员等级名称不能为空!");
			return;
		}
		if($("#minPoints").val() == ""){
			layer.alert("积分下限不能为空!");
			return;
		}
		if($("#maxPoints").val() == ""){
			layer.alert("积分上限不能为空!");
			return;
		}
		if($("#discount").val() == ""){
			layer.alert("初始折扣率不能为空!");
			return;
		}
		if ("checked" == $("#showPrice").attr("checked")) {
			obj.showPrice = 1;
		}
		else{
			obj.showPrice = 0;
		}
		if ("checked" == $("#specialRank").attr("checked")) {
			obj.specialRank = 1;
		}
		else{
			obj.specialRank = 0;
		}
		
		obj.rankName = $("#rankName").val();
		obj.minPoints = $("#minPoints").val();
		obj.maxPoints = $("#maxPoints").val();
		obj.discount = $("#discount").val();
		
		var param = {data:JSON.stringify(obj)};
	
		callAjax(basePath + "userRank/saveOrUpdate",'POST', param, function(data){
			if (data.flag == "1") {
				layer.alert("会员等级创建成功!");
				
				if(event != undefined){
					var queryUserRank = event.data.queryUserRank;
					queryUserRank();
					
					$("#userRankWin").modal("hide");
				}
			}
			else{
				layer.alert("会员等级创建失败!");
			}
		});
	};
	
	this.update = function(){
		var rankId = $(this).attr("rankId");
		for(var i = 0; i < userRankData.length; i++){
			if(rankId == userRankData[i].rankId){
				$("#rankId").val(userRankData[i].rankId);
				$("#rankName").val(userRankData[i].rankName);
				$("#minPoints").val(userRankData[i].minPoints);
				$("#maxPoints").val(userRankData[i].maxPoints);
				$("#discount").val(userRankData[i].discount);
				
				$("#showPrice").val(userRankData[i].showPrice);
				$("#specialRank").val(userRankData[i].specialRank);
				
				$("#userRankWin").modal("show");
			}
		}
	};
	
	this.deleteUserRank = function(event){
		var rankId = $(this).attr("rankId");
		if(rankId == "" || rankId == null){
			layer.alert("列车号为空！");
			return;
		}
		
		var param = {
			data:rankId
		};
		
		callAjax(basePath + "userRank/delete", 'POST', param, function(data){
			if(data.flag == "1"){
				layer.alert("删除成功！");
				
				if(event != undefined){
					var queryUserRank = event.data.queryUserRank;
					queryUserRank();
				}
			}
			else{
				layer.alert(data.msg);
			}
		});
	};
	
	this.addUserRank = function(){
		$("#rankId").val("");
		
		$("#rankName").val("");
		$("#minPoints").val("");
		$("#maxPoints").val("");
		$("#discount").val("");
		
		$("#showPrice").val("");
		$("#specialRank").val("");
		
		$("#userRankWin").modal("show");
	};
}