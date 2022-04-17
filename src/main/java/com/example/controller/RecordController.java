package com.example.controller;

import com.example.config.Result;
import com.example.entity.Account;
import com.example.entity.Record;
import com.example.service.RecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Resource
     private RecordService recordService;

    @PostMapping
    public Result<?> save(HttpServletRequest request, @RequestBody Record record) {
        Account account = (Account) request.getSession().getAttribute("account");
        record.setUserid(Integer.parseInt(account.getId().toString()));
        return Result.success(recordService.save(record));
    }

    @PutMapping
    public Result<?> update(@RequestBody Record record) {
        return Result.success(recordService.updateById(record));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        recordService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Record> findById(@PathVariable Long id) {
        return Result.success(recordService.getById(id));
    }

    @GetMapping
    public Result<List<Record>> findAll() {
        return Result.success(recordService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Record>> findPage(HttpServletRequest request,@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        Account account = (Account) request.getSession().getAttribute("account");
        return Result.success(recordService.page(new Page<>(pageNum, pageSize), Wrappers.<Record>lambdaQuery().like(Record::getUsername, name).eq(Record::getUsername,account.getUsername())));
    }

}