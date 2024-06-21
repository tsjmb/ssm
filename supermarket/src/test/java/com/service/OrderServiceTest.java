package com.service;

import com.config.SpringConfig;
import com.dao.OrderDao;
import com.domain.Order;
import com.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void findOrderTest(){
        for (Order order : orderService.findOrder(0)) {
            System.out.println(order);
        }

    }

    @Test
    public void findProductListTest(){
        for (Product product : orderService.findProductList(1415926)) {
            System.out.println(product);
        }

    }

    @Test
    public void tests(){
        int[] orderNum = orderService.findOrderNum(1415926);
        for (int i = 0; i < orderNum.length; i++) {
            System.out.println(orderNum[i]);
        }
    }

    @Test
    public void test02(){
       Order order = new Order();
       order.setId(1415980);
        Date currentDate = new Date();
        order.setTimes(currentDate);
        System.out.println("当前时间： " + currentDate);
        order.setNum(10);
        order.setTotal(12.56);
        order.setOperator("张三");
        order.setTag("微信");
        orderService.addOrder(order);
    }

    @Test
    public void test00(){
        for (double i : orderService.findTotal(2024, 6)) {
            System.out.println(i);
        }

    }

    @Test
    public void test03(){
        boolean b = orderService.addOrderList(5, 80258611, 2024001);
        System.out.println(b);
    }

    @Test
    public void test01(){

        for (Map<Integer, Double> map : orderService.findByDay(2024, 6, 13)) {
            System.out.println(map);
        }


    }
}
