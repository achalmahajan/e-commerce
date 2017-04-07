package com.sd.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Achal on 4/6/17.
 */
@Controller
public class MainController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homePage(){
        return "Search";
    }
}
