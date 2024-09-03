package com.cbank.controller;

import com.cbank.common.Result;
import com.cbank.entity.Certification;
import com.cbank.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/2 17:27
 **/
@RestController
@RequestMapping("/certification")
@CrossOrigin(origins = "http://localhost:8080") // Vue开发服务器地址
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    /**
     * 展示认证申请列表
     * @return 所有认证申请记录
     */
    @GetMapping("/list")
    public Result list(){
        List<Certification> list = certificationService.list();
        return Result.success(list);
    }

    /**
     * 根据成果名称模糊查询认证记录
     *
     * @param achievementName 成果名称
     * @return 认证记录列表
     */
    @GetMapping("/search")
    public Result search(@RequestParam String achievementName) {
        List<Certification> list = certificationService.searchByAchievementName(achievementName);
        return Result.success(list);
    }
}
