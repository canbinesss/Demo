package com.example.mapper;

import com.example.entity.Coach;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CoachMapper extends BaseMapper<Coach> {

    List<HashMap> getlist();

    HashMap<String, Object> getvideocoach(String coachname);

    void saveFollow(Map<String, Object> map);

    Integer getFollow(Map<String, Object> map);

    void removeFollow(Map<String, Object> map);

    HashMap<String, Object> getCoachbyId(String id);

    List<HashMap> getAlllist();

    List<Map<String, Object>> getFollowbyUserId(Long id);
}