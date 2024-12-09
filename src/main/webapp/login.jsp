<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h2>タスク管理システム</h2>
	<h2>ユーザーIDとパスワードを入力してください</h2>
	<form action="LoginServlet" method="POST">
		<label for="username">ユーザーID:</label> <input type="text" id="username"
			name="userid" required><br> 
		<label for="password">パスワード:</label>
		<input type="password" id="password" name="password" required><br>
		<br> 
		<input type="submit" value="ログイン">
		<input type="reset" value="クリア">
	</form>

</body>
</html>