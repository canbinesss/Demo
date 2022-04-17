package com.example.service;

import com.example.entity.LM;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.LMMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LMService extends ServiceImpl<LMMapper, LM> {

    @Resource
    private LMMapper lMMapper;

}