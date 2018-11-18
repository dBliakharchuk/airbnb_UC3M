package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.*;

@WebServlet(urlPatterns = {"/sendMessageQueueServlet"})
public class SendMessageQueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Resource(mappedName="airbnbConnectionFactory")  // Inject the connectionFactory using annotations
	 ConnectionFactory cf;
	 @Resource(mappedName="airbnbQueue") // Inject the queue using annotations
	 private Queue queue;
	 
	 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageQueueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

			
	public void doPost(
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
			
			try {
				Connection con = cf.createConnection();
				con.start();
			      
				Session session = con.createSession(false, javax.jms.TopicSession.AUTO_ACKNOWLEDGE);	
				MessageProducer producer = session.createProducer(queue);
				TextMessage newMes = session.createTextMessage();
				String m = "Empty message!!";
				//Get some message from JS or some field
				//String m = request.getParameter("I want to book this appartment");
				newMes.setText(m);
				newMes.setStringProperty("sendTo", "emailCus");//who gonna receive this message 
				
				producer.send(newMes);

				producer.close();
				session.close();
				con.close();
			} catch (Exception e) {
				System.out.println(" Error when sending the message</BR>");
			}
		}

				public void doGet(
					javax.servlet.http.HttpServletRequest request,
					javax.servlet.http.HttpServletResponse response)
					throws javax.servlet.ServletException, java.io.IOException {

					try {
						doPost(request, response);
					} catch (Exception e) {
						System.out.println(
							"JHC ***************************************Error in doGet: "
								+ e);
					}
				}

}
