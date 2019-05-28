<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.bean.EmployeeDispBean" scope="request"/>
<jsp:useBean id="bean_ss" class="jp.co.central_soft.train2019.bean.IdInputBean" scope="request"/>
<html>
<head>
<meta charset="UTF-8">
<title>employeeDisp</title>
</head>
<body>
ログインユーザ名：<%=bean_ss.getEdBean().getEmployeeName() %><br>
ログイン日時<%=bean_ss.getLd() %><br>
<br>
<%=bean.getEmployeeName() %><br>
<%=bean.getHireFiscalYear() %><br>
<%=bean.getBloodType() %><br>
<%=bean.getEmail() %><br>
<%=bean.getEmployeeID() %><br>
<%=bean.getHeight() %><br>
<%=bean.getWeight() %><br>
<%=bean.getBirthday() %><br>
</body>
</html>