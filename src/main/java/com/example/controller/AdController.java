package com.example.controller;

import com.example.config.Result;
import com.example.entity.Ad;
import com.example.service.AdService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Resource
     private AdService adService;

    @PostMapping
    public Result<?> save(@RequestBody Ad ad) {
        return Result.success(adService.save(ad));
    }

    @PutMapping
    public Result<?> update(@RequestBody Ad ad) {
        return Result.success(adService.updateById(ad));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        adService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Ad> findById(@PathVariable Long id) {
        return Result.success(adService.getById(id));
    }

    @GetMapping
    public Result<List<Ad>> findAll() {
        return Result.success(adService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Ad>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(adService.page(new Page<>(pageNum, pageSize), Wrappers.<Ad>lambdaQuery().like(Ad::getAdp, name)));
    }

}