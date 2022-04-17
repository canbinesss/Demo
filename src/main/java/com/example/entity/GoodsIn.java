package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_goods_in")
public class GoodsIn extends Model<GoodsIn> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 商品名称 商品名称 
      */
    private String goodsname;

    /**
      * 入库类型 入库类型 
      */
    private String intype;

    /**
      * 入库时间 入库时间 
      */
    private Date intime;

    /**
      * 入库金额 入库金额 
      */
    private BigDecimal inprice;

    /**
      * 入库数量 入库数量 
      */
    private Integer innum;

    /**
      * 当前存量 当前存量 
      */
    private Integer inventory;

    /**
      * 生产日期 生产日期 
      */
    private Date productiondate;

    /**
      * 有效期至 有效期至 
      */
    private Date effective;

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

    public String getIntype() {
        return intype;
    }

    public void setIntype(String intype) {
         this.intype = intype;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
         this.intime = intime;
    }

    public BigDecimal getInprice() {
        return inprice;
    }

    public void setInprice(BigDecimal inprice) {
         this.inprice = inprice;
    }

    public Integer getInnum() {
        return innum;
    }

    public void setInnum(Integer innum) {
         this.innum = innum;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
         this.inventory = inventory;
    }

    public Date getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(Date productiondate) {
         this.productiondate = productiondate;
    }

    public Date getEffective() {
        return effective;
    }

    public void setEffective(Date effective) {
         this.effective = effective;
    }

}