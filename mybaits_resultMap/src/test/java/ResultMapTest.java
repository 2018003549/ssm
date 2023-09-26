import Utils.SqlSessionUtils;
import mapper.DeptMapper;
import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Dept;
import pojo.Emp;

public class ResultMapTest {
    @Test
    public void selectTest(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByID(2);
        System.out.println(emp);
        session.close();
    }
    @Test
    public void selectEmpDept(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpAndDept(2);
        System.out.println(emp);
        session.close();
    }
    @Test
    public void selectEandDByStep(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpAndDeptStep1(2);
        System.out.println(emp.getEmpID());
        session.close();
    }
    @Test
    public void selectDeptAndEmp(){
        SqlSession session = SqlSessionUtils.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
        session.close();
    }

    @Test
    public void selectDeptAndEmpByStep(){
        SqlSession session = SqlSessionUtils.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptAndEmpStep1(1);
        System.out.println(dept);
        session.close();
    }
}
