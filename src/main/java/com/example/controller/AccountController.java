package com.example.controller;

import com.example.config.Result;
import com.example.dto.Order;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.service.AccountService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/account")
public class AccountController {
    public static final ConcurrentHashMap<String, Account> MAP = new ConcurrentHashMap<>();

    @Resource
    private AccountService accountService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 登录
     *
     * @param account
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result<Map> login(@RequestBody Account account, HttpServletRequest request) {
        Account res = accountService.login(account);
        Map map = new HashMap();

        request.getSession().setAttribute("accountName", account.getUsername());
        MAP.put(res.getUsername(), res);
        request.getSession().setAttribute("account", res);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        String username = res.getUsername();
        Long id1 = res.getId();
        String user = id1+username;
        Object o = redisTemplate.opsForValue().get(user);
        List<Order> list = new ArrayList<>();
        Integer num = 0;
        if(o != null){
            list = (List<Order>) o;
            num = list.size();
        }
        if(accountService.isVip(res.getId()) != null){
            request.getSession().setAttribute("vipfilg",true);
            res.setVipfilg(true);
            map.put("vipinfo",accountService.isVip(res.getId()));
        }else{
            request.getSession().setAttribute("vipfilg",false);
            res.setVipfilg(false);
        }
        map.put("account",res);
        map.put("num",num);
        return Result.success(map);
    }

    /**
     * 注册
     *
     * @param account
     * @param request
     * @return
     */
    @PostMapping("/register")
    public Result<Account> register(@RequestBody Account account, HttpServletRequest request) {
        account.setAvatar("/files/1618158897664");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        account.setRegistdate(sdf.format(new Date()));
        if (account.getPassworld() == null) {
            account.setPassworld("123456");
        }
        Account dbAccount = accountService.register(account);
        request.getSession().setAttribute("account", account);
        return Result.success(dbAccount);
    }

    @GetMapping("/logout")
    public Result<?> logout(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        String username = account.getUsername();
        Long id1 = account.getId();
        String user = id1+username;
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        if (account != null) {
            request.getSession().removeAttribute("account");
            MAP.remove(account.getUsername());
        }

        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody Account account) {
//        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        account.setRegistdate(sp.format(new Date()));
        return Result.success(accountService.save(account));
    }

    @PutMapping
    public Result<?> update(@RequestBody Account account) {
        return Result.success(accountService.updateById(account));
    }

    @PostMapping("/upa")
    public Result<?> upa(HttpServletRequest request,@RequestBody Account account) {
        request.getSession().setAttribute("account",account);
        return Result.success(accountService.updateById(account));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        accountService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Account> findById(@PathVariable Long id) {
        return Result.success(accountService.getById(id));
    }
    @GetMapping("/detail")
    public Result<Account> findById(@RequestParam(required = false, defaultValue = "") String id) {
        return Result.success(accountService.getById(id));
    }

    @GetMapping
    public Result<List<Account>> findAll() {
        return Result.success(accountService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Account>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(accountService.page(new Page<>(pageNum, pageSize), Wrappers.<Account>lambdaQuery().like(Account::getUsername, name)));
    }

    @GetMapping("/detail/{username}")
    public Result<Account> findByUsername(@PathVariable String username) {
        return Result.success(accountService.getbyAccountname(username));
    }



}