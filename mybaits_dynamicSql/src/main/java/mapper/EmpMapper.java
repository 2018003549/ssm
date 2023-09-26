package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Emp;

import java.util.List;

public interface EmpMapper {
List<Emp> getEmpByCondition(Emp emp);

    List<Emp> getEmpByChoose(Emp emp);

    void insertMore(@Param("emps") List<Emp> emps);

    void deleteMore(@Param("ids") Integer[] ids);
}
