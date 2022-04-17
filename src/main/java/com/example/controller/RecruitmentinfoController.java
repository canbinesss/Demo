package com.example.controller;

import com.example.config.Result;
import com.example.entity.Recruitmentinfo;
import com.example.service.RecruitmentinfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/recruitmentinfo")
public class RecruitmentinfoController {
    @Resource
     private RecruitmentinfoService recruitmentinfoService;

    @PostMapping
    public Result<?> save(@RequestBody Recruitmentinfo recruitmentinfo) {
        return Result.success(recruitmentinfoService.save(recruitmentinfo));
    }

    @PutMapping
    public Result<?> update(@RequestBody Recruitmentinfo recruitmentinfo) {
        return Result.success(recruitmentinfoService.updateById(recruitmentinfo));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        recruitmentinfoService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Recruitmentinfo> findById(@PathVariable Long id) {
        return Result.success(recruitmentinfoService.getById(id));
    }

    @GetMapping
    public Result<List<Recruitmentinfo>> findAll() {
        return Result.success(recruitmentinfoService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Recruitmentinfo>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(recruitmentinfoService.page(new Page<>(pageNum, pageSize), Wrappers.<Recruitmentinfo>lambdaQuery().like(Recruitmentinfo::getRecruittitle, name)));
    }

}