package dao;

import entity.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;

public class CartDAO {

    public List<Cart> getAllCart() {
        List<Cart> cartList = new ArrayList<>();
        String query = "SELECT * FROM Cart";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setAccountID(rs.getInt("accountID"));
                cart.setProductID(rs.getInt("productID"));
                cart.setAmount(rs.getInt("amount"));
                cart.setPrice(rs.getDouble("price"));
                cart.setPname(rs.getString("pname"));
                cart.setImage(rs.getString("image"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    public void addCart(int accountID, int productID, int amount, double price, String pname, String image) {
        String query = "INSERT INTO Cart(accountID, productID, amount, price, pname, image) VALUES (?,?,?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.setDouble(4, price);
            ps.setString(5, pname);
            ps.setString(6, image);
            
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
