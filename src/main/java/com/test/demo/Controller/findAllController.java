package com.test.demo.Controller;

import com.test.demo.Entity.Employee;
import com.test.demo.Service.*;
import com.test.demo.mapper.DaoEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class findAllController {
  @Autowired
  private  DeleteService deleteService;
  @Autowired
  UpdateService updateService;
    @Autowired
    private DaoEmployees mapper;

  @Autowired
  GetnameByidService getnameByidService;
  @Autowired
  getByidService getbyidservice;
  @Autowired
  private findAllService find;
  @Autowired
  private InsertService insertService;



  @PostMapping("/Insert")
  public String findController(HttpServletRequest request,HttpServletResponse response){
    String u_name = request.getParameter("u_name");
    String u_pwd = request.getParameter("u_pwd");
    Employee employee = new Employee(0, u_name, u_pwd);
    boolean result = insertService.inertservice(employee);
    if (result){
      request.getSession().setAttribute("u_name",u_name);
      return "success";
    }
    request.getSession().setAttribute("error01","注册失败，请重新注册");
    return "zupage";

  }
  @RequestMapping("/ZC")
  public String ZCController(){

    return "zupage";
  }
  @PostMapping ("/login")
  public String  loginController(HttpServletRequest request, HttpServletResponse response,
                                 Model model) throws IOException, ServletException {
    String u_name = request.getParameter("u_name");
    String u_pwd = request.getParameter("u_pwd");
    if((u_name.equals(null))||u_pwd.equals(null)){
      model.addAttribute("empty1","用户名或密码为空");
      return "index";
    }
    List<Employee> employees = find.findService();
    boolean flag =true;
    for(Employee employee1:employees){
      if (u_name.equals(employee1.getU_name())){
        flag =false;
      }
    }
    if (flag){
     model.addAttribute("error2","用户名不存在，请注册");
     return "index";

    }
    for (Employee employee:employees){
      if((u_name.equals(employee.getU_name()))&&(u_pwd.equals(employee.getU_pwd()))){
        request.getSession().setAttribute("u_name",u_name);
       return "success";
      }
    }
    model.addAttribute("error","用户名或密码错误");

    return "index";

  }
  @GetMapping("/Getbyid")
  @ResponseBody
  public Employee Getbyid01(HttpServletRequest request){
    Integer u_id = Integer.parseInt(request.getParameter("u_id"));
    return getbyidservice.getbyidService(u_id);
  }
  @ResponseBody
  @GetMapping("/GetnameByID")
  public String GetNameByid(HttpServletRequest request){
    Integer u_id = Integer.parseInt(request.getParameter("u_id"));
    return getnameByidService.getnamebyid(u_id);
  }
  @ResponseBody
  @PostMapping("/update")
  public void updateController(HttpServletRequest request,HttpServletResponse response) throws IOException {
    boolean result = updateService.updateService(new Employee(null, request.getParameter("u_name"), request.getParameter("u_pwd")));
    response.setContentType("text/html;charset=utf-8");

    if (result){
      response.getWriter().write("修改信息成功");
      return;
    }
    response.getWriter().write("信息修改失败");

  }
  @ResponseBody
  @RequestMapping("/deleteController")
  public void deleteController(HttpServletRequest request,HttpServletResponse response) throws IOException {
    String u_name = request.getParameter("u_name");
    boolean result = deleteService.deleteService("u_name");
    response.setContentType("text/html;charset=utf-8");
    if (result){
      response.getWriter().write("删除用户成功！");
      return;
    }
    response.getWriter().write("删除用户失败！！");

  }

  @GetMapping("/FH")
  public String FH(){
    return "index";
  }
  @RequestMapping("/getbyid")
  public String Getbyid(){
    return "Getbyid";
  }
  @RequestMapping("/getbyname")
  public String Getnamebyid(){
    return "GetnameById";

  }
  @RequestMapping("/XG")
  public String ZF(){
    return "update";
  }
  @RequestMapping("/ZX")
  public String ZX(){
    return "delete";
  }




}
