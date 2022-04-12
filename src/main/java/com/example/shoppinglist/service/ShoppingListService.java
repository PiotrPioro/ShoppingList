package com.example.shoppinglist.service;

import com.example.shoppinglist.entity.Product;
import com.example.shoppinglist.repository.ShoppingListRepository;
import com.example.shoppinglist.entity.ShoppingList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingList getShoppingListById(Long id) {
        return shoppingListRepository.getById(id);
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

    public void addProductToList(Long id, Product product){
        ShoppingList shoppingList = getShoppingListById(id);
        List<Product> productList = shoppingList.getProductList();
        productList.add(product);
        shoppingList.setProductList(productList);
        update(shoppingList);
    }
}
