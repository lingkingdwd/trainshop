var usersTable;
var usersData = new Array;

$(document).ready(function() {
	var usersManage = new UsersManage();
	usersManage.createUsersTable();
	
	$("#createBtn").on("click", usersManage.addUsers);
	$("#searchBtn").on("click", usersManage.queryUsers);
	
	$("#saveBtn").on("click",{queryUsers:usersManage.queryUsers}, usersManage.saveUsers);
	
	$('body').on('click', 'button[name="editBtn"]', usersManage.update);
	$('body').on('click', 'button[name="deleteBtn"]', {queryUsers:usersManage.queryUsers}, usersManage.deleteUsers);
});

function UsersManage(){
	this.querysRank = function(){
		usersTable.clear().draw();
		
		var obj = new Object();
		obj.userName = $("#searchUsersName").val();
		
		var param = {data:JSON.stringify(obj)};
	
		callAjax(basePath + "users/getUserslist", 'POST',  param, function(resp){
			usersData = resp.DATA;
			$.each(usersData,function(index,item){
				usersTable.row.add(item).draw();
			});
		});
	}
	
	this.createUsersTable = function (){
		var obj = new Object();
		obj.userName = $("#searchUsersName").val();
		
		var param = {data:JSON.stringify(obj)};
	
		callAjax(basePath + "users/getUserslist", 'POST',  param, function(resp){
			usersData = resp.DATA;
			usersTable = $("#usersTable").DataTable({
				data:usersData,
				columns :[{ data: "userId"},
			        { data: "userName" },
			        { data: "email" },
			        { data: "isValidated" },
			        { data: "userMoney" },
			        { data: "frozenMoney" },
			        { data: "rankPoints"},
			        { data: "payPoints"},
			        { data: "regTime"},
			        {data : ""}
				],
		        columnDefs:[{
                	targets:[8],
                	render:function(data,type,row) {
                		 var strData=new Date(Number(data));
							
                         return dateTimeFormat(strData);
                	}
                },{
                	targets:[9],
                	render:function(data,type,row) {
                		 var html='<button type="button" name="editBtn" userId="' + row.userId + '" class="btn btn-stroke btn-xs btn-success marright5 "' +
							'title="编辑">' +
							'<i class="fa fa-pencil"></i></button>' + 
							'<button type="button" name="deleteBtn" userId="' + row.userId + '" class="btn btn-stroke btn-xs btn-danger marright5 ' +
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
		});
	}
	
	this.saveUsers = function(event){
		var userId = $("#userId").val();
		
		var obj = new Object();
		
		if($("#userName").val() == ""){
			layer.alert("用户名称不能为空!");
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
	
		callAjax(basePath + "users/saveOrUpdate",'POST', param, function(data){
			if (data.flag == "1") {
				layer.alert("会员创建成功!");
				
				if(event != undefined){
					var queryUsers = event.data.queryUsers;
					queryUsers();
					
					$("#usersWin").modal("hide");
				}
			}
			else{
				layer.alert("会员创建失败!");
			}
		});
	};
	
	this.update = function(){
		var userId = $(this).attr("userId");
		for(var i = 0; i < usersData.length; i++){
			if(userId == usersData[i].userId){
				$("#userId").val(usersData[i].userId);
				$("#rankName").val(usersData[i].rankName);
				$("#minPoints").val(usersData[i].minPoints);
				$("#maxPoints").val(usersData[i].maxPoints);
				$("#discount").val(usersData[i].discount);
				
				$("#showPrice").val(usersData[i].showPrice);
				$("#specialRank").val(usersData[i].specialRank);
				
				$("#usersWin").modal("show");
			}
		}
	};
	
	this.deleteUsers = function(event){
		var userId = $(this).attr("userId");
		if(userId == "" || userId == null){
			layer.alert("用户号为空！");
			return;
		}
		
		var param = {
			data:userId
		};
		
		callAjax(basePath + "users/delete", 'POST', param, function(data){
			if(data.flag == "1"){
				layer.alert("删除成功！");
				
				if(event != undefined){
					var queryUsers = event.data.queryUsers;
					queryUsers();
				}
			}
			else{
				layer.alert(data.msg);
			}
		});
	};
	
	this.addUsers = function(){
		$("#rankId").val("");
		
		$("#rankName").val("");
		$("#minPoints").val("");
		$("#maxPoints").val("");
		$("#discount").val("");
		
		$("#showPrice").val("");
		$("#specialRank").val("");
		
		$("#usersWin").modal("show");
	};
}