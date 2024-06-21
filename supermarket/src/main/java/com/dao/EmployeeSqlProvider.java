package com.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class EmployeeSqlProvider {
    public String selectInfo(@Param("id") Integer id, @Param("name") String name){
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("employee");

        if(id!=null){
            id=(int) id;
            sql.WHERE("id=#{id}");
        }

        if(name!=null){
//            sql.OR();
            sql.WHERE("name=#{name}");
        }

//        System.out.println(sql.toString());
        return sql.toString();
    }
}
