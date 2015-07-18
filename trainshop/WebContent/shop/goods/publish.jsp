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
									<input type="text" class="form-control" id="goodsName" name="goodsName">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>商品货号：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="goodsSn" name="goodsSn">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>商品分类：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="category" name="category">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">市场价：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="marketPrice" name="marketPrice">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>售价：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="shopPrice" name="shopPrice" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">促销价格：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="promotePrice" name="promotePrice" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">简短描述：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="goodsBrief" name="goodsBrief" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">详细描述：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="goodsDesc" name="goodsDesc" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">可用积分数量：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="integral" name="integral" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">是否是精品：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="isBest" name="isBest" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">是否是新品：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="isNew" name="isNew" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">是否热销：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="isHot" name="isHot" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">是否特价：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id=isPromote name="isPromote" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">赠送积分数量：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id=giveIntegral name="giveIntegral" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label
									class="col-md-1 control-label padding-left-none marleft45">商家备注：</label>
								<div class="col-sm-10 marright13">
									<textarea class="form-control" id="sellerNote" name="sellerNote"></textarea>
								</div>
							</div>
						</div>
						<br />
						<h5 class="innerAll border-bottom  marbot10 text-primary"
							style="clear: both">
							<span class="fa fa-user text-primary"></span> <strong>上传商品图片</strong>
						</h5>
						<!-- <div class="col-md-12">
							<label
								class="col-md-2 control-label padding-left-none marleft45">微缩图片：</label>
							<div class="col-sm-9 marright13">
								<input id="goodsThumb" name="goodsThumb" type="file" class="fileupload-new" />
							</div>
						</div>
						<div class="col-md-12">
							<label
								class="col-md-2 control-label padding-left-none marleft45">实际大小图片：</label>
							<div class="col-sm-9 marright13">
								<input id="goodsImg" name="goodsImg" type="file" class="fileupload-new" />
							</div>
						</div> -->
						<div class="col-md-12">
							<input id="originalImg" name="originalImg" type="file" class="fileupload-new" />
						</div>
						<div class="col-md-12">
							<div class="form-actions text-right">
								<button type="button" class="btn btn-primary" id="add-save">
									<i class="fa fa-check-circle"></i> 保存
								</button>
								<button type="button" class="btn btn-default" id="back">
									<i class="fa fa-arrow-left"></i> 返回
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="categoryModalId">
		<div class="modal-dialog">
			<div class="modal-content border-none">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">商品分类</h3>
				</div>
				<div class="modal-body">
					<div class="col-md-12 marbot10">
						<!-- 请放树结构 -->
						<ul id="categoryTreeId" class="ztree" style="margin-top: 0">
						</ul>
					</div>
				</div>
				<div class="modal-footer" style="clear: both;">
					<button id="selectCategoryBtnId" type="submit"
						class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
						<i class="fa fa-check-circle"></i> 确定
					</button>
					<a href="#" class="btn btn-default" data-dismiss="modal"><i
						class="fa fa-times"></i> 取消</a>
				</div>
			</div>
		</div>
	</div>
</body>
<link rel="stylesheet" href="<%=basePath%>js/bootstrap-fileinput/css/fileinput.css" />
<script src="<%=basePath%>js/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=basePath%>/shop/goods/publish.js"></script>
</html>
