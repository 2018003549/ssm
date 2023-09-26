import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("dataSource-ioc.xml");
        DruidDataSource druidDataSource = ioc.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getConnection());
    }
}
