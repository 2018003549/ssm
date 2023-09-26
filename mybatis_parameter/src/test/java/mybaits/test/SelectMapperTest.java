package mybaits.test;

import Utils.SqlSessionUtils;
import mapper.SelectMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
@Test
    public void testgetUserByid(){
    SqlSession session = SqlSessionUtils.getSession();
    SelectMapper mapper = session.getMapper(SelectMapper.class);
    User user = mapper.getUserByID(5);
    System.out.println(user);
    session.close();
}
    @Test
    public void testgetAllUser(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        List<User> users = mapper.getAlluser();
        System.out.println(users);
        session.close();
    }
    @Test
    public void testselectCount(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Integer integer = mapper.selectCount();
        System.out.println(integer);
        session.close();
    }

    @Test
    public void getUserByidtomap(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> integer = mapper.getUserByidtomap(5);
        System.out.println(integer);
        session.close();
    }

    @Test
    public void getallUsertomap(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllusertomap();
        System.out.println(map);
        session.close();
    }
    @Test
    public void getUserByLike(){
        SqlSession session = SqlSessionUtils.getSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        List<User> a = mapper.getUserLike("a");
        System.out.println(a);
        session.close();
    }
}
