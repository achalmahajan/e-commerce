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


    XmlParser xmlParser = new XmlParser();

    public List<Item> getAllItems(){
        return xmlParser.getItems();
    }

    public Item getItem(String title){
        return xmlParser.getItems().stream().filter(i -> i.getTitle().equals(title)).findFirst().get();
    }
}
