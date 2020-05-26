package com.test.demo.Service;

import com.test.demo.Entity.Employee;
import com.test.demo.mapper.DaoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertService {
  @Autowired
  private  DaoEmployees daoEmployees;
  public boolean inertservice(Employee employee){
    return daoEmployees.Insert(employee);
  }
}
