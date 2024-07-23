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

@WebServlet("/home")
public class HomeControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ProductDAO pDAO = new ProductDAO();
		List<Product> pList = pDAO.getAllProduct();
		
		CategoryDAO cDAO = new CategoryDAO();
		List<Category> cList = cDAO.getAllCategory();
		
		
		request.setAttribute("cList", cList);

		request.setAttribute("pList", pList);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
        
    }
		
	
}
