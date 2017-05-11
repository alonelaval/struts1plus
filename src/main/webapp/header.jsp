<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String basePath = request.getContextPath(); 
pageContext.setAttribute("basePath",basePath);
%>
    <base href="${basePath }">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.1.min.js"></script>
	
  
