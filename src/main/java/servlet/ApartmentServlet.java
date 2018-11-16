package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ApartmentPK;

/**
 * Servlet implementation class ApartmentServlet
 */
@WebServlet("/ApartmentServlet")
public class ApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentServlet() {
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
			
			String buildingNumber = request.getParameter("building_number");
			String street = request.getParameter("street");
			String flatNumber = request.getParameter("flat_number");
			String	city = request.getParameter("city");
			
			
			ApartmentPK apartmentPK = new ApartmentPK(email, buildingNumber, street, flatNumber, city);
			writer.println(1);
			
//			 Apartment apartmen = new Apartment(apartmentPK, adults_beds, childeren_beds, cuntry, description, placeName, price, type); change type
//			 User updatedUserData = new User(email, name, phoneNumber, surname);
//			 int userUpdatedStatus = AdministratorLogic.updateUserData(updatedUserData);
			
			
//			 writer.println(email + placeName + cuntry  + type + Double.toString(price) + Integer.toString(childeren_beds) + Integer.toString(adults_beds)
//					 + description + buildingNumber + street + flatNumber + city);
		}else if ("deletePlace".equals(action))
		{
			
			String email = request.getParameter("email");
			String buildingNumber = request.getParameter("building_number");
			String street = request.getParameter("street");
			String flatNumber = request.getParameter("flat_number");
			String	city = request.getParameter("city");
			
			
			
			writer.println(1);
			
			
//			String email = request.getParameter("email");
//			int userDeletedStatus = AdministratorLogic.deleteUser(email);
//			writer.println(userDeletedStatus);
			
		}
		
	}
	

}
