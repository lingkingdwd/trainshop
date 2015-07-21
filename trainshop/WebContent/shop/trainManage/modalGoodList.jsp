	<%@ page language="java" pageEncoding="UTF-8"%>
	<div  class="modal fade" id="modalGoodList">
		<div class="modal-dialog" style="width:1000px;">
			<div class="modal-content border-none">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">xxx列车已上车商品</h3>
				</div>
				<div class="modal-body">
					<div class="col-md-12 marbot10">
						
					<form id="addHouseTypeForm" name="addHouseTypeForm"
						class="form-horizontal" method="POST" role="form"
						enctype="multipart/form-data">
						<h5 class="innerAll border-bottom  marbot10 text-primary">
							<span class="fa fa-user text-primary"></span> <strong>商品清单</strong>
						</h5>
						<div class="col-md-12">
						<table id="goodsTable2"
										class="table table-bordered table-hover">
										<thead>
											<tr>
												<th >商品ID</th>
												<th>编号</th>
												<th >名称</th>
												<th >商品分类</th>
												<th >市场价</th>
												<th >售价</th>
												<th >促销价格</th>
												<th >简短描述</th>
												<th >详细描述</th>
												<th >可用积分数量</th>
												<th >是否是精品</th>
												<th >是否是新品</th>
												<th >是否热销</th>
												<th >是否特价</th>
												<th >赠送积分数量</th>
												<th >商家备注</th>
												<th >操作</th>
												
											</tr>
										</thead>
										<tbody></tbody>
									</table>
						</div>
					</form>
					</div>
				</div>
				<div class="modal-footer" style="clear: both;">
				</div>
			</div>
		</div>
	</div>
