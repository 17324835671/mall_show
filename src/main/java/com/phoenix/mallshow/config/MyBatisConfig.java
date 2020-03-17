package com.phoenix.mallshow.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by tx_li on 2020/3/10.
 */
@Configuration
@MapperScan({"com/phoenix/mallshow/mbg/mapper","com.phoenix.mallshow.dao"})
public class MyBatisConfig {
}
