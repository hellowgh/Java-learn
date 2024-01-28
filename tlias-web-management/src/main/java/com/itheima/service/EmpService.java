package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface EmpService {

    public Long total();

    public PageBean page(Long page, Long pageSize);

}
