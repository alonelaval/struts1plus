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
  	<h3>列表</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}</span>	
  	<hr/>
		<vaildators:validators>
				<vaildators:validator value="${users}" 
						validateClassName="com.alonelaval.struts1plus.validator.validate.NotNullValidate" errorPath="/error.jsp"  />
		</vaildators:validators>
	 <table cellpadding="0" cellspacing="0" border="0">
	 		<thead>
	 				<tr>
	 				<td width="150" style="padding-left:10px">编号</td>
                    <td width="150" style="padding-left:10px">姓名</td>
                    <td width="285">证件号码</td>
                    <td width="275">电子邮箱</td>
                    <td width="">手机号码</td>
                    <td>操作</td>
                    </tr>
	 		</thead>
            <tbody>
            	<c:forEach items="${users}" var="user">
	                <tr>
	                	<td width="150" style="padding-left:10px">${user.personId}</td>
	                    <td width="150" style="padding-left:10px">${user.personName }</td>
	                    <td width="285">${user.personIdCard }</td>
	                    <td width="275">${user.personEmail }</td>
	                    <td width="275">${user.personMobile}</td>
	                    <td width="275"><a href="${basePath}/user!toAdd.do">增加</a>
	                    				<a href="${basePath}/user!delete.do?person.personId=${user.personId}">删除</a>
	                    				<a href="${basePath}/user!toUpdate.do?person.personId=${user.personId}">更新</a>
	                  	</td>
	                </tr>
                </c:forEach>
			</tbody>
	 </table>
	 <%@ include file="footer.jsp" %>
  </body>
</html>
