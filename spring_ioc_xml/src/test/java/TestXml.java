import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.student;

public class TestXml {
    @Test
    public void testXml(){
        //获取ioc容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring_ioc.xml");
        //获取bean
        student studentOne = (student) ioc.getBean("studentOne");
        System.out.println(studentOne);
    }
}
