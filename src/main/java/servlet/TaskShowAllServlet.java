package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskShowAllDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskShowAllServlet
 */
@WebServlet("/TaskShowAllServlet")
public class TaskShowAllServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//一覧をTaskShowAllDAOの型で受け取る
		TaskShowAllDAO taskshowalldao = new TaskShowAllDAO();
		List<TaskBean> taskbeanlist = null;

		try {
			taskbeanlist = taskshowalldao.taskShowAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		//受け取ったものを全部Listに入れてそのListをsettAtrivuteで送る
		// セッションスコープへの属性の設定
		request.setAttribute("taskbeanlist", taskbeanlist);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("taskShowAll.jsp");
		rd.forward(request, response);

	}

}
