<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	 function delUser(id){
	     $.ajax({
	        type: "DELETE",
	        url: '<%=basePath%>user/'+id,
	        dataType: "text",
	       success: function (data) {
	    	   if(data=="suc"){
	    		   alert("删除成功");
	    		   location.reload();
	    	   }
	        }
	    }); 
	}
</script>
<style type="text/css">
	body{
		text-align: center;
	}
	.div{
		margin: 0 auto;
		width: 500px;
		height: 100px;
		border: 1px;
	}
</style>
<title>用户列表</title>
</head>
<body>
<div class="div">
<h3><a href="<%=basePath%>user/addUser">添加新用户</a></h3>
	<table border="1">
		<tbody>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>手机号</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty list }">
				<c:forEach items="${list}" var="user">
					<tr>
						<td>${user.id }</td>
						<td>${user.name }</td>
						<td>${user.age }</td>
						<td>${user.phone }</td>
						<td>
						<a href="<%=basePath %>user/${user.id}/edit">编辑用户</a>
						<a href="<%=basePath %>user/${user.id}">查看用户详情</a>  
						<a href="javascript:void(0);" onclick="delUser(${user.id })">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	</div>
</body>
</html>