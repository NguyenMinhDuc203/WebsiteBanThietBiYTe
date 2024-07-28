package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import entity.Account;

@WebServlet("/addcart")
public class AddCart extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        String id = request.getParameter("id");
	        String name = request.getParameter("name");
	        String price = request.getParameter("price");
	        String image = request.getParameter("image");
	        String title = request.getParameter("title");

	        HttpSession session = request.getSession();
	        Account a = (Account) session.getAttribute("acc");

	        if (a == null) {
	            response.sendRedirect("Login.jsp");
	            return;
	        }

	        CartDAO cartDAO = new CartDAO();
	        int amount = 1;
	        cartDAO.addCart(a.getId(), Integer.parseInt(id), amount, Double.parseDouble(price), name, image);
	        response.sendRedirect("cart");
	    }

}
