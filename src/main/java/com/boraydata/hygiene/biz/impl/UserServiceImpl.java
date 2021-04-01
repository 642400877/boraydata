package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.UserService;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.UserEntity;
import com.boraydata.hygiene.dal.mapper.UserMapper;
import com.boraydata.hygiene.dal.query.UserQuery;
import com.boraydata.hygiene.web.request.LoginRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public UserEntity findUser(LoginRequest loginRequest) throws BusinessException {
        UserQuery userQuery = new UserQuery();
        userQuery.setUsername(loginRequest.getUsername());
        return userMapper.findUserInfoByUsername(userQuery);
    }

    public boolean addUser(LoginRequest loginRequest) throws BusinessException {
        UserQuery userQuery = new UserQuery();
        BeanUtils.copyProperties(loginRequest, userQuery);
        userQuery.setRId(0);
//        userQuery.setUsername(loginRequest.getUsername());
//        userQuery.setEmail(loginRequest.getEmail());
//        userQuery.setPassword(loginRequest.getPassword());
//        userQuery.setMobile(loginRequest.getMobile());
        userQuery.setStatus(0);
        return userMapper.addUserInfo(userQuery);
    }
}
