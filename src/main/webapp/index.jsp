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
  	<h3>示列</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}</span>
  	<hr/>
	<ul>
		<li><a href="${basePath}/index!toList.do">列表查询，增删改查</a></li>
		<li><a href="${basePath}/index!toDownload.do">文件下载</a></li>	
		<li><a href="${basePath}/index!toAjaxJson.do">ajaxJson数据请求</a></li>
		<li><a href="${basePath}/index!toAjaxTest.do?testText=111">ajaxBusiness非指定的AJAX方法</a></li>
		<li><a href="${basePath}/index!toAjaxUpload.do">ajax上传文件</a></li>
		<li><a href="${basePath}/index!toUpload.do">文件上传</a></li>
		<li><a href="${basePath}/index!toToken.do">防止表单重复提交</a></li>
		<li><a href="${basePath}/index!toMultiChoice.do">多选表单</a></li>
		<li><a href="${basePath}/example/param.jsp?testParam=test">验证url参数</a></li>
		<li><a href="${basePath}/page.do">分页</a></li>
		<%-- <li><a href="${basePath}/index!toRestful.do">restful</a></li>--%>
		<li><a href="${basePath}/index!toRedirect.do">redirect传参数</a></li>
		<li><a href="${basePath}/index!toRedirectURL.do">redirect重写URL</a></li>
		<li><a href="${basePath}/index!toUrlOverrideURL.do">foward重写URL</a></li>
	</ul>
	<hr/>
  </body>
</html>
