package com.railway.transportation.biz.userservice.controller;

import com.railway.transportation.biz.userservice.dto.req.UserLoginReqDTO;
import com.railway.transportation.biz.userservice.dto.resp.UserLoginRespDTO;
import com.railway.transportation.biz.userservice.service.UserLoginService;
import com.railway.transportation.framework.starter.convention.result.Result;
import com.railway.transportation.framework.starter.web.Results;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录控制层
 */
@RestController
@RequiredArgsConstructor
public class UserLoginController {

    private final UserLoginService userLoginService;

    /**
     * 用户登录
     */
    @PostMapping("/api/user-service/v1/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Results.success(userLoginService.login(userLoginReqDTO));
    }

    /**
     * 用户退出登录
     */
    @GetMapping("api/user-service/logout")
    public Result<Void> logout(@RequestParam(required = false) String accessToken) {
        userLoginService.logout(accessToken);
        return Results.success();
    }
}
