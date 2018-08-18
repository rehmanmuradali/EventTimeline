package com.rehman.timeline.controller;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;

@RestController
public class HelloWorldContainer {


    @RequestMapping("/")
    public String greeting(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Greetings to " + name;
    }



}
