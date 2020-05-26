package com.test.demo.Service;

import com.test.demo.Entity.Employee;
import com.test.demo.mapper.DaoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

@Service
public class getByidService {
  @Autowired
  private DaoEmployees daoEmployees;
  public Employee getbyidService(Integer u_id){
    return daoEmployees.Getbyid(u_id);
  }
}
