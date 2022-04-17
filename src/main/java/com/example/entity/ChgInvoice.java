package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_chg_invoice")
public class ChgInvoice extends Model<ChgInvoice> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 收费日期 收费日期 
      */
    private Date chgdate;

    /**
      * 收费方式 收费方式 
      */
    private String chgtype;

    /**
      * 优惠类别 优惠类别 
      */
    private String discount;

    /**
      * 发票号 发票号 
      */
    private String invoiceCode;

    /**
      * 总费用 总费用 
      */
    private BigDecimal totalcost;

    /**
      * 用户id 
      */
    private Integer userid;

    /**
      * 用户名 
      */
    private String username;

    /**
     * 地址
     */
    private String address;

    public Date getChgdate() {
        return chgdate;
    }

    public void setChgdate(Date chgdate) {
         this.chgdate = chgdate;
    }

    public String getChgtype() {
        return chgtype;
    }

    public void setChgtype(String chgtype) {
         this.chgtype = chgtype;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
         this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
         this.invoiceCode = invoiceCode;
    }

    public BigDecimal getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(BigDecimal totalcost) {
         this.totalcost = totalcost;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
         this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}