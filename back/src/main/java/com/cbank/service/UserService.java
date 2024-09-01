package com.cbank.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cbank.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {
    List<User> getAllUser();

    public IPage<User> getPageC(long current, long size);
    public IPage<User> getPageCC(long current, long size, String nameFilter);
}
