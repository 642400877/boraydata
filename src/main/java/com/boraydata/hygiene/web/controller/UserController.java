package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.UserBusiness;
import com.boraydata.hygiene.web.request.LoginRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/v1")
public class UserController {

    @Autowired
    UserBusiness userBusiness;

    @RequestMapping("login")
    public MyResult login(@RequestBody LoginRequest loginRequest) {
        return MyResult.success(userBusiness.login(loginRequest));
    }

    @RequestMapping("register")
    public MyResult register(@RequestBody LoginRequest loginRequest) {
        return MyResult.success(userBusiness.register(loginRequest));
    }

}
