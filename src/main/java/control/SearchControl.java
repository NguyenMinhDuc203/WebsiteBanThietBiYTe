package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;

@WebServlet("/search")
public class SearchControl extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		request.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("txtSearch");
		ProductDAO pDao = new ProductDAO();
		List<Product> list = pDao.findProductByName(txtSearch);
		
		CategoryDAO cDAO = new CategoryDAO();
		List<Category> cList = cDAO.getAllCategory();
		
		
		request.setAttribute("cList", cList);
		request.setAttribute("txtSearch", txtSearch);
		request.setAttribute("pList", list);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

}
