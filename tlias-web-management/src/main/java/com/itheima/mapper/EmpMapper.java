package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void remove(List<Integer> ids);

    // id在数据库中设置的是自增的，密码有默认值。两者不需要设置。
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp findById(Integer id);

    void update(Emp emp);


    // mistake 这里犯过一个小错误，将sql语句的and写成了&
    /**
     * 根据用户名和密码查询用户
     * @param emp
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp findByUsernameAndPassword(Emp emp);

    /**
     * 根据部门id删除员工
     * @param deptId 部门id
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void removeEmpsByDeptId(Integer deptId);
}
