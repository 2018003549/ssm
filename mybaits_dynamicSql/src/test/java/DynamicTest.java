import Utils.SqlSessionUtils;
import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Emp;

import java.util.Arrays;
import java.util.List;

public class DynamicTest {
    @Test
    public void testGetEmpByconditon(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getEmpByCondition(new Emp(null, "", null, ""));
        emps.forEach(System.out::println);
        session.close();
    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null, "", null, ""));
        emps.forEach(System.out::println);
        session.close();
    }

    @Test
    public void testinsertMore(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp(null, "无敌", 18, "男");
        Emp emp1 = new Emp(null, "无惧怕", 18, "男");
        Emp emp2 = new Emp(null, "无忧", 16, "男");
        List<Emp> list = Arrays.asList(emp, emp1, emp2);
        mapper.insertMore(list);
        session.close();
    }
    @Test
    public void testdeleteMore(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        mapper.deleteMore(new Integer[]{9,7});
        session.close();
    }
}
