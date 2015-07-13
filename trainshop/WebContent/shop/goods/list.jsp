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
					<li class="active">分类管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">分类管理</div>
						<div class="panel-body">
							<div class="row">
								<div class=" col-md-3" id="left">
									<!--此处放树结构-->
									<ul id="categoryTreeId" class="ztree"></ul>
								</div>
								<div class="col-md-9" id="right">
									<div class="relativeWrap">
										<div class="box-generic">
											<div class="tabsbar2">
												<ul>
													<li class="glyphicons camera active"><a href="#"
														data-toggle="tab"><span
															class="glyphicon glyphicon-th-list"></span> 分类信息 </a></li>
												</ul>
											</div>
											<div class="col-md-12">
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label">父级分类：</label>
														<div class="col-sm-8 martop7">
															<span>xxx</span>
														</div>
													</div>
												</div>
												<div class="col-md-6">
												</div>
											</div>
											<div class="col-md-12">
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label">分类名称：</label>
														<div class="col-sm-8 martop7">
															<input type="text" class="form-control" id="categoryName">
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label"> 是否显示：</label>
														<div class="col-sm-8">
															<select class=" form-control" id="selectSPZT">
							
															</select>
														</div>
													</div>
												</div>
											</div>
											<div id="garage-show">
												<div class="row marbot10">
													<div class="col-md-10 padding-left-none">
														<button class="btn btn-success" style="display: none"
															id="cancel-select">
															<span class="fa fa-minus-square"></span> 取消全选
														</button>
														<button type="button" class="btn btn-danger"
															id="garage-delete">
															<i class="fa fa-times"></i> 删除
														</button>
														<button class="btn btn-success" id="cancel-delete">
															<span class="fa fa-minus-square"></span> 取消删除
														</button>
														<button type="button" class="btn btn-primary"
															id="save-garage">
															<i class="fa fa-check-circle"></i> 保存
														</button>
													</div>
												</div>
											</div>
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
</body>
<script type="text/javascript" src="<%=basePath%>/shop/category/list.js"></script>
</html>
