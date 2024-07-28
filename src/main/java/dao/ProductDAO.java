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
	
	
//	findProduct
	public List<Product> findProductByName(String name) {
		ArrayList<Product> pList = new ArrayList<Product>();
		String query = "Select * from Product where name like ?";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
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
	
//	getProductBySellID
	public List<Product> getProductBySellID(int id) {
		ArrayList<Product> pList = new ArrayList<Product>();
		String query = "Select * from Product where sell_ID = ?";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImage(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setTitle(rs.getString(5));
				p.setDescription(rs.getString(6));
				pList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
//	deleteProductByID
	public void deleteProductByID(String id) {
		String query = "Delete from Product where id = ?";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	insertProduct
	public void insertProduct(Product p) {
	    String query = "INSERT INTO product (name, image, price, title, description, cateID, sell_ID) VALUES (?,?,?,?,?,?,?);";
	    try {
	        conn = ConnectDB.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, p.getName());
	        ps.setString(2, p.getImage());
	        ps.setDouble(3, p.getPrice());
	        ps.setString(4, p.getTitle());
	        ps.setString(5, p.getDescription());
	        ps.setInt(6, p.getCateID());
	        ps.setInt(7, p.getSell_ID());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
//updateProduct
	public void updateProduct(Product p) {
		String query = "UPDATE product SET name = ?, image = ?, price = ?, title = ?, description = ?, cateID = ?, sell_ID = ? WHERE id = ?;";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setString(2, p.getImage());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getTitle());
			ps.setString(5, p.getDescription());
			ps.setInt(6, p.getCateID());
			ps.setInt(7, p.getSell_ID());
			ps.setInt(8, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ProductDAO pDAO = new ProductDAO();
//		List<Product> pList = pDAO.getAllProduct();
//		List<Product> pList = pDAO.getProductByCID("1");
				List<Product> pList = pDAO.findProductByName("a");
		for (Product p : pList) {
			System.out.println(p);
			
		}
		
		
//		Product p = pDAO.getProductByID("1");
//        System.out.println(p);		
	}

}


