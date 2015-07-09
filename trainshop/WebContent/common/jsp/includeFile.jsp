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
	var basePath = '<%=basePath %>';
</script>
<link rel="stylesheet" href="<%=basePath %>common/js/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath %>common/js/metisMenu/dist/metisMenu.min.css" />
<link rel="stylesheet" href="<%=basePath %>common/js/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=basePath %>common/css/timeline.css" />
<link rel="stylesheet" href="<%=basePath %>common/css/sb-admin-2.css" />
<link rel="stylesheet" href="<%=basePath %>common/js/morrisjs/morris.css" />

<script type="text/javascript" src="<%=basePath %>common/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/metisMenu/dist/metisMenu.min.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/raphael/raphael-min.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/morrisjs/morris.min.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/sb-admin-2.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/layer/layer.js"></script>