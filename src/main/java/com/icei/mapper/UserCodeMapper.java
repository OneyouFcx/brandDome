package com.icei.mapper;

import com.icei.domain.UserCode;

public interface UserCodeMapper {
     UserCode getByUserCode(String userCode);

     int insertSelective(UserCode userCode);
}