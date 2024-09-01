package com.cbank.mapper;

import com.cbank.entity.User;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: zhelang
 * @date 2024/9/1 16:47
 **/

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> getAllUser();

}
