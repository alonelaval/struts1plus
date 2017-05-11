<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="vaildators" uri="/WEB-INF/vaildators.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>
    <%@ include file="header.jsp" %>
  </head>
  <body>
  	<h3>文件下载</h3>
	<span style="color: red;font: bold;">${errorInfo}${message}</span>
	<hr/>
	<a href="${basePath}/download.do">点击下载文件</a>
	<%@ include file="footer.jsp" %>
  </body>
</html>
