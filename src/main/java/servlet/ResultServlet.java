package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import logic.ApartmentLogic;
import model.Apartment;
import model.Reservation;


@WebServlet(
		urlPatterns="/results",
		loadOnStartup=1,
		initParams={@WebInitParam(name="configuracion", value="es.uc3m.tiw")}
		)
public class ResultServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	
		@Override
		public void init(ServletConfig config) throws ServletException {
			this.config = config;
			
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
			
			String fromPlace = request.getParameter("from-place").replaceAll("\\s","").toLowerCase();
			Date dateStart = null;
			Date dateEnd = null;
			try {
				dateStart = new Date ((new SimpleDateFormat("MM/dd/yyyy")).parse(request.getParameter("date-start")).getTime());
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dateEnd = new Date((new SimpleDateFormat("MM/dd/yyyy")).parse(request.getParameter("date-end")).getTime());
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String price = request.getParameter("price");
			String typeOfAccom = request.getParameter("typeOfAccom");
			
			Integer adults = null;
			Integer children = null;
			
			if(request.getParameter("adults")!=null){
					
				adults = new Integer(request.getParameter("adults"));
			}
			if(request.getParameter("children")!=null){
				
				children = new Integer(request.getParameter("children"));
			}
			
			List<Apartment> resultApartmentsList = ApartmentLogic.search(fromPlace, price, typeOfAccom, adults, children, dateStart, dateEnd);
			
			request.setAttribute("resultApartments", resultApartmentsList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
			
			dispatcher.forward(request, response);
				
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<html>");
//			out.println("<head>");
//			out.println("</head>");						
//			out.println("<body>");
//			out.println("<h1> Your fromPlace  is:"+fromPlace+"</h1>");
//			out.println("<h1> Your price  is:"+price+"</h1>");	
//			out.println("<h1> Your typeOfAccom  is:"+typeOfAccom+"</h1>");	
//			out.println("<h1> Your adults  is:"+adults+"</h1>");	
//			out.println("<h1> Your children  is:"+children+"</h1>");
//			out.println("<h1> Your dateStart  is:"+dateStart+"</h1>");
//			out.println("<h1> Your dateEnd  is:"+dateEnd+"</h1>");
//			out.println("<h1> Your resultApartment  is:"+resultApartmentsList.size()+"</h1>");
//			
//			out.println("</body>");				
//			out.println("</html>");		
//			
//			out.flush();
//			out.close();
//					
		}
		
}

