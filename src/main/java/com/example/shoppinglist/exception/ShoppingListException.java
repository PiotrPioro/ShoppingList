package com.example.shoppinglist.exception;

public class ShoppingListException extends RuntimeException{

    public ShoppingListException(Long id) {
        super("Could not find shoppingList with id: " + id);
    }
}
