var usersTable;
var usersData = new Array;

$(document).ready(function() {
	var usersManage = new UsersManage();
	usersManage.createUsersTable();

	$("#searchBtn").on("click", usersManage.queryUsers);
	
	$("#createBtn").on("click", usersManage.addUsers);
	$("#saveBtn").on("click", {
		queryUsers : usersManage.queryUsers
	}, usersManage.saveUsers);

	$('body').on('click', 'button[name="editBtn"]', usersManage.update);
	$('body').on('click', 'button[name="deleteBtn"]', {
		queryUsers : usersManage.queryUsers
	}, usersManage.deleteUsers);
	
	//显示会员等级数据
	var obj = new Object();
	var param = {
		data : JSON.stringify(obj)
	};
	callAjax(basePath + "userRank/getList", 'POST', param, function(data) {
	    $.each(data.DATA,function(i,val){
	        $("#userRankSelect").append("<option value='"+val.rankId+"'>"+val.rankName+"</option>")
	        $("#userRankSelect1").append("<option value='"+val.rankId+"'>"+val.rankName+"</option>")
	    })
	});
});

function UsersManage() {
	this.queryUsers = function() {
		usersTable.clear().draw();

		var obj = new Object();
		obj.userName = $("#userName").val();
		pay_points_lt = $("#pay_points_lt").val();
		pay_points_gt = $("#pay_points_gt").val();
		obj.userRank = $("#userRankSelect").val();

		callAjax(basePath + "users/getUserslist", 'POST', {
			"data" : JSON.stringify(obj),
			"pay_points_gt" : pay_points_gt,
			"pay_points_lt" : pay_points_lt
		}, function(resp) {
			usersData = resp.DATA;
			$.each(usersData, function(index, item) {
				usersTable.row.add(item).draw();
			});
		});
	}

	this.createUsersTable = function() {
		var obj = new Object();
		var param = {
			data : JSON.stringify(obj)
		};

		callAjax(
				basePath + "users/getUserslist",
				'POST',
				param,
				function(resp) {
					usersData = resp.DATA;
					usersTable = $("#usersTable")
							.DataTable(
									{
										data : usersData,
										columns : [ {
											data : "userId"
										}, {
											data : "userName"
										}, {
											data : "email"
										}, {
											data : "isValidated"
										}, {
											data : "userMoney"
										}, {
											data : "frozenMoney"
										}, {
											data : "rankPoints"
										}, {
											data : "payPoints"
										}, {
											data : "regTime"
										}, {
											data : ""
										} ],
										columnDefs : [
												{
													targets : [ 8 ],
													render : function(data,
															type, row) {
														var strData = new Date(
																Number(data));

														return dateTimeFormat(strData);
													}
												},
												{
													targets : [ 9 ],
													render : function(data,
															type, row) {
														var html = '<button type="button" name="editBtn" userId="'
																+ row.userId
																+ '" class="btn btn-stroke btn-xs btn-success marright5 "'
																+ 'title="编辑">'
																+ '<i class="fa fa-pencil"></i></button>'
																+ '<button type="button" name="deleteBtn" userId="'
																+ row.userId
																+ '" class="btn btn-stroke btn-xs btn-danger marright5 '
																+ 'title="删除">'
																+ '<i class="fa fa-times"></i></button>';

														return html;
													}
												}, {
													targets : [ 0 ],
													visible : false,
													searchable : false
												} ],
										"language" : {
											"sProcessing" : "处理中...",
											"sLengthMenu" : "显示 _MENU_ 项结果",
											"sZeroRecords" : "没有匹配结果",
											"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
											"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
											"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
											"sInfoPostFix" : "",
											"sSearch" : "搜索:",
											"sUrl" : "",
											"sEmptyTable" : "表中数据为空",
											"sLoadingRecords" : "载入中...",
											"sInfoThousands" : ",",
											"oPaginate" : {
												"sFirst" : "首页",
												"sPrevious" : "上页",
												"sNext" : "下页",
												"sLast" : "末页"
											},
											"oAria" : {
												"sSortAscending" : ": 以升序排列此列",
												"sSortDescending" : ": 以降序排列此列"
											}
										}
									});
				});
	}
	// 创建
	this.addUsers = function() {
		 $("#userName1").val("");
		 $("#email").val("");
		 $("#password").val("");
		 $("#confirmPassword").val("");
		 $("#mobilePhone").val("");
		 $("#userRankSelect1").val("");
		 $("input[name='sex']:checked").val("");
		 $("#birthday").val("");
		 $("#creditLine").val("");
		 $("#msn").val("");
		 $("#qq").val("");
		 $("#userId").val("");
		 $(".modal-title").html("添加会员");
		 $("#saveBtn").html("保存");
		 
		 $("#usersWin").modal("show");
	};
	// 保存
	this.saveUsers = function(event) {
		var obj = new Object();

		if ($("#userName1").val() == "") {
			layer.alert("用户名称不能为空!");
			return;
		}
		if ($("#email").val() == "") {
			layer.alert("邮件地址不能为空!");
			return;
		}
		if ($("#password").val() == "") {
			layer.alert("登录密码不能为空!");
			return;
		}
		if ($("#confirmPassword").val() == "") {
			layer.alert("确认密码不能为空!");
			return;
		}
		if ($("#mobilePhone").val() == "") {
			layer.alert("手机不能为空!");
			return;
		}
		obj.userId=$("#userId").val();
		obj.userName=$("#userName1").val();
		obj.email=$("#email").val();
		obj.password=$.trim($("#password").val());
		obj.mobilePhone=$("#mobilePhone").val();
		obj.userRank = $("#userRankSelect1").val();
		obj.sex = $("input[name='sex']:checked").val();
		obj.birthday=$("#birthday").val();
		obj.creditLine=$("#creditLine").val();
		obj.msn=$("#msn").val();
		obj.qq=$("#qq").val();
		var param = {
			data : JSON.stringify(obj),
			confirmPassword:$.trim($("#confirmPassword").val())
		};
		
		if(obj.password != $.trim($("#confirmPassword").val())){
			layer.alert("两次密码不一致!");
			return;
		}

		callAjax(basePath + "users/saveOrUpdate", 'POST', param,
				function(data) {
					if (data.flag == "1") {
						layer.alert(data.message);
						$("#usersWin").modal("hide");
						if (event != undefined) {
							var queryUsers = event.data.queryUsers;
							queryUsers();
						}
					} else {
						layer.alert(data.message);
					}
				});
	};

	this.update = function() {
		$(".modal-title").html("修改会员");
		$("#saveBtn").html("修改");
		var userId = $(this).attr("userId");
		for (var i = 0; i < usersData.length; i++) {
			if (userId == usersData[i].userId) {
				$("#userId").val(usersData[i].userId);
				$("#userName1").val(usersData[i].userName);
				$("#email").val(usersData[i].email);
				$("#password").val(usersData[i].password);
				$("#confirmPassword").val(usersData[i].confirmPassword);
				$("#mobilePhone").val(usersData[i].mobilePhone);
				$("#userRankSelect1").val(usersData[i].userRank);
				$("input[name='sex']:checked").val(usersData[i].sex);
				$("#birthday").val(usersData[i].birthday);
				$("#creditLine").val(usersData[i].creditLine);
				$("#msn").val(usersData[i].msn);
				$("#qq").val(usersData[i].qq);
				$("#userRankSelect1").find("option[value="+usersData[i].userRank+"]").attr("selected",true);

				$("#usersWin").modal("show");
			}
		}
	};

	//删除会员信息
	this.deleteUsers = function(event) {
		var userId = $(this).attr("userId");
		if (userId == "" || userId == null) {
			layer.alert("用户号为空！");
			return;
		}
		
		var obj=new Object();
		obj.userId = $(this).attr("userId");

		var param = {
			data : JSON.stringify(obj)
		};

		callAjax(basePath + "users/deleteUsers", 'POST', param, function(data) {
			if (data.flag == "1") {
				layer.alert("删除成功！");
				if (event != undefined) {
					var queryUsers = event.data.queryUsers;
					queryUsers();
				}
			} else {
				layer.alert(data.message);
			}
		});
	};

}
