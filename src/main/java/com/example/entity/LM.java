package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@TableName("t_lm")
public class LM extends Model<LM> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 教练id 
      */
    private Integer coachid;

    /**
      * 教练名 
      */
    private String coachname;

    /**
      * 留言内容 
      */
    private String lmcontent;

    /**
      * 留言时间 
      */
    private Date lmdate;

    /**
      * 回复内容 
      */
    private String replycontent;

    /**
      * 回复时间 
      */
    private Date replydate;

    /**
      * 用户id 
      */
    private Integer userid;

    /**
      * 用户名 
      */
    private String username;

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
         this.coachid = coachid;
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
         this.coachname = coachname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getLmcontent() {
        return lmcontent;
    }

    public void setLmcontent(String lmcontent) {
         this.lmcontent = lmcontent;
    }

    public Date getLmdate() {
        return lmdate;
    }

    public void setLmdate(Date lmdate) {
         this.lmdate = lmdate;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
         this.replycontent = replycontent;
    }

    public Date getReplydate() {
        return replydate;
    }

    public void setReplydate(Date replydate) {
         this.replydate = replydate;
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