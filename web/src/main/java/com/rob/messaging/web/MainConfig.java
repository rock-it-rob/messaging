package com.rob.messaging.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;

/**
 * MainConfig is the bootstrap point for spring boot.
 * @author Rob Benton
 */
@SpringBootApplication(
    exclude = {
        //EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class

    }
)
public class MainConfig
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainConfig.class, args);
    }
}
