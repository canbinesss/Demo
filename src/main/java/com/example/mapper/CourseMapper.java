package com.example.mapper;

import com.example.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface CourseMapper extends BaseMapper<Course> {

    List<Course> getlist();

    void saveCollection(Map<String, Object> map);

    Integer getCollection(Map<String, Object> map);

    void removeCollection(Map<String, Object> map);

    List<Course> getlistByCoachName(String coachname);

    List<Course> getAlllist();

    List<Map<String, Object>> getCollectionbyUserId(Long id);
}