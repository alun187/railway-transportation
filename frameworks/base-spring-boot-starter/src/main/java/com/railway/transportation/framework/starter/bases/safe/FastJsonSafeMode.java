package com.railway.transportation.framework.starter.bases.safe;

import org.springframework.beans.factory.InitializingBean;

public class FastJsonSafeMode implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("fastjson2.parser.safeMode", "true");
    }
}
