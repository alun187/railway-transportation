package com.railway.transportation.framework.starter.idempotent.core;

import com.railway.transportation.framework.starter.idempotent.annotation.Idempotent;
import com.railway.transportation.framework.starter.idempotent.enums.IdempotentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 幂等参数包装
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public final class IdempotentParamWrapper {
    /**
     * 幂等注解
     */
    private Idempotent idempotent;

    /**
     * AOP 处理连接点
     */
    private ProceedingJoinPoint joinPoint;

    /**
     * 锁标识，{@link IdempotentTypeEnum#PARAM}
     */
    private String lockKey;
}
