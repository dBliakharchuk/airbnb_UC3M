package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataAccess;
import logic.PaymentUtils;
import model.ApartmentPK;


@WebServlet(
		urlPatterns="/transfers",
		loadOnStartup=1,
		initParams={@WebInitParam(name="configuracion", value="es.uc3m.tiw")}
		)
public class TransferServlet extends HttpServlet {
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
			
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			
			dispatcher.forward(request, response);

		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String cardNumber = request.getParameter("card-number");
			String expirationDate = request.getParameter("expiration-date");
			String cv2 = request.getParameter("cv2-code");
			
			if (PaymentUtils.isDataCorrect(16, cardNumber, 3, cv2, expirationDate)==false) {
				
        		String dataError = "Provided data is incorrect. Provide valid payment data and try again.";
        	
        		request.setAttribute("dataError", dataError);
			
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/payment.jsp");
			
        		dispatcher.forward(request, response);
        	} else {    
        	
        	}
		}


}
