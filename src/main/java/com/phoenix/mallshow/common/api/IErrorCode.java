package com.phoenix.mallshow.common.api;

/**
 * 封装API的错误码
 * Created by tx_li on 2020/3/10.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
