package controller;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Employee;

import java.util.Collection;
import java.util.List;

@Controller
public class TestEmployeeController {
    @Autowired
    EmployeeDao dao;
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployees(Model model){
        //获取员工列表
        Collection<Employee> all = dao.getAll();
        model.addAttribute("employeeList",all);
        return "employee_list";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        dao.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String showEmployee(@PathVariable("id") Integer id, Model model){
        Employee emp = dao.get(id);//获取到该id的员工信息
        model.addAttribute("employee",emp);//将该员工信息存入请求域
        return "employee_update";//转发到修改页面
    }
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String showEmployee(Employee employee, Model model){
        dao.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        dao.delete(id);
        return "redirect:/employee";
    }
}
