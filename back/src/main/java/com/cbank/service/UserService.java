package com.cbank.service;

import com.cbank.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {
    List<User> getAllUser();
}
