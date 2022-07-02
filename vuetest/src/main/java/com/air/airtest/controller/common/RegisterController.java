package com.air.airtest.controller.common;

import com.air.airtest.entity.User;
import com.air.airtest.entity.Worker;
import com.air.airtest.enums.Role;
import com.air.airtest.response.AjaxResult;
import com.air.airtest.response.ResponseTool;
import com.air.airtest.service.UserService;
import com.air.airtest.service.WorkerService;
import com.air.airtest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    public UserService userService;
    @Autowired
    WorkerService workerService;

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public AjaxResult userRegister (
            String username, String password,
            String name,String gender,
            String phone,String email,
            String address,String idcard) {
        User user = new User(phone, password, name, gender, phone, email, address, idcard);
        user.setUserId(Integer.valueOf(idcard));
        System.out.println(user);
        int result = userService.insertUser(user);
        if(result == 1) {
            return ResponseTool.success(result);
        }
        else return ResponseTool.failed("注册失败,请稍后再试");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/admin")
    public AjaxResult adminRegister(
            String username, String password,
            String name, String gender,
            String phone, String email,
            String address) {
        Worker worker = new Worker(username, password, name, gender, phone, email, address, 0);
        worker.setRole(Role.ADMIN.getValue());
        int result = workerService.insert(worker);
        if(result == 1) {
            return ResponseTool.success(result);
        }
        else return ResponseTool.failed("注册失败,请稍后再试");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/operator")
    public AjaxResult operatorRegister(String username,String password,String name,String gender,String phone,String email,String address){
        Worker worker = new Worker(username,password,name,gender,phone,email,address, 0);
        worker.setRole(Role.OPERATOR.getValue());
        int result = workerService.insert(worker);
        if(result==1){
            return ResponseTool.success(result);
        }
        else return ResponseTool.failed("注册失败,请稍后再试");
    }

}
