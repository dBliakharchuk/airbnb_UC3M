package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataAccess;
import logic.AdministratorLogic;
import model.Apartment;
import model.ApartmentPK;
import model.User;


@WebServlet(
		urlPatterns="/administatorHomes",
		loadOnStartup=1,
		initParams={@WebInitParam(name="configuracion", value="es.uc3m.tiw")}
		)
public class AdministratorHomesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private List<Apartment> apartments;
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			this.config = config;
			DataAccess.test();
		}
	       


		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			apartments =  new ArrayList<Apartment>(DataAccess.getAllApartments());
			request.setAttribute("apartments", apartments);
			request.getRequestDispatcher("administatorHomes.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter writer = response.getWriter();
			String action = request.getParameter("action");
			
			if ("updateApartment".equals(action))
			{	
				String email = request.getParameter("email");
				String placeName = request.getParameter("placeName");
				String cuntry= request.getParameter("cuntry");
				double	price = Double.parseDouble(request.getParameter("price"));
				String type = request.getParameter("type");
				int adults_beds = Integer.parseInt(request.getParameter("adults_beds"));
				int childeren_beds = Integer.parseInt(request.getParameter("childeren_beds"));
				String	description = request.getParameter("description");
				
				int buildingNumber = Integer.parseInt(request.getParameter("building_number"));
				String street = request.getParameter("street");
				int flatNumber = Integer.parseInt(request.getParameter("flat_number"));
				String	city = request.getParameter("city");
				
				
			//	ApartmentPK apartmentPK = new ApartmentPK(email, buildingNumber, street, flatNumber, city);
//				
//				 
//				 User updatedUserData = new User(email, name, phoneNumber, surname);
//				
//				 int userUpdatedStatus = AdministratorLogic.updateUserData(updatedUserData);
				
				
//				 writer.println(email + placeName + cuntry + price + type + adults_beds + childeren_beds
//						 + description + building_number + street + flat_number + city);
			}else if ("deletePlace".equals(action))
			{
//				String email = request.getParameter("email");
//				int userDeletedStatus = AdministratorLogic.deleteUser(email);
//				writer.println(userDeletedStatus);
				
			}
			
		}
		
		



}











