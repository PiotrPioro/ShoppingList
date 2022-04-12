package com.example.shoppinglist.service;

import com.example.shoppinglist.entity.ShoppingList;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.entity.Product;
import com.example.shoppinglist.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ShoppingListRepository shoppingListRepository;

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.getById(id);
        List<ShoppingList> shoppingLists = shoppingListRepository.findAll();

        for(ShoppingList s : shoppingLists){
            List<Product> productList = s.getProductList();
            for(Product p : productList){
                if(p.equals(product)){
                    productList.remove(p);
                }
            }
        }
        productRepository.delete(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
