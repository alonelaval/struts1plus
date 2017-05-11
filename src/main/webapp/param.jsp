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
		<vaildators:validators>
				<vaildators:validator value="<%=request.getParameter(\"testParam\")%>"
						validateClassName="com.alonelaval.struts1plus.validator.validate.NotNullValidate" errorPath="/error.jsp"  />
		</vaildators:validators>
	<h3>测试验证url参数</h3>
	<span style="color: red;font: bold;">${errorInfo}${message}</span>
	<hr/>
	测试验证url参数
	<%@ include file="footer.jsp" %>
  </body>
</html>
