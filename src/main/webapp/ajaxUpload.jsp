<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="vaildators" uri="/WEB-INF/vaildators.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>
    <%@ include file="header.jsp" %>
    	<script type="text/javascript" src="${basePath}/js/ajaxfileupload.js"></script>
		<link href="<%=basePath %>/css/ajaxfileupload.css" type="text/css" rel="stylesheet" />
  </head>
  <body>
  	<h3>ajax上传文件</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}</span>
	<hr>  	
	<img id="loading" src="<%=basePath %>/images/loading.gif" style="display:none;">
	<form method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>编号：</td>
				<td><input type="text" name="intTest" id="intTest" value="${intTest} "</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="testText" id="testText" value="${testText}"/></td>
			</tr>
			<tr>
				<td>身份证复印件：</td>
				<td><input type="file" name="fileToUpload" id="fileToUpload" value="${fileToUpload}"/>${fileToUpload.name}</td>
			</tr>
			<tr>
				<td>最近的相片：</td>
				<td><input type="file" name="fileToUpload2" id="fileToUpload2" value="${fileToUpload2}"/>${fileToUpload2.name}</td>
			</tr>
			<tr>
				<td colspan="1"><input type="button" value="提交" onclick="ajaxFileUploadTest()"></td>
			</tr>
		</table>
	</form>	
	<%@ include file="footer.jsp" %>
	<script type="text/javascript">
	function ajaxFileUploadTest(){
		$("#loading")
		.ajaxStart(function(){
			$(this).show();
		})
		.ajaxComplete(function(){
			$(this).hide();
		});
		var intTest = $('#intTest').val();
		var testText = $('#testText').val();
		$.ajaxFileUpload
		(
			{
				url:'${basePath}/ajax.do?intTest2=111',
				secureuri:false,
				fileElementIds:['fileToUpload','fileToUpload2'],
				dataType: 'json',
				data:{intTest:intTest, testText:testText},
				success: function (data, status)
				{
				    alert(data.statusMessage);
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		)
		return false;
	}
	</script>
  </body>
</html>
