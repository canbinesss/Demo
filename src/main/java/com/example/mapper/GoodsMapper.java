package com.example.mapper;

import com.example.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface GoodsMapper extends BaseMapper<Goods> {

    void editnumbyname(Goods goods);

    List<Map> getNum();

    Integer getAllNum();

    Integer getnumByName(String goodsName);

    List<Goods> getlist();

    List<Goods> getAlllist();

    String getUrlByName(String goodsname);

}