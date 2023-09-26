import aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAop {
    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-aop-xml.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.div(5,1);
    }
}
