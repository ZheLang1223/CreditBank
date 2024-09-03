package com.cbank.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cbank.common.Result;
import com.cbank.entity.User;
import com.cbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080") // Vue开发服务器地址
public class UserController {

    @Autowired  // 自动注入实例
    private UserService userService;

//    public IPage<User> getUserPage(@RequestParam long current,
//                                   @RequestParam long size,
//                                   @RequestParam(required = false) String nameFilter){
//        return userService.getPageCC(current, size, nameFilter);
//    }

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/list")
    public Result getUserList(){
        List<User> list = userService.getUserList();
        return Result.success(list);
    }

    /**
     * 根据用户昵称、账号、真实姓名模糊查询用户
     *
     * @param name 用户昵称、账号、真实姓名
     * @return 用户记录
     */
    @GetMapping("/search")
    public Result searchByName(String name){
        List<User> list = userService.searchByName(name);
        return Result.success(list);
    }

    /**
     * 登录
     * @param user 登录用户
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return Result.error();
    }

    /**
     * 添加用户
     */
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        int i = userService.addUser(user);
        if (i != 1) return Result.error("添加失败");
        return Result.success("添加成功");
    }
}
