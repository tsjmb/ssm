package com.service.impl;

import com.dao.OrderDao;
import com.domain.Order;
import com.domain.Product;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findOrder(int index) {
        List<Order> orders = orderDao.selectAll(index);
        return orders;
    }

    @Override
    public List<Product> findProductList(int orderId) {
        List<Product> products = orderDao.selectProductList(orderId);
        return products;
    }

    @Override
    public Order findOrderById(int id) {
        Order order = orderDao.selectById(id);
        return order;
    }

    @Override
    public int[] findOrderNum(int orderId) {
        int[] arr = orderDao.selectNum(orderId);
        return arr;
    }

    @Override
    public double[] findTotal(int years, int months) {
        double[] total = orderDao.selectTotal(years, months);
        return total;
    }

    @Override
    public List<Map<Integer,Double>> findByDay(int years, int months, int days) {
        List<Map<Integer,Double>> list = orderDao.selectByDay(years, months, days);
        return list;
    }

    @Override
    public void addOrder(Order order) {
        orderDao.insertOrder(order);
    }

    @Override
    public boolean  addOrderList(int num, int orderId, int productId) {
        orderDao.insertOrderList(num, orderId, productId);
        return true;
    }
}
