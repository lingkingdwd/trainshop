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
					<li><a class="amenu">系统管理</a>
					</li>
					<li class="active">商品关联管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">商品关联管理</div>
						<div class="panel-body">
							<div class="row">
								<div class=" col-md-3" id="left">
									<!--此处放树结构-->
									<ul id="orgTreeId" class="ztree"></ul>
								</div>
								<div class="col-md-9" id="right">
									<div class="col-12 dataTable_wrapper">
										<table id="trainTable"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="text-center">列车车次</th>
													<th class="text-center">始发站</th>
													<th class="text-center">终到站</th>
													<th class="text-center">开车时间</th>
													<th class="text-center">到站时间</th>
													<th class="text-center">操作</th>
												</tr>
											</thead>
											<tbody></tbody>
										</table>
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

	<div class="modal fade" id="newTrainWin" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content border-none">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">添加商品到列车</h3>
				</div>
				<div class="modal-body">
					<table id="goodsTable"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>商品ID</th>
												<th>商品编号</th>
												<th>商品名称</th>
												<th>库存数量</th>
												<th>市场售价</th>
												<th>本店售价</th>
												<th>商品介绍</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
					<input type="hidden" id="orgId" name="orgId" value="">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" onclick="save();">
						<i class="fa fa-check-circle"></i> 保存
					</button>
					<a href="#" class="btn btn-default" data-dismiss="modal"><i
						class="fa fa-times"></i>&nbsp;关闭</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>/shop/train/trainManage.js"></script>
</html>
