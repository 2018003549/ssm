package test;

import Utils.SqlSessionUtils;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
        @Test
        public void testInsert() throws IOException {
            SqlSession sqlSession = SqlSessionUtils.getSession();
            //获取mapper接口的代理实现类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//传入某类型的class对象，返回该类型的实例化对象
            /*接口不能直接创建对象*/
            //调用接口中的方法
            int result = mapper.insertUser();
            System.out.println("结果"+result);
            sqlSession.close();//关闭会话对象
        }
        @Test
    public void testSelectone() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//传入某类型的class对象，返回该类型的实例化对象
        /*接口不能直接创建对象*/
        //调用接口中的方法
        User user = mapper.selectUserByid();
        System.out.println(user);
        sqlSession.close();//关闭会话对象
    }
    @Test
    public void updateUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//传入某类型的class对象，返回该类型的实例化对象
        /*接口不能直接创建对象*/
        //调用接口中的方法
        int result = mapper.updateUser();
        System.out.println(result);
        sqlSession.close();//关闭会话对象
    }
    @Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSession();
        //获取mapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//传入某类型的class对象，返回该类型的实例化对象
        /*接口不能直接创建对象*/
        //调用接口中的方法
        List<User> user = mapper.selectAll();
        user.forEach(System.out::println);
        sqlSession.close();//关闭会话对象
    }
}
