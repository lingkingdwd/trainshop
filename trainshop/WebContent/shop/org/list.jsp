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
					<li class="active">组织机构管理</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="panel panel-default">
						<div class="panel-heading">组织机构管理</div>
						<div class="panel-body">
							<div class="row">
								<div class=" col-md-3" id="left">
									<!--此处放树结构-->
									<ul id="orgTreeId" class="ztree"></ul>
								</div>
								<div class="col-md-9" id="right">
									<div class="relativeWrap">
										<div class="box-generic">
											<div class="tabsbar2">
												<ul>
													<li class="glyphicons camera active"><a href="#"
														data-toggle="tab"><span
															class="glyphicon glyphicon-th-list"></span> 组织机构 </a></li>
												</ul>
											</div>
											<div class="col-md-12">
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label">父级机构：</label>
														<div class="col-sm-">
															<span id="parOrgName"></span>
															<input type="hidden" id="parOrgId">
														</div>
													</div>
												</div>
												<div class="col-md-6">
												</div>
											</div>
											<div class="col-md-12">
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label martop10">机构名称：</label>
														<div class="col-sm-8 martop7">
															<input type="hidden" id="orgId">
															<input type="text" class="form-control" id="orgName">
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label martop10"> 是否启用：</label>
														<div class="col-sm-8 martop7">
															<select class=" form-control" id="status">
																<option value ="1">是</option>
																<option value ="0">否</option>
															</select>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="col-md-6">
													<div class="form-group">
														<label class="col-sm-4 control-label martop10">机构代码：</label>
														<div class="col-sm-8 martop7">
															<input type="hidden" id="orgId">
															<input type="text" class="form-control" id="orgcode">
														</div>
													</div>
												</div>
												<div class="col-md-6">
													
												</div>
											</div>
											<div class="col-md-12">
												<label></label>
											</div>
											<div id="garage-show">
												<div class="row martop7">
													<div class="col-md-10 padding-left-none text-center">
														<button type="button" class="btn btn-success" id="addOrg">
															<span class="fa fa-plus"></span> 添加机构
														</button>
														<button type="button" id="saveOrg" type="button" class="btn btn-primary"
															id="save-garage">
															<i class="fa fa-save"></i> 保存修改
														</button>
														<button type="button" id="deleteOrg" type="button" class="btn btn-danger"
															id="deleteOrg">
															<i class="fa fa-times"></i> 删除机构
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
<script type="text/javascript" src="<%=basePath%>/shop/org/list.js"></script>
</html>
