import aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAnnotation {
    @Test
    public void testBefore(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,55);
    }
}
