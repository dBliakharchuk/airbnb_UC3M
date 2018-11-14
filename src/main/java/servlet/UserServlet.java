package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.AdministratorLogic;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String action = request.getParameter("action");
		
		if ("updateUser".equals(action))
		{
			 String email = request.getParameter("email");
			 String name = request.getParameter("name");
			 String surname = request.getParameter("surname");
			 String	phoneNumber = request.getParameter("phoneNumber");
			 			
			 int userUpdatedStatus = AdministratorLogic.updateUserData(email, name, phoneNumber, surname);
			 writer.println(userUpdatedStatus);
				
		} else if ("changePassword".equals(action))
		{
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int passwordUpdateStatus = AdministratorLogic.updateUserPassword(email, password);
			writer.println(passwordUpdateStatus);
			
		} else if ("deleteUser".equals(action))
		{
			String email = request.getParameter("email");
			int userDeletedStatus = AdministratorLogic.deleteUser(email);
			writer.println(userDeletedStatus);
			
		}
	}

}
