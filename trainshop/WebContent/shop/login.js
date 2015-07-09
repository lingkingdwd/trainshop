function login() {
	var obj = new Object();
	obj.userName = $.trim($("#userName").val());
	obj.password = $.trim($("#password").val());
	var temp = JSON.stringify(obj);
	var param = {
		data:temp
	};
	
	$.ajax({
		type : 'POST',
		url : basePath + "adminUserController/loginAction",
		data : param, 
		async : false,
		dataType : "json",
		success : function(data) {
			if (data.flag == 1) {
				location.href = basePath + "indexController/index";
			} else {
				layer.alert("提示：" + data.message, 9);
			}
		},
		error : function(data) {
			layer.alert("数据请求失败",8);
		}
	});
}


$(document).ready(function() {
	/*$(".checkbox").click(function() {
		var checkboxClass = $(this).hasClass("checkbox-undo");
		switch (checkboxClass) {
		case true:
			$(this).removeClass("checkbox-undo").addClass("checkbox-do");
			break;
		case false:
			$(this).removeClass("checkbox-do").addClass("checkbox-undo");
			break;
		}
	});*/
	
	// 执行按钮操作
	$("#btn-login").click(function() {
		login();
	});
	
	//回车键进行查询
	$(document).keyup(function(event){
		if(event.keyCode ==13){
			$("#btn-login").trigger("click");
		}
	});
});