package com.cbank.entity;

import java.time.LocalDateTime;

/**
 * @author: zhelang
 * @date 2024/9/1 16:39
 **/
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
