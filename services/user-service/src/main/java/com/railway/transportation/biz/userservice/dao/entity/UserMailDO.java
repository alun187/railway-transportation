package com.railway.transportation.biz.userservice.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.railway.transportation.framword.starter.database.base.BaseDO;
import lombok.*;

/**
 * 用户邮箱表实体对象
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@TableName("t_user_mail")
public class UserMailDO extends BaseDO {

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
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;
}