package com.cbank.controller;

import com.cbank.common.Result;
import com.cbank.entity.Achievement;
import com.cbank.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/2 17:00
 **/

@RestController
@RequestMapping("/achievement")
@CrossOrigin(origins = "http://localhost:8080") // Vue开发服务器地址
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    /**
     * 获取成就列表
     * @return 成就列表
     */
    @GetMapping("/list")
    public Result list(){
        List<Achievement> list = achievementService.list();
        return Result.success(list);
    }
}
