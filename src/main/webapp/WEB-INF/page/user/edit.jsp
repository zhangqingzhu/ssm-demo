<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
  	<base href="<%=basePath%>">
    <title>更新用户</title> 
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	 function updateUser(id){
	    		var name = $('input[name=name]').val();
	    		var pwd = $('input[name=pwd]').val();
	    		var age = $('input[name=age]').val();
	    		var phone = $('input[name=phone]').val();
	     $.ajax({
	        type: "PUT",
	        url: '<%=basePath%>user/'+id,
	        data:{
	        	'id':id,
				'name':name,
				'pwd':pwd,
				'age':age,
				'phone':phone
			},
	        dataType: "text",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	        success: function (data) {
		    	   if(data=="success"){
		    		   alert("更新成功");
		    		   location.reload();
		    	   }
		        }
	    });
}
</script> 
  </head>  
  <body>  
    <h1>更新用户</h1>  
    <form>
         <input type="hidden" name="id" value="${user.id }"/> 
		        姓名：<input type="text" name="name" value="${user.name }"/>  
		        密码：<input type="text" name="pwd" value="${user.pwd }"/>  
		        年龄：<input type="text" name="age" value="${user.age }"/>  
		        手机号：<input type="text" name="phone" value="${user.phone }"/> 
        <input type="button" value="更新" onclick="updateUser(${user.id });"/>
        <input type="button" value="返回用户列表" onclick="window.location.href='<%=basePath%>user'" />
    </form>  
  </body>  
</html>