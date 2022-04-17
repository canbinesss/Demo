package com.example.controller;

import com.example.config.Result;
import com.example.entity.*;
import com.example.entity.Package;
import com.example.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userVip")
public class UserVipController {
    @Resource
     private UserVipService userVipService;
    @Resource
     private AccountService accountService;
    @Resource
     private PackageService packageService;
    @Resource
     private RenewalLogService renewalLogService;
    @Resource
     private UserService userService;

    @PostMapping
    public Result<?> save(@RequestBody UserVip userVip) {
        BigDecimal vipmoney = userVip.getVipmoney();
        String cardtype = userVip.getCardtype();
        if(cardtype.indexOf(":") != -1){
            cardtype = cardtype.split(":")[0];
        }
        userVip.setCardtype(cardtype);
        BigDecimal cardMoney = packageService.getCardMoneyByName(cardtype);
        BigDecimal ye =vipmoney.subtract(cardMoney);
        RenewalLog renewalLog = new RenewalLog();
            BigDecimal add = userVip.getVipmoney();
            BigDecimal money = packageService.getCardMoneyByName(userVip.getCardtype());
            BigDecimal subtract = add.subtract(money);

            renewalLog.setSprice(money.toString());
            renewalLog.setVipid(userVip.getUserid());
            renewalLog.setUsername(userVip.getUsername());
            renewalLog.setDate(new Date());
            Integer cardDay = packageService.getCardDayByName(userVip.getCardtype());
            renewalLog.setDays(cardDay.toString());
            renewalLog.setFilltype(userVip.getCardtype());
            renewalLog.setInsprice(userVip.getVipmoney().toString());
            renewalLog.setLoosechange(subtract.toString());
            renewalLogService.save(renewalLog);

            userVip.setVipmoney(subtract);
        userVip.setVipmoney(ye);
        String Cardtype = userVip.getCardtype();
        if(Cardtype.indexOf(":") != -1){
            Cardtype = Cardtype.split(":")[0];
        }
        userVip.setCardtype(Cardtype);
        return Result.success(userVipService.save(userVip));
    }

    @PutMapping
    public Result<?> update(@RequestBody UserVip userVip) {
        RenewalLog renewalLog = new RenewalLog();
        UserVip vip = userVipService.getUserVipeById(userVip.getId());
        String cardtype = userVip.getCardtype();
        if(cardtype.indexOf(":") != -1){
            cardtype = cardtype.split(":")[0];
        }
        userVip.setCardtype(cardtype);
        if (!userVip.getExpire().equals(vip.getExpire())) {
            BigDecimal add = userVip.getVipmoney().add(vip.getVipmoney());
            BigDecimal money = packageService.getCardMoneyByName(userVip.getCardtype());
            BigDecimal subtract = add.subtract(money);

            renewalLog.setSprice(money.toString());
            renewalLog.setVipid(userVip.getUserid());
            renewalLog.setUsername(userVip.getUsername());
            renewalLog.setDate(new Date());
            Integer cardDay = packageService.getCardDayByName(userVip.getCardtype());
            renewalLog.setDays(cardDay.toString());
            renewalLog.setFilltype(userVip.getCardtype());
            renewalLog.setInsprice(userVip.getVipmoney().toString());
            renewalLog.setLoosechange(subtract.toString());
            renewalLogService.save(renewalLog);

            userVip.setVipmoney(subtract);
        }
        String Cardtype = userVip.getCardtype();
        if(Cardtype.indexOf(":") != -1){
            Cardtype = Cardtype.split(":")[0];
        }
        return Result.success(userVipService.updateById(userVip));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        userVipService.removeById(id);
        return Result.success();
    }
    @GetMapping("/getnum")
    public Result<String> getnum() {
        return Result.success(userVipService.getnum().toString());
    }

    @GetMapping("/{id}")
    public Result<UserVip> findById(@PathVariable Long id) {
        return Result.success(userVipService.getById(id));
    }

    @GetMapping
    public Result<List<UserVip>> findAll() {
        return Result.success(userVipService.list());
    }

    @GetMapping("/page")
    public Result<IPage<UserVip>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(userVipService.page(new Page<>(pageNum, pageSize), Wrappers.<UserVip>lambdaQuery().like(UserVip::getUsername, name)));
    }
    @GetMapping("/getUser")
    public Result<List<Account>> findUser(HttpServletRequest request, HttpServletResponse respons) {
//        List<User> list = userService.getUserIdNameList();
//        List<Account> list = accountService.getUserIdNameList();
        return Result.success(accountService.list());
    }
    @GetMapping("/getCardType")
    public Result<List<Package>> findCardType(HttpServletRequest request, HttpServletResponse respons) {
//        List<User> list = userService.getUserIdNameList();
//        List<Account> list = accountService.getUserIdNameList();
        return Result.success(packageService.list());
    }
    @GetMapping("/getIdByUserName")
    public Integer getIdByUserName(HttpServletRequest request, HttpServletResponse respons,@RequestParam(required = false, defaultValue = "") String username) {
        Integer userid = userService.getIdbyUsername(username);
//        System.err.println(userid);
        return userid;
    }
    @GetMapping("/getCardDayByName")
    public Integer getCardDayByName(HttpServletRequest request, HttpServletResponse respons,@RequestParam(required = false, defaultValue = "") String CardName) {
        if(CardName.indexOf(":") != -1){
            CardName = CardName.split(":")[0];
        }
        Integer cardDay = packageService.getCardDayByName(CardName);
//        System.err.println(userid);
        return cardDay;
    }
    @PostMapping("/getCardMoneyByName")
    public boolean getCardMoneyByName(@RequestParam(required = false, defaultValue = "") String CardName,@RequestParam(required = false, defaultValue = "") String vipmoney) {
        if(CardName.indexOf(":") != -1){
            CardName = CardName.split(":")[0];
        }
        BigDecimal money = packageService.getCardMoneyByName(CardName);
        Double d = Double.parseDouble(vipmoney);
        Double d2 = Double.parseDouble(money.toString());
        if(d>=d2){
            return true;
        }else{
            return false;
        }
    }
    @PutMapping("/getCardMoneyByName")
    public boolean getCardMoneyByName2(@RequestBody UserVip userVip,@RequestParam(required = false, defaultValue = "") String CardName,@RequestParam(required = false, defaultValue = "") String vipmoney) {
        UserVip vip = userVipService.getUserVipeById(userVip.getId());
        BigDecimal add = userVip.getVipmoney().add(vip.getVipmoney());
        BigDecimal money = packageService.getCardMoneyByName(userVip.getCardtype());
        BigDecimal subtract = add.subtract(money);
        Double d = Double.parseDouble(subtract.toString());
        if(d>=0){
            return true;
        }else{
            return false;
        }
    }

}