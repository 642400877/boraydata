package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.UserService;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.common.util.JwtUtil;
import com.boraydata.hygiene.common.util.MD5CommonEntity;
import com.boraydata.hygiene.common.util.MD5Util;
import com.boraydata.hygiene.common.util.StringUtil;
import com.boraydata.hygiene.dal.entity.UserEntity;
import com.boraydata.hygiene.web.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserBusiness {

    @Autowired
    UserService userService;

    public UserEntity login(LoginRequest loginRequest) throws Exception {
        UserEntity userEntity = userService.findUser(loginRequest);
        if (!checkLogin(loginRequest, userEntity)) {
            throw new BusinessException("用户名不存在或者密码不正确");
        }
        userEntity.setToken(JwtUtil.createJWT(String.valueOf(userEntity.getId()), userEntity.getUsername()));
        userEntity.setPassword("");
        userEntity.setSalt("");
        return userEntity;
    }

    public String publicKey() {


        return null;
    }

    public UserEntity register(LoginRequest loginRequest) throws Exception {
        checkRegisterParam(loginRequest);
        UserEntity userEntity = userService.findUser(loginRequest);
        if (!Objects.isNull(userEntity)) {
            throw new BusinessException("用户名重复");
        }
        userEntity = new UserEntity();
        MD5CommonEntity md5CommonEntity = MD5Util.md5(loginRequest.getPassword());
        loginRequest.setPassword(md5CommonEntity.getMd5());
        loginRequest.setSalt(md5CommonEntity.getSalt());
        userService.addUser(loginRequest);
        userEntity.setToken(JwtUtil.createJWT(String.valueOf(userEntity.getId()), userEntity.getUsername()));
        return userEntity;
    }

    private boolean checkLogin(LoginRequest loginRequest, UserEntity userEntity) throws Exception {
        if (Objects.isNull(userEntity)) {
            return false;
        }
        if (!MD5Util.verify(loginRequest.getPassword(), userEntity.getSalt(), userEntity.getPassword())) {
            return false;
        }
        return true;
    }

    private boolean checkRegisterParam(LoginRequest loginRequest) {
        if (!Objects.isNull(userService.findUser(loginRequest))) {
            throw new BusinessException("用户名已存在");
        }
        if (loginRequest.getUsername().length() > 16) {
            throw new BusinessException("用户名不可以超过16个字符");
        }
        if (StringUtil.isNullOrBlank(loginRequest.getUsername())) {
            throw new BusinessException("用户名不能为空");
        }
        if (loginRequest.getPassword().length() > 16) {
            throw new BusinessException("密码不可以超过16个字符");
        }
        if (StringUtil.isNullOrBlank(loginRequest.getPassword())) {
            throw new BusinessException("密码不能为空");
        }
        if (!StringUtil.isNullOrBlank(loginRequest.getMobile()) && loginRequest.getMobile().length() != 11) {
            throw new BusinessException("手机号码填写不正确");
        }
        if (!StringUtil.isNullOrBlank(loginRequest.getEmail()) && loginRequest.getEmail().length() > 50) {
            throw new BusinessException("邮箱填写不正确");
        }
        return true;
    }

}
