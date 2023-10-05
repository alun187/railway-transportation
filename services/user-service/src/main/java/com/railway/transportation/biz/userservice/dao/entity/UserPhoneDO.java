package com.railway.transportation.biz.userservice.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.railway.transportation.framword.starter.database.base.BaseDO;
import lombok.*;

/**
 * 用户手机号实体对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@TableName("t_user_phone")
public class UserPhoneDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 注销时间戳
     */
    private Long deletionTime;
}
