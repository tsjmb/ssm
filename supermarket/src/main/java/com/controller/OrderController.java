package com.controller;

import com.domain.Order;
import com.domain.Product;
import com.service.OrderService;
import com.utils.Code;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public Result getOrder(int index){
        List<Order> orders = orderService.findOrder(index);
        return new Result(Code.GET_OK,orders);
    }

    @GetMapping("/{orderId}")
    public Result getOrderItem(@PathVariable int orderId){
        List<Product> products = orderService.findProductList(orderId);
        return new Result(Code.GET_OK,products);
    }

    @PostMapping("/{id}")
    public Result getOrderById(@PathVariable int id){
        Order order = orderService.findOrderById(id);
        return new Result(Code.GET_OK,order);
    }

    @GetMapping("/num")
    public Result getOrderNum(int orderId){
        int[] array = orderService.findOrderNum(orderId);
        return new Result(Code.GET_OK,array);
    }


    @PostMapping("/total")
    public Result getOrderTotal(int years,int months){
        double[] total = orderService.findTotal(years, months);
        return new Result(Code.GET_OK,total);
    }

    @PostMapping("/num")
    public Result getOrderByDay(int years,int months,int days){
        List<Map<Integer, Double>> byDay = orderService.findByDay(years, months, days);
        return new Result(Code.GET_OK,byDay);
    }

    @PostMapping("/add")
    public Result addOrderInfo(@RequestBody Order order){
        orderService.addOrder(order);
        return new Result(Code.SAVE_OK,true);
    }

    @PostMapping("/order_list")
    public Result addOrderList(int num,int orderId,int productId){
        boolean flag = orderService.addOrderList(num, orderId, productId);
        return new Result(Code.SAVE_OK,flag);
    }
}
