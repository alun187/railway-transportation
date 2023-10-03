package com.railway.transportation.framword.starter.database.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.railway.transportation.framword.starter.common.enums.DelEnum;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 元数据处理器
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createDate", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateDate", Date.class, new Date());
        this.strictInsertFill(metaObject, "delFlag", Integer.class, DelEnum.NORMAL.code());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateDate", Date.class, new Date());
    }
}
