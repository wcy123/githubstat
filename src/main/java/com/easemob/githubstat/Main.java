package com.easemob.githubstat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by wangchunye on 8/23/16.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println("hello world 1");
        SpringApplication.run(Main.class,args);
    }

}
