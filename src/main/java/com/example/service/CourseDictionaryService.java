package com.example.service;

import com.example.entity.CourseDictionary;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.CourseDictionaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseDictionaryService extends ServiceImpl<CourseDictionaryMapper, CourseDictionary> {

    @Resource
    private CourseDictionaryMapper courseDictionaryMapper;

}