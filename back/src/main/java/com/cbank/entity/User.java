package com.cbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: zhelang
 * @date 2024/9/1 16:39
 **/
@Data   // 自动生成getter和setter方法 和 toString方法
@AllArgsConstructor // 自动生成所有参数的构造方法
@NoArgsConstructor  // 无参构造方法
public class User {
    private Long id;    // 主键
    private String nickname;
    private String username;
    private String password;
    private String real_name;
    private String email;
    private Integer age;
    private Character gender;
    private String phone;
    private String role;    // 用户身份：0超级管理员，1管理员，2用户
    private LocalDateTime joinedDate;   // 用户创建时间
    private String status;


}
