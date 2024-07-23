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

@WebServlet("/detail")
public class DetailControl extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		ProductDAO pDAO = new ProductDAO();
		Product p = pDAO.getProductByID(id);
		
		
		CategoryDAO cDAO = new CategoryDAO();
		List<Category> cList = cDAO.getAllCategory();
		
		
		request.setAttribute("cList", cList);
		request.setAttribute("p", p);
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
	}
}
