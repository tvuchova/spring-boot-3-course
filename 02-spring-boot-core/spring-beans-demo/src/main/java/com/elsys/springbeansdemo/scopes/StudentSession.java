package com.elsys.springbeansdemo.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@Slf4j
@SessionScope
public class StudentSession {
    public String getSessionInfo() {
        log.info("Session data requested."+ System.identityHashCode(this));
        return "Session: Data for the logged-in student's session."+ System.identityHashCode(this);
    }
}
