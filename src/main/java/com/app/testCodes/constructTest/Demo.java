package com.app.testCodes.constructTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Demo implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(Demo.class);
    }

    @Override
    public void run(final String... args) throws Exception {
        /*context.getBean("chutiya");
        context.getBean("chutiya");
        context.getBean("chutiya");*/
        MyBean b1 = new MyBean();
        MyBean b2 = new MyBean();
        MyBean b3 = new MyBean();

    }
}
