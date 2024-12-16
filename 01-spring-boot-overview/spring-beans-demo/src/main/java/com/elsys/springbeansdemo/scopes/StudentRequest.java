package com.elsys.springbeansdemo.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Slf4j
@RequestScope
public class StudentRequest {
    public String getStudentRequest() {
        log.info("Student request data requested."+ System.identityHashCode(this));
        return "Request: Student request data.";
    }
}
