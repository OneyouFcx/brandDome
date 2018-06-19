package com.icei.service.adminService;

import com.icei.domain.UserCode;
import com.icei.mapper.UserCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCodeService {
    @Autowired
    public UserCodeMapper userCodeMapper;

    public UserCode getAllByCode(String userCode){
        return userCodeMapper.getByUserCode(userCode);
    }

    public int  insertServ(UserCode userCode){
        return userCodeMapper.insertSelective(userCode);
    }
}
