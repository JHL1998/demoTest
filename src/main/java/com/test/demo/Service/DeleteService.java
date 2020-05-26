package com.test.demo.Service;

import com.test.demo.mapper.DaoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
  @Autowired
 private DaoEmployees daoEmployees;
  public  boolean deleteService(String u_name){
    return daoEmployees.Delete(u_name);
  }
}
