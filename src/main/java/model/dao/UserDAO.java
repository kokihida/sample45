package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	/**
	 * @author 肥田
	 */

	//ログイン時のメソッド戻り値では名ユーザー名を返しsessionに入れたい
	public String login(String id, String pass) throws ClassNotFoundException, SQLException {
		String uName = null;
		String sql = "SELECT user_name FROM m_user WHERE user_id = ? AND password = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			//?プレスホルダにセット
			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				uName = res.getString("user_name");
				return uName;
			}
		}
		return null;

	}

}
