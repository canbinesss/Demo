package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.util.Date;


@TableName("t_user_vip")
public class UserVip extends Model<UserVip> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 用户id 会员编号 
      */
    private Integer userid;

    /**
      * 用户名 名称 
      */
    private String username;

    /**
      * 电话 电话 
      */
    private String phone;

    /**
      * 性别 性别 
      */
    private String sex;

    /**
      * 年龄 年龄 
      */
    private String age;

    /**
      * 生日 生日 
      */
    private String birthday;

    /**
      * 卡类型 卡类型 
      */
    private String cardtype;

    /**
      * 录入日期 录入日期
      */
    private String entrydate;

    /**
      * 会员状态 会员状态 
      */
    private String vipstate;

    /**
      * 会员余额 会员余额 
      */
    private BigDecimal vipmoney;

    /**
      * 到期日期 到期日期 
      */
    private String expire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
         this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
         this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
         this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
         this.birthday = birthday;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
         this.cardtype = cardtype;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
         this.entrydate = entrydate;
    }

    public String getVipstate() {
        return vipstate;
    }

    public void setVipstate(String vipstate) {
         this.vipstate = vipstate;
    }

    public BigDecimal getVipmoney() {
        return vipmoney;
    }

    public void setVipmoney(BigDecimal vipmoney) {
         this.vipmoney = vipmoney;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
         this.expire = expire;
    }

    @Override
    public String toString() {
        return "UserVip{" +
                "id=" + id +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cardtype='" + cardtype + '\'' +
                ", entrydate=" + entrydate +
                ", vipstate='" + vipstate + '\'' +
                ", vipmoney=" + vipmoney +
                ", expire=" + expire +
                '}';
    }
}