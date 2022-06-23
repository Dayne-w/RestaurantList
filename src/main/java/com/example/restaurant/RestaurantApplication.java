package com.example.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@SpringBootApplication // 프로그램 다 만들었을 땐, @EnableWebMVC 지워야 정상작동한다..
public class RestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

}
