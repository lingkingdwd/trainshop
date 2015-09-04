<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/common/includeFile.jsp"%>
<title>后台管理</title>

</head>
<body>
	<div id="wrapper" class="page-wrap">
		<%@ include file="/common/nav.jsp"%>
		<div id="page-wrapper">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>/">首页</a></li>
					<li><a class="amenu">系统管理</a></li>
					<li class="active">会员管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">会员列表</div>
						<div class="panel-body">
							<div class="row marbot10 border-bottom ">
								<form class="form-horizontal" role="form">
									<div class="col-md-12">
										<div class="innerAll  margin-bottom-none padding-top-none">
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5">会员等级：</label>
													<div class="col-md-7">
														<select class="form-control" id="userRankSelect"
															name="user_rank">
															<option value="">请选择会员等级</option>
														</select>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5"> 会员积分大于：</label>
													<div class="col-md-7">
														<input id="pay_points_gt" type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5"> 会员积分小于：</label>
													<div class="col-md-7">
														<input id="pay_points_lt" type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5"> 会员名称：</label>
													<div class="col-md-7">
														<input id="userName" type="text" class="form-control"
															name="user_name">
													</div>
												</div>
											</div>
											<div class="col-md-8 text-right">
												<button type="button" class="btn btn-primary" id="searchBtn">
													<i class="fa fa-search"></i> 搜索
												</button>
												<button id="createBtn" type="button" class="btn btn-success">
													<i class="fa fa-plus"></i> 创建
												</button>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
								</form>
							</div>
							<div class="col-12 dataTable_wrapper">
								<table id="usersTable"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="text-center">编号</th>
											<th class="text-center">会员名称</th>
											<th class="text-center">邮件地址</th>
											<th class="text-center">是否已验证</th>
											<th class="text-center">可用资金</th>
											<th class="text-center">冻结资金</th>
											<th class="text-center">等级积分</th>
											<th class="text-center">消费积分</th>
											<th class="text-center">注册日期</th>
											<th class="text-center">操作</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<!-- 保存页面 -->
	<div class="modal fade" id="usersWin" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content border-none">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">添加会员</h3>
				</div>
				<div class="modal-body">
					<table class="table table-primary table-vertical-center">
						<tr>
							<td class="col-md-3 text-right"><font color="red">*</font>会员名称：</td>
							<td>
								<input type="hidden" id="userId" /> 
								<input type="text" id="userName1" class="form-control require-field" />
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right"><font color="red">*</font>邮件地址：</td>
							<td>
								<input type="text" id="email" class="form-control require-field" />
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right"><font color="red">*</font>登录密码：</td>
							<td>
								<input type="text" id="password" class="form-control require-field" />
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right"><font color="red">*</font>确认密码：</td>
							<td>
								<input type="text" id="confirmPassword" class="form-control require-field" />
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right"><font color="red">*</font>手机：</td>
							<td>
								<input class="form-control require-field" type="text" value="" size="40" id="mobilePhone">
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">会员等级：</td>
							<td>
								<select class="form-control" id="userRankSelect1">
								    <option value="">请选择会员等级</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">性别：</td>
							<td>
								<input type="radio" checked="" value="0" name="sex">保密
								<input type="radio" value="1" name="sex">男 
								<input type="radio" value="2" name="sex">女
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">出生日期：</td>
							<td>
								<input id="birthday" class="Wdate" onfocus="WdatePicker({readOnly:true,maxDate:'%y-%M-%d'})" />
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">信用额度:</td>
							<td>
								<input class="form-control" type="text" size="10" value="0" id="creditLine">
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">MSN：</td>
							<td>
								<input class="form-control" type="text" value="" size="40" id="msn">
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">QQ：</td>
							<td>
								<input class="form-control" type="text" value="" size="40" id="qq">
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button id="saveBtn" type="submit" class="btn btn-primary">
						<i class="fa fa-check-circle"></i> 保存
					</button>
					<a href="#" class="btn btn-default" data-dismiss="modal">
						<i class="fa fa-times"></i>&nbsp;关闭
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript" src="<%=basePath%>shop/member/list.js"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script> 
</html>
