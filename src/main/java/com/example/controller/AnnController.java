package com.example.controller;

import com.example.config.Result;
import com.example.entity.Ann;
import com.example.service.AnnService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ann")
public class AnnController {
    @Resource
     private AnnService annService;

    @PostMapping
    public Result<?> save(@RequestBody Ann ann) {
        return Result.success(annService.save(ann));
    }

    @PutMapping
    public Result<?> update(@RequestBody Ann ann) {
        return Result.success(annService.updateById(ann));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        annService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Ann> findById(@PathVariable Long id) {
        return Result.success(annService.getById(id));
    }

    @GetMapping
    public Result<List<Ann>> findAll() {
        return Result.success(annService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Ann>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(annService.page(new Page<>(pageNum, pageSize), Wrappers.<Ann>lambdaQuery().like(Ann::getAnnTitle, name)));
    }

}