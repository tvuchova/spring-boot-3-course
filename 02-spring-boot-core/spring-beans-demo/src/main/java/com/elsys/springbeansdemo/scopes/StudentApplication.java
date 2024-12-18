package com.elsys.springbeansdemo.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Slf4j
@Scope("application")
public class StudentApplication {
    public String getApplicationData() {
        log.info("Application data requested."+ System.identityHashCode(this));
        return "Application: Shared data for all students.";
    }
}
