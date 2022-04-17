package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;


@TableName("t_recruitmentinfo")
public class Recruitmentinfo extends Model<Recruitmentinfo> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 工作地址 
      */
    private String address;

    /**
      * 联系人 
      */
    private String contact;

    /**
      * 联系人电话 
      */
    private String phone;

    /**
      * 招聘内容 
      */
    private String recruittext;

    /**
      * 发布时间 
      */
    private Date recruittime;

    /**
      * 招聘标题 
      */
    private String recruittitle;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
         this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
         this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
         this.phone = phone;
    }

    public String getRecruittext() {
        return recruittext;
    }

    public void setRecruittext(String recruittext) {
         this.recruittext = recruittext;
    }

    public Date getRecruittime() {
        return recruittime;
    }

    public void setRecruittime(Date recruittime) {
         this.recruittime = recruittime;
    }

    public String getRecruittitle() {
        return recruittitle;
    }

    public void setRecruittitle(String recruittitle) {
         this.recruittitle = recruittitle;
    }

}