package com.elsys.springbeansdemo.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class StudentService {
    public String getStudentData() {
        log.info("Student data requested."+ System.identityHashCode(this));
        return "Singleton: Shared student data."+ System.identityHashCode(this);
    }

}
