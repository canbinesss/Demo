package com.example.service;

import com.example.entity.RenewalLog;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.RenewalLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RenewalLogService extends ServiceImpl<RenewalLogMapper, RenewalLog> {

    @Resource
    private RenewalLogMapper renewalLogMapper;

}