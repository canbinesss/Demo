package com.example.service;

import com.example.entity.GoodsIn;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.GoodsInMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsInService extends ServiceImpl<GoodsInMapper, GoodsIn> {

    @Resource
    private GoodsInMapper goodsInMapper;

}