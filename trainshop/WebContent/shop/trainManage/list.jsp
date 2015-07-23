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
					<li class="active">列车商品管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">列车商品管理</div>
						<div class="panel-body">
							<div class="row">
								<div class=" col-md-2" id="left">
									<!--此处放树结构-->
									<ul id="orgTreeId" class="ztree"></ul>
								</div>
								<div class="col-md-10" id="right">
									<div class="col-12 dataTable_wrapper">
										<table id="trainTable"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<!-- <th class="text-center" style="width: 10%;">编号</th> -->
													<th class="text-center" style="width: 18%;">列车车次</th>
													<th class="text-center" style="width: 15%;">始发站</th>
													<th class="text-center" style="width: 15%;">终到站</th>
													<th class="text-center" style="width: 15%;">开车时间</th>
													<th class="text-center" style="width: 15%;">到站时间</th>
													<th class="text-center" style="width: 22%;">操作</th>
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
<%@include file="modalGoodAdd.jsp" %>
<%@include file="modalGoodList.jsp" %>
</body>
<script type="text/javascript" src="<%=basePath%>shop/trainManage/list.js"></script>
</html>
