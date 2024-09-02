package com.cbank.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cbank.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

public interface UserService {
    List<User> getUserList();

//    IPage<User> getPageC(long current, long size);
//    IPage<User> getPageCC(long current, long size, String nameFilter);

    List<User> getUserByRealname(String realname);

    int addUser(User user);
}
