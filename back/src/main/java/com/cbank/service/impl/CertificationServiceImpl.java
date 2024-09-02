package com.cbank.service.impl;

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
}
