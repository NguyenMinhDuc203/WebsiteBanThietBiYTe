package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Account;
import entity.Category;
import entity.Product;

@WebServlet("/managerproduct")
public class ManagerProductControl extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ProductDAO pDAO = new ProductDAO();
	        HttpSession session = request.getSession();
	        Account a = (Account) session.getAttribute("acc");

	        if (a == null) {
	            response.sendRedirect("Login.jsp");
	            return;
	        }

	        int sellID = a.getId(); // Lấy ID người bán
	        List<Product> pList = pDAO.getProductBySellID(sellID); // Lấy danh sách sản phẩm của người bán
	        request.setAttribute("pList", pList); // Đặt danh sách sản phẩm vào request
	        
	        // Cập nhật danh mục
	        CategoryDAO cDAO = new CategoryDAO();
	        List<Category> cList = cDAO.getAllCategory();
	        request.setAttribute("cList", cList);

	        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response); // Chuyển tiếp đến JSP
	    
	}


}
