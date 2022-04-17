package com.example.controller;

import com.example.config.Result;
import com.example.entity.Invoice;
import com.example.service.InvoiceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Resource
     private InvoiceService invoiceService;

    @PostMapping
    public Result<?> save(@RequestBody Invoice invoice) {
        return Result.success(invoiceService.save(invoice));
    }

    @PutMapping
    public Result<?> update(@RequestBody Invoice invoice) {
        return Result.success(invoiceService.updateById(invoice));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        invoiceService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Invoice> findById(@PathVariable Long id) {
        return Result.success(invoiceService.getById(id));
    }

    @GetMapping
    public Result<List<Invoice>> findAll() {
        return Result.success(invoiceService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Invoice>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(invoiceService.page(new Page<>(pageNum, pageSize), Wrappers.<Invoice>lambdaQuery().like(Invoice::getApplicant, name)));
    }

}