package com.cbank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cbank.entity.Achievement;
import com.cbank.mapper.AchievementMapper;
import com.cbank.mapper.UserMapper;
import com.cbank.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/2 17:00
 **/

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;

    public List<Achievement> list(){
        return achievementMapper.getList();
    }

    /**
     * 根据成果名称模糊查询成果记录
     *
     * @param name 成果名称
     * @return 查询的成果记录
     */
    @Override
    public List<Achievement> searchByName(String name) {
        LambdaQueryWrapper<Achievement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Achievement::getName, name);
        return achievementMapper.selectList(queryWrapper);
    }
}
