package com.example.service;

import com.example.entity.Record;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.RecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class RecordService extends ServiceImpl<RecordMapper, Record> {

    @Resource
    private RecordMapper recordMapper;

    public List<HashMap> getyearinfo(String username) {
        return recordMapper.getyearinfo(username);
    }

    public Integer gettime(HashMap map) {
        return recordMapper.gettime(map);
    }
}