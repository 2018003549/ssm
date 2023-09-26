package mybaits.test;

import Utils.SqlSessionUtils;
import mapper.SelectMapper;
import mapper.SpecialSqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;

import java.util.List;
import java.util.Map;

public class SpecialSql {
@Test
    public void testDeleteMore(){
    SqlSession session = SqlSessionUtils.getSession();
    SpecialSqlMapper mapper = session.getMapper(SpecialSqlMapper.class);
    mapper.deleteMore("9,10");
    session.close();
}
    @Test
    public void testTablename(){
        SqlSession session = SqlSessionUtils.getSession();
        SpecialSqlMapper mapper = session.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getList("t_user");
        System.out.println(list);
        session.close();
    }

    @Test
    public void testinsert(){
        SqlSession session = SqlSessionUtils.getSession();
        SpecialSqlMapper mapper = session.getMapper(SpecialSqlMapper.class);
        User user=new User(null,"admin","123456",23,"男","12345@qq.com");
        mapper.insert(user);
        System.out.println(user);
        session.close();
    }
}
