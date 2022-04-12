package com.example.shoppinglist.repository;

import com.example.shoppinglist.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    @Query("select sh from ShoppingList sh where sh.id = ?1")
    ShoppingList findShoppingListById(Long id);
}
