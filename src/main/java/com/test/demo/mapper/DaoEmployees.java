package com.test.demo.mapper;

import com.test.demo.Entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DaoEmployees {
  /*@Select("select * from employees")*/
  List<Employee> findAll();
 /* @Insert("insert into employees(u_name,u_pwd) values(#{u_name},#{u_pwd})")*/
  boolean Insert(Employee employee);
 /* @Select("select * from employees where u_id=#{u_id}")*/
  Employee Getbyid(Integer u_id);
/*  @Select("select u_name from employees where u_id=#{u_id}")*/
  String GetnameByid(Integer u_id);
  boolean upDate( Employee employee);
  boolean Delete( String u_name);
}
