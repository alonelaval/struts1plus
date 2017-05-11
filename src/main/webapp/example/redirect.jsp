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
  	<h3>restful示列</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}${param}</span>
  	<hr/>
	<ul>
		<form id="form" action="${basePath}/a.action" method="post">
			<input id="_method" name="_method" value="put" type="hidden">
			<input type="button" value="put" onclick="doSubmit('put')">
			<input type="button" value="delete" onclick="doSubmit('delete')">
			<input type="button" value="post" onclick="doSubmit('post')">
			<input type="button" value="TRACE" onclick="doSubmit('TRACE')">
			<input type="button" value="Options" onclick="doSubmit('Options')">
			<input type="button" value="head" onclick="doSubmit('head')">
			<input type="button" value="get" onclick="doSubmit('get')">
		</form>
	</ul>
	<hr/>
	<%@ include file="footer.jsp" %>
	<script type="text/javascript"> 
			function doSubmit(method){
				$('#_method').val(method);	
				$('#form').submit();
			}
	</script>
  </body>
</html>

