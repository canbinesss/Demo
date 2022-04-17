package com.example.service;

import com.example.entity.Ann;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.AnnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnnService extends ServiceImpl<AnnMapper, Ann> {

    @Resource
    private AnnMapper annMapper;

    public List<Ann> getlist() {
        return annMapper.getlist();
    }
}