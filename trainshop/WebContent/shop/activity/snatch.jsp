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
					<li><a class="amenu">促销管理</a></li>
					<li class="active">夺宝奇兵</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">夺宝奇兵</div>
						<div class="panel-body">
							<div class="row marbot10 border-bottom ">
								<form class="form-horizontal" role="form">
									<div class="col-md-12">
										<div class="innerAll  margin-bottom-none padding-top-none">
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5">活动名称：</label>
													<div class="col-md-7">
														<input type="text" class="form-control" value="2015">
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5">版本类型：</label>
													<div class="col-md-7">
														<select class="form-control">
															<option>普通版</option>
															<option>奋斗版</option>
														</select>
													</div>
												</div>
											</div>
											<div class="col-md-4 text-right">
												<button type="button" class="btn btn-primary">
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
							<div class="row">
								<div class="col-md-12 overflow-x">
									<table id="goodsActivityTable" class="table table-bordered table-primary table-center">
										<thead>
											<tr>
												<th class="text-center">编号</th>
												<th class="text-center">活动名称</th>
												<th class="text-center">商品名称</th>
												<th class="text-center">活动开始时间</th>
												<th class="text-center">活动结束时间</th>
												<th class="text-center">价格下限</th>
												<th class="text-center">消耗积分</th>
												<th class="text-center">操作</th>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
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

	<div class="modal fade" id="newTrainWin" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content border-none">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">添加列车</h3>
				</div>
				<div class="modal-body">
					<table class="table table-primary table-vertical-center">
						<tr>
							<td class="col-md-3 text-right">列车车次：</td>
							<td><input type="hidden" id="trainId" /> <input
								type="hidden" id="orgId" /> <input type="text" id="trainNumber"
								class="form-control" /></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">始发站：</td>
							<td><input type="text" id="startStation"
								class="form-control" /></td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">终到站：</td>
							<td><input type="text" id="endStation" class="form-control" />
							</td>
						</tr>
						<tr>
							<td class="col-md-3 text-right">始发时间：</td>
							<td><div class="form-group margin-none innerB">
									<div class="col-md-5 padding-none">
										<div class="input-group"
											onclick="WdatePicker({dateFmt:'HH:mm', el:'startTime'})">
											<input type="text" id="startTime" value="2014-01-01" /> <span
												class="input-group-addon"><i class="fa fa-calendar"></i>
											</span>
										</div>
									</div>
								</div></td>
						</tr>
						<tr>
							<td class="col-md-2 text-right">终到站时间：</td>
							<td colspan="3"><div class="form-group margin-none innerB">
									<div class="col-md-5 padding-none">
										<div class="input-group"
											onclick="WdatePicker({dateFmt:'HH:mm', el:'endTime'})">
											<input type="text" id="endTime" value="2014-01-01" /> <span
												class="input-group-addon"><i class="fa fa-calendar"></i>
											</span>
										</div>
									</div>
								</div></td>
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
<script type="text/javascript"
	src="<%=basePath%>shop/activity/snatch.js"></script>
</html>
