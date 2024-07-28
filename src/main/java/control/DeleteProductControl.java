package control;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;

@WebServlet("/deleteproduct")
public class DeleteProductControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pid = request.getParameter("pid");
		ProductDAO pDAO = new ProductDAO();
		pDAO.deleteProductByID(pid);
		response.sendRedirect("managerproduct");

	}
}
