package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    public static SqlSession getSession(){
        SqlSession sqlSession=null;
        try {
            //获取核心配置文件输入流（resources选用org.apache.io）
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory对象，通过输入流获取
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sql的会话对象SqlSession，该对象用于操作数据库
            sqlSession = sqlSessionFactory.openSession(true);
            //获取mapper接口的代理实现类对象
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
