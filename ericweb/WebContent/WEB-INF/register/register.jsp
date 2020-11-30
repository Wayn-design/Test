<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    <jsp:include page="../../banner.jsp"></jsp:include>
  <fieldset>
  	<legend>使用者註冊作業</legend>
  	<form method="post" action="usersave.action">
  		<div>使用者名稱</div>
  		<input type="text" name="username"/>
  		<div>使用者密碼</div>
  		<input type="password" name="password"/>
  		<div>EMAIL</div>
  		<input type="text" name="email"/>
  		<br/>
  		<input type="submit" value="註冊"/>
  	</form>
  </fieldset>
  </body>
</html>
