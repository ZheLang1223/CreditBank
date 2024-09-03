package com.cbank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cbank.entity.Certification;
import com.cbank.mapper.CertificationMapper;
import com.cbank.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/2 17:28
 **/

@Service
public class CertificationServiceImpl implements CertificationService {
    @Autowired
    private CertificationMapper certificationMapper;

    @Override
    public List<Certification> list(){
        return certificationMapper.getList();
    }

    /**
     * 根据成果名称模糊查询认证记录
     *
     * @param achievementName 成果名称
     * @return 认证记录列表
     */
    @Override
    public List<Certification> searchByAchievementName(String achievementName) {
        LambdaQueryWrapper<Certification> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Certification::getAchievementName, achievementName);
        return certificationMapper.selectList(queryWrapper);
    }
}
