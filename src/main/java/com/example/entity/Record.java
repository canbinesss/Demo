package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;


@TableName("t_record")
public class Record extends Model<Record> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 运动时间 
      */
    private Date modate;

    /**
      * 运动时长 
      */
    private String motime;

    /**
      * 运动方式 
      */
    private String motype;

    /**
      * 记录时间 
      */
    private Date recorddate;

    /**
      * 用户id 
      */
    private Integer userid;

    /**
      * 用户名 
      */
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public Date getModate() {
        return modate;
    }

    public void setModate(Date modate) {
         this.modate = modate;
    }

    public String getMotime() {
        return motime;
    }

    public void setMotime(String motime) {
         this.motime = motime;
    }

    public String getMotype() {
        return motype;
    }

    public void setMotype(String motype) {
         this.motype = motype;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
         this.recorddate = recorddate;
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

}