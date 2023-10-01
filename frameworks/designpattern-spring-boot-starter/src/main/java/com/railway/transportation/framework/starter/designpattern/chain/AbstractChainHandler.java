package com.railway.transportation.framework.starter.designpattern.chain;

import org.springframework.core.Ordered;

/**
 * 抽象业务责任链组件
 */
public interface AbstractChainHandler<T> extends Ordered {

    /**
     * 执行责任链逻辑
     * @param resultParam 入参
     */
    void handler(T resultParam);

    /**
     * @return 责任链组件标志
     */
    String mark();
}
