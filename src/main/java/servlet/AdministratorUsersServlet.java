package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataAccess;
import logic.AdministratorLogic;
import model.User;

@WebServlet(urlPatterns = "/administatorUsers", loadOnStartup = 1, initParams = {
		@WebInitParam(name = "configuracion", value = "es.uc3m.tiw") })
public class AdministratorUsersServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private List<User> users;

	private Boolean userUpdated = false;
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			this.config = config;

		}
	       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		users = new ArrayList<User>(DataAccess.getAllUsers());
		request.setAttribute("users", users);
		request.getRequestDispatcher("administatorUsers.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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