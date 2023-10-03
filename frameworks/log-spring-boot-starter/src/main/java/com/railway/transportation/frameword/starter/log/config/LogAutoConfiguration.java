package com.railway.transportation.frameword.starter.log.config;

import com.railway.transportation.frameword.starter.log.annotation.ILog;
import com.railway.transportation.frameword.starter.log.core.ILogPrintAspect;
import org.springframework.context.annotation.Bean;

/**
 * 日志自动装配
 */
public class LogAutoConfiguration {

    /**
     * {@link ILog} 日志打印 AOP 切面
     */
    @Bean
    public ILogPrintAspect iLogPrintAspect() {
        return new ILogPrintAspect();
    }
}
