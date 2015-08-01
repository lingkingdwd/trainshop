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
					<li><a href="<%=basePath%>/">首页</a>
					</li>
					<li><a class="amenu">订单管理</a>
					</li>
					<li class="active">发货列表</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12 ">
					<table id="orderTable" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center" style="width: 15%;">订单号</th>
								<th class="text-center" style="width: 15%;">商品名称</th>
								<th class="text-center" style="width: 15%;">发货时间</th>
								<th class="text-center" style="width: 10%;">发货状态</th>
								<th class="text-center" style="width: 10%;">发货人</th>
								<th class="text-center" style="width: 10%;">操作</th>

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
	src="<%=basePath%>shop/order/ship_list.js"></script>
</html>
