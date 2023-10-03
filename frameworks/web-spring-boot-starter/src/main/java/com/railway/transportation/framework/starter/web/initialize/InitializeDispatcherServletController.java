package com.railway.transportation.framework.starter.web.initialize;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import static com.railway.transportation.framework.starter.web.config.WebAutoConfiguration.INITIALIZE_PATH;

/**
 * 初始化 {@link DispatcherServlet}
 */
@Slf4j
@RestController
public final class InitializeDispatcherServletController {

    @GetMapping(INITIALIZE_PATH)
    public void initializeDispatcherServlet() {
        log.info("Initialized the dispatcherServlet to improve the first response time of the interface...");
    }
}
