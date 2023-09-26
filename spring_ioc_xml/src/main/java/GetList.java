import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.student;

import java.util.List;

public class GetList {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc.xml");
        student student= (pojo.student) ioc.getBean("two");
        List<Integer> arrayList = student.getArrayList();
        System.out.println(arrayList);
    }
}
