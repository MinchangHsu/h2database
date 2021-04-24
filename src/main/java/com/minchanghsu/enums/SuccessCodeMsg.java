package com.minchanghsu.enums;

import lombok.Getter;

@Getter
public enum SuccessCodeMsg {
    COMMON_FAIL(0, "回应失败"),
    COMMON_OK(1, "回应成功");

    private int code;
    private String msg;

    private SuccessCodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
