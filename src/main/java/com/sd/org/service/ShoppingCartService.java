package com.sd.org.service;

import com.sd.org.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Achal on 4/4/17.
 */
@Service
public class ShoppingCartService {

    private List<Item> cart = Arrays.asList(
            new Item("First Item", "First Item Link", "First Item description"),
            new Item( "Third Item", "Third Item Link", "Third Item description"));

    private List<Item> cart2 = Arrays.asList(
            new Item( "Second Item", "Second Item Link", "Second Item description"),
            new Item("Third Item", "Third Item Link", "Third Item description"));

    private HashMap<Integer,List<Item>> cartMap = new HashMap<Integer, List<Item>>(){{
        put(1,cart);
        put(2,cart2);
    }};


    public List<Item> getAllCartItems(int userId){
        return cartMap.get(userId);
    }



    public void addItem(int userId, Item item){

        if(cartMap.containsKey(userId)){
            List<Item> list = getAllCartItems(userId);
            list.add(item);
            cartMap.put(userId,list);
        }else{
//            List<Item> list = new ArrayList<Item>(item);
//            cartMap.put(userId, list);

        }

    }

}
