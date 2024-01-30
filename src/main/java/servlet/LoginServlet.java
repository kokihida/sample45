package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		UserDAO userdao = new UserDAO(); //メソッド呼ぶためのインスタンス
		String url = null;
		String uName = null;

		try {
			uName = userdao.login(userId, password);
			if (uName != null) {
				url = "menu.jsp";
			} else if (uName == null) {
				url = "login-failed.jsp";
			}

			// セッションオブジェクトの取得
			HttpSession session = request.getSession();
			// セッションスコープへの属性の設定
			session.setAttribute("uName", uName);

			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
