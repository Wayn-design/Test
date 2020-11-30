<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
 <base href="<%=basePath%>">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	   <link rel="stylesheet" href="styles.css">
	   <!-- CDN -->
   <!-- <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script> -->
   <script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<div id='cssmenu'>
<ul>
   <li class='active'><a href='index.jsp'><span>首頁</span></a></li>
   <li>
   	<a href='customers/custqry.action'><span>客戶資料查詢</span></a></li>
  <li><a href='customers/customermaint.action'><span>客戶資料維護</span></a></li>
   <li><a href='#'><span>產品資料維護</span></a></li>
   <li class='last'><a href='#'><span>聯絡</span></a></li>
   <li><a href='register.action'><span>註冊作業</span></a></li>
</ul>
</div>