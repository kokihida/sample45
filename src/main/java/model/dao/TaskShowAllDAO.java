package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskShowAllDAO {

	//一覧を表示させるためのメソッド
	public List<TaskBean> taskShowAll() throws ClassNotFoundException, SQLException {

		String sql = "SELECT t1.task_name,t2.category_name,t1.limit_date,t1.user_id,t1.status_code,t1.memo FROM t_task t1 JOIN m_category t2 ON t1.category_id = t2.category_id";
		List<TaskBean> returnbeanList = new ArrayList<TaskBean>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			//SQLの実行
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				String task_name = res.getString("t1.task_name");
				String category_name = res.getString("t2.category_name");
				Date limit_date = res.getDate("t1.limit_date");
				String user_id = res.getString("user_id");
				String status_code = res.getString("status_code");
				String memo = res.getString("memo");
				
				TaskBean taskbean = new TaskBean();
				taskbean.setTaskName(task_name);
				taskbean.setCategoryName(category_name);
				taskbean.setLimitDate(limit_date);
				taskbean.setUserId(user_id);
				taskbean.setStatusCode(status_code);
				taskbean.setMemo(memo);
				
				returnbeanList.add(taskbean);
			}
		}
		return returnbeanList;
	}

}
