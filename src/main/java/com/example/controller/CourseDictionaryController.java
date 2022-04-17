package com.example.controller;

import com.example.config.Result;
import com.example.entity.CourseDictionary;
import com.example.service.CourseDictionaryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/courseDictionary")
public class CourseDictionaryController {
    @Resource
     private CourseDictionaryService courseDictionaryService;

    @PostMapping
    public Result<?> save(@RequestBody CourseDictionary courseDictionary) {
        return Result.success(courseDictionaryService.save(courseDictionary));
    }

    @PutMapping
    public Result<?> update(@RequestBody CourseDictionary courseDictionary) {
        return Result.success(courseDictionaryService.updateById(courseDictionary));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        courseDictionaryService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<CourseDictionary> findById(@PathVariable Long id) {
        return Result.success(courseDictionaryService.getById(id));
    }

    @GetMapping
    public Result<List<CourseDictionary>> findAll() {
        return Result.success(courseDictionaryService.list());
    }

    @GetMapping("/page")
    public Result<IPage<CourseDictionary>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(courseDictionaryService.page(new Page<>(pageNum, pageSize), Wrappers.<CourseDictionary>lambdaQuery().like(CourseDictionary::getName, name)));
    }

}