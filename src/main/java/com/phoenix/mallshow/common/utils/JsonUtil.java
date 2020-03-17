package com.phoenix.mallshow.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @ProjectName: macalline-work-server
 * @Package: com.red.star.macalline.data.utils
 * @Description:
 * @Author: AMGuo
 * @CreateDate: 2018/10/16 下午4:44
 * @Version: 1.0
 */
public class JsonUtil {

    /**
     * 判断字符串是否json格式
     *
     * @param content
     * @return
     */
    public final static boolean isJSON(String content) {
        if (CheckUtil.isEmpty(content)) {
            return false;
        }
        try {
            JSONObject.parseObject(content);
        } catch (Exception ex) {
            try {
                JSONObject.parseArray(content);
            } catch (Exception ex1) {
                return false;
            }
        }
        return true;
    }
}
