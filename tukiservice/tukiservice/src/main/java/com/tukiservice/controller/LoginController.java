package com.tukiservice.controller;

import com.tukiservice.models.user.UserEntity;
import com.tukiservice.repositories.user.UserEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    UserEntityDAO userEntityDAO;
    @PostMapping
    public String loginUser(@RequestBody UserEntity userEntity){
        if(userEntityDAO.verifyUser(userEntity)){
            return "OK";
        }else{
            return "FAIL";
        }
    }
}
