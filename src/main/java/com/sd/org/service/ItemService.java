package com.sd.org.service;

import com.sd.org.model.Item;
import com.sd.org.parser.XmlParser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Achal on 4/4/17.
 */
@Service
public class ItemService {

//    private List<Item> items = Arrays.asList(
//            new Item( "First Item", "First Item Link", "First Item description"),
//            new Item( "Second Item", "Second Item Link", "Second Item description"),
//            new Item( "Third Item", "Third Item Link", "Third Item description"));

    XmlParser xmlParser = new XmlParser();

    public List<Item> getAllItems(){
        return xmlParser.getItems();
    }

//    public Item getItem(String title){
//        return items.stream().filter(i -> i.getTitle().equals(title)).findFirst().get();
//    }
}
