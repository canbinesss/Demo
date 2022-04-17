package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("t_equipment")
public class Equipment extends Model<Equipment> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 器材名称 
      */
    private String equipmentname;

    /**
      * 器材数量 
      */
    private Integer num;

    /**
      * 器材图片 
      */
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
         this.equipmentname = equipmentname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
         this.num = num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
         this.url = url;
    }

}