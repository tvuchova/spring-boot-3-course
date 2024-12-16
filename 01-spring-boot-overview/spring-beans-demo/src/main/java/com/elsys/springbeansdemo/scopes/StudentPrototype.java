package com.elsys.springbeansdemo.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope("prototype")
public class StudentPrototype {
    public String generateReport(String studentName) {
        log.info("Generating report card for " + studentName + "."+ System.identityHashCode(this));
        return "Prototype: Generating report card for " + studentName + "."+ System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "StudentService@" + System.identityHashCode(this);
    }
}
