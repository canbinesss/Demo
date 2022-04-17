package com.example.controller;

import com.example.config.Result;
import com.example.entity.ChgInvoice;
import com.example.service.ChgInvoiceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/chgInvoice")
public class ChgInvoiceController {
    @Resource
     private ChgInvoiceService chgInvoiceService;

    @PostMapping
    public Result<?> save(@RequestBody ChgInvoice chgInvoice) {
        return Result.success(chgInvoiceService.save(chgInvoice));
    }

    @PutMapping
    public Result<?> update(@RequestBody ChgInvoice chgInvoice) {
        return Result.success(chgInvoiceService.updateById(chgInvoice));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        chgInvoiceService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<ChgInvoice> findById(@PathVariable Long id) {
        return Result.success(chgInvoiceService.getById(id));
    }

    @GetMapping
    public Result<List<ChgInvoice>> findAll() {
        return Result.success(chgInvoiceService.list());
    }

    @GetMapping("/page")
    public Result<IPage<ChgInvoice>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(chgInvoiceService.page(new Page<>(pageNum, pageSize), Wrappers.<ChgInvoice>lambdaQuery().like(ChgInvoice::getUsername, name)));
    }

}