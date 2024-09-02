package com.cbank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbank.entity.Achievement;
import com.cbank.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/2 17:00
 **/

@Mapper
public interface AchievementMapper extends BaseMapper<Achievement>{

     List<Achievement> getList();
}
