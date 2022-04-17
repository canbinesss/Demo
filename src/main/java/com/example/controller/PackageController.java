package com.example.controller;

import com.example.config.Result;
import com.example.entity.Package;
import com.example.service.PackageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController {
    @Resource
     private PackageService packageService;

    @PostMapping
    public Result<?> save(@RequestBody Package packages) {
        return Result.success(packageService.save(packages));
    }

    @PutMapping
    public Result<?> update(@RequestBody Package packages) {
        return Result.success(packageService.updateById(packages));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        packageService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Package> findById(@PathVariable Long id) {
        return Result.success(packageService.getById(id));
    }

    @GetMapping
    public Result<List<Package>> findAll() {
        return Result.success(packageService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Package>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(packageService.page(new Page<>(pageNum, pageSize), Wrappers.<Package>lambdaQuery().like(Package::getPackagetype, name)));
    }

}