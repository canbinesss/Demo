package com.example.controller;

import com.example.config.Result;
import com.example.entity.Account;
import com.example.entity.SignIn;
import com.example.entity.UserVip;
import com.example.service.SignInService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.UserVipService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/signIn")
public class SignInController {
    @Resource
     private SignInService signInService;
    @Resource
     private UserVipService userVipService;

    @PostMapping
    public Result<?> save(@RequestBody SignIn signIn) {
//        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        signIn.setIntime(new Date());
        return Result.success(signInService.save(signIn));
    }

    @PutMapping
    public Result<?> update(@RequestBody SignIn signIn) {
        return Result.success(signInService.updateById(signIn));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        signInService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<SignIn> findById(@PathVariable Long id) {
        return Result.success(signInService.getById(id));
    }

    @GetMapping
    public Result<List<SignIn>> findAll() {
        return Result.success(signInService.list());
    }

    @GetMapping("/page")
    public Result<IPage<SignIn>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(signInService.page(new Page<>(pageNum, pageSize), Wrappers.<SignIn>lambdaQuery().like(SignIn::getUsername, name)));
    }
    @GetMapping("/getVipUser")
    public Result<List<UserVip>> findVipUser(HttpServletRequest request, HttpServletResponse respons) {
        return Result.success(userVipService.list());
    }
}