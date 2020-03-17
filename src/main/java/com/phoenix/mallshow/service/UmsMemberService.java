package com.phoenix.mallshow.service;


import com.phoenix.mallshow.common.api.CommonResult;

/**
 * 会员管理Service
 * Created by tx_li on 2020/3/10.
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
