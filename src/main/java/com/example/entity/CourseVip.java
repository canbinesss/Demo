package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;


@TableName("t_course_vip")
public class CourseVip extends Model<CourseVip> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 课程id 
      */
    private String courseid;

    /**
      * 会员id 
      */
    private String vipid;

    /**
      * 选课时间 
      */
    private Date date;

    /**
      * 选课节数 
      */
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
         this.courseid = courseid;
    }

    public String getVipid() {
        return vipid;
    }

    public void setVipid(String vipid) {
         this.vipid = vipid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
         this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
         this.num = num;
    }

}