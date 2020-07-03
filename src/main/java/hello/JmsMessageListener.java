package hello;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jms.JMSException;
import java.util.Map;

public class JmsMessageListener implements MessageListener {

	private JmsTemplate jmsTemplate;
	private Queue queue;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			
			try {
				String msg = ((TextMessage) message).getText();		
				System.out.println("Received message: " + msg);
				if (msg == null) throw new IllegalArgumentException("Null received...");
			} catch(JMSException e) {
				throw new RuntimeException(e);
			}
		}//end if
	}
	
	//for receiving custom messages
	public Email receiveMessage() throws JMSException {
		Map map = (Map) jmsTemplate.receiveAndConvert();
		return new Email((String)map.get("to"), (String)map.get("body"));
	}

}
