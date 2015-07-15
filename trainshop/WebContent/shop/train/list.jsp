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
					<li class="active">列车管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">列车管理</div>
						<div class="panel-body">
							<div class="row">
								<div class=" col-md-3" id="left">
									<!--此处放树结构-->
									<ul id="orgTreeId" class="ztree"></ul>
								</div>
								<div class="col-md-9" id="right">
									<div class="col-12 dataTable_wrapper">
										<table id="example"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="text-center">列车车次</th>
													<th class="text-center">始发站</th>
													<th class="text-center">终到站</th>
													<th class="text-center">开车时间</th>
													<th class="text-center">到站时间</th>
												</tr>
											</thead>

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
</body>
<script type="text/javascript" src="<%=basePath%>/shop/train/list.js"></script>
</html>
