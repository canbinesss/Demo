package com.example.controller;

import com.example.config.Result;
import com.example.entity.Account;
import com.example.entity.Goods;
import com.example.entity.GoodsIn;
import com.example.service.GoodsInService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/goodsIn")
public class GoodsInController {
    @Resource
     private GoodsInService goodsInService;
    @Resource
     private GoodsService goodsService;

    @PostMapping
    public Result<?> save(@RequestBody GoodsIn goodsIn) {
        Integer innum = goodsIn.getInnum();
        Integer inventory = goodsIn.getInventory();
        inventory = innum+ inventory;
        String goodsname = goodsIn.getGoodsname();
        Goods goods = new Goods();
        goods.setNum(inventory);
        goods.setGoodsname(goodsname);
        goodsService.editnumbyname(goods);
        return Result.success(goodsInService.save(goodsIn));
    }

    @PutMapping
    public Result<?> update(@RequestBody GoodsIn goodsIn) {
        return Result.success(goodsInService.updateById(goodsIn));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        goodsInService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<GoodsIn> findById(@PathVariable Long id) {
        return Result.success(goodsInService.getById(id));
    }

    @GetMapping
    public Result<List<GoodsIn>> findAll() {
        return Result.success(goodsInService.list());
    }

    @GetMapping("/page")
    public Result<IPage<GoodsIn>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(goodsInService.page(new Page<>(pageNum, pageSize), Wrappers.<GoodsIn>lambdaQuery().like(GoodsIn::getGoodsname, name)));
    }
    @GetMapping("/getGoods")
    public Result<List<Goods>> findGoods(HttpServletRequest request, HttpServletResponse respons) {
//        List<User> list = userService.getUserIdNameList();
//        List<Account> list = accountService.getUserIdNameList();
        return Result.success(goodsService.list());
    }
}