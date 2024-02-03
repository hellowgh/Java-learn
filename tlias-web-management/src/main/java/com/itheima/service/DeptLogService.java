package com.itheima.service;

import com.itheima.pojo.DeptLog;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface DeptLogService {
    // 重新开启一个新事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void insert(DeptLog deptLog);
}
