package com.example.utils;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author sunian
 * @name speechRecognition
 * @class name：com.sunian.speechrecognition.util
 * @time 2018/11/7 10:15
 * @describe describe
 */
public class JsonUtil {

    public static String getJsonString(Object object) throws Exception {
        return JacksonMapper.getInstance().writeValueAsString(object);
    }

    public static Object toObject(String jsonString, Class cls) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, cls);
    }

}

