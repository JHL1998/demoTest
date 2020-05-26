package com.test.demo.Service;

import com.test.demo.mapper.DaoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetnameByidService {
  @Autowired
  private DaoEmployees daoEmployees;
  public String getnamebyid(Integer u_id){
    return daoEmployees.GetnameByid(u_id);
  }
}
