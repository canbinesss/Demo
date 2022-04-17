package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("t_invoice")
public class Invoice extends Model<Invoice> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 申请人id 
      */
    private Integer userid;

    /**
      * 申请人 发票号 
      */
    private String applicant;

    /**
      * 首位号 
      */
    private Integer fristCode;

    /**
      * 末尾号 
      */
    private Integer lastCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
         this.userid = userid;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
         this.applicant = applicant;
    }

    public Integer getFristCode() {
        return fristCode;
    }

    public void setFristCode(Integer fristCode) {
         this.fristCode = fristCode;
    }

    public Integer getLastCode() {
        return lastCode;
    }

    public void setLastCode(Integer lastCode) {
         this.lastCode = lastCode;
    }

}