package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {
    public String selectProduct(Product product){
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("product");

        if(product.getId()!=0){
            sql.WHERE("id=#{id}");
        }
//
        if(product.getSort()!=null&&product.getSort()!=""){
            sql.WHERE("sort=#{sort}");
        }

        if(product.getStatus()!=0){
            sql.WHERE("status=#{status}");
        }
//
//
//        System.out.println(sql.toString());
        return sql.toString();
    }
}
