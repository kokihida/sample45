package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 肥田
 */
public class ConnectionManager {
	

	private static String URL = "jdbc:mysql://localhost:3306/task_db";

	/* データベースのユーザとパスワード */
	private static String USER = "root";
	private static String PASSWORD = "root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);

	}
}
