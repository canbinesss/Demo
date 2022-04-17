package com.example.controller;

import com.example.config.Result;
import com.example.entity.CourseVip;
import com.example.entity.LM;
import com.example.entity.User;
import com.example.service.LMService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lM")
public class LMController {
    @Resource
     private LMService lMService;

    @PostMapping
    public Result<?> save(@RequestBody LM lM) {
        return Result.success(lMService.save(lM));
    }

    @PutMapping
    public Result<?> update(@RequestBody LM lM) throws ParseException {
        LM one = lMService.getOne(Wrappers.<LM>lambdaQuery().eq(LM::getId, lM.getId()));
        lM.setLmdate(one.getLmdate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        Date parse = sdf.parse(format);
        lM.setReplydate(parse);
        return Result.success(lMService.updateById(lM));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        lMService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<LM> findById(@PathVariable Long id) {
        return Result.success(lMService.getById(id));
    }

    @GetMapping
    public Result<List<LM>> findAll() {
        return Result.success(lMService.list());
    }

    @GetMapping("/page")
    public Result<IPage<LM>> findPage(HttpServletRequest request, @RequestParam(required = false, defaultValue = "") String name,
                                      @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        return Result.success(lMService.page(new Page<>(pageNum, pageSize), Wrappers.<LM>lambdaQuery().like(LM::getUsername, name).eq(LM::getCoachname,user.getUsername())));
    }

}