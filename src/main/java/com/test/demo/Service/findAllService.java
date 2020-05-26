package com.test.demo.Service;

import com.test.demo.Entity.Employee;
import com.test.demo.mapper.DaoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class findAllService {
  @Autowired
  private  DaoEmployees daoEmployees;
  public List<Employee> findService(){
    return daoEmployees.findAll();
  }
}
