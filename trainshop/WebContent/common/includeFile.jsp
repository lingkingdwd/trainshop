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
<link rel="stylesheet" href="<%=basePath %>js/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath %>js/metisMenu/dist/metisMenu.min.css" />
<link rel="stylesheet" href="<%=basePath %>js/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=basePath %>css/timeline.css" />
<link rel="stylesheet" href="<%=basePath %>css/sb-admin-2.css" />
<link rel="stylesheet" href="<%=basePath %>js/morrisjs/morris.css" />

<script type="text/javascript" src="<%=basePath %>js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/metisMenu/dist/metisMenu.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/raphael/raphael-min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/morrisjs/morris.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/sb-admin-2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/layer/layer.js"></script>