package com.example.mapper;

import com.example.entity.SignIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface SignInMapper extends BaseMapper<SignIn> {

    SignIn getjlbyidtime(@Param("id") Integer id, @Param("time2") String time2);
}