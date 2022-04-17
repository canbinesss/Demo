package com.example.controller;

import com.example.config.Result;
import com.example.entity.Equipment;
import com.example.service.EquipmentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Resource
     private EquipmentService equipmentService;

    @PostMapping
    public Result<?> save(@RequestBody Equipment equipment) {
        return Result.success(equipmentService.save(equipment));
    }

    @PutMapping
    public Result<?> update(@RequestBody Equipment equipment) {
        return Result.success(equipmentService.updateById(equipment));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        equipmentService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Equipment> findById(@PathVariable Long id) {
        return Result.success(equipmentService.getById(id));
    }

    @GetMapping
    public Result<List<Equipment>> findAll() {
        return Result.success(equipmentService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Equipment>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(equipmentService.page(new Page<>(pageNum, pageSize), Wrappers.<Equipment>lambdaQuery().like(Equipment::getEquipmentname, name)));
    }

}