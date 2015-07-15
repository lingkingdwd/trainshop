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
					<li class="active">商品发布</li>
				</ol>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<form id="addHouseTypeForm" name="addHouseTypeForm"
						class="form-horizontal" method="POST" role="form"
						enctype="multipart/form-data">
						<h5 class="innerAll border-bottom  marbot10 text-primary">
							<span class="fa fa-user text-primary"></span> <strong>基本信息</strong>
						</h5>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>商品名称：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="hxbmt" name="hxbmt">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>商品分类：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="hxbmt" name="hxbmt">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>建筑面积：</label>
								<div class="col-sm-8">
									<div class="input-group">
										<input type="text" class="form-control" value="" id="jzar"
											name="jzar" /> <strong class="input-group-addon">㎡</strong>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>套内面积：</label>
								<div class="col-sm-8">
									<div class="input-group" style="z-index: 0;">
										<input type="text" class="form-control" value="" id="tnar"
											name="tnar" /> <strong class="input-group-addon">㎡</strong>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">公摊面积：</label>
								<div class="col-sm-8">
									<div class="input-group">
										<input type="text" class="form-control" value="" id="gtar"
											name="gtar" readonly="readonly" /> <strong
											class="input-group-addon">㎡</strong>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label
									class="col-md-1 control-label padding-left-none marleft45">备注：</label>
								<div class="col-sm-10 marright13">
									<textarea class="form-control" id="bzxx" name="bzxx"></textarea>
								</div>
							</div>
						</div>
						<br />
						<h5 class="innerAll border-bottom  marbot10 text-primary"
							style="clear: both">
							<span class="fa fa-user text-primary"></span> <strong>上传户型图</strong>
						</h5>
						<div class="col-md-12">
							<!-- <div class="fileupload fileupload-new margin-none"
							data-provides="fileupload">
							<span class="btn btn-default btn-file"> 
                <span class="fileupload-new">上传户型图</span> 
              <span class="fileupload-exists">更换</span>
             	<input type="file" id="files" multiple class="margin-none"/>
             </span> <span class="fileupload-preview"></span> <a href="#" class="close fileupload-exists" data-dismiss="fileupload" >&times;</a> </div>
							
						</div> -->
							<input id="files" name="files" type="file" class="fileupload-new" />
							<div class="form-actions text-right">
								<button type="button" class="btn btn-primary" id="add-save">
									<i class="fa fa-check-circle"></i> 保存
								</button>
								<button type="button" class="btn btn-default" id="back">
									<i class="fa fa-arrow-left"></i> 返回
								</button>
							</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
<script type="text/javascript" src="<%=basePath%>/shop/goods/publish.js"></script>
</html>
