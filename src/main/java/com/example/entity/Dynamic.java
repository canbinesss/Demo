package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@TableName("t_dynamic")
public class Dynamic extends Model<Dynamic> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 用户id 
      */
    private String accountid;

    /**
      * 用户名称 
      */
    private String username;

    /**
      * 用户头像 
      */
    private String useravatar;

    /**
      * 发表时间 
      */
    private Date date;

    /**
      * 发表内容 
      */
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
         this.accountid = accountid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
         this.useravatar = useravatar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
         this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
         this.text = text;
    }

}