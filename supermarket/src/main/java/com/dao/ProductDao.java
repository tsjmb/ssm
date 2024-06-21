package com.dao;

import com.domain.Employee;
import com.domain.Product;
import org.apache.ibatis.annotations.*;

import java.lang.reflect.Array;
import java.util.List;

public interface ProductDao {
    @Select("select * from product limit #{index},6")
    List<Product> selectByIndex(int index);

    @Update("update product set name=#{name},purchasePrice=#{purchasePrice},price=#{price},sort=#{sort},status=#{status},inventory=#{inventory},number=#{number},url=#{url} where id=#{id}")
    void updateById(Product product);

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @SelectProvider(type = ProductSqlProvider.class,method = "selectProduct")
    List<Product> selectProduct(Product product);

    @Select("select count(*) from product")
    int selectLength();

    @Select("select sum(inventory) from product where `status`=1 UNION select sum(inventory) from product where `status`=2")
    int[] selectInventory();

    @Select("select * from product where id=#{id}")
    Product selectById(int id);

    @Insert("insert into product values (#{id},#{name},#{purchasePrice},#{price},#{sort},#{status},#{inventory},#{number},#{url})")
    void insertProduct(Product product);
}
