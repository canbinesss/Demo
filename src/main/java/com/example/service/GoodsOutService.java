package com.example.service;

import com.example.entity.GoodsOut;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.GoodsOutMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsOutService extends ServiceImpl<GoodsOutMapper, GoodsOut> {

    @Resource
    private GoodsOutMapper goodsOutMapper;

}