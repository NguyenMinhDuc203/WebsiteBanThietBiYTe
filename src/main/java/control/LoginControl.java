package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import entity.Account;

@WebServlet("/login")
public class LoginControl extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		AccountDAO dao = new AccountDAO();
		Account a = dao.checkLogin(user, pass);
		if(a!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("acc", a);
            response.sendRedirect("home");
		}else {
			request.setAttribute("mess", "Incorrect username or password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}
}
