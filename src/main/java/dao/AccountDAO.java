package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.Account;

public class AccountDAO {
	
	

	public ResultSet rs = null;
	public PreparedStatement ps = null;
	public Connection conn = null;
	
	
	public Account checkLogin(String user, String pass) {
        String query = "Select * from Account where user = ? and pass = ?";
        try {
            conn = ConnectDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
//	CheckAccountExist
	public boolean checkAccountExist(String user) {
        String query = "Select * from Account where user = ?";
        try {
            conn = ConnectDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
	
//	CreateAccount
	public boolean createAccount(String user, String pass) {
		String query = "INSERT INTO Account (user, pass, isSell, isAdmin) VALUES (?, ?, 0, 0)";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);;
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		AccountDAO dao = new AccountDAO();
		System.out.println(dao.checkLogin("admin", "123"));
		System.out.println(dao.checkLogin("Adam", "123456"));
		System.out.println(dao.checkLogin("admin1", "123"));
		System.out.println(dao.checkLogin("admin1", "1234"));
	}
}
