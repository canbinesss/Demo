package com.example.service;

import com.example.entity.Course;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CourseService extends ServiceImpl<CourseMapper, Course> {

    @Resource
    private CourseMapper courseMapper;

    public List<Course> getlist() {
        return courseMapper.getlist();
    }

    public void saveCollection(Map<String, Object> map) {
        courseMapper.saveCollection(map);
    }

    public Integer getCollection(Map<String, Object> map) {
        return courseMapper.getCollection(map);
    }

    public void removeCollection(Map<String, Object> map) {
        courseMapper.removeCollection(map);
    }

    public List<Course> getlistByCoachName(String coachname) {
        return courseMapper.getlistByCoachName(coachname);
    }

    public List<Course> getAlllist() {
        return courseMapper.getAlllist();
    }

    public List<Course> getAlllistforuser(Long id) {
        return courseMapper.getAlllist();
    }

    public List<Map<String, Object>> getCollectionbyUserId(Long id) {
        return courseMapper.getCollectionbyUserId(id);
    }
}