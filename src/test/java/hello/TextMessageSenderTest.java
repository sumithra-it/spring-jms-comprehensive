package hello;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextMessageSenderTest {

	    private static JmsMessageSender jmsMessageSender;
	    private static JmsMessageListener jmsMessageListener;

	    @SuppressWarnings("resource")
	    @BeforeClass
	    public static void setUp() {
	        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:EmbeddedActiveMQ.xml", "classpath:applicationContext.xml");
	        jmsMessageSender = (JmsMessageSender) applicationContext.getBean("jmsMessageSender");
	        jmsMessageListener = (JmsMessageListener) applicationContext.getBean("messageListener");
	    }

	    @Test
	    public void testSimpleSend() {
	    	jmsMessageSender.simpleSend();
	    }

	    @Test
	    public void testSendTextMessage() {
	    	jmsMessageSender.sendTextMessage(null);
	    }

}