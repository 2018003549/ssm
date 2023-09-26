import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-JdbcTemplate.xml")
public class TestJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test//测试增删改功能
    public void testUpdate(){
        String sql = "insert into t_emp values(null,?,?,?,1)";
        int result = jdbcTemplate.update(sql, "张三", 23, "男");
        System.out.println(result);
    }
}
