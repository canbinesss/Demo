package com.example.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kangzhongbin
 * @date 2021年12月18日10:51
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.info("test {}","${java:os}");
    }
}
