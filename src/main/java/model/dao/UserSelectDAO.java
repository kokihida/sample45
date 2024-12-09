/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;

/**
 * @author 肥田
 * m_userのuser_idがFKなので、入力できるものが指定できるように値を受け取るためのクラス
 */
public class UserSelectDAO {

	public List<UserBean> userList() throws ClassNotFoundException, SQLException {

		List<UserBean> userbeanlist = new ArrayList<>();
		String sql = "SELECT * FROM m_user";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			ResultSet res = pstmt.executeQuery();

			

			while (res.next()) {
				String userid = res.getString("user_id");
				String username = res.getString("user_name");
				Timestamp updatedeteime = res.getTimestamp("update_datetime"); //★ここ記述自身なし

				UserBean userbean = new UserBean();
				userbean.setUserId(userid);
				userbean.setUserName(username);
				userbean.setTimeStamp(updatedeteime);

				userbeanlist.add(userbean);
			}

		}
		//m_user内のid,name,更新日時を返す
		return userbeanlist;

	}
}
