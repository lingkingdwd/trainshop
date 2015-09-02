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
														<select class="form-control" id="userRankSelect" name="user_rank">
															<option value="0">所用等级</option>
															<option value="1">注销用户</option>
															<option value="3">代销用户</option>
															<option value="2">vip</option>
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
														<input id="userName" type="text" class="form-control" name="user_name">
													</div>
												</div>
											</div>
											<div class="col-md-8 text-right">
												<button type="button" class="btn btn-primary" id="searchBtn">
													<i class="fa fa-search"></i> 搜索
												</button>
												<button type="button" class="btn btn-success">
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
							<td class="col-md-3 text-right">会员名称：</td>
							<td><input type="hidden" id="userId" /> <input type="text"
								id="userName" class="form-control" /><span
								class="require-field">*</span></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">邮件地址：</td>
							<td><input type="text" id="email" class="form-control" /><span
								class="require-field">*</span></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">登录密码：</td>
							<td><input type="text" id="password" class="form-control" /><span
								class="require-field">*</span></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">确认密码：</td>
							<td><input type="text" id="confirmPassword"
								class="form-control" /><span class="require-field">*</span></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">手机：</td>
							<td><input class="inputBg" type="text" value="" size="40"
								id="mobilePhone"><span class="require-field">*</span></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">会员等级：</td>
							<td><select class="form-control" id="userRankSelect">
							</select></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">性别：</td>
							<td><input type="radio" checked="" value="0" name="sex">保密
								<input type="radio" value="1" name="sex">男 <input
								type="radio" value="2" name="sex">女</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">出生日期：</td>
							<td><select name="birthdayYear">
									<option value="1955">1955</option>
									<option value="1956">1956</option>
									<option value="1957">1957</option>
									<option value="1958">1958</option>
									<option value="1959">1959</option>
									<option value="1960">1960</option>
									<option value="1961">1961</option>
									<option value="1962">1962</option>
									<option value="1963">1963</option>
									<option value="1964">1964</option>
									<option value="1965">1965</option>
									<option value="1966">1966</option>
									<option value="1967">1967</option>
									<option value="1968">1968</option>
									<option value="1969">1969</option>
									<option value="1970">1970</option>
									<option value="1971">1971</option>
									<option value="1972">1972</option>
									<option value="1973">1973</option>
									<option value="1974">1974</option>
									<option value="1975">1975</option>
									<option value="1976">1976</option>
									<option value="1977">1977</option>
									<option value="1978">1978</option>
									<option value="1979">1979</option>
									<option value="1980">1980</option>
									<option value="1981">1981</option>
									<option value="1982">1982</option>
									<option value="1983">1983</option>
									<option value="1984">1984</option>
									<option value="1985">1985</option>
									<option value="1986">1986</option>
									<option value="1987">1987</option>
									<option value="1988">1988</option>
									<option value="1989">1989</option>
									<option value="1990">1990</option>
									<option value="1991">1991</option>
									<option value="1992">1992</option>
									<option value="1993">1993</option>
									<option value="1994">1994</option>
									<option value="1995">1995</option>
									<option value="1996">1996</option>
									<option value="1997">1997</option>
									<option value="1998">1998</option>
									<option value="1999">1999</option>
									<option value="2000">2000</option>
									<option value="2001">2001</option>
									<option value="2002">2002</option>
									<option value="2003">2003</option>
									<option value="2004">2004</option>
									<option value="2005">2005</option>
									<option value="2006">2006</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
							</select> <select name="birthdayMonth">
									<option value="1">01</option>
									<option value="2">02</option>
									<option value="3">03</option>
									<option value="4">04</option>
									<option value="5">05</option>
									<option value="6">06</option>
									<option value="7">07</option>
									<option value="8">08</option>
									<option value="9">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select> <select name="birthdayDay">
									<option value="1">01</option>
									<option value="2">02</option>
									<option value="3">03</option>
									<option value="4">04</option>
									<option value="5">05</option>
									<option value="6">06</option>
									<option value="7">07</option>
									<option value="8">08</option>
									<option value="9">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
							</select></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">信用额度:</td>
							<td><input id="credit_line" type="text" size="10" value="0"
								id="creditLine"></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">MSN：</td>
							<td><input class="inputBg" type="text" value="" size="40"
								id="msn"></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">QQ：</td>
							<td><input class="inputBg" type="text" value="" size="40"
								id="qq"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button id="saveBtn" type="submit" class="btn btn-primary">
						<i class="fa fa-check-circle"></i> 保存
					</button>
					<a href="#" class="btn btn-default" data-dismiss="modal"><i
						class="fa fa-times"></i>&nbsp;关闭</a>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript" src="<%=basePath%>shop/member/list.js"></script>
</html>
