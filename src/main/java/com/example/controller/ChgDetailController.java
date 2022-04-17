package com.example.controller;

import com.example.config.Result;
import com.example.entity.ChgDetail;
import com.example.service.ChgDetailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/chgDetail")
public class ChgDetailController {
    @Resource
     private ChgDetailService chgDetailService;

    @PostMapping
    public Result<?> save(@RequestBody ChgDetail chgDetail) {
        return Result.success(chgDetailService.save(chgDetail));
    }

    @PutMapping
    public Result<?> update(@RequestBody ChgDetail chgDetail) {
        return Result.success(chgDetailService.updateById(chgDetail));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        chgDetailService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<ChgDetail> findById(@PathVariable Long id) {
        return Result.success(chgDetailService.getById(id));
    }

    @GetMapping
    public Result<List<ChgDetail>> findAll() {
        return Result.success(chgDetailService.list());
    }

    @GetMapping("/page")
    public Result<IPage<ChgDetail>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(chgDetailService.page(new Page<>(pageNum, pageSize), Wrappers.<ChgDetail>lambdaQuery().like(ChgDetail::getGoodsname, name)));
    }

}