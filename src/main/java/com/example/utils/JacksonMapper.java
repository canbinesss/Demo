package com.example.utils;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author sunian
 * @name speechRecognition
 * @class name：com.sunian.speechrecognition.util
 * @time 2018/11/7 10:14
 * @describe describe
 */
public class JacksonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    private JacksonMapper() {

    }

    public static ObjectMapper getInstance() {
        return mapper;
    }

}

