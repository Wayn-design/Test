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

<fieldset>
	<legend>客戶資料查詢</legend>
	<s:form>
		<s:textfield label="國家別" name="country"></s:textfield>
		<s:submit value="查詢"></s:submit>
	</s:form>
	<br/>	
</fieldset>
<s:if test="result.size()>0">
	<fieldset>
		<legend>查詢結果</legend>
		<table border="1" width="100%">
			<thead>
				<tr>
					<td>客戶編號</td>
					<td>姓名</td>
					<td>地址</td>
					<td>城市</td>
					<td>國家</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="result" status="item">
				<tr>
					<td><s:property value="customer_id"/></td>
					<td><s:property value='first_name+"-"+last_name'/></td>
					<td><s:property value="address"/></td>
					<td><s:property value="city"/></td>
					<td><s:property value="country"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	</fieldset>
</s:if>
<s:else>
	<h2><s:property value="message"/></h2>
</s:else>

</body>
</html>