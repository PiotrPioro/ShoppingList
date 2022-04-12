package com.example.shoppinglist.controller;

import com.example.shoppinglist.entity.Product;
import com.example.shoppinglist.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/show")
    public Product getProductById(@RequestParam("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/showAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
