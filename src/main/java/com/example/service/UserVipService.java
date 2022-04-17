package com.example.service;

import com.example.entity.UserVip;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.UserVipMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserVipService extends ServiceImpl<UserVipMapper, UserVip> {

    @Resource
    private UserVipMapper userVipMapper;

    public UserVip getUserVipeById(Long id) {
        return userVipMapper.getUserVipeById(id);
    }

    public Integer getnum() {
        return userVipMapper.getnum();
    }
}