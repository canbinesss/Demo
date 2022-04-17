package com.example.mapper;

import com.example.entity.Package;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

public interface PackageMapper extends BaseMapper<Package> {

    Integer getCardDayByName(String cardName);

    BigDecimal getCardMoneyByName(String cardName);
}