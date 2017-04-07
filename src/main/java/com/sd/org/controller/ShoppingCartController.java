package com.sd.org.controller;

import com.sd.org.model.Item;
import com.sd.org.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Achal on 4/4/17.
 */
@RestController

public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/{userId}/cart")
    public List<Item> getAllCartItems(@PathVariable int userId){
        return shoppingCartService.getAllCartItems(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/addItem")
    public void addItemToCart(@PathVariable int userId, @RequestBody Item item){
        shoppingCartService.addItem(userId, item);
    }
}
