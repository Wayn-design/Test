<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料維護</title>

</head>
<body>
	<jsp:include page="../../banner.jsp"></jsp:include>
	<script type="text/javascript">
		//使用選擇器語法(選擇網頁物件) 下載瀏覽器引發的事件 進行初始化設定
		$(document).ready(
			//事件程序
			function(){
				var customeridEL = $("#customer_id");
				customeridEL.blur(
					function(){
						var cid = $(this).val();
						alert(cid);
					}		
				);
			}
		); //引發點onload
	</script>
	<fieldset>
		<legend>客戶新增作業</legend>
		<s:form>
			<s:textfield label="客戶編號" name="customer.customer_id" id="customer_id"></s:textfield>
			<s:textfield label="First Name" name="customer.first_name" id="first_name"></s:textfield>
			<s:textfield label="Last Name" name="customer.last_name" id="last_name"></s:textfield>
			<s:textfield label="儲號" name="customer.store_id" id="store_id"></s:textfield>
			<s:textfield label="電子郵件信箱" name="customer.email" id="email"></s:textfield>
			<s:checkbox name="customer.active" label="有效性" id="active"></s:checkbox>
			<s:textfield label="建檔日期" name="customer.create_date" id="create_date"></s:textfield>
			<s:submit value="新增"></s:submit>
			<s:reset value="取消"></s:reset>
		</s:form>
		
	</fieldset>
</body>
</html>