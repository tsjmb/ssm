package com.dao;

import com.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeDao {

    @Select("select * from employee")
    List<Employee> selectAll();

    @Select("select * from employee limit #{index},9")
    List<Employee> selectPage(int index);

    @Delete("delete from employee where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from employee where uid=#{uid}")
    Employee selectById(Integer uid);


//    @Insert("insert into employee values (#{id},#{name},#{sex},#{age},#{phone},#{province},#{city},#{county})")
//    void insertEmployee(Employee employee);

    @Update("update employee set name=#{name},sex=#{sex},age=#{age},phone=#{phone},province=#{province},city=#{city},county=#{county} where id=#{id}")
    void updateById(Employee employee);

    @SelectProvider(type = EmployeeSqlProvider.class,method = "selectInfo")
    Employee selectInfo(@Param("id") Integer id,@Param("name") String name);

    @Select("select count(*) from employee")
    int selectNum();
}
