package com.example.mapper;

import com.example.entity.Recruitmentinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface RecruitmentinfoMapper extends BaseMapper<Recruitmentinfo> {

    List<Recruitmentinfo> getlist();
}