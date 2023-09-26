package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    PageInfo<Employee> getPage(Integer pageNum);
}
