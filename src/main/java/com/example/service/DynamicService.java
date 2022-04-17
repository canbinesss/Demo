package com.example.service;

import com.example.entity.Dynamic;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.DynamicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DynamicService extends ServiceImpl<DynamicMapper, Dynamic> {

    @Resource
    private DynamicMapper dynamicMapper;

}