package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;

@WebServlet("/signup")
public class SignupControl extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        
        if (!pass.equals(repass)){
            response.sendRedirect("SignUp.jsp");
		} else {
			AccountDAO dao = new AccountDAO();
//			checkAccountExist
			if (dao.checkAccountExist(user)) {
				request.setAttribute("mess", "Account already exists");
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			} else {
//			CreateAccount
				dao.createAccount(user, pass);
				response.sendRedirect("Login.jsp");
			}
		}

	}
}