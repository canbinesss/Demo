package com.example.service;

import com.example.entity.Ad;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.AdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdService extends ServiceImpl<AdMapper, Ad> {

    @Resource
    private AdMapper adMapper;

}