package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("t_ann")
public class Ann extends Model<Ann> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 公告内容 
      */
    private String annContent;

    /**
      * 公告标题 
      */
    private String annTitle;

    /**
      * 发布时间 
      */
    private String issueData;

    /**
      * 是否启用 
      */
    private String state;

    public String getAnnContent() {
        return annContent;
    }

    public void setAnnContent(String annContent) {
         this.annContent = annContent;
    }

    public String getAnnTitle() {
        return annTitle;
    }

    public void setAnnTitle(String annTitle) {
         this.annTitle = annTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getIssueData() {
        return issueData;
    }

    public void setIssueData(String issueData) {
         this.issueData = issueData;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
         this.state = state;
    }

}