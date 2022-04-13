package com.example.shoppinglist.service;

import com.example.shoppinglist.entity.Product;
import com.example.shoppinglist.exception.ShoppingListException;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.repository.ShoppingListRepository;
import com.example.shoppinglist.entity.ShoppingList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ProductRepository productRepository;

    public Optional<ShoppingList> getShoppingListById(Long id) {
        return Optional.ofNullable(shoppingListRepository.findShoppingListById(id)).orElseThrow(()-> new ShoppingListException(id));
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

        ShoppingList shoppingList = shoppingListRepository.getById(id);
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
