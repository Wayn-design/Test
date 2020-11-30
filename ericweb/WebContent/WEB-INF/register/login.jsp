<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../../banner.jsp"></jsp:include>
<fieldset style="background-color:lightyellow">
	<legend>登入作業</legend>
	<s:form>
		<s:textfield label="使用者名稱" name="users.username"></s:textfield>
		<s:password label="使用者密碼" name="users.password"></s:password>
		<s:submit value="登入"></s:submit>
	</s:form>
</fieldset>
</body>
</html>