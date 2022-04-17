package com.example.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exception.CustomException;
import com.example.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    @Resource
    private AccountMapper accountMapper;

    public List<Account> getUserIdNameList() {
        return accountMapper.getUserIdNameList();
    }

    public Account login(Account account) {
        Account one = getOne(Wrappers.<Account>lambdaQuery().eq(Account::getPassworld, account.getPassworld()).eq(Account::getUsername, account.getUsername()).or().eq(Account::getPhone, account.getUsername()));
        if (one == null) {
            throw new CustomException("-1", "账号或密码错误");
        }
        return one;
    }

    public Account register(Account account) {
        Account one = getOne((Wrappers.<Account>lambdaQuery().eq(Account::getUsername, account.getUsername())));
        if (one != null) {
            throw new CustomException("-1", "用户已注册");
        }
        if (account.getPassworld() == null) {
            account.setPassworld("123456");
        }
        save(account);
        return getOne((Wrappers.<Account>lambdaQuery().eq(Account::getUsername, account.getUsername())));
    }

    public UserVip isVip(Long id) {
        UserVip vipinfo = accountMapper.getVipById(id);
       return vipinfo;
    }


    public Account getbyAccountname(String username) {
        Account one = getOne((Wrappers.<Account>lambdaQuery().eq(Account::getUsername, username)));
        return one;
    }

}