package com.railway.transportation.biz.userservice.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.railway.transportation.biz.userservice.dao.entity.UserDO;
import com.railway.transportation.biz.userservice.dao.entity.UserMailDO;
import com.railway.transportation.biz.userservice.dao.entity.UserPhoneDO;
import com.railway.transportation.biz.userservice.dao.mapper.UserMailMapper;
import com.railway.transportation.biz.userservice.dao.mapper.UserMapper;
import com.railway.transportation.biz.userservice.dao.mapper.UserPhoneMapper;
import com.railway.transportation.biz.userservice.dto.req.UserLoginReqDTO;
import com.railway.transportation.biz.userservice.dto.resp.UserLoginRespDTO;
import com.railway.transportation.biz.userservice.service.UserLoginService;
import com.railway.transportation.framework.starter.cache.DistributedCache;
import com.railway.transportation.framework.starter.convention.exception.ClientException;
import com.railway.transportation.framework.starter.convention.exception.ServiceException;
import com.railway.transportation.starter.user.core.UserInfoDTO;
import com.railway.transportation.starter.user.toolkit.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {

    private final UserMailMapper userMailMapper;
    private final UserPhoneMapper userPhoneMapper;
    private final UserMapper userMapper;
    private final DistributedCache distributedCache;

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        String usernameOrMailOrPhone = requestParam.getUsernameOrMailOrPhone();
        boolean mailFlag = false;
        // 时间复杂度最佳 O(1)。indexOf or contains 时间复杂度为 O(n)
        for (char c : usernameOrMailOrPhone.toCharArray()) {
            if (c == '@') {
                mailFlag = true;
                break;
            }
        }
        String username;
        if (mailFlag) {
            LambdaQueryWrapper<UserMailDO> queryWrapper = Wrappers.lambdaQuery(UserMailDO.class).eq(UserMailDO::getMail, usernameOrMailOrPhone);
            username = Optional.ofNullable(userMailMapper.selectOne(queryWrapper)).map(UserMailDO::getUsername).
                    orElseThrow(() -> new ClientException("用户名/手机号/邮箱不存在"));
        } else {
            LambdaQueryWrapper<UserPhoneDO> queryWrapper = Wrappers.lambdaQuery(UserPhoneDO.class).eq(UserPhoneDO::getPhone, usernameOrMailOrPhone);
            username = Optional.ofNullable(userPhoneMapper.selectOne(queryWrapper)).map(UserPhoneDO::getUsername).
                    orElse(null);
        }
        username = Optional.ofNullable(username).orElse(requestParam.getUsernameOrMailOrPhone());
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername, username).
                eq(UserDO::getPassword, requestParam.getPassword()).select(UserDO::getId, UserDO::getUsername, UserDO::getRealName);
        UserDO userDO = userMapper.selectOne(queryWrapper);
        if (userDO != null) {
            UserInfoDTO userInfoDTO = UserInfoDTO.builder().userId(String.valueOf(userDO.getId())).username(userDO.getUsername()).realName(userDO.getRealName()).build();
            String accessToken = JWTUtil.generateAccessToken(userInfoDTO);
            UserLoginRespDTO actual = UserLoginRespDTO.builder().userId(String.valueOf(userDO.getId())).username(userDO.getUsername()).realName(userDO.getRealName()).accessToken(accessToken).build();
            distributedCache.put(accessToken, JSON.toJSONString(actual), 30, TimeUnit.MINUTES);
            return actual;
        }
        throw new ServiceException("账号不存在或密码错误");
    }

    @Override
    public void logout(String accessToken) {
        if (StrUtil.isNotBlank(accessToken)) {
            distributedCache.delete(accessToken);
        }
    }
}
