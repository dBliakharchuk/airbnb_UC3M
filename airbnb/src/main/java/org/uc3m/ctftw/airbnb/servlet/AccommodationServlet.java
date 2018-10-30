package org.uc3m.ctftw.airbnb.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.uc3m.ctftw.airbnb.database.DataAccess;
import org.uc3m.ctftw.airbnb.logic.Application;
import org.uc3m.ctftw.airbnb.model.User;


@WebServlet(
		urlPatterns="/accommodation",
		loadOnStartup=1,
		initParams={@WebInitParam(name="configuracion", value="es.uc3m.tiw")}
		)
public class AccommodationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	
		@Override
		public void init(ServletConfig config) throws ServletException {
			this.config = config;
			Session sessionObj = Application.buildSessionFactory().openSession();
			try
		    {
		        List<User> users = sessionObj.createCriteria(User.class).list();
		        System.out.println(users);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		}
	       


		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
				
			
		}


}
