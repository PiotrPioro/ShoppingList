package com.example.shoppinglist.service;

import com.example.shoppinglist.entity.Product;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.repository.ShoppingListRepository;
import com.example.shoppinglist.entity.ShoppingList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ProductRepository productRepository;

    public ShoppingList getShoppingListById(Long id) {
        return shoppingListRepository.findShoppingListById(id);
    }

    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public void deleteProduct(Long id) {
        shoppingListRepository.delete(shoppingListRepository.getById(id));
    }

    public void update(ShoppingList shoppingList){
        shoppingListRepository.save(shoppingList);
    }

    public List<ShoppingList> getAllShoppingList(){
        return shoppingListRepository.findAll();
    }

    public void addProductToList(Long id, Long productId){

        ShoppingList shoppingList = getShoppingListById(id);
        Product product = productRepository.getById(productId);
        List<Product> productList = new LinkedList<>();

        if(shoppingList.getProductList() != null){
            productList = shoppingList.getProductList();
        }

        productList.add(product);
        shoppingList.setProductList(productList);
        update(shoppingList);
    }
}
