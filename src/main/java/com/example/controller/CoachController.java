package com.example.controller;

import com.example.config.Result;
import com.example.entity.Coach;
import com.example.service.CoachService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {
    @Resource
     private CoachService coachService;

    @PostMapping
    public Result<?> save(@RequestBody Coach coach) {
        return Result.success(coachService.save(coach));
    }

    @PutMapping
    public Result<?> update(@RequestBody Coach coach) {
        return Result.success(coachService.updateById(coach));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        coachService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Coach> findById(@PathVariable Long id) {
        return Result.success(coachService.getById(id));
    }

    @GetMapping
    public Result<List<Coach>> findAll() {
        return Result.success(coachService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Coach>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(coachService.page(new Page<>(pageNum, pageSize), Wrappers.<Coach>lambdaQuery().like(Coach::getCoachname, name)));
    }

}