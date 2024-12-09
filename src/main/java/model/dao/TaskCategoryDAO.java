/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

/**
 * @author 肥田
 * m_categoryに登録されているcategory_nameをタスク登録の際にセレクトボタンで表示させるDAO
 */
public class TaskCategoryDAO {
	public List<CategoryBean> taskCategory() throws ClassNotFoundException, SQLException {

		List<CategoryBean> categoryList = new ArrayList<>();

		String sql = "SELECT t1.category_id,t1.category_name FROM m_category t1 JOIN t_task t2 ON t1.category_id = t2.category_id";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			//SQLの実行
			ResultSet res = pstmt.executeQuery();

			CategoryBean categoryBean = new CategoryBean();

			while (res.next()) {
				int categoryid = res.getInt("category_id");
				String categoryName = res.getString("category_name");

				categoryBean.setCategoryId(categoryid);
				categoryBean.setCategoryName(categoryName);

				categoryList.add(categoryBean);
			}
		}
		return categoryList;

	}
}
