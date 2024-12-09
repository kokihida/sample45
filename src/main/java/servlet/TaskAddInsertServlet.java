package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskAddDAO;
import model.dao.TaskCategoryDAO;
import model.dao.UserSelectDAO;
import model.entity.CategoryBean;
import model.entity.UserBean;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/TaskAddInsertServlet")
public class TaskAddInsertServlet extends HttpServlet {
	/**
	 * @author 肥田
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * doGetではカテゴリー名をセレクトボックスで選択できるようにメソッドを実装している
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		TaskCategoryDAO taskCategorydao = new TaskCategoryDAO();
		List<CategoryBean> categorybeanList = new ArrayList<>();
		//セレクトボックス用カテゴリ一覧とカテゴリ名をとってくる
		try {
			categorybeanList = taskCategorydao.taskCategory();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		//以下にm_userの中身を出力できるようにセレクトボックス内で表示するため持ってきます
		UserSelectDAO userselectdao = new UserSelectDAO();
		List<UserBean> userbeanlist = new ArrayList<>();
		try {
			//一覧取得
			userbeanlist = userselectdao.userList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// セッションスコープへの属性の設定
		session.setAttribute("categorybeanList", categorybeanList);
		request.setAttribute("userbeanlist", userbeanlist);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("task-new.jsp");//そのまま登録したいものを入力するjspへ
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String taskName = request.getParameter("taskName"); //タスク名受け取り
		int category = Integer.parseInt(request.getParameter("category")); //カテゴリーをセレクトボックスから受け取り
		String limit = request.getParameter("limit"); //★★やらかしてるかも、ここ怪しいなぁ
		String userid = request.getParameter("userid"); //担当者
		String status = request.getParameter("status"); //ステータスの00,50,99受け取る
		String memo = request.getParameter("memo");

		//limitをYYYY/MM/DDにするための処理　★★java.sqlクラスを使用
		Date limitDate = Date.valueOf(limit);

		TaskAddDAO taskadddao = new TaskAddDAO();
		int result = 0;
		String url = null;
		try {
			result = taskadddao.taskAdd(taskName, category, limitDate, userid, status, memo);

			if (result == 1) {
				url = "add-success.jsp";
			} else {
				url = "add-failure.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
