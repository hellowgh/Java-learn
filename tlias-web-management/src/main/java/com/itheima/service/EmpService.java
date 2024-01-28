package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize);

}
