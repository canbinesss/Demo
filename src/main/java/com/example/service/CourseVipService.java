package com.example.service;

import com.example.entity.CourseVip;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.CourseVipMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseVipService extends ServiceImpl<CourseVipMapper, CourseVip> {

    @Resource
    private CourseVipMapper courseVipMapper;

}