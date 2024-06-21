package com.service;

import com.config.SpringConfig;
import com.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void findAllEmployeeTest(){
        for (Employee employee : employeeService.findAllEmployee()) {
            System.out.println(employee);
        }

    }

    @Test
    public void deleteEmployeeTest(){
        Boolean flag = employeeService.removeEmployee(1);
        System.out.println(flag);
    }

    @Test
    public void findPageTest(){
        for (Employee employee : employeeService.findPage(0)) {
            System.out.println(employee);
        }

    }

    @Test
    public void updateEmployeeTest(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setAge(18);
        employee.setCity("罗田县");
        employee.setCounty("黄冈市");
        employee.setProvince("湖北省");
        employee.setName("aaa");
        employee.setPhone("15289634123");
        employee.setSex('男');
        boolean b = employeeService.updateEmployee(employee);
        System.out.println(b);
    }

    @Test
    public void findByIdAndNameTest(){
        Employee byIdAndName = employeeService.findByIdAndName(1, null);
        System.out.println(byIdAndName);
    }

    @Test
    public void test(){
        int employeeNum = employeeService.findEmployeeNum();
        System.out.println(employeeNum);
    }
}
