import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    @Test
    public void test(){
        //获取ioc容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取容器中的bean
        helloword bean = (helloword)ioc.getBean("helloFirst");
        bean.sayHello();
    }
}
