package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.naming.*;
import javax.jms.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/readMessageQueueBrowserServlet" )
public class ReadMessageQueueBrowserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 @Resource(mappedName="airbnbConnectionFactory")
	 ConnectionFactory cf;
	 @Resource(mappedName="airbnbQueue")
	 private Queue queue;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadMessageQueueBrowserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doPost(request, response);
		} catch (Exception e) {
			System.out.println(
				"JHC ***************************************Error in doGet: "
					+ e);
		}		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			Connection conection = cf.createConnection();
			Session session= conection.createSession(false, javax.jms.TopicSession.AUTO_ACKNOWLEDGE);
		
			QueueBrowser browser = session.createBrowser(queue);
			conection.start();

			Enumeration<Message> enum1 =  browser.getEnumeration();

			while (enum1.hasMoreElements()) {
				Message newMes = enum1.nextElement();
				if (newMes instanceof TextMessage) {
					TextMessage textMes = (TextMessage) newMes;
					//send this messages to Message.jsp
				}
			}
			
			conection.stop();
			browser.close();
			session.close();
			conection.close();
		} catch (Exception e) {
			System.out.println(
				"JHC *************************************** Error in doPost: "
					+ e);
		}
	}
}
