<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="vaildators" uri="/WEB-INF/vaildators.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>
    <%@ include file="header.jsp" %>
    <style type="">
    	.errorClass{
    		border-color:  red;
    	}
    
    </style>
  </head>
  <body>
  	<h3>多选项</h3>
  	<span style="color: red;font: bold;">${errorInfo}${message}</span>
	<hr>  	
	<form method="post" action="${basePath}/multiChoice.do"  name="form" id="form">
		<table>
			<tr>
				<td>编号：</td>
				
				<td><input type="text" name="intTest" id="intTest" value="${intTest}" validate='nu11|1|20|false' nullMsg="输入项不能为空!" formatMsg="格式错误！"/></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="testText" id="testText" value="${testText}"/></td>
			</tr>
			<tr>
				<td>喜欢的水果：</td>
				<td>
							<label><input name="favouriteFruits" type="checkbox" value="苹果" />苹果 </label> 
							<label><input name="favouriteFruits" type="checkbox" value="桃子" />桃子 </label> 
							<label><input name="favouriteFruits" type="checkbox" value="香蕉" />香蕉 </label> 
							<label><input name="favouriteFruits" type="checkbox" value="梨" />梨 </label> 
				</td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
							<label><input name="hobbys" type="checkbox" value="1" />读书 </label> 
							<label><input name="hobbys" type="checkbox" value="2" />跑步</label> 
							<label><input name="hobbys" type="checkbox" value="3" />游泳</label> 
							<label><input name="hobbys" type="checkbox" value="4" />音乐</label> 
							<label><input name="hobbys" type="checkbox" value="5" />电影</label> 
				</td>
			</tr>
			<tr>
				<td>喜欢的电影：</td>
				<td>
							<label><input name="movies" type="checkbox" value="1" />电影1</label> 
							<label><input name="movies" type="checkbox" value="2" />电影2</label> 
							<label><input name="movies" type="checkbox" value="3" />电影3</label> 
							<label><input name="movies" type="checkbox" value="4" />电影4</label> 
							<label><input name="movies" type="checkbox" value="5" />电影5</label> 
				</td>
			</tr>
			<tr>
				<td>喜欢的电影：</td>
				<td>
						<select name="select">
							<option />电影1</option> 
							<option  value="2" />电影2</option> 
							<option value="3" />电影3</option> 
							<option value="4" />电影4</option> 
							<option value="5" />电影5</option> 
						</select>
				</td>
			</tr>
			<tr>
				<input type="button" name="ceshi" onclick="pinganValidate('form',2)" value="测试">
				<td colspan="1"><input type="submit" name="submit" value="提交"></td>
			</tr>
		</table>
		
	</form>	
	
	
	<%@ include file="footer.jsp" %>
  	
  </body>
</html>
