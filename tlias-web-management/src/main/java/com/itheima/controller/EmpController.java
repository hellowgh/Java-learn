package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.TestComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * 分页查询结果的封装类
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private TestComponent testComponent;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info("分页查询，参数：{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);

        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    @Log
    public Result remove(@PathVariable List<Integer> ids) {
        log.info("删除员工，id是：{}", ids);

        empService.remove(ids);

        return Result.success();
    }

    @PostMapping
    @Log
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工，emp：{}", emp);

        empService.save(emp);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        log.info("find employee by id: {}", id);

        Emp emp = empService.findById(id);

        if (Objects.isNull(emp)) {
            return Result.error("not exist");
        }

        return Result.success(emp);
    }

    @PutMapping
    @Log
    public Result update(@RequestBody Emp emp) {
        Integer id = emp.getId();

        log.info("update by id: {}", id);

        empService.update(emp);

        return Result.success();
    }


    /**
     * 测试阿里云存储
     * @return
     */
    @GetMapping("/test")
    public Result test() {
        testComponent.test();

        return Result.success();
    }

}
