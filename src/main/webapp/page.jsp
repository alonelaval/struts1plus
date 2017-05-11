<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="vaildators" uri="/WEB-INF/vaildators.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>
    <%@ include file="header.jsp" %>
  </head>
  <body>
  	<h3>带查询的分页排序列表</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}</span>	
  	<hr/>
  	 <form action="${basePath}/page.do" id="form" method="post">
  	 	<dir>
  	 		<table>
				<tr>
					<td>编号：</td>
					<td><input type="text" name="person.personId"  value="${person.personId}"</td>
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
					<td colspan="1"><input type="submit"></td>
				</tr>
			</table>
  	 	</dir>
		 <table cellpadding="0" cellspacing="0" border="0">
		 		<thead>
		 				<tr>
		 				<td width="150" style="padding-left:10px" orderBy = 'person.personId'>编号</td>
	                    <td width="150" style="padding-left:10px" orderBy ='person.personName'>姓名</td>
	                    <td width="285"  orderBy ='person.personIdCard'>证件号码</td>
	                    <td width="275">电子邮箱</td>
	                    <td width="">手机号码</td>
	                    </tr>
		 		</thead>
	            <tbody>
	            	<c:forEach items="${page.data}" var="user">
		                 <tr>
	                	<td width="150" style="padding-left:10px">${user.personId}</td>
	                    <td width="150" style="padding-left:10px">${user.personName }</td>
	                    <td width="285">${user.personIdCard }</td>
	                    <td width="275">${user.personEmail }</td>
	                    <td width="275">${user.personMobile}</td>
	                </tr>
	                </c:forEach>
				</tbody>
		 </table>
		 <div>
		 <tags:page form="form" pageNum="10"/>
		</div>			
	 </form>
	 <%@ include file="footer.jsp" %>
  </body>
</html>
