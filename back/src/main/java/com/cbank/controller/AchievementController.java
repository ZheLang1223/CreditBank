package com.cbank.controller;

import com.cbank.common.Result;
import com.cbank.entity.Achievement;
import com.cbank.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据成果名称模糊查询成果记录
     *
     * @param name 成果名称
     * @return 查询结果
     */
    @GetMapping("/search")
    public Result searchByName(@RequestParam String name) {
        List<Achievement> list = achievementService.searchByName(name);
        return Result.success(list);
    }
}
