import Utils.SqlSessionUtils;
import mapper.CacheMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Emp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CacheTest {
    @Test
    public void getEmp(){
        SqlSession session1 = SqlSessionUtils.getSession();
        CacheMapper mapper = session1.getMapper(CacheMapper.class);
        CacheMapper mapper1 = session1.getMapper(CacheMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(2);
        List<Emp> empByCondition1 = mapper.getEmpByCondition(2);
        List<Emp> empByCondition4 = mapper1.getEmpByCondition(2);
        System.out.println(empByCondition);
        System.out.println(empByCondition1);
        System.out.println(empByCondition4);
        List<Emp> empByCondition2 = mapper.getEmpByCondition(3);
        System.out.println(empByCondition2);
        SqlSession session2 = SqlSessionUtils.getSession();
        CacheMapper mapper2 = session2.getMapper(CacheMapper.class);
        List<Emp> empByCondition3 = mapper2.getEmpByCondition(2);
        System.out.println(empByCondition3);
    }
    @Test
    public void getEmp2() throws IOException {
        //获取核心配置文件输入流（resources选用org.apache.io）
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象，通过输入流获取
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession，该对象用于操作数据库
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        mapper.getEmpByCondition(3);
        mapper1.getEmpByCondition(3);
    }
}
