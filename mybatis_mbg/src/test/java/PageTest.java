import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.Utils.SqlSessionUtils;
import com.study.mapper.EmpMapper;
import com.study.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void textPage(){
        SqlSession session = SqlSessionUtils.getSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Page<Object> page = PageHelper.startPage(2, 4);
        List<Emp> emps = mapper.selectByExample(null);
        System.out.println(page);
        session.close();
    }
}
