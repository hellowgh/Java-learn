package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * get all depts
     * @return
     */
    List<Dept> list();

    /**
     * delete dept by id
     * @param id
     */
    void deleteById(Integer id);

    /**
     * insert dept
     * @param dept
     */
    void insert(Dept dept) ;

    /**
     * update dept by id
     * @param id
     * @param dept
     */
    void update(Dept dept);
}
