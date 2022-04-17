package com.example.service;

import com.example.entity.Recruitmentinfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.RecruitmentinfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitmentinfoService extends ServiceImpl<RecruitmentinfoMapper, Recruitmentinfo> {

    @Resource
    private RecruitmentinfoMapper recruitmentinfoMapper;

    public List<Recruitmentinfo> getlist() {
        return recruitmentinfoMapper.getlist();
    }
}