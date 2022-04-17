package com.example.mapper;

import com.example.entity.Ann;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface AnnMapper extends BaseMapper<Ann> {

    List<Ann> getlist();
}