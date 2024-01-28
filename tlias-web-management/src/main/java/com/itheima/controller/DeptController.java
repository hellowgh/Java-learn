package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("query all depts");
        return Result.success(deptService.list());
    }

    /**
     * delete dept by id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.warn("delete dept by id: {}",  id); // 输出时，{}被id替换

        deptService.deleteById(id);

        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("add dept: {}", dept);

        deptService.insert(dept);

        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        Integer id = dept.getId();

        log.info("update dept {}", id);

        deptService.update(dept);

        return Result.success();
    }
}
