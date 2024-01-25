//package com.itranswarp.learnjava;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
//@Mapper
//public interface EmployeeMyBatisRepository {
//    @Select("select * from employees")
//    public List<Employee> findAll();
//
//    @Select("select * from employees where id = #{id}")
//    public Employee findById(long  id);
//}
