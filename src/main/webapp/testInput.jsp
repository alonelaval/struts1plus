<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.trustutn.org/vaildators" prefix="vaildators"%>
<%
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
           // pageContext.setAttribute("path", path);
          //  pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'MyTestJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<vaildators:validators>
			<vaildators:validator value="${basePath}" validateClassName="validator.NotNullValidate" errorPath="/test.do" redirect="true"/>
		</vaildators:validators>
		<form action="${path}/test!addUser.do" method="get">
			<input name="intTest" value="111" /><br/>
			<input name="dateTest" value="2015-12-15 11:11:00" /><br/>
			<input name="stringTest" value="111" /><br/>
			<input name="booleanTest" value="111" /><br/>
			<input name="floatTest" value="111" /><br/>
			<input name="byteTest" value="111" /><br/>
			<input name="doubleTest" value="111" /><br/>
			<input name="shortTest" value="111" /><br/>
			<input name="longTest" value="111" /><br/>
			<input name="charTest" value="111" /><br/>
			<input name="testBean.intTest" value="111" /><br/>
			<input name="testPublic" value="111" /><br/>
			<input name="testProtected" value="111" /><br/>
			<input name="bigDecimal" value="111" /><br/>
			<input name="websiteId" value="111" /><br/>
			<input name="test" type="submit">
		</form>
		
		<form action="${path}/testAjax!getJson.do" method="post">
			<input type="hidden" name="datas" value="[{'destIp':'测试0','deviceId':'测试0'},{'destIp':'测试1','deviceId':'测试1'},{'destIp':'测试2','deviceId':'测试2'},{'destIp':'测试3','deviceId':'测试3'},{'destIp':'测试4','deviceId':'测试4'},{'destIp':'测试5','deviceId':'测试5'},{'destIp':'测试6','deviceId':'测试6'},{'destIp':'测试7','deviceId':'测试7'},{'destIp':'测试8','deviceId':'测试8'},{'destIp':'测试9','deviceId':'测试9'}]" /><br/>
			<input name="testJSon" type="submit">
		</form>
	</body>
</html>
