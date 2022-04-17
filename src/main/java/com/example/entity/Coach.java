package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;


@TableName("t_coach")
public class Coach extends Model<Coach> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
      * 教练名称 
      */
    private String coachname;

    /**
      * 教练电话 
      */
    private String coachphone;

    /**
      * 教练性别 
      */
    private String coachsex;

    /**
      * 家庭住址 
      */
    private String unit;

    /**
      * 工作时间 
      */
    private Date worktime;

    /**
      * 教练状态 
      */
    private String coachstate;

    /**
      * 教龄 
      */
    private String teachingage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
         this.id = id;
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
         this.coachname = coachname;
    }

    public String getCoachphone() {
        return coachphone;
    }

    public void setCoachphone(String coachphone) {
         this.coachphone = coachphone;
    }

    public String getCoachsex() {
        return coachsex;
    }

    public void setCoachsex(String coachsex) {
         this.coachsex = coachsex;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
         this.unit = unit;
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
         this.worktime = worktime;
    }

    public String getCoachstate() {
        return coachstate;
    }

    public void setCoachstate(String coachstate) {
         this.coachstate = coachstate;
    }

    public String getTeachingage() {
        return teachingage;
    }

    public void setTeachingage(String teachingage) {
         this.teachingage = teachingage;
    }

}