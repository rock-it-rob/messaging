package com.rob.messaging.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MainConfig is the bootstrap point for spring boot.
 *
 * @author Rob Benton
 */
@SpringBootApplication
public class MainConfig
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainConfig.class, args);
    }
}
