
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="modal fade" id="modalOrder" data-backdrop="static">
	<div class="modal-dialog modal-hg">
		<div class="modal-content border-none">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3 class="modal-title">订单详情</h3>
			</div>
			<div class="modal-body">
				<div class="col-md-12 marbot10">

					<form id="addHouseTypeForm" name="addHouseTypeForm"
						class="form-horizontal" method="POST" role="form"
						enctype="multipart/form-data">
						<h5 class="innerAll border-bottom  marbot10 text-primary">
							<span class="fa fa-user text-primary"></span> <strong>订单信息</strong>
						</h5>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>订单序号：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_orderId"
										name="i_orderId" readonly="readonly">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>订单编号：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_orderSn"
										name="i_orderSn">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>下单时间：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_time"
										name="i_time">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">车次：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_train"
										name="i_train">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><span
									class="text-danger">*</span>车厢：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_carriage"
										name="i_carriage">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">座位：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_seat"
										name="i_seat">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">订单总额：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="i_gAmount"
										name="i_gAmount" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">应付总额：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="" id="i_oAmount"
										name="i_oAmount" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label">订单状态：</label>
								<div class="col-sm-8">
									<select class="form-control" id="s_status" name="s_status">
										<option value="0">未确认</option>
										<option value="1">已确认</option>
										<option value="2">已取消</option>
										<option value="3">无效</option>
										<option value="4">退货</option>
										<option value="5">已分单</option>
									</select>
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
			<div class="modal-footer" style="clear: both;">
				<button type="button" class="btn btn-primary" id="btn_save">
					<i class="fa fa-check-circle"></i> 保存
				</button>
				<a href="#" class="btn btn-default" data-dismiss="modal"><i
					class="fa fa-times"></i> 取消</a>
			</div>
		</div>
	</div>
</div>
