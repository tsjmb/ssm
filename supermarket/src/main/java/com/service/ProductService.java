package com.service;

import com.domain.Product;

import java.lang.reflect.Array;
import java.util.List;

public interface ProductService {
    List<Product> findProduct(int index);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    List<Product> findByIDAndOther(Product product);

    int findProductLength();

    int[] findInventory();

    Product findProductById(int id);

    boolean addProduct(Product product);
}
