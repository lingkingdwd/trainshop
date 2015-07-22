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
					<li><a class="amenu">商品管理</a></li>
					<li class="active">商品管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">商品管理</div>
						<div class="panel-body">
							<div id="garage-show">
								<div class="row">
									<div class="col-md-10 padding-left-none text-left">
										<button type="button" class="btn btn-success" id="btn_addGood">
											<span class="fa fa-plus"></span> 添加商品
										</button>
									</div>
								</div>
							</div>
							<div class="row martop7">
								<div class="col-12 ">
									<table id="goodsTable"
										class="table table-bordered table-hover">
										<thead>
											<tr>
												<th >商品ID</th>
												<th class="text-center" style="width: 10%;">编号</th>
												<th class="text-center" style="width: 22%;">名称</th>
												<th class="text-center" style="width: 10%;">商品分类</th>
												<th class="text-center" style="width: 10%;">市场价</th>
												<th class="text-center" style="width: 8%;">售价</th>
												<th >促销价格</th>
												<th class="text-center" style="width: 28%;">简短描述</th>
												<th >详细描述</th>
												<th >可用积分数量</th>
												<th >是否是精品</th>
												<th >是否是新品</th>
												<th >是否热销</th>
												<th >是否特价</th>
												<th >赠送积分数量</th>
												<th >商家备注</th>
												<th class="text-center" style="width: 12%;">操作</th>
												
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
	<%@ include file="modalGood.jsp"%>
</body>
<script type="text/javascript" src="<%=basePath%>shop/goods/list.js"></script>
</html>
