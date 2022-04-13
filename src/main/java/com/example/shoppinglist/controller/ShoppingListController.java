package com.example.shoppinglist.controller;

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

    @PostMapping
    public ShoppingList addShoppingList(@RequestBody ShoppingList shoppingList){
        return shoppingListService.addShoppingList(shoppingList);
    }

    @GetMapping("/{id}")
    public ShoppingList getShoppingListById(@PathVariable Long id){
        return shoppingListService.getShoppingListById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingList(@PathVariable Long id){
        shoppingListService.deleteProduct(id);
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingLists(){
        return shoppingListService.getAllShoppingList();
    }

    @PutMapping
    public void addProductToList(@RequestParam("id") Long id, @RequestParam("productId") Long productId){
        shoppingListService.addProductToList(id, productId);
    }
}
