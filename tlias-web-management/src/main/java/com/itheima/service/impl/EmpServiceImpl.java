package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        // 3. 封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void remove(List<Integer> ids) {
        empMapper.remove(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDate.from(LocalDateTime.now()));
        emp.setUpdateTime(LocalDate.from(LocalDateTime.now()));

        empMapper.insert(emp);
    }

    @Override
    public Emp findById(Integer id) {
        return empMapper.findById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDate.from(LocalDateTime.now()));

        empMapper.update(emp);
    }
}
