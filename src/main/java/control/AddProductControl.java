package control;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import entity.Account;
import entity.Product;

@WebServlet("/addproduct")
public class AddProductControl extends  HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String categoryID = request.getParameter("category");
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int sell_ID = a.getId();
		
		ProductDAO pDAO = new ProductDAO();
		Product p = new Product(name, image, Double.parseDouble(price), title, description, Integer.parseInt(categoryID), sell_ID);
		pDAO.insertProduct(p);
		response.sendRedirect("managerproduct");
		
		

	}

}
