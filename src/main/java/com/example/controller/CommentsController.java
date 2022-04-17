package com.example.controller;

import com.example.config.Result;
import com.example.entity.Comments;
import com.example.service.CommentsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Resource
     private CommentsService commentsService;

    @PostMapping
    public Result<?> save(@RequestBody Comments comments) {
        return Result.success(commentsService.save(comments));
    }

    @PutMapping
    public Result<?> update(@RequestBody Comments comments) {
        return Result.success(commentsService.updateById(comments));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        commentsService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Comments> findById(@PathVariable Long id) {
        return Result.success(commentsService.getById(id));
    }

    @GetMapping
    public Result<List<Comments>> findAll() {
        return Result.success(commentsService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Comments>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(commentsService.page(new Page<>(pageNum, pageSize), Wrappers.<Comments>lambdaQuery().like(Comments::getCommentsname, name)));
    }

}