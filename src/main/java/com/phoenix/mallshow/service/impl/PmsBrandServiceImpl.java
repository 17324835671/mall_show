
package com.phoenix.mallshow.service.impl;

import com.github.pagehelper.PageHelper;
import com.phoenix.mallshow.component.TestKafkaListener;
import com.phoenix.mallshow.mbg.mapper.PmsBrandMapper;
import com.phoenix.mallshow.mbg.model.PmsBrand;
import com.phoenix.mallshow.mbg.model.PmsBrandExample;
import com.phoenix.mallshow.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;


/**
 * PmsBrandService实现类
 * Created by tx_li.
 */

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandServiceImpl.class);
    @Autowired
    private PmsBrandMapper brandMapper;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }


    public void sendMessage(String topic, String data) {
        LOGGER.info("kafka sendMessage start");
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("kafka sendMessage error, ex = {}, topic = {}, data = {}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", ex, topic, data);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.info("kafka sendMessage success topic = {}, data = {}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",topic, data);
            }
        });
        LOGGER.info("kafka sendMessage end");
    }

}


