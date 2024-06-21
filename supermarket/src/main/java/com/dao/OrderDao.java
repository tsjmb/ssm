package com.dao;

import com.domain.Order;
import com.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDao {

    @Select("select * from `order` order by times desc limit #{index},9")
    List<Order> selectAll(int index);

    @Select("select product.id,product.name,product.price from product,order_list where order_list.orderId=#{orderId} and product.id=order_list.productId")
    List<Product> selectProductList(int orderId);

    @Select("select * from `order` where id=#{id}")
    Order selectById(int id);

    @Select("select num from order_list where orderId=#{orderId}")
    int[] selectNum(int orderId);


    @SelectProvider(type = OrderSqlProvider.class, method = "selectByDay")
    List<Map<Integer, Double>> selectByDay(@Param("years") int years, @Param("months") int months, @Param("days") int days);

    @SelectProvider(type = OrderSqlProvider.class, method = "selectTotal")
    double[] selectTotal(@Param("years") int years, @Param("months") int months);

    @Insert("insert into `order` values(#{times},#{id},#{num},#{operator},#{tag},#{total})")
    void insertOrder(Order order);

    @Insert("insert into `order_list` values (null,#{num},#{orderId},#{productId})")
    void insertOrderList(@Param("num") int num,@Param("orderId") int orderId,@Param("productId") int productId);
}