package com.example.controller;

import com.example.config.Result;
import com.example.entity.CourseVip;
import com.example.service.CourseVipService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/courseVip")
public class CourseVipController {
    @Resource
     private CourseVipService courseVipService;

    @PostMapping
    public Result<?> save(@RequestBody CourseVip courseVip) {
        return Result.success(courseVipService.save(courseVip));
    }

    @PutMapping
    public Result<?> update(@RequestBody CourseVip courseVip) {
        return Result.success(courseVipService.updateById(courseVip));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        courseVipService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<CourseVip> findById(@PathVariable Long id) {
        return Result.success(courseVipService.getById(id));
    }

    @GetMapping
    public Result<List<CourseVip>> findAll() {
        return Result.success(courseVipService.list());
    }

    @GetMapping("/page")
    public Result<IPage<CourseVip>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(courseVipService.page(new Page<>(pageNum, pageSize), Wrappers.<CourseVip>lambdaQuery().like(CourseVip::getCourseid, name)));
    }

}