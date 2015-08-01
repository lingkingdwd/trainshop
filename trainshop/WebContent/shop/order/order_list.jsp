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
					<li><a class="amenu">订单管理</a></li>
					<li class="active">订单列表</li>
				</ol>
			</div>

			<div class="row martop10">
				<div class="col-12 ">
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-sm-4 control-label">列车：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="i_train"
									name="i_train">
							</div>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="col-sm-6 control-label">订单编号：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="i_order"
									name="i_order">
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-sm-6 control-label">订单状态：</label>
							<div class="col-sm-6">
								<select class="form-control" id="s_status"
									name="s_status">
									<option value="99">全部</option>
									<option value="0">未确认</option>
									<option value="1">已确认</option>
									<option value="2">已取消</option>
									<option value="3">无效</option>
									<option value="4">退货</option>
									<option value="5">已分单</option>
									</select>
							</div>
						</div>
					</div>
					<div class="col-md-1">
					<button type="button" class="btn btn-primary" id="btn_search">
									<i class="fa fa-check-circle"></i> 搜索
								</button>
					</div>
				</div>
			</div>

			<div class="row martop10">
				<div class="col-12 ">
					<table id="orderTable" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center" style="width: 10%;">订单号</th>
								<th class="text-center" style="width: 15%;">下单时间</th>
								<th class="text-center" style="width: 10%;">车次</th>
								<th class="text-center" style="width: 10%;">车厢</th>
								<th class="text-center" style="width: 10%;">座位</th>
								<th class="text-center" style="width: 10%;">订单总额</th>
								<th class="text-center" style="width: 10%;">应付总额</th>
								<th class="text-center" style="width: 10%;">订单状态</th>
								<th class="text-center" style="width: 15%;">操作</th>

							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<%@ include file="modalOrder.jsp"%>
</body>
<script type="text/javascript"
	src="<%=basePath%>shop/order/order_list.js"></script>
</html>
