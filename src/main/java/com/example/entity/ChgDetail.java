package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;


@TableName("t_chg_detail")
public class ChgDetail extends Model<ChgDetail> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 发票号 发票号 
      */
    private String invoiceCode;

    /**
      * 商品名称 商品名称 
      */
    private String goodsname;

    /**
      * 商品价格 商品单价 
      */
    private BigDecimal price;

    /**
      * 商品折扣 商品优惠 
      */
    private String discount;

    /**
      * 商品数量 商品数量 
      */
    private String num;

    /**
      * 商品单位 商品单位 
      */
    private String unit;

    /**
      * 商品总价 商品总价 
      */
    private BigDecimal amt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
         this.invoiceCode = invoiceCode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
         this.goodsname = goodsname;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
         this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
         this.unit = unit;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
         this.amt = amt;
    }

}