package com.icei.utils;

import com.icei.domain.UserCode;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * MD5加密
 */
public   class  MD5 {

    public static String likeMd5(UserCode user){
        SimpleHash hash = new SimpleHash("MD5", user.getPassword(),user.getCredentialsSalt(), 2);
        String pwd = hash.toHex();
        return pwd;
    }
}
