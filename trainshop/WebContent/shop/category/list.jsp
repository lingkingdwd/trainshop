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
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">分类管理</div>
						<div class="panel-body">
							<div class="row">
								<div class=" col-md-3" id="left">
								</div>
								<div class="col-md-9" id="right">
									<div class="relativeWrap">
										<div class="box-generic">
											<div class="tabsbar2">
												<ul>
													<li class="glyphicons camera active"><a href="#"
														data-toggle="tab"><span
															class="glyphicon glyphicon-th-list"></span> 车库基本信息 </a></li>
													<li class="pull-right"><span
														class="glyphicon glyphicon-resize-full resize-icon"
														id="maxSize"></span> <span
														class="glyphicon glyphicon-resize-small resize-icon"
														id="minSize"></span></li>
												</ul>
											</div>
											<form action="" id="ck-form"></form>
											<table class="table table-vertical-center">
												<tr>
													<td class="text-right border-none"><span
														class="text-danger">*</span>车库名称：</td>
													<td class="border-none"><input type="text"
														class="form-control" placeholder="" id='garage-name'></td>
													<td class="text-right border-none">车库总面积：</td>
													<td class="border-none"><input type="text"
														class="form-control" placeholder="" disabled
														id="garage-area"></td>
													<td class="text-right border-none">销售形式：</td>
													<td class="border-none"><input type="text"
														class="form-control" placeholder=" 按套销售" disabled
														id='sale-type'></td>
												</tr>
												<tr>
													<td class="text-right border-none">车库层数：</td>
													<td class="border-none"><input type="text"
														class="form-control" id="garage-floor"></td>
													<td class="text-right border-none"><span
														class="text-danger">*</span>车库总数：</td>
													<td class="border-none"><input type="text"
														class="form-control" id="garage-number"></td>
													<td class="text-right border-none">&nbsp;</td>
													<td class="border-none">&nbsp;</td>
												</tr>
											</table>
											<div class="form-actions text-right marbot10">
												<button type="button" class="btn btn-primary"
													id="create-garage">
													<i class="fa fa-check-circle"></i> 生成车库
												</button>

											</div>
											<div id="garage-show">
												<div class="row marbot10">
													<div class="col-md-4">
														<div class="form-group">
															<label
																class="col-sm-4 control-label margin-bottom-none padding-none martop7"><span
																class="text-danger"></span>车库户型：</label>
															<div class="col-sm-7 padding-left-none">
																<select class="form-control" id="hx-dict">
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-6 padding-left-none">
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
													<div class="col-md-2 martop7">
														<span><strong>显示：</strong> </span> <label
															class="checkbox-inline"> <input type="checkbox"
															id="inlineCheckbox4" value="option4"> 户型
														</label>
													</div>
												</div>
												<div class="row marbot10">
													<div id="jqxgrid"></div>
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
<script type="text/javascript" src="<%=basePath%>shop/login.js"></script>
<script type="text/javascript" src="<%=basePath%>/shop/category/list.js"></script>
</html>
