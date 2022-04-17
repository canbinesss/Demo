package com.example.service;

import com.example.entity.Coach;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.CoachMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoachService extends ServiceImpl<CoachMapper, Coach> {

    @Resource
    private CoachMapper coachMapper;

    public List<HashMap> getlist() {
        return coachMapper.getlist();
    }

    public HashMap<String, Object> getvideocoach(String coachname) {
        return coachMapper.getvideocoach(coachname);
    }

    public void saveFollow(Map<String, Object> map) {
        coachMapper.saveFollow(map);
    }

    public Integer getFollow(Map<String, Object> map) {
        return coachMapper.getFollow(map);
    }

    public void removeFollow(Map<String, Object> map) {
        coachMapper.removeFollow(map);
    }

    public HashMap<String, Object> getCoachbyId(String id) {
        return coachMapper.getCoachbyId(id);
    }

    public List<HashMap> getAlllist() {
        return coachMapper.getAlllist();
    }

    public List<Map<String, Object>> getFollowbyUserId(Long id) {
        return coachMapper.getFollowbyUserId(id);
    }

}