package com.elsys.springbeansdemo.awareness;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyApplicationContextAware implements ApplicationContextAware {
    private final ApplicationContext applicationContext;

    public MyApplicationContextAware(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Setting application context.");
    }
    public String[] printBeans() {
        log.info("Beans: " + applicationContext.getBeanDefinitionCount());
        return applicationContext.getBeanDefinitionNames();
    }
}
