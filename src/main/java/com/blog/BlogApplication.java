package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages ={"com.blog.pojo"} )
//@ComponentScans(value = {@ComponentScan("com.blog.service"),@ComponentScan("com.blog.controller.admin"),@ComponentScan("com.blog.dao")})
//@ComponentScan(basePackages ={"com.blog.dao"})
public class BlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogApplication.class, args);
    }

}
