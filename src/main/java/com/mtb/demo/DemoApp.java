package com.mtb.demo;

import com.mtb.demo.integration.common.config.IntegrationPropertyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@EnableConfigurationProperties(IntegrationPropertyConfig.class)
@SpringBootApplication
public class DemoApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApp.class, args);
    }
}
