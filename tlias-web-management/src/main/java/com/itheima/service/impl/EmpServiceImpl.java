package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Long total() {
        return empMapper.total();
    }

    @Override
    public PageBean page(Long page, Long pageSize) {
        Long total = empMapper.total();

        List<Emp> empList = empMapper.page(page, pageSize);

        return new PageBean(total, empList);
    }
}
