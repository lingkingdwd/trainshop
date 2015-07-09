<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/common/jsp/includeFile.jsp" %>
<title>管理员系统登录</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">请登录</h3>
					</div>
					<div class="panel-body">
						<form role="form">
							<fieldset>
								<div class="form-group">
									<input id="userName" class="form-control" placeholder="用户名" name="userName"
										type="email" autofocus>
								</div>
								<div class="form-group">
									<input id="password" class="form-control" placeholder="密码"
										name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">记住登录
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<a id="btn-login" class="btn btn-lg btn-success btn-block">登录</a>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath %>shop/login.js"></script>
</body>
</html>
