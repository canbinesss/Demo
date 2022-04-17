package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@TableName("t_sign_in")
public class SignIn extends Model<SignIn> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 签到时间 
      */
    private String intime;

    /**
      * 签到类型 
      */
    private String type;

    /**
      * 会员id 
      */
    private Integer userid;

    /**
      * 会员名称 
      */
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
         this.intime = intime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
         this.type = type;
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