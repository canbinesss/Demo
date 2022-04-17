package com.example.controller;

import com.example.config.Result;
import com.example.entity.Order;
import com.example.service.OrderService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
     private OrderService orderService;

    @PostMapping
    public Result<?> save(@RequestBody Order order) {
        return Result.success(orderService.save(order));
    }

    @PutMapping
    public Result<?> update(@RequestBody Order order) {
        return Result.success(orderService.updateById(order));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        orderService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Order> findById(@PathVariable Long id) {
        return Result.success(orderService.getById(id));
    }

    @GetMapping
    public Result<List<Order>> findAll() {
        return Result.success(orderService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Order>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(orderService.page(new Page<>(pageNum, pageSize), Wrappers.<Order>lambdaQuery().like(Order::getInvcode, name).orderByDesc(Order::getState)));
    }

}