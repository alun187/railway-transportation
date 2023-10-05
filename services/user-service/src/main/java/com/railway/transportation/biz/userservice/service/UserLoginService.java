package com.railway.transportation.biz.userservice.service;

import com.railway.transportation.biz.userservice.dto.req.UserLoginReqDTO;
import com.railway.transportation.biz.userservice.dto.resp.UserLoginRespDTO;

/**
 * 用户登录接口
 */
public interface UserLoginService {
    /**
     * 用户登录接口
     *
     * @param requestParam 用户登录入参
     * @return 用户登录返回结果
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    void logout(String accessToken);
}
