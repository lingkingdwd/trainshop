<%@ page language="java" pageEncoding="UTF-8"%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html">TrainShop后台管理</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-tasks">
				<li><a href="#">
						<div>
							<p>
								<strong>任务1</strong> <span class="pull-right text-muted">40%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%">
									<span class="sr-only">40% Complete (success)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 2</strong> <span class="pull-right text-muted">20%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									style="width: 20%">
									<span class="sr-only">20% Complete</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 3</strong> <span class="pull-right text-muted">60%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (warning)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 4</strong> <span class="pull-right text-muted">80%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: 80%">
									<span class="sr-only">80% Complete (danger)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a class="text-center" href="#"> <strong>See
							All Tasks</strong> <i class="fa fa-angle-right"></i>
				</a></li>
			</ul> <!-- /.dropdown-tasks --></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-alerts">
				<li><a href="#">
						<div>
							<i class="fa fa-comment fa-fw"></i> New Comment <span
								class="pull-right text-muted small">4 minutes ago</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
								class="pull-right text-muted small">12 minutes ago</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-envelope fa-fw"></i> Message Sent <span
								class="pull-right text-muted small">4 minutes ago</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-tasks fa-fw"></i> New Task <span
								class="pull-right text-muted small">4 minutes ago</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
								class="pull-right text-muted small">4 minutes ago</span>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a class="text-center" href="#"> <strong>See
							All Alerts</strong> <i class="fa fa-angle-right"></i>
				</a></li>
			</ul> <!-- /.dropdown-alerts --></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#"><i class="fa fa-user fa-fw"></i> User
						Profile</a></li>
				<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a></li>
				<li class="divider"></li>
				<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
						Logout</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<!-- <li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="搜索...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>64
								</span>
							</div> /input-group
						</li> -->
				<li><a href="<%=basePath%>indexController/index"><i
						class="fa fa-dashboard fa-fw"></i> 首页</a>
				</li>
				<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
						商品管理<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=basePath%>goods/publish">发布商品</a></li>
						<li><a href="<%=basePath%>goods/init">商品管理</a></li>
						<li><a href="<%=basePath%>category/init">分类管理</a></li>
						<li><a href="#">用户评论</a></li>
						<li><a href="#">商品品牌</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-train fa-fw"></i> 列车管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=basePath%>train/init">列车管理</a></li>
						<li><a href="<%=basePath%>trainGoods/init">列车商品管理</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i> 订单管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=basePath%>order/orderInit">订单列表</a></li>
						<li><a href="<%=basePath%>order/shipInit">发货单列表</a></li>
						<li><a href="<%=basePath%>order/backInit">退货单列表</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-sitemap fa-fw"></i> 促销管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=basePath %>goodsActivity/snatch">夺宝奇兵</a></li>
						<li><a href="#">红包类型</a></li>
						<li><a href="#">祝福贺卡</a></li>
						<li><a href="#">团购活动</a></li>
						<li><a href="#">专题管理</a></li>
						<li><a href="#">拍卖活动</a></li>
						<li><a href="#">优惠活动</a></li>
						<li><a href="#">批发管理</a></li>
						<li><a href="#">超值礼包</a></li>
						<li><a href="#">积分商城商品</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i> 用户管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=basePath %>org/init">组织机构管理</a></li>
						<!-- <li><a href="#">用户管理</a></li>
						<li><a href="#">角色管理</a></li>
						<li><a href="#">权限分配</a></li>
						<li><a href="#">菜单管理</a></li> -->
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i> 会员管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="<%=basePath %>users/list">会员列表</a></li>
						<li><a href="<%=basePath %>userRank/init">会员等级</a></li>
						<li><a href="<%=basePath %>users/list">会员留言</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i> 系统设置<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">支付方式</a></li>
						<li><a href="#">计划任务</a></li>
						<li><a href="#">计划任务</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i> 报表统计<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">流量分析</a></li>
						<li><a href="#">客户统计</a></li>
						<li><a href="#">订单统计</a></li>
						<li><a href="#">销售概况</a></li>
						<li><a href="#">会员排行</a></li>
						<li><a href="#">销售明细</a></li>
						<li><a href="#">销售排行</a></li>
						<li><a href="#">访问购买率</a></li>
					</ul>
				</li>
				<!-- <li><a href="#"><i class="fa fa-sitemap fa-fw"></i> 系统管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#">系统配置</a></li>
						<li><a href="#">日志配置</a></li>
						<li><a href="#">Third Level <span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a href="#">Third Level Item</a></li>
								<li><a href="#">Third Level Item</a></li>
								<li><a href="#">Third Level Item</a></li>
								<li><a href="#">Third Level Item</a></li>
							</ul> /.nav-third-level</li>
					</ul> /.nav-second-level</li> -->
				<!-- <li><a href="#"><i class="fa fa-files-o fa-fw"></i> 报表管理<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="blank.html">浏览管理</a></li>
					</ul> /.nav-second-level</li> -->
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
