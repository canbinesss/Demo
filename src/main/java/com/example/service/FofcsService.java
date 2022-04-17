package com.example.service;

import com.example.entity.Fofcs;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.FofcsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FofcsService extends ServiceImpl<FofcsMapper, Fofcs> {

    @Resource
    private FofcsMapper fofcsMapper;

    public List<Fofcs> getlist() {
        return fofcsMapper.getlist();
    }
}