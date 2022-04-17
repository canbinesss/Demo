package com.example.controller;

import com.example.config.Result;
import com.example.entity.Goods;
import com.example.service.ChgDetailService;
import com.example.service.GoodsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private ChgDetailService chgDetailService;

    @PostMapping
    public Result<?> save(@RequestBody Goods goods) {
        return Result.success(goodsService.save(goods));
    }

    @PutMapping
    public Result<?> update(@RequestBody Goods goods) {
        return Result.success(goodsService.updateById(goods));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        goodsService.removeById(id);
        return Result.success();
    }
    @GetMapping("/getAllnum")
    public Result<String> getAllnum() {
        return Result.success(goodsService.getAllnum().toString());
    }

    @GetMapping("/{id}")
    public Result<Goods> findById(@PathVariable Long id) {
        return Result.success(goodsService.getById(id));
    }

    @GetMapping
    public Result<List<Goods>> findAll() {
        return Result.success(goodsService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Goods>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(goodsService.page(new Page<>(pageNum, pageSize), Wrappers.<Goods>lambdaQuery().like(Goods::getGoodsname, name)));
    }
    @GetMapping("/getnum")
    public Result<Map> findGoodsNum() {
        List newlist = new ArrayList();
        List<Map> getnum = this.goodsService.getnum();

        List<Map<String,Object>> list = (List) getnum;
        List l = new ArrayList();
        for (Map<String, Object> stringObjectMap : list) {
            Map<String,Object> map = new HashMap<>();
            l.add(stringObjectMap.get("goodsname"));
            map.put("name",stringObjectMap.get("goodsname"));
            map.put("value",stringObjectMap.get("num"));
            newlist.add(map);
        }

        Map m = new HashMap();
        m.put("datelist",l);
        m.put("datemap",newlist);
        return Result.success(m);
    }

    @GetMapping("/getxltj")
    public Result<List<HashMap>> getxltj(){
        List<HashMap> goodses = new ArrayList<HashMap>();
        goodses = chgDetailService.getgoods();
        return new Result<>(goodses);
    }

}