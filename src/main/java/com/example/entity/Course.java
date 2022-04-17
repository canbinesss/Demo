package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;


@TableName("t_course")
public class Course extends Model<Course> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 教练名称 
      */
    private String coach;

    /**
      * 课程名称 
      */
    private String course;

    /**
      * 课程简介 
      */
    private String introduction;

    /**
      * 课程费用 
      */
    private BigDecimal price;

    /**
      * 图片url 
      */
    private String picturerurl;

    /**
      * 视频url 
      */
    private String videourl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
         this.coach = coach;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
         this.course = course;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
         this.introduction = introduction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
         this.price = price;
    }

    public String getPicturerurl() {
        return picturerurl;
    }

    public void setPicturerurl(String picturerurl) {
         this.picturerurl = picturerurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
         this.videourl = videourl;
    }

}