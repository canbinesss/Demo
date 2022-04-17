package com.example.controller;

import com.example.config.Result;
import com.example.entity.Fofcs;
import com.example.service.FofcsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/fofcs")
public class FofcsController {
    @Resource
     private FofcsService fofcsService;

    @PostMapping
    public Result<?> save(@RequestBody Fofcs fofcs) {
        return Result.success(fofcsService.save(fofcs));
    }

    @PutMapping
    public Result<?> update(@RequestBody Fofcs fofcs) {
        return Result.success(fofcsService.updateById(fofcs));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        fofcsService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Fofcs> findById(@PathVariable Long id) {
        return Result.success(fofcsService.getById(id));
    }

    @GetMapping
    public Result<List<Fofcs>> findAll() {
        return Result.success(fofcsService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Fofcs>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(fofcsService.page(new Page<>(pageNum, pageSize), Wrappers.<Fofcs>lambdaQuery().like(Fofcs::getCscontent, name)));
    }

}