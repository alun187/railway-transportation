package com.railway.transportation.framework.starter.designpattern.builder;

import java.io.Serializable;

/**
 * Builder 模式抽象接口
 * @author cuidl
 * @param <T>
 */
public interface Builder<T> extends Serializable {

    /**
     * 构建方法
     * @return 构建后的对象
     */
    T builder();
}
