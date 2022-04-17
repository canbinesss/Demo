package com.example.controller;

import com.example.config.Result;
import com.example.entity.Dynamic;
import com.example.service.DynamicService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {
    @Resource
     private DynamicService dynamicService;

    @PostMapping
    public Result<?> save(@RequestBody Dynamic dynamic) {
        return Result.success(dynamicService.save(dynamic));
    }

    @PutMapping
    public Result<?> update(@RequestBody Dynamic dynamic) {
        return Result.success(dynamicService.updateById(dynamic));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        dynamicService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Dynamic> findById(@PathVariable Long id) {
        return Result.success(dynamicService.getById(id));
    }

    @GetMapping
    public Result<List<Dynamic>> findAll() {
        return Result.success(dynamicService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Dynamic>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(dynamicService.page(new Page<>(pageNum, pageSize), Wrappers.<Dynamic>lambdaQuery().like(Dynamic::getUsername, name)));
    }

}