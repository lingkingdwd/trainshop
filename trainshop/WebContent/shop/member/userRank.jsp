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
					<li class="active">会员等级管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">会员等级管理</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<div class="row marbot10 border-bottom ">
										<form class="form-horizontal" role="form">
											<div class="col-md-12">
												<div class="innerAll  margin-bottom-none padding-top-none">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label col-md-5">等级名称：</label>
															<div class="col-md-7">
																<input id="searchRankName" type="text" class="form-control">
															</div>
														</div>
													</div>
													<div class="col-md-8 text-right">
														<button id="searchBtn" type="button" class="btn btn-primary">
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
									<div class="row">
										<div class="col-md-12 overflow-x">
											<table id="userRankTable" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th class="text-center">会员等级ID</th>
														<th class="text-center">会员等级名称</th>
														<th class="text-center">积分下限</th>
														<th class="text-center">积分上限</th>
														<th class="text-center">初始折扣率(%)</th>
														<th class="text-center">特殊会员组</th>
														<th class="text-center">显示价格</th>
														<th class="text-center">操作</th>
													</tr>
												</thead>
												<tbody></tbody>
											</table>
										</div>
									</div>
								</div>
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

	<div class="modal fade" id="userRankWin" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content border-none">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">添加会员等级</h3>
				</div>
				<div class="modal-body">
					<table class="table table-primary table-vertical-center">
						<tr>
							<td class="col-md-3 text-right">会员等级名称：</td>
							<td><input type="hidden" id="rankId" /> <input type="text"
								id="rankName" class="form-control" /></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">积分下限：</td>
							<td><input type="text" id="minPoints" class="form-control" 
								onkeyup='this.value=this.value.replace(/[^0-9|.]/g,"")' onafterpaste='this.value=this.value.replace(/[/[^0-9|.]/g,"")'/></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">积分上限：</td>
							<td><input type="text" id="maxPoints" class="form-control" 
								onkeyup='this.value=this.value.replace(/[^0-9|.]/g,"")' onafterpaste='this.value=this.value.replace(/[/[^0-9|.]/g,"")'/></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right"></td>
							<td>
								<div class="col-md-12 text-left marbot10">
									<label class="checkbox-inline"> 
										<input type="checkbox" id="showPrice" value=""> 在商品详情页显示该会员等级的商品价格
									</label>
									<!-- <button type="button" class="btn btn-primary"><i class="fa fa-copy"></i> 复制上一版计划数据</button> -->
								</div>
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right"></td>
							<td>
								<div class="col-md-12 text-left marbot10">
									<label class="checkbox-inline"> 
										<input type="checkbox" id="specialRank" value=""> 特殊会员组
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<td class="col-md-2 text-right">初始折扣率：</td>
							<td><input type="text" id="discount" class="form-control" 
								onkeyup='this.value=this.value.replace(/[^0-9|.]/g,"")' onafterpaste='this.value=this.value.replace(/[/[^0-9|.]/g,"")'/>
							</td>
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
<script type="text/javascript" src="<%=basePath%>shop/member/userRank.js"></script>
</html>
