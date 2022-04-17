package com.example.controller;

import com.example.config.Result;
import com.example.entity.Account;
import com.example.entity.RenewalLog;
import com.example.service.RenewalLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/renewalLog")
public class RenewalLogController {
    @Resource
     private RenewalLogService renewalLogService;

    @PostMapping
    public Result<?> save(@RequestBody RenewalLog renewalLog) {
        return Result.success(renewalLogService.save(renewalLog));
    }

    @PutMapping
    public Result<?> update(@RequestBody RenewalLog renewalLog) {
        return Result.success(renewalLogService.updateById(renewalLog));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        renewalLogService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<RenewalLog> findById(@PathVariable Long id) {
        return Result.success(renewalLogService.getById(id));
    }

    @GetMapping
    public Result<List<RenewalLog>> findAll() {
        return Result.success(renewalLogService.list());
    }

    @GetMapping("/page")
    public Result<IPage<RenewalLog>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(renewalLogService.page(new Page<>(pageNum, pageSize), Wrappers.<RenewalLog>lambdaQuery().like(RenewalLog::getUsername, name)));
    }
    @GetMapping("/pages")
    public Result<IPage<RenewalLog>> findPages(HttpServletRequest request,@RequestParam(required = false, defaultValue = "") String name,
                                               @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                               @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        Account account = (Account) request.getSession().getAttribute("account");
        return Result.success(renewalLogService.page(new Page<>(pageNum, pageSize), Wrappers.<RenewalLog>lambdaQuery().like(RenewalLog::getUsername, name).eq(RenewalLog::getUsername,account.getUsername()).orderByDesc(RenewalLog::getDate)));
    }

}