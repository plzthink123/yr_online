package com.think123.yr_online.enums;

import lombok.Getter;

/**
 * ViewObject
 * DataTransferObject
 * DataObject
 * @author plzthink123
 * 2019-08-07 12:37
 */
@Getter
public enum  ResultEnum {

    SUCCESS(0,"成功"),
    ;

    private Integer code;

    private String msg;

      ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}