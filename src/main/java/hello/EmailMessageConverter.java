package hello;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
public class EmailMessageConverter implements MessageConverter{

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		Email email = (Email) object;
		MapMessage mapmsg = session.createMapMessage();
		mapmsg.setString("to", email.getTo());
		mapmsg.setString("body", email.getBody());
		return mapmsg;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		MapMessage mapmsg = (MapMessage) message;
		return new Email(mapmsg.getString("to"), mapmsg.getString("body"));
	}

}
