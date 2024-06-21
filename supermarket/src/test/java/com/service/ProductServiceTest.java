package com.service;

import com.config.SpringConfig;
import com.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Array;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findProductTest(){
        for (Product product : productService.findProduct(6)) {
            System.out.println(product);
        }
    }

    @Test
    public void updateProductTest(){
        Product product = new Product();
//        product.setId(2024007);
        product.setName("zhangsan");
        product.setPurchasePrice(12);
        product.setPrice(12);
        product.setSort("baidu");
        product.setStatus(1);
        product.setInventory(12);
        product.setNumber(12);
        product.setUrl("12");
        System.out.println(product);
//        boolean b = productService.updateProduct(product);
//        System.out.println(b);
    }

    @Test
    public void deleteProduct(){
        boolean b = productService.deleteProduct(2024007);
        System.out.println(b);
    }

    @Test
    public void findByIDAndOther(){
        Product product = new Product();
        product.setId(2024002);
//        product.setSort("百货");
        product.setStatus(1);
        System.out.println(product);
        for (Product product1 : productService.findByIDAndOther(product)) {
            System.out.println(product1);
        }
    }

    @Test
    public void findInventoryTest(){
        int[] arrays = productService.findInventory();
        for (int i = 0; i<arrays.length ; i++) {
            System.out.println(arrays[i]);
        }
    }

    @Test
    public void test(){
        Product product = productService.findProductById(2024001);
        System.out.println(product);
    }

    @Test
    public void tests(){
        Product product = new Product();
        product.setSort("家用");
        product.setPurchasePrice(19.98);
        product.setName("洁丽雅 GRACE 一次性棉柔洗脸巾 擦脸洁 面 抽纸式 干湿两用80片/包");
        boolean b = productService.addProduct(product);
        System.out.println(b);
    }
}
