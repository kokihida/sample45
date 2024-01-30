package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class TaskAddInsertServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		
		
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// セッションスコープへの属性の設定
		session.setAttribute("uName", null);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(null);//そのまま登録したいものを入力するjspへ
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//入力フォーム.jspを表示する(入力フォームjsp)

		//入力したらこちらを入力するでよろしいですか？.jsp
		//決定したら登録される

	}

}
