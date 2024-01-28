package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Delete("INSERT INTO dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Update("UPDATE dept SET name = #{name}, create_time = #{createTime}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);
}
