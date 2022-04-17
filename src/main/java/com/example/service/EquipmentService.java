package com.example.service;

import com.example.entity.Equipment;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EquipmentService extends ServiceImpl<EquipmentMapper, Equipment> {

    @Resource
    private EquipmentMapper equipmentMapper;

}