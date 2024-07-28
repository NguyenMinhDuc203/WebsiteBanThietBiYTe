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

@WebServlet("/edit")
public class EditControl extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
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
		pDAO.updateProduct(new Product(Integer.parseInt(id), name, image, Double.parseDouble(price), title, description, Integer.parseInt(categoryID), sell_ID));
		response.sendRedirect("managerproduct");

	}
}
