package com.cbank.controller;

import com.cbank.common.Result;
import com.cbank.entity.Certification;
import com.cbank.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/list")
    public Result list(){
        List<Certification> list = certificationService.list();
        return Result.success(list);
    }
}
