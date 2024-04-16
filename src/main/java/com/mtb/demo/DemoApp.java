package com.mtb.demo;

import com.mtb.demo.faker.FakeDataGen;
import com.mtb.demo.integration.common.config.IntegrationPropertyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@EnableConfigurationProperties(IntegrationPropertyConfig.class)
@EnableJpaAuditing
@SpringBootApplication
public class DemoApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApp.class, args);

        FakeDataGen.generateSize();
    }
}
