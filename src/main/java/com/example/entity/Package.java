package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;


@TableName("t_package")
public class Package extends Model<Package> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 套餐名称 套餐名称 
      */
    private String packagetype;

    /**
      * 有效天数 有效天数 
      */
    private String days;

    /**
      * 售价 售价 
      */
    private BigDecimal price;

    /**
      * 优惠 优惠 
      */
    private String discounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public void setPackagetype(String packagetype) {
         this.packagetype = packagetype;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
         this.days = days;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
         this.price = price;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
         this.discounts = discounts;
    }

}