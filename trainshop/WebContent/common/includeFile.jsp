<%@ page language="java" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = path + "/";
	/* String  USERID = "";
	if(request.getSession().getAttribute("USERID") != null){
		USERID = request.getSession().getAttribute("USERID").toString();
	}
	if(USERID.equals("")){
		response.sendRedirect(basePath + "login");
	} */
%>

<script type="text/javascript">
	var pathNoSlash = '<%=path %>';
	var basePath = '<%=basePath %>';
</script>
<link rel="stylesheet" href="<%=basePath %>js/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath %>js/metisMenu/dist/metisMenu.min.css" />
<link rel="stylesheet" href="<%=basePath %>js/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" />
<link rel="stylesheet" href="<%=basePath %>js/datatables-responsive/css/dataTables.responsive.css" />
<link rel="stylesheet" href="<%=basePath %>css/timeline.css" />
<link rel="stylesheet" href="<%=basePath %>js/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=basePath %>css/sb-admin-2.css" />
<link rel="stylesheet" href="<%=basePath %>js/morrisjs/morris.css" />
<link rel="stylesheet" href="<%=basePath %>js/zTree/css/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath %>css/common.css" />

<script type="text/javascript" src="<%=basePath %>js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/metisMenu/dist/metisMenu.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/raphael/raphael-min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/morrisjs/morris.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/sb-admin-2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath %>js/common.js"></script>
<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js"></script>

<script src="<%=basePath %>js/zTree/jquery.ztree.core-3.5.js"></script>
<script src="<%=basePath %>js/zTree/jquery.ztree.excheck-3.5.js"></script>