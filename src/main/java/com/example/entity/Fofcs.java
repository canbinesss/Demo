package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("t_fofcs")
public class Fofcs extends Model<Fofcs> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 背景图片 
      */
    private String bgurl;

    /**
      * 常识内容 
      */
    private String cscontent;

    public String getBgurl() {
        return bgurl;
    }

    public void setBgurl(String bgurl) {
         this.bgurl = bgurl;
    }

    public String getCscontent() {
        return cscontent;
    }

    public void setCscontent(String cscontent) {
         this.cscontent = cscontent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

}