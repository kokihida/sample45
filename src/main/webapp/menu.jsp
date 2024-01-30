<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
画面表示確認
	<%
	//セッションオブジェクトの取得
	HttpSession sessionLogin = request.getSession();

	// セッションスコープからの属性値の取得
	String uName = (String) sessionLogin.getAttribute("uName");

	// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
	response.setContentType("text/html; charset=UTF-8");
	%>
	ようこそ<%=uName %>さん<br>
	
	<form action="InsertServlet" method="GET">
		<input type="submit" value="タスク登録画面">
	</form>
	<br>

	<form action="TaskShowAllServlet" method="POST">
		<input type="submit" value="タスク一覧表示画面">
	</form>
	<br>

	<form action="未記入" method="POST">
		<input type="submit" value="ログアウト">
	</form>

</body>
</html>