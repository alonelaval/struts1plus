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
  <h3>用json数据请求后端</h3>
  <span style="color: red;font: bold;">${errorInfo}${message}</span>
  <hr/>
	JSON数据为：
	<textarea  disabled="disabled" style="width: 100%;height: 180px;">
		参数：
		testText:'testText';
		datas:[
				{'destIp':'测试0','deviceId':'测试0'},{'destIp':'测试1','deviceId':'测试1'},
			  	{'destIp':'测试2','deviceId':'测试2'},{'destIp':'测试3','deviceId':'测试3'},
			 	{'destIp':'测试4','deviceId':'测试4'},{'destIp':'测试5','deviceId':'测试5'},
			  	{'destIp':'测试6','deviceId':'测试6'},{'destIp':'测试7','deviceId':'测试7'},
			  	{'destIp':'测试8','deviceId':'测试8'},{'destIp':'测试9','deviceId':'测试9'}
			  ];
		intTest:123
	
	</textarea>
	<br>
	<input type="button" value="提交" onclick="ajaxJson()">
	<%@ include file="footer.jsp" %>
	<script type="text/javascript">
	function ajaxJson(){
			
				var testText='testText';
				var datas =[
							{'destIp':'测试0','deviceId':'测试0'},{'destIp':'测试1','deviceId':'测试1'},
					  		{'destIp':'测试2','deviceId':'测试2'},{'destIp':'测试3','deviceId':'测试3'},
					 		{'destIp':'测试4','deviceId':'测试4'},{'destIp':'测试5','deviceId':'测试5'},
					  		{'destIp':'测试6','deviceId':'测试6'},{'destIp':'测试7','deviceId':'测试7'},
					  		{'destIp':'测试8','deviceId':'测试8'},{'destIp':'测试9','deviceId':'测试9'}
					 	];
				var intTest = 123;
			$.ajax({
			         cache: "false",
			         type: "post",
			         url: '${basePath}/json.do',
			         dataType:'json',
			         data: {testText:testText,datas:JSON.stringify(datas),intTest:intTest},
			         success: function(data)
			         {
			         	alert(typeof data)
				 	    alert(data.statusMessage);
			         },
			         error: function(msg)
			         {
						alert("操作失败！");
				    }
				});
	}
	</script>
  </body>
</html>
