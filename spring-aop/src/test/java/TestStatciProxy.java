import Cal.CalculatorStaticProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStatciProxy {
    @Test
    public void testStatic(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        CalculatorStaticProxy proxy = ioc.getBean(CalculatorStaticProxy.class);
        proxy.add(3,9);

    }
}
