package com.railway.transportation.framework.starter.idempotent.annotation;

import com.railway.transportation.framework.starter.idempotent.enums.IdempotentSceneEnum;
import com.railway.transportation.framework.starter.idempotent.enums.IdempotentTypeEnum;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * RestAPI业务场景幂等注解
 * 暂时没有找到在 AOP 处理比较优雅的方式，暂时废弃
 */
@Deprecated
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Idempotent(scene = IdempotentSceneEnum.RESTAPI)
public @interface RestAPIIdempotent {

    /**
     * {@link Idempotent#key} 的别名
     */
    @AliasFor(annotation = Idempotent.class, attribute = "key")
    String key() default "";

    /**
     * {@link Idempotent#message} 的别名
     */
    @AliasFor(annotation = Idempotent.class, attribute = "message")
    String message() default "您操作太快，请稍后再试";

    /**
     * {@link Idempotent#type} 的别名
     */
    @AliasFor(annotation = Idempotent.class, attribute = "type")
    IdempotentTypeEnum type() default IdempotentTypeEnum.PARAM;
}
