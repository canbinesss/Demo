package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.ToString;

import java.util.List;


@TableName(value = "t_user", autoResultMap = true)
@ToString()
public class User extends Model<com.example.entity.User> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String avatar;

    /**
      * 权限
      */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<com.example.entity.Role> role;

    @TableField(exist = false)
    private List<com.example.entity.Permission> permission;

    public List<com.example.entity.Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<com.example.entity.Permission> permission) {
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
         this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
         this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
         this.avatar = avatar;
    }

    public List<com.example.entity.Role> getRole() {
        return role;
    }

    public void setRole(List<com.example.entity.Role> role) {
        this.role = role;
    }
}
