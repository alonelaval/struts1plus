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
  	<h3>文件上传--没有添加文件验证器</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}</span>	
  	<hr/>
	<form action="${basePath}/upload.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>编号：</td>
				<td><input type="text" name="intTest" value="${intTest} "</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="testText" value="${testText}"/></td>
			</tr>
			<tr>
				<td>身份证复印件：</td>
				<td><input type="file" name="formFile" value="${formFile}"/>${formFile.name }</td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>	
	<%@ include file="footer.jsp" %>
  </body>
</html>
