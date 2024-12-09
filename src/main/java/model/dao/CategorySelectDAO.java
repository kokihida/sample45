/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.entity.CategoryBean;

/**
 * @author 肥田
 * m_categoryからカテゴリ名の一覧を取得するDAO
 */
public class CategorySelectDAO {
	public List<CategoryBean> selectCategory() throws ClassNotFoundException, SQLException{
		
		String sql ="SELECT * FROM m_category";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
		}
		return null;
		
	}

}
