package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataAccess;
import logic.ApartmentLogic;
import logic.UserLogic;
import model.Apartment;
import model.ApartmentPK;
import model.ApartmentType;
import model.User;

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
		String emailOfLoggedUser = (String) request.getSession().getAttribute("emailOfLoggedUser"); 

		
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
			Apartment apartment = DataAccess.getApartmentById(apartmentPK);
			
			apartment.setName(placeName);
			apartment.setPrice(price);
			apartment.setType(type);
			apartment.setBedsAdult(adults_beds);
			apartment.setBedsChild(childeren_beds);
			apartment.setDescription(description);
			
			Boolean apartmentUpdatedStatus = ApartmentLogic.modifyApartment(apartment);
			
			
			if(!("admin".equals(emailOfLoggedUser)))
			{
				if(apartmentUpdatedStatus)
				{
					RequestDispatcher rd = request.getRequestDispatcher("/manageProfile"); //not working
					rd.forward(request, response);
					//not working
				}
			}else {
				int apartmentUpdateStatusInt = apartmentUpdatedStatus ? 1 : 0;
				writer.println(apartmentUpdateStatusInt);				
			}
			
			System.out.println(email + placeName + cuntry  + type + Double.toString(price) + Integer.toString(childeren_beds) + Integer.toString(adults_beds)
					 + description + buildingNumber + street + flatNumber + city);
		}if ("addApartment".equals(action))
		{	
			String email = request.getParameter("email");
			String placeName = request.getParameter("placeName");
			String cuntry= request.getParameter("country");
			double	price = Double.parseDouble(request.getParameter("price"));
			String type = request.getParameter("type");
			int adults_beds = Integer.parseInt(request.getParameter("adults_beds"));
			int childeren_beds = Integer.parseInt(request.getParameter("childeren_beds"));
			String	description = request.getParameter("description");
			
			String buildingNumber = request.getParameter("building_number");
			String street = request.getParameter("street");
			String flatNumber = request.getParameter("flat_number");
			String	city = request.getParameter("city");
	
			byte[] picture = new byte[1];				//to do !!!! proces picture !!!!!!!!!!!!
			
			ApartmentPK apartmentPK = new ApartmentPK(email, buildingNumber, street, flatNumber, city);
			User host = DataAccess.getUserByEmail(email);
		
			Apartment newApartment = new Apartment(host, buildingNumber, street, flatNumber, city, adults_beds, childeren_beds, cuntry, description, placeName, picture, price, ApartmentType.fromString(type) );
			Boolean apartmentAddedStatus = ApartmentLogic.addApartment(newApartment);
			if(apartmentAddedStatus)
			{
				RequestDispatcher rd = request.getRequestDispatcher("manageProfile");
				rd.forward(request, response);
				// not working -> manageProfile
			}
			

		}else if ("deletePlace".equals(action))
		{
			
			String email = request.getParameter("email");
			String buildingNumber = request.getParameter("building_number");
			String street = request.getParameter("street");
			String flatNumber = request.getParameter("flat_number");
			String	city = request.getParameter("city");
			
			System.out.println(email + buildingNumber + street+ flatNumber + city );
			
			ApartmentPK apartmentPK = new ApartmentPK(email, buildingNumber, street, flatNumber, city);
			Boolean apartmentDeletedtatus = ApartmentLogic.removeApartment(apartmentPK);
			
			if(!("admin".equals(emailOfLoggedUser)))
			{
				if(apartmentDeletedtatus)
				{
					int apartmentDeletedtatusInt = apartmentDeletedtatus ? 1 : 0;
					writer.println(apartmentDeletedtatusInt);
					RequestDispatcher rd = request.getRequestDispatcher("manageProfile"); 
					rd.forward(request, response);
					//not working -> manageProfile
				}
			}else {
				int apartmentDeletedtatusInt = apartmentDeletedtatus ? 1 : 0;
				writer.println(apartmentDeletedtatusInt);
			}

			
		}
		
	}
	

}
