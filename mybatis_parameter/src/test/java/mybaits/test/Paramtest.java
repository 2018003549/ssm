package mybaits.test;

import Utils.SqlSessionUtils;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paramtest {
    @Test
    public void testSelectAll(){
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        users.forEach(System.out::println);
        session.close();
    }
    @Test
    public void testSelectByID(){
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectByID("admin");
        System.out.println(user);
        session.close();
    }
    @Test
    public void testCheckLogin(){
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
        session.close();
    }
    @Test
    public void testCheckBymap(){
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,Object>map=new HashMap<>();
        //值定义为Object是因为存入的数据既有字符串又有数字
        map.put("username","admin");
        map.put("password",123456);
        User user = mapper.checkByMap(map);
        System.out.println(user);
        session.close();
    }
    @Test
    public void testInsert(){
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(null, "zhangsan", "12131", 32, "m", "37701@qq.cmo");
        mapper.insertUser(user);
        session.close();
    }
    @Test
    public void testCheckByParam(){
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectByParam("zhangsan","12131");
        System.out.println(user);
        session.close();
    }
}
