package com.ex.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/login")
    Map<String, Object> login(String username, String password){
        //todo spring security
        Map<String, Object> maps = new HashMap<>();
        maps.put("username", "user");
        maps.put("password", "pass");
        return maps;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/test")
    String test(String username, String password){
        return "val from spring";
    }

}
