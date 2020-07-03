package hello;
import javax.jms.Queue;
import org.springframework.jms.core.JmsTemplate;

public class JmsMessageSender {
	private JmsTemplate jmsTemplate;
	private Queue queue;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	
	public void sendMessage(final Email email) {
		jmsTemplate.convertAndSend(email);
	}
	public void simpleSend() {
		jmsTemplate.send(queue, s -> s.createTextMessage("Hello Good morning Sumithra"));
	}
	public void sendTextMessage(String msg) {
		jmsTemplate.send(queue, s -> s.createTextMessage(msg));
	}
}
