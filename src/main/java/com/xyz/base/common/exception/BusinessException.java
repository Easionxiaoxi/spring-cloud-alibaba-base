package com.xyz.base.common.exception;

import com.xyz.base.common.enums.StateCode;
import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(StateCode stateCode) {
        super(stateCode.getMsg());
        this.code = stateCode.getCode();
    }
}
