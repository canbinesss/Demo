package com.example.service;

import com.example.entity.SignIn;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.SignInMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SignInService extends ServiceImpl<SignInMapper, SignIn> {

    @Resource
    private SignInMapper signInMapper;

    public boolean ishave(Integer id,String time2) {
        SignIn signIn = signInMapper.getjlbyidtime(id,time2);
        if(signIn!=null){
            return true;
        }else{
            return false;
        }
    }
}