package com.phoenix.mallshow.dto;

import lombok.Data;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
@Data
public class OrderParam {
    //收货地址id
    private Long memberReceiveAddressId;
    //优惠券id
    private Long couponId;
    //使用的积分数
    private Integer useIntegration;
    //支付方式
    private Integer payType;


}
