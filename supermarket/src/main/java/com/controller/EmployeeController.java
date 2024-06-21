package com.controller;

import com.domain.Employee;
import com.service.EmployeeService;
import com.utils.Code;
import com.utils.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping
//    public Result getAllEmployee(){
//        List<Employee> allEmployee = employeeService.findAllEmployee();
//        return new Result(Code.GET_OK,allEmployee);
//    }

    @DeleteMapping("/{id}")
    public Result deleteEmployee(@PathVariable Integer id){
//        System.out.println("进入了删除方法");
        Boolean flag = employeeService.removeEmployee(id);
        return new Result(Code.DELETE_OK,flag);
    }

//    @PostMapping
//    public Result createEmployee(@RequestBody Employee employee){
////        System.out.println("进入了添加员工方法");
//        boolean flag = employeeService.addEmployee(employee);
//        return new Result(Code.SAVE_OK,flag);
//    }

    @GetMapping("/page")
    public Result getPageEmployee(int index){
        List<Employee> employees = employeeService.findPage(index);
        return new Result(Code.GET_OK,employees);
    }

    @GetMapping()
    public Result getEmployeeInfo(@RequestParam(required = false,name = "id") Integer id,@RequestParam(required = false,name = "name") String name){
//        System.out.println("进入了搜索方法中");
//        System.out.println(id);
//        System.out.println(name);
        Employee employee = employeeService.findByIdAndName(id, name);
        return new Result(Code.GET_OK,employee);
    }

    @PutMapping
    public Result updateEmployeeInfo(@RequestBody Employee employee){
//        System.out.println("进入了更新方法中");
        boolean flag = employeeService.updateEmployee(employee);
        return new Result(Code.UPDATE_OK,flag);
    }

    @GetMapping("/num")
    public Result getEmployeeNum(){
        int employeeNum = employeeService.findEmployeeNum();
        return new Result(Code.GET_OK,employeeNum);
    }

    @GetMapping("/getId")
    public Result getEmployeeById(int uid){
        Employee employee = employeeService.findById(uid);
        return new Result(Code.GET_OK,employee);
    }

}
