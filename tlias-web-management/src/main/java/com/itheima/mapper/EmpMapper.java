package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("SELECT COUNT(*) FROM emp")
    Long total();


    @Select("SELECT * FROM emp limit #{page}, #{pageSize}")
    List<Emp> page(Long page, Long pageSize);
}
