package com.example.controller;

import com.example.config.Result;
import com.example.entity.Goods;
import com.example.entity.GoodsOut;
import com.example.service.GoodsOutService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goodsOut")
public class GoodsOutController {
    @Resource
     private GoodsOutService goodsOutService;
    @Resource
     private GoodsService goodsService;

    @PostMapping
    public Result<?> save(@RequestBody GoodsOut goodsOut) {
        Integer innum = goodsOut.getOutnum();
        Integer inventory = goodsService.getnumByName(goodsOut.getGoodsName());
        inventory = inventory - innum;
        String goodsname = goodsOut.getGoodsName();
        Goods goods = new Goods();
        goods.setNum(inventory);
        goods.setGoodsname(goodsname);
        goodsService.editnumbyname(goods);
        return Result.success(goodsOutService.save(goodsOut));
    }

    @PutMapping
    public Result<?> update(@RequestBody GoodsOut goodsOut) {
        return Result.success(goodsOutService.updateById(goodsOut));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        goodsOutService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<GoodsOut> findById(@PathVariable Long id) {
        return Result.success(goodsOutService.getById(id));
    }

    @GetMapping
    public Result<List<GoodsOut>> findAll() {
        return Result.success(goodsOutService.list());
    }

    @GetMapping("/page")
    public Result<IPage<GoodsOut>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(goodsOutService.page(new Page<>(pageNum, pageSize), Wrappers.<GoodsOut>lambdaQuery().like(GoodsOut::getGoodsName, name)));
    }

}