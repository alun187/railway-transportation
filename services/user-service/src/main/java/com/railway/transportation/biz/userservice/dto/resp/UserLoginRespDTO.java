package com.railway.transportation.biz.userservice.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * 用户登录返回参数
 */
@Data
@Builder
public class UserLoginRespDTO {

    /**
     * 用户 ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * Token
     */
    private String accessToken;
}
