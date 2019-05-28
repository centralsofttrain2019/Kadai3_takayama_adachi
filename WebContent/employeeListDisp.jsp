<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.bean.EmployeeListDispBean" scope="request"/>
<jsp:useBean id="bean_ss" class="jp.co.central_soft.train2019.bean.IdInputBean" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeeListDisp</title>
</head>
<body>
ログインユーザ名：<%=bean_ss.getEmployeeName() %><br>
ログイン日時：<%=bean_ss.getLd() %><br>

<table border=1>
<thead>
	<tr>
		<th>ID</th>
		<th>名前</th>
		<th>身長</th>
		<th>体重</th>
		<th>メールアドレス</th>
		<th>入社年度</th>
		<th>BirthDay</th>
		<th>血液型</th>
	</tr>
</thead>
<% for(int i=0; i< bean.size(); i++) { %>
<tr>
<th><%=bean.get(i).getEmployeeID() %></th>
<th><%=bean.get(i).getEmployeeName() %></th>
<th><%=bean.get(i).getHeight() %></th>
<th><%=bean.get(i).getWeight() %></th>
<th><%=bean.get(i).getEmail() %></th>
<th><%=bean.get(i).getHireFiscalYear() %></th>
<th><%=bean.get(i).getBirthday() %></th>
<th><%=bean.get(i).getBloodType() %></th>
</tr>
<% } %>
</table>
</body>
</html>