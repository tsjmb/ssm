package com.service;

import com.domain.Order;
import com.domain.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> findOrder(int index);

    List<Product> findProductList(int orderId);

    Order findOrderById(int id);

    int[] findOrderNum(int orderId);

    double[] findTotal(int years,int months);

    List<Map<Integer,Double>> findByDay(int years, int months, int days);

    void addOrder(Order order);

    boolean addOrderList(int num,int orderId,int productId);
}
