package com.elsys.springbeansdemo.scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* /singleton: Always returns the same instance data.
  /prototype: Creates a new instance for each request.
  /request: Creates a new instance for each HTTP request.
  /session: Maintains data within the same HTTP session.
   /application: Shares the same data across the application.
* */
@RestController
public class ScopeController {

    private final StudentService singletonBean;
    private final ObjectFactory<StudentPrototype> springPrototype;
    private final StudentSession studentSession;
    private final StudentRequest studentRequest;
    private final StudentApplication studentApplication;

    public ScopeController(StudentService singletonBean, ObjectFactory<StudentPrototype> springPrototype, StudentSession studentSession, StudentRequest studentRequest, StudentApplication studentApplication) {
        this.singletonBean = singletonBean;
        this.springPrototype = springPrototype;
        this.studentSession = studentSession;
        this.studentRequest = studentRequest;
        this.studentApplication = studentApplication;
    }

    @GetMapping("/singleton")
    public String singletonScope() {
        return singletonBean.getStudentData();
    }

    @GetMapping("/prototype")
    public String prototypeScope() {
        return springPrototype.getObject().generateReport("John Doe");
    }

    @GetMapping("/request")
    public String requestScope() {
        return studentRequest.getStudentRequest();
    }

    @GetMapping("/session")
    public String sessionScope() {
        return studentSession.getSessionInfo();
    }

    @GetMapping("/application")
    public String applicationScope() {
        return studentApplication.getApplicationData();
    }
}
