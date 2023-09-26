package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Dept;
import pojo.Emp;

public interface DeptMapper {


    /**
     * 分步查询员工及其对应部门的第二步
     * @return
     */
    Dept selectEmpAndDeptStep2(@Param("deptID") int deptID);

    /**
     * 查询当前部门以及部门的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") int deptId);

    /**
     * 分步查询部门以及对应员工的第一步
     * @param deptId
     * @return
     */
    Dept selectDeptAndEmpStep1(@Param("deptId") int deptId);
}
