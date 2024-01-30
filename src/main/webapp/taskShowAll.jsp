<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスクの一覧表示</title>
</head>
<body>

	<%
	// セッションスコープからの属性値の取得
	List<TaskBean> taskbeanlist = (List<TaskBean>) request.getAttribute("taskbeanlist");

	// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
	response.setContentType("text/html; charset=UTF-8");
	%>

	<h2>タスク一覧画面</h2>
	<table border="1">

		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>

		<%
		for (TaskBean taskbean : taskbeanlist) {
		%>

		<tr>
			<td><%=taskbean.getTaskName()%></td>
			<td><%=taskbean.getCategoryName()%></td>
			<td><%=taskbean.getLimitDate()%></td>
			<td><%=taskbean.getUserId()%></td>
			<td><%=taskbean.getStatusCode()%></td>
			<td><%=taskbean.getMemo()%></td>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>