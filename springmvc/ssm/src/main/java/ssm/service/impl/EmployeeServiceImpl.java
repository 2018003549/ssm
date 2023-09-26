package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.EmployeeMapper;
import ssm.pojo.Employee;
import ssm.service.EmployeeService;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAll() {
        List<Employee> list = employeeMapper.getAllEmployee();
        return list;
    }

    @Override
    public PageInfo<Employee> getPage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
        return pageInfo;
    }
}
