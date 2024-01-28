package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        log.info("query all depts");
        return Result.success(deptService.list());
    }

    /**
     * delete dept by id
     * @param id
     * @return
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.warn("delete dept by id: {}",  id); // 输出时，{}被id替换

        deptService.deleteById(id);

        return Result.success();
    }

}
