package com.example.mapper;

import com.example.entity.Fofcs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface FofcsMapper extends BaseMapper<Fofcs> {

    List<Fofcs> getlist();
}