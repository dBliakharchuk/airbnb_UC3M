package servlet;

import logic.UserLogic;
import database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet(
		urlPatterns= {"/loginServlet", "/registrationServlet", "/logoutServlet"},
		loadOnStartup=1,
		initParams={@WebInitParam(name="configuracion", value="es.uc3m.tiw")}
		)
public class AccountServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private static List<User> users = new ArrayList<User>();
	
	private String inputEmail = "";
	private String inputName = "";
	private String inputSurname = "";
	private String inputPassword = "";
	private String inputCheckbox = "";
	
	private String urlPath = "";
	private HttpSession session = null;
	private String msgBox = null;
	
	private static final String LOGIN_SERVLET = "/loginServlet";
	private static final String REGISTRATION_SERVLET = "/registrationServlet";
	private static final String LOGOUT_SERVLET = "/logoutServlet";
	
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			this.config = config;
		}
	       
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				msgBox = null;
				session = request.getSession();  
	            session.invalidate(); 
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); 
				dispatcher.forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			User registeredUser = null;
			User loggedUser = null;
			msgBox = null;
			urlPath = (String)request.getServletPath();
			
			if (urlPath.equals(REGISTRATION_SERVLET)) {
				inputEmail = request.getParameter("inputEmail");
				inputName = request.getParameter("inputName");
				inputSurname = request.getParameter("inputSurname");
				inputPassword = request.getParameter("inputPassword");
				
				registeredUser = DataAccess.getUserByEmail(inputEmail);
				if (registeredUser == null) 
				{
					registeredUser = new User(inputEmail, inputName, inputSurname, inputPassword, "0000000000");
					DataAccess.createUser(registeredUser);
					msgBox = "User was created";
				} else 
				{
					msgBox = "User already exist in DB!!!";
				}				
			} else if (urlPath.equals(LOGIN_SERVLET)) {
				inputEmail = request.getParameter("inputEmail");
				inputPassword = request.getParameter("inputPassword");
				inputCheckbox = request.getParameter("inputCheckbox");
				
				loggedUser = DataAccess.getUserByEmail(inputEmail);//should check email and password
	
				if (loggedUser != null)
				{
					boolean correctPassword = loggedUser.getPassword().equals(inputPassword);
					if (correctPassword) {
						session = request.getSession();
						session.setAttribute("loggedUser", loggedUser);
//						msgBox = ("User was logged in");
					}
				} else {
					msgBox = "Email or Password is wrong!!!";
				}
			} 
			else {
				msgBox = "Wrong Servlet";
			}
			
			request.setAttribute("msgBox", msgBox); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); 
			dispatcher.forward(request, response); 
		}
}
