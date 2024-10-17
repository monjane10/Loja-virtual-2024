package com.dev.Backend.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class hello {

    @GetMapping("/")
    public String Hello(){
        return "Olá Mundo, Sou Lourenço Monjane" + new Date();
    }
    
}
