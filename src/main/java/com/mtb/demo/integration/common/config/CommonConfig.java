package com.mtb.demo.integration.common.config;

import com.mtb.demo.integration.common.domain.IntegrationApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * This is a common configuration class that is used to get the integration property domain.
 * All the other configuration classes will extend this class and override the getIntegrationPropertyDomain method.
 */
@Slf4j
public abstract class CommonConfig {

    public abstract IntegrationApi getIntegrationPropertyDomain();

    /**
     * This is a void bean that is used to log the integration property domain.
     * used only for logging purposes in debug mode.
     * @return null
     */
    @Bean
    public Void voidBean() {
        log.atDebug().log(getIntegrationPropertyDomain().toString());
        return null;
    }
}
