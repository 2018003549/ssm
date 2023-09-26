package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

public interface EmpMapper {
    Emp selectByID(int id);

    Emp selectEmpAndDept(@Param("ID") int id);

    /**
     * 分步查询员工及其对应部门的第一步
     * @param id
     * @return
     */
    Emp selectEmpAndDeptStep1(@Param("ID") int id);

    /**
     * 分步查询部门以及对应员工的第二步
     * @param deptId
     * @return
     */
    Emp selectDeptAndEmpStep2(@Param("deptId") int deptId);
}
