<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.bean.IdInputBean" scope="request"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ログインユーザ名:<%=bean.getEmployeeName() %><br>
ログイン日時：<%=bean.getLd() %><br>
<form method="post" action="EmployeeDispServlet">
	IDを入力してください<input type="text" name="eid">
	<input type="submit" value="従業員表示">
</form>
<form method="post" action="EmployeeListDispServlet">
	<input type="submit" value="全従業員表示">
</form>
<font color="red"><%=bean.getMessage() %></font>
</body>
</html>