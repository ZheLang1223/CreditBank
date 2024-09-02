package com.cbank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.cbank.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/1 16:47
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();

    /**
     * 基于分页信息查询用户数据
     * 通过接收的IPage<User>参数确定分页信息（当前页码、每页大小等）
     * 然后执行查询并返回查询结果
     * @param page 分页信息
     * @return 当前分页查询结果
     */
    IPage<User> pageC(IPage<User> page);

    /**
     * 基于分页信息进行查询，还可以通过wrapper参数附加额外的查询条件
     * @param page 分页信息
     * @param wrapper 通常用于构建动态 SQL 查询条件
     * @return 当前分页查询结果
     */
    IPage<User> pageCC(IPage<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
