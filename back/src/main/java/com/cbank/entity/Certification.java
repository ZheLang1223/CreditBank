package com.cbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: zhelang
 * @date 2024/9/2 17:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certification {
    private Long id;

    private Long achievementId; // 关联的成果id

    private String achievementName; // 申请认证的成果的名称

    private Long applicantId; // 申请认证的用户的id

    private Long reviewerId; // 审核认证申请的用户id

    private LocalDateTime applicationDate; // 申请提交的日期和时间

    private LocalDateTime reviewDate; // 认证审核的日期和时间

    private String status; // 认证状态：待审核、已通过、已拒绝

    private String remark; // 审核员对该认证的评语或备注
}
