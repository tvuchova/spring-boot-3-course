package com.elsys.springbeansdemo.awareness;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyBeanNameAware implements BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void printBeanName() {
        log.info("Bean name: " + beanName);
    }
}
