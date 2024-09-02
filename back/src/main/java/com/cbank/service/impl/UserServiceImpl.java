package com.cbank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cbank.entity.User;
import com.cbank.mapper.UserMapper;
import com.cbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> getPageC(long current, long size) {
        IPage<User> page = new Page<>(current, size);
        return userMapper.pageC(page);
    }

    @Override
    public IPage<User> getPageCC(long current, long size, String nameFilter) {
        IPage<User> page = new Page<>(current, size);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("nickname", nameFilter);  // 添加一个简单的名字过滤条件

        return userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

}
