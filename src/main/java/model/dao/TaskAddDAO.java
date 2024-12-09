package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 肥田
 */
public class TaskAddDAO {

	//INSERTしタスクを新規登録するためのDAO
	public int taskAdd(String taskName, int category, Date date, String userid, String status, String memo)
			throws ClassNotFoundException, SQLException {

		int recode = 0;
		String sql = "INSERT INTO t_task (task_name,category_id,limit_date,user_id,status_code,memo)VALUES (?,?,?,?,?,?)";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1,taskName);
			pstmt.setInt(2,category);
			pstmt.setDate(3,date);
			pstmt.setString(4,userid);
			pstmt.setString(5,status);
			pstmt.setString(6,memo);
			
			//SQLの実行Updateメソッド
			recode = pstmt.executeUpdate();
			
			
		}

		return recode;

	}
}
