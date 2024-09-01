package com.cbank.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cbank.entity.User;
import com.cbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080") // Vue开发服务器地址
public class UserController {

    @Autowired  // 自动注入实例
    private UserService userService;

    public IPage<User> getUserPage(@RequestParam long current,
                                   @RequestParam long size,
                                   @RequestParam(required = false) String nameFilter){
        return userService.getPageCC(current, size, nameFilter);
    }

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }
}
