package com.example.shoppinglist.service;

import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.getById(id));
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
