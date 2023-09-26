import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.UserFactoryBean;
import pojo.student;

public class TestFactory {
    @Test
    public void testFactoryBean(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("factoryBeanTest.xml");
        student bean = ioc.getBean(student.class);
        System.out.println(bean.toString());
    }
}
