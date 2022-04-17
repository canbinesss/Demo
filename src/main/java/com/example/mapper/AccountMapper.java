package com.example.mapper;

import com.example.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.UserVip;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {

    List<Account> getUserIdNameList();

    UserVip getVipById(Long id);
}