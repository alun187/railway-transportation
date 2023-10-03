package com.railway.transportation.framword.starter.database.handler;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.railway.transportation.framwork.starter.distributedid.toolkit.SnowflakeIdUtil;

/**
 * 自定义雪花算法生成器
 */
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        return SnowflakeIdUtil.nextId();
    }
}
