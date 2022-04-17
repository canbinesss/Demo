package com.example.mapper;

import com.example.entity.UserVip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserVipMapper extends BaseMapper<UserVip> {

    UserVip getUserVipeById(Long id);

    Integer getnum();
}