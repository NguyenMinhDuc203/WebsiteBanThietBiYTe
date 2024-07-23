package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.Product;

public class ProductDAO {
	
//	getAllProduct
	
	public ResultSet rs =null;
	public PreparedStatement ps = null;
	public Connection conn = null;
//	getAllProduct
	public List<Product> getAllProduct() {
		ArrayList<Product> pList = new ArrayList<Product>();
		String query = "Select * from Product";
		try {
			conn = ConnectDB.getConnection();
			 ps = conn.prepareStatement(query);
			 rs = ps.executeQuery();
//			 private int id;
//				private String name;
//				private String image;
//				private double price;
//				private String title;
//				private String description;
			 while(rs.next()) {
				 Product p = new Product();
				 p.setId(rs.getInt(1));
				 p.setName(rs.getString(2));
				 p.setImage(rs.getString(3));
				 p.setPrice(rs.getDouble(4));
				 p.setTitle(rs.getString(5));
				 pList.add(p);
			 }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pList;
	}
	
//	getProductByCID
	public List<Product> getProductByCID(String cid) {
        ArrayList<Product> pList = new ArrayList<Product>();
        String query = "Select * from Product where cateID = ?";
        try {
            conn = ConnectDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setImage(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                p.setTitle(rs.getString(5));
                pList.add(p);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return pList;
    }
	
	
//	getProductByID
	public Product getProductByID(String id) {
		Product p = new Product();
		String query = "Select * from Product where id = ?";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImage(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setTitle(rs.getString(5));
				p.setDescription(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	public static void main(String[] args) {
		ProductDAO pDAO = new ProductDAO();
//		List<Product> pList = pDAO.getAllProduct();
		List<Product> pList = pDAO.getProductByCID("1");
		for (Product p : pList) {
			System.out.println(p);
			
		}
		
		
//		Product p = pDAO.getProductByID("1");
//        System.out.println(p);		
	}

}


