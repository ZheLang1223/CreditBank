package com.cbank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbank.entity.Certification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/2 17:28
 **/

@Mapper
public interface CertificationMapper extends BaseMapper<Certification> {
    List<Certification> getList();
}
