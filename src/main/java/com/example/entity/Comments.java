package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@TableName("t_comments")
public class Comments extends Model<Comments> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 动态id 
      */
    private Integer dynamicid;

    /**
      * 评价人头像 
      */
    private String commentsuri;

    /**
      * 评价人名称 
      */
    private String commentsname;

    /**
      * 评价时间 
      */
    private Date commentsdate;

    /**
      * 评价内容 
      */
    private String commentstext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public Integer getDynamicid() {
        return dynamicid;
    }

    public void setDynamicid(Integer dynamicid) {
         this.dynamicid = dynamicid;
    }

    public String getCommentsuri() {
        return commentsuri;
    }

    public void setCommentsuri(String commentsuri) {
         this.commentsuri = commentsuri;
    }

    public String getCommentsname() {
        return commentsname;
    }

    public void setCommentsname(String commentsname) {
         this.commentsname = commentsname;
    }

    public Date getCommentsdate() {
        return commentsdate;
    }

    public void setCommentsdate(Date commentsdate) {
         this.commentsdate = commentsdate;
    }

    public String getCommentstext() {
        return commentstext;
    }

    public void setCommentstext(String commentstext) {
         this.commentstext = commentstext;
    }

}