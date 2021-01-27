package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.UserEntity;
import com.boraydata.hygiene.web.request.LoginRequest;

public interface UserService {

    UserEntity findUser(LoginRequest loginRequest);

    boolean addUser(LoginRequest loginRequest);

}
