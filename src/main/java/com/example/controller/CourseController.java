package com.example.controller;

import com.example.config.Result;
import com.example.entity.Account;
import com.example.entity.Coach;
import com.example.entity.Course;
import com.example.entity.CourseDictionary;
import com.example.service.CoachService;
import com.example.service.CourseDictionaryService;
import com.example.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
     private CourseService courseService;
    @Resource
     private CoachService coachService;
    @Resource
     private CourseDictionaryService courseDictionaryService;

    @PostMapping
    public Result<?> save(@RequestBody Course course) {
        return Result.success(courseService.save(course));
    }

    @PutMapping
    public Result<?> update(@RequestBody Course course) {
        return Result.success(courseService.updateById(course));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        courseService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Course> findById(@PathVariable Long id) {
        return Result.success(courseService.getById(id));
    }

    @GetMapping
    public Result<List<Course>> findAll() {
        return Result.success(courseService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Course>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(courseService.page(new Page<>(pageNum, pageSize), Wrappers.<Course>lambdaQuery().like(Course::getCourse, name)));
    }
    @GetMapping("/getCoach")
    public Result<List<Coach>> findCoach(HttpServletRequest request, HttpServletResponse respons) {
//        List<User> list = userService.getUserIdNameList();
//        List<Account> list = accountService.getUserIdNameList();
        return Result.success(coachService.list());
    }
    @GetMapping("/getCourse")
    public Result<List<CourseDictionary>> findCourse(HttpServletRequest request, HttpServletResponse respons) {
//        List<User> list = userService.getUserIdNameList();
//        List<Account> list = accountService.getUserIdNameList();
        return Result.success(courseDictionaryService.list());
    }
}