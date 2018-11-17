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
				// Now use the session to create a message producer associated to the queue
				MessageProducer producer = session.createProducer(queue);
				 // Now use the session to create a text message
				TextMessage newMes = session.createTextMessage();
				//  We retrieve the parameter 'message' from the request, and use it as text of our message
				String m = request.getParameter("I want to book this appartment");	//here
				newMes.setText(m);
				//newMes.setStringProperty("sendTo", request.getSession().get);//who gonna receive this message 
				// Use the message producer to send the message						messageProducer.send(textMessage);
				producer.send(newMes);
				
				//waiting for response 

				// Close the producer
				producer.close();
				// Close the session 
				session.close();
				// Close the connection 
				con.close();
				System.out.println(" Menssage sent </BR>");

			} catch (javax.jms.JMSException e) {
				System.out.println(
					"JHC *************************************** Error in doPost: "
						+ e);
				System.out.println(
					"JHC *************************************** Error MQ: "
						+ e.getLinkedException().getMessage());
				System.out.println(
					"JHC *************************************** Error MQ: "
						+ e.getLinkedException().toString());		
				System.out.println(" Error when sending the message</BR>");
		
				
			}catch (Exception e) {
				System.out.println(
					"JHC *************************************** Error in doPost: "
						+ e.toString());
				System.out.println(" Error when sending the message</BR>");
				
			}
			
			System.out.println(
			" >>>>>>  <A href=\"SendMessageToQueue.html\">Back</A></P>");
			System.out.println("</body></html>");
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
