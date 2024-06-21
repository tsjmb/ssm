package com.service;

import com.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();

    Boolean removeEmployee(Integer id);

    Employee findById(Integer id);

//    boolean addEmployee(Employee employee);

    List<Employee> findPage(int index);

    boolean updateEmployee(Employee employee);

    Employee findByIdAndName(Integer id,String name);

    int findEmployeeNum();
}
