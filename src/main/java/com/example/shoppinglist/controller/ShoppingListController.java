package com.example.shoppinglist.controller;

import com.example.shoppinglist.entity.Product;
import com.example.shoppinglist.entity.ShoppingList;
import com.example.shoppinglist.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingList")
@AllArgsConstructor
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @PostMapping("/add")
    public ShoppingList addShoppingList(@RequestBody ShoppingList shoppingList){
        return shoppingListService.addShoppingList(shoppingList);
    }

    @GetMapping("/show")
    public ShoppingList getShoppingListById(@RequestParam("id") Long id){
        return shoppingListService.getShoppingListById(id);
    }

    @DeleteMapping("/delete")
    public void deleteShoppingList(@RequestParam("id") Long id){
        shoppingListService.deleteProduct(id);
    }

    @GetMapping("/showAllShoppingLists")
    public List<ShoppingList> getAllShoppingLists(){
        return shoppingListService.getAllShoppingList();
    }

    @PutMapping("/addProduct")
    public void addProductToList(@RequestParam("id") Long id, @RequestParam("productId") Long productId){
        shoppingListService.addProductToList(id, productId);
    }
}
