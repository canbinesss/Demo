package com.example.service;

import com.example.entity.Package;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.PackageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class PackageService extends ServiceImpl<PackageMapper, Package> {

    @Resource
    private PackageMapper packageMapper;

    public Integer getCardDayByName(String cardName) {
        return packageMapper.getCardDayByName(cardName);
    }

    public BigDecimal getCardMoneyByName(String cardName) {
        return packageMapper.getCardMoneyByName(cardName);
    }
}