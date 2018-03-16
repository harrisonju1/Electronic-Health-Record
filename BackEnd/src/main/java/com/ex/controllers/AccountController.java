package com.ex.controllers;

import com.ex.beans.User;
import com.ex.dao.UserDao;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    // checks to make sure the username and password match
    // returns the user if true
    // otherwise returns null
    @RequestMapping("/api/authorize")
    Object authorize(@RequestBody String cred){
        String username = cred.split(":")[0];
        String password = cred.split(":")[1];
        System.out.println("login attempt: u:"+username+", p:"+password);
        User found = new UserDao().findOne(username);
        if (found!=null && found.getPassword().equals(password)) {
            return found;
        }
        return null;
    }
}
