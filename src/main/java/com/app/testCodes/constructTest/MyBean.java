package com.app.testCodes.constructTest;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component("chutiya")
public class MyBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set, Initializing customs.");
    }

    @PostConstruct
    public void postConctruct() {
        System.out.println("After Post Construct");
    }
}
