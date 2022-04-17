package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;


@TableName("t_goods")
public class Goods extends Model<Goods> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 商品名称 
      */
    private String goodsname;

    /**
      * 商品数量 
      */
    private Integer num;

    /**
      * 商品价格 
      */
    private BigDecimal price;

    /**
      * 商品折扣 
      */
    private String discount;

    /**
      * 商品图片 
      */
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
         this.goodsname = goodsname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
         this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
         this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
         this.discount = discount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
         this.url = url;
    }

}