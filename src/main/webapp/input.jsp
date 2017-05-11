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
	<c:if test="${isUpdate}">
		<vaildators:validators>
				<vaildators:validator value="${person.personId}" 
						validateClassName="com.alonelaval.struts1plus.validator.validate.NotNullValidate" errorPath="/error.jsp"  />
		</vaildators:validators>
	</c:if>
	<h3>添加或者更新</h3>
	<span style="color: red;font: bold;">${errorInfo}${message}</span>
	<hr/>
	<c:if test="${isUpdate}">
		<form action="${basePath}/user!update.do" method="post">
	</c:if>
	<c:if test="${!isUpdate}">
		<form action="${basePath}/user!add.do" method="post">
	</c:if>
		<table>
			<tr>
				<td>编号：</td>
				<td><input type="text" name="person.personId" <c:if test="${isUpdate}"> readonly="readonly"</c:if> value="${person.personId}"</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="person.personName" value="${person.personName}"/></td>
			</tr>
			<tr>
				<td>证件号码：</td>
				<td><input type="text" name="person.personIdCard" value="${person.personIdCard }"/></td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" name="person.personMobile" value="${person.personMobile }"/></td>
			</tr>
			<tr>
				<td>电子邮箱：</td>
				<td><input type="text" name="person.personEmail" value="${person.personEmail }"/></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>	
	<%@ include file="footer.jsp" %>
  </body>
  
</html>
