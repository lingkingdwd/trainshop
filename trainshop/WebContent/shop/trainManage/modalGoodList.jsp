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
	              								<th>列车ID</th>
												<th>商品ID</th>
												<th>商品号码</th>
												<th >名称</th>
												<!-- <th >市场价</th> -->
												<th >售价</th>
												<th >促销价格</th>
												<th >促销开始时间</th>
												<th >促销结束时间</th>
												<th >备注说明</th>
												<th class="text-center" style="width: 5%;">操作</th>
												
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
