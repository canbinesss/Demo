package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;


@TableName("t_order")
public class Order extends Model<Order> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 发货时间 
      */
    private Date deliverdate;

    /**
      * 购买地址 
      */
    private String goodsacc;

    /**
      * 商品名称 
      */
    private String goodsname;

    /**
      * 购买数量 
      */
    private Integer goodsnum;

    /**
      * 商品图片 
      */
    private String goodsurl;

    /**
      * 发票号 
      */
    private String invcode;

    /**
      * 订单时间 
      */
    private Date orderdate;

    /**
      * 发货状态 
      */
    private String state;

    public Date getDeliverdate() {
        return deliverdate;
    }

    public void setDeliverdate(Date deliverdate) {
         this.deliverdate = deliverdate;
    }

    public String getGoodsacc() {
        return goodsacc;
    }

    public void setGoodsacc(String goodsacc) {
         this.goodsacc = goodsacc;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
         this.goodsname = goodsname;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
         this.goodsnum = goodsnum;
    }

    public String getGoodsurl() {
        return goodsurl;
    }

    public void setGoodsurl(String goodsurl) {
         this.goodsurl = goodsurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getInvcode() {
        return invcode;
    }

    public void setInvcode(String invcode) {
         this.invcode = invcode;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
         this.orderdate = orderdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
         this.state = state;
    }

}