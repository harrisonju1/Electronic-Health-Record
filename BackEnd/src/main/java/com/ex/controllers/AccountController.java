package com.ex.controllers;

import com.ex.beans.User;
import com.ex.dao.UserDao;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/login")
    Map<String, Object> login(String username, String password){

        Map<String, Object> maps = new HashMap<>();
        maps.put("username", "user");
        maps.put("password", "pass");
        return maps;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/authorize")
    // checks to make sure the username and password match
    // returns the user if true
    // otherwise returns null
    Object authorize(@RequestBody String cred){
        String username = cred.split(":")[0];
        String password = cred.split(":")[1];
        System.out.println("login attempt:"+username+" "+password);
        User found = new UserDao().findOne(username);
        if (found!=null && found.getPassword().equals(password)) {
            return found;
        }
        return null;
    }
}
