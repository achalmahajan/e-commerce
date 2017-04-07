package com.sd.org.controller;

import com.sd.org.model.Item;
import com.sd.org.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Achal on 4/3/17.
 */

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

//    @RequestMapping("/{title}")
//    public Item getItem(@PathVariable String title){
//        return itemService.getItem(title);
//    }
    }
