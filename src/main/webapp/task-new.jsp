<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.CategoryBean,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク新規登録</title>
</head>
<body>
	タスク登録画面
	<br>

	<form action="TaskAddInsertServlet" method="POST">

		<%
		//セッションオブジェクトの取得
		HttpSession sessioncategory = request.getSession();
		// getAtrrivuteからの属性値の取得
		List<CategoryBean> categorybeanList = (List<CategoryBean>) sessioncategory.getAttribute("categorybeanList");
		List<UserBean> userbeanlist = (List<UserBean>) request.getAttribute("userbeanlist");
		
		// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
		response.setContentType("text/html; charset=UTF-8");
		%>
		<table border="1">

			<tr>
				<th>タスク名</th>
				<th>カテゴリ情報</th>
				<th>期限</th>
				<th>担当者情報</th>
				<th>ステータス情報</th>
				<th>メモ</th>
			</tr>

			<tr>
				<td><input type="text" name="taskName"></td>
				<td><select name="category">
						<%
						for (CategoryBean bean : categorybeanList) {
						%>
						<option value="<%=bean.getCategoryId()%>"><%=bean.getCategoryName()%></option>

						<%
						}
						%>
				</select></td>
				<td><input type="date" name="limit"></td>
				<td><select name="userid">
						<%
						for (UserBean userbean : userbeanlist) {
						%>
						<option value="<%=userbean.getUserId()%>"><%=userbean.getUserId()%></option>

						<%
						}
						%>
				</select></td>
				
				<td><select name="status">
						<option value="00">00:未着手</option>
						<option value="50">50:着手</option>
						<option value="99">99:完了</option>
				</select></td>
				<td><input type="text" name="memo"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="タスク登録">
	</form>
</body>
</html>