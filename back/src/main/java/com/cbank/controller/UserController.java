package com.cbank.controller;

import com.cbank.entity.User;
import com.cbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080") // Vue开发服务器地址
public class UserController {

    @Autowired  // 自动注入实例
    UserService userService;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }
}
