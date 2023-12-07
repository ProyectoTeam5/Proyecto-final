package com.tukiservice.controller;

import com.tukiservice.models.user.UserEntity;
import com.tukiservice.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    IUserService userService;
    @PostMapping
    public String loginUser(@RequestBody UserEntity userEntity){
        if(userService.verifyUser(userEntity)){
            return "OK";
        }else{
            return "FAIL";
        }
    }
}
