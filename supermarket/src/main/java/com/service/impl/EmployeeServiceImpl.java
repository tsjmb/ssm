package com.service.impl;

import com.dao.EmployeeDao;
import com.domain.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.selectAll();
    }

    @Override
    public Boolean removeEmployee(Integer id) {
        employeeDao.deleteById(id);
        return true;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeDao.selectById(id);
        return employee;
    }

//    @Override
//    public boolean addEmployee(Employee employee) {
//        employeeDao.insertEmployee(employee);
//        return true;
//    }

    @Override
    public List<Employee> findPage(int index) {
        List<Employee> employees = employeeDao.selectPage(index);
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        employeeDao.updateById(employee);
        return true;
    }

    @Override
    public Employee findByIdAndName(Integer id, String name) {
        Employee employee = employeeDao.selectInfo(id, name);
        return employee;
    }

    @Override
    public int findEmployeeNum() {
        int num = employeeDao.selectNum();
        return num;
    }
}
