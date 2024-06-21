package com.service.impl;

import com.dao.ProductDao;
import com.domain.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findProduct(int index) {
        List<Product> products = productDao.selectByIndex(index);
        return products;
    }

    @Override
    public boolean updateProduct(Product product) {
        productDao.updateById(product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        productDao.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findByIDAndOther(Product product) {
        List<Product> products = productDao.selectProduct(product);
        return products;
    }

    @Override
    public int findProductLength() {
        int len = productDao.selectLength();
        return len;
    }

    @Override
    public int[] findInventory() {
        int[] array = productDao.selectInventory();
        return array;
    }

    @Override
    public Product findProductById(int id) {
        return productDao.selectById(id);
    }

    @Override
    public boolean addProduct(Product product) {
        productDao.insertProduct(product);
        return true;
    }
}
