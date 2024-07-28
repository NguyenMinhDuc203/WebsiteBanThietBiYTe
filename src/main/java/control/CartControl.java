//package control;
//
//import dao.CartDAO;
//import entity.Account;
//import entity.Cart;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/cart")
//public class CartControl extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        CartDAO cartDAO = new CartDAO();
//        HttpSession session = request.getSession();
//        Account a = (Account) session.getAttribute("acc");
//
//        if (a == null) {
//            response.sendRedirect("Login.jsp");
//            return;
//        }
//
//        List<Cart> cartList = cartDAO.getAllCart();
//        request.setAttribute("cartList", cartList);
//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
//    }
//
//}
package control;

import dao.CartDAO;
import entity.Account;
import entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDAO cartDAO = new CartDAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");

        if (a == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        List<Cart> cartList = cartDAO.getAllCart();
        double totalPrice = cartList.stream().mapToDouble(cart -> cart.getPrice() * cart.getAmount()).sum();
        double vat = totalPrice * 0.1; // Tính VAT là 10% của tổng tiền hàng

        request.setAttribute("cartList", cartList);
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("vat", vat);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }
}
