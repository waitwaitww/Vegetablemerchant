package com.feng.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class jsonUtil {

    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH-mm-ss");
    }
    public static String getJson(Object object, String dateFormat){
        //jackson objectMapper对象
        //使用ObjectMapper 来格式化输出
        //使用SimpleDateFormat格式化时间，否则Date以时间戳的形式呈现（1970.1.1后的毫秒数）
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        mapper.setDateFormat(df);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
