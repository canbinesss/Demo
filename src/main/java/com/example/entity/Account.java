package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("t_account")
public class Account extends Model<Account> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 头像 
      */
    private String avatar;

    /**
      * 用户名 
      */
    private String username;

    /**
      * 手机号 
      */
    private String phone;

    /**
      * 密码 
      */
    private String passworld;

    /**
      * 邮箱 
      */
    private String email;

    private Boolean vipfilg;

    /**
      * 注册时间 
      */
    private String registdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
         this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
         this.phone = phone;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
         this.passworld = passworld;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
         this.registdate = registdate;
    }

    public Boolean getVipfilg() {
        return vipfilg;
    }

    public void setVipfilg(Boolean vipfilg) {
        this.vipfilg = vipfilg;
    }
}