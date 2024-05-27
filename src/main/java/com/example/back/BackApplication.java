package com.example.back;

import com.example.back.example.Backpressure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BackApplication.class, args);

        Backpressure backpressure = context.getBean(Backpressure.class);
        backpressure.backpressure_error();
    }

}
