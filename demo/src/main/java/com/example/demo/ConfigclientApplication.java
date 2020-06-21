package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RefreshScope
@RestController
public class ConfigclientApplication {
    @Value("${welcome.message}")
    String welcomeText;
    private static final Logger LOG = Logger.getLogger(ConfigclientApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(ConfigclientApplication.class, args);
    }
    @RequestMapping(value = "/")
    public String welcomeText() {
        LOG.log(Level.INFO, welcomeText);
        return welcomeText;

    }
}