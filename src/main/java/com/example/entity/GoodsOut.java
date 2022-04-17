package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@TableName("t_goods_out")
public class GoodsOut extends Model<GoodsOut> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 商品名称 商品名称 
      */
    private String goodsname;

    /**
      * 出库类型 出库类型 
      */
    private String outtype;

    /**
      * 出库时间 出库时间 
      */
    private Date outtime;

    /**
      * 出库数量 出库数量 
      */
    private Integer outnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getGoodsName() {
        return goodsname;
    }

    public void setGoodsName(String goodsname) {
         this.goodsname = goodsname;
    }

    public String getOuttype() {
        return outtype;
    }

    public void setOuttype(String outtype) {
         this.outtype = outtype;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
         this.outtime = outtime;
    }

    public Integer getOutnum() {
        return outnum;
    }

    public void setOutnum(Integer outnum) {
         this.outnum = outnum;
    }

}