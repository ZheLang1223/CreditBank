package com.cbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: zhelang
 * @date 2024/9/2 17:00
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    private Long id;

    private Long userId; // 用户表的外键，表示创建此成就的管理员

    private String name; // 成果的名称

    private String description; // 成就描述和认证介绍

    private String type; // 成就类型：在线课程、学位、项目、论文、职业、技能证书

    private BigDecimal credits; // 成就对应的学分

    private LocalDateTime createdDate; // 成就创建时间

    private String status; // 成就状态

    private String level; // 成就等级：初级、中级、高级
}
