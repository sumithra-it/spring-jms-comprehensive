package hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@SpringBootTest
public class SpringContextTest {
	 @Test
	    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
		 //assertTrue(true);
	 	}
	}