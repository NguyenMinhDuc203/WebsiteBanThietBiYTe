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

@WebServlet("/updateproduct")
public class UpdateProductControl extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String pid = request.getParameter("pid");
		ProductDAO pDAO = new ProductDAO();
		Product p = pDAO.getProductByID(pid);

		CategoryDAO cDAO = new CategoryDAO();
		List<Category> cList = cDAO.getAllCategory();
		
		
		request.setAttribute("cList", cList);
		request.setAttribute("noteID", p.getCateID());
		request.setAttribute("detail", p);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}


}
