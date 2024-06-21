package com.controller;

import com.domain.Product;
import com.service.ProductService;
import com.utils.Code;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Result getProductList(int index){
        List<Product> products = productService.findProduct(index);
        return new Result(Code.GET_OK,products);
    }

    @PutMapping
    public Result updateProductInfo(@RequestBody Product product){
        boolean flag = productService.updateProduct(product);
        return new Result(Code.UPDATE_OK,flag);
    }

    @DeleteMapping("/{id}")
    public Result deleteProductInfo(@PathVariable int id){
        boolean flag = productService.deleteProduct(id);
        return new Result(Code.DELETE_OK,flag);
    }

    @PostMapping
    public Result searchProduct(@RequestBody Product product){
//        System.out.println(product);
        List<Product> products = productService.findByIDAndOther(product);
        return new Result(Code.GET_OK,products);
    }

    @PostMapping("/add")
    public Result addProductInfo(@RequestBody Product product){
        boolean b = productService.addProduct(product);
        return new Result(Code.GET_OK,b);
    }


    @GetMapping("/length")
    public Result getProductLength(){
        int len = productService.findProductLength();
        return new Result(Code.GET_OK,len);
    }

    @GetMapping("/inventory")
    public Result getProductInventory(){
        int[] inventory = productService.findInventory();
        return new Result(Code.GET_OK,inventory);
    }

    @GetMapping("/{id}")
    public Result getProductById(@PathVariable int id){
        Product product = productService.findProductById(id);
        return new Result(Code.GET_OK,product);
    }
}
