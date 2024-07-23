package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.Category;

public class CategoryDAO {
	public ResultSet rs =null;
	public PreparedStatement ps = null;
	public Connection conn = null;
	
	
	public List<Category> getAllCategory() {
		
		ArrayList<Category> cList = new ArrayList<Category>();
		String query = "Select * from Category";
		
		try {
			
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				cList.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cList;
	}
	
	public static void main(String[] args) {
		CategoryDAO cDAO = new CategoryDAO();
        List<Category> cList = cDAO.getAllCategory();
        for (Category c : cList) {
            System.out.println(c);
	}}

}
