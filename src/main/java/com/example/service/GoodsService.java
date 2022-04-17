package com.example.service;

import com.example.entity.Goods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> {

    @Resource
    private GoodsMapper goodsMapper;

    public void editnumbyname(Goods goods) {
        goodsMapper.editnumbyname(goods);
    }

    public List<Map> getnum() {
        return goodsMapper.getNum();
    }

    public Integer getAllnum() {
        return goodsMapper.getAllNum();
    }

    public Integer getnumByName(String goodsName) {
        return goodsMapper.getnumByName(goodsName);
    }

    public List<Goods> getlist() {
        return goodsMapper.getlist();
    }

    public List<Goods> getAlllist() {
        return goodsMapper.getAlllist();
    }

    public String getUrlByName(String goodsname) {
        return goodsMapper.getUrlByName(goodsname);
    }

}