package com.example.mapper;

import com.example.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RecordMapper extends BaseMapper<Record> {

    List<HashMap> getyearinfo(String username);

    Integer gettime(HashMap map);
}