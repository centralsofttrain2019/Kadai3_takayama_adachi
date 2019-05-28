<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login error</title>
</head>
<body>
	<p>IDは数値を入力してください。</p>
	<form method="POST" action="IdInputServlet">
		ユーザーIDを入力してください：<input type="text" name="eid">
		<input type="submit" value="Log in">
	</form>
</body>
</html>