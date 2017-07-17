<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
  	<base href="<%=basePath%>">
    <title>添加用户</title>  
  </head>  
  </body>  
  <body>
  		<h1>添加信息</h1>
	   <form action="<%=basePath%>user" method="post">
		用户名:<input type="text" name="name"/><br>
		密&nbsp码:<input type="password" name="pwd"/><br>
		年&nbsp龄:<input type="text" name="age"/><br>
		手机号:<input type="text" name="phone"/><br>
		<input type="submit" value="添加"/>
		</form>
  </body>
</html>  