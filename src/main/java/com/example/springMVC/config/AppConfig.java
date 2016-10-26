package com.example.springMVC.config;

/**
 * Created by Menaka on 10/26/16.
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class AppConfig {

}
