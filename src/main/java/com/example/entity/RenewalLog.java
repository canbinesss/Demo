package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;


@TableName("t_renewal_log")
public class RenewalLog extends Model<RenewalLog> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 会员编号 会员卡编号 
      */
    private Integer vipid;

    /**
      * 名称 名称 
      */
    private String username;

    /**
      * 充值类型 充值类型 
      */
    private String filltype;

    /**
      * 天数 天数 
      */
    private String days;

    /**
      * 金额 金额 
      */
    private String sprice;

    /**
      * 实收金额 实收金额 
      */
    private String insprice;

    /**
      * 找零 找零 
      */
    private String loosechange;

    /**
      * 日期 date 
      */
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
         this.vipid = vipid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }

    public String getFilltype() {
        return filltype;
    }

    public void setFilltype(String filltype) {
         this.filltype = filltype;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
         this.days = days;
    }

    public String getSprice() {
        return sprice;
    }

    public void setSprice(String sprice) {
         this.sprice = sprice;
    }

    public String getInsprice() {
        return insprice;
    }

    public void setInsprice(String insprice) {
         this.insprice = insprice;
    }

    public String getLoosechange() {
        return loosechange;
    }

    public void setLoosechange(String loosechange) {
         this.loosechange = loosechange;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
         this.date = date;
    }

}