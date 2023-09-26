import com.study.Utils.SqlSessionUtils;
import com.study.mapper.EmpMapper;
import com.study.pojo.Emp;
import com.study.pojo.EmpExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MbgTest {
    @Test
    public void SelectByPrimaryKey(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(2);
        System.out.println(emp);
        session.close();
    }
    @Test
    public void Select(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        /*//查询所有
        List<Emp> emps = mapper.selectByExample(null);*/
        EmpExample example = new EmpExample();
        example.createCriteria().andAgeBetween(20,30).andEmpNameLike("%三%");
        example.or().andEmpNameLike("李四");
        List<Emp> emps = mapper.selectByExample(example);
        System.out.println(emps);
        session.close();
    }

}
