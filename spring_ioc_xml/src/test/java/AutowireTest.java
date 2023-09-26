import control.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {
    @Test
    public void testXml(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController controller = ioc.getBean(UserController.class);
        controller.saveUser();
    }
}
