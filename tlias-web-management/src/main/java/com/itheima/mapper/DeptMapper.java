package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * query all depts
     * @return
     */
    @Select("SELECT * FROM dept")
    List<Dept> list();

    @Select("DELETE FROM dept WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("INSERT INTO dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

}
