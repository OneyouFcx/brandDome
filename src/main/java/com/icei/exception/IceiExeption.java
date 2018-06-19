package com.icei.exception;

import com.icei.enums.ResultEnums;

public class IceiExeption extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public IceiExeption(ResultEnums resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
}
