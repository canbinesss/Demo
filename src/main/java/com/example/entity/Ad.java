package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("t_ad")
public class Ad extends Model<Ad> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 广告图片 
      */
    private String adp;

    /**
      * 广告链接 
      */
    private String untitled2;

    public String getAdp() {
        return adp;
    }

    public void setAdp(String adp) {
         this.adp = adp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getUntitled2() {
        return untitled2;
    }

    public void setUntitled2(String untitled2) {
         this.untitled2 = untitled2;
    }

}