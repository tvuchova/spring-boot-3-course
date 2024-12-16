package com.elsys.springbeansdemo.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExampleBean {
    @PostConstruct
    public void init() {
       log.info ("ExampleBean init");
    }
    @PreDestroy
    public void destroy() {
        log.info("ExampleBean destroy");
    }
}
